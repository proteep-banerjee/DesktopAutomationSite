package Fab_Application.Controller.HomeScreenTestManagers.verifyAllStaticPages;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.*;

public class HomeScreen_AllStaticPages_Manager {

    SoftAssert softAssert = new SoftAssert();

    //To verify all static links are redirected to expected pages
    public void verifyAllStaticPages(WebDriver driver, ExtentTest logger) throws IOException, InterruptedException {
        List<WebElement> links = AllStaticLinks(driver, logger);
        String mainWindow = driver.getWindowHandle();
        int count = 0;
        for (WebElement link : links) {
            ReusableMethods.Click(driver, link);
            ReusableMethods.wait(1);

            Set<String> s1 = driver.getWindowHandles();
            Iterator<String> i1 = s1.iterator();

            while (i1.hasNext()) {
                String ChildWindow = i1.next();

                if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
                    driver.switchTo().window(ChildWindow);
                    if (count == 0) {
                        if (aboutUs(driver, logger).getText().equalsIgnoreCase("About Us")) {
                            System.out.println("Successfully verified \"About Us\"");
                             softAssert.assertTrue(true);
                             softAssert.assertAll();
                        } else {
                             softAssert.assertTrue(false);
                             softAssert.assertAll();
                        }
                    } else if (count == 1) {
                        if (careers(driver, logger).getText().equalsIgnoreCase("careers")) {
                            System.out.println("Successfully verified \"Careers\"");
                            softAssert.assertTrue(true);
                            softAssert.assertAll();
                        } else {
                            softAssert.assertTrue(false);
                            softAssert.assertAll();
                        }
                    } else if (count == 2) {
                        if (press(driver, logger).getText().equalsIgnoreCase("press")) {
                            System.out.println("Successfully verified \"Press\"");
                            softAssert.assertTrue(true);
                            softAssert.assertAll();
                        } else {
                            softAssert.assertTrue(false);
                            softAssert.assertAll();
                        }
                    } else if (count == 3) {
                        if (blog(driver, logger).getText().equalsIgnoreCase("home")) {
                            System.out.println("Successfully verified \"Blog\"");
                            softAssert.assertTrue(true);
                            softAssert.assertAll();
                        } else {
                            softAssert.assertTrue(false);
                            softAssert.assertAll();
                        }
                    } else if (count == 4) {
                        if (beOurFranchiseOptionDown(driver, logger).getText().contains("Partner with us")) {
                            System.out.println("Successfully verified \"Be our franchise\"");
                            softAssert.assertTrue(true);
                            softAssert.assertAll();
                        } else {
                            softAssert.assertTrue(false);
                            softAssert.assertAll();
                        }
                    } else if (count == 5) {
                        if (travelAgent(driver, logger).getText().equalsIgnoreCase("Travel Agent Login")) {
                            System.out.println("Successfully verified \"Travel Agent\"");
                            softAssert.assertTrue(true);
                            softAssert.assertAll();
                        } else {
                            softAssert.assertTrue(false);
                            softAssert.assertAll();
                        }
                    } else if (count == 6) {
                        if (corporateEnquiryOption(driver, logger).getText().contains("Corporate Panel")) {
                            System.out.println("Successfully verified \"Corporate Enquiry\"");
                            softAssert.assertTrue(true);
                            softAssert.assertAll();
                        } else {
                            softAssert.assertTrue(false);
                            softAssert.assertAll();
                        }
                    } else if (count == 7) {
                        if (termsAndConditions(driver, logger).getText().contains("Terms and Conditions")) {
                            System.out.println("Successfully verified \"Terms and conditions\"");
                            softAssert.assertTrue(true);
                            softAssert.assertAll();
                        } else {
                            softAssert.assertTrue(false);
                            softAssert.assertAll();
                        }
                    } else if (count == 8) {
                        if (privacyPolicy(driver, logger).getText().contains("Privacy Policy")) {
                            System.out.println("Successfully verified \"Privacy policy\"");
                            softAssert.assertTrue(true);
                            softAssert.assertAll();
                        } else {
                            softAssert.assertTrue(false);
                            softAssert.assertAll();
                        }
                    } else if (count == 9){
                        if (cancellationPolicy(driver, logger).getText().contains("Cancellation")) {
                            System.out.println("Successfully verified \"Cancellation\"");
                            softAssert.assertTrue(true);
                            softAssert.assertAll();
                        } else {
                            softAssert.assertTrue(false);
                            softAssert.assertAll();
                        }
                    } else {
                        if (FAQs(driver, logger).getText().contains("Frequently")) {
                            System.out.println("Successfully verified \"FAQs\"");
                            softAssert.assertTrue(true);
                            softAssert.assertAll();
                        } else {
                            softAssert.assertTrue(false);
                            softAssert.assertAll();
                        }
                    }
                    count++;
                    driver.close();
                    driver.switchTo().window(mainWindow);
                }}

            }
        }
    }
