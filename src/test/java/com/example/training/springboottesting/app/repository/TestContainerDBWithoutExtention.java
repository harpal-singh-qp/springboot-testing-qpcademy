package com.example.training.springboottesting.app.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * CreatedBy Harpal Singh at 12/13/21
 */

@Testcontainers
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataJpaTest
public class TestContainerDBWithoutExtention {

    @Container
    MySQLContainer mySQLContainer = new MySQLContainer();



    @BeforeAll
    @Test
    void start(){
        mySQLContainer.start();
    }
    @Test
    void test(){
        Assertions.assertThat(mySQLContainer.isRunning());
    }


    @AfterAll
    @Test
    void afterall(){
        mySQLContainer.stop();
    }


}
