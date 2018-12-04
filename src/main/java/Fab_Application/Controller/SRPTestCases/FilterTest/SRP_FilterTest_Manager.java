package Fab_Application.Controller.SRPTestCases.FilterTest;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Fab_Application.Controller.POM.FilterScreen.FilterScreen_POM.*;
import static Fab_Application.Controller.POM.SRPScreen.SRP_POM.*;

public class SRP_FilterTest_Manager {

    SoftAssert softAssert = new SoftAssert();

     /*To validate that the prices of the properties displayed in the SRP are
     less than or equal to prices set by the filter.*/
    public void ValidateFilterPriceSlider(WebDriver driver, ExtentTest logger, String minimumDesiredPrice,
                                          String maximumDesiredPrice) throws IOException, InterruptedException {

        ReusableMethods.Click(driver, FooterBannerCloseIcon(driver, logger));

        //ReusableMethods.scrollIntoView(driver, FilterPriceSliderLeft(driver, logger));

        int currentLeftSliderPostion = Integer.parseInt(FilterLeftPriceSliderTooltip(driver, logger).
                getText().replaceAll("[^\\d.]", ""));

        int currentRightSliderPostion = Integer.parseInt(FilterRightPriceSliderTooltip(driver, logger).
                getText().replaceAll("[^\\d.]", ""));


        Assert.assertFalse(Integer.parseInt(maximumDesiredPrice) <= Integer.parseInt(minimumDesiredPrice),
                "Please enter correct input for price range.");

        Actions builder = new Actions(driver);

            while(currentLeftSliderPostion < Integer.parseInt(minimumDesiredPrice)){
                builder.dragAndDropBy(FilterPriceSliderLeft(driver, logger), 30, 0).
                        build().perform();

                currentLeftSliderPostion = Integer.parseInt(FilterLeftPriceSliderTooltip(driver, logger).
                        getText().replaceAll("[^\\d.]", ""));
            }

        Thread.sleep(1000);

            while(currentRightSliderPostion > Integer.parseInt(maximumDesiredPrice)){
                builder.dragAndDropBy(FilterPriceSliderRight(driver, logger), -30, 0).
                        build().perform();

                currentRightSliderPostion = Integer.parseInt(FilterRightPriceSliderTooltip(driver, logger).
                        getText().replaceAll("[^\\d.]", ""));
            }

            Thread.sleep(2000);

            ReusableMethods.scrollToEndLoads(driver);

            ReusableMethods.scrollup(driver);

        for(WebElement element : listOfPropertyPrices(driver, logger)) {
            String price = element.getText().replaceAll("[^\\d.]", "");

            if(Integer.parseInt(price) < currentLeftSliderPostion &&
            Integer.parseInt(price) > currentRightSliderPostion){

                softAssert.assertFalse(true, "Price filter set does not match the price shown on SRP.");
            }
        }

        softAssert.assertAll();
    }




    /*To validate that on applying the couple friendly filter, all the properties
    * appearing on the SRP have "Couple Friendly" tags on them.*/
    public void ValidateCoupleFriendlyPolicyFilter(WebDriver driver, ExtentTest logger) throws IOException {

//        ReusableMethods.Click(driver, filtersButton(driver, logger));

        ReusableMethods.scrollIntoView(driver, FilterCoupleFriendlyPolicy(driver, logger));

        ReusableMethods.Click(driver, FilterCoupleFriendlyPolicy(driver, logger));

//        ReusableMethods.Click(driver, FilterApplyButton(driver, logger));

        ReusableMethods.scrollToEndLoads(driver);

        ReusableMethods.scrollup(driver);

        softAssert.assertEquals(listOfProperties(driver, logger).size(), CoupleFriendlyTags(driver, logger).size(), "All the properties on the SRP are not " +
                "couple friendly on applying the filter.");

        softAssert.assertAll();

    }




    /*To validate that all the sections are present on the filter screen.*/
    public void ValidateAllSectionsFilter(WebDriver driver, ExtentTest logger) throws IOException {

//        ReusableMethods.Click(driver, filtersButton(driver, logger));
        softAssert.assertTrue(ReusableMethods.isElementPresent(driver, FilterLocalitySection(driver, logger)), "Locality Section not present in filters screen");
        softAssert.assertTrue(ReusableMethods.isElementPresent(driver, PricePerNightSection(driver, logger)), "Price per night section not present in filters screen");
        softAssert.assertTrue(ReusableMethods.isElementPresent(driver, FilterPoliciesSection(driver, logger)), "Policies section not present in the filter screen");
        softAssert.assertTrue(ReusableMethods.isElementPresent(driver, FiltertransportationSection(driver, logger)), "Transportation section not present in the filter screen");
        softAssert.assertTrue(ReusableMethods.isElementPresent(driver, FilterOccupancySection(driver, logger)), "Occupancy section not present in the filter screen");
        softAssert.assertTrue(ReusableMethods.isElementPresent(driver, FilterAmenitiesSection(driver, logger)), "Room Amenities Section not present on filter screen");
        softAssert.assertTrue(ReusableMethods.isElementPresent(driver, FilterStandardAmenitiesSection(driver, logger)), "Standard Amenities Section not present on filter screen");

        softAssert.assertAll();

    }



    // To validate the reset functionality of the filter screen.
    public void ResetFilterTest(WebDriver driver, ExtentTest logger) throws IOException {

        ReusableMethods.Click(driver, filtersButton(driver, logger));

        String ApplyButtonTextBeforeReset = FilterApplyButton(driver, logger).getText();

        ReusableMethods.Click(driver, FilterResetButton(driver, logger));

        String ApplyButtonTextAfterReset = FilterApplyButton(driver, logger).getText();

        softAssert.assertNotEquals(ApplyButtonTextBeforeReset, ApplyButtonTextAfterReset, "Filter reset button not working.");

        ReusableMethods.Click(driver, FilterApplyButton(driver, logger));

        ReusableMethods.scrollToEndLoads(driver);

        ReusableMethods.Click(driver, BackToTop(driver, logger));

        softAssert.assertAll();

    }
}
