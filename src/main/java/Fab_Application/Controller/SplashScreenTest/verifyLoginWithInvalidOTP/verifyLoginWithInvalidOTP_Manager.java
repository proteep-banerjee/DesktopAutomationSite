package Fab_Application.Controller.SplashScreenTest.verifyLoginWithInvalidOTP;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.LoginScreen.LoginPage_POM.*;
import static Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM.LoginButton;

public class verifyLoginWithInvalidOTP_Manager {
    SoftAssert softAssert = new SoftAssert();

    public void verifyLoginWithInvalidOTP(WebDriver driver, String mobile, String OTP, String ExpectedOutput , ExtentTest logger) throws IOException, InterruptedException {
        //clicking on login button
        ReusableMethods.Click(driver, LoginButton(driver, logger));
        //Entering valid mobile number
        ReusableMethods.type(driver, mobileNumberField(driver, logger), mobile);
        //Clicking continue button
        ReusableMethods.Click(driver, continueButton(driver, logger));
        //Entering invalid OTP
        ReusableMethods.type(driver, otpField(driver, logger), OTP);
        //Clicking on Getting started button
        ReusableMethods.Click(driver, getStartedButton(driver, logger));
        //Verifying expected output with actual output
        String text = verifyInvalidOTP(driver, logger).getText();
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
