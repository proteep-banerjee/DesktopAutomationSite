package Fab_Application.HomeScreenTest;

import Fab_Application.Controller.HomeScreenTestManagers.verifyCalendarDatesNotSame.HomeScreen_CalendarDatesNotSame_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HomeScreen_CalendarDatesNotSame extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify check in and check out cannot be same
    @Test(enabled = true)
    public void CalendarDatesNotSame() {

        try{
            logger = extent.startTest("HomeScreen_CalendarDatesNotSame");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            new HomeScreen_CalendarDatesNotSame_Manager().CalendarDatesNotSame(driver, logger);
            logger.log(LogStatus.PASS, "Successfully verified Check-In and Check-Out dates cannot be same");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "Failed to verify Check-In and Check-Out dates are not same" + e.getMessage());
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
