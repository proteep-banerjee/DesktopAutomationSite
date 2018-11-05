package Fab_Application.Controller.BookingFlow.SearchCityPage;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class SearchCityManager {

    public void Validate_TC(WebDriver driver, String cityName,
                            String checkInDate, String checkoutDate){

        try{
            ReusableMethods.FindElement(driver, UiAddresses.CitySearchField).sendKeys(cityName);

            Thread.sleep(4000);
            List<WebElement> cities = ReusableMethods.FindElements(driver, UiAddresses.autosuggestionList);  //driver.findElements(UiAddresses.autosuggestionList);

            for(WebElement city : cities){
                if(city.getText().equalsIgnoreCase(cityName)){
                    city.click();
                    break;
                }
            }


            ReusableMethods.FindElement(driver, UiAddresses.checkinButton).click();

            CalendarDateSelection(driver, checkInDate, checkoutDate);


            ReusableMethods.FindElement(driver, UiAddresses.DoneButton).click();


            ReusableMethods.FindElement(driver, UiAddresses.SearchButton).click();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    // Calendar date selection logic
    private void CalendarDateSelection(WebDriver driver,
                                      String checkInDate, String checkoutDate) throws InterruptedException, IOException {

        WebElement nextButton = ReusableMethods.FindElement(driver, UiAddresses.nextButton),
                calendarYear = ReusableMethods.FindElement(driver, UiAddresses.calendarYear),
                calendarMonth = ReusableMethods.FindElement(driver, UiAddresses.calendarMonth);

        // Check in date selection
        String checkinMonth = checkInDate.split("-")[1];
        String checkinYear = checkInDate.split("-")[2];
        int userInputCheckinDate = Integer.parseInt(checkInDate.split("-")[0]);

        while(!(checkinMonth.equalsIgnoreCase(calendarMonth.getText()) && checkinYear.equalsIgnoreCase(calendarYear.getText()))){
            nextButton.click();
        }

        Thread.sleep(1000);

        List<WebElement> calendarDates = ReusableMethods.FindElements(driver, UiAddresses.calendarDateList);

        for(WebElement calendarDate : calendarDates){
            if(calendarDate.getText().equals(String.valueOf(userInputCheckinDate))){
                calendarDate.click();
                break;
            }
        }

        // Check out date selection
        String checkoutMonth = checkoutDate.split("-")[1];
        String checkoutYear = checkoutDate.split("-")[2];
        int userInputCheckoutDate = Integer.parseInt(checkoutDate.split("-")[0]);

        while(!(checkoutMonth.equalsIgnoreCase(calendarMonth.getText()) && checkoutYear.equalsIgnoreCase(calendarYear.getText()))){
            nextButton.click();
        }

        Thread.sleep(1000);

        calendarDates = ReusableMethods.FindElements(driver, UiAddresses.calendarDateList);

        for(WebElement calendarDate : calendarDates){
            if(calendarDate.getText().equals(String.valueOf(userInputCheckoutDate))){
                calendarDate.click();
                break;
            }
        }

    }
}
