package com.example.training.springboottesting.mockito;

import lombok.*;

/**
 * @author Harpal Singh 11/14/21
 */

@Data
@Builder
public class CourseReviewRequest {
    private long courseID;
    private String reviewedBy;
    private int rating;
    private String detailedComment;
}

