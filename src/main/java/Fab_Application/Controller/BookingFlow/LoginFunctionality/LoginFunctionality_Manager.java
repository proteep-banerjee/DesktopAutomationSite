package Fab_Application.Controller.BookingFlow.LoginFunctionality;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFunctionality_Manager {

    public void Validate_TC(WebDriver driver){

        try {

            ReusableMethods.FindElement(driver, UiAddresses.installAppClose).click();

            ReusableMethods.FindElement(driver,UiAddresses.loginButton).click();

        }
        catch(Exception e){

            e.printStackTrace();

        }
    }
}
