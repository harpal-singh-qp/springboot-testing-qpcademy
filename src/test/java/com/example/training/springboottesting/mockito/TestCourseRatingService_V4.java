package com.example.training.springboottesting.mockito;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.lang.reflect.Method;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * @author Harpal Singh 11/12/21
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

class TestCourseRatingService_V4 {

    @Mock
    CourseRatingRepository courseRatingRepository;


    @Mock
    CourseRepository courseRepository;

    @Mock
    CourseAnalyticService courseAnalyticService;

    @InjectMocks
    CourseRatingService courseRatingService;


    @Test
    void validate_Festive_Season_SPringBootTEst_With_Mockito() {

        Course course = getCourseName();
        CourseReviewRequest goodCourseReviewRequest = getCourseReviewRequest(course);
        CourseRating expectedCourseRating = getCourseRatingObject(goodCourseReviewRequest, course);


        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(course));
        when(courseRatingRepository.save(any())).thenReturn(expectedCourseRating);

        CourseRating actualCourseRating = courseRatingService.submitCourseRating(goodCourseReviewRequest);
        verify(courseRepository,times(1)).findById(goodCourseReviewRequest.getCourseID());
        verify(courseAnalyticService,times(1)).sendForAnalytics(goodCourseReviewRequest);
        Assertions.assertNotNull(actualCourseRating);

    }


    private CourseRating getCourseRatingObject(CourseReviewRequest courseReviewRequest, Course course) {
        return CourseRating.builder()
                .rating(courseReviewRequest.getRating())
                .course(course)
                .ratedBy(courseReviewRequest.getReviewedBy())
                .build();
    }

    private CourseReviewRequest getCourseReviewRequest(Course course) {
        return CourseReviewRequest.builder().courseID(course.getId()).rating(5).reviewedBy("rahul")
                .detailedComment("This course is awesome").build();
    }

    private Course getCourseName() {
        Course course = new Course();
        course.setId(1l);
        course.setBookId(12l);
        course.setCoachName("Harpal");
        course.setContent("This Course Gives you proper insight of mocking framework !!");
        course.setTitle("Mockito");
        course.setUserId(24l);
        return course;
    }

}


class CustomUnitTestDisplayName extends DisplayNameGenerator.Standard {

    @Override
    public String generateDisplayNameForClass(Class<?> testClass) {
        return "Unit test class "+super.generateDisplayNameForClass(testClass);
    }

    @Override
    public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
        return super.generateDisplayNameForNestedClass(nestedClass);
    }

    @Override
    public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
        return "Should validate if "+super.generateDisplayNameForMethod(testClass, testMethod);
    }
}
