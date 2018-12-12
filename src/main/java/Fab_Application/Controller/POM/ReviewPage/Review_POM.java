package Fab_Application.Controller.POM.ReviewPage;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class Review_POM {

    public static WebElement GuestAndRoomDetails(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Review_GuestsAndRoomsDetails, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement PayNow(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Review_PayNow, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement PayAtHotel(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_payAtHotelButton, logger);
            System.out.println("pay @ found... ");
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement FullName(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Review_Name, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement Mobile(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Review_Mobile, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement Otp(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Review_Otp, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement ConfirmBooking(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Review_ConfirmBooking, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement TotalAmount(WebDriver driver, ExtentTest logger) throws IOException{

        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.Review_TotalAmount, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;

    }
   
    public static WebElement AmountToBePaid(WebDriver driver, ExtentTest logger) throws IOException{

        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.Review_AmountToBePaid, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;

    }

    public static WebElement appliedCoupon(WebDriver driver, ExtentTest logger) throws IOException{

        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.Review_appliedCoupon, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }
    
    public static WebElement couponDiscount(WebDriver driver, ExtentTest logger) throws IOException{

        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.Review_couponDiscount, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }
    
    public static WebElement promoPrice(WebDriver driver, ExtentTest logger) throws IOException{

        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.Review_promoPrice, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }
    
    public static List<WebElement> rackPrice(WebDriver driver, ExtentTest logger) throws IOException{

        List<WebElement> list = null;
        try{
        	//list = ReusableMethods.FindElements(driver,UiAddresses.rackPrice, logger);
        	list = driver.findElements(UiAddresses.Review_rackPrice);
            logger.log(LogStatus.PASS,  " List of desired elements Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return list;
    }
    
    public static WebElement discountedPrice(WebDriver driver, ExtentTest logger) throws IOException{

        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.Review_discountedPrice, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }
    
    public static WebElement GSTAmountApplied(WebDriver driver, ExtentTest logger) throws IOException{

        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.Review_GSTAmount, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }
    
    public static WebElement payableAmount(WebDriver driver, ExtentTest logger) throws IOException{

        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.Review_payableAmount, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }
    
    public static WebElement totalSavings(WebDriver driver, ExtentTest logger) throws IOException{

        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.Review_totalSavings, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }
    
    
    public static WebElement pointsToBeCredited(WebDriver driver, ExtentTest logger) throws IOException{

        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.Review_pointsToBeCredited, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }  
    
    public static WebElement removeCoupon(WebDriver driver, ExtentTest logger) throws IOException{

        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.Review_removeCoupon, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    } 
    
    public static WebElement applyCouponField(WebDriver driver, ExtentTest logger) throws IOException{

        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.Review_applyCouponField, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    } 
    
    public static WebElement applyCouponButton(WebDriver driver, ExtentTest logger) throws IOException{

        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.Review_applyCouponButton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    } 
    
    
}
