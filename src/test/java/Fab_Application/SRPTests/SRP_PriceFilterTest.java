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

public class SRP_PriceFilterTest extends BaseTestClass {

    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";


    public static WebDriver driver = null;

    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,
            enabled = true)
    public void PriceFilterTest(String MinimumDesiredPrice, String MaximumDesiredPrice, String cityName, String checkInMonth, String checkInDate) throws IOException {
        try{
            logger = extent.startTest("Price Filter Test");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new HomeScreenManager().Validate_TC(driver, cityName, checkInMonth, checkInDate, logger);
            new SRP_FilterTest_Manager().ValidateFilterPriceSlider(driver, logger, MinimumDesiredPrice, MaximumDesiredPrice);
            logger.log(LogStatus.PASS, "The prices have been verified successfully on SRP after filter.");
        }
        catch (Exception e){
            String img = ReusableMethods.captureScreenShot(driver);
            logger.log(LogStatus.FAIL, "Failed to validate prices after filter on SRP due to the following exception : " +
                    "<br>" + e.getMessage());
            logger.addScreenCapture(img);
        }
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
