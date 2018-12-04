package Fab_Application.SplashScreenTest;

import Fab_Application.Controller.SplashScreenTest.verifyGuestList.verifyGuestList_Manager;
import Fab_Application.Controller.SplashScreenTest.verifyLoginSideTabs.verifyLoginSideTabs_Manager;
import Fab_Application.Controller.SplashScreenTest.verifyLoginWithValidCredentials.verifyLoginWithValidCredentials_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class verifyLoginSideTabsTest extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify that after login side tabs (my booking, profile, fab credits and A-membership) are getting redirected to the correct pages
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class, enabled = true)
    public void verifyLoginSideTabs(String mobile, String OTP) {

        try{
            logger = extent.startTest("verifyLoginSideTabsTest");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new verifyLoginWithValidCredentials_Manager().verifyLoginWithValidCredentials(driver,mobile, OTP, logger);
            new verifyLoginSideTabs_Manager().verifyLoginSideTabs(driver, logger);
            logger.log(LogStatus.PASS, "Successfully verified on Log-In page side tabs are working fine.");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "Failed to verify side tabs on the Log-In page." + e.getMessage());
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
