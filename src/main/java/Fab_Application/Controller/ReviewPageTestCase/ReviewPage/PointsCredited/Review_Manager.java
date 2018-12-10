package Fab_Application.Controller.ReviewPageTestCase.ReviewPage.PointsCredited;

import Fab_Application.Constants.UiAddresses;
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
		
		WebElement payableAmount = Review_POM.payableAmount(driver, logger);
		WebElement creditedPoint = Review_POM.pointsToBeCredited(driver, logger);
	//	WebElement discountedPrice = Review_POM.discountedPrice(driver, logger);
		
		
		List<WebElement> discountedPriceList = ReusableMethods.FindElements(driver, UiAddresses.Review_discountedPrice, logger);
		
	//	discountedPriceAmount = Integer.parseInt(discountedPrice.getText());
		amountPayable = Integer.parseInt(payableAmount.getText());
		System.out.println("amountPayable "+ amountPayable);
		
		String creditedPointsStr = creditedPoint.getText();
		creditedPointsStr = creditedPointsStr.trim().split("//s")[0].replaceAll("[^0-9]", "");
		
		
		
		if(discountedPriceList.size() !=0) {
			discountedPriceAmount = Integer.parseInt(discountedPriceList.get(0).getText());
			amountPayable = discountedPriceAmount;
			
		}else {
			amountPayable = Integer.parseInt(payableAmount.getText());
		}
		
		
		
		
		System.out.println("Credited Points"+ creditedPointsStr);
		creditedPoints = Integer.parseInt(creditedPointsStr);   		    	
		creditsVerify(driver,amountPayable,userType,creditedPoints ,logger);
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
		
		System.out.println("Actual Credits: "+ actualCredits + "Expected Credits "+ expectedCredits);
		
		Assert.assertEquals(actualCredits, expectedCredits, "Points to be credited are incorrect ");
		
	}



}
