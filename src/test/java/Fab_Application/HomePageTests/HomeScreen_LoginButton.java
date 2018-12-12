package Fab_Application.HomePageTests;

import Fab_Application.Controller.HomePage.HomePageTest_Manager_withValidations.HomeScreen_LoginButton_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomeScreen_LoginButton extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify on pressing login button user is redirected to login page
    @Test(enabled = true)
    public void verifyLoginButton() {
        try{
            logger = extent.startTest("HomeScreen_LoginButton_Manager");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new HomeScreen_LoginButton_Manager().verifyLoginButton(driver, logger);
            logger.log(LogStatus.PASS, "Successfully verified that user is redirected to login page after clicking login button");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "User is not redirected to login page on clicking login button" + e.getMessage());
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
