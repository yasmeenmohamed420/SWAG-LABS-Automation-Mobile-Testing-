package MobilePages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page5_OverViewCheckOut extends PageBase{
    public Page5_OverViewCheckOut(WebDriver driver, AppiumDriver appiumDriver) {
        super(driver, appiumDriver);
    }

    By productPrice = By.xpath("//android.widget.TextView[@text=\"$29.99\"]");
    By productDesc = By.xpath("//android.widget.TextView[@text=\"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.\"]");
    By finishButton = By.xpath("//android.widget.TextView[@text=\"FINISH\"]");

    public void finishButtonClick()
    {
        clickElement(finishButton);
    }
    public boolean checkProuctDesc()
    {
        return isElementDisplayed(productDesc);
    }

    public boolean checkProuctPrice()
    {
        return isElementDisplayed(productPrice);
    }
}
