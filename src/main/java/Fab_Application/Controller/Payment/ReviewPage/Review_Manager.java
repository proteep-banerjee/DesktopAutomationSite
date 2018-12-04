package Fab_Application.Controller.Payment.ReviewPage;

import Fab_Application.Controller.POM.ReviewPage.Review_POM;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;

public class Review_Manager {

    public void validateTC(WebDriver driver, ExtentTest logger) throws IOException, InterruptedException {
    	
    	WebElement payNow = Review_POM.PayNow(driver,logger);
    	
    	ReusableMethods.scrollIntoView(driver, payNow);
    	Actions action = new Actions(driver);
    	action.moveToElement(payNow).build().perform();
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", payNow);
    	
    	System.out.println("Now waiting for Pay now ");
    	Thread.sleep(8000);
    	
      //  ReusableMethods.Click(driver,Review_POM.PayNow(driver,logger));

        String totalAmount = Review_POM.TotalAmount(driver,logger).getAttribute("innerText").replaceAll("[^0-9]","");
        String amountToBePaid = Review_POM.AmountToBePaid(driver,logger).getText().replaceAll("[^0-9]","");
        
        System.out.println("totalAmount "+totalAmount);
        System.out.println("amountToBePaid "+ amountToBePaid);

        if(totalAmount.equalsIgnoreCase(amountToBePaid)){
            Assert.assertTrue(true,"Total Payable Amount matched...");
        }

        else{
            Assert.assertTrue(false,"Total Payable Amount not matched...");
        }
    }


}
