package com.example.training.springboottesting.mockito;

import lombok.Builder;
import lombok.Data;

/**
 * CreatedBy Harpal Singh at 12/3/21
 */
@Data
@Builder
public class CourseRequest {

    private String courseName;
    private String userName;
    private long price;
    private String coachName;
}
