package com.example.training.springboottesting.app.service;

import com.example.training.springboottesting.app.request.SurveyRequest;
import com.google.gson.Gson;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * CreatedBy Harpal Singh at 12/3/21
 */

@Component
public class SurveyQProducer {

    @Autowired
    private RabbitTemplate template;

    private Gson gson = new Gson();

    @Autowired
    private Queue queue;

    public void pushSurveyCreateRequestToQueue(SurveyRequest surveyRequest) {
        this.template.convertAndSend(queue.getName(), gson.toJson(surveyRequest));
        System.out.println(" [x] Sent '" + surveyRequest.toString() + "'");
    }
}