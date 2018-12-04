package Fab_Application.Controller.SRPTestCases.ValidateEditBoxText;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import static Fab_Application.Controller.POM.SRPScreen.SRP_POM.*;

public class SRP_ValidateEditBox_Manager {

    SoftAssert softAssert = new SoftAssert();

    // To verify that the details appearing in the edit box are same as searched details.
//
//    }
//
//    private void CalendarDateSelection(WebDriver driver,
//                                       String checkInDate, String checkoutDate,
//                                       ExtentTest logger) throws Exception{
//
//        WebElement calendarYear = calendarYear(driver, logger),
//                calendarMonth = calendarMonth(driver, logger);
//
//        // Check in date selection
//        String checkinMonth = checkInDate.split("-")[1];
//        String checkinYear = checkInDate.split("-")[2];
//        int userInputCheckinDate = Integer.parseInt(checkInDate.split("-")[0]);
//
//        while(!(checkinMonth.equalsIgnoreCase(calendarMonth.getText()) &&
//                checkinYear.equalsIgnoreCase(calendarYear.getText()))){
//            ReusableMethods.Click(driver, calendarNextButton(driver, logger));
//        }
//
//        Thread.sleep(1000);
//        ReusableMethods.selectFromListByText(driver, calendarDates(driver, logger),
//                String.valueOf(userInputCheckinDate));
//
//        // Check out date selection
//        String checkoutMonth = checkoutDate.split("-")[1];
//        String  public void ValidateEditBoxDetails(WebDriver driver, String cityName,
//                                       String checkInDate, String checkOutDate,
//                                       String Guests, ExtentTest logger) throws Exception {
//
//        ReusableMethods.Click(driver, EditDetailsBox(driver, logger));
//        ReusableMethods.Click(driver, ClearButton(driver, logger));
//        ReusableMethods.type(driver, SearchField(driver, logger), cityName);
//
//        Thread.sleep(4000);
//        ReusableMethods.selectFromListByText(driver, autosuggestionList(driver, logger), cityName);
//
//        ReusableMethods.Click(driver,CheckinButton(driver, logger));
//        CalendarDateSelection(driver, checkInDate, checkOutDate, logger);
//
//        for(int i = 1; i <= (Integer.parseInt(Guests) - 1); i++)
//            ReusableMethods.Click(driver, GuestIncrease(driver, logger));
//
//        ReusableMethods.Click(driver, SearchButton(driver, logger));
//
//        // Verify the city name
//        ReusableMethods.verifyText(SearchDetailsCity(driver, logger), cityName);
//
//        // Verify the dates
//        String checkinMonth = checkInDate.split("-")[1].substring(0,3);
//        String checkoutMonth = checkOutDate.split("-")[1].substring(0,3);
//        int checkindate = Integer.parseInt(checkInDate.split("-")[0]);
//        int checkoutdate = Integer.parseInt(checkOutDate.split("-")[0]);
//        ReusableMethods.verifyText(SearchDetailsDate(driver, logger), checkinMonth +
//                " " + checkindate + " - " + checkoutMonth + " " + checkoutdate);
//
//        // Verify the Guests
//        /*System.out.println(SearchDetailsGuest(driver, logger).
//                getText().replaceAll("[^\\d.]", ""));*/
//        softAssert.assertEquals(SearchDetailsGuest(driver, logger).
//                getText().replaceAll("[^\\d.]", ""), Guests,
//                "Number of guests did not match in the edit box.");
//
//        softAssert.assertAll();
//                checkoutYear = checkoutDate.split("-")[2];
//        int userInputCheckoutDate = Integer.parseInt(checkoutDate.split("-")[0]);
//
//        while(!(checkoutMonth.equalsIgnoreCase(calendarMonth.getText()) &&
//                checkoutYear.equalsIgnoreCase(calendarYear.getText()))){
//            ReusableMethods.Click(driver, calendarNextButton(driver, logger));
//        }
//
//        Thread.sleep(1000);
//        ReusableMethods.selectFromListByText(driver, calendarDates(driver, logger),
//                String.valueOf(userInputCheckoutDate));
//
//        ReusableMethods.Click(driver, calendarDoneButton(driver, logger));
 //   }
}
