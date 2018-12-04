package Fab_Application.Controller.POM.LoginScreen;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginPage_POM {

    public static WebElement googleLogin(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_googleLogin, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement facebookLogin(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_facebookLogin, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement mobileNumberField(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_mobileNumberField,logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement continueButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_continueButton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement otpField(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            //going to click elemy
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_otpField, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement getStartedButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_getStartedButton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

//    public static WebElement homeButton(WebDriver driver, ExtentTest logger) throws IOException {
//        WebElement element = null;
//
//        try{
//            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_homeButton, logger);
//            logger.log(LogStatus.PASS, element.getText() + " : Found");
//
//        } catch (Exception e) {
//            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
//            System.out.println(e.getMessage());
//            Assert.assertTrue(false);
//        }
//
//        return element;
//    }

//    public static WebElement verifyLoginPage(WebDriver driver, ExtentTest logger) throws IOException {
//        WebElement element = null;
//
//        try{
//            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_verifyLoginPage1, logger);
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//            Assert.assertTrue(false);
//        }
//
//        return element;
//    }

    public static WebElement verifyInvalidUserName(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_invalidUsername, logger);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement verifyInvalidOTP(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_invalidOTP, logger);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

//    public static List<WebElement> verifyLogin(WebDriver driver,ExtentTest logger) throws IOException{
//
//        List<WebElement> elementList = new ArrayList<>();
//
//        try{
//            elementList = ReusableMethods.FindElements(driver, UiAddresses.splashScreen_PersonIcon, logger);
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//            Assert.assertTrue(false);
//        }
//        return elementList;
//
//    }

//    public static WebElement clickingToggleButton(WebDriver driver, ExtentTest logger) throws IOException {
//        WebElement element = null;
//
//        try{
//            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_toggleButton, logger);
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//            Assert.assertTrue(false);
//        }
//        return element;
//    }

//    public static List<String> verifyUserOnWelcomeScreen(WebDriver driver, ExtentTest logger) throws IOException {
//        List<String> element = new ArrayList<String>();
//        try{
//            element.add(ReusableMethods.FindElement(driver, UiAddresses.loginScreen_verifyLoginPage1, logger).getText());
//            ReusableMethods.Click(driver,clickingToggleButton(driver,logger));
//            Thread.sleep(2000);
//            element.add(ReusableMethods.FindElement(driver, UiAddresses.loginScreen_verifyLoginPage2, logger).getText());
//            return element;
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//            Assert.assertTrue(false);
//            return null;
//        }
//    }

    public static WebElement logoutButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_LogoutButton, logger);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement logoutPopup(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_logoutPopUp, logger);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

}
