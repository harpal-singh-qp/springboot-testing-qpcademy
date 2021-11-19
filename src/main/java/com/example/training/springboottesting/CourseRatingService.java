package com.example.training.springboottesting;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * @author Harpal Singh 11/13/21
 */
public class CourseRatingService {

    @Autowired
    private CourseRatingRepository courseRatingRepository;

    @Autowired
    private CourseRepository courseRepository;


    @Autowired
    private CourseAnalyticService analyticService;

    public CourseRating submitCourseRating(CourseReviewRequest courseReviewRequest) {
        long courseID = courseReviewRequest.getCourseID();
        Optional<Course> courseHolder = courseRepository.findById(courseID);
        CourseRating courseRating = getCourseRating(courseReviewRequest, courseHolder);
        return courseRatingRepository.save(courseRating);
    }

    private CourseRating getCourseRating(CourseReviewRequest courseReviewRequest, Optional<Course> courseHolder) {
        if (courseHolder.isPresent()) {
            analyticService.sendForAnalytics(courseReviewRequest);
            Course course = courseHolder.get();
            CourseRating courseRating = prepareCourseRating(courseReviewRequest, course);
            return courseRating;
        }
        return null;
    }

    private CourseRating prepareCourseRating(CourseReviewRequest courseReviewRequest, Course course) {
        return CourseRating.builder()
                        .rating(courseReviewRequest.getRating())
                        .course(course)
                        .ratedBy(courseReviewRequest.getReviewedBy())
                        .build();
    }
}
