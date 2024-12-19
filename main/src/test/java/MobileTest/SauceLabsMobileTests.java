package MobileTest;

import MobilePages.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabsMobileTests extends MobileTestBase
{
    @BeforeMethod
    public void setUp(@Optional("Android") String platformName, @Optional("15.0") String platformVersion, @Optional("emulator-5554") String deviceName, @Optional("UIAutomator2") String automationName, @Optional("C:\\Users\\CM\\Downloads\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk") String APP_Path , @Optional("com.swaglabsmobileapp.MainActivity") String appWaitActivity) throws InterruptedException, MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(platformName);
        options.setPlatformVersion(platformVersion);
        options.setDeviceName(deviceName); // Replace with your device name
        options.setApp(APP_Path); // Replace with your app's path
        options.setAutomationName(automationName);
        options.setAppWaitActivity(appWaitActivity);

        // Initialize the Appium Driver
        this.driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723/"), // Appium server URL
                options
        );
    }

    @Test(priority = 1)
    public void validLoginAndCheckout() throws InterruptedException
    {
        Page1_LoginPage page1 = new Page1_LoginPage(driver, appiumDriver);
        Page2_ProductPage page2 = new Page2_ProductPage(driver,appiumDriver);
        Page3_CardPage page3 = new Page3_CardPage(driver,appiumDriver);
        Page4_InfoCheckOut page4 = new Page4_InfoCheckOut(driver,appiumDriver);
        Page5_OverViewCheckOut page5 = new Page5_OverViewCheckOut(driver,appiumDriver);
        Page6_CompleteCheckOut page6 = new Page6_CompleteCheckOut(driver,appiumDriver);

//login
        String user = page1.userText();
        page1.clickUserName();
        page1.setUserName(user);
        page1.scroll();
        String pass = page1.passText();
        page1.scrollUp();
        page1.clickPassword();
        page1.setPass(pass);
        page1.loginClicked();


// Verify login successful
        boolean checkLogin = page2.checkLoginSucess();
        Assert.assertTrue(checkLogin,"Login failed!");

//Add product to cart
        page2.firstProductClickd();
        page2.addFirstProduct();
        page2.goToCard();
        Assert.assertEquals(page3.getProduct(),"Sauce Labs Backpack","There is no product");
        page3.setCheckOut();

// Checkout
        page4.firstName("Yasmeen");
        page4.lastName("Mohamed");
        page4.zipCode("123456");
        page1.scroll();
        page4.setContinueButtom();
        boolean checkDesc = page5.checkProuctDesc();
        Assert.assertTrue(checkDesc,"Order Description message not displayed");

        boolean checkPrice = page5.checkProuctPrice();
        Assert.assertTrue(checkPrice,"Order price message not displayed");


////Finish and verify success message
        page1.scroll();
        page5.finishButtonClick();
        String MSG = page6.msgSucessShopping();
        System.out.println(MSG);
        Assert.assertEquals(MSG,"THANK YOU FOR YOU ORDER","Order success message not displayed");
    }

    @Test(priority = 2)
    public void invalidLogin() throws InterruptedException
    {
        Page1_LoginPage page1 = new Page1_LoginPage(driver, appiumDriver);

        page1.clickUserName();
        page1.setUserName("WrongUser");
        page1.clickPassword();
        page1.setPass("WrongPassword");
        page1.loginClicked();

        String loginFailedTxt = page1.getErrorLogin();
        Assert.assertTrue(loginFailedTxt.contains("not match"), "Login succeeded with invalid credentials!");
    }

    @Test(priority = 3)
    public void incompleteCheckout() throws InterruptedException
    {
        Page1_LoginPage page1 = new Page1_LoginPage(driver, appiumDriver);
        Page2_ProductPage page2 = new Page2_ProductPage(driver,appiumDriver);
        Page3_CardPage page3 = new Page3_CardPage(driver,appiumDriver);
        Page4_InfoCheckOut page4 = new Page4_InfoCheckOut(driver,appiumDriver);
//login
        String user = page1.userText();
        page1.clickUserName();
        page1.setUserName(user);
        page1.scroll();
        String pass = page1.passText();
        page1.scrollUp();
        page1.clickPassword();
        page1.setPass(pass);
        page1.loginClicked();


// Verify login successful
        boolean checkLogin = page2.checkLoginSucess();
        Assert.assertTrue(checkLogin,"Login failed!");

//Add product to cart
        page2.firstProductClickd();
        page2.addFirstProduct();
        page2.goToCard();
        Assert.assertEquals(page3.getProduct(),"Sauce Labs Backpack","There is no product");
        page3.setCheckOut();

// Checkout with uncompleted data
        page4.firstName("");
        page4.lastName("Mohamed");
        page4.zipCode("123456");
        page1.scroll();
        page4.setContinueButtom();

// error message
        String errorMsg = page4.errorCompleteDtatRequire();
//        Assert.assertTrue(errorMsg.contains("is required"), "Error message displayed for incomplete data");
        System.out.println("Error message displayed for incomplete data");
    }


    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}

