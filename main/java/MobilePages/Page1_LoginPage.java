package MobilePages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page1_LoginPage extends PageBase{
    public Page1_LoginPage(WebDriver driver, AppiumDriver appiumDriver) {
        super(driver, appiumDriver);
    }

    By userNameLocator = By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]");
    By passwordLocator = By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
    By userNameText = By.xpath("//android.widget.TextView[@text=\"standard_user\"]\n");
    By passwordText = By.xpath("//android.widget.TextView[@text=\"secret_sauce\"]\n");
    By login = By.xpath("//android.widget.TextView[@text=\"LOGIN\"]\n");
    By loginError = By.xpath("//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]\n");

    public String userText()
    {
        return getText(userNameText);
    }
    public String passText()
    {
        return getText(passwordText);
    }
    public void clickUserName()
    {
        clickElement(userNameLocator);
    }
    public void clickPassword()
    {
        clickElement(passwordLocator);
    }
    public void setUserName(String text)
    {
        setText(userNameLocator,text);
    }
    public void setPass(String text)
    {
        setText(passwordLocator,text);
    }
    public void loginClicked()
    {
        clickElement(login);
    }

    public String getErrorLogin()
    {
        return getText(loginError);
    }

    public void scroll()
    {
        ((AndroidDriver) driver).findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
                )
        );
    }
    public void scrollUp() throws InterruptedException {

        ((AndroidDriver) driver).findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"
                )
        );
    }
}
