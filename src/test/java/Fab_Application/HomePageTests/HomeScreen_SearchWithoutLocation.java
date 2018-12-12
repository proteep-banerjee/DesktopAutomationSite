package Fab_Application.HomePageTests;

import Fab_Application.Controller.HomePage.HomePageTest_Manager_withValidations.HomeScreen_SearchWithoutLocation_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomeScreen_SearchWithoutLocation extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify user is prompted to enter location during search if the same is not given
    @Test(enabled = true)
    public void verifySearchWithoutLocation() {
        try{
            logger = extent.startTest("HomeScreen_SearchWithoutLocation");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new HomeScreen_SearchWithoutLocation_Manager().verifySearchWithoutLocation(driver, logger);
            logger.log(LogStatus.PASS, "Successfully verified user is prompted to enter location if user is searching hotels without giving location");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "User not prompted to enter location which is not expected" + e.getMessage());
        }
    }
    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
