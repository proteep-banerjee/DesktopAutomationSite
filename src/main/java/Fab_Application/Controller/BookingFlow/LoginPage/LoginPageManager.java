package Fab_Application.Controller.BookingFlow.LoginPage;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;

public class LoginPageManager {

    public void Validate_TC(WebDriver driver, String mobileNumber, String OTP){

        try{
            /*Thread.sleep(500);
            driver.findElement(UiAddresses.mobileNumberField).sendKeys(mobileNumber);
            Thread.sleep(500);
            driver.findElement(UiAddresses.continueButton).click();
            Thread.sleep(1000);
            driver.findElement(UiAddresses.otpField).sendKeys(OTP);
            Thread.sleep(500);
            driver.findElement(UiAddresses.getSatrtedButton).click();
            Thread.sleep(500);
            driver.findElement(UiAddresses.homeButton).click();*/

            ReusableMethods.FindElement(driver, UiAddresses.mobileNumberField).sendKeys(mobileNumber);
            ReusableMethods.FindElement(driver, UiAddresses.continueButton).click();
            ReusableMethods.FindElement(driver, UiAddresses.otpField).sendKeys(OTP);
            ReusableMethods.FindElement(driver, UiAddresses.getSatrtedButton).click();
            ReusableMethods.FindElement(driver, UiAddresses.homeButton).click();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
