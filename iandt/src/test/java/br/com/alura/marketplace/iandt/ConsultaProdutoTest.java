package br.com.alura.marketplace.iandt;

import br.com.alura.marketplace.application.Application;
import br.com.alura.marketplace.domain.repository.ProdutoRepository;
import br.com.alura.marketplace.iandt.setup.LocalStackSetup;
import br.com.alura.marketplace.iandt.setup.PostgresSetup;
import br.com.alura.marketplace.iandt.setup.RedisSetup;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

import static br.com.alura.marketplace.domain.entity.factory.ProdutoFactory.criarProduto;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ContextConfiguration(classes = Application.class)
@Testcontainers
class ConsultaProdutoTest implements PostgresSetup, LocalStackSetup, RedisSetup {

    @LocalServerPort
    Integer port;

    @Autowired
    ProdutoRepository produtoRepository;

    @BeforeEach
    void beforeEach() {
        RestAssured.baseURI = String.format("http://localhost:%s/api", port);
    }

    @AfterEach
    void afterEach() {
        produtoRepository.deleteAll();
    }

    @DisplayName("Quando consultar um produto")
    @Nested
    class ConsultarProduto {

        @DisplayName("Então deve executar com sucesso")
        @Nested
        class Sucesso {

            @DisplayName("Dado um produto com todos os campos salvo na base")
            @Test
            void teste1() {
                // Dado
                var produto = criarProduto()
                        .comTodosOsCamposExcetoDB();
                produtoRepository.save(produto);
                // Quando
                var response = given()
                        .log().all()
                        .get("/v1/produtos/{id}", produto.getProdutoId())
                        .then()
                        .log().all()
                        .extract()
                        .response();
                // Então
                assertThat(response.statusCode())
                        .isEqualTo(200);
            }

            @DisplayName("Dado uma segunda consulta do mesmo produto")
            @Test
            void teste2() {
                // Dado
                var produto = criarProduto()
                        .comTodosOsCamposExcetoDB();
                produtoRepository.save(produto);
                for (var i = 0; i < 2; i++) {
                    // Quando
                    var response = given()
                            .log().all()
                            .get("/v1/produtos/{id}", produto.getProdutoId())
                            .then()
                            .log().all()
                            .extract()
                            .response();
                    // Então
                    assertThat(response.statusCode())
                            .isEqualTo(200);
                    produtoRepository.deleteAll();
                }
            }
        }
    }
}
