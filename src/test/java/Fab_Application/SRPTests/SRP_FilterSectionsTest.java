package Fab_Application.SRPTests;

/**
 * Created by Proteep Banerjee
 */

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

public class SRP_FilterSectionsTest extends BaseTestClass {

    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";

    public static WebDriver driver = null;

    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,
            enabled = true)
    public void FiltersAllSectionTest(String cityName, String checkInMonth, String checkInDate,
                                      String guestNum) throws IOException {
        try{
            logger = extent.startTest("Filters All Sections Presence test.");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new HomePage_Manager_withoutValidations().searchProperty(driver, cityName, checkInMonth,
                    checkInDate, guestNum, logger);
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
