package Fab_Application.Controller.SplashScreenTest.verifyAListOption;

import Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM.AListOption;
import static Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM.guestList;
import static Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM.verifyAListOptionText;

public class verifyAListOptionTest_Manager {
    SoftAssert softAssert = new SoftAssert();

    public void verifyAListOption(WebDriver driver, ExtentTest logger) throws IOException {
        ReusableMethods.Click(driver, AListOption(driver, logger));
        String text = verifyAListOptionText(driver, logger);
        System.out.println("Text : "+text);
        //verifying
        if (text.contains("A-List")) {
            softAssert.assertTrue(true);
            softAssert.assertAll();
        } else {
            softAssert.assertTrue(false);
            softAssert.assertAll();
        }
    }
}
