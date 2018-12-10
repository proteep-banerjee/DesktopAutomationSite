package Fab_Application.Controller.POM.PropertyDetailPage;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;


public class PDP_POM {

    public static WebElement EditButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_EditButton,logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement BookNowButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_BookNowButton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement EditSelection(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_EditSelection, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement RedeemFabCredits(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_RedeemFabCredits, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement ViewAllRooms(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_ViewAllRooms, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement OpenMaps(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_OpenMaps, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement CancellationPolicy(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_CancellationPolicy, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement ChildrenPolicy(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_ChildrenPolicy, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement Check_In_Out_Timings(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_Check_In_out_timings, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement ViewMoreHotels(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_ViewMore, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement OpenApp(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_OpenAppButton, logger);
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
            element = ReusableMethods.FindElement(driver, UiAddresses.PayAtHotel, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

}
