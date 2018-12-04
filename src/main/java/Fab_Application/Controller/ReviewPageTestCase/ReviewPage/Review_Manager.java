package Fab_Application.Controller.ReviewPageTestCase.ReviewPage;

import Fab_Application.Controller.POM.ReviewPage.Review_POM;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;

public class Review_Manager {
	
	long couponDiscountAmount = 0;
	double promoPriceAmount = 0;
	double amountPayable = 0;
	double discountedPriceAmount = 0;
	double GSTAmount = 0;
	double rackPriceAmount = 0;
	double totalSavingAmount = 0;
	

    public void validateTC(WebDriver driver, ExtentTest logger) throws IOException, InterruptedException {
    	
    	
    	WebElement appliedCoupon = Review_POM.appliedCoupon(driver,logger);
    	WebElement couponDiscount = Review_POM.couponDiscount(driver, logger);
    	WebElement promoPrice = Review_POM.promoPrice(driver, logger);
    	WebElement discountedPrice = Review_POM.discountedPrice(driver, logger);
    	WebElement payableAmount = Review_POM.payableAmount(driver, logger);
    	WebElement GST = Review_POM.GSTAmountApplied(driver, logger);
    	WebElement rackPrice = Review_POM.rackPrice(driver, logger);
    	WebElement totalSavings = Review_POM.totalSavings(driver, logger);
    	
    	couponDiscountAmount = Integer.parseInt(couponDiscount.getText());
    	promoPriceAmount = Integer.parseInt(promoPrice.getText());
    	discountedPriceAmount = Integer.parseInt(discountedPrice.getText());
    	amountPayable = Integer.parseInt(payableAmount.getText());
    	GSTAmount = Integer.parseInt(GST.getText());
    	rackPriceAmount = Integer.parseInt(rackPrice.getText());
    	totalSavingAmount = Integer.parseInt(totalSavings.getText());
    	
    	
    	if(appliedCoupon.getText().contains("STAYFAB")) {
    	
    		Assert.assertEquals(couponDiscountAmount , Math.round(promoPriceAmount * 0.2),
    				"Coupon discount amount for pre-applied STAYFAB is not as expected");
   	
    	}
    	
    	else {
    	//	logger.log(LogStatus.FAIL, "Pre-applied STAYFAB coupon not present");
    		Assert.assertTrue(false, " Pre-applied STAYFAB coupon not present ");
    	}
    }
    	
    	public boolean priceVerify(WebDriver driver, ExtentTest logger) {
    		
    		boolean result = true;
    		
    		result = (promoPriceAmount - couponDiscountAmount) == discountedPriceAmount &&
    				 (discountedPriceAmount + GSTAmount) == amountPayable 				&&
    				 ((discountedPriceAmount >= 1000 && GSTAmount > 0) || 
    				  (discountedPriceAmount < 1000 && GSTAmount == 0))		            &&
    			     (rackPriceAmount - amountPayable) == totalSavingAmount;
    				
    				
    		
    		
    		
    		return result;
    		
    	}
    


}
