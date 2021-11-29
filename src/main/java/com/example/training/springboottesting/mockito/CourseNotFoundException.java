package com.example.training.springboottesting.mockito;/* harpalsingh created on 11/23/21 inside the package - com.example.training.springboottesting */

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String courseName_is_not_valid) {
    super(courseName_is_not_valid);
    }
}
