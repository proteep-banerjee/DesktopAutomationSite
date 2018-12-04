package Fab_Application.Controller.SplashScreenTest.verifyCheckInAndCheckOutDateNotSame;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.*;

public class verifyCheckInAndCheckOutDateNotSame_Manager {
    SoftAssert softAssert = new SoftAssert();


//    public void verifyCheckInAndCheckOutDateNotSame(WebDriver driver, ExtentTest logger) throws IOException, InterruptedException {
//        ReusableMethods.Click(driver, CalendarCheckInButton(driver,logger));
//
//        //clicking on current date as check-in date
//        ReusableMethods.Click(driver, CalendarCurrentDate(driver,logger));
//
//        //clicking on current date as check-out date also
//        ReusableMethods.Click(driver, ReusableMethods.FindElement(driver, UiAddresses.Calendar_SameCheckOutDateAsCheckIn,logger));
//
//        //verifying check-in and check-out dates are not same
//        WebElement CheckInDate = CheckedInDate(driver, logger);
//
//        //System.out.println(CheckInDate.getText());
//        WebElement CheckOutDate = CheckedOutDate(driver, logger);
//        //System.out.println(CheckOutDate.getText());
//        boolean status = ReusableMethods.CompareText(CheckInDate, CheckOutDate);
//        //System.out.println("Status is "+status);
//        if (status == true) {
//            softAssert.assertTrue(false);
//            softAssert.assertAll();
//        } else {
//            softAssert.assertTrue(true);
//            softAssert.assertAll();
//        }
//    }
}
