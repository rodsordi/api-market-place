package br.com.alura.marketplace.iandt.setup;

import com.redis.testcontainers.RedisContainer;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.utility.DockerImageName;

public interface RedisSetup {

    RedisContainer REDIS = new RedisContainer(DockerImageName.parse("redis:6.2.6"));

    @DynamicPropertySource
    static void localstackDynamicPropertySource(DynamicPropertyRegistry registry) {
        registry.add("spring.data.redis.host", REDIS::getHost);
        registry.add("spring.data.redis.port", REDIS::getRedisPort);
    }

    @BeforeAll
    static void postgresBeforeAll() {
        REDIS.start();
    }
}
