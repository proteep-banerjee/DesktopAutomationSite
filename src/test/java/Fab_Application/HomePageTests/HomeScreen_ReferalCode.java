package Fab_Application.HomePageTests;

import Fab_Application.Controller.HomePage.HomePageTest_Manager_withValidations.HomeScreen_ReferalCode_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomeScreen_ReferalCode extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify 'your referal code' option is showing some referal code
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,enabled = true)
    public void verifyReferalCode(String mobile, String OTP) {
        try {
            logger = extent.startTest("verifyReferalCodeAndSocialMediaLinks");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new HomeScreen_ReferalCode_Manager().verifyReferalCode(driver, mobile, OTP, logger);

            logger.log(LogStatus.PASS, "Successfully verified 'your referal code' option is showing some referal code.");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Failed to verify referal code option " + e.getMessage());
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
