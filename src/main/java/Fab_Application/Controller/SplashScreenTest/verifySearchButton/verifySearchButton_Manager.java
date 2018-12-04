package Fab_Application.Controller.SplashScreenTest.verifySearchButton;

import Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.SRPScreen.SRP_POM.SearchDetailsCity;
import static Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM.searchField;

public class verifySearchButton_Manager {
    SoftAssert softAssert = new SoftAssert();

    // To verify search button is working fine
    public void verifySearchButton(WebDriver driver, String location, ExtentTest logger) throws IOException, InterruptedException {

        System.out.println("Entering input in the search field...");
        ReusableMethods.type(driver, searchField(driver, logger), location);
        Thread.sleep(500);
        searchField(driver, logger).sendKeys(Keys.ENTER);
        //clicking on search button
        ReusableMethods.Click(driver, SplashScreen_POM.SearchButton(driver, logger));
        Thread.sleep(1000);
        //verifying user is redirected to SRP or not
        String text = SearchDetailsCity(driver, logger).getAttribute("value");
        System.out.println("Actual text : "+text);
        if (text.contains(location)) {
            softAssert.assertTrue(true);
            softAssert.assertAll();
        } else {
            softAssert.assertTrue(false);
            softAssert.assertAll();
        }
    }
}
