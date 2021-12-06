package com.example.training.springboottesting.app.junit5;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayNameGeneration(CustomDisplayName.class)
public class TestDisplayName {

    @Test
    void test_Display_Name(){


    }
}

class CustomDisplayName extends DisplayNameGenerator.Standard {

    @Override
    public String generateDisplayNameForClass(Class<?> testClass) {
        return super.generateDisplayNameForClass(testClass);
    }

    @Override
    public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
        return super.generateDisplayNameForNestedClass(nestedClass);
    }

    @Override
    public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
        return "*****"+testMethod.getName()+"***********";
    }
}

