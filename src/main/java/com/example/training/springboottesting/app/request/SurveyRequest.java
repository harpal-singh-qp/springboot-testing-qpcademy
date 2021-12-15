package com.example.training.springboottesting.app.request;

import lombok.Builder;
import lombok.Data;

/**
 * CreatedBy Harpal Singh at 12/3/21
 */

@Data
@Builder
public class SurveyRequest {

    private String name;
    private String title;
    private long ownerId;

}
