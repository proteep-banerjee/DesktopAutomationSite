package Fab_Application.ReviewPageTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Fab_Application.Controller.BookingFlow.HomePage.HomePage_Manager;
import Fab_Application.Controller.BookingFlow.LoginPage.LoginPageManager;
import Fab_Application.Controller.BookingFlow.SearchCityPage.SearchCityManager;
import Fab_Application.Controller.BookingFlow.SearchResultPage.SRP_Manager;
import Fab_Application.Controller.ReviewPageTestCase.PropertyDetailPage.PDP_Manager;
import Fab_Application.Controller.ReviewPageTestCase.ReviewPage.PointsCredited.Review_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;

public class PointsCreditedTest extends BaseTestClass {

    private static String firstServer = "fabhotels_prod";
    private static String browserName = "Chrome";
    String userType ="";
   

    private static WebDriver driver = null;

    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,
            enabled = true)
    public void PreAppliedCouponsTest(String MobileNumber, String OTP,String cityName, String checkInDate,
            String guestsNumber, String PropertyName){

        try{
            logger = extent.startTest("Coupon Test");
            driver = DriverHelper.initiateWebBrowserInstance(browserName, firstServer);

            new HomePage_Manager().Validate_TC(driver, logger);
            new LoginPageManager().Validate_TC(driver, MobileNumber, OTP, logger);
            new SearchCityManager().Validate_TC(driver, cityName, checkInDate, guestsNumber, logger);
            new SRP_Manager().Validate_TC(driver, PropertyName, logger);
            userType =  new PDP_Manager().Validate_TC(driver, logger);
            new Review_Manager().Validate_TC(driver,userType,logger);

            logger.log(LogStatus.PASS, "Booking flow has been tested successfully.");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "Booking flow test has failed due to the following exception : " +
                    "<br>" + e.getMessage());
        }
    }

    @AfterTest
    public void teardown() throws InterruptedException{
    	
    	Thread.sleep(10000);
    	System.out.println("Quitting the driver");
    	
        driver.quit();
    }

}
