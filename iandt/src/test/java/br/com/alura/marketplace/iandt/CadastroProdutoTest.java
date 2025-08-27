package br.com.alura.marketplace.iandt;

import br.com.alura.marketplace.application.Application;
import br.com.alura.marketplace.domain.repository.ProdutoRepository;
import br.com.alura.marketplace.domain.usecase.CadastroProdutoUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.s3.S3Template;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

import static br.com.alura.marketplace.application.v1.dto.ProdutoDtoFactory.criarProdutoDtoRequest;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.petstore.model.factory.PetDtoFactory.criarPetDto;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ContextConfiguration(classes = Application.class)
@Testcontainers
class CadastroProdutoTest implements PostgresSetup, LocalstackSetup, WiremockSetup, RabbitMQSetup {

    @LocalServerPort
    Integer port;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    S3Template s3Template;

    @Autowired
    ProdutoRepository produtoRepository;

    @Value("${aws.s3.bucket.name}")
    String bucketName;

    @BeforeEach
    void beforeEach() {
        RestAssured.baseURI = String.format("http://localhost:%s/api", port);

        if (!s3Template.bucketExists(bucketName))
            s3Template.createBucket(bucketName);
    }

    @AfterEach
    void afterEach() {
        produtoRepository.deleteAll();
    }

    @DisplayName("Quando criar um produto")
    @Nested
    class CriarProduto {

        @DisplayName("Então deve executar com sucesso")
        @Nested
        class Sucesso {

            @BeforeEach
            void beforeEach() throws JsonProcessingException {
                var petDto = criarPetDto()
                        .comTodosOsCampos();
                wireMockServer.stubFor(post("/petstore/pet")
                        .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(objectMapper.writeValueAsString(petDto))));
            }

            @DisplayName("Dado um produto com todos os campos")
            @Test
            void teste1() throws JsonProcessingException {
                // Dado
                var produto = criarProdutoDtoRequest()
                        .comTodosOsCampos();
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
