package Fab_Application.Controller.LoginPage;

/**
 * Created By Kalpana
 * Modified By Proteep.
 */

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static Fab_Application.Controller.POM.LoginScreen.LoginPage_POM.*;

public class LoginPage_Manager_withoutValidations {

/*This method enters the a valid mobile number and a valid OTP to login to the
* website demonstrating the positive flow of login.*/
    public void SimpleLogin(WebDriver driver, String mobileNumber, String OTP, ExtentTest logger) throws IOException {


            ReusableMethods.type(driver, mobileNumberField(driver, logger), mobileNumber);
            ReusableMethods.Click(driver, continueButton(driver, logger));
    
            //Validate OTP
            ReusableMethods.type(driver, otpField(driver, logger), OTP);
            ReusableMethods.Click(driver, getStartedButton(driver, logger));


    }
}
