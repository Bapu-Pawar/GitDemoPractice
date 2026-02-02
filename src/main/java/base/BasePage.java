package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driver.DriverManager;
import utils.WaitUtil;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverManager.getDriver();
    }

    protected void click(WebElement element) {
        WaitUtil.waitForClickable(element);
        element.click();
    }

    protected void type(WebElement element, String value) {
        WaitUtil.waitForVisibility(element);
        element.clear();
        element.sendKeys(value);
    }

    protected String getText(WebElement element) {
        WaitUtil.waitForVisibility(element);
        return element.getText();
    }
}
