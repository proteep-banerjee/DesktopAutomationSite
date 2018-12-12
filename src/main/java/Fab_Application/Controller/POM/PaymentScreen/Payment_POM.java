package Fab_Application.Controller.POM.PaymentScreen;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

import static Fab_Application.Constants.UiAddresses.*;

/*
Created By Bhupesh Mehta on 18-Nov-2018
 */
public class Payment_POM {

    public static WebElement mobileNumber_Field(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try {
            element = ReusableMethods.FindElement(driver, MobileNumber_Field, logger);
            System.out.println(element.getText());
            logger.log(LogStatus.PASS, element.getText() + " : Mobile Number Field Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement fullName_Field(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try {
            element = ReusableMethods.FindElement(driver, fullName_Field, logger);
            System.out.println(element.getText());
            logger.log(LogStatus.PASS, element.getText() + " : Full Name Field Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement email_Field(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try {
            element = ReusableMethods.FindElement(driver, email_Field, logger);
            System.out.println(element.getText());
            logger.log(LogStatus.PASS, element.getText() + " : Email Field Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement gst_CheckBox(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try {
            element = ReusableMethods.FindElement(driver, gst_CheckBox, logger);
            System.out.println(element.getText());
            logger.log(LogStatus.PASS, element.getText() + " : GST CheckBox Button Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement GSTNumber(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try {
            element = ReusableMethods.FindElement(driver, GST_Number, logger);
            System.out.println(element.getText());
            logger.log(LogStatus.PASS, element.getText() + " : GST Number Field Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement companyName(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try {
            element = ReusableMethods.FindElement(driver, companyNameField, logger);
            System.out.println(element.getText());
            logger.log(LogStatus.PASS, element.getText() + " : Company Name Field Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement companyAddress(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try {
            element = ReusableMethods.FindElement(driver, companyAddressField, logger);
            System.out.println(element.getText());
            logger.log(LogStatus.PASS, element.getText() + " : Company Address Field Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement CreditCard(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try {
            element = ReusableMethods.FindElement(driver, CreditCardOption, logger);
            System.out.println(element.getText());
            logger.log(LogStatus.PASS, element.getText() + " : Debit Card Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement CreditCardNumber(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try {
            element = ReusableMethods.FindElement(driver, CreditCardNumberField, logger);
            System.out.println(element.getText());
            logger.log(LogStatus.PASS, element.getText() + " : Debit/Credit Number Field Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement monthYear(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try {
            element = ReusableMethods.FindElement(driver, monthYearField, logger);
            System.out.println(element.getText());
            logger.log(LogStatus.PASS, element.getText() + " : MM Drop Down List Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement CreditCardCvvNumber(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try {
            element = ReusableMethods.FindElement(driver, CreditCardCvv, logger);
            System.out.println(element.getText());
            logger.log(LogStatus.PASS, element.getText() + " : CVV Number Field Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement fullName_Card(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try {
            element = ReusableMethods.FindElement(driver, fullName_Card, logger);
            System.out.println(element.getText());
            logger.log(LogStatus.PASS, element.getText() + " : Full Name on Debit/Credit Card Field Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement Pay(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try {
            element = ReusableMethods.FindElement(driver, payField, logger);
            System.out.println(element.getText());
            logger.log(LogStatus.PASS, element.getText() + " : Pay Securely Button Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement netBankingOption(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try {
            element = ReusableMethods.FindElement(driver, netBanking, logger);
            System.out.println(element.getText());
            logger.log(LogStatus.PASS, element.getText() + " : NetBanking Button Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }
    public static WebElement PaytmOption(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try {
            element = ReusableMethods.FindElement(driver, paytm, logger);
            System.out.println(element.getText());
            logger.log(LogStatus.PASS, element.getText() + " : Wallet Button Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }
    
    public static WebElement paytmRadioButton(WebDriver driver, ExtentTest logger) throws IOException{

        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.paytmRadiobutton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }
    
    public static WebElement paytmloginLink(WebDriver driver, ExtentTest logger) throws IOException{

        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.loginLink, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }
    
    public static WebElement paytmLoginField(WebDriver driver, ExtentTest logger) throws IOException{

        WebElement element = null;
        try{
        	driver.switchTo().frame("login-iframe");
        	
            element = ReusableMethods.FindElement(driver,UiAddresses.loginField, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }
    
    public static WebElement paytmPasswordField(WebDriver driver, ExtentTest logger) throws IOException{

        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.passwordField, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }
    
    public static WebElement paytmSecureLogin(WebDriver driver, ExtentTest logger) throws IOException{

        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.secureLogin, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }
    
    public static WebElement paytmWalletPayNow(WebDriver driver, ExtentTest logger) throws IOException{

        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.walletPayNow, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }
    

}
