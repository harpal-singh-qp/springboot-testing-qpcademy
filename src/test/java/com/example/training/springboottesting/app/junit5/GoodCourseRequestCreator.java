package com.example.training.springboottesting.app.junit5;
import com.example.training.springboottesting.app.mockito.CourseRequest;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

/**
 * CreatedBy Harpal Singh at 12/3/21
 */
public class GoodCourseRequestCreator implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType()== CourseRequest.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return CourseRequest.builder().courseName("SpringBootTesting").coachName("Harpaal").price(1000).build();
        //dfsfsdfs
    }
}
