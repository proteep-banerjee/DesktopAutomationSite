package Fab_Application.Controller.HomeScreenTestManagers.verifyAllLinks;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomeScreen_AllLinks_Manager {
    SoftAssert softAssert = new SoftAssert();

    //To verify all links present on the home page are working properly
    public void verifyAllLinks(WebDriver driver, ExtentTest logger) throws IOException {
        String url = "";
        HttpURLConnection huc = null;
        int linksNotWorking = 0;
        int respCode = 200;

        List<WebElement> links = ReusableMethods.FindElements(driver, UiAddresses.homeScreen_allLinks, logger);

        Iterator<WebElement> it = links.iterator();
        while (it.hasNext()) {
            url = it.next().getAttribute("href");
            System.out.println(url);
            if (url == null || url.isEmpty()) {
                continue;
            }
            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
                List<String> brokenLinks = new ArrayList();
                if (respCode >= 400) {
                    System.out.println(url + " is a broken link.");
                    brokenLinks.add(url);
                    linksNotWorking++;
                } else {
                    System.out.println(url + " is a valid link.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Broken Links : "+linksNotWorking);
        if (linksNotWorking > 0) {
            softAssert.assertTrue(false);
            softAssert.assertAll();
        } else {
            softAssert.assertTrue(true);
            softAssert.assertAll();
        }
    }
}
