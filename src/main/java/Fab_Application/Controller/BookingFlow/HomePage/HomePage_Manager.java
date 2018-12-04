package Fab_Application.Controller.BookingFlow.HomePage;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.*;

public class HomePage_Manager {

    public void Validate_TC(WebDriver driver, ExtentTest logger) throws IOException {

        ReusableMethods.Click(driver, LoginButton(driver, logger));

    }
}
