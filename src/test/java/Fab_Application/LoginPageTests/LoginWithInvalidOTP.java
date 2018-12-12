package Fab_Application.LoginPageTests;

import Fab_Application.Controller.LoginPage.LoginPageTest_Manager_withValidations.verifyLoginWithInvalidOTP_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class LoginWithInvalidOTP extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify user will not be able to log-in with invalid OTP
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class, enabled = true)
    public void verifyLoginWithInvalidOTP(String mobile, String OTP, String ExpectedOutput) {
        try{
            logger = extent.startTest("verifyLoginWithInvalidOTP_Manager");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new verifyLoginWithInvalidOTP_Manager().verifyLoginWithInvalidOTP(driver, mobile, OTP, ExpectedOutput, logger);
            logger.log(LogStatus.PASS, "Successfully verified that user is not able to log-in if the incorrect OTP is given");
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
