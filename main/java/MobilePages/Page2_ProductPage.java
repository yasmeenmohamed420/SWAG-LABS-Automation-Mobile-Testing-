package MobilePages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page2_ProductPage extends PageBase{
    public Page2_ProductPage(WebDriver driver, AppiumDriver appiumDriver) {
        super(driver, appiumDriver);
    }

    By firstProduct = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]/android.view.ViewGroup/android.widget.ImageView");
    By addProduct = By.xpath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]\n");
    By prouctWord = By.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");
    By card = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");


    public void firstProductClickd()
    {
        clickElement(firstProduct);
    }
    public void addFirstProduct()
    {
        clickElement(addProduct);
    }
    public  boolean checkLoginSucess()
    {
        boolean checkLogin = isElementDisplayed(prouctWord);
        return  checkLogin;
    }
    public void goToCard()
    {
        clickElement(card);
    }
}
