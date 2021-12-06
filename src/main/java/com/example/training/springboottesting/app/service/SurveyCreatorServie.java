package com.example.training.springboottesting.app.service;

import com.example.training.springboottesting.app.request.SurveyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CreatedBy Harpal Singh at 12/3/21
 */

@Service
public class SurveyCreatorServie implements SurveyCreator {

    @Autowired
    SurveyQProducer surveyQueueService;

    @Override
    public void createSurvey(SurveyRequest surveyRequest) {
        surveyQueueService.pushSurveyCreateRequestToQueue(surveyRequest);
    }
}
