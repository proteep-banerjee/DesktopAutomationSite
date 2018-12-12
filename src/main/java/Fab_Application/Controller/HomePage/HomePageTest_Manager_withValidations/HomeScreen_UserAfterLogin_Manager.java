package Fab_Application.Controller.HomePage.HomePageTest_Manager_withValidations;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.LoginScreen.LoginPage_POM.verifyUserOnWelcomeScreen;

public class HomeScreen_UserAfterLogin_Manager {
    SoftAssert softAssert = new SoftAssert();

    //To verify after login user's name is visible on welcome screen
    public void verifyUserAfterLogin(WebDriver driver,String mobile, String OTP, String TextOnWelcomeScreen, ExtentTest logger) throws IOException, InterruptedException {
        //Verifying welcome screen messages
        String element = verifyUserOnWelcomeScreen(driver, logger);
        //Change Akku to Subrat in excel if running this TC on live
        System.out.println(element);
        System.out.println(TextOnWelcomeScreen);
        ReusableMethods.wait(1);
        if (element.contains(TextOnWelcomeScreen)) {
            softAssert.assertTrue(true);
            softAssert.assertAll();
        } else {
            softAssert.assertTrue(false);
            softAssert.assertAll();
        }
    }
}
