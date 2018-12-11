package Fab_Application.Controller.POM.SRPScreen;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

import static Fab_Application.Constants.UiAddresses.calendar_DateList;

public class SRP_POM {

    public static List<WebElement> listOfProperties(WebDriver driver, ExtentTest logger) throws IOException {

        List<WebElement> elements = null;

        try{
            elements = ReusableMethods.FindElements(driver, UiAddresses.SRP_listOfProperties, logger);
            logger.log(LogStatus.PASS, elements + " : Found", logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return elements;
    }

}
