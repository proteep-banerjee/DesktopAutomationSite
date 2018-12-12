package Fab_Application.HomePageTests;

import Fab_Application.Controller.HomePage.HomePageTest_Manager_withValidations.HomeScreen_AllLinks_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomeScreen_AllLinksBeforeLogin extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify all links before log-in are working
    @Test(enabled = true)
    public void verifyAllLinks() {
        int count = 0;
        try{
            logger = extent.startTest("HomeScreen_AllLinks_Manager");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new HomeScreen_AllLinks_Manager().verifyAllLinks(driver, logger);
            logger.log(LogStatus.PASS, "Successfully verified all the links");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "Failed to verify all the links" + e.getMessage());
            logger.log(LogStatus.FAIL, count+" links are not working");

        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
