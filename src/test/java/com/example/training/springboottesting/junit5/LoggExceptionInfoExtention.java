package com.example.training.springboottesting.junit5;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.util.Arrays;
import java.util.Optional;

/**
 * CreatedBy Harpal Singh at 12/3/21
 */
@Slf4j
public class LoggExceptionInfoExtention implements TestExecutionExceptionHandler {


    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {

        log.error(" Test-Instance "+ context.getTestInstance() +" threw an execption for test method ::"+context.getDisplayName());
        Optional<StackTraceElement> first = Arrays.stream(throwable.getStackTrace()).findFirst();
        StackTraceElement stackTraceElement = first.get();
        log.error(String.format(" At Time %s with for file %s at line number %s "
                , System.currentTimeMillis() ,stackTraceElement.getFileName(),stackTraceElement.getLineNumber()));
    }


}
