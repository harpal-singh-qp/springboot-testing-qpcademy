//package com.example.training.springboottesting.app.extentions;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.extension.AfterAllCallback;
//import org.junit.jupiter.api.extension.BeforeAllCallback;
//import org.junit.jupiter.api.extension.Extension;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.testcontainers.containers.MySQLContainer;
//import org.testcontainers.junit.jupiter.Testcontainers;
//
///**
// * CreatedBy Harpal Singh at 12/5/21
// */
//
//
//@Slf4j
//@Testcontainers
//public class MySqlDockerContainerExtentions implements Extension, BeforeAllCallback, AfterAllCallback {
//
//    final static MySQLContainer mySQLContainer =
//            new MySQLContainer("mysql:5.7.34");
//
//
//    @DynamicPropertySource
//    static void postgresqlProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
//        registry.add("spring.datasource.username", mySQLContainer::getUsername);
//        registry.add("spring.datasource.password", mySQLContainer::getPassword);
//    }
//
//
//    @Override
//    public void beforeAll(ExtensionContext context) {
//
//        log.info("###########################################START######################################");
//        mySQLContainer.start();
//        log.info("###########################################DONE START######################################");
//    }
//
//    @Override
//    public void afterAll(ExtensionContext context) throws Exception {
//     //   mySQLContainer.stop();
//    }
//
//    String getHost() {
//        log.info("HOST"+ mySQLContainer.getHost());
//        return mySQLContainer.getHost();
//    }
//
//    Integer getPort() {
//        return mySQLContainer.getFirstMappedPort();
//    }
//
//    String getContainerID() {
//        log.info("Container "+ mySQLContainer.getContainerId());
//        return mySQLContainer.getContainerId();
//    }
//}