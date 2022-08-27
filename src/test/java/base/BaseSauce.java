package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

@After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
    // Shutdown browsers after tests finished
}
