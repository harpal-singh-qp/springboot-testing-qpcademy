package com.example.training.springboottesting.app.request;

import lombok.Data;
import lombok.ToString;

/**
 * CreatedBy Harpal Singh at 12/3/21
 */

@Data
@ToString
public class SurveyRequest {

    private String name;
    private String title;
    private long ownerId;

}
