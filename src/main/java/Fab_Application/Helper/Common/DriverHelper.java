package Fab_Application.Helper.Common;

import Fab_Application.Config.DriverConfiguration;
import Fab_Application.Constants.BrowserCapabilities;
import Fab_Application.Utilities.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.AUTOMATION_NAME;


public class DriverHelper {

    public static SoftAssert softAssert = new SoftAssert();

    public static final String CONFIGURATION_FILE_PATH = "Configurations/env_config.properties";


    public static WebDriver initiateBrowserInstance(String browserName, String ServerName, Map<String, Object> capablitiesList) throws InterruptedException {
        WebDriver driver = null;

        browserName = getValueOfProperty(CONFIGURATION_FILE_PATH, browserName);

        try{
            if (browserName.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", DriverConfiguration.chromeDriverPath);

                DesiredCapabilities capabilities = BrowserCapabilities.CapabilitiesList(capablitiesList, browserName);
                driver = new ChromeDriver(capabilities);

                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
                driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            } else {

                //import firefox options jars


            /*FirefoxOptions options = new FirefoxOptions()
                    .setProfile(new FirefoxProfile());
            driver = new FirefoxDriver(options);*/

            }
            String ServiceUrl = getValueOfProperty(CONFIGURATION_FILE_PATH, ServerName);
            driver.get(ServiceUrl);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Unable to open browser instance.");
            System.exit(-1);
        }

        return driver;

    }

     public static IOSDriver initiateIOSInstance(String PLATFORM_NAME, String DEVICE_NAME, String PLATFORM_VERSION, String APP) throws MalformedURLException {
        IOSDriver driver;
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        cap.setCapability("noReset", "false");
        cap.setCapability(MobileCapabilityType.APP, APP);
        cap.setCapability("avd",DEVICE_NAME);

        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new IOSDriver(url, cap);

        if (driver == null) {
            //ReportHelper.logValidationFailure("Driver not initiated properly", "AndroidDriver:  on LINUX (511dd936....", driver.toString(), "Driver initiation failure");
            Reporter.log("Driver failed to initiate having session id : - " + driver.getSessionId());
            Assert.assertTrue(false);
        }
        return driver;
    }


    public static AndroidDriver initiateAndroidHomeInstance(String PLATFORM_NAME, String DEVICE_NAME, String PLATFORM_VERSION,String AUTOMATION_NAME, String APP) {
        AndroidDriver driver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("deviceName", DEVICE_NAME);
        capabilities.setCapability("platformVersion", PLATFORM_VERSION);
        capabilities.setCapability("platformName", PLATFORM_NAME);
        capabilities.setCapability("automationName", AUTOMATION_NAME);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("newCommandTimeout", 0);
        capabilities.setCapability("app", APP);
        capabilities.setCapability("noReset", "true");
        //capabilities.setCapability("appPackage", "com.fabhotels.debug");
        //capabilities.setCapability("appActivity", "com.fabhotels.activity.OnboardingActivity");

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.get("fabHotels://app/");
            String img = ReusableMethods.captureScreenShot(driver);
            //logRequest(driver.toString(), "Pass", "Driver initiated properly");
        } catch (Exception e) {
            e.getStackTrace();
        }
        //System.out.println(driver.toString());
        return driver;
    }

    public static String getValueOfProperty(String filePath, String keyName) {
        try {
            Properties prop = new Properties();
            InputStream inpStream = null;
            inpStream = new FileInputStream(filePath);
            prop.load(inpStream);
            return prop.getProperty(keyName);
        } catch (IOException var4) {
            System.out.println(var4);
            return null;
        }
    }

}
