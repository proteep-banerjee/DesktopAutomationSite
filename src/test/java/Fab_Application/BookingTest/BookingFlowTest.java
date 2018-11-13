package Fab_Application.BookingTest;

import Fab_Application.Config.DeviceConfiguration;
import Fab_Application.Controller.BookingFlow.SplashScreen.SplashScreen_Manager;
import Fab_Application.Controller.BookingFlow.LoginPage.LoginPageManager;
import Fab_Application.Controller.BookingFlow.PropertyDetailPage.PDP_Manager;
import Fab_Application.Controller.BookingFlow.SearchCityPage.SearchCityManager;
import Fab_Application.Controller.BookingFlow.SearchResultPage.SRP_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BookingFlowTest extends BaseTestClass {

    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";



    private static WebDriver driver = null;

    @Test(priority = 0, enabled = true)
    public void loginButton() {

        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", DeviceConfiguration.DeviceName);

        Map<String, Object> optionlist = new HashMap<String, Object>();
        optionlist.put("mobileEmulation", mobileEmulation);

        try {
            logger = extent.startTest("Login Button");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer, optionlist);
            new SplashScreen_Manager().Validate_TC(driver, logger);
            logger.log(LogStatus.PASS, "User has been redirected to the login screen" +
                    " successfully.");

        }
        catch (InterruptedException e) {
            logger.log(LogStatus.FAIL, "User could not be redirected to the login screen due to the following exception : " +
                    "<br>" + e.getMessage());
        }
    }
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,
            enabled = true, priority = 1)
    public void loginFunctionalityTest(String MobileNumber, String OTP){

        try{
            logger = extent.startTest("Login Functionality Test");
            new LoginPageManager().Validate_TC(driver, MobileNumber, OTP, logger);
            logger.log(LogStatus.PASS, "User has logged in successfully and has been redirected to the home screen.");
        }
        catch (Exception e){
            logger.log(LogStatus.FAIL, "User failed to logged in due to the following exception : " +
                    "<br>" + e.getMessage());
        }
    }

    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,
            enabled = true, priority = 2)
    public void searchCityTest(String cityName, String checkInDate, String checkoutDate){

        try{
            logger = extent.startTest("Search Hotel Test");
            new SearchCityManager().Validate_TC(driver, cityName, checkInDate, checkoutDate, logger);
            logger.log(LogStatus.PASS, "User was able to search hotels in " + cityName + " between dates " + checkInDate + " and " + checkoutDate
            + ". The user has been redirected to the SRP screen.");
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, "User failed to perform search due to the following exception : " +
                    "<br>" + e.getMessage());
        }
    }

    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,
            enabled = true, priority = 3)
    public void SRPTest(String PropertyName){
        try{
            new SRP_Manager().Validate_TC(driver, PropertyName);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(enabled = true, priority = 4)
    public void PDPTest(){
        try{
            logger = extent.startTest("PDPTest");
            new PDP_Manager().Validate_TC(driver, logger);
            logger.log(LogStatus.PASS, "User has been redirected to the payment page successfully");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
