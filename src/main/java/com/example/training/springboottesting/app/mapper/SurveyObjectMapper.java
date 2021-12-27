package com.example.training.springboottesting.app.mapper;

import com.example.training.springboottesting.app.dto.SurveyDTO;
import com.example.training.springboottesting.app.entity.Survey;
import com.example.training.springboottesting.app.entity.User;
import com.example.training.springboottesting.app.exception.UserNotFoundException;
import com.example.training.springboottesting.app.repository.UserRepository;
import com.example.training.springboottesting.app.request.SurveyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;


/**
 * CreatedBy Harpal Singh at 12/3/21
 */

@Component
public class SurveyObjectMapper implements CustomObjectMapper {

    @Autowired
    private UserRepository userRepository;

    public SurveyDTO convertToSurveyDto(Survey survey) {
        return SurveyDTO.builder()
                .name(survey.getName())
                .ownerID(survey.getOwnerId())
                .surveyID(survey.getId())
                .title(survey.getTitle())
                .build();
    }

    public String convertToJson(SurveyRequest surveyRequest){
        return gson.toJson(surveyRequest);
    }

    public SurveyRequest convertToSurveyRequest(String jsonRequest){
        return gson.fromJson(jsonRequest, SurveyRequest.class);
    }

    public Survey convertToSurvey(SurveyRequest surveyRequest) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(surveyRequest.getOwnerId());
        if(optionalUser.isPresent()){
            return new Survey().setName(surveyRequest.getName())
                   // .setOwner(optionalUser.get())
                    .setOwnerId(surveyRequest.getOwnerId()).setTitle(surveyRequest.getTitle())
                    .setUpdatedAt(new Date()).setCreatedAt(new Date());
        } else {
            throw new UserNotFoundException("User Not Found Exception");
        }
    }
}
