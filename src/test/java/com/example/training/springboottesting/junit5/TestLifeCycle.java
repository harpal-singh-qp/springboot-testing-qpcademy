package com.example.training.springboottesting.junit5;

import com.example.training.springboottesting.LoggerExtension;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Junit 5  Extenstion
 * --> Test Life Cycle Callbacks
 * --> Test Instance Post Processing
 * --> Conditional Test Execution ( integration , slow, fast , dev , CI , QA  , Weekened, Weekdays)
 * --> Parameter Resoultion --> Everytest Injection  void testCourseCreateoin( int random) {
 * --> Exeception Handling
 *
 * @author Harpal Singh 30/11/21
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(LoggerExtension.class)
public class TestLifeCycle {

    Logger logger;

    public void setLogger(Logger logger){
        this.logger = logger;
    }


    @BeforeAll
    void beforeAll() {
        logger.info("beforeAll");

    }

    @BeforeEach
    void beforEach() {
        logger.info("BeforeEach");
    }



    @Test
    void test() {
        logger.info("test");
    }

    @Test
    void test1() {
        logger.info("test1");
    }

    @AfterEach
    void afterEach() {
        logger.info("afterEach");
    }

    @AfterAll
    void afterAll() {
        logger.info("afterAll");

    }

   }

