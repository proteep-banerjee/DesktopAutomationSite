package Fab_Application.Controller.SplashScreenTest.verifyAutoSearchSuggestion;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.*;

public class verifyAutoSearchSuggestion_Manager {
    SoftAssert softAssert = new SoftAssert();

    // To verify search field gives suggestion according to the input
    public void VerifyAutoSearchSuggestion(WebDriver driver, String location, ExtentTest logger) throws IOException, InterruptedException {

        System.out.println("Entering input in the search field...");
        ReusableMethods.type(driver, searchField(driver, logger), location);

        Thread.sleep(1000);
        System.out.println("Verifying all the search suggestions...");
        List<WebElement> listOfSuggestion = autosuggestionList(driver, logger);
        Thread.sleep(1000);

        for (WebElement suggestion : listOfSuggestion) {
            System.out.println("Location is " + suggestion.getText());
            if (suggestion.getText().contains(location)) {
                softAssert.assertTrue(true, suggestion.getText() + " Verified");
                softAssert.assertAll();
            } else {
                softAssert.assertTrue(false, suggestion.getText() + " Not Verified");
                softAssert.assertAll();
            }
        }
    }
}
