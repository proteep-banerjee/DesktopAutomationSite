package Fab_Application.Controller.ReviewPage.ReviewPage_Manager_withValidations;


/**
 * Created By - Kalpana
 */

import Fab_Application.Controller.POM.ReviewPage.Review_POM;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class Review_ApplyCoupon_Manager {


	long couponDiscountAmount = 0;
	double promoPriceAmount = 0;
	double amountPayable = 0;
	double discountedPriceAmount = 0;
	double GSTAmount = 0;
	double rackPriceAmount = 0;
	double totalSavingAmount = 0;
	double creditedPoints = 0;


	public void ApplyCoupon(WebDriver driver, String couponCode,int discountPercentage, ExtentTest logger) throws IOException, InterruptedException {

		ReusableMethods.Click(driver, Review_POM.removeCoupon(driver, logger));
		ReusableMethods.type(driver, Review_POM.applyCouponField(driver, logger), couponCode);
		ReusableMethods.Click(driver, Review_POM.applyCouponButton(driver, logger));
		
		
		WebElement appliedCoupon = Review_POM.appliedCoupon(driver,logger);
		WebElement couponDiscount = Review_POM.couponDiscount(driver, logger);
		WebElement promoPrice = Review_POM.promoPrice(driver, logger);
		WebElement discountedPrice = Review_POM.discountedPrice(driver, logger);
		WebElement payableAmount = Review_POM.payableAmount(driver, logger);
		WebElement GST = Review_POM.GSTAmountApplied(driver, logger);
		List<WebElement> rackPriceList = Review_POM.rackPrice(driver, logger);
		WebElement totalSavings = Review_POM.totalSavings(driver, logger);

		couponDiscountAmount = Integer.parseInt(couponDiscount.getText());
		promoPriceAmount = Integer.parseInt(promoPrice.getText().replaceAll("[^0-9]", ""));
		discountedPriceAmount = Integer.parseInt(discountedPrice.getText());
		amountPayable = Integer.parseInt(payableAmount.getText());
		GSTAmount = Integer.parseInt(GST.getText());
		totalSavingAmount = Integer.parseInt(totalSavings.getText());

		if(rackPriceList.size()!= 0) {

			System.out.println("Rackprice present");
			rackPriceAmount = Integer.parseInt(rackPriceList.get(0).getText());

		}else {
			System.out.println("Rackprice not present");
			rackPriceAmount = promoPriceAmount;
		}	

		System.out.println("appliedCoupon.getText() "+ appliedCoupon.getText());

		if(appliedCoupon.getText().contains(couponCode)) {
			System.out.println(couponCode +" coupon applied successfully");

			System.out.println("couponDiscountAmount "+couponDiscountAmount);
			System.out.println("Math.round(promoPriceAmount * 0.2) "+ Math.round(promoPriceAmount * (discountPercentage/100)));

			    		Assert.assertEquals(couponDiscountAmount , Math.round(promoPriceAmount * (discountPercentage/100)),
			    				"Coupon discount amount for applied coupon is not as expected");

		}

		else {
			logger.log(LogStatus.FAIL, couponCode +" coupon not applied successfully");
			Assert.assertTrue(false, couponCode +" coupon not applied successfully");
		}

		boolean result = priceVerify(driver,logger);
		assertTrue(result, "Prices on Review page are incorrect");
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


}
