package Fab_Application.Controller.POM.FilterScreen;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

@SuppressWarnings("ConstantConditions")
public class FilterScreen_POM {

    public static WebElement FilterResetButton(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Filter_ResetButton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static WebElement FilterPriceSliderLeft(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Filter_PriceSliderLeft, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }


    public static WebElement FilterPriceSliderRight(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Filter_PriceSliderRight, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static WebElement FilterLeftPriceSliderTooltip(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Filter_LeftPriceSliderTooltip, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }


    public static WebElement FilterRightPriceSliderTooltip(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Filter_RightPriceSliderTooltip, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static WebElement FilterCoupleFriendlyPolicy(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Filter_CoupleFriendlyPolicy, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static WebElement FilterOccupancy(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Filter_Occupancy, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static WebElement FilterLocalitySection(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Filter_LocalitySection, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static WebElement PricePerNightSection(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Filter_PricepernightSection, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static WebElement FilterPoliciesSection(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Filter_PoliciesSection, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static WebElement FilterOccupancySection(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Filter_OccupancySection, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static WebElement FilterAmenitiesSection(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Filter_AmenitiesSection, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }


    public static WebElement FiltertransportationSection(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Filter_TransportationSection, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }


    public static WebElement FilterStandardAmenitiesSection(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Filter_StandardAmenitiesSection, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

}
