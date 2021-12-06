package com.example.training.springboottesting.app.junit5;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class RunOnJenkinCIExtention  implements ExecutionCondition {


    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {

        String jenkin_home = System.getenv("JENKIN_HOME");
        if(jenkin_home!=null){
            return ConditionEvaluationResult.enabled("This test is for jenkins CI");
        } else {
            return ConditionEvaluationResult.disabled("This is not specifics to Jenknis");
        }

    }
}

