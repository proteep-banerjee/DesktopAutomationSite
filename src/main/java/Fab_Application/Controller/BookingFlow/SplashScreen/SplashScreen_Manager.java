package Fab_Application.Controller.BookingFlow.SplashScreen;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class SplashScreen_Manager {

    public void Validate_TC(WebDriver driver, ExtentTest logger){

        try {

            ReusableMethods.Click(driver, SplashScreen_POM.installAppClose(driver, logger), logger, "installAppClose button");
            ReusableMethods.Click(driver, SplashScreen_POM.LoginButton(driver, logger), logger, "Login Button");

        }
        catch(Exception e){

            e.printStackTrace();

        }
    }
}
