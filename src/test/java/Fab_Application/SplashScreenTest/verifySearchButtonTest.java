package Fab_Application.SplashScreenTest;

import Fab_Application.Config.DeviceConfiguration;
import Fab_Application.Constants.Constants;
import Fab_Application.Controller.SplashScreenTest.verifySearchButton.verifySearchButton_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class verifySearchButtonTest extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify user is redirected to SRP on clicking search button in the home page
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class, enabled = true)
    public void verifySearchButton(String location) {
        try{
            logger = extent.startTest("verifySearchButton");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new verifySearchButton_Manager().verifySearchButton(driver, location, logger);
            logger.log(LogStatus.PASS, "Successfully verified search button is working fine.");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "Failed to verify search button." + e.getMessage());
        }
    }
    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
