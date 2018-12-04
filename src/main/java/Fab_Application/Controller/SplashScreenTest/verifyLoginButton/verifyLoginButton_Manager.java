package Fab_Application.Controller.SplashScreenTest.verifyLoginButton;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.LoginButton;

public class verifyLoginButton_Manager {
    SoftAssert softAssert = new SoftAssert();

//    public void verifyLoginButton(WebDriver driver, ExtentTest logger) throws IOException {
//        //clicking on login button
//        ReusableMethods.Click(driver, LoginButton(driver, logger));
//        //verifying login page appears or not
//        WebElement text = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_login_SignUpText,logger);
//        System.out.println(text.getText());
//        if(text.getText().contains("Log In/Sign Up")) {
//            softAssert.assertTrue(true);
//            softAssert.assertAll();
//        } else {
//            softAssert.assertTrue(false);
//            softAssert.assertAll();
//        }
//    }
}
