package hooks;

import config.ConfigReader;
import driver.DriverFactory;
import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtil;

import com.aventstack.extentreports.*;

import report.ExtentManager;

public class Hooks {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Before
    public void setUp(Scenario scenario) {

        // Create Extent test
        ExtentTest extentTest = extent.createTest(scenario.getName());
        test.set(extentTest);

        DriverFactory.initDriver(ConfigReader.get("browser"));
        DriverManager.getDriver().get(ConfigReader.get("url"));
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            test.get().fail("Scenario Failed ❌");

            // 🔥 CAPTURE & ATTACH SCREENSHOT
            String screenshotPath = ScreenshotUtil.capture(scenario.getName());

            try {
                test.get().addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            test.get().pass("Scenario Passed ✅");
        }

        extent.flush();

        DriverManager.getDriver().quit();
        DriverManager.unload();
    }
}
