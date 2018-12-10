package Fab_Application.Controller.HomeScreenTestManagers.verifyAllCities;

import Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.getMoreCities;
import static Fab_Application.Controller.POM.HomeScreen.HomeScreen_POM.moreCitesOption;


public class HomeScreen_AllCities_Manager {
    SoftAssert softAssert = new SoftAssert();

    //To verify "FabHotels in cities" option on the home screen is showing all the cities
    public void verifyOurLocationsOption(WebDriver driver, ExtentTest logger) throws IOException, InterruptedException {
        String cities[] = {"New Delhi", "Bangalore", "Mumbai", "Chennai", "Goa", "Gurgaon",
                            "Hyderabad","Jaipur", "Pune", "Kolkata", "Ahmedabad", "Amritsar",
                            "Chandigarh", "Coimbatore", "Indore", "Kochi", "Mysore", "Noida",
                            "Ooty", "Pondicherry", "Pune", "Udaipur", "Vijayawada", "Visakhapatnam"};
        //fetching all locations
        List<WebElement> List = HomeScreen_POM.getAllourLocations(driver,logger);
        List<String> locationNames = new ArrayList<String>();
        for (WebElement location:List) {
            if (location.getText().equalsIgnoreCase("More Cities")) {
                break;
            }
            locationNames.add(location.getText());
        }
        ReusableMethods.Click(driver,moreCitesOption(driver,logger));
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();
        Iterator<String> window = allWindow.iterator();
        while (window.hasNext()) {
            String childWindow = window.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                List<WebElement> moreCitiesName = getMoreCities(driver, logger);
                for(WebElement name : moreCitiesName) {
                    locationNames.add(name.getText());
                }
            }
        }
        //verifying all locations
        for (int i = 0; i<=cities.length-1; i++) {
            if (locationNames.contains(cities[i])) {
                System.out.println("Successfully verified location : "+cities[i]);
            } else {
                System.out.println("Failed to verify location : "+cities[i]);
                Assert.assertTrue(false,"Failed to verify location : "+cities[i]);
            }
        }
    }
}
