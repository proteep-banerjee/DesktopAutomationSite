package Fab_Application.HomePageTests;

import Fab_Application.Controller.HomePage.HomePageTest_Manager_withValidations.HomeScreen_Logout_Manager;
import Fab_Application.Controller.LoginPage.LoginPageTest_Manager_withValidations.verifyLoginWithValidCredentials_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomeScreen_Logout extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify on pressing logout button user is getting logged out
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class, enabled = true)
    public void verifyLogout(String mobile, String OTP, String ExpectedOutput) {

        try{
            logger = extent.startTest("HomeScreen_Logout_Manager");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new verifyLoginWithValidCredentials_Manager().verifyLoginWithValidCredentials(driver,mobile, OTP, logger);
            new HomeScreen_Logout_Manager().verifyLogout(driver, ExpectedOutput, logger);

            logger.log(LogStatus.PASS, "Successfully verified all the links are working fine.");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "Failed to verify all the links" + e.getMessage());
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
