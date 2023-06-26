package page;

import base.BaseSauce;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CompletePage extends BaseSauce {
    @FindBy (className = "complete-header")
    WebElement orderCompleted;
    @FindBy (className = "complete-text")
    WebElement orderMessage;

    public CompletePage () {
        super();
        PageFactory.initElements(driver, this);
    }
    public boolean completedDisplayed () {
        return isDisplayed(orderCompleted);
    }
    public String completedText () {

        return textShown(orderCompleted);
    }
    public boolean messageDisplayed () {
        return isDisplayed(orderMessage);
    }
    public String messageText () {
        return textShown(orderMessage);
    }
}

