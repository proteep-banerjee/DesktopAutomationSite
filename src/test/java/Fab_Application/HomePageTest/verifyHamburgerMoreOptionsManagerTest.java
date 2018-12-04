package Fab_Application.HomePageTest;

import Fab_Application.Config.DeviceConfiguration;
import Fab_Application.Constants.Constants;
import Fab_Application.Controller.SplashScreenTest.verifyHamburgerMoreOptions.verifyHamburgerMoreOptions_Manager;
import Fab_Application.Controller.SplashScreenTest.verifyLoginWithValidCredentials.verifyLoginWithValidCredentials_Manager;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import Fab_Application.Helper.Common.BaseTestClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class verifyHamburgerMoreOptionsManagerTest extends BaseTestClass{
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

//    //To verify hamburger more options
//    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class, enabled = true)
//    public void verifyHamburgerMoreOptions(String mobile, String OTP) {
//        try {
//            logger = extent.startTest("verifyHamburgerMoreOptions_Manager");
//            driver = DriverHelper.initiateMwebBrowserInstance(browserName, firstServer, Constants.mobileWebCapabilities(DeviceConfiguration.DeviceName));
//            new verifyLoginWithValidCredentials_Manager().verifyLoginWithValidCredentials(driver,mobile, OTP, logger);
//            new verifyHamburgerMoreOptions_Manager().verifyHamburgerMoreOptions(driver, logger);
//
//            logger.log(LogStatus.PASS, "Successfully verified all options in the \"more option button\" on the hamburger.");
//        } catch (Exception e) {
//            logger.log(LogStatus.FAIL, "Failed to verify all options on the hamburger's \"More options\"" + e.getMessage());
//        }
//    }
//
//    @AfterClass
//    void tearDown(){
//        driver.quit();
//    }
}
