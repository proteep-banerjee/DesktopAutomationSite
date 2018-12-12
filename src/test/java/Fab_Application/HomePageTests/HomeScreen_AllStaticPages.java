package Fab_Application.HomePageTests;

import Fab_Application.Controller.HomePage.HomePageTest_Manager_withValidations.HomeScreen_AllStaticPages_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomeScreen_AllStaticPages extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify all static links are redirected to expected pages
    @Test(enabled = true)
    public void verifyAllStaticPages() {
        try {
            logger = extent.startTest("verifyAllStaticPages");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new HomeScreen_AllStaticPages_Manager().verifyAllStaticPages(driver, logger);
            logger.log(LogStatus.PASS, "Successfully verified all the static links are getting redirected to correct pages");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Failed to verify all static links " + e.getMessage());
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
