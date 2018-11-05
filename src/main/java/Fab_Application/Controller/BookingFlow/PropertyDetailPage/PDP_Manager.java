package Fab_Application.Controller.BookingFlow.PropertyDetailPage;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class PDP_Manager {

    public void Validate_TC(WebDriver driver) throws IOException {

        ReusableMethods.FindElement(driver, UiAddresses.EditButton).click();
        ReusableMethods.FindElement(driver, UiAddresses.BookNowButton).click();
        ReusableMethods.FindElement(driver, UiAddresses.PayAtHotel).click();
    }
}
