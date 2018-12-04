package Fab_Application.SplashScreenTest;

import Fab_Application.Config.DeviceConfiguration;
import Fab_Application.Constants.Constants;
import Fab_Application.Controller.SplashScreenTest.verifyAutoSearchSuggestion.verifyAutoSearchSuggestion_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Helper.Data.TestDataHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class verifySearchTest extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

    //To verify search suggestions are as per the input in the searchfield
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class, enabled = true, priority = 0)
    public void verifySearch(String location) {
        try {
            logger = extent.startTest("verifySearch");
            driver = DriverHelper.initiateBrowserInstance(browserName, firstServer);
            //new verifyAutoSearchSuggestion_Manager().VerifyAutoSearchSuggestion(driver,location, logger);
            logger.log(LogStatus.PASS, "Successfully verified all the search suggestions.");


        }
        catch (Exception e) {
            logger.log(LogStatus.FAIL, "Failed to verify the search suggestions."+e.getMessage());
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }

























    //################################TO DO##############################################
    //To verify user membership is correctly displayed and is same as on hamberger after clicking on membership option on hamberger
 /*       @Test(dataProvider = "ExcelDataProvider", dataProviderClass = TestDataHelper.class, enabled = false, priority = 16)
        public void verifyUserMembership_Manager(String mobile, String OTP, String TextOnWelcomeScreen) {
            try{
                System.out.println(TextOnWelcomeScreen);

                logger = extent.startTest("verifyUserMembership_Manager");
                new verifyLoginWithValidCredentials_Manager().verifyLoginWithValidCredentials_Manager(driver,mobile,OTP, logger);
                new verifyUserMembership_Manager().verifyUserMembership_Manager(driver, mobile, OTP, TextOnWelcomeScreen, logger);
                logger.log(LogStatus.PASS, "Successfully verified correct user information is displayed on the welcome page");
            }
            catch (Exception e){
                logger.log(LogStatus.FAIL, "Failed to verify user information on welcome page" + e.getMessage());
            }
        }*/








}
