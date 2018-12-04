package Fab_Application.Controller.SRPTestCases.FilterTest;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.io.IOException;

import static Fab_Application.Controller.POM.FilterScreen.FilterScreen_POM.*;
import static Fab_Application.Controller.POM.SRPScreen.SRP_POM.*;

public class SRP_FilterTest_Manager {

    SoftAssert softAssert = new SoftAssert();
//
//     /*To validate that the prices of the properties displayed in the SRP are
//     less than or equal to prices set by the filter.*/
//    public void ValidateFilterPriceSlider(WebDriver driver, ExtentTest logger, String desiredPrice) throws IOException, InterruptedException {
//
//        ReusableMethods.Click(driver, filtersButton(driver, logger));
//
//        ReusableMethods.scrollIntoView(driver, FilterPriceSlider(driver, logger));
//
//        int currentSliderPostion = Integer.parseInt(FilterPriceSliderTooltip(driver, logger).
//                getText().replaceAll("[^\\d.]", ""));
//
//        Actions builder = new Actions(driver);
//
//        if(Integer.parseInt(desiredPrice) < currentSliderPostion){
//            while(currentSliderPostion > Integer.parseInt(desiredPrice)){
//                builder.dragAndDropBy(FilterPriceSlider(driver, logger), -30, 0).
//                        build().perform();
//
//                currentSliderPostion = Integer.parseInt(FilterPriceSliderTooltip(driver, logger).
//                        getText().replaceAll("[^\\d.]", ""));
//            }
//        }
//        else{}
//
//        Thread.sleep(3000);
//
//        ReusableMethods.Click(driver, FilterApplyButton(driver, logger));
//
//        ReusableMethods.scrollToEndLoads(driver);
//
//        if(ReusableMethods.isElementPresent(driver, BackToTop(driver, logger))){
//            ReusableMethods.Click(driver, BackToTop(driver, logger));
//        }
//
//        for(WebElement element : listOfPropertyPrices(driver, logger)) {
////                System.out.println(element.getText());
//            String price = element.getText().replaceAll("[^\\d.]", "");
//            if(Integer.parseInt(price) > Integer.parseInt(desiredPrice)){
//                softAssert.assertFalse(true, "Price filter set does not match the price shown on SRP.");
//            }
//        }
//
//        softAssert.assertAll();
//    }
//
//
//
//
//    /*To validate that on applying the couple friendly filter, all the properties
//    * appearing on the SRP have "Couple Friendly" tags on them.*/
//    public void ValidateCoupleFriendlyPolicyFilter(WebDriver driver, ExtentTest logger) throws IOException {
//
//        ReusableMethods.Click(driver, filtersButton(driver, logger));
//
//        ReusableMethods.scrollIntoView(driver, FilterCoupleFriendlyPolicy(driver, logger));
//
//        ReusableMethods.Click(driver, FilterCoupleFriendlyPolicy(driver, logger));
//
//        ReusableMethods.Click(driver, FilterApplyButton(driver, logger));
//
//        ReusableMethods.scrollToEndLoads(driver);
//
//        if(ReusableMethods.isElementPresent(driver, BackToTop(driver, logger))){
//            ReusableMethods.Click(driver, BackToTop(driver, logger));
//        }
//
//        softAssert.assertEquals(listOfProperties(driver, logger).size(), CoupleFriendlyTags(driver, logger).size(), "All the properties on the SRP are not " +
//                "couple friendly on applying the filter.");
//
//        softAssert.assertAll();
//
//    }
//
//
//
//
//    /*To validate that all the sections are present on the filter screen.*/
//    public void ValidateAllSectionsFilter(WebDriver driver, ExtentTest logger) throws IOException {
//
//        ReusableMethods.Click(driver, filtersButton(driver, logger));
//        softAssert.assertTrue(ReusableMethods.isElementPresent(driver, FilterLocalitySection(driver, logger)), "Locality Section not present in filters screen");
//        softAssert.assertTrue(ReusableMethods.isElementPresent(driver, PricePerNightSection(driver, logger)), "Price per night section not present in filters screen");
//        softAssert.assertTrue(ReusableMethods.isElementPresent(driver, FilterPoliciesSection(driver, logger)), "Policies section not present in the filter screen");
//        softAssert.assertTrue(ReusableMethods.isElementPresent(driver, FilterOccupancySection(driver, logger)), "Occupancy section not present in the filter screen");
//        softAssert.assertTrue(ReusableMethods.isElementPresent(driver, FilterStandardAmenitiesSection(driver, logger)), "Standard Amenities Section not present on filter screen");
//
//        softAssert.assertAll();
//
//    }
//
//
//
//    // To validate the reset functionality of the filter screen.
//    public void ResetFilterTest(WebDriver driver, ExtentTest logger) throws IOException {
//
//        ReusableMethods.Click(driver, filtersButton(driver, logger));
//
//        String ApplyButtonTextBeforeReset = FilterApplyButton(driver, logger).getText();
//
//        ReusableMethods.Click(driver, FilterResetButton(driver, logger));
//
//        String ApplyButtonTextAfterReset = FilterApplyButton(driver, logger).getText();
//
//        softAssert.assertNotEquals(ApplyButtonTextBeforeReset, ApplyButtonTextAfterReset, "Filter reset button not working.");
//
//        ReusableMethods.Click(driver, FilterApplyButton(driver, logger));
//
//        ReusableMethods.scrollToEndLoads(driver);
//
//        ReusableMethods.Click(driver, BackToTop(driver, logger));
//
//        softAssert.assertAll();
//
//    }
}
