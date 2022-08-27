package page;

import base.BaseSauce;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutPage extends BaseSauce {
    @FindBy (id="first-name")
    WebElement firstName;
    @FindBy (css="[placeholder=\"Last Name\"]")
    WebElement lastName;
    @FindBy (id="postal-code")
    WebElement zipCode;
    @FindBy (id="continue")
    WebElement finish;
    @FindBy (css = "[data-test=\"error\"]")
    WebElement wrong;

    public CheckOutPage () {
        PageFactory.initElements(driver, this);
    }

    public CheckOutPage inputAllFields () {
        this.inputFirstName("Zika")
                .inputLastName("Zikic")
                .inputZipCode("37000");
        return this;
    } // one method for all inputs
    public CheckOutPage inputFirstName (String x) {
        wdWait.until(ExpectedConditions.elementToBeClickable(firstName));
        firstName.clear();
        firstName.sendKeys(x);
        return this;
    }
    public CheckOutPage inputLastName (String x) {
        wdWait.until(ExpectedConditions.elementToBeClickable(lastName));
        lastName.clear();
        lastName.sendKeys(x);
        return this;
    }
    public CheckOutPage inputZipCode (String x) {
        wdWait.until(ExpectedConditions.elementToBeClickable(zipCode));
        zipCode.clear();
        zipCode.sendKeys(x);
        return this;
    }
    public void clickContinue () {
        wdWait.until(ExpectedConditions.elementToBeClickable(finish));
        finish.click();
    }
    public boolean wrongDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(wrong));
        return wrong.isDisplayed();
    }
    public String wrongText () {
        wdWait.until(ExpectedConditions.visibilityOf(wrong));
        return wrong.getText();
    }

}
