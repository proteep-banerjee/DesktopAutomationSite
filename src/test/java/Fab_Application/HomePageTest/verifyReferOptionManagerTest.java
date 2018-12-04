package Fab_Application.HomePageTest;

import Fab_Application.Config.DeviceConfiguration;
import Fab_Application.Constants.Constants;
import Fab_Application.Controller.SplashScreenTest.verifyReferOption.verifyReferOption_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class verifyReferOptionManagerTest extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

//    //To verify user is redirected to enter mobile number for login
//    @Test(enabled = true)
//    public void verifyReferOption() {
//
//        try{
//            logger = extent.startTest("verifyReferOption_Manager");
//            driver = DriverHelper.initiateMwebBrowserInstance(browserName, firstServer, Constants.mobileWebCapabilities(DeviceConfiguration.DeviceName));
//            new verifyReferOption_Manager().verifyReferOption(driver, logger);
//            logger.log(LogStatus.PASS, "Successfully redirected to \"refer and earn\" page");
//        }
//        catch (Exception e){
//            logger.log(LogStatus.FAIL, " Failed to redirect user to \"refer and earn\" page" + e.getMessage());
//        }
//    }
//
//    @AfterClass
//    void tearDown(){
//        driver.quit();
//    }
}
