package com.example.training.springboottesting.app.logging;

import com.example.training.springboottesting.app.junit5.GoodCourseRequestCreator;
import com.example.training.springboottesting.app.mockito.CourseRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * CreatedBy Harpal Singh at 12/3/21
 */
@ExtendWith({GoodCourseRequestCreator.class})
public class TestParameterResolverAndExceptionHandler {

    private static Log log = LogFactory.getLog(GoodLoggingTest.class);



    @Test
    void validateCourseRequest(CourseRequest courseRequest) {
        Assertions.assertNotNull(courseRequest);
        System.out.println(courseRequest.getUserName().length());
        Assertions.assertNotNull(courseRequest.getUserName());
    }

  }
