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
        sauceDemoHome.fillUsername("" + Math.random() * 10); //wrong username on purpose
        sauceDemoHome.fillPassword(testPassword);
        sauceDemoHome.clickLogin();
        Assert.assertTrue(sauceDemoHome.errorDisplaying());
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", sauceDemoHome.errorText());
        // This is first general negative test case with wrong username
    }

    @Test
    public void negativeTestCase2() {
        for (String x : testNames) {
            sauceDemoHome.fillUsername(x);
            sauceDemoHome.fillPassword("" + Math.random() * 10); //wrong password on purpose
            sauceDemoHome.clickLogin();
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
        firstAndFourthTest(testNames[0]);

             }


    @Test
    public void positiveTestCase2() {
        sauceDemoHome.fillUsername(testNames[1]); //testing 2nd username which outputs faulty results
        sauceDemoHome.fillPassword(testPassword);
        sauceDemoHome.clickLogin();
        Assert.assertTrue(sauceDemoHome.errorDisplaying());
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", sauceDemoHome.errorText());
    }
    // Second user cannot access further, we just check out error message
    @Test
    public void positiveTestCase3() {
        sauceDemoHome.fillUsername(testNames[2]);  //testing 3rd test username: problem_user, picking up 1st and 2nd items
        sauceDemoHome.fillPassword(testPassword);
        sauceDemoHome.clickLogin();
        sauceInventory.clickItem(1);
        sauceInventory.clickItem(2);
        Assert.assertEquals("2", sauceInventory.basketQuantity());
        sauceInventory.clickBasket();
        Assert.assertTrue(sauceCart.firstItemDisplayed());
        Assert.assertTrue(sauceCart.secondItemDisplayed());
        sauceCart.removeFirstItem();
        Assert.assertEquals("1", sauceCart.cartQuantity());
        sauceCart.clickCheckOut();
        checkOutPage.inputAllFields();
        checkOutPage.clickContinue();
        Assert.assertTrue(checkOutPage.wrongDisplayed());
        Assert.assertEquals("Error: Last Name is required", checkOutPage.wrongText());

        }
        @Test

    public void positiveTestCase4 () {
            firstAndFourthTest(testNames[3]);
    }

    @Test
        public void negativeTestCase4() { //Negative test case for Check out leaving First Name empty
        sauceDemoHome.fillUsername(testNames[0]);
        sauceDemoHome.fillPassword(testPassword);
        sauceDemoHome.clickLogin();

            try {
            sauceInventory.clickItem(j); }
            catch (Exception e) { sauceInventory.scrollDownInventory();
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
            checkOutPage.inputLastName("Zikic");
            checkOutPage.inputZipCode("37000");
            checkOutPage.clickContinue();
            Assert.assertTrue(checkOutPage.wrongDisplayed());
            Assert.assertEquals("Error: First Name is required", checkOutPage.wrongText());

        } } }
    @Test
    public void negativeTestCase5 () { //Negative test case for Check out leaving Last Name empty
        sauceDemoHome.fillUsername(testNames[0]);
        sauceDemoHome.fillPassword(testPassword);
        sauceDemoHome.clickLogin();

        try {
        sauceInventory.clickItem(j); }
        catch (Exception e) {
            sauceInventory.scrollDownInventory();
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
        checkOutPage.inputFirstName("Zika");
        checkOutPage.inputZipCode("37000");
        checkOutPage.clickContinue();
        Assert.assertTrue(checkOutPage.wrongDisplayed());
        Assert.assertEquals("Error: Last Name is required", checkOutPage.wrongText());

    } } }
    @Test
    public void negativeTestCase6 () { //Negative test case for Check out leaving Zip code empty
        sauceDemoHome.fillUsername(testNames[0]);
        sauceDemoHome.fillPassword(testPassword);
        sauceDemoHome.clickLogin();
        try {
        sauceInventory.clickItem(j); }
        catch (Exception e) { sauceInventory.scrollDownInventory();
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
        checkOutPage.inputLastName("Zikic");
        checkOutPage.inputFirstName("Zika");
        checkOutPage.clickContinue();
        Assert.assertTrue(checkOutPage.wrongDisplayed());
        Assert.assertEquals("Error: Postal Code is required", checkOutPage.wrongText());

    } } }

    private void firstAndFourthTest(String x) {
        sauceDemoHome.fillUsername(x);  //testing 1st test username: standard_user
        sauceDemoHome.fillPassword(testPassword);
        sauceDemoHome.clickLogin();
        try {
            sauceInventory.clickItem(j); } //try to click on item, if it out of reach, scroll down
        // j is Random integer number between 1 and 6
        catch (Exception e) { sauceInventory.scrollDownInventory();
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
            checkOutPage.inputAllFields();
            checkOutPage.clickContinue();
            Assert.assertTrue(checkOutStep2.checkTotal());
            checkOutStep2.goToOrder();
            Assert.assertTrue(completePage.completedDisplayed());
            Assert.assertEquals("Thank you for your order!", completePage.completedText());
            Assert.assertTrue(completePage.messageDisplayed());
            Assert.assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!", completePage.messageText());
        }
    }

}












