package Fab_Application.HomePageTest;

import Fab_Application.Config.DeviceConfiguration;
import Fab_Application.Constants.Constants;
import Fab_Application.Controller.SplashScreenTest.verifyCheckInAndCheckOutDateNotSame.verifyCheckInAndCheckOutDateNotSame_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class verifyCheckInAndCheckOutDateNotSameManagerTest extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;
//
//    //To verify checkin and check out should not be same
//    @Test(enabled = true)
//    public void verifyCheckInAndCheckOutDateNotSame() {
//
//        try{
//            logger = extent.startTest("verifyCheckInAndCheckOutDateNotSame_Manager");
//            driver = DriverHelper.initiateMwebBrowserInstance(browserName, firstServer, Constants.mobileWebCapabilities(DeviceConfiguration.DeviceName));
//            new verifyCheckInAndCheckOutDateNotSame_Manager().verifyCheckInAndCheckOutDateNotSame(driver, logger);
//            logger.log(LogStatus.PASS, "Successfully verified Check-In and Check-Out dates are not same");
//        }
//        catch (Exception e){
//            logger.log(LogStatus.FAIL, "Failed to verify Check-In and Check-Out dates are not same" + e.getMessage());
//        }
//    }
//
//    @AfterClass
//    void tearDown(){
//        driver.quit();
//    }
}
