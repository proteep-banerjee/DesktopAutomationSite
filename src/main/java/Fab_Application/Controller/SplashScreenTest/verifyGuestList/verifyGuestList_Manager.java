package Fab_Application.Controller.SplashScreenTest.verifyGuestList;

import Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM.guestList;

public class verifyGuestList_Manager {
    SoftAssert softAssert = new SoftAssert();

    public void verifyGuestList(WebDriver driver, ExtentTest logger) throws InterruptedException, IOException {

        ReusableMethods.Click(driver,SplashScreen_POM.guestSelected(driver, logger));
        ReusableMethods.selectFromListByText(driver, guestList(driver, logger), "4 Guests" );
        Thread.sleep(2000);
        String guestSelected = SplashScreen_POM.guestSelected(driver, logger).getText();
        System.out.println("Guest selected : "+guestSelected);
        //verifying
        if (guestSelected.equals("4 Guests")) {
            softAssert.assertTrue(true);
            softAssert.assertAll();
        } else {
            softAssert.assertTrue(false);
            softAssert.assertAll();
        }
    }
}

