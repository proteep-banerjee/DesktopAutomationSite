package Fab_Application.Controller.SplashScreenTest.verifyLoginWithValidCredentials;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.LoginScreen.LoginPage_POM.*;
import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.*;

public class verifyLoginWithValidCredentials_Manager {
    SoftAssert softAssert = new SoftAssert();

//    public void verifyLoginWithValidCredentials(WebDriver driver, String mobile, String OTP, ExtentTest logger) throws IOException, InterruptedException {
//        //clicking on login button
//        ReusableMethods.Click(driver, LoginButton(driver, logger));
//        //Entering mobile number
//        ReusableMethods.type(driver, mobileNumberField(driver, logger), mobile);
//        //Clicking continue button
//        ReusableMethods.Click(driver, continueButton(driver, logger));
//        //Entering OTP
//        ReusableMethods.type(driver, otpField(driver, logger), OTP);
//        //clicking getting started button
//        ReusableMethods.Click(driver, getStartedButton(driver, logger));
//        //verifying login page
//        String text = verifyLoginPage(driver, logger).getText();
//        if (text.contains("Welcome")) {
//            softAssert.assertTrue(true);
//            softAssert.assertAll();
//        } else {
//            softAssert.assertTrue(false);
//            softAssert.assertAll();
//        }
//    }
}
