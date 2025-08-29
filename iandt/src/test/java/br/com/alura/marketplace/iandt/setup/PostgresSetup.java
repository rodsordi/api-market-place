package br.com.alura.marketplace.iandt.setup;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

public interface PostgresSetup {

    PostgreSQLContainer<?> POSTGRES = new PostgreSQLContainer<>("postgres:latest");

    @DynamicPropertySource
    static void postgresDynamicPropertySource(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.driverClassName", POSTGRES::getDriverClassName);
        registry.add("spring.datasource.url", POSTGRES::getJdbcUrl);
        registry.add("spring.datasource.username", POSTGRES::getUsername);
        registry.add("spring.datasource.password", POSTGRES::getPassword);
    }

    @BeforeAll
    static void postgresBeforeAll() {
        POSTGRES.start();
    }
}
