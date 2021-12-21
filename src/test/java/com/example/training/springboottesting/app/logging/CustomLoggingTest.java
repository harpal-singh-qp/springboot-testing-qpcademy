package com.example.training.springboottesting.app.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;


/**
 * CreatedBy Harpal Singh at 12/14/21
 */

public class CustomLoggingTest {

    private static Log log = LogFactory.getLog(GoodLoggingTest.class);

    @Test
    void customLoggingTest() {
        log.info(" C Logging test");
        }

}
