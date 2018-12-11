package Fab_Application.Controller.POM.PropertyDetailPage;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import static Fab_Application.Constants.UiAddresses.*;


public class PDP_POM {

    public static WebElement BookNowButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            String childWindow = "";
            Set<String> windowHandles = driver.getWindowHandles();
            Iterator handlesItr = windowHandles.iterator();
            while(handlesItr.hasNext()){
                handlesItr.next();
                childWindow =   handlesItr.next().toString();
            }

            driver.switchTo().window(childWindow);
            System.out.println("Switched to window " + driver.getTitle());

            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_BookNowButton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement ContinueButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_continueButton,logger);
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
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_ConfirmBooking, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement roomIncrementButton(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, PDP_RoomIncrementButton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : + Button Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }


    public static WebElement RoomPriceTotal(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_RoomPriceTotal,logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

        public static WebElement InfobarPrice(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, PDP_InfobarPrice, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Book Now Button Found on PropertyDetailPage Screen");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }


    public static WebElement InfobarNightCount(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, PDP_InfobarNightCount, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement InfobarGuestCount(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, PDP_InforbarGuestCount, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement DeluxeNightCount(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, PDP_DeluxeNightCount, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement DeluxeGuestCount(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, PDP_DeluxeGuestCount, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement PDPScreenPrice(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_ScreenPrice, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }
    
    public static WebElement userType(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_userType, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }




}
