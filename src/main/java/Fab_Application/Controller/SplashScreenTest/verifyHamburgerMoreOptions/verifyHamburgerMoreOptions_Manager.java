package Fab_Application.Controller.SplashScreenTest.verifyHamburgerMoreOptions;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class verifyHamburgerMoreOptions_Manager {
    SoftAssert softAssert = new SoftAssert();
//
//    public void verifyHamburgerMoreOptions(WebDriver driver, ExtentTest logger) throws IOException, InterruptedException {
//        ReusableMethods.MoveByElementAndClick(driver, toggleButton(driver,logger));
//        ReusableMethods.MoveByElementAndClick(driver, hamburgerMoreOptions(driver,logger));
//        List<WebElement> options = getHamburgerMoreOptionsList(driver,logger);
//        int count = 0;
//        for(WebElement option:options) {
//            ReusableMethods.Click(driver,option);
//            String text;
//            if(count == 0 || count == 1) {
//                text = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_beOurFranchise,logger).getText();
//                System.out.println("text : "+text);
//                if (text.contains("India's Best")) {
//                    System.out.println("Successfully verified \"Be our franchise\"");
//                    softAssert.assertTrue(true);
//                    softAssert.assertAll();
//                } else {
//                    softAssert.assertTrue(false);
//                    softAssert.assertAll();
//                }
//            } else if(count == 2) {
//                text = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_aboutUs,logger).getText();
//                System.out.println("text : "+text);
//                if (text.contains("About")) {
//                    System.out.println("Successfully verified \"About us\"");
//                    softAssert.assertTrue(true);
//                    softAssert.assertAll();
//                } else {
//                    softAssert.assertTrue(false);
//                    softAssert.assertAll();
//                }
//            } else if(count == 3) {
//                text = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_termAndConditions,logger).getText();
//                if (text.contains("Terms")) {
//                    System.out.println("Successfully verified \"Terms and Conditions\"");
//                    softAssert.assertTrue(true);
//                    softAssert.assertAll();
//                } else {
//                    softAssert.assertTrue(false);
//                    softAssert.assertAll();
//                }
//            } else if(count == 4) {
//                text = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_FAQ,logger).getText();
//                if (text.contains("General")) {
//                    System.out.println("Successfully verified \"FAQ's\"");
//                    softAssert.assertTrue(true);
//                    softAssert.assertAll();
//                } else {
//                    softAssert.assertTrue(false);
//                    softAssert.assertAll();
//                }
//            } else if(count == 5) {
//                text = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_cancellationPolicy,logger).getText();
//                if (text.contains("Cancellation")) {
//                    System.out.println("Successfully verified \"Cancellation policy\"");
//                    softAssert.assertTrue(true);
//                    softAssert.assertAll();
//                } else {
//                    softAssert.assertTrue(false);
//                    softAssert.assertAll();
//                }
//            } else {
//                //blog option is not working 404
//                break;
//                /*text = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_fabCredits,logger).getText();
//                if (text.contains("Your balance")) {
//                    System.out.println("Successfully verified \"My fab credits\"");
//                    softAssert.assertTrue(true);
//                    softAssert.assertAll();
//                } else {
//                    softAssert.assertTrue(false);
//                    softAssert.assertAll();
//                }*/
//            }
//            ReusableMethods.scrollIntoView(driver,toggleButton(driver,logger));
//            ReusableMethods.MoveByElementAndClick(driver,toggleButton(driver,logger));
//            ReusableMethods.MoveByElementAndClick(driver, hamburgerMoreOptions(driver,logger));
//            count++;
//            if (count == 6) {
//                break;
//            }
//        }
//    }

}
