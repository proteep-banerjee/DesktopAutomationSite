package Fab_Application.HomeScreenTest;

import Fab_Application.Controller.LoginTestManagers.verifyLoginWithValidCredentials.verifyLoginWithValidCredentials_Manager;
import Fab_Application.Controller.HomeScreenTestManagers.verifySocialMediaLinks.HomeScreen_SocialMediaLinks_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomeScreen_SocialMediaLinks extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify social media links are working fine or not
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class, enabled = true)
    public void verifySocialMediaLinks(String  mobile, String OTP) {
        try {
            logger = extent.startTest("verifySocialMediaLinks");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new verifyLoginWithValidCredentials_Manager().verifyLoginWithValidCredentials(driver,mobile,OTP, logger);
            new HomeScreen_SocialMediaLinks_Manager().verifySocialMediaLinks(driver, logger);

            logger.log(LogStatus.PASS, "Successfully verified all the socila media links");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Failed to verify social media links " + e.getMessage());
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
