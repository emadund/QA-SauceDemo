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
    PageFactory.initElements(driver, this);
}
 public void clickItem (int i) {

    switch (i) {
        case 1: wdWait.until(ExpectedConditions.elementToBeClickable(itemCart1));
        itemCart1.click(); break;
        case 2: wdWait.until(ExpectedConditions.elementToBeClickable(itemCart2));
            itemCart2.click(); break;
        case 3: wdWait.until(ExpectedConditions.elementToBeClickable(itemCart3));
            itemCart3.click(); break;
        case 4: wdWait.until(ExpectedConditions.elementToBeClickable(itemCart4));
            itemCart4.click(); break;
        case 5: wdWait.until(ExpectedConditions.elementToBeClickable(itemCart5));
            itemCart5.click(); break;
        case 6: wdWait.until(ExpectedConditions.elementToBeClickable(itemCart6));
            itemCart6.click(); break;
    }
    // Method for choosing one among 6 items
}

    public void clickItemDetails (int i) {

        switch (i) {
            case 1: wdWait.until(ExpectedConditions.elementToBeClickable(item1));
                item1.click(); break;
            case 2: wdWait.until(ExpectedConditions.elementToBeClickable(item2));
                item2.click(); break;
            case 3: wdWait.until(ExpectedConditions.elementToBeClickable(item3));
                item3.click(); break;
            case 4: wdWait.until(ExpectedConditions.elementToBeClickable(item4));
                item4.click(); break;
            case 5: wdWait.until(ExpectedConditions.elementToBeClickable(item5));
                item5.click(); break;
            case 6: wdWait.until(ExpectedConditions.elementToBeClickable(item6));
                item6.click(); break;
        }
        //Method for choosing one among 6 items and clicking on its image
}
public void addDetailedItem () {
       wdWait.until(ExpectedConditions.elementToBeClickable(addToCartItem));
       addToCartItem.click();
}
public void clickBasket () {
    wdWait.until(ExpectedConditions.elementToBeClickable(basket));
    basket.click();
}
public boolean basketDisplayed () {
    wdWait.until(ExpectedConditions.visibilityOf(basket));
    return basket.isDisplayed();
}
public String basketQuantity () {
    wdWait.until(ExpectedConditions.elementToBeClickable(basket));
    return basket.getText();
}

    public void scrollDown() {
        js.executeScript("window.scrollBy(0,200)");
        wdWait.until(ExpectedConditions.elementToBeClickable(itemCart5));
    }


}
