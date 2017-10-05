package com.fabhotels.desktopsite.testsuite.PaymentFlow;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.pageobjects.CheckoutReview;
import com.fabhotels.desktopsite.pageobjects.DetailPage;
import com.fabhotels.desktopsite.pageobjects.SearchResultPage;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.Constants;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_GuestDetails extends Config {
	String Sheetname;
	Xls_Reader datatable;

	@BeforeMethod(firstTimeOnly=true)
	public void beforeMethod() {
		driver = generic.startDriver(Driver_Type);
		generic.maximize();
		driver.manage().deleteAllCookies();
	}

	@DataProvider(name = "DataProvider_GuestDetailsPage")
	public Object[][] DataProvider_GuestDetailPage() {
		Sheetname = "GuestDetailPage";
		datatable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_PAYMENT);
		int rowcount = datatable.getRowCount(Sheetname);
		Object result[][] = new Object[rowcount - 1][2];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = i;
			result[i - 2][1] = datatable.getCellData(Sheetname, "Case_Type", i);
		}	
		return result;
	}

	//	(//div[contains(@class, 'datepicker-checkin')]//td[text()='27'][@class='day'])

	@Test(dataProvider="DataProvider_GuestDetailsPage")
	public void TC_positiveCase_Checkout_GuestDetails(int rowNo, String Case_Type) {
		System.out.println("Case_Type :"+Case_Type);
		Sheetname = "GuestDetailPage";
		generic.loadURL(UrlProvider.getGothamPropertyPageUrl());

		DetailPage DetailPage=new DetailPage(driver,generic);
		SearchResultPage SearchResultPage=new SearchResultPage(driver,generic);
		SearchResultPage.positive_selectHotelFromDetail();

		DetailPage.Positive_CheckInCheckOutDateWE();

		CheckoutReview CheckoutReview=new CheckoutReview(driver, generic);
		CheckoutReview.positiveCheckoutReview();
		CheckoutReview.TestCase_GuestDetails(datatable,Sheetname,rowNo);

		String currentError=CheckoutReview.captureError();
		//datatable.setCellData(Sheetname, "ExpectedErrors", rowNo, currentError);
		String ExpectedErrors=datatable.getCellData(Sheetname, "ExpectedErrors", rowNo);

		String Expected=datatable.getCellData(Sheetname, "Expected", rowNo);

		if(Expected.equalsIgnoreCase("NotSubmitted")){
			Assert.assertTrue((currentError.equals(ExpectedErrors)),
					"Errors does not matches. ");

		}else{
			CheckoutReview.positivePayAtHotels();
			String errorOTP=CheckoutReview.captureError();
			System.out.println("error OTP : "+errorOTP);
			Assert.assertEquals(errorOTP.trim(), ", Please enter a valid input","OTP Error mismatch");
			
			
	/*		String mobileOrEmail = generic.getText(CheckoutReview.mobileOrEmail_WE);
			datatable.setCellData(Sheetname, "mobileOrEmail", rowNo,mobileOrEmail);
			String ExpectedmobileOrEmail = datatable.getCellData(Sheetname, "mobileOrEmail", rowNo);
			Assert.assertEquals(ExpectedmobileOrEmail, mobileOrEmail);
	*/	}
	}

	@AfterMethod(lastTimeOnly=true)
	public void afterMethod() {
		driver.quit();
	}

}
