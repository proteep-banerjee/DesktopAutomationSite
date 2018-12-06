package Fab_Application.Controller.POM.SplashScreen;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("ConstantConditions")
public class SplashScreen_POM {

    public static WebElement searchField(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.splashScreen_CitySearchField, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static WebElement checkInButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.splashScreen_checkinButton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }


    public static WebElement SearchButton(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.splashScreen_SearchButton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static List<WebElement> autosuggestionList(WebDriver driver, ExtentTest logger) throws IOException{
        List<WebElement> elements = null;

        try{
            elements = ReusableMethods.FindElements(driver, UiAddresses.splashScreen_autosuggestionList, logger);
            logger.log(LogStatus.PASS, elements + " : Found", logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return elements;
    }

}
