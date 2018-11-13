package Fab_Application.Controller.BookingFlow.LoginPage;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class LoginPage_POM {

    public static WebElement googleLogin(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_googleLogin, logger, "Google Login Button");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement facebookLogin(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_facebookLogin, logger, "Facebook Login Button");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement mobileNumberField(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_mobileNumberField,
                    logger, "mobile Number Field");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement continueButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_continueButton, logger, "Continue Button");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement otpField(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            //going to click elemy
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_otpField, logger, "OTP Field");

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement getStartedButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_getSatrtedButton, logger, "Get Started Button");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement homeButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_homeButton, logger, "Home Button");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

}
