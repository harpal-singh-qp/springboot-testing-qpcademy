package com.example.training.springboottesting.app.logging;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


/**
 * CreatedBy Harpal Singh at 12/14/21
 *
 */

@Slf4j
public class GoodLoggingTest {


    @DisplayName("Good Logging")
    @ParameterizedTest
    @ValueSource(strings = {"log4j", "sl4j"})
    void goodLoggingTest(String loggerLib) {
        log.info(String.format(" Popular Logger Lib %s",loggerLib ));
        Assertions.assertNotNull(loggerLib);
    }
}
