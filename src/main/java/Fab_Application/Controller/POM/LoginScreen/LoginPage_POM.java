package Fab_Application.Controller.POM.LoginScreen;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

@SuppressWarnings("ConstantConditions")
public class LoginPage_POM {

    public static WebElement googleLogin(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_googleLogin, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
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
            Assert.fail();
        }

        return element;
    }

    public static WebElement mobileNumberField(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_mobileNumberField,
                    logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
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
            Assert.fail();
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
            Assert.fail();
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
            Assert.fail();
        }

        return element;
    }

    public static WebElement homeButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_homeButton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static WebElement verifyLoginPage(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_verifyLoginPage, logger);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static WebElement verifyInvalidUserName(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_invalidUsername, logger);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.fail();
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
            Assert.fail();
        }
        return element;
    }

    public static WebElement clickingToggleButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_toggleButton, logger);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.fail();
        }
        return element;
    }

    public static String verifyUserOnWelcomeScreen(WebDriver driver, ExtentTest logger) throws IOException {
        String element;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_verifyLoginPage, logger).getText();
            return element;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.fail();
            return null;
        }
    }

    public static WebElement logoutButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_logoutButton, logger);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.fail();
        }
        return element;
    }


    public static WebElement logoutPopup(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_logoutPopup, logger);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.fail();
        }
        return element;
    }

    public static WebElement bookingSideTab(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_bookingSideTab, logger);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.fail();
        }
        return element;
    }

    public static WebElement profileSideTab(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_profileSideTab, logger);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.fail();
        }
        return element;
    }

    public static WebElement fabCreditsSideTab(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_fabCreditsSideTab, logger);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.fail();
        }
        return element;
    }

    public static WebElement AListMembershipSideTab(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_AListMemebershipSideTab, logger);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.fail();
        }
        return element;
    }


}
