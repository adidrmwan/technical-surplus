package test.automation.pages.android;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.AndroidPageObject;

@Component("test.automation.pages.android.LoginScreen")
public class LoginScreen extends AndroidPageObject {

    private By registerLink() {
        return MobileBy.id("textViewLinkRegister");
    }

    private By loginButton() {
        return MobileBy.id("appCompatButtonLogin");
    }

    private By toastMessage() {
        return MobileBy.id("snackbar_text");
    }

    public boolean isOnPage() {
        return waitUntilPresence(loginButton()).isDisplayed();
    }

    public void tapRegisterLink() {
        onClick(registerLink());
    }

    public void tapLoginButton(){
        onClick(loginButton());
    }

    public String getToastMessage() {
        return waitUntilVisible(toastMessage()).getText();
    }

}
