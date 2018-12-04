package Fab_Application.HomePageTest;

import Fab_Application.Config.DeviceConfiguration;
import Fab_Application.Constants.Constants;
import Fab_Application.Controller.SplashScreenTest.verifyCityCarousalHomePage.verifyCityCarousalHomePage_Manager;
import Fab_Application.Helper.Common.BaseTestClass;
import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class verifyCityCarousalHomePageManagerTest extends BaseTestClass {
    private static String firstServer = "fabhotels_uat";
    private static String browserName = "browserName";
    private static WebDriver driver = null;

//    //To verify city carousal on home page scrolls properly
//    @Test(enabled = true)
//    public void verifyCityCarousalHomePage() {
//
//        try{
//            logger = extent.startTest("verifyCityCarousalHomePage_Manager");
//            driver = DriverHelper.initiateMwebBrowserInstance(browserName, firstServer, Constants.mobileWebCapabilities(DeviceConfiguration.DeviceName));
//            new verifyCityCarousalHomePage_Manager().cityCarousalHomePage(driver, logger);
//            logger.log(LogStatus.PASS, "Successfully verified that city carousal scrolls properly");
//        }
//        catch (Exception e){
//            logger.log(LogStatus.FAIL, "City carousal is not getting scrolled properly" + e.getMessage());
//        }
//    }
//
//    @AfterClass
//    void tearDown(){
//        driver.quit();
//    }
}
