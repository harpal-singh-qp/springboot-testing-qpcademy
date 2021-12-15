package com.example.training.springboottesting.app.repository;

import com.example.training.springboottesting.app.dto.UserRankDto;
import com.example.training.springboottesting.app.entity.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

/**
 * CreatedBy Harpal Singh at 12/8/21
 */

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestDbLayerInMemoryIntegration {


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
    void createUser() {
        User user = new User().setPhoneNumber("88674543222")
                .setLastName("Singh")
                .setFirstName("Harpal")
                .setEmailAddress("Harpal.rtu@gmail.com")
                .setCreatedAt(new Date())
                .setUpdatedAt(new Date())
                .setAge(32);
        userRepository.save(user);
        Assertions.assertNotEquals(0, userRepository.findAll().size());

    }


    @Test
    @Order(3)
    void updateUser(){
        Assertions.assertNotEquals(0,userRepository.findAll().size());

    }


    @Test
    @Disabled
    //Can't execute this with H2 since its native query
    void testYoungest(){
        List<UserRankDto> youngest = userRepository.findYoungest();
        System.out.println("Find yougest"+youngest);
    }
}
