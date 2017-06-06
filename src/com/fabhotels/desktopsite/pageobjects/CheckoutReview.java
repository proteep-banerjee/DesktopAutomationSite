package com.fabhotels.desktopsite.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.testsuite.PaymentFlow.ExecutionSuite_GuestDetails;

public class CheckoutReview {


	WebDriver driver;
	GenericFunctions generic = new GenericFunctions(driver);


	public CheckoutReview(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}

	public static final String couponCode_Txt = "//input[@placeholder='Enter coupon or gift card code']";
	public static final String applyButton_Btn = "//div[@class='review_booking_offers']//div[@class='apply_coupon_code']";
	public static final String applyCross_Btn = "//div[@class='review_booking_coupon_detail']//span[@class='remove_coupon_code']";
	public static final String subTotal_WE = "//span[@class='sub-total-amount']";
	public static final String discount_WE = "//span[@class='discount-amount']";
	public static final String serviceTax_WE = "//span[@class='tax-amount']";
	public static final String total_WE = "//div[@class='review_booking_total_amount']//span[@class='grand-total-amount']";
	public static final String continue_Btn = "//div[@class='review_booking_continue submit-booking-details']";
	//span[@class='grand-total-amount']

	//Guest details
	public static final String guestName_Txt = "//div[@class='review_guest_details_single']//input[@data-name='fullname']";
	public static final String guestEmail_Txt = "//div[@class='review_guest_details_single']//input[@data-name='email']";
	public static final String guestCountryCode_Btn="//input[@id='country-code']";
	public static final String guestCountryCode1_Dd ="//div[@class='country_code_list_container']//span[contains(text(),'";
	public static final String guestCountryCode2_Dd ="')]/..";
	public static final String guestCountryCode_Txt = "//input[@id='country-code']";
	public static final String guestMobileNumber_Txt = "//div[@class='review_guest_details_mobile_input']//input[@data-name='mobile']";
	public static final String guestProcess_Btn = "//div[@class='review_guest_continue submit-guest-details']";
	public static final String guestSubscribe_Chk = "//input[@id='Checkbox_Subscribe']";
	public static final String guestPolicies_Chk = "//input[@id='Checkbox_Policies']";

	public static final String creditCard_Btn ="//li[@tab-order='1']";
	public static final String debitCard_Btn ="//li[@tab-order='2']";
	public static final String netBanking_Btn ="//li[@tab-order='3']";
	public static final String wallets_Btn ="//li[@tab-order='4']";
	public static final String payAtHotel_Btn ="//li[@tab-order='5']";

	public static final String creditCardNo_Txt = "(//input[@placeholder='Card number'])[1]";
	public static final String creditHolderName_Txt = "(//input[@placeholder='Card holder name'])[1]";
	public static final String creditExpiryDate_Txt = "(//input[@placeholder='MM / YY'])[1]";
	public static final String creditCVV_Txt = "(//input[@placeholder='CVV'])[1]";
	public static final String creditCardCancel_Btn =".//*[@id='contentBodyDiv']//a[contains(@href,'cancel')]";

	public static final String debitCardNo_Txt = "(//input[@placeholder='Card number'])[2]";
	public static final String debitHolderName_Txt = "(//input[@placeholder='Card holder name'])[2]";
	public static final String debitExpiryDate_Txt = "(//input[@placeholder='MM / YY'])[2]";
	public static final String debitCVV_Txt = "(//input[@placeholder='CVV'])[2]";
	public static final String debitCardCancel_Btn = "//button[@id='cancel']";

	public static final String netbankingHDFC_Rd = "//input[@id='netbanking_HDFC']";
	public static final String netbankingICICI_Rd = "//input[@id='netbanking_ICICI']";
	public static final String netbankingCITI_Rd = "//input[@id='netbanking_CITI']";
	public static final String netbankingSBI_Rd = "//input[@id='netbanking_SBI']";
	public static final String netbankingAXIS_Rd = "//input[@id='netbanking_AXIS']";
	public static final String netbankingKOTAK_Rd = "//input[@id='netbanking_KOTAK']";

	public static final String chooseBank_DD = "//select[@class='bank-list']//option[text()='SBI']";

	public static final String payRupees_Btn= "//div[@class='review_payment_submit']//div";
	public static final String payTmCancel_Btn= "//a[contains(@href,'/oltp-web/cancelTransaction')]";


	public static final String requestOTP_Btn = "(//div//span[text()='Request OTP'])[2]";  //"(//div[@class='review_payment_details_single_medium']//div//span[text()='Request OTP'])[1]";
	public static final String resendOTP_Btn = "//span[text()='Resend OTP']";
	public static final String enterOTP_Txt = "//input[@placeholder='Enter OTP']";
	public static final String mobileOrEmail_WE = "//div[@class='review_payment_verify_mobile']//span";
	public static final String bookNow_Btn = "//div[@class='review_payment_option_details']//span[text()='Book Now']";

	public static final String tryAgain_Btn = "//div[@data-url='/checkout/review']";

	public static final String errorMessage_Err = "//p[contains(@class,'_error')]";


	public static String emailId="";


			public void SelectCountryCode(String data){
		try{
			//	System.out.println("Click :"+xPath);
			driver.findElement(By.xpath(guestCountryCode1_Dd+data+guestCountryCode1_Dd)).click();
		}catch(Exception ex){
			generic.goToSleep(1000);
			System.out.println("I am in Click Exception.");
			generic.fill(guestCountryCode_Txt, data);
		}
	}
	public void positiveCheckoutReview(){
		generic.goToSleep(500);
		generic.click(couponCode_Txt);
		if(ExecutionSuite_GuestDetails.Environment.contains("dev")) generic.fill(couponCode_Txt, "ICICI20");
		if(ExecutionSuite_GuestDetails.Environment.contains("live")) generic.fill(couponCode_Txt,"ICICI20" );
		if(ExecutionSuite_GuestDetails.Environment.contains("preprod")) generic.fill(couponCode_Txt,"ICICI20" );
		generic.click(applyButton_Btn);
		String subTotalGetText=generic.getText(subTotal_WE);
		Integer subTotal = Integer.parseInt(subTotalGetText);
		String discountGetText = generic.getText(discount_WE);
		Integer discount = Integer.parseInt(discountGetText);
		String serviceTaxGetText = generic.getText(serviceTax_WE);
		Integer serviceTax = Integer.parseInt(serviceTaxGetText);
		String totalGetText = generic.getText(total_WE);
		Integer total = Integer.parseInt(totalGetText);
		//System.out.println(subTotal+", "+discount+", "+serviceTax+", "+total+"------");

		int discountCal = (int) (subTotal*.2);
		int subTotalMinusDiscount = subTotal-discountCal;
		int serviceTaxCal= (int) Math.ceil(subTotalMinusDiscount*.09);
		int totalCal = (subTotalMinusDiscount+ serviceTaxCal);
		//System.out.println(discountCal+", "+subTotalMinusDiscount+", "+serviceTaxCal+", "+totalCal+"... ");

		Assert.assertEquals(discount.intValue(), discountCal, "Discount does not matches.");
		Assert.assertEquals(serviceTax.intValue(), serviceTaxCal, "ServiceTax does not matches.");
		Assert.assertEquals(total.intValue(), totalCal, "Total does not matches.");

		if(generic.isVisible(continue_Btn)) generic.click(continue_Btn);
		//if(generic.isVisible(continue_Btn)) generic.click(continue_Btn);
	}

	public void TestCase_GuestDetails(Xls_Reader datatable, String sheetname, int rowNo){
		generic.fill(guestName_Txt, datatable.getCellData(sheetname, "Name", rowNo));
		generic.fill(guestEmail_Txt, datatable.getCellData(sheetname, "Email", rowNo));
		generic.click(guestCountryCode_Btn);
		System.out.println(guestCountryCode1_Dd+datatable.getCellData(sheetname, "CountryCode", rowNo)+guestCountryCode2_Dd);
		SelectCountryCode(datatable.getCellData(sheetname, "CountryCode", rowNo));
		generic.fill(guestMobileNumber_Txt, datatable.getCellData(sheetname, "MobileNumber", rowNo));
		generic.click(guestProcess_Btn);
		generic.goToSleep(3000);
	}

	public void positiveGuestDetails(){
		generic.fill(guestName_Txt, "Testing Script");
		generic.fill(guestEmail_Txt, "sankalp.sharma@fabhotels.com");
		generic.fill(guestMobileNumber_Txt, "9650752666");
		generic.click(guestProcess_Btn);
		generic.goToSleep(3000);
	}


	public void positiveCreditCardPayment(){
		generic.fill(creditCardNo_Txt, "4375514425814000");
		generic.fill(creditCVV_Txt, "007");
		generic.fill(creditExpiryDate_Txt, "01/18");
		generic.fill(creditHolderName_Txt, "Sankalp Sharma");
		generic.click(payRupees_Btn);
		generic.goToSleep(8000);
	}

	public void positiveCreditCardPaymentRetry(){
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

	public void positiveDebitCardPayment(){
		generic.click(debitCard_Btn);
		generic.fill(debitCardNo_Txt, "4572742504008266");
		generic.fill(debitCVV_Txt, "900");
		generic.fill(debitExpiryDate_Txt, "01/24");
		generic.fill(debitHolderName_Txt, "Sankalp Sharma");
		generic.click(payRupees_Btn);
		generic.goToSleep(3000);
	}

	public void positiveDebitCardPaymentRetry(){
		generic.click(debitCard_Btn);
		generic.fill(debitCardNo_Txt, "4572742504008266");
		generic.fill(debitCVV_Txt, "900");
		generic.fill(debitExpiryDate_Txt, "01/24");
		generic.fill(debitHolderName_Txt, "Sankalp Sharma");
		generic.click(payRupees_Btn);
		generic.goToSleep(3000);
		//generic.alertBox_Accept();
		generic.click(debitCardCancel_Btn);
		generic.alertBox_Accept();
		generic.goToSleep(3000);
		generic.click(tryAgain_Btn);
	}

	public void positiveNetBankingPayment(){
		generic.click(netBanking_Btn);
		generic.click(netbankingICICI_Rd);
		generic.click(payRupees_Btn);
		generic.goToSleep(8000);
		generic.alertBox_Accept();
	}

	public void positiveNetBankingPaymentRetry(){
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

	public void positiveWalletsPayment(){
		generic.click(wallets_Btn);
		generic.click(payRupees_Btn);
		generic.goToSleep(8000);
		generic.click(payTmCancel_Btn);
		generic.alertBox_Accept();
	}

	public void positiveWalletsPaymentRetry(){
		generic.click(wallets_Btn);
		generic.click(payRupees_Btn);
		generic.goToSleep(8000);
		generic.click(payTmCancel_Btn);
		generic.alertBox_Accept();
		generic.goToSleep(5000);
		generic.click(tryAgain_Btn);
	}

	public void positivePayAtHotels(){
		generic.click(payAtHotel_Btn);
		generic.goToSleep(1000);
		generic.click(wallets_Btn);
		generic.goToSleep(1000);
		generic.click(payAtHotel_Btn);
		generic.goToSleep(1000);
		generic.click(requestOTP_Btn);
		generic.click(bookNow_Btn);
		generic.goToSleep(8000);
	}

	public void positiveGuestDetailsForAbandonedcard(){
		emailId=generic.getEmailasCurrentTimeStamp();
		generic.fill(guestName_Txt, "Testing Script");
		generic.fill(guestEmail_Txt, emailId);
		generic.fill(guestMobileNumber_Txt, "9650752666");
		generic.click(guestProcess_Btn);
		generic.goToSleep(3000);
	}


	public String captureError(){
		String total_Error="";
		if(driver.findElements(By.xpath(errorMessage_Err)).size()> 0){
			List<WebElement> errors= driver.findElements(By.xpath(errorMessage_Err));
			for(int i=0; i<errors.size(); i++){
				if(errors.get(i).isDisplayed()){
					total_Error= total_Error+", "+errors.get(i).getText();
				}
			}
		}
		return total_Error;
	}


}
