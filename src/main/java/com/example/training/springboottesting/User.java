package com.example.training.springboottesting;/* harpalsingh created on 11/11/21 inside the package - com.example.training.springboottesting */

import lombok.Data;

import java.util.random.RandomGenerator;
/**
 * @author Harpal Singh 11/12/21
 */
@Data
public class User {
    private int id;
    private String name;

    public boolean isPrimeCustomer() {
        return RandomGenerator.getDefault().nextBoolean();
    }
}
