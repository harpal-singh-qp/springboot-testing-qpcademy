package com.example.training.springboottesting.app.extentions;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import static com.example.training.springboottesting.app.extentions.MySqlDockerContainerExtentions.mySQLContainer;

/**
 * CreatedBy Harpal Singh at 12/5/21
 */


@Slf4j
@Testcontainers
public class RabbitMqDockerContainerExtentions implements Extension, BeforeAllCallback, AfterAllCallback {

    final static RabbitMQContainer rabbitMQContainer =
            new RabbitMQContainer("rabbitmq:3.7-management").withReuse(true).withExposedPorts(5672)
                    .withVhost("/")
                    .withUser("admin", "admin")
                    .withPermission("/", "admin", ".*", ".*", ".*");;


    @DynamicPropertySource
    static void postgresqlProperties(DynamicPropertyRegistry registry) {

        Integer mappedPort = rabbitMQContainer.getMappedPort(5672);
        registry.add("spring.rabbitmq.host", rabbitMQContainer::getHost);
        registry.add(" spring.rabbitmq.port", ()->mappedPort);
        registry.add("spring.rabbitmq.username", rabbitMQContainer::getAdminUsername);
        registry.add("spring.rabbitmq.password", rabbitMQContainer::getAdminPassword);
    }


    @Override
    public void beforeAll(ExtensionContext context) {

        log.info("###########################################RabbitMQSTART######################################");
        rabbitMQContainer.start();
        log.info("###########################################DONE START######################################");
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
    }

    String getHost() {
        log.info(" rabbitMQContainer HOST"+ rabbitMQContainer.getHost());
        return rabbitMQContainer.getHost();
    }

    Integer getPort() {
        return rabbitMQContainer.getFirstMappedPort();
    }

    String getContainerID() {
        log.info("rabbitMQContainer Container "+ rabbitMQContainer.getContainerId());
        return rabbitMQContainer.getContainerId();
    }
}