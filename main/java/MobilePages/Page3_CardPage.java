package MobilePages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page3_CardPage extends PageBase{
    public Page3_CardPage(WebDriver driver, AppiumDriver appiumDriver) {
        super(driver, appiumDriver);
    }

    By poductCard = By.xpath("//android.widget.TextView[@text=\"Sauce Labs Backpack\"]");
    By checkOut = By.xpath("//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]");

    public String getProduct()
    {
        return getText(poductCard);
    }
    public void setCheckOut()
    {
        clickElement(checkOut);
    }
}
