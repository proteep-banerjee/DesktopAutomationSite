package Fab_Application.Controller.SplashScreenTest.verifyReferOption;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class verifyReferOption_Manager {
    //This function is to verify after clicking on refer friend option user is redirected to enter mobile number
    SoftAssert softAssert = new SoftAssert();

//    public void verifyReferOption(WebDriver driver, ExtentTest logger) throws IOException {
//        System.out.println("Clicking on toggle-button...");
//        ReusableMethods.Click(driver, HomeScreen_POM.toggleButton(driver,logger));
//        ReusableMethods.Click(driver, ReferAFriendOption(driver, logger));
//        WebElement text = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_mobileNumberField,logger);
//        String temp = text.getAttribute("placeholder");
//        System.out.println("Actual output is : "+temp);
//        if (text.getAttribute("placeholder").contains("mobile")) {
//            softAssert.assertTrue(true," Successfully redirected to \"refer and earn\" page");
//            softAssert.assertAll();
//        } else {
//            softAssert.assertTrue(false, " Failed to redirect user to \"refer and earn\" page");
//            softAssert.assertAll();
//        }
//    }
}
