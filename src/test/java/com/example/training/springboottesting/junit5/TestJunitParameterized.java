package com.example.training.springboottesting.junit5;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.training.springboottesting.mockito.Course;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.InvokeDynamic;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

