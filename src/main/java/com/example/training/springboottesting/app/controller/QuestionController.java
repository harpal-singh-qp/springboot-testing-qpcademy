package com.example.training.springboottesting.app.controller;

import com.example.training.springboottesting.app.dto.QuestionDto;
import com.example.training.springboottesting.app.request.EntertainmentQuestionRequest;
import com.example.training.springboottesting.app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CreatedBy Harpal Singh at 12/2/21
 */

@RestController
@RequestMapping("survey")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("create-question")
    QuestionDto createQuestion(@RequestBody EntertainmentQuestionRequest questionRequest) throws Exception {
        return questionService.fetchMovieByTitle(questionRequest);
    }

}

