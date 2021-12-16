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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

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
    void getAllSurveyTest() throws Exception {
        List<SurveyDTO> surveyDTOList = new ArrayList<>();
        surveyDTOList.add(SurveyDTO.builder().title("test-title")
                .surveyID(1).ownerID(1).name("mock-mvc-name").build());

        when(surveyRenderer.getAllSurvey()).thenReturn(surveyDTOList);
        mockMvc.perform(
                MockMvcRequestBuilders.get("/survey/list-survey"))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    void createSurveyTest() throws Exception, UserNotFoundException {
        SurveyRequest surveyRequest = SurveyRequest.builder().name("harpal").ownerId(1).title("title-survey").build();

        when(surveyRenderer.createSurvey(surveyRequest)).thenReturn(SurveyDTO.builder().name(surveyRequest.getName()).build());
        mockMvc.perform(
                MockMvcRequestBuilders.post("/survey/create-survey")
        .content(objectMapper.writeValueAsString(surveyRequest))
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }

    @Test
    void testCreateSurveyViaQueue() {

    }

}
