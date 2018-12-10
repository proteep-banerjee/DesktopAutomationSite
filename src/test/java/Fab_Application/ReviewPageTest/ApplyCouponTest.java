package Fab_Application.ReviewPageTest;

import Fab_Application.Controller.BookingFlow.HomePage.HomePage_Manager;
import Fab_Application.Controller.BookingFlow.LoginPage.LoginPageManager;
import Fab_Application.Controller.BookingFlow.SearchCityPage.SearchCityManager;
import Fab_Application.Controller.BookingFlow.SearchResultPage.SRP_Manager;
import Fab_Application.Controller.ReviewPageTestCase.PropertyDetailPage.PDP_Manager;
import Fab_Application.Controller.ReviewPageTestCase.ReviewPage.ApplyCoupon.Review_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ApplyCouponTest extends BaseTestClass {

    private static String firstServer = "fabhotels_prod";
    private static String browserName = "browserName";
   

    private static WebDriver driver = null;

    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,
            enabled = true)
    public void ApplyCouponsTest(String MobileNumber, String OTP,String cityName, String checkInDate,
            String guestsNumber, String PropertyName, String couponCode, String discountPercentage){

        try{
            logger = extent.startTest("Coupon Test");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);

            new HomePage_Manager().Validate_TC(driver, logger);
            new LoginPageManager().Validate_TC(driver, MobileNumber, OTP, logger);
            new SearchCityManager().Validate_TC(driver, cityName, checkInDate, guestsNumber, logger);
            new SRP_Manager().Validate_TC(driver, PropertyName, logger);
            new PDP_Manager().Validate_TC(driver, logger);
            new Review_Manager().Validate_TC(driver,couponCode,Integer.parseInt(discountPercentage),logger);

            logger.log(LogStatus.PASS, "Booking flow has been tested successfully.");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "Booking flow test has failed due to the following exception : " +
                    "<br>" + e.getMessage());
        }
    }

    @AfterClass
    public void teardown() throws InterruptedException{
    	
    	Thread.sleep(10000);
    	System.out.println("Quitting the driver");
    	
        driver.quit();
    }

}
