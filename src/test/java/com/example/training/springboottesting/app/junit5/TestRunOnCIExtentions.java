package com.example.training.springboottesting.app.junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

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
