package Fab_Application.Controller.SearchResultPage.SRPTest_Managers_withValidatons;

/**
 * Created by Proteep Banerjee
 */

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Fab_Application.Controller.POM.SRPScreen.SRP_POM.*;

public class SRP_ValidateRatings_Manager {

    SoftAssert softAssert = new SoftAssert();

    // To verify the ratings and the reviews on the SRP are correct.
    public void ValidatePropertyRatings(WebDriver driver, ExtentTest logger) throws IOException {

        ReusableMethods.scrollToEndLoads(driver);

        ReusableMethods.scrollup(driver);

        List<Double> Stars = new ArrayList<Double>();
        List<String> Reviews = new ArrayList<String>();

        //Adding the number of stars in a list.
        for(WebElement star : RatingStars(driver, logger)){
            //System.out.println(star.getText());
            Stars.add(Double.parseDouble(star.getText()));
        }

        //Adding the review for a particular star in a list
        for(WebElement review : RatingReviews(driver,logger)){
            //System.out.println(review.getText());
            Reviews.add(review.getText());
        }

       Assert.assertEquals(Stars.size(), Reviews.size(), "The number of ratings and " +
               "reviews mismatched on SRP");


        //Iterating through the list of stars to verify the values.
        for (int i = 0; i < Stars.size(); i++){
            if(Stars.get(i) < 4.0)
                softAssert.assertTrue(Reviews.get(i).startsWith("Good"), "Rating and reviews mismatched.");

            else if(Stars.get(i) > 3.9 && Stars.get(i) < 4.5)
                softAssert.assertTrue(Reviews.get(i).startsWith("Very Good"), "Rating and reviews mismatched.");

            else
                softAssert.assertTrue(Reviews.get(i).startsWith("Fabulous"), "Rating and reviews mismatched.");
        }

        softAssert.assertAll();

    }
}
