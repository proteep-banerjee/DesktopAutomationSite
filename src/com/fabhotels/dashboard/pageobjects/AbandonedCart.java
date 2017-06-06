package com.fabhotels.dashboard.pageobjects;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;
import com.fabhotels.desktopsite.pageobjects.CheckoutReview;
import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import org.testng.asserts.SoftAssert;

public class AbandonedCart {

	WebDriver driver;
	GenericFunctions generic;
	CheckoutReview CheckoutReview=new CheckoutReview(driver,generic);
	SoftAssert SoftAssert=new SoftAssert();

	public AbandonedCart(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;		
	}

	public String bookingId_Txt = "//input[@name='PaymentRequest[booking_id]']";
	public String transactionRequest_Txt = "//input[@name='PaymentRequest[txn_id]']";
	public String title_Txt = "//input[@name='PaymentRequest[title]']";
	public String firstName_Txt = "//input[@name='PaymentRequest[first_name]']";
	public String lastName_Txt = "//input[@name='PaymentRequest[last_name]']";
	public String email_Txt = "//input[@name='PaymentRequest[email]']";
	public String mobile_Txt = "//input[@name='PaymentRequest[mobile]']";
	public String propertyName_Txt = "//input[@name='PaymentRequest[property_name]']";
	public String city_Txt = "//input[@name='PaymentRequest[city]']";
	public String checkIn_Txt = "//input[@name='PaymentRequest[checkin]']";
	public String CheckOut_Txt = "//input[@name='PaymentRequest[checkout]']";
	public String coupon_Txt = "//input[@name='PaymentRequest[coupon]']";
	public String grandTotal_Txt = "//input[@name='PaymentRequest[grand_total]']";
	public String bookingStatus_Txt = "//input[@name='PaymentRequest[booking_status]']";
	public String status_DD = "//select[@name='PaymentRequest[status]']";
	public String supportStatus_DD = "//select[@name='PaymentRequest[support_status]']";
	public String source_Txt = "//select[@name='PaymentRequest[source]']";
	public String startTime_Txt = "//input[@name='PaymentRequest[start_time]']";
	public String note_Txt = "//input[@name='PaymentRequest[note]']";
	public String bookingLink_Txt = "//input[@name='PaymentRequest[booking_link]']";

	public String viewAbandonedBooking_Btn = "(//img[contains(@src,'gridview/view.png')])[1]";
	public String updateAbandonedBooking_Btn = "(//img[contains(@src,'gridview/update.png')])[1]";




	public void positiveSearch(){
		generic.fill(firstName_Txt, "Testing");
		generic.fill(lastName_Txt, "Script");
		generic.fill(email_Txt, CheckoutReview.emailId);
		System.out.println( " CheckoutReview.emailId : "+CheckoutReview.emailId);
		generic.goToSleep(1000);
		generic.fill(mobile_Txt, "9650752666");
		//	generic.fill(, "");
		//	generic.fill(, "");
		generic.goToSleep(2000);
		generic.enter(mobile_Txt);
		generic.goToSleep(20000);
	}



	public String bookingIdView_WE = "(//tr[@class='odd']/td[1])[1]";
	public String transactionRequestView_WE = "(//tr[@class='odd']/td[2])[1]";
	public String titleView_WE = "(//tr[@class='odd']/td[3])[1]";
	public String firstNameView_WE = "(//tr[@class='odd']/td[4])[1]";
	public String lastNameView_WE = "(//tr[@class='odd']/td[5])[1]";
	public String emailView_WE = "(//tr[@class='odd']/td[6])[1]";
	public String mobileView_WE = "(//tr[@class='odd']/td[7])[1]";
	public String propertyNameView_WE = "(//tr[@class='odd']/td[8])[1]";
	public String cityView_WE = "(//tr[@class='odd']/td[9])[1]";
	public String checkInView_WE = "(//tr[@class='odd']/td[10])[1]";
	public String CheckOutView_WE = "(//tr[@class='odd']/td[11])[1]";
	public String couponView_WE = "(//tr[@class='odd']/td[12])[1]";
	public String grandTotalView_WE = "(//tr[@class='odd']/td[13])[1]";
	public String bookingStatusView_WE = "(//tr[@class='odd']/td[14])[1]";
	public String statusView_WE = "(//tr[@class='odd']/td[15])[1]";
	public String supportStatusView_WE = "(//tr[@class='odd']/td[16])[1]";
	public String sourceView_WE = "(//tr[@class='odd']/td[17])[1]";
	public String startTimeView_WE = "(//tr[@class='odd']/td[18])[1]";
	public String noteView_WE = "(//tr[@class='odd']/td[19])[1]";
	public String bookingLinkView_WE = "(//tr[@class='odd']/td[20])[1]";


	public void viewPositive(){
		String bookingIdView = generic.getText(bookingIdView_WE);
		String transactionRequestView=generic.getText(transactionRequestView_WE);
		String titleView=generic.getText(titleView_WE);
		String firstNameView=generic.getText(firstNameView_WE);
		String lastNameView=generic.getText(lastNameView_WE);
		String emailView=generic.getText(emailView_WE);
		String mobileView=generic.getText(mobileView_WE);
		String propertyNameView=generic.getText(propertyNameView_WE);
		String cityView=generic.getText(cityView_WE);
		String checkInView=generic.getText(checkInView_WE);
		String CheckOutView=generic.getText(CheckOutView_WE);
		String couponView=generic.getText(couponView_WE);
		String grandTotalView=generic.getText(grandTotalView_WE);
		String bookingStatusView=generic.getText(bookingStatusView_WE);
		String statusView=generic.getText(statusView_WE);
		String supportStatusView=generic.getText(supportStatusView_WE);
		String sourceView=generic.getText(sourceView_WE);
		String startTimeView=generic.getText(startTimeView_WE);
		String noteView=generic.getText(noteView_WE);
		String bookingLinkView=generic.getText(bookingLinkView_WE);

		SoftAssert.assertEquals(bookingIdView, "","");
		SoftAssert.assertEquals(transactionRequestView, "","");
		SoftAssert.assertEquals(titleView, "Mr","");
		SoftAssert.assertEquals(firstNameView, "Testing","");
		SoftAssert.assertEquals(lastNameView, "Script","");
		SoftAssert.assertEquals(emailView, CheckoutReview.emailId,"");
		SoftAssert.assertEquals(mobileView, "+91-9650752666","");
		SoftAssert.assertEquals(propertyNameView, "","");
		SoftAssert.assertEquals(cityView, "Gurgaon","");
		SoftAssert.assertEquals(checkInView, "","");
		SoftAssert.assertEquals(CheckOutView, "","");
		SoftAssert.assertEquals(couponView, "ICICI20","");
		SoftAssert.assertEquals(grandTotalView, "","");
		SoftAssert.assertEquals(bookingStatusView, "SENT_TO_PAYTM","");
		//		SoftAssert.assertEquals(statusView, "","");
		SoftAssert.assertEquals(supportStatusView, "NOT_CONTACTED","");
		SoftAssert.assertEquals(sourceView, "","");
		SoftAssert.assertEquals(startTimeView, "","");
		SoftAssert.assertEquals(noteView, "","");
		SoftAssert.assertEquals(bookingLinkView, "Book","");
	}
	//	casa2inns_593106513ff01	Mr			KIOSK-02052017-120138@mailinator.com		
	//	FabHotel Phase 4 Galleria		2017-06-04	2017-06-05	ICICI20	506				2017-06-02 12:01:45	 	Book	Remove	View Update





}
