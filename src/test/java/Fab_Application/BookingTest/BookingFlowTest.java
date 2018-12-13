package Fab_Application.BookingTest;


/**
 * Created By - Kalpana
 */

import Fab_Application.Controller.HomePage.HomePage_Manager_withoutValidations;
import Fab_Application.Controller.LoginPage.LoginPage_Manager_withoutValidations;
import Fab_Application.Controller.PropertyDetailPage.PDP_Manager_withoutValidations;
import Fab_Application.Controller.ReviewPage.ReviewPage_Manager_withoutValidations;
import Fab_Application.Controller.SearchResultPage.SRP_Manager_withoutValidations;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class BookingFlowTest extends BaseTestClass {

    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static String adminServer = "fabhotel_uat_adminPanel";

    private static WebDriver driver = null;

    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,
            enabled = true)
    public void BookingFlow_Test(String MobileNumber, String OTP,String cityName,
                                 String checkInMonth, String checkInDate,String guestsNumber, String PropertyName,String adminUsername,String adminPassword){

        try{
            logger = extent.startTest("Booking Flow Test");
            driver = DriverHelper.initiateBrowserInstance(browserName,firstServer);

            new HomePage_Manager_withoutValidations().clickLoginButton(driver,logger);
            new LoginPage_Manager_withoutValidations().SimpleLogin(driver, MobileNumber, OTP, logger);
            new HomePage_Manager_withoutValidations().searchProperty(driver,cityName,checkInMonth,checkInDate,guestsNumber,logger);
            new SRP_Manager_withoutValidations().SRP_Redirection(driver, PropertyName, logger);
            new PDP_Manager_withoutValidations().PDP_Redirection(driver, logger);
            WebDriver temp_driver = DriverHelper.initiateBrowserInstance(browserName,adminServer);
            new ReviewPage_Manager_withoutValidations().ReviewPageRedirection(driver,temp_driver,MobileNumber,adminUsername,adminPassword,logger);

            logger.log(LogStatus.PASS, "Booking flow has been tested successfully.");
        }
        catch (Exception e){
        	System.out.println(e.getMessage());
            logger.log(LogStatus.FAIL, "Booking flow test has failed due to the following exception : " + e.getMessage());
        }
    }

    @AfterTest
    public void teardown() throws InterruptedException{
    	
    	Thread.sleep(10000);
    	System.out.println("Quitting the driver");
    	
        driver.quit();
    }
}
