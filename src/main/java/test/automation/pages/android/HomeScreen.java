package test.automation.pages.android;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.AndroidPageObject;

@Component("test.automation.pages.android.HomeScreen")
public class HomeScreen extends AndroidPageObject {
    private By title() {
        return MobileBy.xpath("//android.widget.TextView[contains(@text, 'Android NewLine Learning')]");
    }

    public boolean isOnPage() {
        return waitUntilVisible(title()).isDisplayed();
    }
}
