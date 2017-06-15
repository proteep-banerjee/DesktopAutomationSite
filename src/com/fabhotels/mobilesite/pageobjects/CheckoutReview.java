package com.fabhotels.mobilesite.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.mobilesite.testsuite.payment.ExecutionSuite_PositivePaymentFlow;

public class CheckoutReview {

	WebDriver driver;
	GenericFunctions generic;

	public CheckoutReview(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}

	public static final String couponCode_Txt = "//input[@placeholder='Enter Coupon Code']";
	public static final String applyButton_Btn = "//button[contains(text(),'Apply')]";
	public static final String applyCross_Btn = "//div[@class='payment__review__coupon__remove']";
	public static final String subTotal_WE = "(//div[@class='payment__review__overview__total__single__right'])[1]";
	public static final String discount_WE = "(//div[@class='payment__review__overview__total__single__right'])[2]";
	public static final String serviceTax_WE = "(//div[@class='payment__review__overview__total__single__right'])[3]";
	public static final String total_WE = "(//div[@class='payment__review__overview__total__single__right'])[4]";
	public static final String continue_Btn = "//button[contains(text(),'Continue')]";
	// span[@class='grand-total-amount']

	// Guest details
	public static final String guestName_Txt = "//input[contains(@placeholder,'Your full name. e.g. John Doe')]";
	public static final String guestEmail_Txt = "//input[contains(@placeholder,'Email address')]";
	public static final String guestCountryCode_Btn = "//div[@class='payment__country_flag']//input";
	public static final String guestCountryCode1_Dd = "//ul[@class='country_list']//li//span[@data-phone-code='";
	public static final String guestCountryCode2_Dd = "']";
	public static final String guestCountryCode_Txt = "//div[@class='payment__country_flag']//input";
	public static final String guestMobileNumber_Txt = "//input[contains(@class,'input-mobile')][@placeholder='xxxxx xxxxx']";
	public static final String guestProcess_Btn = "//button[contains(text(),'Proceed to Pay')]";
	public static final String guestSubscribe_Chk = "(//div[contains(@class,'payment__card__form_check')])[1]//div";
	public static final String guestPolicies_Chk = "(//div[contains(@class,'payment__card__form_check')])[3]//div";

	public static final String creditCard_Btn = "//a[text()='Credit / Debit Card']";
	public static final String debitCard_Btn = "//a[text()='Credit / Debit Card']";
	public static final String netBanking_Btn = "//a[text()='Net Banking']";
	public static final String wallets_Btn = "//a[text()='Wallet']";
	public static final String payAtHotel_Btn = "//div[@class='payment__payAtHotel_or']/..//button";

	public static final String creditCardNo_Txt = "//input[@placeholder='Enter Card Number']";
	public static final String creditHolderName_Txt = "(//input[@placeholder='Name on card'])[1]";
	public static final String creditExpiryDate_Txt = "(//input[@placeholder='MM / YY'])[1]";
	public static final String creditCVV_Txt = "(//input[@placeholder='CVV no.'])[1]";
	public static final String creditCardCancel_Btn = "//img[@src='../images/btn_cancel.gif']";

	public static final String debitCardNo_Txt = "//input[@placeholder='Enter Card Number']";
	public static final String debitHolderName_Txt = "(//input[@placeholder='Name on card'])[1]";
	public static final String debitExpiryDate_Txt = "(//input[@placeholder='MM / YY'])[1]";
	public static final String debitCVV_Txt = "(//input[@placeholder='CVV no.'])[1]";
	public static final String debitCardCancel_Btn = "//img[@src='../images/btn_cancel.gif']"; // "//div[@class='payment__card__total__continue']//button";

	public static final String netbankingHDFC_Rd = "//input[@value='HDFC']";
	public static final String netbankingICICI_Rd = "//input[@value='ICICI']";
	public static final String netbankingCITI_Rd = "//input[@value='CITI']";
	public static final String netbankingSBI_Rd = "//input[@value='SBI']";
	public static final String netbankingAXIS_Rd = "//input[@value='AXIS']";
	public static final String netbankingKOTAK_Rd = "//input[@value='KOTAK']";

	public static final String chooseBank_DD = "//select[@name='bank_name']//option[text()='SBI']";

	public static final String payRupees_Btn = "//div[@class='payment__card__total__continue']//button";
	public static final String payTmRupees_Btn = "//div[@class='payment__card__total__continue']//button";
	public static final String payTmCancel_Btn = "//a[contains(@href,'/oltp-web/cancelTransaction')]";

	public static final String requestOTP_Btn = "(//div//span[text()='Request OTP'])[2]"; // "(//div[@class='review_payment_details_single_medium']//div//span[text()='Request
																							// OTP'])[1]";
	public static final String resendOTP_Btn = "//a[contains(text(),'Resend OTP')]";
	public static final String enterOTP_Txt = "//input[@name='otp']";
	public static final String mobileOrEmail_WE = "//div[@class='review_payment_verify_mobile']//span";
	public static final String bookNow_Btn = "//button[text()='Book Now']";
	public static final String wantToPayNow_Btn = "//button[text()='I want to pay now']";

	public static final String tryAgain_Btn = "//button[text()='Try Again']"; // "//div[@data-url='/checkout/review']";

	public static final String errorMessage_Err = "//span[contains(@class,'_error')]";

	public void SelectCountryCode(String data) {
		try {
			// System.out.println("Click :"+xPath);
			driver.findElement(By.xpath(guestCountryCode1_Dd + data + guestCountryCode1_Dd)).click();
		} catch (Exception ex) {
			generic.goToSleep(1000);
			System.out.println("I am in Click Exception.");
			generic.fill(guestCountryCode_Txt, data);
		}
	}

	public void positiveCheckoutReview() {
		generic.goToSleep(500);
		generic.click(couponCode_Txt);
		if (ExecutionSuite_PositivePaymentFlow.TestorLive.contains("dev"))
			generic.fill(couponCode_Txt, "FAB15");
		if (ExecutionSuite_PositivePaymentFlow.TestorLive.contains("live"))
			generic.fill(couponCode_Txt, "ICICI20");
		if (ExecutionSuite_PositivePaymentFlow.TestorLive.contains("preprod"))
			generic.fill(couponCode_Txt, "ICICI20");
		generic.click(applyButton_Btn);
		generic.goToSleep(3000);
		String subTotalGetText = generic.getText(subTotal_WE);
		Integer subTotal = Integer.parseInt(subTotalGetText);
		String discountGetText = generic.getText(discount_WE);
		Integer discount = Integer.parseInt(discountGetText);
		String serviceTaxGetText = generic.getText(serviceTax_WE);
		Integer serviceTax = Integer.parseInt(serviceTaxGetText);
		String totalGetText = generic.getText(total_WE);
		Integer total = Integer.parseInt(totalGetText);
		System.out.println("Web subTotal :" + subTotal + ", discount :" + discount + ", serviceTax:" + serviceTax
				+ ", total:" + total + "------");

		int discountCal = (int) (subTotal * .2);
		int subTotalMinusDiscount = subTotal - discountCal;
		int serviceTaxCal = (int) Math.ceil(subTotalMinusDiscount * .09);
		int totalCal = (subTotalMinusDiscount + serviceTaxCal);
		System.out.println("Cal discountCal:" + discountCal + ", subTotalMinusDiscount:" + subTotalMinusDiscount
				+ ", serviceTaxCal:" + serviceTaxCal + ", totalCal:" + totalCal + "... ");

		System.out.println();
		generic.goToSleep(10000);
		Assert.assertEquals(discount.intValue(), discountCal, "Discount does not matches.");
		Assert.assertEquals(serviceTax.intValue(), serviceTaxCal, "ServiceTax does not matches.");
		Assert.assertEquals(total.intValue(), totalCal, "Total does not matches.");

		if (generic.isVisible(continue_Btn))
			generic.click(continue_Btn);
		// if(generic.isVisible(continue_Btn)) generic.click(continue_Btn);
	}

	public void TestCase_GuestDetails(Xls_Reader datatable, String sheetname, int rowNo) {
		generic.fill(guestName_Txt, datatable.getCellData(sheetname, "Name", rowNo));
		generic.fill(guestEmail_Txt, datatable.getCellData(sheetname, "Email", rowNo));
		generic.click(guestCountryCode_Btn);
		System.out.println(
				guestCountryCode1_Dd + datatable.getCellData(sheetname, "CountryCode", rowNo) + guestCountryCode2_Dd);
		SelectCountryCode(datatable.getCellData(sheetname, "CountryCode", rowNo));
		generic.fill(guestMobileNumber_Txt, datatable.getCellData(sheetname, "MobileNumber", rowNo));
		generic.click(guestProcess_Btn);
		generic.goToSleep(3000);
	}

	public void positiveGuestDetails() {
		generic.fill(guestName_Txt, "Testing Script");
		generic.fill(guestEmail_Txt, "sankalp.sharma@fabhotels.com");
		generic.fill(guestMobileNumber_Txt, "9650752666");
		generic.click(guestProcess_Btn);
		generic.goToSleep(3000);
	}

	public void positiveCreditCardPayment() {
		generic.fill(creditCardNo_Txt, "4375514425814000");
		generic.fill(creditCVV_Txt, "007");
		generic.fill(creditExpiryDate_Txt, "01/18");
		generic.fill(creditHolderName_Txt, "Sankalp Sharma");
		generic.click(payRupees_Btn);
		generic.goToSleep(8000);
	}

	public void positiveCreditCardPaymentRetry() {
		generic.fill(creditCardNo_Txt, "4375514425814000");
		generic.fill(creditCVV_Txt, "007");
		generic.fill(creditExpiryDate_Txt, "01/18");
		generic.fill(creditHolderName_Txt, "Sankalp Sharma");
		generic.click(payRupees_Btn);
		generic.goToSleep(3000);
		generic.alertBox_Accept();
		generic.click(creditCardCancel_Btn);
		generic.goToSleep(3000);
		generic.click(tryAgain_Btn);
	}

	public void positiveDebitCardPayment() {
		generic.click(debitCard_Btn);
		generic.fill(debitCardNo_Txt, "4572742504008266");
		generic.fill(debitCVV_Txt, "900");
		generic.fill(debitExpiryDate_Txt, "01/24");
		generic.fill(debitHolderName_Txt, "Sankalp Sharma");
		generic.click(payRupees_Btn);
		generic.goToSleep(3000);
	}

	public void positiveDebitCardPaymentRetry() {
		generic.click(debitCard_Btn);
		generic.fill(debitCardNo_Txt, "4572742504008266");
		generic.fill(debitCVV_Txt, "900");
		generic.fill(debitExpiryDate_Txt, "01/24");
		generic.fill(debitHolderName_Txt, "Sankalp Sharma");
		generic.click(payRupees_Btn);
		generic.goToSleep(3000);
		// generic.alertBox_Accept();
		generic.click(debitCardCancel_Btn);
		generic.alertBox_Accept();
		generic.goToSleep(3000);
		generic.click(tryAgain_Btn);
	}

	public void positiveNetBankingPayment() {
		generic.click(netBanking_Btn);
		generic.click(netbankingICICI_Rd);
		generic.click(payRupees_Btn);
		generic.goToSleep(8000);
		generic.alertBox_Accept();
	}

	public void positiveNetBankingPaymentRetry() {
		generic.click(netBanking_Btn);
		generic.click(netbankingICICI_Rd);
		generic.click(payRupees_Btn);
		generic.goToSleep(5000);
		driver.navigate().back();
		driver.navigate().refresh();
		generic.alertBox_Accept();
		driver.navigate().refresh();
		generic.goToSleep(5000);
		generic.click(tryAgain_Btn);
	}

	public void positiveWalletsPayment() {
		generic.click(wallets_Btn);
		generic.click(payRupees_Btn);
		generic.goToSleep(8000);
		generic.click(payTmCancel_Btn);
		generic.alertBox_Accept();
	}

	public void positiveWalletsPaymentRetry() {
		generic.click(wallets_Btn);
		generic.click(payRupees_Btn);
		generic.goToSleep(8000);
		generic.click(payTmCancel_Btn);
		generic.alertBox_Accept();
		generic.goToSleep(5000);
		generic.click(tryAgain_Btn);
	}

	public void positivePayAtHotels() {
		generic.click(payAtHotel_Btn);
		generic.goToSleep(1000);
		generic.click(wallets_Btn);
		generic.goToSleep(1000);
		generic.click(payAtHotel_Btn);
		generic.goToSleep(1000);
		generic.click(resendOTP_Btn); // requestOTP_Btn
		generic.click(bookNow_Btn);
		generic.goToSleep(8000);
	}

	public String captureError() {
		String total_Error = "";
		if (driver.findElements(By.xpath(errorMessage_Err)).size() > 0) {
			List<WebElement> errors = driver.findElements(By.xpath(errorMessage_Err));
			for (int i = 0; i < errors.size(); i++) {
				if (errors.get(i).isDisplayed()) {
					total_Error = total_Error + ", " + errors.get(i).getText();
				}
			}
		}
		return total_Error;
	}

}