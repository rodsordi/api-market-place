package br.com.alura.marketplace.iandt;

import com.redis.testcontainers.RedisContainer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

public interface RedisSetup {

    @Container
    RedisContainer redis = new RedisContainer(DockerImageName.parse("redis:6.2.6"));

    @DynamicPropertySource
    static void localstackDynamicPropertySource(DynamicPropertyRegistry registry) {
        registry.add("spring.data.redis.host", redis::getHost);
        registry.add("spring.data.redis.port", redis::getRedisPort);
    }

    @BeforeAll
    static void postgresBeforeAll() {
        redis.start();
    }

    @AfterAll
    static void postgresAfterAll() {
        redis.stop();
    }
}
