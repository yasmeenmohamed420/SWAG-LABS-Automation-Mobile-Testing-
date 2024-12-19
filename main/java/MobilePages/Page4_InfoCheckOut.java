package MobilePages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page4_InfoCheckOut extends PageBase{
    public Page4_InfoCheckOut(WebDriver driver, AppiumDriver appiumDriver) {
        super(driver, appiumDriver);
    }

    By firstName = By.xpath("//android.widget.EditText[@content-desc=\"test-First Name\"]");
    By lastName = By.xpath("//android.widget.EditText[@content-desc=\"test-Last Name\"]");
    By zipCode = By.xpath("//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]");
    By continueButtom = By.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]");
    By errorCompleteData = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]\n");

    public void firstName(String text)
    {
        setText(firstName,text);
    }
    public void lastName(String text)
    {
        setText(lastName,text);
    }
    public void zipCode(String text)
    {
        setText(zipCode,text);
    }
    public void setContinueButtom()
    {
        clickElement(continueButtom);
    }
    public String errorCompleteDtatRequire()
    {
        return getText(errorCompleteData);
    }


}
