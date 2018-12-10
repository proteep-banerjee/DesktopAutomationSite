package Fab_Application.Controller.HomeScreenTestManagers.verifySearchAutoSuggestions;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.autosuggestionList;
import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.searchField;

public class HomeScreen_SearchAutoSuggestions_Manager {
    SoftAssert softAssert = new SoftAssert();

    //To verify search field autosuggestion is giving correct suggestions as per the input
    public void verifyAutoSuggestionsInSearchField(WebDriver driver,String location, ExtentTest logger) throws InterruptedException, IOException {
        ReusableMethods.type(driver, searchField(driver, logger), location);
        ReusableMethods.wait(1);
        List<WebElement> listOfSuggestions = autosuggestionList(driver, logger);
        for (WebElement suggestion : listOfSuggestions) {
            System.out.println(suggestion.getText());
            if (suggestion.getText().contains(location)) {
                softAssert.assertTrue(true);
                softAssert.assertAll();
            } else {
                System.out.println("Failed to verify Autosuggestion.");
                softAssert.assertTrue(false);
                softAssert.assertAll();
            }
        }
    }
}
