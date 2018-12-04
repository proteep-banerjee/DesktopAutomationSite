package Fab_Application.Controller.BookingFlow.LoginPage;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

import static Fab_Application.Controller.POM.LoginScreen.LoginPage_POM.*;


public class LoginPageManager {

    public void Validate_TC(WebDriver driver, String mobileNumber, String OTP, ExtentTest logger) throws IOException {


            ReusableMethods.type(driver, mobileNumberField(driver, logger), mobileNumber);
            ReusableMethods.Click(driver, continueButton(driver, logger));
      //Validate OTP
            ReusableMethods.type(driver, otpField(driver, logger), OTP);
            ReusableMethods.Click(driver, getStartedButton(driver, logger));
     //       ReusableMethods.Click(driver, homeButton(driver, logger));


    }
}
