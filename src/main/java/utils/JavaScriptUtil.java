package utils;

 
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import driver.DriverManager;

public class JavaScriptUtil {

    private static JavascriptExecutor js() {
        return (JavascriptExecutor) DriverManager.getDriver();
    }

    public static void scrollIntoView(WebElement element) {
        js().executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void clickByJS(WebElement element) {
        js().executeScript("arguments[0].click();", element);
    }

    public static void highlightElement(WebElement element) {
        js().executeScript(
                "arguments[0].style.border='3px solid red'", element);
    }
}
