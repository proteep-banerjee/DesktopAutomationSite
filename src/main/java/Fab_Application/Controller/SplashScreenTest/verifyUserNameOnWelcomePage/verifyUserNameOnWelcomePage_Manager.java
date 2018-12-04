package Fab_Application.Controller.SplashScreenTest.verifyUserNameOnWelcomePage;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class verifyUserNameOnWelcomePage_Manager {
    SoftAssert softAssert = new SoftAssert();

//    public void verifyUserNameOnWelcomePage(WebDriver driver,String mobile, String OTP, String TextOnWelcomeScreen, ExtentTest logger) throws IOException, InterruptedException {
//        //Verifying welcome screen messages
//        List<String> element = verifyUserOnWelcomeScreen(driver, logger);
//
//        System.out.println(TextOnWelcomeScreen);
//
//        //Change Akku to Subrat in excel if running this TC on live app
//        for (String text:element) {
//            System.out.println(text);
//            Thread.sleep(1000);
//            if (text.contains(TextOnWelcomeScreen)) {
//                softAssert.assertTrue(true);
//                softAssert.assertAll();
//            } else {
//                softAssert.assertTrue(false);
//                softAssert.assertAll();
//            }
//        }
//    }
}
