package Fab_Application.Payment_Flow;

import Fab_Application.Controller.HomePage.HomePage_Manager_withoutValidations;
import Fab_Application.Controller.LoginPage.LoginPage_Manager_withoutValidations;
import Fab_Application.Controller.PaymentPage.Payment_PaymentFlow_Manager;
import Fab_Application.Controller.PropertyDetailPage.PDP_Managers_withValidations.PDP_PaymentFlow_Manager;
import Fab_Application.Controller.ReviewPage.ReviewPage_Manager_withValidations.Review_Payment_Manager;
import Fab_Application.Controller.SearchResultPage.SRP_Manager_withoutValidations;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created By - Kalpana
 */
public class Payment extends BaseTestClass {

    WebDriver driver = null;

    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";

    //End To End Flow
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class, enabled = true)

    public void PaymentFlow(String mobileNumber, String otp,String cityName,String checkInMonth,String checkInDate,String guestNumber,String PropertyName,
    		String cardNumber,String month,String year,String cvv,String CardName) throws IOException, InterruptedException{

        logger = extent.startTest("End To End Payment Flow");
        driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);

        new HomePage_Manager_withoutValidations().clickLoginButton(driver,logger);
        new LoginPage_Manager_withoutValidations().SimpleLogin(driver, mobileNumber, otp, logger);
        new HomePage_Manager_withoutValidations().searchProperty(driver,cityName,checkInMonth,checkInDate,guestNumber,logger);
        new SRP_Manager_withoutValidations().SRP_Redirection(driver, PropertyName, logger);
        new PDP_PaymentFlow_Manager().ValidateDetailsOnPage(driver, logger);
        new Review_Payment_Manager().redirectToPaymentPage(driver,logger);
        new Payment_PaymentFlow_Manager().completePayment(logger, driver,cardNumber, month, year, cvv, CardName);
    }
    @AfterClass
    public void TearDown(){
        driver.quit();
    }
}

