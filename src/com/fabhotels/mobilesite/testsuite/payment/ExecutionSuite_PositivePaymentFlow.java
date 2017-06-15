package com.fabhotels.mobilesite.testsuite.payment;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.mobilesite.pageobjects.CheckoutReview;
import com.fabhotels.mobilesite.pageobjects.DetailsPage;
import com.fabhotels.mobilesite.utils.Config;
import com.fabhotels.mobilesite.utils.UrlProvider;

public class ExecutionSuite_PositivePaymentFlow extends Config {
	String Sheetname;
	Xls_Reader datatable;

	@BeforeMethod
	public void beforeMethod() {
		driver = generic.startDriver(Driver_Type, Device_Type);
		generic.maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void TC_positiveCase_Payment_CreditCard() {
		generic.loadURL(UrlProvider.getDamanPageUrl());

		DetailsPage DetailsPage = new DetailsPage(driver, generic);

		DetailsPage.Positive_CheckInCheckOutDateWE();

		CheckoutReview CheckoutReview = new CheckoutReview(driver, generic);
		CheckoutReview.positiveCheckoutReview();
		CheckoutReview.positiveGuestDetails();
		CheckoutReview.positiveCreditCardPaymentRetry();

		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL
				+ ", .fabhotels.com/payment/detail?tab=payment old Expected : https://www.3dsecure.icicibank.com/");
		Assert.assertTrue((currentURL.contains(".fabhotels.com/payment/detail?tab=payment")),
				"Retry Payment URL does not matches. ");
		// Assert.assertAll();
	}

	@Test
	public void TC_positiveCase_Payment_DebitCard() {
		generic.loadURL(UrlProvider.getDamanPageUrl());
		DetailsPage DetailsPage = new DetailsPage(driver, generic);
		DetailsPage.Positive_CheckInCheckOutDateWE();

		CheckoutReview CheckoutReview = new CheckoutReview(driver, generic);
		CheckoutReview.positiveCheckoutReview();
		CheckoutReview.positiveGuestDetails();
		CheckoutReview.positiveDebitCardPayment();

		// https://secure.paytm.in/oltp-web/processTransaction?orderid=casa2inns_58ca84c5c513f
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL + ", Expected : https://acs.icicibank.com/acspage/");
		Assert.assertTrue((currentURL.contains("https://acs.icicibank.com/acspage/")),
				"Payment URL does not matches. ");
		// Assert.assertAll();
	}

	@Test
	public void TC_positiveCase_Payment_Netbanking() {
		generic.loadURL(UrlProvider.getDamanPageUrl());
		DetailsPage DetailsPage = new DetailsPage(driver, generic);
		DetailsPage.Positive_CheckInCheckOutDateWE();

		CheckoutReview CheckoutReview = new CheckoutReview(driver, generic);
		CheckoutReview.positiveCheckoutReview();
		CheckoutReview.positiveGuestDetails();
		CheckoutReview.positiveNetBankingPayment();

		// https://shopping.icicibank.com/corp/BANKAWAY?IWQRYTASKOBJNAME=bay_mc_login&BAY_BANKID=ICI
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL + ", Expected : https://shopping.icicibank.com/corp/BANKAWAY");
		Assert.assertTrue((currentURL.contains("https://shopping.icicibank.com/corp/BANKAWAY")),
				"Payment URL does not matches. ");
		// Assert.assertAll();
	}

	@Test
	public void TC_positiveCase_Payment_Wallets() {
		generic.loadURL(UrlProvider.getDamanPageUrl());
		DetailsPage DetailsPage = new DetailsPage(driver, generic);
		DetailsPage.Positive_CheckInCheckOutDateWE();

		CheckoutReview CheckoutReview = new CheckoutReview(driver, generic);
		CheckoutReview.positiveCheckoutReview();
		CheckoutReview.positiveGuestDetails();
		CheckoutReview.positiveWalletsPayment();

		String currentURL = driver.getCurrentUrl();
		generic.goToSleep(5000);
		System.out.println(currentURL
				+ ", Expected : secure.paytm.in https://pguat.paytm.com/oltp-web/processTransaction?orderid=casa2inns_58db67627c139");
		Assert.assertTrue(
				(currentURL.contains("https://secure.paytm.in/oltp-web/processTransaction?orderid=casa2inns_")
						|| currentURL.contains("fabhotels.com/checkout/paymentFailure")),
				"Payment URL does not matches. ");
		// Assert.assertAll();
	}

	@Test
	public void TC_positiveCase_Payment_PayAtHotels() {
		generic.loadURL(UrlProvider.getDamanPageUrl());
		DetailsPage DetailsPage = new DetailsPage(driver, generic);
		DetailsPage.Positive_CheckInCheckOutDateWE();

		CheckoutReview checkoutReview = new CheckoutReview(driver, generic);
		checkoutReview.positiveCheckoutReview();
		checkoutReview.positiveGuestDetails();
		checkoutReview.positivePayAtHotels();

		String ActualErrors = checkoutReview.captureError();

		Assert.assertTrue((generic.isVisible(CheckoutReview.bookNow_Btn)), "Book Now button is not present.");
		Assert.assertEquals(ActualErrors, ", Please enter a valid OTP", "Error Message does not matches.");
		// Assert.assertAll();
	}

	@AfterMethod
	public void afterTest() {
		// driver.quit();
	}

}
