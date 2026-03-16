package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static void initDriver(String browser) {

        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");   // Opens browser in incognito

            driver = new ChromeDriver(options);

        } else {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }

        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().window().maximize();
    }
}