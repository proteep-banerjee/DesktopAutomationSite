package Fab_Application.Controller.BookingFlow.LoginPage;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class LoginPageManager {

    public void Validate_TC(WebDriver driver, String mobileNumber, String OTP, ExtentTest logger){

        try{

            ReusableMethods.type(driver, LoginPage_POM.mobileNumberField(driver, logger), mobileNumber, logger, "Mobile Number Field");
            ReusableMethods.Click(driver, LoginPage_POM.continueButton(driver, logger), logger, "Continue Button");
            ReusableMethods.type(driver, LoginPage_POM.otpField(driver, logger), OTP, logger, "OTP Field");
            ReusableMethods.Click(driver, LoginPage_POM.getStartedButton(driver, logger), logger, "Get Started Button");
            ReusableMethods.Click(driver, LoginPage_POM.homeButton(driver, logger), logger, "Home Button");

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
