package com.example.training.springboottesting.junit5;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.training.springboottesting.mockito.Course;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

/*
    This is to show case usages of parameterized test
    Goal : Read test property file and create stubbed courses instead of hard-coding and expand your range of testing
    with multiple use-cases

 */
public class TestJunitParameterized {


@ParameterizedTest
@CsvFileSource(resources = "/good-course-sample.csv" ,numLinesToSkip = 1)
void validateGoodCourse(String coachName,String courseContent,String courseTitle){
    Course course = getStubbedCourseName(coachName, courseContent, courseTitle);
    Assertions.assertNotNull(course.getContent());
    Assertions.assertNotNull(course.getCoachName());
    Assertions.assertNotNull(course.getTitle());
    //Some business logic when you can pass your stubbed course;
}

    @ParameterizedTest
    @ValueSource (strings = {"springboot","mockito"})
    void validateGoodCourse(String courseName) {
    Assertions.assertNotNull(courseName);
}


    private Course getStubbedCourseName(String coachName, String courseContent, String courseTitle) {
        Course course = new Course();
        course.setCoachName(coachName);
        course.setTitle(courseTitle);
        course.setContent(courseContent);
        return course;
    }

}