package Fab_Application.Controller.SRPTestManagers.ValidateNumberOfReviews;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Fab_Application.Controller.POM.SRPScreen.SRP_POM.ReviewCountList;

public class SRP_ValidateNumberOfReviews_Manager {

    SoftAssert softAssert = new SoftAssert();

    // Vaidate that the number of reviews for any given property on the SRP is not less than 5.
    public void Validate_TC(WebDriver driver, ExtentTest logger) throws IOException {

        ReusableMethods.scrollToEndLoads(driver);

        ReusableMethods.scrollup(driver);

        List<Integer> reviewCounts = new ArrayList<Integer>();

        for(WebElement element : ReviewCountList(driver, logger)){
//            System.out.println(element.getText());
            reviewCounts.add(Integer.parseInt(element.getText().replaceAll("[^\\d.]", "")));
        }

        for (int i = 0; i < reviewCounts.size(); i++){
            softAssert.assertTrue(reviewCounts.get(i) >= 5, "Review Count is less than 5 at index : " + i);
        }

        softAssert.assertAll();
    }
}
