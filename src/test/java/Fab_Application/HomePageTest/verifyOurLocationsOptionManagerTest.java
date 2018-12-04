package Fab_Application.HomePageTest;

import Fab_Application.Config.DeviceConfiguration;
import Fab_Application.Constants.Constants;
import Fab_Application.Controller.SplashScreenTest.verifyOurLocationsOption.verifyOurLocationsOption_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class verifyOurLocationsOptionManagerTest extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;
//
//    //To verify "Our Locations" option on the home screen gives number of locations
//    @Test(enabled = true)
//    public void verifyOurLocationsOption() {
//        try {
//            logger = extent.startTest("verifyOurLocationsOption_Manager");
//            driver = DriverHelper.initiateMwebBrowserInstance(browserName, firstServer, Constants.mobileWebCapabilities(DeviceConfiguration.DeviceName));
//            new verifyOurLocationsOption_Manager().verifyOurLocationsOption(driver, logger);
//
//            logger.log(LogStatus.PASS, "Successfully verified that Our locations option is displaying all the valid locations.");
//        } catch (Exception e) {
//            logger.log(LogStatus.FAIL, "Failed to verify Our locations option on the home page" + e.getMessage());
//        }
//    }
//
//    @AfterClass
//    void tearDown(){
//        driver.quit();
//    }
}
