package Fab_Application.Controller.SplashScreenTest.verifyLoginWithInvalidUsername;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.LoginScreen.LoginPage_POM.continueButton;
import static Fab_Application.Controller.POM.LoginScreen.LoginPage_POM.mobileNumberField;
import static Fab_Application.Controller.POM.LoginScreen.LoginPage_POM.verifyInvalidUserName;
import static Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM.LoginButton;

public class verifyLoginWithInvalidUsername_Manager {
    SoftAssert softAssert = new SoftAssert();

    public void verifyLoginWithInvalidUsername(WebDriver driver, String mobile, String ExpectedOutput , ExtentTest logger) throws IOException, InterruptedException {
        //clicking on login button
        ReusableMethods.Click(driver, LoginButton(driver, logger));
        //Entering Invalid mobile number
        ReusableMethods.type(driver, mobileNumberField(driver, logger), mobile);
        //Clicking continue button
        ReusableMethods.Click(driver, continueButton(driver, logger));
        String text = verifyInvalidUserName(driver, logger).getText();
        System.out.println(text);
        System.out.println(ExpectedOutput);
        if (text.equalsIgnoreCase(ExpectedOutput)) {
            softAssert.assertTrue(true);
            softAssert.assertAll();
        } else {
            softAssert.assertTrue(false);
            softAssert.assertAll();
        }
    }
}
