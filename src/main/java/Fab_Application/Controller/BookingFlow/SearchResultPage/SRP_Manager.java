package Fab_Application.Controller.BookingFlow.SearchResultPage;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

import static Fab_Application.Controller.POM.SRPScreen.SRP_POM.*;


public class SRP_Manager {

    public void Validate_TC(WebDriver driver, String PropertyName, ExtentTest logger) throws IOException, InterruptedException {

      
            ReusableMethods.scrollToEndLoads(driver);
          //  ReusableMethods.Click(driver, BackToTop(driver, logger));
            Thread.sleep(2000);
    	
    	boolean prop = false;

            for(WebElement property : listOfProperties(driver, logger)) {
                String Property = property.getText();
                
                System.out.println("Property "+ Property);
                if (Property.toLowerCase().contains(PropertyName.toLowerCase())) {
                	
                	prop = true;
                	
                	System.out.println("Got the property name ");

                    ReusableMethods.scrollIntoView(driver, property);
                    
             //       new Actions(driver).moveToElement(property).build().perform();
                    
                    System.out.println("Scrolled to property, Clicking now ");
                    
                 //   ((JavascriptExecutor) driver).executeScript("arguments[0].click;",property);
                   
                   WebElement search = property.findElement(By.xpath("/ancestor :: div[contains(@class,'table-div')]//div[contains(@class,'price-wrap')]"));
                   
                //   System.out.println("search btn "+ search);
                   
                   Thread.sleep(5000);
                   ReusableMethods.Click(driver, search);
                    
                    System.out.println("Clicked on prop ");

                    break;
                }
            }
          
            	System.out.println("Prop result " +prop);
            

    }
}
