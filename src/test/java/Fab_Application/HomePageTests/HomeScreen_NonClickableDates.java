package Fab_Application.HomePageTests;

import Fab_Application.Controller.HomePage.HomePageTest_Manager_withValidations.HomeScreen_NonClickableDates_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomeScreen_NonClickableDates extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify user can not select date before current date
    @Test(enabled = true)
    public void verifyDateBeforeCurrentNotSelectable() {

        try{
            logger = extent.startTest("HomeScreen_NonClickableDates_Manager");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new HomeScreen_NonClickableDates_Manager().verifyNonClickableDates(driver, logger);
            logger.log(LogStatus.PASS, "Successfully verified dates before current date are non selectable");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "Failed to verify dates before current date are non selectable" + e.getMessage());
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
