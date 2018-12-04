package Fab_Application.Controller.SplashScreenTest.verifyUserNameOnWelcomePage;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

import static Fab_Application.Controller.POM.LoginScreen.LoginPage_POM.verifyUserOnWelcomeScreen;

public class verifyUserNameOnWelcomePage_Manager {
    SoftAssert softAssert = new SoftAssert();

    public void verifyUserNameOnWelcomePage(WebDriver driver,String mobile, String OTP, String TextOnWelcomeScreen, ExtentTest logger) throws IOException, InterruptedException {
        //Verifying welcome screen messages
        String element = verifyUserOnWelcomeScreen(driver, logger);
        //Change Akku to Subrat in excel if running this TC on live
        System.out.println(element);
        System.out.println(TextOnWelcomeScreen);
        Thread.sleep(1000);
        if (element.contains(TextOnWelcomeScreen)) {
            softAssert.assertTrue(true);
            softAssert.assertAll();
        } else {
            softAssert.assertTrue(false);
            softAssert.assertAll();
        }
    }
}
