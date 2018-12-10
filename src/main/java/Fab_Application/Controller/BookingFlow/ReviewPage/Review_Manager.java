package Fab_Application.Controller.BookingFlow.ReviewPage;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Controller.POM.ReviewPage.Review_POM;
import Fab_Application.Helper.Common.DriverHelper;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

import static Fab_Application.Controller.POM.PropertyDetailPage.PDP_POM.*;
import static Fab_Application.Controller.POM.ReviewPage.Review_POM.PayAtHotel;

public class Review_Manager {

    public void Validate_TC(WebDriver driver,String browserName,String serverName,String mobileNumber,String adminUsername,
    		 String adminPassword, ExtentTest logger) throws InterruptedException,IOException,JSONException {
    	
    	ReusableMethods.Click(driver, PayAtHotel(driver,logger));
    	ReusableMethods.wait(5);
   
        //OTP
        String otp = getOtpForNumber(driver,browserName,serverName,mobileNumber,adminUsername,adminPassword,logger);    
        System.out.println("Iam on window "+ driver.getTitle());       
        ReusableMethods.wait(5);
        ReusableMethods.type(driver,Review_POM.Otp(driver,logger),otp);
        ReusableMethods.Click(driver,ConfirmBooking(driver,logger));
        
        String confirmationText = ReusableMethods.getText(driver, UiAddresses.bookingConfirmationText, logger);
        String bookingId = "";
        if(confirmationText.equalsIgnoreCase("Booking confirmed!")) {
        	
        	 bookingId = ReusableMethods.getText(driver, UiAddresses.bookingId, logger);
        	System.out.println(bookingId);
        	logger.log(LogStatus.PASS, "booking created successfully with "+ bookingId);
        	Assert.assertTrue(true);
        }
        else {
        	System.out.println("Booking creation failed ");
        	logger.log(LogStatus.FAIL, "booking creation Failed ");
        	Assert.assertTrue(false);
        }
    
    }

    public String getOtpForNumber(WebDriver driver, String browserName, String serverName, String mobileNumber, 
    								String adminUsername, String adminPassword, ExtentTest logger)
            throws InterruptedException, IOException, JSONException {

        String otp = "";
        WebDriver temp_driver = DriverHelper.initiateWebBrowserInstance(browserName,serverName);
        WebElement username = ReusableMethods.FindElement(temp_driver,UiAddresses.userName,logger);
        username.click();
        username.sendKeys(adminUsername);
        WebElement password = ReusableMethods.FindElement(temp_driver,UiAddresses.password,logger);
        password.click();
        password.sendKeys(adminPassword);
        ReusableMethods.FindElement(temp_driver,UiAddresses.login,logger).click();
        WebElement abandoned = ReusableMethods.FindElement(temp_driver, UiAddresses.AbandonedCart, logger);
        
        		try {
        			ReusableMethods.Click(temp_driver, abandoned);
        		}
        		catch(Exception e) {
        			((JavascriptExecutor)temp_driver).executeScript("window.scrollBy(0,250)");
            		ReusableMethods.Click(temp_driver, abandoned);
        		}
        
        ReusableMethods.wait(3);
        
        WebElement mobileSearch = ReusableMethods.FindElement(temp_driver,UiAddresses.searchMobile,logger);
        ReusableMethods.Click(temp_driver, mobileSearch);
        ReusableMethods.type(temp_driver, mobileSearch, mobileNumber);    
        mobileSearch.sendKeys(Keys.ENTER);

        ReusableMethods.wait(5);
        
        String mobile = ReusableMethods.getText(temp_driver, UiAddresses.mobile, logger).split("-")[1];

        if(mobile.contains(mobileNumber)){

        	otp = ReusableMethods.getText(temp_driver, UiAddresses.transactionId, logger);
            logger.log(LogStatus.PASS,"Otp found "+ otp + "for number");
        } else {
            System.out.println("Otp not found ");
            logger.log(LogStatus.FAIL,"Otp not found");
        }
       
        temp_driver.quit();
        
        System.out.println("OTP received "+ otp);
        return otp;
    }
}
