package Fab_Application.Controller.SplashScreenTest.verifyMenuTopOptions;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

import static Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM.*;

public class verifyMenuTopOptions_Manager {
    //This function is to verify after clicking on refer friend option user is redirected to enter mobile number if the user has not logged-in
    SoftAssert softAssert = new SoftAssert();

    public void verifyMenuTopOptions(WebDriver driver, String firstServer, ExtentTest logger) throws IOException, InterruptedException {

        int count = 0;
        WebElement text;
        while (count < 3) {
                if (count == 0) {
                System.out.println("Clicking on \"Refer a friend and earn\" option...");
                ReusableMethods.Click(driver,ReferAFriendOption(driver, logger));
                text = ReusableMethods.FindElement(driver, UiAddresses.getSplashScreen_mobileNumberOnReferAFriend,logger);
                String temp = text.getAttribute("placeholder");
                System.out.println("Actual output is : "+temp);
                if (temp.contains("Mobile")) {
                    System.out.println("Successfully redirected user to Refer A Friend And Earn page.");
                    softAssert.assertTrue(true);
                    softAssert.assertAll();
                } else {
                    softAssert.assertTrue(false);
                    softAssert.assertAll();
                }
                count++;

                driver.navigate().back();
                //Thread.sleep(2000);
                continue;
            } else if (count == 1) {
                System.out.println("Clicking on \"Corporate enquiry\" option...");
                ReusableMethods.Click(driver,corporateEnquiryOption(driver, logger));
                text = ReusableMethods.FindElement(driver, UiAddresses.getSplashScreen_corporateEnquiry,logger);
                String temp = text.getText();
                System.out.println("Actual output is : "+temp);
                if (temp.contains("Corporate Panel")) {
                    System.out.println("Successfully redirected user to Corporate Enquiry page.");
                    softAssert.assertTrue(true);
                    softAssert.assertAll();
                } else {
                    softAssert.assertTrue(false);
                    softAssert.assertAll();
                }
                count++;
                driver.navigate().back();
                continue;
            } else {
                System.out.println("Clicking on \"Be our franchise\" option...");
                ReusableMethods.Click(driver,beOurFranchiseOption(driver, logger));
                text = ReusableMethods.FindElement(driver, UiAddresses.getSplashScreen_beOurFranchise,logger);
                String temp = text.getText();
                System.out.println("Actual output is : "+temp);
                if (temp.contains("Partner with us")) {
                    System.out.println("Successfully redirected user to Be Our Franchise page.");
                    softAssert.assertTrue(true);
                    softAssert.assertAll();
                } else {
                    softAssert.assertTrue(false);
                    softAssert.assertAll();
                }
                count++;
            }
        }
    }
}
