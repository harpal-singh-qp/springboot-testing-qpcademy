package com.example.training.springboottesting.app.extentions;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.*;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * CreatedBy Harpal Singh at 12/5/21
 */
@Slf4j
@Testcontainers
public class MySqlDockerContainerExtentions implements TestInstancePostProcessor {

    static MySQLContainer mySQLContainer =
            (MySQLContainer) new MySQLContainer("mysql:5.7.34")
                    .withInitScript("sql/ddl/survey-app.sql")
                    .withReuse(true);
    ;


//    @Override
//    public void beforeAll(ExtensionContext context) {
//
//
//    }
//
//
//    @Override
//    public void afterAll(ExtensionContext context) throws Exception {
//    }

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        mySQLContainer.start();
        String jdbcUrl = String.format(mySQLContainer.getJdbcUrl());
        System.setProperty("spring.datasource.url", mySQLContainer.getJdbcUrl());
        System.setProperty("spring.datasource.username", mySQLContainer.getUsername());
        System.setProperty("spring.datasource.password", mySQLContainer.getPassword());
    }
}