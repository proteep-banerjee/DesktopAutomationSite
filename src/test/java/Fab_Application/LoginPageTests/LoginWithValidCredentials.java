package Fab_Application.LoginPageTests;

import Fab_Application.Controller.LoginPage.LoginPageTest_Manager_withValidations.verifyLoginWithValidCredentials_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class LoginWithValidCredentials extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify login with valid credentials
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class, enabled = true)
    public void verifyLoginWithValidCredentials(String mobile, String OTP) {
        try{
            logger = extent.startTest("verifyLoginWithValidCredentials_Manager");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new verifyLoginWithValidCredentials_Manager().verifyLoginWithValidCredentials(driver,mobile,OTP, logger);
            logger.log(LogStatus.PASS, "Successfully verified that user is able to log-in if correct credentials are given");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "Failed to login" + e.getMessage());
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
