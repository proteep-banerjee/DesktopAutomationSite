package Fab_Application.Controller.BookingFlow.PropertyDetailPage;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class PDP_Manager {

    public void Validate_TC(WebDriver driver, ExtentTest logger) throws IOException {

        ReusableMethods.Click(driver, PDP_POM.EditButton(driver, logger), logger, "Edit Button");
        ReusableMethods.Click(driver, PDP_POM.BookNowButton(driver, logger), logger, "Book Now Button");

    }
}
