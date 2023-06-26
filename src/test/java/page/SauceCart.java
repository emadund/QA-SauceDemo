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
        super();
        PageFactory.initElements(driver, this);
    }

    public String cartQuantity () {

        return textShown(shoppingCart);
    }
    public boolean firstItemDisplayed () {

        return isDisplayed(removeItem1);
    }
    public boolean secondItemDisplayed () {

        return isDisplayed(removeItem2);
    }
    public void removeFirstItem () {
        clickOnButton(removeItem1);
    }
    public void clickCheckOut () {
        clickOnButton(checkOut);
    }

}
