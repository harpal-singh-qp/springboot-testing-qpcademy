package com.example.training.springboottesting.junit5;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;

/**
 * @author Harpal Singh 30/11/21
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestLifeCycle {

    @BeforeAll
    void beforeAll() {
        System.out.println("beforeAll");
    }

    @BeforeEach
    void beforEach() {
        System.out.println("BeforeEach");
    }



    @Test
    void test() {
        System.out.println("test");
    }

    @Test
    void test1() {
        System.out.println("test1");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }

    @AfterAll
    void afterAll() {
        System.out.println("afterAll");

    }

   }

