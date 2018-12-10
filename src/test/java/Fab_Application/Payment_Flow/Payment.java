package Fab_Application.Payment_Flow;

import Fab_Application.Controller.BookingFlow.HomePage.HomePage_Manager;
import Fab_Application.Controller.BookingFlow.LoginPage.LoginPageManager;
import Fab_Application.Controller.BookingFlow.SearchCityPage.SearchCityManager;
import Fab_Application.Controller.BookingFlow.SearchResultPage.SRP_Manager;
import Fab_Application.Controller.Payment.PDPScreen.PDP_Manager;
import Fab_Application.Controller.Payment.PaymentScreen.Payment_Manager;
import Fab_Application.Controller.Payment.ReviewPage.Review_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
/*

 */
public class Payment extends BaseTestClass {

    WebDriver driver = null;

    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";

    HomePage_Manager homePage_manager = new HomePage_Manager();
    LoginPageManager loginPageManager = new LoginPageManager();
    SearchCityManager searchCityManager = new SearchCityManager();
    SRP_Manager srp_manager = new SRP_Manager();
    PDP_Manager pdp_manager = new PDP_Manager();
    Review_Manager review_manager = new Review_Manager();
    Payment_Manager payment_manager = new Payment_Manager();


    //End To End Flow
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class, enabled = true)

    public void PaymentFlow(String mobileNumber, String otp,String cityName,String checkInDate,String guestNumber,String PropertyName,
    		String cardNumber, String month, String year, String cvv, String CardName) throws IOException, InterruptedException {

        logger = extent.startTest("End To End Payment Flow");
        driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);


        homePage_manager.Validate_TC(driver, logger);
        loginPageManager.Validate_TC(driver, mobileNumber, otp, logger);
        searchCityManager.Validate_TC(driver, cityName, checkInDate, guestNumber, logger);
        srp_manager.Validate_TC(driver, PropertyName, logger);
        pdp_manager.Validate_TC(driver, logger);
        review_manager.validateTC(driver,logger);


        //DriverHelper.closeBrowser(driver);

        payment_manager.validateTC(logger, driver,cardNumber, month, year, cvv, CardName);
    }
    @AfterClass
    public void TearDown(){
        driver.quit();
    }
}

