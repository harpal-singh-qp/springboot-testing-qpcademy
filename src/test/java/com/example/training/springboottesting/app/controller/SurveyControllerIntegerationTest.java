package com.example.training.springboottesting.app.controller;

import com.example.training.springboottesting.app.dto.SurveyDTO;
import com.example.training.springboottesting.app.exception.UserNotFoundException;
import com.example.training.springboottesting.app.request.SurveyRequest;
import com.example.training.springboottesting.app.service.SurveyRenderer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * CreatedBy Harpal Singh at 12/5/21
 */

@WebMvcTest(SurveyController.class)
public class SurveyControllerIntegerationTest {


    @MockBean
    SurveyRenderer surveyRenderer;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllSurveyTest(List<SurveyDTO> surveyDTOList) throws Exception {
        when(surveyRenderer.getAllSurvey()).thenReturn(surveyDTOList);

        mockMvc.perform(get("/survey/list-survey"))
                .andExpect(status().is(OK.value()))
                .andDo(print())
                .andExpect(jsonPath("$.[0].surveyID").value(1))
                .andExpect(jsonPath("$.[0].name").value("SurveyName"))
                 .andReturn();

}

    @Test
    void createSurveyTest() throws Exception, UserNotFoundException {
    // Arrange
        SurveyRequest surveyRequest = SurveyRequest.builder().title("postSurveyTitle")
                .name("postSurveyName").build();
        when(surveyRenderer.createSurvey(surveyRequest)).thenReturn(SurveyDTO.builder()
                .name(surveyRequest.getName())
                .title(surveyRequest.getTitle())
                .build());
        //Act//assert
        mockMvc.perform(post("/survey/create-survey")
                .content(objectMapper.writeValueAsString(surveyRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(OK.value()))
                .andDo(print())
                .andExpect(jsonPath("$.title").value("postSurveyTitle"))
                .andExpect(jsonPath("$.name").value("postSurveyName"))
                .andReturn();
    }

    @Test
    void testCreateSurveyViaQueue() {

    }

}
