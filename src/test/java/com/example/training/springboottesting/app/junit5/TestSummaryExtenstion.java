package com.example.training.springboottesting.app.junit5;

import org.junit.jupiter.api.extension.*;

/**
 * Goal : To create a custom extention to create test summary
 * use it in your test  : @ExtendWith(TestSummaryExtenstion.class)
 *
 * @author Harpal Singh 30/11/21
 */
public class TestSummaryExtenstion implements BeforeAllCallback, BeforeEachCallback, AfterEachCallback,
        AfterAllCallback {


    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        long startTime = System.currentTimeMillis();
        context.getStore(ExtensionContext.Namespace.create("TestSummaryStore")).put("TEST_CLASS", startTime);
    }


    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        long startTime = System.currentTimeMillis();
        context.getStore(ExtensionContext.Namespace.create("TestSummaryStore")).put("TEST_METHOD", startTime);

    }


    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        Long startTimeOFMehotd = context.getStore(ExtensionContext.Namespace.create("TestSummaryStore"))
                .get("TEST_METHOD", long.class);
        long totalTime = System.currentTimeMillis() - startTimeOFMehotd.longValue();
        context.publishReportEntry("************ " + context.getDisplayName() + " have taken *" + totalTime + " taken");
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        Long startTimeOFMehotd = context.getStore(ExtensionContext.Namespace.create("TestSummaryStore"))
                .get("TEST_CLASS", long.class);
        long totalTime = System.currentTimeMillis() - startTimeOFMehotd.longValue();
        context.publishReportEntry("************ " + context.getDisplayName() + " have taken *" + totalTime + " taken");

    }

}
