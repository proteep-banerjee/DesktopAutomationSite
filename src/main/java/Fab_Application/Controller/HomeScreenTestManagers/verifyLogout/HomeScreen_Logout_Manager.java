package Fab_Application.Controller.HomeScreenTestManagers.verifyLogout;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Controller.POM.LoginScreen.LoginPage_POM;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.LoginScreen.LoginPage_POM.verifyLoginPage;

public class HomeScreen_Logout_Manager {
    SoftAssert softAssert = new SoftAssert();

    //To verify on pressing logout button user is getting logged out
    public void verifyLogout(WebDriver driver, String ExpectedOutput, ExtentTest logger) throws IOException, InterruptedException {
        ReusableMethods.MoveToElement(driver,verifyLoginPage(driver,logger));
        ReusableMethods.Click(driver, LoginPage_POM.logoutButton(driver, logger));
        ReusableMethods.wait(2);
        String text = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_verifyHomePageText,logger).getText();
        System.out.println("Actual output is : "+text);
        System.out.println("Actual output should contains : "+ExpectedOutput);
        if (text.contains(ExpectedOutput)) {
            softAssert.assertTrue(true);
            softAssert.assertAll();
        } else {
            softAssert.assertTrue(false);
            softAssert.assertAll();
        }
    }
}
