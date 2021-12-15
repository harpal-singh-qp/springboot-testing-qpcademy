package com.example.training.springboottesting.app.controller;

import com.example.training.springboottesting.app.service.SurveyRenderer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
    void createSurveyTest() throws Exception {

     }

     @Test
    void getAllSurveyTest() throws Exception {
         this.mockMvc.perform(MockMvcRequestBuilders.get("/survey/list-survey")
                 .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON))
                 .andExpect(MockMvcResultMatchers.status().is(200))
                 .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                 .andDo(MockMvcResultHandlers.print())
                 .andReturn();
     }
}
