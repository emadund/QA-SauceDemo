package page;

import base.BaseSauce;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SauceCart extends BaseSauce {
    @FindBy (className = "shopping_cart_badge")
    WebElement shoppingCart;
    @FindBy (xpath = "(//*[contains(@class,\"btn btn_secondary btn_small cart_button\")])[1]")
    WebElement removeItem1;
    //Locating item number in square brackets mentioned in xpath locator (1)
    @FindBy (xpath = "(//*[contains(@class,\"btn btn_secondary btn_small cart_button\")])[2]")
    WebElement removeItem2;
    //Locating item number in square brackets mentioned in xpath locator (2)
    @FindBy (css = ".btn.btn_action.btn_medium.checkout_button")
    WebElement checkOut;


    public SauceCart () {
        PageFactory.initElements(driver, this);
    }

    public String cartQuantity () {
        wdWait.until(ExpectedConditions.elementToBeClickable(shoppingCart));
        return shoppingCart.getText();
    }
    public boolean firstItemDisplayed () {
        wdWait.until(ExpectedConditions.elementToBeClickable(removeItem1));
        return removeItem1.isDisplayed();
    }
    public boolean secondItemDisplayed () {
        wdWait.until(ExpectedConditions.elementToBeClickable(removeItem2));
        return removeItem2.isDisplayed();
    }
    public void removeFirstItem () {
        wdWait.until(ExpectedConditions.elementToBeClickable(removeItem1));
        removeItem1.click();
    }
    public void clickCheckOut () {
        wdWait.until(ExpectedConditions.elementToBeClickable(checkOut));
        checkOut.click();

    }

}
