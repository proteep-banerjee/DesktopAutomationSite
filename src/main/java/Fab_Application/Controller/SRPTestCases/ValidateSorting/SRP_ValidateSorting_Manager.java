package Fab_Application.Controller.SRPTestCases.ValidateSorting;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static Fab_Application.Controller.POM.SRPScreen.SRP_POM.*;

public class SRP_ValidateSorting_Manager {

    SoftAssert softAssert = new SoftAssert();

    // Verify that the prices are sorted high to low order on sorting accordingly.
//    public void verifyHighToLow(WebDriver driver, ExtentTest logger){
//        try{
//
//            ReusableMethods.Click(driver, sortButton(driver, logger));
//
//            Thread.sleep(2000);
//
//            ReusableMethods.Click(driver, HighToLow(driver, logger));
//
//            Thread.sleep(2000);
//
//            ReusableMethods.scrollToEndLoads(driver);
//
//            if(ReusableMethods.isElementPresent(driver, BackToTop(driver, logger))){
//                ReusableMethods.Click(driver, BackToTop(driver, logger));
//            }
//
//            List<Integer> prices = new ArrayList<Integer>();
//            List<WebElement> soldOutProperties = soldoutPropertiesList(driver, logger);
//
//            for(WebElement element : listOfPropertyPrices(driver, logger)){
////                System.out.println(element.getText());
//                String price = element.getText().replaceAll("[^\\d.]", "");
//                prices.add(Integer.parseInt(price));
//            }
//
//            for(int i = 0; i < ((prices.size()- soldOutProperties.size())-1); i++){
//                if(prices.get(i)< prices.get(i+1)){
//                    softAssert.assertTrue(false, "Prices not sorted in High to Low");
//                }
//            }
//            softAssert.assertAll();
//        }
//        catch(Exception e){
//
//            e.printStackTrace();
//
//        }
//    }
//
//    // Verify that the prices are sorted low to high order on sorting accordingly.
//    public void verifyLowToHigh(WebDriver driver, ExtentTest logger){
//        try{
//
//            ReusableMethods.Click(driver, sortButton(driver, logger));
//
//            Thread.sleep(2000);
//
//            ReusableMethods.Click(driver, LowToHigh(driver, logger));
//
//            Thread.sleep(2000);
//
//            ReusableMethods.scrollToEndLoads(driver);
//
//            if(ReusableMethods.isElementPresent(driver, BackToTop(driver, logger))){
//                ReusableMethods.Click(driver, BackToTop(driver, logger));
//            }
//
//            List<Integer> prices = new ArrayList<Integer>();
//            List<WebElement> soldOutProperties = soldoutPropertiesList(driver, logger);
//
//            for(WebElement element : listOfPropertyPrices(driver, logger)){
////                System.out.println(element.getText());
//                String price = element.getText().replaceAll("[^\\d.]", "");
//                prices.add(Integer.parseInt(price));
//            }
//
//            for(int i = 0; i < ((prices.size()- soldOutProperties.size())-1); i++){
//                if(prices.get(i)> prices.get(i+1)){
//                    softAssert.assertTrue(false, "Prices not sorted in Low to High");
//                }
//            }
//            softAssert.assertAll();
//        }
//        catch(Exception e){
//
//            e.printStackTrace();
//
//        }
//    }
}
