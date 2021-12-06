package com.example.training.springboottesting.app.service;

import com.example.training.springboottesting.app.dto.SurveyDTO;
import com.example.training.springboottesting.app.request.SurveyRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CreatedBy Harpal Singh at 12/3/21
 */
@Service
public interface SurveyRenderer {

     List<SurveyDTO> getAllSurvey() ;

     void createSurvey(SurveyRequest surveyRequest);
}
