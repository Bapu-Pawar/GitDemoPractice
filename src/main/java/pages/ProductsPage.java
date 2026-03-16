package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import utils.LoggerUtil;

public class ProductsPage extends BasePage {

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackBtn;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    public void addBackpackToCart() {
        click(addBackpackBtn);
        LoggerUtil.info("Clicked Add to Cart for Backpack");
    }

    public void openCart() {
        click(cartIcon);
        LoggerUtil.info("Opened Cart Page");
    }
}