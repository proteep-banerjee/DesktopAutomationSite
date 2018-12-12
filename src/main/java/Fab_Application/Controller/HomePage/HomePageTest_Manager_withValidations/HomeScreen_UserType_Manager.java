package Fab_Application.Controller.HomePage.HomePageTest_Manager_withValidations;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.userType;

public class HomeScreen_UserType_Manager {
    SoftAssert softAssert = new SoftAssert();

    //To verify after login, type of user should be blue OR silver OR gold OR platinum
    public void verifyUserType(WebDriver driver, ExtentTest logger) throws IOException {
        String userType =  userType(driver, logger).getText();
        System.out.println(userType);
        if (userType.contains("BLUE") || userType.contains("SILVER") || userType.contains("GOLD") || userType.contains("PLATINUM")) {
            softAssert.assertTrue(true);
            softAssert.assertAll();
        } else {
            System.out.println("Failed to verify user type");
            softAssert.assertTrue(false);
            softAssert.assertAll();
        }
    }
}
