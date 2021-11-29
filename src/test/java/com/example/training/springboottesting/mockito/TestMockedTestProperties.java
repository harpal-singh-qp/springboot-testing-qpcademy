package com.example.training.springboottesting.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sun.net.ftp.FtpClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
 * This is not a real word test case, this is just to showcase how to read property files using springboot
 * in testing context
 *
 * Goal-->read inline properties
 *
 * @author Harpal Singh 11/25/21
 */
@ExtendWith({MockitoExtension.class, SpringExtension.class})
@TestPropertySource(properties = {"ftp.server.host=dummy.ftp.server:9031"})

public class TestMockedTestProperties {

    @Autowired
    Environment environment;


    @Test
    void validateFtpSetup() {
        Assertions.assertEquals("dummy.ftp.server:9031", environment.getProperty("ftp.server.host"));

    }
}
