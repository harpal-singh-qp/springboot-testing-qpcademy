package com.example.training.springboottesting.app.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Harpal Singh 11/12/21
 */
@ExtendWith(MockitoExtension.class)
class TestGetDiscountServiceUsingMock_ArgumentCapture {


    @Mock
    CourseRepository courseRepository;

    @InjectMocks
    CourseService courseService;

    @Captor
    ArgumentCaptor<Course> courseArgumentCaptor;

    @Test
    void validateCourseTitle(){

        //Arrange

        CourseDto expectedCourseDto = CourseDto.builder().courseName("springBoot testing").build();

        //Act
        courseService.createCourse(expectedCourseDto);

        Mockito.verify(courseRepository).save(courseArgumentCaptor.capture());
        courseArgumentCaptor.getValue();
        //Assert
        Assertions.assertEquals("springBoot testing".toUpperCase(), courseArgumentCaptor.getValue().getTitle());
    }


}