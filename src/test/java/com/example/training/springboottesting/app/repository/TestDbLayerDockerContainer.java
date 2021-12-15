package com.example.training.springboottesting.app.repository;

import com.example.training.springboottesting.app.dto.UserRankDto;
import com.example.training.springboottesting.app.entity.User;
import com.example.training.springboottesting.app.extentions.MySqlDockerContainerExtentions;
import com.example.training.springboottesting.app.extentions.UserCreatorExtention;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.List;

/**
 * CreatedBy Harpal Singh at 12/8/21
 */

@DataJpaTest
@Testcontainers
@ExtendWith({MySqlDockerContainerExtentions.class , UserCreatorExtention.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
    void createUser(List<User> userList) {
        userList.forEach(user->userRepository.save(user));
        Assertions.assertNotEquals(0, userRepository.findAll().size());
    }


    @Test
    @Order(3)
    void checKSize(){
        Assertions.assertNotEquals(2,userRepository.findAll().size());

    }


    @Test
    @Order(4)
    void testYoungest(){
        List<UserRankDto> youngest = userRepository.findYoungest();
        System.out.println("Find yougest"+youngest);
    }

    @Test
    @AfterAll
    void cleanUp(){
        userRepository.deleteAll();
    }
}
