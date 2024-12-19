package MobilePages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page6_CompleteCheckOut extends PageBase{
    public Page6_CompleteCheckOut(WebDriver driver, AppiumDriver appiumDriver) {
        super(driver, appiumDriver);
    }

    By msgSucessShopping = By.xpath("//android.widget.TextView[@text=\"THANK YOU FOR YOU ORDER\"]");

    public String msgSucessShopping()
    {
        return getText(msgSucessShopping);
    }
}
