package com.example.training.springboottesting.app.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * CreatedBy Harpal Singh at 12/3/21
 */
@Builder
@Data
@ToString
public class SurveyDTO {
    long surveyID;
    String name;
    String title;
    long ownerID;
}
