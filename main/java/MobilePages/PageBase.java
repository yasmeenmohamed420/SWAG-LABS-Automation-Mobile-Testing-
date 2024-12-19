package MobilePages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class PageBase {


    AppiumDriver appiumDriver;
    WebDriver driver;
    WebDriverWait wait;

    Actions act;
    Select select;
    public PageBase(WebDriver driver ,AppiumDriver appiumDriver) {

        this.driver = driver;
        this.appiumDriver = appiumDriver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        act=new Actions(this.driver);

    }


    public void setText(By locator, String text) {
      WebElement el= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
       el.clear();
       el.sendKeys(text);
    }
    public void clickElement(By locator) {
        WebElement el= wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
    }


    public void mouseOverElement(By locator) {
        WebElement el= wait.until(ExpectedConditions.elementToBeClickable(locator));
          act.moveToElement(el).perform();
    }


    public boolean isElementDisplayed(By locator) {
        WebElement el= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
       return el.isDisplayed();
    }


    public void rightClickOnElement(By locator) {
        WebElement el= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        act.contextClick(el).perform();
    }

    public void switchAlertAndAccept() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void selectFromDropdownList(By locator,String value) {
        WebElement el= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
       select=new Select(el);
        select.selectByValue(value);
    }
    private boolean isAttribtuePresent(By locator, String attribute) {
        Boolean result = false;
        WebElement el= wait.until(ExpectedConditions.elementToBeClickable(locator));
        try {
            String value = el.getAttribute(attribute);
            if (value != null){
                result = true;
            }
        } catch (Exception e) {}

        return result;
    }


    public void switchToOtherWindowTap(){

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

      //  driver.switchTo().window(driver.getWindowHandles().iterator().next());
    }


    public String getText(By locator) {
        WebElement el= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return el.getText();
    }

}
