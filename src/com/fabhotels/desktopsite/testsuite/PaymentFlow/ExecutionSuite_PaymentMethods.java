package com.fabhotels.desktopsite.testsuite.PaymentFlow;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.core.CustomAssert;
import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.pageobjects.CheckoutReview;
import com.fabhotels.desktopsite.pageobjects.DetailPage;
import com.fabhotels.desktopsite.pageobjects.ListingPage;
import com.fabhotels.desktopsite.pageobjects.OtpProvider;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.Constants;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_PaymentMethods extends Config {

	ListingPage listingPage;
	DetailPage detailPage;
	CheckoutReview checkoutReview;
	String Sheetname;
	OtpProvider getOtp;
	Xls_Reader datatable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_PAYMENT);

	public void bookinCreationFlow()
	{
		detailPage.positive_CheckInCheckOutDateWE();
		checkoutReview.positiveCheckoutReview();
		checkoutReview.click_continue_Btn();
		checkoutReview.testCase_GuestDetails(datatable, "GuestName", 2);
		checkoutReview.click_guestProceedToPay_Btn();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		generic = new GenericFunctions(driver);
		driver = generic.startDriver(Driver_Type);
		listingPage = new ListingPage(driver, generic);
		detailPage = new DetailPage(driver, generic);
		checkoutReview = new CheckoutReview(driver, generic);
		getOtp=new OtpProvider(driver, generic);
		driver.manage().deleteAllCookies();
	}

	@Test
	public void TC_PaymentMethods_001_CreditCard() {
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		bookinCreationFlow();
		checkoutReview.positiveCreditCardPayment();
		System.out.println(generic.getCurrentUrl() + ", Expected : https://www.3dsecure.icicibank.com/");
		Assert.assertTrue((generic.getCurrentUrl().contains("https://www.3dsecure.icicibank.com/")),
				"Payment URL does not matches. ");
	}

	@Test
	public void TC_PaymentMethods_002_DebitCard() {
		CustomAssert customAssert = new CustomAssert();
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		bookinCreationFlow();
		checkoutReview.positiveDebitCardPayment();
		// https://acs.icicibank.com/acspage/
		System.out.println(generic.getCurrentUrl() + ", Expected : https://acs.icicibank.com/acspage/");
		Assert.assertTrue((generic.getCurrentUrl().contains("https://acs.icicibank.com/acspage/")),
				"Payment URL does not matches. ");
		customAssert.assertAll();
	}

	@Test
	public void TC_PaymentMethods_003_Netbanking() {
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		bookinCreationFlow();
		checkoutReview.positiveNetBankingPayment();
		// https://shopping.icicibank.com/corp/BANKAWAY?IWQRYTASKOBJNAME=bay_mc_login&BAY_BANKID=ICI
		Assert.assertTrue((generic.getCurrentUrl().contains("https://shopping.icicibank.com/corp/BANKAWAY")),
				"Payment URL does not matches. ");
	}

	@Test
	public void TC_PaymentMethods_004_Wallets() {
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		bookinCreationFlow();
		checkoutReview.positiveWalletsPayment();
		//https://secure.paytm.in/oltp-web/processTransaction?orderid=casa2inns_5a0940cac2a12
		Assert.assertTrue(
				(generic.getCurrentUrl().contains("https://secure.paytm.in/oltp-web/processTransaction?orderid=casa2inns_")
						|| generic.getCurrentUrl().contains("fabhotels.com/checkout/paymentFailure")),
				"Payment URL does not matches. ");
	}

	@Test
	public void TC_PaymentMethods_005_PayAtHotels() {
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		bookinCreationFlow();
		checkoutReview.positivePayAtHotels();
		checkoutReview.fill_Otp_Num(getOtp.getOtp());
		checkoutReview.click_bookNow_Btn();
		generic.goToSleep(2000);
		Assert.assertEquals(checkoutReview.get_booking_response_Title(), "Fabulous!","Booking creation is not sucessfull!!!!!!");
	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
	}

}
