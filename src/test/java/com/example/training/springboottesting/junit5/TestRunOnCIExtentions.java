package com.example.training.springboottesting.junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Target;

/*

 whatever is getting repeated , think of writing an extention for it
 what to chose whhat kind  extention, check use-case-repeat,
 whether on each method,each test instace , post method ,
 beofremethod

 */
@ExtendWith(RunOnJenkinCIExtention.class)
public class TestRunOnCIExtentions {


    @Test
    void testOnCi(){

    }

    @Tag("qa")
    @Test
    void testsdfOnsdfsi(){

    }



    @Tag("dev")
    @Test
    void testOnsdfdfsi(){

    }
}
