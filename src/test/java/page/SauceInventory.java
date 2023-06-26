package page;

import base.BaseSauce;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SauceInventory extends BaseSauce {

    @FindBy (id="add-to-cart-sauce-labs-backpack")
    WebElement itemCart1;
    @FindBy (id="add-to-cart-sauce-labs-bike-light")
    WebElement itemCart2;
    @FindBy (id="add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement itemCart3;
    @FindBy (id="add-to-cart-sauce-labs-fleece-jacket")
    WebElement itemCart4;
    @FindBy (id="add-to-cart-sauce-labs-onesie")
    WebElement itemCart5;
    @FindBy (id="add-to-cart-test.allthethings()-t-shirt-(red)")
    WebElement itemCart6;
    // Locating elements for adding items to cart
    @FindBy (css = "[alt=\"Sauce Labs Backpack\"]")
    WebElement item1;
    @FindBy (css ="[alt=\"Sauce Labs Bike Light\"]" )
    WebElement item2;
    @FindBy (css = "[alt=\"Sauce Labs Bolt T-Shirt\"]")
    WebElement item3;
    @FindBy (css ="[alt=\"Sauce Labs Fleece Jacket\"]" )
    WebElement item4;
    @FindBy (css = "[alt=\"Sauce Labs Fleece Jacket\"]")
    WebElement item5;
    @FindBy (css ="[alt=\"Test.allTheThings() T-Shirt (Red)\"]" )
    WebElement item6;
    // Locating item images
   @FindBy (css = "[class=\"shopping_cart_badge\"]")
    WebElement basket;
   @FindBy (css = "[class=\"btn btn_primary btn_small btn_inventory\"]")
   WebElement addToCartItem;
   //Adding any item from detailed page



public SauceInventory () {

    super();
    PageFactory.initElements(driver, this);
}
 public void clickItem (int i) {

    switch (i) {
        case 1: clickOnButton(itemCart1); break;
        case 2: clickOnButton(itemCart2); break;
        case 3: clickOnButton(itemCart3); break;
        case 4: clickOnButton(itemCart4); break;
        case 5: clickOnButton(itemCart5); break;
        case 6: clickOnButton(itemCart6); break;
    }
    // Method for choosing one among 6 items
}

    public void clickItemDetails (int i) {

        switch (i) {
            case 1: clickOnButton(item1); break;
            case 2: clickOnButton(item1); break;
            case 3: clickOnButton(item1); break;
            case 4: clickOnButton(item1); break;
            case 5: clickOnButton(item1); break;
            case 6: clickOnButton(item1); break;
        }
        //Method for choosing one among 6 items and clicking on its image
}
public void addDetailedItem () {
       clickOnButton(addToCartItem);
}
public void clickBasket () {
    clickOnButton(basket);
}
public boolean basketDisplayed () {
    return isDisplayed(basket);
}
public String basketQuantity () {
    wdWait.until(ExpectedConditions.elementToBeClickable(basket));
    return textShown(basket);
}

    public void scrollDownInventory() {
        scrollDown(itemCart5);
    }


}
