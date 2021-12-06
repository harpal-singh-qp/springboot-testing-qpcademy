package com.example.training.springboottesting.app.dto;

import lombok.Builder;
import lombok.Data;

/**
 * CreatedBy Harpal Singh at 12/3/21
 */
@Builder
@Data
public class SurveyDTO {
    long surveyID;
    String name;
    String title;
    long ownerID;
}
