package Fab_Application.Controller.SearchResultPage.SRPTest_Managers_withValidatons;

/**
 * Created by Proteep Banerjee
 */

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.SRPScreen.SRP_POM.*;

public class SRP_ValidateFreeBreakfast_Manager {

    SoftAssert softAssert = new SoftAssert();

    public void ValidateFreeBreakfastForProperties(WebDriver driver,
                                                   ExtentTest logger) throws IOException {

        ReusableMethods.scrollToEndLoads(driver);

        ReusableMethods.scrollup(driver);

        int breakfastSize = FreeBreakfastList(driver, logger).size();

        int properties = listOfProperties(driver, logger).size();

        softAssert.assertEquals(breakfastSize, properties,
                "Free Breakfast not available for all the properties.");

        softAssert.assertAll();
    }
}
