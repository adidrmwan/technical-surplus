package test.automation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import test.automation.driver.AndroidDriverPool;
import test.automation.driver.DriverPool;

import java.util.List;

public class BasePageObject {
    @Autowired
    DriverPool driver;

    @Autowired
    AndroidDriverPool androidDriverPool;

    public WebDriver getDriver() {
        if (this.driver.getAndroidDriver() == null) {
            this.driver.setAndroidDriver(this.androidDriverPool.create());
        }
        return this.driver.getAndroidDriver();
    }

    public WebDriverWait onWait() {
        return new WebDriverWait(getDriver(), 15);
    }

    public WebElement waitUntilClickable(By by) {
        return onWait().until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitUntilPresence(By by) {
        return onWait().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> waitUntilPresences(By by) {
        return onWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public WebElement waitUntilVisible(By by) {
        return onWait().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public List<WebElement> waitUntilVisibles(By by) {
        return onWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void onClick(By by) {
        waitUntilClickable(by).click();
    }

    public void onType(By by, CharSequence... keysToSend) {
        waitUntilPresence(by).sendKeys(keysToSend);
    }

    public void clear(By by) {
        waitUntilPresence(by).clear();
    }

    public boolean isElementInvisible(By by) {
        return onWait().until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void scrollTo(By by) {
        Locatable l = ((Locatable) this.waitUntilPresence(by));
        l.getCoordinates().inViewPort();
    }
}
