package test.automation.stepdefinitions.android;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import test.automation.pages.android.HomeScreen;
import test.automation.pages.android.LoginScreen;

public class LoginAndroidSteps {
    @Autowired
    LoginScreen loginScreen;

    @Autowired
    HomeScreen homeScreen;

    @Given("user on login screen")
    public void androidUserInputUnregisteredEmail() {
        loginScreen.isOnPage();
    }

    @And("user tap login button")
    public void androidUserTapLoginButton() {
        loginScreen.tapLoginButton();
    }

    @Then("user see toast {string} is displayed")
    public void userSeeToastIsDisplayed(String message) {
        Assert.assertEquals(loginScreen.getToastMessage(),message);
    }

    @Then("user on home screen")
    public void userOnHomeScreen() {
        Assert.assertTrue(homeScreen.isOnPage());
    }
}
