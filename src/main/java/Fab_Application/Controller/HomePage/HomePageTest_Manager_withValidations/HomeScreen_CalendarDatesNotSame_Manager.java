package Fab_Application.Controller.HomePage.HomePageTest_Manager_withValidations;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.*;

public class HomeScreen_CalendarDatesNotSame_Manager {
    SoftAssert softAssert = new SoftAssert();

    //To verify check in and check out cannot be same
    public void CalendarDatesNotSame(WebDriver driver, ExtentTest logger) throws IOException, InterruptedException {
        ReusableMethods.Click(driver, CalendarCheckInButton(driver,logger));

        //clicking on current date as check-in date
        ReusableMethods.Click(driver, CalendarCurrentDate(driver,logger));

        //clicking on current date as check-out date also
        ReusableMethods.Click(driver, ReusableMethods.FindElement(driver, UiAddresses.Calendar_SameCheckOutDateAsCheckIn,logger));

        //verifying check-in and check-out dates are not same
        String CheckInDate = CheckedInDate(driver, logger).getAttribute("value");

        System.out.println("Check-In Date : #"+CheckInDate);
        String CheckOutDate = CheckedOutDate(driver, logger).getAttribute("value");
        System.out.println("Check-Out date : "+CheckOutDate);
        boolean status = ReusableMethods.CompareText(CheckInDate, CheckOutDate);
        System.out.println("Date compare Status is : "+status);
        if (status == true) {
            softAssert.assertTrue(false);
            softAssert.assertAll();
        } else {
            softAssert.assertTrue(true);
            softAssert.assertAll();
        }
    }
}
