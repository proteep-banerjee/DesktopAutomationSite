package Fab_Application.Controller.BookingFlow.SearchCityPage;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import static Fab_Application.Constants.UiAddresses.calendar_monthYearDisplay;
import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.*;

public class SearchCityManager {

    public void Validate_TC(WebDriver driver, String cityName,String checkInDate, String guestNum,
                                        ExtentTest logger) throws IOException, InterruptedException {


        ReusableMethods.type(driver, searchField(driver, logger), cityName);

        Thread.sleep(4000);

        ReusableMethods.selectFromListByText(driver, autosuggestionList(driver, logger), cityName);

        ReusableMethods.Click(driver, CheckinButton(driver, logger));
        
        Thread.sleep(3000);
   
        CalendarDateSelection(driver,checkInDate,logger);
        ReusableMethods.wait(3);
  
        ReusableMethods.Click(driver, guestIcon(driver,logger));
        ReusableMethods.wait(2);
        ReusableMethods.Click(driver, selectGuest(driver,logger,guestNum));
        ReusableMethods.Click(driver, SearchButton(driver, logger));
    }


    // Calendar date selection logic
    private void CalendarDateSelection(WebDriver driver,String Date, ExtentTest logger)
            throws IOException {

        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        String monthYear = ReusableMethods.getText(driver,calendar_monthYearDisplay,logger);
        String[] monthYearArray = monthYear.split("\\s");
        String month = monthYearArray[0];
        String year = monthYearArray[1];

        String[] checkInDateArr = Date.split("-");
        String toBeSelectedYear = checkInDateArr[2];
        String toBeSelectedMonth = checkInDateArr[1];
        String toBeSelectedDate = checkInDateArr[0];

        while(Integer.parseInt(toBeSelectedYear) > Integer.parseInt(year)){
            ReusableMethods.Click(driver,calendarNextButton(driver,logger));
        }
       
        boolean monthResult = month.equalsIgnoreCase(months[Integer.parseInt(toBeSelectedMonth) -1]);
        while(!month.equalsIgnoreCase(months[Integer.parseInt(toBeSelectedMonth) -1])) {
        	ReusableMethods.Click(driver,calendarNextButton(driver,logger));
        }
        
        if(month.equalsIgnoreCase(months[Integer.parseInt(toBeSelectedMonth) - 1])){
        	
            ReusableMethods.Click(driver, selectCalendarDates(driver,logger,toBeSelectedDate));
        }
        else {

            System.out.println("Desired month " +months[Integer.parseInt(toBeSelectedMonth) -1] + " not selected...  " +
                    "displayed month is " + month);
        }

        }

    }
