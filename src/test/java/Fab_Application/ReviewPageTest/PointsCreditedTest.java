package Fab_Application.ReviewPageTest;


/**
 * Created By - Kalpana
 */

import Fab_Application.Controller.HomePage.HomePage_Manager_withoutValidations;
import Fab_Application.Controller.LoginPage.LoginPage_Manager_withoutValidations;
import Fab_Application.Controller.PropertyDetailPage.PDP_Manager_withoutValidations;
import Fab_Application.Controller.ReviewPage.ReviewPage_Manager_withValidations.Review_PointsCredited_Manager;
import Fab_Application.Controller.SearchResultPage.SRP_Manager_withoutValidations;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class PointsCreditedTest extends BaseTestClass {

    private static String firstServer = "fabhotels_prod";
    private static String browserName = "browserName";
    String userType ="";
   

    private static WebDriver driver = null;

    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,
            enabled = true)
    public void PointsCreditedTest(String MobileNumber, String OTP,String cityName,String checkInMonth, String checkInDate,
            String guestNumber, String PropertyName){

        try{
            logger = extent.startTest("Coupon Test");
            System.out.println("firstServer "+ firstServer);
            driver = DriverHelper.initiateBrowserInstance(browserName,firstServer);

            new HomePage_Manager_withoutValidations().clickLoginButton(driver,logger);
            new LoginPage_Manager_withoutValidations().SimpleLogin(driver, MobileNumber, OTP, logger);
            new HomePage_Manager_withoutValidations().searchProperty(driver,cityName,checkInMonth,checkInDate,guestNumber,logger);
            new SRP_Manager_withoutValidations().SRP_Redirection(driver, PropertyName, logger);
            userType =  new PDP_Manager_withoutValidations().PDP_RedirectionAndUserType(driver,logger);
            new Review_PointsCredited_Manager().VerifyPointsCredited(driver,userType,logger);

            logger.log(LogStatus.PASS, "Points Credited Test has been tested successfully.");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "Points Credited Test has failed due to the following exception : " +
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
