package Fab_Application.Controller.SRPTestCases.HomeScreen;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.*;

public class HomeScreenManager {

    public void Validate_TC(WebDriver driver, String cityName,
                            String checkInDate, String checkoutDate, ExtentTest logger) throws IOException, InterruptedException {

//            if(installAppClose(driver, logger).size() > 0){
//                    for(WebElement element : installAppClose(driver, logger)){
//                            ReusableMethods.Click(driver, element);
//                    }
//            }
            ReusableMethods.type(driver, searchField(driver, logger), cityName);
            Thread.sleep(4000);
            ReusableMethods.selectFromListByText(driver, autosuggestionList(driver, logger), cityName);
     //       ReusableMethods.Click(driver, checkInButton(driver, logger));
       //     ReusableMethods.calendar_CheckIn(driver, checkInDate, checkoutDate);
        //    ReusableMethods.Click(driver, calendarDoneButton(driver, logger));
            ReusableMethods.Click(driver, SearchButton(driver, logger));
            Thread.sleep(2000);

    }

    /*// Calendar date selection logic
=======

            CalendarDateSelection(driver, checkInDate, checkoutDate, logger);
            ReusableMethods.Click(driver, SearchButton(driver, logger));

    }

    // Calendar date selection logic
>>>>>>> remotes/origin/MWebAutomation_Bhupesh
    private void CalendarDateSelection(WebDriver driver,
                                      String checkInDate, String checkoutDate, ExtentTest logger) throws InterruptedException, IOException {

        WebElement calendarYear = calendarYear(driver, logger),
                calendarMonth = calendarMonth(driver, logger);

        // Check in date selection
        String checkinMonth = checkInDate.split("-")[1];
        String checkinYear = checkInDate.split("-")[2];
        int userInputCheckinDate = Integer.parseInt(checkInDate.split("-")[0]);

        while(!(checkinMonth.equalsIgnoreCase(calendarMonth.getText()) && checkinYear.equalsIgnoreCase(calendarYear.getText()))){
            ReusableMethods.Click(driver, calendarNextButton(driver, logger));
        }

        Thread.sleep(1000);
        ReusableMethods.selectFromListByText(driver, calendarDates(driver, logger),
                String.valueOf(userInputCheckinDate));

        // Check out date selection
        String checkoutMonth = checkoutDate.split("-")[1];
        String checkoutYear = checkoutDate.split("-")[2];
        int userInputCheckoutDate = Integer.parseInt(checkoutDate.split("-")[0]);

        while(!(checkoutMonth.equalsIgnoreCase(calendarMonth.getText()) && checkoutYear.equalsIgnoreCase(calendarYear.getText()))){
            ReusableMethods.Click(driver, calendarNextButton(driver, logger));
        }

        Thread.sleep(1000);
        ReusableMethods.selectFromListByText(driver, calendarDates(driver, logger),
                String.valueOf(userInputCheckoutDate));

        ReusableMethods.Click(driver, calendarDoneButton(driver, logger));
<<<<<<< HEAD
    }*/
    }
