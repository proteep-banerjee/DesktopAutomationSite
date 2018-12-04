package Fab_Application.Controller.SplashScreenTest.verifyLoginSideTabs;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

import static Fab_Application.Controller.POM.LoginScreen.LoginPage_POM.*;
import static Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM.LoginButton;

public class verifyLoginSideTabs_Manager {
    SoftAssert softAssert = new SoftAssert();

    public void verifyLoginSideTabs(WebDriver driver, ExtentTest logger) throws IOException, InterruptedException {
        ReusableMethods.Click(driver, verifyLoginPage(driver, logger));
        int count = 0;
        while (count < 4) {
            String text;
            if (count == 0) {
                ReusableMethods.MoveByElementAndClick(driver,bookingSideTab(driver,logger));
                text = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_verifyBookingTab, logger).getText();
                System.out.println("text : " + text);
                if (text.contains("All Bookings")) {
                    count++;
                    System.out.println("Successfully verified \"My booking\"");
                    softAssert.assertTrue(true);
                    softAssert.assertAll();
                    driver.navigate().back();
                    continue;
                } else {
                    softAssert.assertTrue(false);
                    softAssert.assertAll();
                }
            } else if (count == 1) {
                ReusableMethods.Click(driver, verifyLoginPage(driver, logger));
                ReusableMethods.MoveByElementAndClick(driver,profileSideTab(driver,logger));
                text = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_verifyProfileTab, logger).getText();
                System.out.println("text : " + text);
                if (text.contains("SAVE PROFILE")) {
                    count++;
                    System.out.println("Successfully verified \"Profile\"");
                    softAssert.assertTrue(true);
                    softAssert.assertAll();
                    driver.navigate().back();
                    continue;
                } else {
                    softAssert.assertTrue(false);
                    softAssert.assertAll();
                }
            } else if (count == 2) {
                ReusableMethods.Click(driver, verifyLoginPage(driver, logger));
                ReusableMethods.MoveByElementAndClick(driver,fabCreditsSideTab(driver,logger));
                text = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_verifyFabCreditsTab, logger).getText();
                System.out.println(text);
                if (text.contains("Fab credits")) {
                    count++;
                    System.out.println("Successfully verified \"Fab Credits\"");
                    softAssert.assertTrue(true);
                    softAssert.assertAll();
                    driver.navigate().back();
                    continue;
                } else {
                    softAssert.assertTrue(false);
                    softAssert.assertAll();
                }
            } else {
                ReusableMethods.Click(driver, verifyLoginPage(driver, logger));
                ReusableMethods.MoveByElementAndClick(driver,AListMembershipSideTab(driver,logger));
                text = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_verifyAListMembershipTab, logger).getText();
                System.out.println(text);
                if (text.contains("Membership")) {
                    count++;
                    System.out.println("Successfully verified \"A-ListMembership\"");
                    softAssert.assertTrue(true);
                    softAssert.assertAll();
                } else {
                    softAssert.assertTrue(false);
                    softAssert.assertAll();
                }
            }






/*            //clicking on login button
        ReusableMethods.Click(driver, LoginButton(driver, logger));
        //verifying login page appears or not
        WebElement text = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_login_SignUpText,logger);
        System.out.println(text.getText());
        if(text.getText().contains("Log In/Sign Up")) {
            softAssert.assertTrue(true);
            softAssert.assertAll();
        } else {
            softAssert.assertTrue(false);
            softAssert.assertAll();
        }*/
        }
    }
}
