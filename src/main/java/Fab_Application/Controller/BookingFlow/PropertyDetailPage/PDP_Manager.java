package Fab_Application.Controller.BookingFlow.PropertyDetailPage;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


import static Fab_Application.Controller.POM.PropertyDetailPage.PDP_POM.*;

public class PDP_Manager {

    public void Validate_TC(WebDriver driver, ExtentTest logger) throws IOException {

  //      ReusableMethods.Click(driver, EditButton(driver, logger));

    	

        ReusableMethods.Click(driver, BookNowButton(driver, logger));
        ReusableMethods.scrollToEndLoads(driver);
        ReusableMethods.Click(driver,ContinueButton(driver,logger));
//        ReusableMethods.Click(driver, PayAtHotel(driver, logger));
//
//        ReusableMethods.getPageTitle(driver, "Checkout Confirmation - FabHotels.com");
//
//        //OTP Validation
//        ReusableMethods.Click(driver,ConfirmBooking(driver,logger));



    }
}

