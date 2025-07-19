package br.com.alura.marketplace.iandt;

import br.com.alura.marketplace.application.Application;
import br.com.alura.marketplace.domain.repository.ProdutoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import io.awspring.cloud.s3.S3Template;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static br.com.alura.marketplace.application.v1.dto.ProdutoDtoFactory.criarProdutoDtoRequest;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.testcontainers.containers.localstack.LocalStackContainer.Service.S3;
import static org.testcontainers.utility.DockerImageName.parse;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ContextConfiguration(classes = Application.class)
@Testcontainers
class ConsultarProdutoTest {

    @Container
    static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest");

    @Container
    static final LocalStackContainer localStack = new LocalStackContainer(parse("localstack/localstack:3.5.0"))
            .withServices(S3);

    static final WireMockServer wireMockServer = new WireMockServer(9090);

    @DynamicPropertySource
    static void dynamicPropertySource(DynamicPropertyRegistry registry) {
        // PostgreSQL
        registry.add("spring.datasource.driverClassName", postgres::getDriverClassName);
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
        // AWS
        registry.add("spring.cloud.aws.region.static", localStack::getRegion);
        registry.add("spring.cloud.aws.credentials.access-key", localStack::getAccessKey);
        registry.add("spring.cloud.aws.credentials.secret-key", localStack::getSecretKey);
        // S3
        registry.add("spring.cloud.aws.s3.endpoint", () -> localStack.getEndpointOverride(S3).toString());
    }

    @BeforeAll
    static void beforeAll() {
        postgres.start();
        localStack.start();
        wireMockServer.start();
        configureFor("localhost", wireMockServer.port());
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
        localStack.stop();
        wireMockServer.stop();
    }

    @LocalServerPort
    Integer port;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    S3Template s3Template;

    @Autowired
    ProdutoRepository produtoRepository;

    @BeforeEach
    void beforeEach() {
        baseURI = String.format("http://localhost:%s/api", port);

        if (!s3Template.bucketExists("marketplace"))
            s3Template.createBucket("marketplace");
    }

    @AfterEach
    void afterEach() {
        wireMockServer.resetAll();

        produtoRepository.deleteAll();
    }

    @DisplayName("Quando criar um produto")
    @Nested
    class CriarProduto {

        @DisplayName("Então deve executar com sucesso")
        @Nested
        class Sucesso {

            @DisplayName("Dado um produto com todos os campos")
            @Test
            void teste1() throws JsonProcessingException {
                // Dado
                var produto = criarProdutoDtoRequest().comTodosOsCampos();
                // Quando
                var response = given()
                        .log().all()
                        .header("Correlation-Id", "ff81d6d4-cb83-4877-bdfd-c6a80522cf42")
                        .contentType(JSON)
                        .body(objectMapper.writeValueAsString(produto))
                        .post("/v1/produtos")
                        .then()
                        .log().all()
                        .extract()
                        .response();
                // Então
                assertThat(response.statusCode())
                        .isEqualTo(201);
            }
        }
    }
}
