package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;

public class RemoveProductFromCartSteps {
	
	CartPage cartPage = new CartPage();
	
	@When("user remove product from cart")
	public void user_remove_product_from_cart() {
		cartPage.removeBackpack();
	}
	@Then("cart should be empty")
	public void cart_is_empty() {
		cartPage.isCartEmpty();
	}

}
