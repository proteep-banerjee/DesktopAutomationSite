package Fab_Application.Controller.SRPTestCases.ValidatePrice;

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


public class SRP_ValidatePrice_Manager {

    SoftAssert softAssert = new SoftAssert();

    // To verify that the price of property is non zero
//    public void Validate_TC(WebDriver driver, ExtentTest logger) throws IOException {
//
//        ReusableMethods.scrollToEndLoads(driver);
//
//        if(ReusableMethods.isElementPresent(driver, BackToTop(driver, logger))){
//            ReusableMethods.Click(driver, BackToTop(driver, logger));
//        }
//            ReusableMethods.scrollToEndLoads(driver);
//            ReusableMethods.Click(driver, BackToTop(driver, logger));
//
//            List<String> prices = new ArrayList<String>();
//            for(WebElement element : listOfPropertyPrices(driver, logger)){
//                prices.add(element.getText());
//            }
//
//            for(String price : prices){
//                softAssert.assertNotEquals(price, "₹0");
//            }
//
//            softAssert.assertAll();
//    }
//
//    // To validate rack prices of properties on SRP
//    public void ValidateRackPrices(WebDriver driver, ExtentTest logger) throws IOException {
//
//        ReusableMethods.scrollToEndLoads(driver);
//
//        if(ReusableMethods.isElementPresent(driver, BackToTop(driver, logger))){
//            ReusableMethods.Click(driver, BackToTop(driver, logger));
//        }
//
//        List<Integer> rackPrices = new ArrayList<Integer>();
//        List<Integer> sellPrices = new ArrayList<Integer>();
//
//        for (WebElement element : RackPricesList(driver, logger)){
//            System.out.println(element.getText());
//            rackPrices.add(Integer.parseInt(element.getText().replaceAll("[^\\d.]", "")));
//        }
//
//        for(WebElement element : listOfPropertyPrices(driver, logger)){
//            sellPrices.add(Integer.parseInt(element.getText().replaceAll("[^\\d.]", "")));
//        }
//
//        Assert.assertEquals(rackPrices.size(), sellPrices.size(), "Number of rack prices not equal to number of sell prices.");
//
//        for (int i = 0; i < rackPrices.size(); i++){
//
//            softAssert.assertNotEquals(rackPrices.get(i), (Integer)0, "Rack prices found to be zero");
//            softAssert.assertTrue(rackPrices.get(i) > sellPrices.get(i), "Rack price not greater than sell price at index : " + i);
//        }
//
//        softAssert.assertAll();
//    }
}
