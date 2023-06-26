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
        super();
        PageFactory.initElements(driver, this);
    }

    public void inputAllFields () {
        inputFirstName("Zika");
        inputLastName("Zikic");
        inputZipCode("37000");
    } // one method for all inputs
    public void inputFirstName (String x) {
        fillTextField(x, firstName);
    }
    public void inputLastName (String x) {
        fillTextField(x, lastName);
    }
    public void inputZipCode (String x) {
        fillTextField(x, zipCode);
    }
    public void clickContinue () {
        clickOnButton(finish);
    }
    public boolean wrongDisplayed () {
        return isDisplayed(wrong);
    }
    public String wrongText () {
        return textShown(wrong);
    }

}
