package com.example.training.springboottesting.app.extentions;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * CreatedBy Harpal Singh at 12/5/21
 */
@Slf4j
@Testcontainers
public class RabbitMqDockerContainerExtentions implements TestInstancePostProcessor {

    final static RabbitMQContainer rabbitMQContainer =
            new RabbitMQContainer("rabbitmq:3.7-management")
                    .withExposedPorts(5672,15672).withReuse(true);;



    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        log.info("################################## [RabbitMQSTART] #####################################");
        rabbitMQContainer.start();
        System.setProperty("spring.rabbitmq.host",rabbitMQContainer.getHost());
        System.setProperty("spring.rabbitmq.port",rabbitMQContainer.getMappedPort(5672).toString());
        log.info("################################## [DONE START] ######################################");
    }
}