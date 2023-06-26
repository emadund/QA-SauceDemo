package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.SauceDemoHome;

import java.io.File;

public class BaseSauce {

    protected static WebDriver driver;
    protected static WebDriverWait wdWait;

    protected static JavascriptExecutor js;
//* main Objects for page abstraction defined

@Before

public void initialSetup () {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-notifications"); //in case of alerters or banners and for JS scrolling
    driver = new ChromeDriver(options);
    js = (JavascriptExecutor)driver;
    wdWait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
    driver.manage().window().maximize();
    driver.get("https://www.saucedemo.com/");

}
    public void fillTextField (String text, WebElement w) {
        wdWait.until(ExpectedConditions.elementToBeClickable(w));
        w.clear();
        w.sendKeys(text);
    }
    public void clickOnButton (WebElement w) {
        wdWait.until(ExpectedConditions.elementToBeClickable(w));
        w.click();
    }
    public boolean isDisplayed (WebElement w) {
        wdWait.until(ExpectedConditions.visibilityOf(w));
        return w.isDisplayed();
    }
    public String textShown (WebElement w) {
        wdWait.until(ExpectedConditions.visibilityOf(w));
        return w.getText();
    }
    public void scrollDown(WebElement w) {
        js.executeScript("window.scrollBy(0,200)");
        wdWait.until(ExpectedConditions.elementToBeClickable(w));
    }
/*
@After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
    // Shutdown browsers after tests finished */
}
