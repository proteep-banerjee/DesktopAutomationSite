package Fab_Application.SRPTests;

import Fab_Application.Config.DeviceConfiguration;
import Fab_Application.Constants.Constants;
import Fab_Application.Controller.SRPTestCases.HomeScreen.HomeScreenManager;
import Fab_Application.Controller.SRPTestCases.ValidateRatings.SRP_ValidateRatings_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class SRP_RatingsTest extends BaseTestClass {

    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";

    public static WebDriver driver = null;
//
//    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,
//            enabled = true)
//    public void RatingsTest(String cityName, String checkInMonth, String checkInDate) throws IOException {
//        try{
//            logger = extent.startTest("Ratings Test");
//            driver = DriverHelper.initiateMwebBrowserInstance(browserName,
//                    firstServer, Constants.mobileWebCapabilities
//                            (DeviceConfiguration.DeviceName));
//            new HomeScreenManager().Validate_TC(driver, cityName, checkInMonth, checkInDate, logger);
//            new SRP_ValidateRatings_Manager().ValidatePropertyRatings(driver, logger);
//            logger.log(LogStatus.PASS, "The ratings have been verified successfully on SRP");
//        }
//        catch (Exception e){
//            String img = ReusableMethods.captureScreenShot(driver);
//            logger.log(LogStatus.FAIL, "Failed to validate ratings on SRP due to the following exception : " +
//                    "<br>" + e.getMessage());
//            logger.addScreenCapture(img);
//        }
//    }
//
//    @AfterClass
//    public void teardown(){
//        driver.quit();
//    }
}
