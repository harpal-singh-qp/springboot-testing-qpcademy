//package com.example.training.springboottesting.app.controller;
//
//import com.example.training.springboottesting.app.extentions.MySqlDockerContainerExtentions;
//import com.example.training.springboottesting.app.extentions.RabbitMqDockerContainerExtentions;
//import com.example.training.springboottesting.app.service.SurveyRenderer;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.api.extension.RegisterExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.testcontainers.containers.MySQLContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//
///**
// * CreatedBy Harpal Singh at 12/5/21
// */
//
//@SpringBootTest
//public class SurveyControllerIntegerationTest {
//
//    @Autowired
//    SurveyRenderer surveyRenderer;
//
//    @Autowired
//    SurveyController surveyController;
//
//    @RegisterExtension
//    static MySqlDockerContainerExtentions mysqlContainer = new MySqlDockerContainerExtentions();
//
//    @RegisterExtension
//    static RabbitMqDockerContainerExtentions rabbitMqContainer = new RabbitMqDockerContainerExtentions();
//
//    @Test
//    void createSurveyTest() throws InterruptedException {
//        Assertions.assertNotNull(mysqlContainer);
//        Assertions.assertNotNull(rabbitMqContainer);
//
//     }
//
//}
