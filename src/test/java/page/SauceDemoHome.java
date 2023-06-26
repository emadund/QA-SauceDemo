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
        super();
        PageFactory.initElements(driver,this);
    }
public void fillUsername (String x) {
        fillTextField(x,username);
}
public void fillPassword (String x) {
       fillTextField(x,password);
}
public void clickLogin () {
        clickOnButton(loginButton);
}
public boolean errorDisplaying () {
       return isDisplayed(errorBanner);
}
public String errorText () {

        return textShown(errorBanner);
}

}
