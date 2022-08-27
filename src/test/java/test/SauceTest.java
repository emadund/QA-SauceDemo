package test;

import base.BaseSauce;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.*;

import java.util.Random;

public class SauceTest extends BaseSauce {
    private SauceDemoHome sauceDemoHome;
    private SauceInventory sauceInventory;
    private SauceCart sauceCart;
    private CheckOutPage checkOutPage;
    private CheckOutStep2 checkOutStep2;
    private CompletePage completePage;
    private String[] testNames = {"standard_user", "locked_out_user", "problem_user", "performance_glitch_user"};
    // initial usernames represented as Array of Strings
    private final String testPassword = "secret_sauce";
    // constant and unique password
    private Random rn = new Random();
    private int j = rn.nextInt(5) + 1; // defining random number between 1 and 6;


    @Before
    public void initialTest() {
        sauceDemoHome = new SauceDemoHome();
        sauceInventory = new SauceInventory();
        sauceCart = new SauceCart();
        checkOutPage = new CheckOutPage();
        checkOutStep2 = new CheckOutStep2();
        completePage = new CompletePage();

    }

    @Test

    public void negativeTestCase1() {
        sauceDemoHome.fillUsername("" + Math.random() * 10) //wrong username on purpose
                .fillPassword(testPassword)
                .clickLogin();
        Assert.assertTrue(sauceDemoHome.errorDisplaying());
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", sauceDemoHome.errorText());
        // This is first general negative test case with wrong username
    }

    @Test
    public void negativeTestCase2() {
        for (String x : testNames) {
            sauceDemoHome.fillUsername(x)
                    .fillPassword("" + Math.random() * 10)  //wrong password on purpose
                    .clickLogin();
            Assert.assertTrue(sauceDemoHome.errorDisplaying());
            Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", sauceDemoHome.errorText());
        }
        // 2nd general negative test case with wrong password

    }

    @Test
    public void negativeTestCase3() {
        sauceDemoHome.clickLogin();
        Assert.assertTrue(sauceDemoHome.errorDisplaying());
        Assert.assertEquals("Epic sadface: Username is required", sauceDemoHome.errorText());
        // 3rd general negative test case with both fields empty
    }

    @Test
    public void positiveTestCase1() {
        sauceDemoHome.fillUsername(testNames[0])  //testing 1st test username: standard_user
                .fillPassword(testPassword)
                .clickLogin();
             try {
        sauceInventory.clickItem(j); } //try to click on item, if it out of reach, scroll down
        // j is Random integer number between 1 and 6
        catch (Exception e) { sauceInventory.scrollDown();
            sauceInventory.clickItem(j); }
        finally {
        Assert.assertTrue(sauceInventory.basketDisplayed());
        Assert.assertEquals("1", sauceInventory.basketQuantity());
        // As requested in task, we picked up one Random item, put in cart and checked out if there is 1 chosen
        if (j == 1) // In Case random number is 1, we avoid next random choice to be 0
        {
            sauceInventory.clickItemDetails(++j); // In Case random number is 1, we avoid next random choice to be 0
        }
        else {
            sauceInventory.clickItemDetails(--j);}
            sauceInventory.addDetailedItem();
            Assert.assertEquals("2", sauceCart.cartQuantity());
            sauceInventory.clickBasket();
            Assert.assertTrue(sauceCart.firstItemDisplayed());
            Assert.assertTrue(sauceCart.secondItemDisplayed());
            sauceCart.removeFirstItem();
            sauceCart.clickCheckOut();
            checkOutPage.inputAllFields()
                    .clickContinue();
            Assert.assertTrue(checkOutStep2.checkTotal());
            checkOutStep2.goToOrder();
            Assert.assertTrue(completePage.completedDisplayed());
            Assert.assertEquals("THANK YOU FOR YOUR ORDER", completePage.completedText());
            Assert.assertTrue(completePage.messageDisplayed());
            Assert.assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!", completePage.messageText());
        }
             }


    @Test
    public void positiveTestCase2() {
        sauceDemoHome.fillUsername(testNames[1]) //testing 2nd username which outputs faulty results
                .fillPassword(testPassword)
                .clickLogin();
        Assert.assertTrue(sauceDemoHome.errorDisplaying());
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", sauceDemoHome.errorText());
    }
    // Second user cannot access further, we just check out error message
    @Test
    public void positiveTestCase3() {
            sauceDemoHome.fillUsername(testNames[2])  //testing 3rd test username: problem_user, picking up 1st and 2nd items
                    .fillPassword(testPassword)
                    .clickLogin();
            sauceInventory.clickItem(1);
            sauceInventory.clickItem(2);
            Assert.assertEquals("2", sauceInventory.basketQuantity());
                sauceInventory.clickBasket();
                Assert.assertTrue(sauceCart.firstItemDisplayed());
                Assert.assertTrue(sauceCart.secondItemDisplayed());
                sauceCart.removeFirstItem();
                Assert.assertEquals("1", sauceCart.cartQuantity());
                sauceCart.clickCheckOut();
                checkOutPage.inputAllFields()
                        .clickContinue();
                Assert.assertTrue(checkOutPage.wrongDisplayed());
                Assert.assertEquals("Error: Last Name is required", checkOutPage.wrongText());

        }
        @Test

    public void positiveTestCase4 () {
            sauceDemoHome.fillUsername(testNames[3])  /* testing 4th test username: performance_glitch_user
            this should work as first positive test cast only it is a little slower. It wouldn't work if we omit
            WebDriverWait wdWait object */
                    .fillPassword(testPassword)
                    .clickLogin();
            try {
                sauceInventory.clickItem(j); }
            catch (Exception e) { sauceInventory.scrollDown();
                sauceInventory.clickItem(j); }
            finally {
            Assert.assertTrue(sauceInventory.basketDisplayed());
            Assert.assertEquals("1", sauceInventory.basketQuantity());
            // As requested in task, we picked up one Random item, put in cart and checked out if there is 1 chosen
            if (j == 1) // In Case random number is 1, we avoid next random choice to be 0
            {
                sauceInventory.clickItem(++j);
            }
            else {
            sauceInventory.clickItemDetails(--j);
            sauceInventory.addDetailedItem();
            Assert.assertEquals("2", sauceCart.cartQuantity());
            sauceInventory.clickBasket();
            Assert.assertTrue(sauceCart.firstItemDisplayed());
            Assert.assertTrue(sauceCart.secondItemDisplayed());
            sauceCart.removeFirstItem();
            sauceCart.clickCheckOut();
            checkOutPage.inputAllFields()
                    .clickContinue();
            Assert.assertTrue(checkOutStep2.checkTotal());
            checkOutStep2.goToOrder();
            Assert.assertTrue(completePage.completedDisplayed());
            Assert.assertEquals("THANK YOU FOR YOUR ORDER", completePage.completedText());
            Assert.assertTrue(completePage.messageDisplayed());
            Assert.assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!", completePage.messageText());
        } } }

    @Test
        public void negativeTestCase4() { //Negative test case for Check out leaving First Name empty
            sauceDemoHome.fillUsername(testNames[0])
                    .fillPassword(testPassword)
                    .clickLogin();

            try {
            sauceInventory.clickItem(j); }
            catch (Exception e) { sauceInventory.scrollDown();
                sauceInventory.clickItem(j);}
            finally {
            Assert.assertTrue(sauceInventory.basketDisplayed());
            Assert.assertEquals("1", sauceInventory.basketQuantity());
            // As requested in task, we picked up one Random item, put in cart and checked out if there is 1 chosen
            if (j == 1) // In Case random number is 1, we avoid next random choice to be 0
            {
                sauceInventory.clickItem(++j);
            }
            else {

            sauceInventory.clickItemDetails(--j);
            sauceInventory.addDetailedItem();
            Assert.assertEquals("2", sauceCart.cartQuantity());
            sauceInventory.clickBasket();
            Assert.assertTrue(sauceCart.firstItemDisplayed());
            Assert.assertTrue(sauceCart.secondItemDisplayed());
            sauceCart.removeFirstItem();
            sauceCart.clickCheckOut();
            checkOutPage.inputLastName("Zikic")
                    .inputZipCode("37000")
            .clickContinue();
            Assert.assertTrue(checkOutPage.wrongDisplayed());
            Assert.assertEquals("Error: First Name is required", checkOutPage.wrongText());

        } } }
    @Test
    public void negativeTestCase5 () { //Negative test case for Check out leaving Last Name empty
        sauceDemoHome.fillUsername(testNames[0])
                .fillPassword(testPassword)
                .clickLogin();

        try {
        sauceInventory.clickItem(j); }
        catch (Exception e) {
            sauceInventory.scrollDown();
            sauceInventory.clickItem(j);
        }
        finally {
        Assert.assertTrue(sauceInventory.basketDisplayed());
        Assert.assertEquals("1", sauceInventory.basketQuantity());
        // As requested in task, we picked up one Random item, put in cart and checked out if there is 1 chosen
        if (j == 1) // In Case random number is 1, we avoid next random choice to be 0
        {
            sauceInventory.clickItem(++j);
        }
        else {
        sauceInventory.clickItemDetails(--j);
        sauceInventory.addDetailedItem();
        Assert.assertEquals("2", sauceCart.cartQuantity());
        sauceInventory.clickBasket();
        Assert.assertTrue(sauceCart.firstItemDisplayed());
        Assert.assertTrue(sauceCart.secondItemDisplayed());
        sauceCart.removeFirstItem();
        sauceCart.clickCheckOut();
        checkOutPage.inputFirstName("Zika")
                .inputZipCode("37000")
        .clickContinue();
        Assert.assertTrue(checkOutPage.wrongDisplayed());
        Assert.assertEquals("Error: Last Name is required", checkOutPage.wrongText());

    } } }
    @Test
    public void negativeTestCase6 () { //Negative test case for Check out leaving Zip code empty
        sauceDemoHome.fillUsername(testNames[0])
                .fillPassword(testPassword)
                .clickLogin();
        try {
        sauceInventory.clickItem(j); }
        catch (Exception e) { sauceInventory.scrollDown();
            sauceInventory.clickItem(j);}
        finally {
        Assert.assertTrue(sauceInventory.basketDisplayed());
        Assert.assertEquals("1", sauceInventory.basketQuantity());
        // As requested in task, we picked up one Random item, put in cart and checked out if there is 1 chosen
        if (j == 1) // In Case random number is 1, we avoid next random choice to be 0
        {
            sauceInventory.clickItem(++j);
        }
        else {
        sauceInventory.clickItemDetails(--j);
        sauceInventory.addDetailedItem();
        Assert.assertEquals("2", sauceCart.cartQuantity());
        sauceInventory.clickBasket();
        Assert.assertTrue(sauceCart.firstItemDisplayed());
        Assert.assertTrue(sauceCart.secondItemDisplayed());
        sauceCart.removeFirstItem();
        sauceCart.clickCheckOut();
        checkOutPage.inputLastName("Zikic")
                .inputFirstName("Zika")
        .clickContinue();
        Assert.assertTrue(checkOutPage.wrongDisplayed());
        Assert.assertEquals("Error: Postal Code is required", checkOutPage.wrongText());

    } } }

}












