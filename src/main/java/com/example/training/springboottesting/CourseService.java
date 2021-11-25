package com.example.training.springboottesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Harpal Singh 11/12/21
 */
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;



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

//    public int getTotalEnrolledStudents(long courseID){
//        Optional<Course> course = courseRepository.findById(courseID);
//        return getTotalCount(course.get());
//
//    }
//
//    private int getTotalCount(Course course) {
//        if()
//    }

}
