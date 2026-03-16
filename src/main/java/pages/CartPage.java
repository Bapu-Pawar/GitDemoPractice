package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import utils.LoggerUtil;

public class CartPage extends BasePage {

    @FindBy(className = "inventory_item_name")
    private WebElement cartItem;
    
    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;
    
    @FindBy (id = "remove-sauce-labs-backpack")
    private WebElement removeBackpack;

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    public String getCartItemName() {
        String name = getText(cartItem);
        LoggerUtil.info("Cart item found: " + name);
        return name;
    }
    
    public void removeBackpack() {
    	click(removeBackpack);
    }
    public boolean isCartEmpty() {
    	return cartItems.size()==0; }
}