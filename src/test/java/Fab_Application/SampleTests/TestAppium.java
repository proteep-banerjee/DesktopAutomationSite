package Fab_Application.SampleTests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestAppium {

    AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("deviceName", "ZY3222K99L");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        capabilities.setCapability("app", System.getProperty("user.dir")+"/App/ChromeApp.apk");
        //capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(priority = 0)
    public void lauunchBrowser() throws InterruptedException {
//        Thread.sleep(15000);
        driver.get("https://uat.fabmailers.in");
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void login() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElementByXPath("//android.view.View[@text='LOGIN']").click();
        Thread.sleep(5000);
//        driver.findElementByClassName("android.widget.EditText").click();
//        Thread.sleep(5000);
        driver.findElementByClassName("android.widget.EditText").sendKeys("9818274287");
        Thread.sleep(2000);
        driver.hideKeyboard();
        Thread.sleep(5000);
        driver.findElementByClassName("android.widget.Button").click();
        Thread.sleep(5000);
        driver.findElementByXPath("//android.widget.EditText[contains(@text, 'OTP')]").sendKeys("123456");
        Thread.sleep(2000);
        driver.hideKeyboard();
        Thread.sleep(5000);
        driver.findElementByXPath("//android.widget.Button[@text='GET STARTED']").click();
        Thread.sleep(15000);
        driver.findElementByXPath("//android.view.View[contains(@text, 'FabHotels:')]").click();
        Thread.sleep(5000);

    }

    @Test(priority = 2)
    public void Search_Hotel() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElementById("gp-input").clear();
        Thread.sleep(7000);
        driver.findElementById("gp-input").sendKeys("New Delhi");
        Thread.sleep(4000);
        driver.hideKeyboard();
        Thread.sleep(5000);
//        driver.findElementByXPath("//android.view.View[@text='SEARCH']").click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
