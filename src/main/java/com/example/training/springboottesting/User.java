package com.example.training.springboottesting;/* harpalsingh created on 11/11/21 inside the package - com.example.training.springboottesting */

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Random;
/**
 * @author Harpal Singh 11/12/21
 */
@Data
@Component
public class User {
    private int id;
    private String name;
    private String emailAddress;

    public boolean isPrimeCustomer() {
        return new Random().nextBoolean();
    }
}
