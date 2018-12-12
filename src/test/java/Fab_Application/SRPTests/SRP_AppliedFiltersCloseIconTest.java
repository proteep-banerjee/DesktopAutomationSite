package Fab_Application.SRPTests;

import Fab_Application.Controller.HomePage.HomePage_Manager_withoutValidations;
import Fab_Application.Controller.SearchResultPage.SRPTest_Managers_withValidatons.SRP_FilterTest_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Proteep Banerjee
 */

public class SRP_AppliedFiltersCloseIconTest extends BaseTestClass {

    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";

    public static WebDriver driver = null;

    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,
            enabled = true)
    public void AppliedFiltersCloseIconTest(String cityName,
                                            String checkInMonth, String checkInDate, String guestNum) throws IOException {

        try{
            logger = extent.startTest("Applied Filters Close Icon Test");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new HomePage_Manager_withoutValidations().searchProperty(driver, cityName, checkInMonth,
                    checkInDate, guestNum, logger);
            new SRP_FilterTest_Manager().AppliedFiltersCloseIcon(driver, logger);
            logger.log(LogStatus.PASS, "Close Icon for filters on SRP have been verified " +
                    "successfully.");
        }
        catch (Exception e){
            String img = ReusableMethods.captureScreenShot(driver);
            logger.log(LogStatus.FAIL, "Failed to validate close Icon for filters on SRP due to the following exception : " +
                    "<br>" + e.getMessage());
            logger.addScreenCapture(img);
        }

    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

}
