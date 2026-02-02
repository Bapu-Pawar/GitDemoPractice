package stepdefinitions;

import config.ConfigReader;
import io.cucumber.java.en.Given;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user logs into SauceDemo")
    public void login() {
        loginPage.login(
            ConfigReader.get("username"),
            ConfigReader.get("password")
        );
    }
}
