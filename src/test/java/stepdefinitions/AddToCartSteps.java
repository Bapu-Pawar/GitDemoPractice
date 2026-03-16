package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.ProductsPage;

public class AddToCartSteps {

    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();

    @When("user adds backpack to cart")
    public void userAddsBackpackToCart() {
        productsPage.addBackpackToCart();
    }

    @When("user opens cart page")
    public void userOpensCartPage() {
        productsPage.openCart();
    }

    @Then("backpack product should be visible in cart")
    public void verifyBackpackProductInCart() {
        String actualProduct = cartPage.getCartItemName();

        Assert.assertEquals(
                actualProduct,
                "Sauce Labs Backpack",
                "Product in cart is incorrect"
        );
    }
}
