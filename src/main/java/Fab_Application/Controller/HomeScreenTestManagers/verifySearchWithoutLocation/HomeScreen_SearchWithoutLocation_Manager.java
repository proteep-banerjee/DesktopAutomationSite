package Fab_Application.Controller.HomeScreenTestManagers.verifySearchWithoutLocation;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.SearchButton;
import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.searchWithoutLocation;

public class HomeScreen_SearchWithoutLocation_Manager {
    SoftAssert softAssert = new SoftAssert();

    //To verify user is prompted to enter location during search if the same is not given
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
