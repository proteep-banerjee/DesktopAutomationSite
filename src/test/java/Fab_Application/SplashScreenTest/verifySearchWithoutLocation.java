package Fab_Application.SplashScreenTest;

import Fab_Application.Config.DeviceConfiguration;
import Fab_Application.Constants.Constants;
import Fab_Application.Controller.SplashScreenTest.verifySearchWithoutLocation.verifySearchWithoutLocation_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class verifySearchWithoutLocation extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify user is prompted to enter location during search if the same is not given
    @Test(enabled = true)
    public void verifySearchWithoutLocation() {
        try{
            logger = extent.startTest("verifySearchWithoutLocation");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new verifySearchWithoutLocation_Manager().verifySearchWithoutLocation(driver, logger);
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
