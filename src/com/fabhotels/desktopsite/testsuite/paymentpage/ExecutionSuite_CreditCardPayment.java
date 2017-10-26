package com.fabhotels.desktopsite.testsuite.paymentpage;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_CreditCardPayment extends Config {
	String Sheetname;
	Xls_Reader datatable;

	@BeforeMethod
	public void beforeMethod() {
		generic = new GenericFunctions(driver);
		driver = generic.startDriver(Driver_Type);
		generic.maximize();
		driver.manage().deleteAllCookies();
	}


/*	
	@Test
	public void TC_positiveCase_Payment_CreditCard() {
		generic.loadURL(UrlProvider.getGothamPropertyPageUrl());
		DetailPage DetailPage=new DetailPage(driver,generic);

		SearchResultPage SearchResultPage=new SearchResultPage(driver,generic);
		SearchResultPage.positive_BookNow();

		DetailPage.Positive_CheckInCheckOutDateWE();

		CheckoutReview CheckoutReview=new CheckoutReview(driver, generic);
		CheckoutReview.positiveCheckoutReview();
		CheckoutReview.positiveGuestDetails();
		CheckoutReview.positiveCreditCardPayment();

		String currentURL=driver.getCurrentUrl();
		customAssert.assertTrue((currentURL.contains("https://www.3dsecure.icicibank.com/")),
				"Payment URL does not matches. ");
	}*/
	
	
	@Test
	public void sdsd()
	{

		
		for(int i=0;i<2;i++)
		{
			generic.loadURL(UrlProvider.getListingPageUrl());
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			//executor.executeScript("setVoucherCounter();");
			executor.executeScript("setVoucherCloseCookie();");
			driver.navigate().refresh();
			//generic.loadURL(UrlProvider.getHomePageUrl());
			//generic.loadURL(UrlProvider.getGothamPropertyPageUrl());
			generic.goToSleep(60000);
		}
		
	}
	
	
	
	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
	

}
