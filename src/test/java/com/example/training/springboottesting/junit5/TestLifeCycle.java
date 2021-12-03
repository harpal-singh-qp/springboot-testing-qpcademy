package com.example.training.springboottesting.junit5;

import com.example.training.springboottesting.ApacheLoggerExtension;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Junit 5  Extenstion
 * --> Test Life Cycle Callbacks--TestSummaryExtention-- docker start , docker stop
 * --> CousreService Integration  (Sql stubb)
 *
 * --> Test Instance Post Processing --LoggingExtenstion
 * --> Conditional Test Execution ( integration , slow, fast , dev , CI , QA  , Weekened, Weekdays)
 *
 * --> Parameter Resoultion --> Everytest Injection  void testCourseCreateoin( int random) {
 * --> Exeception Handling
 *
 *
 *
 * @author Harpal Singh 30/11/21
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(ApacheLoggerExtension.class)
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

