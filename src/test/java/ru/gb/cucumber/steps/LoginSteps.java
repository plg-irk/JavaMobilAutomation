package ru.gb.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.gb.base.BaseTest;
import ru.gb.pages.LoginPage;

public class LoginSteps extends BaseTest {

    LoginPage loginPage;

    @Given("^User is on Login page$")
    public void user_is_on_Login_page() {
        loginPage = openApp().clickLoginMenuButton();
    }

    @When("^User click login button$")
    public void user_click_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("^User should see error message \"([^\"]*)\"$")
    public void user_should_see_error_message(String errorText) {
        loginPage.checkPasswordErrorText(errorText);
    }
}
