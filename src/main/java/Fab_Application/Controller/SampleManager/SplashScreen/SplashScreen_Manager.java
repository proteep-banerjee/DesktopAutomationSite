package Fab_Application.Controller.SampleManager.SplashScreen;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM.*;

public class SplashScreen_Manager {

    public void Validate_TC(WebDriver driver, ExtentTest logger) throws IOException {


            ReusableMethods.Click(driver, installAppClose(driver, logger));
            ReusableMethods.Click(driver, LoginButton(driver, logger));

    }
}
