package Fab_Application.Controller.SplashScreenTest.verifyDateBeforeCurrentNotSelectable;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

import static Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM.CalendarCheckInButton;
import static Fab_Application.Controller.POM.SplashScreen.SplashScreen_POM.CheckedOutDate;

public class verifyDateBeforeCurrentNotSelectable_Manager {
    SoftAssert softAssert = new SoftAssert();

    public void verifyDateBeforeCurrentNotSelectable(WebDriver driver, ExtentTest logger) throws IOException {
        //clicking on check in button
        ReusableMethods.Click(driver, CalendarCheckInButton(driver,logger));
        WebElement date = ReusableMethods.FindElement(driver, UiAddresses.Calendar_CurrentDate,logger);
        String currentDate = date.getText();
        System.out.println("Current Date : "+currentDate);
        List<WebElement> NumberOfNonSelectableDates = ReusableMethods.FindElements(driver, UiAddresses.Calendar_NonSelectableDateList,logger);
        String previousDate = NumberOfNonSelectableDates.get(NumberOfNonSelectableDates.size()-1).getText();
        System.out.println("Previous date : "+previousDate);
        //clicking on previous date
        ReusableMethods.Click(driver,NumberOfNonSelectableDates.get(NumberOfNonSelectableDates.size()-1));
        String checkOutDate = CheckedOutDate(driver,logger).getText();
        //System.out.println("CheckOut Date : "+checkOutDate);
        //verifying if checkout date is blank or not
        if (checkOutDate.equals("")) {
            softAssert.assertTrue(true);
            softAssert.assertAll();
        } else {
            softAssert.assertTrue(false);
            softAssert.assertAll();
        }
    }
}
