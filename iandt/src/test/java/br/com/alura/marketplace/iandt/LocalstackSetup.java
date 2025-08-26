package br.com.alura.marketplace.iandt;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.junit.jupiter.Container;

import static org.testcontainers.containers.localstack.LocalStackContainer.Service.S3;
import static org.testcontainers.utility.DockerImageName.parse;

public interface LocalstackSetup {

    @Container
    LocalStackContainer localstack = new LocalStackContainer(parse("localstack/localstack:3.5.0"))
            .withServices(S3);

    @DynamicPropertySource
    static void localstackDynamicPropertySource(DynamicPropertyRegistry registry) {
        // AWS
        registry.add("spring.cloud.aws.region.static", localstack::getRegion);
        registry.add("spring.cloud.aws.credentials.access-key", localstack::getAccessKey);
        registry.add("spring.cloud.aws.credentials.secret-key", localstack::getSecretKey);
        // S3
        registry.add("spring.cloud.aws.s3.endpoint", () -> localstack.getEndpointOverride(S3).toString());
    }

    @BeforeAll
    static void localstackBeforeAll() {
        localstack.start();
    }

    @AfterAll
    static void localstackAfterAll() {
        localstack.stop();
    }
}
