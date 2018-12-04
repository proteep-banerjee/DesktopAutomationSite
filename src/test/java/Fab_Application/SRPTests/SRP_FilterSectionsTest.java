package Fab_Application.SRPTests;

import Fab_Application.Config.DeviceConfiguration;
import Fab_Application.Constants.Constants;
import Fab_Application.Controller.SRPTestCases.FilterTest.SRP_FilterTest_Manager;
import Fab_Application.Controller.SRPTestCases.HomeScreen.HomeScreenManager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class SRP_FilterSectionsTest extends BaseTestClass {

    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";

    public static WebDriver driver = null;

    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,
            enabled = true)
    public void FiltersAllSectionTest(String cityName, String checkInMonth, String checkInDate) throws IOException {
        try{
            logger = extent.startTest("Filters All Sections Presence test.");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new HomeScreenManager().Validate_TC(driver, cityName, checkInMonth,
                    checkInDate, logger);
            new SRP_FilterTest_Manager().ValidateAllSectionsFilter(driver, logger);
            logger.log(LogStatus.PASS, "Presence of all the sections in the filters have been verified " +
                    "successfully.");
        }
        catch (Exception e){
            String img = ReusableMethods.captureScreenShot(driver);
            logger.log(LogStatus.FAIL, "Failed to validate presence of all the sections in the filters due to the following exception : " +
                    "<br>" + e.getMessage());
            logger.addScreenCapture(img);
        }
    }


    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
