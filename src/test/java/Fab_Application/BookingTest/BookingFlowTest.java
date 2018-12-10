package Fab_Application.BookingTest;

import Fab_Application.Controller.BookingFlow.HomePage.HomePage_Manager;
import Fab_Application.Controller.BookingFlow.LoginPage.LoginPageManager;
import Fab_Application.Controller.BookingFlow.PropertyDetailPage.PDP_Manager;
import Fab_Application.Controller.BookingFlow.ReviewPage.Review_Manager;
import Fab_Application.Controller.BookingFlow.SearchCityPage.SearchCityManager;
import Fab_Application.Controller.BookingFlow.SearchResultPage.SRP_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class BookingFlowTest extends BaseTestClass {

    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static String adminFirstServer = "fabhotel_uat_adminPanel";

    private static WebDriver driver = null;
    WebDriver temp_driver = null;

    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,
            enabled = true)
    public void BookingFlow_Test(String MobileNumber, String OTP,String cityName, String checkInDate,
            String guestsNumber, String PropertyName,String adminUsername,String adminPassword){

        try{
            logger = extent.startTest("Booking Flow Test");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);

            new HomePage_Manager().Validate_TC(driver, logger);
            new LoginPageManager().Validate_TC(driver, MobileNumber, OTP, logger);
            new SearchCityManager().Validate_TC(driver, cityName, checkInDate, guestsNumber, logger);
            new SRP_Manager().Validate_TC(driver, PropertyName, logger);
            new PDP_Manager().Validate_TC(driver, logger);

            temp_driver = DriverHelper.initiateBrowserInstance(browserName, adminFirstServer);
            new Review_Manager().Validate_TC(driver,temp_driver,MobileNumber,adminUsername,adminPassword,logger);

            logger.log(LogStatus.PASS, "Booking flow has been tested successfully.");
        }
        catch (Exception e){
        	System.out.println(e.getMessage());
            logger.log(LogStatus.FAIL, "Booking flow test has failed due to the following exception : " + e.getMessage());
        }
    }

    @AfterClass
    public void teardown() throws InterruptedException{
    	
    	Thread.sleep(10000);
    	System.out.println("Quitting the driver");
    	
        driver.quit();
    }
}
