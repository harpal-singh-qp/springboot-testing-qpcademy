package com.example.training.springboottesting.mockito;

import com.example.training.springboottesting.mockito.config.AwsConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * This is not a real word test case, this is just to showcase how to read property files using springboot
 * in testing context
 *
 * Goal:-
 *      1.read properties via standard way
 *      2.read properties from src folder
 *
 * @author Harpal Singh 11/25/21
 */
@ExtendWith({MockitoExtension.class, SpringExtension.class})
@ContextConfiguration(classes = {AwsConfig.class})
@TestPropertySource(locations = "classpath:aws/aws-config-test.properties")
public class TestMockedAwsConfig {


    @Autowired
    private AwsConfig awsConfig;

    @Test
    void validateAwsRegionName(){
        Assertions.assertEquals("us-east-test", awsConfig.getRegionName());
    }

    /**
     * bucket name is common it doesn't have to be in test property file,
     * if any property is not found under TestPropertySource file, then PropertySource path will be checked
     */
    @Test
    void validateAwsBucketName(){
        Assertions.assertEquals("hpst", awsConfig.getBucketName());
    }
}
