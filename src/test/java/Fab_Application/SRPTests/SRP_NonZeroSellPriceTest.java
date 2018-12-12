package Fab_Application.SRPTests;

/**
 * Created by Proteep Banerjee
 */

import Fab_Application.Controller.HomePage.HomePage_Manager_withoutValidations;
import Fab_Application.Controller.SearchResultPage.SRPTest_Managers_withValidatons.SRP_ValidatePrice_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class SRP_NonZeroSellPriceTest extends BaseTestClass {

    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";

    public static WebDriver driver = null;

    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class, enabled = true)
    public void nonZeroPriceTest(String cityName, String checkInMonth, String checkInDate,
                                 String guestNum){

        try{
            logger = extent.startTest("Non zero price Test");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new HomePage_Manager_withoutValidations().searchProperty(driver, cityName, checkInMonth,
                    checkInDate, guestNum, logger);
            new SRP_ValidatePrice_Manager().Validate_TC(driver, logger);
            logger.log(LogStatus.PASS, "The prices of all properties in the SRP screen" +
                    " have been verified to be non zero.");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "Failed to validate prices due to the following exception : " +
                    "<br>" + e.getMessage());
        }
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
