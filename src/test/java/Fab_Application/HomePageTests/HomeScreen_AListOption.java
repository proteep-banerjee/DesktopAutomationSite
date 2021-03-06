package Fab_Application.HomePageTests;

import Fab_Application.Controller.HomePage.HomePageTest_Manager_withValidations.HomeScreen_AListOptionTest_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomeScreen_AListOption extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    @Test(enabled = true)
    public void verifyAListOption() {
        try {
            logger = extent.startTest("verifyAListOption");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new HomeScreen_AListOptionTest_Manager().verifyAListOption(driver, logger);

            logger.log(LogStatus.PASS, "Successfully verified A-List option is redirecting user to the correct page.");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Failed to verify A-List option on the home page " + e.getMessage());
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
