package Fab_Application.Controller.HomeScreenTestManagers.verifyReferalCode;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.*;

public class HomeScreen_ReferalCode_Manager {
    SoftAssert softAssert = new SoftAssert();

    //To verify 'your referal code' option is showing some referal code
    public void verifyReferalCode(WebDriver driver,String mobile, String OTP, ExtentTest logger) throws IOException {
        String text = referalCodeOptionBeforeLogin(driver, logger).getText();
        System.out.println("Referal code before login : "+text);
        if (text.contains("Show code")) {
            softAssert.assertTrue(true);
            softAssert.assertAll();
        } else {
            softAssert.assertTrue(false);
            softAssert.assertAll();
        }
        ReusableMethods.Click(driver, referalCodeOptionBeforeLogin(driver, logger));
        ReusableMethods.type(driver, mobileNumberOnReferal(driver, logger), mobile);
        ReusableMethods.Click(driver, continueButtonOnReferal(driver, logger));
        ReusableMethods.type(driver, OTPOnReferal(driver, logger), OTP);
        ReusableMethods.Click(driver, getStartedButtonOnReferal(driver, logger));
        //verifying referal code
        text = referalCodeOptionAfterLogin(driver, logger).getText();
        System.out.println("Referal code after login : "+text);
        if (text.matches("[A-Za-z0-9]+") && !text.equals(null)) {
            System.out.println("Successfully verified referal code : "+text);
            softAssert.assertTrue(true);
            softAssert.assertAll();
        } else {
            softAssert.assertTrue(false);
            softAssert.assertAll();
        }


    }
}
