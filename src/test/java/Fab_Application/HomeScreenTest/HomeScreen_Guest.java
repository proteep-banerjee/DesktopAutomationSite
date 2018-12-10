package Fab_Application.HomeScreenTest;

import Fab_Application.Controller.HomeScreenTestManagers.verifyGuestList.HomeScreen_GuestList_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomeScreen_Guest extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify user can select number of guests while searching hotels
    @Test(enabled = true)
    public void verifyGuest() {

        try{
            logger = extent.startTest("verifyGuest");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new HomeScreen_GuestList_Manager().verifyGuestList(driver, logger);
            logger.log(LogStatus.PASS, "Successfully verified the Guest list");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "Failed to verify the Guest List" + e.getMessage());
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
