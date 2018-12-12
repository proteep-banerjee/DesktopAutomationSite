package Fab_Application.HomePageTests;

import Fab_Application.Controller.HomePage.HomePageTest_Manager_withValidations.HomeScreen_SearchAutoSuggestions_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomeScreen_SearchAutoSuggestions extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify search field autosuggestion is giving correct suggestions as per the input
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class, enabled = true)
    public void verifyAutoSuggestionsInSearchFieldTest(String location) {

        try{
            logger = extent.startTest("HomeScreen_SearchAutoSuggestions");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new HomeScreen_SearchAutoSuggestions_Manager().verifyAutoSuggestionsInSearchField(driver,location, logger);
            logger.log(LogStatus.PASS, "Successfully verified that Search field is giving correct suggestions as per the input");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "Failed to verify search field autosuggestion." + e.getMessage());
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
