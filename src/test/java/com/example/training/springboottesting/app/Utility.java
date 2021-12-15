package com.example.training.springboottesting.app;

import java.util.Random;

/**
 * CreatedBy Harpal Singh at 12/15/21
 */
public class Utility {

    private Utility(){}

    private static Random random = new Random();

    public static Integer getRandomInteger(){
        return random.nextInt();
    }

    public static Integer getRandomAge(){
        return random.nextInt(110);
    }


}
