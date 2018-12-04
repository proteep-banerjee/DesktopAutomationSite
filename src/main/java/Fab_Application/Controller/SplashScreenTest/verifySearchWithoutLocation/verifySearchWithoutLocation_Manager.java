package Fab_Application.Controller.SplashScreenTest.verifySearchWithoutLocation;

import Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM.SearchButton;
import static Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM.searchWithoutLocation;

public class verifySearchWithoutLocation_Manager {
    SoftAssert softAssert = new SoftAssert();

    public void verifySearchWithoutLocation(WebDriver driver, ExtentTest logger) throws IOException, InterruptedException {
        //clicking search button
        ReusableMethods.Click(driver, SearchButton(driver, logger));
        //Verify error message
        String text = searchWithoutLocation(driver, logger).getText();
        System.out.println("Actual output : "+text);
        if (text.contains("Enter Location")) {
            softAssert.assertTrue(true);
            softAssert.assertAll();
        } else {
            softAssert.assertTrue(false);
            softAssert.assertAll();
        }
    }
}
