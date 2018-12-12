package Fab_Application.LoginPageTests;

import Fab_Application.Controller.LoginPage.LoginPageTest_Manager_withValidations.verifyLoginWithInvalidUsername_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class LoginWithInvalidUsername extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify user will not be able to log-in with invalid username
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class, enabled = true)
    public void verifyLoginWithInvalidUsername(String mobile, String ExpectedOutput) {
        try{
            logger = extent.startTest("verifyLoginWithInvalidUsername_Manager");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
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
