package Fab_Application.SampleTest;

import Fab_Application.Config.DeviceConfiguration;
import Fab_Application.Constants.Constants;
import Fab_Application.Controller.SampleManager.LoginPage.LoginPageManager;
import Fab_Application.Controller.SampleManager.SplashScreen.SplashScreen_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SampleTest extends BaseTestClass {

    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";

    private static WebDriver driver = null;

    @Test(priority = 0, enabled = true)
    public void loginButton() {

        try {
            logger = extent.startTest("Login Button");
            driver = DriverHelper.initiateMwebBrowserInstance(browserName, firstServer, Constants.mobileWebCapabilities(DeviceConfiguration.DeviceName));
            new SplashScreen_Manager().Validate_TC(driver, logger);
            logger.log(LogStatus.PASS, "User has been redirected to the login screen" +
                    " successfully.");

        }
        catch (Exception e) {
            logger.log(LogStatus.FAIL, "User could not be redirected to the login screen due to the following exception : " +
                    "<br>" + e.getMessage());
        }
    }

    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,
            enabled = true, priority = 1)
    public void loginFunctionalityTest(String MobileNumber, String OTP){

        try{
            logger = extent.startTest("Login Functionality Test");
            new LoginPageManager().Validate_TC(driver, MobileNumber, OTP, logger);
            logger.log(LogStatus.PASS, "User has logged in successfully and has been redirected to the home screen.");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "User failed to logged in due to the following exception : " +
                    "<br>" + e.getMessage());
        }
    }


    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
