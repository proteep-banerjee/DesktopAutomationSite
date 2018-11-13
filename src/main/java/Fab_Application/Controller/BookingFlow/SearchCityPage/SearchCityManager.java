package Fab_Application.Controller.BookingFlow.SearchCityPage;

import Fab_Application.Controller.BookingFlow.SplashScreen.SplashScreen_POM;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class SearchCityManager {

    public void Validate_TC(WebDriver driver, String cityName,
                            String checkInDate, String checkoutDate, ExtentTest logger){

        try{
            ReusableMethods.type(driver, SplashScreen_POM.searchField(driver, logger), cityName, logger, "City Search Field");

            Thread.sleep(4000);
            ReusableMethods.selectFromListByText(driver, SplashScreen_POM.autosuggestionList(driver, logger), cityName, logger);


            ReusableMethods.Click(driver, SplashScreen_POM.checkInButton(driver, logger), logger, "Calendar CheckIn Button");

            CalendarDateSelection(driver, checkInDate, checkoutDate, logger);

            ReusableMethods.Click(driver, SplashScreen_POM.SearchButton(driver, logger), logger, "Search Button");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    // Calendar date selection logic
    private void CalendarDateSelection(WebDriver driver,
                                      String checkInDate, String checkoutDate, ExtentTest logger) throws InterruptedException, IOException {

        WebElement calendarYear = SplashScreen_POM.calendarYear(driver, logger),
                calendarMonth = SplashScreen_POM.calendarMonth(driver, logger);

        // Check in date selection
        String checkinMonth = checkInDate.split("-")[1];
        String checkinYear = checkInDate.split("-")[2];
        int userInputCheckinDate = Integer.parseInt(checkInDate.split("-")[0]);

        while(!(checkinMonth.equalsIgnoreCase(calendarMonth.getText()) && checkinYear.equalsIgnoreCase(calendarYear.getText()))){
            ReusableMethods.Click(driver, SplashScreen_POM.calendarNextButton(driver, logger), logger, "Calendar Next Button");
        }

        Thread.sleep(1000);
        ReusableMethods.selectFromListByText(driver, SplashScreen_POM.calendarDates(driver, logger),
                String.valueOf(userInputCheckinDate), logger);

        // Check out date selection
        String checkoutMonth = checkoutDate.split("-")[1];
        String checkoutYear = checkoutDate.split("-")[2];
        int userInputCheckoutDate = Integer.parseInt(checkoutDate.split("-")[0]);

        while(!(checkoutMonth.equalsIgnoreCase(calendarMonth.getText()) && checkoutYear.equalsIgnoreCase(calendarYear.getText()))){
            ReusableMethods.Click(driver, SplashScreen_POM.calendarNextButton(driver, logger), logger, "Calendar Next Button");
        }

        Thread.sleep(1000);
        ReusableMethods.selectFromListByText(driver, SplashScreen_POM.calendarDates(driver, logger),
                String.valueOf(userInputCheckoutDate), logger);

        ReusableMethods.Click(driver, SplashScreen_POM.calendarDoneButton(driver, logger), logger, "Calendar Done Button");
    }
}
