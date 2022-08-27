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
        PageFactory.initElements(driver, this);
    }
    public boolean completedDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(orderCompleted));
        return orderCompleted.isDisplayed();
    }
    public String completedText () {
        wdWait.until(ExpectedConditions.visibilityOf(orderCompleted));
        return orderCompleted.getText();
    }
    public boolean messageDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(orderMessage));
        return orderMessage.isDisplayed();
    }
    public String messageText () {
        wdWait.until(ExpectedConditions.visibilityOf(orderMessage));
        return orderMessage.getText();
    }
}

