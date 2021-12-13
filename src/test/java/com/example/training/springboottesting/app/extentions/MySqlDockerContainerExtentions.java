package com.example.training.springboottesting.app.extentions;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * CreatedBy Harpal Singh at 12/5/21
 */
@Slf4j
@Testcontainers
public class MySqlDockerContainerExtentions implements Extension, BeforeAllCallback, AfterAllCallback {

    static MySQLContainer mySQLContainer =
            (MySQLContainer) new MySQLContainer("mysql:5.7.34")
                    .withInitScript("sql/ddl/survey-app.sql")
                    .withReuse(true);
    ;


    @Override
    public void beforeAll(ExtensionContext context) {
        if (!mySQLContainer.isRunning()) {
            mySQLContainer.start();
            String jdbcUrl = String.format(mySQLContainer.getJdbcUrl());
            System.setProperty("spring.datasource.url", mySQLContainer.getJdbcUrl());
            System.setProperty("spring.datasource.username", mySQLContainer.getUsername());
            System.setProperty("spring.datasource.password", mySQLContainer.getPassword());
        }
    }


    @Override
    public void afterAll(ExtensionContext context) throws Exception {
    }

}