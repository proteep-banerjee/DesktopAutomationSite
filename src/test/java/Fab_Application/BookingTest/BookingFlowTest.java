package Fab_Application.BookingTest;

import Fab_Application.Config.DeviceConfiguration;
import Fab_Application.Controller.BookingFlow.LoginFunctionality.LoginFunctionality_Manager;
import Fab_Application.Controller.BookingFlow.LoginPage.LoginPageManager;
import Fab_Application.Controller.BookingFlow.PropertyDetailPage.PDP_Manager;
import Fab_Application.Controller.BookingFlow.SearchCityPage.SearchCityManager;
import Fab_Application.Controller.BookingFlow.SearchResultPage.SRP_Manager;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BookingFlowTest {

    private static String firstServer = "fabhotels_uat";
    private static String browserName = "chrome";



    private static WebDriver driver = null;

    @Test(priority = 0, enabled = true)
    public void loginButton() {

        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", DeviceConfiguration.DeviceName);

        Map<String, Object> optionlist = new HashMap<String, Object>();
        optionlist.put("mobileEmulation", mobileEmulation);

        try {

            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer, optionlist);
            new LoginFunctionality_Manager().Validate_TC(driver);

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,
            enabled = true, priority = 1)
    public void loginFunctionalityTest(String MobileNumber, String OTP){

        try{
            new LoginPageManager().Validate_TC(driver, MobileNumber, OTP);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class,
            enabled = true, priority = 2)
    public void searchCityTest(String cityName, String checkInDate, String checkoutDate){

        try{
            new SearchCityManager().Validate_TC(driver, cityName, checkInDate, checkoutDate);
        }
        catch(Exception e){
            e.printStackTrace();
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
            new PDP_Manager().Validate_TC(driver);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
