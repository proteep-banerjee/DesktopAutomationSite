package Fab_Application.HomePageTest;

import Fab_Application.Config.DeviceConfiguration;
import Fab_Application.Constants.Constants;
import Fab_Application.Controller.SplashScreenTest.verifyLoginWithInvalidUsername.verifyLoginWithInvalidUsername_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class verifyLoginWithInvalidUsernameManagerTest extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify user will not be able to log-in with invalid username
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class, enabled = true)
    public void verifyLoginWithInvalidUsername(String mobile, String ExpectedOutput) {
        try{
            logger = extent.startTest("verifyLoginWithInvalidUsername_Manager");
            driver = DriverHelper.initiateMwebBrowserInstance(browserName, firstServer, Constants.mobileWebCapabilities(DeviceConfiguration.DeviceName));
            new verifyLoginWithInvalidUsername_Manager().verifyLoginWithInvalidUsername(driver, mobile, ExpectedOutput, logger);
            logger.log(LogStatus.PASS, "Successfully verified that user is not able to log-in if the incorrect username is given");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "Successfully logged-in which is not expected" + e.getMessage());
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
