package com.example.training.springboottesting.app.junit5;

import com.example.training.springboottesting.app.mockito.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/*
    This is to show case usages of parameterized test
    Goal : Read test property file and create stubbed courses instead of hard-coding and expand your range of testing
    with multiple use-cases

 */
@ExtendWith(TestSummaryExtenstion.class)
public class TestJunitParameterized {


    @ParameterizedTest
    @DisplayName("validate Top Course")
    @MethodSource("topCourseProvider")
    void validateTopCourse(String topCourse ) {
     Assertions.assertNotNull(topCourse);
    }

    static Stream<String> topCourseProvider(){
     return new ArrayList<>(Arrays.asList("ElasticSesarch","Machine-learning")).stream();
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/good-course-sample.csv", numLinesToSkip = 1)
    @DisplayName("validateGood Course")
    void validateGoodCourse(String coachName, String courseContent, String courseTitle) {

        Course course = getStubbedCourseName(coachName, courseContent, courseTitle);
        Assertions.assertNotNull(course.getContent());
        Assertions.assertNotNull(course.getCoachName());
        Assertions.assertNotNull(course.getTitle());
        //Some business logic when you can pass your stubbed course;
    }


    @DisplayName("validateGoosdd Course")
    @ParameterizedTest
    @ValueSource(strings = {"springboot", "mockito"})
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

