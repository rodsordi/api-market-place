package br.com.alura.marketplace.iandt;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;

public interface WiremockSetup {

    WireMockServer wireMockServer = new WireMockServer(9090);

    @BeforeAll
    static void wiremockBeforeAll() {
        wireMockServer.start();
        configureFor("localhost", wireMockServer.port());
    }

    @AfterAll
    static void wiremockAfterAll() {
        wireMockServer.stop();
    }

    @AfterEach
    default void wiremockAfterEach() {
        wireMockServer.resetAll();
    }
}
