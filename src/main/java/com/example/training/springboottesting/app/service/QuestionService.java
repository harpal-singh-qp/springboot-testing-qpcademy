package com.example.training.springboottesting.app.service;

import com.example.training.springboottesting.app.dto.MovieDTO;
import com.example.training.springboottesting.app.dto.QuestionDto;
import com.example.training.springboottesting.app.request.EntertainmentQuestionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * CreatedBy Harpal Singh at 12/19/21
 */

@Service
public class QuestionService {

    @Autowired
    EntertainmentQuestionHelperService entertainmentQuestionHelperService;


    public QuestionDto fetchMovieByTitle(EntertainmentQuestionRequest questionRequest) throws Exception {

        MovieDTO movieDto = entertainmentQuestionHelperService.fetchMovieDetailsByTitle(questionRequest.getTitle());
        List<String> actors = Arrays.asList(movieDto.getActors().split(","));
        return QuestionDto.builder().questionText("Select your favourite actor from movie "+movieDto.getTitle())
                .questionChoices(actors).build();


    }

}
