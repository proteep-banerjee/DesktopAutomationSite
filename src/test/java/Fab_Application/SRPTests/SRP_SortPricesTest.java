package Fab_Application.SRPTests;

import Fab_Application.Controller.SRPTestManagers.HomeScreen.HomeScreenManager;
import Fab_Application.Controller.SRPTestManagers.ValidateSorting.SRP_ValidateSorting_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class SRP_SortPricesTest extends BaseTestClass {

    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";

    public static WebDriver driver = null;

    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,
            enabled = true)
    public void lowToHighSortTest(String cityName, String checkInMonth, String checkInDate){
        try{
            logger = extent.startTest("High to low Sorting");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new HomeScreenManager().Validate_TC(driver, cityName, checkInMonth, checkInDate, logger);
            new SRP_ValidateSorting_Manager().verifyLowToHigh(driver,logger);
            logger.log(LogStatus.PASS, "The prices of all properties in the SRP screen" +
                    " have been verified to be sorted from high to low.");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "Failed to validate sorting of prices due to the following exception : " +
                    "<br>" + e.getMessage());
        }
    }


    @Test(enabled = true, dependsOnMethods = {"lowToHighSortTest"})
    public void highToLowSortTest() throws IOException {
        try{
            logger = extent.startTest("Low to high Sorting");
            new SRP_ValidateSorting_Manager().verifyHighToLow(driver,logger);
            logger.log(LogStatus.PASS, "The prices of all properties in the SRP screen" +
                    " have been verified to be sorted from low to high.");
        }
        catch (Exception e){
            String img = ReusableMethods.captureScreenShot(driver);
            logger.log(LogStatus.FAIL, "Failed to validate sorting of prices due to the following exception : " +
                    "<br>" + e.getMessage());
            logger.addScreenCapture(img);
        }
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
