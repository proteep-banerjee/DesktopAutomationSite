package Fab_Application.SRPTests;

import Fab_Application.Controller.SRPTestManagers.FilterTest.SRP_FilterTest_Manager;
import Fab_Application.Controller.SRPTestManagers.HomeScreen.HomeScreenManager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class SRP_CoupleFriendlyFilterTest extends BaseTestClass {

    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";

    public static WebDriver driver = null;

    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,
            enabled = true)
    public void CoupleFriendlyPolicyFilterTest(String cityName, String checkInMonth, String checkInDate) throws IOException {
        try{
            logger = extent.startTest("Couple Friendly Policy Filter Test");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new HomeScreenManager().Validate_TC(driver, cityName, checkInMonth,
                    checkInDate, logger);
            new SRP_FilterTest_Manager().ValidateCoupleFriendlyPolicyFilter(
                    driver, logger);
            logger.log(LogStatus.PASS, "The Couple Friendly tags have been verified " +
                    "successfully on SRP after filter.");
        }
        catch (Exception e){
            String img = ReusableMethods.captureScreenShot(driver);
            logger.log(LogStatus.FAIL, "Failed to validate Couple Friendly tags on SRP due to the following exception : " +
                    "<br>" + e.getMessage());
            logger.addScreenCapture(img);
        }
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
