package com.example.training.springboottesting.app.mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harpal Singh 11/12/21
 */
@Service

public class CourseService {

    @Autowired

    private CourseRepository courseRepository;

    CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    private boolean isEligibleForBlackFridaySale;

    public List<CourseDto> getCourses(){
        List<CourseDto> courseDtos = new ArrayList<>();
        courseRepository.findAll().stream().forEach( course->{
            courseDtos.add(CourseDto.builder().courseName(course.getCourseName().toLowerCase()).build());
        });

        return courseDtos;
    }


    public Course createCourse(CourseDto courseDto) {
        Course course = new Course();
        course.setTitle(courseDto.getCourseName().toUpperCase());
        return courseRepository.save(course);
    }




}
