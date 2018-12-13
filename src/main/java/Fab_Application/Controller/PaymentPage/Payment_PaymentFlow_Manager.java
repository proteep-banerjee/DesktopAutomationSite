package Fab_Application.Controller.PaymentPage;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static Fab_Application.Controller.POM.PaymentScreen.Payment_POM.*;


/**
 * Created By - Kalpana
 */
public class Payment_PaymentFlow_Manager {

    WebDriver driver=null;

    public void completePayment(ExtentTest logger, WebDriver driver, String cardNumber, String month, String year, String cvv, String CardName) throws IOException, InterruptedException {

        ReusableMethods.Click(driver,CreditCard(driver,logger));
        ReusableMethods.wait(5);
        ReusableMethods.type(driver, CreditCardNumber(driver,logger), cardNumber);
        ReusableMethods.wait(5);
        ReusableMethods. type(driver,monthYear(driver,logger),month+year);
        ReusableMethods.type(driver, CreditCardCvvNumber(driver,logger),cvv);
        ReusableMethods.type(driver, fullName_Card(driver,logger),CardName);
        ReusableMethods.wait(5);
//        ReusableMethods.Click(driver,driver.findElement(UiAddresses.netBanking));
//        ReusableMethods.Click(driver,PaytmOption(driver,logger));
//        ReusableMethods.Click(driver, paytmRadioButton(driver,logger));
        ReusableMethods.Click(driver,Pay(driver,logger));
//        ReusableMethods.Click(driver, paytmloginLink(driver,logger));
//        ReusableMethods.type(driver, paytmLoginField(driver,logger),"7777777777");
//        ReusableMethods.type(driver, paytmPasswordField(driver, logger),"Paytm12345");
//        ReusableMethods.Click(driver, paytmSecureLogin(driver,logger));
//        ReusableMethods.Click(driver, paytmWalletPayNow(driver,logger));
        
       
    }
}
