package test.automation.stepdefinitions.android;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import test.automation.data.User;
import test.automation.pages.android.LoginScreen;
import test.automation.pages.android.RegisterScreen;

public class RegisterAndroidSteps {

    @Autowired
    LoginScreen loginScreen;

    @Autowired
    RegisterScreen registerScreen;

    @Autowired
    User user;

    @Given("user on register screen")
    public void androidUserOnRegisterScreen() {
        loginScreen.tapRegisterLink();
        boolean actual = registerScreen.isOnPage();
        Assert.assertTrue(actual);
    }

    @When("user input {string} name")
    public void androidUserInputName(String value) {
        registerScreen.inputName(user.getName(value));
    }

    @And("user input {string} email")
    public void androidUserInputInvalidEmail(String value) {
        registerScreen.inputEmail(user.getEmail(value));
    }

    @And("user input {string} password")
    public void androidUserInputPassword(String value) {
        registerScreen.inputPassword(user.getPassword(value));
    }

    @And("user input {string} confirmation password")
    public void androidUserInputConfirmationPassword(String value) {
        registerScreen.inputConfirmPassword(user.getConfirmPassword(value));
    }

    @And("user tap register button")
    public void androidUserTapRegisterButton() {
        registerScreen.tapRegisterButton();
    }

    @Then("user see error {string} is displayed")
    public void userSeeErrorMessageIsDisplayed(String message) {
        Assert.assertTrue(registerScreen.isErrorRegisterMessageDisplayed(message));
    }

    @Then("user see success {string} is displayed")
    public void userSeeSuccessMessageIsDisplayed(String message) {
        Assert.assertEquals(registerScreen.getToastMessage(), message);
    }

    @Before(value = "@SuccessLogin")
    public void registerNewUser() {
        loginScreen.tapRegisterLink();
        user.existingEmail = user.getEmail("valid");
        user.existingPassword = user.getPassword("valid");
        registerScreen.inputName(user.getName("valid"));
        registerScreen.inputEmail(user.existingEmail);
        registerScreen.inputPassword(user.existingPassword);
        registerScreen.inputConfirmPassword(user.existingPassword);
        registerScreen.tapRegisterButton();
        Assert.assertTrue(registerScreen.isErrorRegisterMessageDisplayed("Registration Successful"));
        registerScreen.goBackToLoginScreen();
    }

}
