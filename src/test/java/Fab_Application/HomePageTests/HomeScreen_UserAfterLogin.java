package Fab_Application.HomePageTests;

import Fab_Application.Controller.HomePage.HomePageTest_Manager_withValidations.HomeScreen_UserAfterLogin_Manager;
import Fab_Application.Controller.LoginPage.LoginPageTest_Manager_withValidations.verifyLoginWithValidCredentials_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomeScreen_UserAfterLogin extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify after login user's name is visible on welcome screen
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class, enabled = true)
    public void verifyUserNameOnWelcomePage(String mobile, String OTP, String TextOnWelcomeScreen) {
        try{
            System.out.println(TextOnWelcomeScreen);

            logger = extent.startTest("HomeScreen_UserAfterLogin_Manager");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new verifyLoginWithValidCredentials_Manager().verifyLoginWithValidCredentials(driver,mobile,OTP, logger);
            new HomeScreen_UserAfterLogin_Manager().verifyUserAfterLogin(driver, mobile, OTP, TextOnWelcomeScreen, logger);
            logger.log(LogStatus.PASS, "Successfully verified correct user information is displayed on the welcome page");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "Failed to verify user information on welcome page" + e.getMessage());
        }
    }
    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
