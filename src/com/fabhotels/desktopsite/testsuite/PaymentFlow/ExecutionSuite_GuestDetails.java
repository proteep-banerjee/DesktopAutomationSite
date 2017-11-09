package com.fabhotels.desktopsite.testsuite.PaymentFlow;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.pageobjects.CheckoutReview;
import com.fabhotels.desktopsite.pageobjects.DetailPage;
import com.fabhotels.desktopsite.pageobjects.OtpProvider;
import com.fabhotels.desktopsite.pageobjects.ListingPage;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.Constants;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_GuestDetails extends Config {

	Xls_Reader datatable;
	String Sheetname;
	ListingPage listingPage;
	DetailPage detailPage;
	CheckoutReview checkoutReview;
	OtpProvider getOtp;

	@BeforeTest
	public void beforeTest() {
		generic = new GenericFunctions(driver);
		driver = generic.startDriver(Driver_Type);
		listingPage = new ListingPage(driver, generic);
		detailPage = new DetailPage(driver, generic);
		checkoutReview = new CheckoutReview(driver, generic);
		getOtp=new OtpProvider(driver, generic);
		datatable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_PAYMENT);
	}

	@DataProvider(name = "DataProvider_GuestDetailsPage")
	public Object[][] DataProvider_GuestDetailPage(Method selectTC) {
		if (selectTC.getName().equalsIgnoreCase("TC_GuestDetails_002_validate_MobileNumber")) {
			Sheetname = "GuestMobileNumber";
		} else if (selectTC.getName().equalsIgnoreCase("TC_GuestDetails_003_validate_EmailId")) {
			Sheetname = "GuestEmailId";
		} else
			Sheetname = "GuestName";
		int rowcount = datatable.getRowCount(Sheetname);
		Object result[][] = new Object[rowcount - 1][2];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = i;
			result[i - 2][1] = datatable.getCellData(Sheetname, "Case_Type", i);
		}
		return result;
	}

	@Test
	public void TC_GuestDetails_001_validate_completerBooking_guestDetails() {
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		detailPage.positive_CheckInCheckOutDateWE();
		checkoutReview.positiveCheckoutReview();
		checkoutReview.click_continue_Btn();
		//mobile number for otp is mentoned in excel
		checkoutReview.TestCase_GuestDetails(datatable, "GuestName", 2);
		checkoutReview.click_guestProceedToPay_Btn();
		checkoutReview.positivePayAtHotels();
		checkoutReview.fill_Otp_Num(getOtp.getOtp());
		checkoutReview.click_bookNow_Btn();
		generic.goToSleep(2000);
		Assert.assertEquals(checkoutReview.get_booking_response_Title(), "Fabulous!","Booking creation is not sucessfull!!!!!!");
	}

	@Test(dataProvider = "DataProvider_GuestDetailsPage")
	public void TC_GuestDetails_002_validate_MobileNumber(int rowNo, String Case_Type) {
		System.out.println("Case_Type :" + Case_Type);
		Sheetname = "GuestMobileNumber";
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		detailPage.positive_CheckInCheckOutDateWE();
		checkoutReview.positiveCheckoutReview();
		checkoutReview.click_continue_Btn();
		checkoutReview.TestCase_GuestDetails(datatable, Sheetname, rowNo);
		checkoutReview.click_guestProceedToPay_Btn();
		String currentError = checkoutReview.captureError();
		String ExpectedErrors = datatable.getCellData(Sheetname, "ExpectedErrors", rowNo);
		String Expected = datatable.getCellData(Sheetname, "Expected", rowNo);
		if (Expected.equalsIgnoreCase("NotSubmitted")) {
			Assert.assertTrue((currentError.equals(ExpectedErrors)), "Errors does not matches. ");
		} else if(Expected.equalsIgnoreCase("Submitted")){
			checkoutReview.positivePayAtHotels();
			checkoutReview.click_bookNow_Btn();
			String errorOTP = checkoutReview.captureError();
			System.out.println("error OTP : " + errorOTP);
			Assert.assertEquals(errorOTP.trim(), ", Please enter a valid input", "OTP Error mismatch");
		}
	}

	@Test(dataProvider = "DataProvider_GuestDetailsPage")
	public void TC_GuestDetails_003_validate_EmailId(int rowNo, String Case_Type) {
		System.out.println("Case_Type :" + Case_Type);
		Sheetname = "GuestEmailId";
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		detailPage.positive_CheckInCheckOutDateWE();
		checkoutReview.positiveCheckoutReview();
		checkoutReview.click_continue_Btn();
		checkoutReview.TestCase_GuestDetails(datatable, Sheetname, rowNo);
		checkoutReview.click_guestProceedToPay_Btn();
		String currentError = checkoutReview.captureError();
		String ExpectedErrors = datatable.getCellData(Sheetname, "ExpectedErrors", rowNo);
		String Expected = datatable.getCellData(Sheetname, "Expected", rowNo);
		if (Expected.equalsIgnoreCase("NotSubmitted")) {
			Assert.assertTrue((currentError.equals(ExpectedErrors)), "Errors does not matches. ");
		} else if(Expected.equalsIgnoreCase("Submitted")){
			checkoutReview.positivePayAtHotels();
			checkoutReview.click_bookNow_Btn();
			String errorOTP = checkoutReview.captureError();
			System.out.println("error OTP : " + errorOTP);
			Assert.assertEquals(errorOTP.trim(), ", Please enter a valid input", "OTP Error mismatch");
		}
	}

	@Test(dataProvider = "DataProvider_GuestDetailsPage")
	public void TC_GuestDetails_004_validate_Name(int rowNo, String Case_Type) {
		System.out.println("Case_Type :" + Case_Type);
		Sheetname = "GuestName";
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		detailPage.positive_CheckInCheckOutDateWE();
		checkoutReview.positiveCheckoutReview();
		checkoutReview.click_continue_Btn();
		checkoutReview.TestCase_GuestDetails(datatable, Sheetname, rowNo);
		checkoutReview.click_guestProceedToPay_Btn();
		String currentError = checkoutReview.captureError();
		String ExpectedErrors = datatable.getCellData(Sheetname, "ExpectedErrors", rowNo);
		String Expected = datatable.getCellData(Sheetname, "Expected", rowNo);
		if (Expected.equalsIgnoreCase("NotSubmitted")) {
			Assert.assertTrue((currentError.equals(ExpectedErrors)), "Errors does not matches. ");
		} else if(Expected.equalsIgnoreCase("Submitted")) {
			checkoutReview.positivePayAtHotels();
			checkoutReview.click_bookNow_Btn();
			String errorOTP = checkoutReview.captureError();
			System.out.println("error OTP : " + errorOTP);
			Assert.assertEquals(errorOTP.trim(), ", Please enter a valid input", "OTP Error mismatch");
		}
	}

	@Test
	public void TC_GuestDetails_005_validate_checkBoxes_guestDetails() {
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		detailPage.positive_CheckInCheckOutDateWE();
		checkoutReview.click_continue_Btn();
		checkoutReview.TestCase_GuestDetails(datatable, "GuestName", 2);
		Assert.assertEquals(checkoutReview.get_checkbox_Subscribe_Chk(), CheckoutReview.checkbox_Subscribe_Msg,"Subscribe checkbox under 'Guest Details' is broken !!");
		checkoutReview.click_checkbox_Subscribe_Chk();
		checkoutReview.click_termsAndCondition_Chk();
		checkoutReview.click_guestProceedToPay_Btn();
		String currentError = checkoutReview.captureError();
		Assert.assertEquals(currentError, ","+CheckoutReview.termsAndCondition_Error_Msg,"Errors for T&C under Guest Details does not matches.");
		checkoutReview.click_guestProceedToPay_Btn();
		checkoutReview.click_termsAndCondition_Chk();
		checkoutReview.click_guestProceedToPay_Btn();
	}

	@Test
	public void TC_GuestDetails_006_validate_checkBoxesLinks_guestDetails() {
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		detailPage.positive_CheckInCheckOutDateWE();
		checkoutReview.click_continue_Btn();
		checkoutReview.click_cancellationPolicy_Lnk();
		generic.SwitchtoNewWindow();
		Assert.assertTrue(generic.isVisible(checkoutReview.get_pageHeading_Lbl("Cancellation and Refunds Policy")),"Cancellation and Refunds policies link are not landing to appropriate pages..");
		generic.closeNewWindow();
		generic.SwitchtoOriginalWindow();
		checkoutReview.click_privacyPolicy_Lnk();
		generic.SwitchtoNewWindow();
		Assert.assertTrue(generic.isVisible(checkoutReview.get_pageHeading_Lbl("Privacy Policy")),"Privacy Policy link are not landing to appropriate pages..");
		generic.closeNewWindow();
		generic.SwitchtoOriginalWindow();
		checkoutReview.click_termsAndconditions_Lnk_Lnk();
		generic.SwitchtoNewWindow();
		Assert.assertTrue(generic.isVisible(checkoutReview.get_pageHeading_Lbl("Terms of Use")),"Terms of Use link are not landing to appropriate pages..");
		generic.closeNewWindow();
		generic.SwitchtoOriginalWindow();
	}

	@Test
	public void TC_GuestDetails_007_validate_header_guestDetails() {
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		detailPage.positive_CheckInCheckOutDateWE();
		checkoutReview.click_continue_Btn();
		checkoutReview.TestCase_GuestDetails(datatable, "GuestName", 2);		
		checkoutReview.click_guestProceedToPay_Btn();
		String email=datatable.getCellData("GuestName", "Email", 2);
		String MobileNumber="+91-"+datatable.getCellData("GuestName", "MobileNumber", 2);
		String reviewDetailsFinalHeader=email+" / "+MobileNumber;
		Assert.assertEquals(checkoutReview.getText_guest_reviewDetails_Header(), reviewDetailsFinalHeader,"Guest Details Header is not appropriate..");
	}

	@AfterTest
	public void aftertest() {
		driver.quit();
	}

}
