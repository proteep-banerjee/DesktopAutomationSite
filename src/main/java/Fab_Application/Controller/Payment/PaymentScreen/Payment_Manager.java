package Fab_Application.Controller.Payment.PaymentScreen;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Controller.POM.ReviewPage.Review_POM;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

import static Fab_Application.Constants.UiAddresses.*;
import static Fab_Application.Controller.POM.PaymentScreen.Payment_POM.*;
/*

 */
public class Payment_Manager {

    WebDriver driver=null;

    public void validateTC(ExtentTest logger, WebDriver driver, String cardNumber, String month, String year, String cvv, String CardName) throws IOException, InterruptedException {

        ReusableMethods.Click(driver,CreditCard(driver,logger));
        ReusableMethods.wait(5);
        ReusableMethods.enterValue(driver, CreditCardNumber(driver,logger), cardNumber);
        ReusableMethods.wait(5);
        ReusableMethods. type(driver,monthYear(driver,logger),month+year);
        ReusableMethods.type(driver, CreditCardCvvNumber(driver,logger),cvv);
        ReusableMethods.enterValue(driver, fullName_Card(driver,logger),CardName);
        ReusableMethods.wait(5);
//        ReusableMethods.Click(driver,driver.findElement(UiAddresses.netBanking));
        ReusableMethods.Click(driver,PaytmOption(driver,logger));
        ReusableMethods.Click(driver, paytmRadioButton(driver,logger));
        ReusableMethods.Click(driver,Pay(driver,logger));
        ReusableMethods.Click(driver, paytmloginLink(driver,logger));
        ReusableMethods.type(driver, paytmLoginField(driver,logger),"7777777777");
        ReusableMethods.type(driver, paytmPasswordField(driver, logger),"Paytm12345");
        ReusableMethods.Click(driver, paytmSecureLogin(driver,logger));
        ReusableMethods.Click(driver, paytmWalletPayNow(driver,logger));
        
       
    }
}
