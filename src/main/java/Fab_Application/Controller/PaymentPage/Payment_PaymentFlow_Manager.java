package Fab_Application.Controller.PaymentPage;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

import static Fab_Application.Controller.POM.PaymentScreen.Payment_POM.*;


/**
 * Created By - Kalpana
 */
public class Payment_PaymentFlow_Manager {

    //  WebDriver driver=null;

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

        WebElement text = ReusableMethods.FindElement(driver,UiAddresses.bookingConfirmationText,logger);
        String confirmationText = text.getAttribute("innerText");

        // String confirmationText = ReusableMethods.getText(driver, UiAddresses.bookingConfirmationText, logger);
        System.out.println("confirmationText "+ confirmationText);
        String bookingId = "";
        if(confirmationText.equalsIgnoreCase("Booking Confirmed!")) {

            bookingId = ReusableMethods.getText(driver, UiAddresses.bookingId, logger);
            System.out.println(bookingId);
            logger.log(LogStatus.PASS, "booking created successfully with "+ bookingId);
            Assert.assertTrue(true);
        }
        else {
            System.out.println("Booking creation failed ");
            logger.log(LogStatus.FAIL, "booking creation Failed ");
            Assert.assertTrue(false);
        }


    }
}