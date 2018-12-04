package Fab_Application.Controller.SplashScreenTest.verifyHamburgerOptions;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class verifyHamburgerOptions_Manager {
    SoftAssert softAssert = new SoftAssert();
//
//    public void verifyHamburgerOptions(WebDriver driver, ExtentTest logger) throws IOException, InterruptedException {
//        ReusableMethods.Click(driver, HomeScreen_POM.toggleButton(driver,logger));
//        List<WebElement> options = HomeScreen_POM.getHamburgerOptions(driver,logger);
//        int count = 0;
//        for(WebElement option:options) {
//            if (option.getText().contains("locations")) {
//                continue;
//            }
//            ReusableMethods.Click(driver,option);
//            Thread.sleep(1000);
//            String text;
//            if(count == 0) {
//                text = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_booking_ongoingBooking,logger).getText();
//                if (text.contains("Ongoing")) {
//                    System.out.println("Successfully verified \"My bookings\"");
//                    softAssert.assertTrue(true);
//                    softAssert.assertAll();
//                } else {
//                    softAssert.assertTrue(false);
//                    softAssert.assertAll();
//                }
//            } else if(count == 1) {
//                text = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_beOurFranchise,logger).getText();
//                if (text.contains("India's Best")) {
//                    System.out.println("Successfully verified \"Be our franchise\"");
//                    softAssert.assertTrue(true);
//                    softAssert.assertAll();
//                } else {
//                    softAssert.assertTrue(false);
//                    softAssert.assertAll();
//                }
//            }else if(count == 2) {
//                text = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_fabCredits,logger).getText();
//                if (text.contains("Your balance")) {
//                    System.out.println("Successfully verified \"My fab credits\"");
//                    softAssert.assertTrue(true);
//                    softAssert.assertAll();
//                } else {
//                    softAssert.assertTrue(false);
//                    softAssert.assertAll();
//                }
//            }else if(count == 3) {
//                text = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_yourMemberShip,logger).getText();
//                if (text.contains("Your Membership")) {
//                    System.out.println("Successfully verified \"Membership\"");
//                    softAssert.assertTrue(true);
//                    softAssert.assertAll();
//                } else {
//                    softAssert.assertTrue(false);
//                    softAssert.assertAll();
//                }
//            } else {
//                text = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_referAFriend,logger).getText();
//                if (text.contains("unique referral")) {
//                    System.out.println("Successfully verified \"Refer a friend\"");
//                    softAssert.assertTrue(true);
//                    softAssert.assertAll();
//                } else {
//                    softAssert.assertTrue(false);
//                    softAssert.assertAll();
//                }
//            }
//            ReusableMethods.MoveByElementAndClick(driver, HomeScreen_POM.toggleButton(driver,logger));
//            Thread.sleep(1000);
//            count++;
//        }
//    }
}

