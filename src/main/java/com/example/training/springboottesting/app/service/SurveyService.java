package com.example.training.springboottesting.app.service;

import com.example.training.springboottesting.app.dto.SurveyDTO;
import com.example.training.springboottesting.app.entity.Survey;
import com.example.training.springboottesting.app.exception.UserNotFoundException;
import com.example.training.springboottesting.app.mapper.SurveyObjectMapper;
import com.example.training.springboottesting.app.repository.SurveyRepository;
import com.example.training.springboottesting.app.request.SurveyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * CreatedBy Harpal Singh at 12/3/21
 */
@Service
public class SurveyService implements SurveyRenderer {

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    SurveyObjectMapper mapper;

    @Autowired
    SurveyQProducer surveyQProducer;



    @Override
    public List<SurveyDTO> getAllSurvey() {
        List<Survey> all = surveyRepository.findAll();
        return all.stream().map(mapper::convertToSurveyDto).collect(Collectors.toList());
    }

    @Override
    public void sendCreateSurveyToQueue(SurveyRequest surveyRequest) {
        surveyQProducer.pushSurveyCreateRequestToQueue(surveyRequest);
    }

    @Override
    public SurveyDTO createSurvey(SurveyRequest surveyRequest) throws UserNotFoundException {
        Survey survey = mapper.convertToSurvey(surveyRequest);
        Survey save = surveyRepository.save(survey);
        return mapper.convertToSurveyDto(save);
    }

}