package Fab_Application.HomeScreenTest;

import Fab_Application.Controller.HomeScreenTestManagers.verifyAllLinks.HomeScreen_AllLinks_Manager;
import Fab_Application.Controller.LoginTestManagers.verifyLoginWithValidCredentials.verifyLoginWithValidCredentials_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomeScreen_AllLinksAfterLogIn extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify all links present on the home page are working properly after logging in
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class, enabled = true, priority = 12)
    public void verifyAllLinksAfterLogIn(String mobile, String OTP) {

        try{
            logger = extent.startTest("verifyAllLinksAfterLogIn");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new verifyLoginWithValidCredentials_Manager().verifyLoginWithValidCredentials(driver,mobile, OTP, logger);
            new HomeScreen_AllLinks_Manager().verifyAllLinks(driver, logger);
            logger.log(LogStatus.PASS, "Successfully verified all the links are working fine.");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "Failed to verify all the links" + e.getMessage());
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}


