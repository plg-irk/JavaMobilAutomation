package ru.gb.cucumber.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

        loginPage.checkLoginErrorText(errorText);
    }

    @When("^User get valid email$")
    public void user_get_valid_email() {
        loginPage.sendInputEmail();
    }

    @Then("^User should see error message password \"([^\"]*)\"$")
    public void user_should_see_error_message_password(String errorPassword) {
        loginPage.checkPasswordErrorText(errorPassword);
    }

}