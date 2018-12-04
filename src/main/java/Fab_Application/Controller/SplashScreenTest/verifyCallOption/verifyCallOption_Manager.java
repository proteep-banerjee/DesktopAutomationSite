package Fab_Application.Controller.SplashScreenTest.verifyCallOption;

import Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM.callOption;
import static Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM.guestList;

public class verifyCallOption_Manager {
    SoftAssert softAssert = new SoftAssert();

    public void verifyCallOption(WebDriver driver, ExtentTest logger) throws InterruptedException, IOException {
        String number = callOption(driver, logger).getText();
        System.out.println(number);
        if (number.contains("+91 70 4242 4242")) {
            System.out.println("Successfully verified call option");
            softAssert.assertTrue(true);
            softAssert.assertAll();
        } else {
            System.out.println("Failed to verify call option");
            softAssert.assertTrue(false);
            softAssert.assertAll();
        }
    }
}
