package com.example.training.springboottesting.app.repository;

import com.example.training.springboottesting.app.entity.User;
import com.example.training.springboottesting.app.extentions.MySqlDockerContainerExtentions;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.OrderWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

/**
 * CreatedBy Harpal Singh at 12/8/21
 */

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(MySqlDockerContainerExtentions.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class TestDbLayerDockerContainer {

    @Autowired
    DataSource dataSource;

    @Autowired
    EntityManager entityManager;

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    UserRepository userRepository;


    @Test
    @Order(1)
    void test() {
        Assertions.assertNotNull(dataSource);
        Assertions.assertNotNull(entityManager);
        Assertions.assertNotNull(testEntityManager);
        Assertions.assertNotNull(userRepository);
    }


    @Test
    @Order(2)
    @Rollback(false)
    void testSaveUser() {
        User user = new User().setPhoneNumber("88674543222")
                .setLastName("Singh")
                .setFirstName("Harpal")
                .setEmailAddress("Harpal.rtu@gmail.com"+new Random().nextInt())
                .setCreatedAt(new Date())
                .setUpdatedAt(new Date())
                .setAge(32);
        userRepository.save(user);
        log.error("Failed to save User "+user.getEmailAddress() + " ");
        Assertions.assertNotEquals(0, userRepository.findAll().size());

    }


    @Test
    @Order(3)
    @Rollback(false)
    void testSize(){
        System.out.println("##USER REPO SIZE##");
        userRepository.findAll().stream().forEach(user->log.info("EMAIL_ADDRESS########"+user.getEmailAddress()));
        log.info("@#########"+userRepository.findAll().size());
     //   Assertions.assertNotEquals(0,userRepository.findAll().size());

    }

}
