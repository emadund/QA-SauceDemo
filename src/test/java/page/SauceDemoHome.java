package page;

import base.BaseSauce;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SauceDemoHome extends BaseSauce {
    @FindBy (id ="user-name")
    WebElement username;
    @FindBy (id ="password")
    WebElement password;
    @FindBy (id="login-button")
    WebElement loginButton;
    @FindBy (css="[data-test=\"error\"]")
    WebElement errorBanner;

    public SauceDemoHome () {
        PageFactory.initElements(driver,this);
    }
public SauceDemoHome fillUsername (String x) {
        wdWait.until(ExpectedConditions.elementToBeClickable(username));
        username.clear();
        username.sendKeys(x);
        return this;

}
public SauceDemoHome fillPassword (String x) {
        wdWait.until(ExpectedConditions.elementToBeClickable(password));
        password.clear();
        password.sendKeys(x);
        return this;

}
public void clickLogin () {
        wdWait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
}
public boolean errorDisplaying () {
        wdWait.until(ExpectedConditions.visibilityOf(errorBanner));
        return errorBanner.isDisplayed();
}
public String errorText () {
        wdWait.until(ExpectedConditions.visibilityOf(errorBanner));
        return errorBanner.getText();
}

}
