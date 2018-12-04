package Fab_Application.SRPTests;

import Fab_Application.Config.DeviceConfiguration;
import Fab_Application.Constants.Constants;
import Fab_Application.Controller.SRPTestCases.HomeScreen.HomeScreenManager;
import Fab_Application.Controller.SRPTestCases.ValidateEditBoxText.SRP_ValidateEditBox_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class SRP_EditDetailsTest extends BaseTestClass {

    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";

    public static WebDriver driver = null;
//
//    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,
//            enabled = true)
//    public void EditBoxDetailsTest(String CityName, String checkInMonth, String checkInDate, String cityName,
//                                   String checkinDate, String checkoutDate,
//                                   String Guests) throws IOException {
//        try{
//            logger = extent.startTest("VerifyEditBoxDetails");
//            driver = DriverHelper.initiateMwebBrowserInstance(browserName, firstServer,
//                    Constants.mobileWebCapabilities(DeviceConfiguration.DeviceName));
//            new HomeScreenManager().Validate_TC(driver, CityName, checkInMonth, checkInDate, logger);
//            new SRP_ValidateEditBox_Manager().ValidateEditBoxDetails(driver,
//                    cityName, checkinDate, checkoutDate, Guests, logger);
//            logger.log(LogStatus.PASS, "Details in the edit box have been matched with searched details.");
//
//        }
//        catch (Exception e){
//            String img = ReusableMethods.captureScreenShot(driver);
//            logger.log(LogStatus.FAIL, "Failed to validate details due to the following exception : " +
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
