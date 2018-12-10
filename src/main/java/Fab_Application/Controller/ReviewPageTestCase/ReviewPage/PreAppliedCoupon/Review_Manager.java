package Fab_Application.Controller.ReviewPageTestCase.ReviewPage.PreAppliedCoupon;

import Fab_Application.Controller.POM.ReviewPage.Review_POM;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.io.IOException;

public class Review_Manager {

	long couponDiscountAmount = 0;
	double promoPriceAmount = 0;
	double amountPayable = 0;
	double discountedPriceAmount = 0;
	double GSTAmount = 0;
	double rackPriceAmount = 0;
	double totalSavingAmount = 0;
	double creditedPoints = 0;


	public void Validate_TC(WebDriver driver, String userType, ExtentTest logger) throws IOException, InterruptedException {

		WebElement appliedCoupon = Review_POM.appliedCoupon(driver,logger);
		WebElement couponDiscount = Review_POM.couponDiscount(driver, logger);
		WebElement promoPrice = Review_POM.promoPrice(driver, logger);
		WebElement discountedPrice = Review_POM.discountedPrice(driver, logger);
		WebElement payableAmount = Review_POM.payableAmount(driver, logger);
		WebElement GST = Review_POM.GSTAmountApplied(driver, logger);
		List<WebElement> rackPriceList = Review_POM.rackPrice(driver, logger);
		WebElement totalSavings = Review_POM.totalSavings(driver, logger);
		WebElement creditedPoint = Review_POM.pointsToBeCredited(driver, logger);

		couponDiscountAmount = Integer.parseInt(couponDiscount.getText());
		promoPriceAmount = Integer.parseInt(promoPrice.getText().replaceAll("[^0-9]", ""));
		discountedPriceAmount = Integer.parseInt(discountedPrice.getText());
		amountPayable = Integer.parseInt(payableAmount.getText());
		GSTAmount = Integer.parseInt(GST.getText());
		totalSavingAmount = Integer.parseInt(totalSavings.getText());
		
		String creditedPointsStr = creditedPoint.getText();
		
		System.out.println("Credited Points "+ creditedPointsStr.substring(0,4));
		creditedPoints = Integer.parseInt(creditedPointsStr.split("//s+")[1]);
		

		    	if(rackPriceList.size()!= 0) {
		    		
		    		System.out.println("Rackprice present");
		    		rackPriceAmount = Integer.parseInt(rackPriceList.get(0).getText());
		    		
		    	}else {
		    		System.out.println("Rackprice not present");
		    		rackPriceAmount = promoPriceAmount;
		    	}	
		    	
		    	System.out.println("appliedCoupon.getText() "+ appliedCoupon.getText());
		    	
		    	if(appliedCoupon.getText().contains("STAYFAB")) {
		    		System.out.println("PRE applied coupon present");
		    	
		    		System.out.println("couponDiscountAmount "+couponDiscountAmount);
		    		System.out.println("Math.round(promoPriceAmount * 0.2) "+ Math.round(promoPriceAmount * 0.2));
		    		
//		    		Assert.assertEquals(couponDiscountAmount , Math.round(promoPriceAmount * 0.2),
//		    				"Coupon discount amount for pre-applied STAYFAB is not as expected");
		   	
		    	}
		    	
		    	else {
		    		logger.log(LogStatus.FAIL, "Pre-applied STAYFAB coupon not present");
		    		Assert.assertTrue(false, " Pre-applied STAYFAB coupon not present ");
		    	}
		
		boolean result = priceVerify(driver,logger);
		assertTrue(result, "Prices on Review page are incorrect");
		creditsVerify(driver,amountPayable,"SILVER",creditedPoints ,logger);
	}

	public boolean priceVerify(WebDriver driver, ExtentTest logger) {

		boolean result = true;

		result = (promoPriceAmount - couponDiscountAmount) == discountedPriceAmount &&
				(discountedPriceAmount + GSTAmount) == amountPayable 				&&
				((discountedPriceAmount >= 1000 && GSTAmount > 0) || 
						(discountedPriceAmount < 1000 && GSTAmount == 0))		    &&
		    (rackPriceAmount - amountPayable) == totalSavingAmount;

		System.out.println("Return review result "+ result);

		return result;
	}
	
	public void creditsVerify(WebDriver driver, double amountPayable, String userType, double actualCredits, ExtentTest logger) {
		
		double expectedCredits = 0;
		
		switch(userType) {
		
		case "BLUE" :
			expectedCredits = Math.floor(amountPayable * 0.05);
			break;
			
		case "SILVER" :
			expectedCredits = Math.floor(amountPayable * 0.06);
			break;
			
		case "GOLD" :
			expectedCredits = Math.floor(amountPayable * 0.065);
			break;
			
		case "PLATINUM" :
			expectedCredits = Math.floor(amountPayable * 0.08);
			break;
			
		}
		
		Assert.assertEquals(actualCredits, expectedCredits, "Points to be credited are incorrect ");
		
	}



}
