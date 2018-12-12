package Fab_Application.HomePageTests;

import Fab_Application.Controller.HomePage.HomePageTest_Manager_withValidations.HomeScreen_MenuTopOptions_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomeScreen_MenuTopOptions extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify top menu options Refer a friend, Corporate enquiry and Be our franchise options are giving correct pages on clicking
    @Test(enabled = true)
    public void verifyMenuTopOptions() {

        try{
            logger = extent.startTest("HomeScreen_MenuTopOptions_Manager");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new HomeScreen_MenuTopOptions_Manager().verifyMenuTopOptions(driver, firstServer, logger);
            logger.log(LogStatus.PASS, "Successfully redirected to \"refer and earn\" page");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, " Failed to redirect user to \"refer and earn\" page" + e.getMessage());
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
