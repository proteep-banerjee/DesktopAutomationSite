package Fab_Application.Controller.HomePage.HomePageTest_Manager_withValidations;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.AListOption;
import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.verifyAListOptionText;

public class HomeScreen_AListOptionTest_Manager {
    SoftAssert softAssert = new SoftAssert();

//    //To verify "Join the A-List" option is redirecting user to the correct page
    public void verifyAListOption(WebDriver driver, ExtentTest logger) throws IOException {
        ReusableMethods.Click(driver, AListOption(driver, logger));
        String text = verifyAListOptionText(driver, logger);
        System.out.println("Text : "+text);
        //verifying
        if (text.contains("A-List")) {
            softAssert.assertTrue(true);
            softAssert.assertAll();
        } else {
            softAssert.assertTrue(false);
            softAssert.assertAll();
        }
    }
}
