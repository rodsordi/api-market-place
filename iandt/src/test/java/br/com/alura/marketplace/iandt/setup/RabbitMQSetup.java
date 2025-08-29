package br.com.alura.marketplace.iandt.setup;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.utility.DockerImageName;

public interface RabbitMQSetup {

    RabbitMQContainer RABBIT_MQ = new RabbitMQContainer(DockerImageName.parse("rabbitmq:3.7.25-management-alpine"));

    @DynamicPropertySource
    static void postgresDynamicPropertySource(DynamicPropertyRegistry registry) {
        registry.add("spring.rabbitmq.host", RABBIT_MQ::getHost);
        registry.add("spring.rabbitmq.port", RABBIT_MQ::getAmqpPort);
        registry.add("spring.rabbitmq.username", RABBIT_MQ::getAdminUsername);
        registry.add("spring.rabbitmq.password", RABBIT_MQ::getAdminPassword);
    }

    @BeforeAll
    static void postgresBeforeAll() {
        RABBIT_MQ.start();
    }
}
