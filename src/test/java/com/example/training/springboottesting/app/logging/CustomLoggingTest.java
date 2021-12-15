package com.example.training.springboottesting.app.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


/**
 * CreatedBy Harpal Singh at 12/14/21
 */

public class CustomLoggingTest {

    private static Log log = LogFactory.getLog(CustomLoggingTest.class);

    @Test
    void customLoggingTest() {
        log.info(" C Logging test");
        }

}
