package br.com.alura.marketplace.iandt.setup;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;

public interface WiremockSetup {

    WireMockServer WIRE_MOCK = new WireMockServer(9090);

    @BeforeAll
    static void wiremockBeforeAll() {
        WIRE_MOCK.start();
        configureFor("localhost", WIRE_MOCK.port());
    }

    @AfterAll
    static void wiremockAfterAll() {
        WIRE_MOCK.stop();
    }

    @AfterEach
    default void wiremockAfterEach() {
        WIRE_MOCK.resetAll();
    }
}
