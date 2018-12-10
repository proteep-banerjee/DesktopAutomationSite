package Fab_Application.HomeScreenTest;

import Fab_Application.Controller.LoginTestManagers.verifyLoginWithValidCredentials.verifyLoginWithValidCredentials_Manager;
import Fab_Application.Controller.HomeScreenTestManagers.verifyUserType.HomeScreen_UserType_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomeScreen_UserType extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify after login, type of user should be blue OR silver OR gold OR platinum
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class, enabled = true)
    public void verifyUserType(String mobile, String OTP) {

        try{
            logger = extent.startTest("HomeScreen_UserType");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new verifyLoginWithValidCredentials_Manager().verifyLoginWithValidCredentials(driver,mobile, OTP, logger);
            new HomeScreen_UserType_Manager().verifyUserType(driver, logger);
            logger.log(LogStatus.PASS, "Successfully verified user type");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "Failed to verify user type" + e.getMessage());
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
