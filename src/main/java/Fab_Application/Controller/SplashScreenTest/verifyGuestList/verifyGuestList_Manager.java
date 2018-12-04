package Fab_Application.Controller.SplashScreenTest.verifyGuestList;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class verifyGuestList_Manager {
    SoftAssert softAssert = new SoftAssert();
//
//    public void verifyGuestList(WebDriver driver, ExtentTest logger) throws InterruptedException, IOException {
//
//        ReusableMethods.selectByValue(driver, guestList(driver, logger), "5");
//        Thread.sleep(2000);
//
//        String option = ReusableMethods.GetFirstSelectedValue(driver, guestList(driver, logger)).getText();
//
//        if (option.equals("05")) {
//            logger.log(LogStatus.INFO, "Successfully verified number of guests");
//            softAssert.assertTrue(true);
//            softAssert.assertAll();
//        } else {
//            logger.log(LogStatus.INFO, "Failed to verify number of guests");
//            softAssert.assertTrue(false);
//            softAssert.assertAll();
//        }
//    }
}

