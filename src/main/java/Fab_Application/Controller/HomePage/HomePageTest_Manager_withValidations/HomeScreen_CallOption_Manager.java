package Fab_Application.Controller.HomePage.HomePageTest_Manager_withValidations;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.callOption;

public class HomeScreen_CallOption_Manager {
    SoftAssert softAssert = new SoftAssert();

    //To verify call option on top of the home page is showing correct mobile number
    public void verifyCallOption(WebDriver driver, ExtentTest logger) throws InterruptedException, IOException {
        String number = callOption(driver, logger).getText();
        System.out.println(number);
        if (number.contains("+91 70 4242 4242")) {
            System.out.println("Successfully verified call option");
            softAssert.assertTrue(true);
            softAssert.assertAll();
        } else {
            System.out.println("Failed to verify call option");
            softAssert.assertTrue(false);
            softAssert.assertAll();
        }
    }
}
