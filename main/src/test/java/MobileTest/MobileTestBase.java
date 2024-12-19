package MobileTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileTestBase {

    public AppiumDriver appiumDriver;
    public  WebDriver driver;
    @BeforeTest
    @Parameters({"platformName","platformVersion","deviceName","automationName","APP_Path","appWaitActivity"})
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


    @AfterTest
    public void tearDown()
    {
        this.driver.quit();
    }
}
