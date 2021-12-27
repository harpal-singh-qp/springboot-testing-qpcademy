package com.example.training.springboottesting.app;

import com.example.training.springboottesting.app.controller.SurveyController;
import com.example.training.springboottesting.app.controller.UserController;
import com.example.training.springboottesting.app.dto.SurveyDTO;
import com.example.training.springboottesting.app.dto.UserDTO;
import com.example.training.springboottesting.app.dto.UserRequest;
import com.example.training.springboottesting.app.extentions.MySqlDockerContainerExtentions;
import com.example.training.springboottesting.app.extentions.RabbitMqDockerContainerExtentions;
import com.example.training.springboottesting.app.repository.SurveyRepository;
import com.example.training.springboottesting.app.repository.UserRepository;
import com.example.training.springboottesting.app.request.SurveyRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

/**
 * CreatedBy Harpal Singh at 12/23/21
 */
@ExtendWith({MySqlDockerContainerExtentions.class, RabbitMqDockerContainerExtentions.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IntegrationTestWithDocker {

    @Autowired
    UserController userController;

    @Autowired
    SurveyController surveyController;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    UserRepository userRepo;

    @Autowired
    SurveyRepository surveyRepository;

    //Create A User
    //Create a Survey
    // rabbit mq
    //Check if survey exists
    @Commit
    @Test
    void testCompletFlow() throws InterruptedException {

        UserDTO userDTO = createUserTest();
        log.info("Create User DTO" +userDTO);
        Assertions.assertNotNull(userDTO);
        //create survey
        createSurvyRequestUsingQTest(userDTO);
        /// if my queue is having ack
        Thread.sleep(600);
        //Awaitility.await().until();
        // check size
        ResponseEntity<List<SurveyDTO>> response = listAllSurveyTest();

        List<SurveyDTO> body = response.getBody();
        Assertions.assertEquals(1,body.size());


    }

    private ResponseEntity<List<SurveyDTO>> listAllSurveyTest() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return testRestTemplate.exchange(
                "/survey/list-survey", HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<SurveyDTO>>() {
                });
    }

    private void createSurvyRequestUsingQTest(UserDTO userDTO) {
        log.info("User DTO " + userDTO);
        SurveyRequest surveyRequest = SurveyRequest.builder().title("integration-survye-title").name("intergation-survey")
                .ownerId(userDTO.getUserId()).build();
        testRestTemplate.postForLocation("/survey/send-create-survey-request", surveyRequest);
    }

    private UserDTO createUserTest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        UserRequest userRequest = UserRequest.builder().firstName("integration-firstname")
                .lastName("integration-lastname").emailAddress("integration@email.com").phoneNumber("34343").build();
        return testRestTemplate.postForEntity("/user/create-user", userRequest, UserDTO.class).getBody();
    }

    @AfterAll
    void cleanUp(){
        userRepo.deleteAll();
                surveyRepository.deleteAll();;
    }
}




