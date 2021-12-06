package com.example.training.springboottesting.app.service;

import com.example.training.springboottesting.app.entity.Survey;
import com.example.training.springboottesting.app.exception.UserNotFoundException;
import com.example.training.springboottesting.app.mapper.SurveyObjectMapper;
import com.example.training.springboottesting.app.repo.SurveyRepository;
import com.example.training.springboottesting.app.request.SurveyRequest;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * CreatedBy Harpal Singh at 12/4/21
 */

@Component
public class SurveyQConsumer {

    @Autowired
    SurveyObjectMapper mapper;

    @Autowired
    SurveyRepository surveyRepository;

    @RabbitHandler
    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload Message message) throws UserNotFoundException {
        SurveyRequest surveyRequest = mapper.convertToSurveyRequest(String.valueOf(message.getPayload()));
        System.out.println(" [x] Received '" + surveyRequest + "'");
        Survey survey = mapper.convertToSurvey(surveyRequest);
        surveyRepository.save(survey);
    }
}