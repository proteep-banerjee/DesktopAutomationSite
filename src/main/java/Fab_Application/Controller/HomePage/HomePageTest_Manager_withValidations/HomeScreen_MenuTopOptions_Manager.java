package Fab_Application.Controller.HomePage.HomePageTest_Manager_withValidations;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.*;

public class HomeScreen_MenuTopOptions_Manager {
    SoftAssert softAssert = new SoftAssert();

    //To verify top menu options Refer a friend, Corporate enquiry and Be our franchise options are giving correct pages on clicking
    public void verifyMenuTopOptions(WebDriver driver, String firstServer, ExtentTest logger) throws IOException, InterruptedException {

        int count = 0;
        WebElement text;
        while (count < 3) {
                if (count == 0) {
                System.out.println("Clicking on \"Refer a friend and earn\" option...");
                ReusableMethods.Click(driver,ReferAFriendOption(driver, logger));
                text = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_mobileNumberOnReferAFriend,logger);
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
                continue;
            } else if (count == 1) {
                System.out.println("Clicking on \"Corporate enquiry\" option...");
                ReusableMethods.Click(driver,corporateEnquiryOptionUp(driver, logger));
                text = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_corporateEnquiry,logger);
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
                text = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_beOurFranchise,logger);
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
