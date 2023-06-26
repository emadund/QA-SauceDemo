package page;

import base.BaseSauce;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutStep2 extends BaseSauce {
    @FindBy (className = "summary_subtotal_label")
    WebElement totalItem;
    @FindBy (css = "[data-test=\"finish\"]")
    WebElement finito;

public CheckOutStep2 () {
    super();
    PageFactory.initElements(driver, this);
}
public boolean checkTotal () {
    return isDisplayed(totalItem);
}
public void goToOrder () {
    clickOnButton(finito);
}

}
