package com.example.training.springboottesting.app.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * CreatedBy Harpal Singh at 12/19/21
 */

@Data
@Builder
public class QuestionDto {

    String questionText;
    List<String> questionChoices;
}
