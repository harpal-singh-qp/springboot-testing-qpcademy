package com.example.training.springboottesting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import java.net.InetAddress;

public class LoggerExtension implements TestInstancePostProcessor {

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        Logger logger = LogManager.getLogger(testInstance.getClass());
        testInstance.getClass().getMethod("setLogger", Logger.class).invoke(testInstance, logger);
        logger.info(" User" + System.getenv().get("USER") + " IPAddress " + InetAddress.getLocalHost() + " CurrentTime "
                + System.currentTimeMillis());

    }


}
