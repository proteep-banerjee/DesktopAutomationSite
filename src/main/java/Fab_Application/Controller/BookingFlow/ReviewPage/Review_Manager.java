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

import java.io.IOException;

import static Fab_Application.Controller.POM.PropertyDetailPage.PDP_POM.*;
import static Fab_Application.Controller.POM.ReviewPage.Review_POM.PayAtHotel;

public class Review_Manager {

    public void Validate_TC(WebDriver driver,String browserName, String serverName, String mobileNumber,ExtentTest logger)

            throws InterruptedException,IOException,JSONException {

       // ReusableMethods.Click(driver,ContinueButton(driver,logger));
    	//ReusableMethods.MoveByElementAndClick(driver, PayAtHotel(driver,logger));
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", PayAtHotel(driver,logger));
    	
    	System.out.println("Clicked on Pay @");
    	Thread.sleep(8000);
    //    ReusableMethods.Click(driver, PayAtHotel(driver, logger));
        //OTP
        String otp = getOtpForNumber(driver,browserName,serverName,mobileNumber,logger);
        
        System.out.println("Iam on window "+ driver.getTitle());
        
        Thread.sleep(5000);
        ReusableMethods.type(driver,Review_POM.Otp(driver,logger),otp);
        ReusableMethods.Click(driver,ConfirmBooking(driver,logger));
        
        



    }

    public String getOtpForNumber(WebDriver driver, String browserName, String serverName, String mobileNumber, ExtentTest logger)
            throws InterruptedException, IOException, JSONException {

        String otp = "";
        WebDriver temp_driver = DriverHelper.initiateWebBrowserInstance(browserName,serverName);
        WebElement username = ReusableMethods.FindElement(temp_driver,UiAddresses.userName,logger);
        username.click();
        username.sendKeys("Varunbhayana");
        WebElement password = ReusableMethods.FindElement(temp_driver,UiAddresses.password,logger);
        password.click();
        password.sendKeys("password");
        ReusableMethods.FindElement(temp_driver,UiAddresses.login,logger).click();
        WebElement abandoned = ReusableMethods.FindElement(temp_driver, UiAddresses.AbandonedCart, logger);
        
        System.out.println("abandoned ...... "+ abandoned.getText());
        
        Thread.sleep(5000);
        
   //     ReusableMethods.scrollIntoView(driver, abandoned);
//        ReusableMethods.MoveByElementAndClick(temp_driver, abandoned);
        
       // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", abandoned);
        
        WebElement mobileSearch = ReusableMethods.FindElement(temp_driver,UiAddresses.searchMobile,logger);
        mobileSearch.click();
        mobileSearch.sendKeys(mobileNumber);
        mobileSearch.sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        String mobile = ReusableMethods.FindElement(temp_driver,UiAddresses.mobile,logger).getText().split("-")[1];

        if(mobile.contains(mobileNumber)){

            otp =  ReusableMethods.FindElement(temp_driver,UiAddresses.transactionId,logger).getText();
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
