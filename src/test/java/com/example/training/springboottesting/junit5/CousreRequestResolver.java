package com.example.training.springboottesting.junit5;

import com.example.training.springboottesting.mockito.CourseRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * CreatedBy Harpal Singh at 12/3/21
 */
@ExtendWith({GoodCourseRequestCreator.class,LoggExceptionInfoExtention.class})
public class CousreRequestResolver {

    @Test
    void validateCourseRequest(CourseRequest  courseRequest , TestInfo testInfo) {
        Assertions.assertNotNull(courseRequest);
        System.out.println(courseRequest.getUserName().length());
        System.out.println(testInfo);
        Assertions.assertNotNull(courseRequest.getUserName());

    }

    //@RepeatedTest()
    //TestInfo
}
