package com.fabhotels.desktopsite.testsuite.PaymentFlow;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.pageobjects.CheckoutReview;
import com.fabhotels.desktopsite.pageobjects.DetailPage;
import com.fabhotels.desktopsite.pageobjects.SearchResultPage;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_PositivePaymentFlow extends Config {
	String Sheetname;
	Xls_Reader datatable;

	@BeforeMethod
	public void beforeMethod() {
		driver = generic.startDriver(Driver_Type);
		generic.maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void TC_positiveCase_Payment_CreditCard() {
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());

		DetailPage DetailPage = new DetailPage(driver, generic);
		SearchResultPage SearchResultPage = new SearchResultPage(driver, generic);
		SearchResultPage.positive_selectHotelFromDetail();

		DetailPage.Positive_CheckInCheckOutDateWE();

		CheckoutReview CheckoutReview = new CheckoutReview(driver, generic);
		CheckoutReview.positiveCheckoutReview();
		CheckoutReview.positiveGuestDetails();
		CheckoutReview.positiveCreditCardPayment();

		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL + ", Expected : https://www.3dsecure.icicibank.com/");
		Assert.assertTrue((currentURL.contains("https://www.3dsecure.icicibank.com/")),
				"Payment URL does not matches. ");
		customAssert.assertAll();
	}

	@Test
	public void TC_positiveCase_Payment_DebitCard() {
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		DetailPage DetailPage = new DetailPage(driver, generic);

		SearchResultPage SearchResultPage = new SearchResultPage(driver, generic);
		SearchResultPage.positive_selectHotelFromDetail();
		DetailPage.Positive_CheckInCheckOutDateWE();

		CheckoutReview CheckoutReview = new CheckoutReview(driver, generic);
		CheckoutReview.positiveCheckoutReview();
		CheckoutReview.positiveGuestDetails();
		CheckoutReview.positiveDebitCardPayment();

		// https://secure.paytm.in/oltp-web/processTransaction?orderid=casa2inns_58ca84c5c513f
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL + ", Expected : https://acs.icicibank.com/acspage/");
		Assert.assertTrue((currentURL.contains("https://acs.icicibank.com/acspage/")),
				"Payment URL does not matches. ");
		customAssert.assertAll();
	}

	@Test
	public void TC_positiveCase_Payment_Netbanking() {
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		DetailPage DetailPage = new DetailPage(driver, generic);

		SearchResultPage SearchResultPage = new SearchResultPage(driver, generic);
		SearchResultPage.positive_selectHotelFromDetail();

		DetailPage.Positive_CheckInCheckOutDateWE();

		CheckoutReview CheckoutReview = new CheckoutReview(driver, generic);
		CheckoutReview.positiveCheckoutReview();
		CheckoutReview.positiveGuestDetails();
		CheckoutReview.positiveNetBankingPayment();

		// https://shopping.icicibank.com/corp/BANKAWAY?IWQRYTASKOBJNAME=bay_mc_login&BAY_BANKID=ICI
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL + ", Expected : https://shopping.icicibank.com/corp/BANKAWAY");
		Assert.assertTrue((currentURL.contains("https://shopping.icicibank.com/corp/BANKAWAY")),
				"Payment URL does not matches. ");
		customAssert.assertAll();
	}

	@Test
	public void TC_positiveCase_Payment_Wallets() {
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		DetailPage DetailPage = new DetailPage(driver, generic);

		SearchResultPage SearchResultPage = new SearchResultPage(driver, generic);
		SearchResultPage.positive_selectHotelFromDetail();

		DetailPage.Positive_CheckInCheckOutDateWE();

		CheckoutReview CheckoutReview = new CheckoutReview(driver, generic);
		CheckoutReview.positiveCheckoutReview();
		CheckoutReview.positiveGuestDetails();
		CheckoutReview.positiveWalletsPayment();

		String currentURL = driver.getCurrentUrl();
		generic.goToSleep(5000);
		System.out.println(currentURL
				+ ", Expected : https://pguat.paytm.com/oltp-web/processTransaction?orderid=casa2inns_58db67627c139");
		Assert.assertTrue(
				(currentURL.contains("https://pguat.paytm.com/oltp-web/processTransaction?orderid=casa2inns_")
						|| currentURL.contains("fabhotels.com/checkout/paymentFailure")),
				"Payment URL does not matches. ");
		customAssert.assertAll();
	}

	@Test
	public void TC_positiveCase_Payment_PayAtHotels() {
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		DetailPage DetailPage = new DetailPage(driver, generic);

		SearchResultPage SearchResultPage = new SearchResultPage(driver, generic);
		SearchResultPage.positive_selectHotelFromDetail();

		DetailPage.Positive_CheckInCheckOutDateWE();

		CheckoutReview checkoutReview = new CheckoutReview(driver, generic);
		checkoutReview.positiveCheckoutReview();
		checkoutReview.positiveGuestDetails();
		checkoutReview.positivePayAtHotels();

		String ActualErrors = checkoutReview.captureError();

		Assert.assertTrue((generic.isVisible(CheckoutReview.bookNow_Btn)), "Book Now button is not present.");
		customAssert.assertEquals(ActualErrors, ", Please enter a valid input", "Error Message does not matches.");
		customAssert.assertAll();
	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
	}

}
