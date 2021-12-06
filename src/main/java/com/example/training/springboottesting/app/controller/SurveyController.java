package com.example.training.springboottesting.app.controller;

import com.example.training.springboottesting.app.dto.SurveyDTO;
import com.example.training.springboottesting.app.entity.Survey;
import com.example.training.springboottesting.app.request.SurveyRequest;
import com.example.training.springboottesting.app.service.SurveyRenderer;
import com.example.training.springboottesting.app.service.SurveyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CreatedBy Harpal Singh at 12/2/21
 */

@RestController
@RequestMapping("survey")
public class SurveyController {

    @Autowired
    SurveyRenderer surveyService;

    @GetMapping("list-survey")
    public List<SurveyDTO> getAllSurvey(){
        return surveyService.getAllSurvey();
    }

    @PostMapping("create-survey")
    public void createSurvey(@RequestBody  SurveyRequest surveyRequest){
        surveyService.createSurvey(surveyRequest);
    }
}
