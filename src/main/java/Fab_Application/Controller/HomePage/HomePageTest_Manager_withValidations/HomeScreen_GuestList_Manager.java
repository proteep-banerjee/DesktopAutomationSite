package Fab_Application.Controller.HomePage.HomePageTest_Manager_withValidations;

import Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.guestList;

public class HomeScreen_GuestList_Manager {
    SoftAssert softAssert = new SoftAssert();

    //To verify user can select number of guests while searching hotels
    public void verifyGuestList(WebDriver driver, ExtentTest logger) throws InterruptedException, IOException {

        ReusableMethods.Click(driver, HomeScreen_POM.guestSelected(driver, logger));
        ReusableMethods.selectFromListByText(driver, guestList(driver, logger), "4 Guests" );
        ReusableMethods.wait(2);
        String guestSelected = HomeScreen_POM.guestSelected(driver, logger).getText();
        System.out.println("Guest selected : "+guestSelected);
        //verifying
        if (guestSelected.equals("4 Guests")) {
            softAssert.assertTrue(true);
            softAssert.assertAll();
        } else {
            softAssert.assertTrue(false);
            softAssert.assertAll();
        }
    }
}

