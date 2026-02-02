package hooks;

import com.aventstack.extentreports.*;
import io.cucumber.java.*;

import report.ExtentManager;

public class ExtentHooks {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentTest extentTest = extent.createTest(scenario.getName());
        test.set(extentTest);
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            test.get().fail("Scenario Failed");
        } else {
            test.get().pass("Scenario Passed");
        }
        extent.flush();
    }
}
