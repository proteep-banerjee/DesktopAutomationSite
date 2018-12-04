package Fab_Application.HomePageTest;

import Fab_Application.Config.DeviceConfiguration;
import Fab_Application.Constants.Constants;
import Fab_Application.Controller.SplashScreenTest.verifyGuestList.verifyGuestList_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class verifyGuestTest extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;
//
//    //To verify user can select number of guests while searching hotels
//    @Test(enabled = true)
//    public void verifyGuest() {
//
//        try{
//            logger = extent.startTest("verifyGuest");
//            driver = DriverHelper.initiateMwebBrowserInstance(browserName, firstServer, Constants.mobileWebCapabilities(DeviceConfiguration.DeviceName));
//            new verifyGuestList_Manager().verifyGuestList(driver, logger);
//            logger.log(LogStatus.PASS, "Successfully verified the Guest list");
//        }
//        catch (Exception e){
//            logger.log(LogStatus.FAIL, "Failed to verify the Guest List" + e.getMessage());
//        }
//    }
//
//    @AfterClass
//    void tearDown(){
//        driver.quit();
//    }
}
