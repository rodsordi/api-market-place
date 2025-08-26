package br.com.alura.marketplace.iandt;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

public interface PostgresSetup {

    @Container
    PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest");

    @DynamicPropertySource
    static void postgresDynamicPropertySource(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.driverClassName", postgres::getDriverClassName);
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @BeforeAll
    static void postgresBeforeAll() {
        postgres.start();
    }

    @AfterAll
    static void postgresAfterAll() {
        postgres.stop();
    }
}
