package Fab_Application.HomePageTest;

import Fab_Application.Config.DeviceConfiguration;
import Fab_Application.Constants.Constants;
import Fab_Application.Controller.SplashScreenTest.verifyNearbyHotelTag.verifyNearbyHotelTag_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class verifyNearbyHotelTagManagerTest extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

//    //To verify nearby hotel tag is coming on home screen
//    @Test(enabled = true)
//    public void verifyNearbyHotelTag() {
//
//        try{
//            logger = extent.startTest("verifyNearbyHotelTag_Manager");
//            driver = DriverHelper.initiateMwebBrowserInstance(browserName, firstServer, Constants.mobileWebCapabilities(DeviceConfiguration.DeviceName));
//            new verifyNearbyHotelTag_Manager().verifyNearbyHotelTag(driver, logger);
//            logger.log(LogStatus.PASS, "Successfully verified all the links are working fine.");
//        }
//        catch (Exception e){
//            logger.log(LogStatus.FAIL, "Failed to verify all the links" + e.getMessage());
//        }
//    }
//
//    @AfterClass
//    void tearDown(){
//        driver.quit();
//    }
}
