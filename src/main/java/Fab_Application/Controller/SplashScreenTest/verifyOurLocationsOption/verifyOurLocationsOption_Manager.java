package Fab_Application.Controller.SplashScreenTest.verifyOurLocationsOption;

import Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class verifyOurLocationsOption_Manager {
    SoftAssert softAssert = new SoftAssert();

//    public void verifyOurLocationsOption(WebDriver driver, ExtentTest logger) throws IOException, InterruptedException {
//        String expectedLocations[] = {"New Delhi", "Bangalore", "Mumbai", "Chennai", "Goa", "Gurgaon",
//                                    "Hyderabad","Jaipur", "Pune", "Ahmedabad", "Amritsar", "Chandigarh",
//                                    "Coimbatore", "Indore", "Kochi", "Kolkata", "Mysore", "Noida", "Ooty",
//                                    "Pondicherry", "Udaipur", "Vijayawada", "Visakhapatnam"};
//        //clicking on toggle button
//        ReusableMethods.Click(driver, HomeScreen_POM.toggleButton(driver,logger));
//        //clicking on Our locations option
//        ReusableMethods.Click(driver, HomeScreen_POM.ourLocationsOption(driver,logger));
//        //fetching all locations
//        List<WebElement> List = HomeScreen_POM.getAllourLocations(driver,logger);
//        List<String> locationNames = new ArrayList<String>();
//        for (WebElement location:List) {
//            locationNames.add(location.getText());
//        }
//        //validating all locations
//        for (int i = 0; i<expectedLocations.length; i++) {
//            if (locationNames.contains(expectedLocations[i])) {
//                System.out.println("Successfully verified location : "+expectedLocations[i]);
//            } else {
//                System.out.println("Failed to verify location : "+expectedLocations[i]);
//                Assert.assertTrue(false,"Failed to verify location : "+expectedLocations[i]);
//            }
//        }
//    }
}
