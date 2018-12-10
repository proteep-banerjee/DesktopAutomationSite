package Fab_Application.HomeScreenTest;

import Fab_Application.Controller.HomeScreenTestManagers.verifyCallOption.HomeScreen_CallOption_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomeScreen_CallOption extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify call option on top of the home page is showing correct mobile number
    @Test(enabled = true)
    public void verifyCallOption() {

        try{
            logger = extent.startTest("HomeScreen_CallOption");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new HomeScreen_CallOption_Manager().verifyCallOption(driver, logger);
            logger.log(LogStatus.PASS, "Successfully verified call option.");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "Failed to verify call option." + e.getMessage());
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
