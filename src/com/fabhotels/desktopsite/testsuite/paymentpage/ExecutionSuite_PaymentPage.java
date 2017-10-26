package com.fabhotels.desktopsite.testsuite.paymentpage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.pageobjects.DetailPage;
import com.fabhotels.desktopsite.pageobjects.ListingPage;
import com.fabhotels.desktopsite.pageobjects.PaymentPage;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.Constants;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_PaymentPage extends Config {
	String Sheetname;
	Xls_Reader datatable;

	@BeforeTest
	public void beforeTest() {
		generic = new GenericFunctions(driver);
		driver = generic.startDriver(Driver_Type);
		generic.maximize();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.manage().deleteAllCookies();
	}
	
	@DataProvider(name = "DataProvider_paymentPage")
	public Object[][] DataProvider_DetailPage() {
		Sheetname = "DetailPage";
		datatable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_DETAILPAGEANDPAYMENTPAGE);
		int rowcount = datatable.getRowCount(Sheetname);
		Object result[][] = new Object[rowcount - 1][5];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = i;
			result[i - 2][1] = datatable.getCellData(Sheetname, "Locality", i);
			String checkinDate = datatable.getCellData(Sheetname, "CheckInDate", i);
			String checkoutDate = datatable.getCellData(Sheetname, "CheckOutDate", i);
			if (checkinDate.equalsIgnoreCase("today")) {
				result[i - 2][2] = GenericFunctions.getTodaysDate();
			} else {
				result[i - 2][2] = checkinDate;
			}
			if (checkoutDate.equalsIgnoreCase("tomorrow")){
				result[i - 2][3] = GenericFunctions.getTomorrowsDate();
			} 
			else{
			  result[i - 2][3] = GenericFunctions.getDateAfterDays(checkoutDate);
			}
			result[i - 2][4] = datatable.getCellData(Sheetname, "ExpectResults", i);
		}	
		return result;
	}
	
	

	@Test (dataProvider = "DataProvider_paymentPage")
	public void TC_Validate_coupon_minimumOrderAmount (int rowno, String locality, String checkInDate, String checkOutDate,
		String expectResults) throws InterruptedException {
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		ListingPage listingPage = new ListingPage(driver, generic);
		DetailPage detailPage = new DetailPage(driver, generic);
		PaymentPage paymentPage = new PaymentPage(driver, generic);
		if(!generic.isVisible(ListingPage.singleProperty_WE)){
			Assert.assertEquals("Property", "NotFound", "Property is not found on the list page !!");
		}
		listingPage.click_singleProperty_WE();
		Thread.sleep(5000L);
		detailPage.Select_CheckIn_CheckOut_Date_WE(checkInDate, checkOutDate); 		
		Thread.sleep(3000L);
		detailPage.click_bookNow_Btn();
		int paymentPageFinalAmount = 0;
		paymentPageFinalAmount = Integer.parseInt(paymentPage.getText_subTotal_Lbl());
		if (paymentPageFinalAmount >=2000){
			Thread.sleep(5000L);
			paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt, "MINORDERTEST-GPQMXTU92FC64UC");
			paymentPage.click_couponCodeApply_Btn();
			Thread.sleep(3000L);
			Assert.assertEquals(paymentPage.getText_couponCodeSuccessMssg_Lbl(), "Fab! You just saved Rs. 50 on your booking", "The minimum amount coupon is not working !!");
		}
		else {
			Thread.sleep(5000L);
			paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt, "MINORDERTEST-GPQMXTU92FC64UC");
			paymentPage.click_couponCodeApply_Btn();
			Thread.sleep(3000L);
			Assert.assertEquals(paymentPage.getText_couponCodeErrorMssg_Lbl(), "This coupon is applicable above Rs 2000", "The minimum value coupon is able to get applied even on defined minimum value !!");
		}		
	}
	
	
	
	@Test (dataProvider = "DataProvider_paymentPage")
	public void TC_Validate_coupon_maximumCapValue (int rowno, String locality, String checkInDate, String checkOutDate,
		    String expectResults) throws InterruptedException {
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		ListingPage listingPage = new ListingPage(driver, generic);
		DetailPage detailPage = new DetailPage(driver, generic);
		PaymentPage paymentPage = new PaymentPage(driver, generic);
		if(!generic.isVisible(ListingPage.singleProperty_WE)){
			Assert.assertEquals("Property", "NotFound", "Property is not found on the list page !!");
		}
		listingPage.click_singleProperty_WE();
		Thread.sleep(5000L);
		detailPage.Select_CheckIn_CheckOut_Date_WE(checkInDate, checkOutDate); 		
		Thread.sleep(3000L);
		detailPage.click_bookNow_Btn();
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt, "MAXCAPTEST-IGYMAY39SD72");
		paymentPage.click_couponCodeApply_Btn();
		Thread.sleep(3000L);
		Assert.assertEquals(paymentPage.getText_couponCodeSuccessMssg_Lbl(), "Fab! You just saved Rs. 100 on your booking", "maximum Cap Value coupon is not Working !!");		
	}
	
	
	
	@Test (dataProvider = "DataProvider_paymentPage")
	public void TC_Validate_coupon_fixed (int rowno, String locality, String checkInDate, String checkOutDate,
		    String expectResults) throws InterruptedException {
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		ListingPage listingPage = new ListingPage(driver, generic);
		DetailPage detailPage = new DetailPage(driver, generic);
		PaymentPage paymentPage = new PaymentPage(driver, generic);
		if(!generic.isVisible(ListingPage.singleProperty_WE)){
			Assert.assertEquals("Property", "NotFound", "Property is not found on the list page !!");
		}
		listingPage.click_singleProperty_WE();
		Thread.sleep(5000L);
		detailPage.Select_CheckIn_CheckOut_Date_WE(checkInDate, checkOutDate); 		
		Thread.sleep(3000L);
		detailPage.click_bookNow_Btn();
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt, "FIXEDTEST-OSBDO65KDH98");
		paymentPage.click_couponCodeApply_Btn();
		Thread.sleep(3000L);
		Assert.assertEquals(paymentPage.getText_couponCodeSuccessMssg_Lbl(), "Fab! You just saved Rs. 150 on your booking", "fixed coupon is not Working !!");		
	}
	
	
	
	@Test (dataProvider = "DataProvider_paymentPage")
	public void TC_Validate_coupon_percent (int rowno, String locality, String checkInDate, String checkOutDate,
		    String expectResults) throws InterruptedException {
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		ListingPage listingPage = new ListingPage(driver, generic);
		DetailPage detailPage = new DetailPage(driver, generic);
		PaymentPage paymentPage = new PaymentPage(driver, generic);
		double discount=0, paymentPageDiscount=0;
		if(!generic.isVisible(ListingPage.singleProperty_WE)){
			Assert.assertEquals("Property", "NotFound", "Property is not found on the list page !!");
		}
		listingPage.click_singleProperty_WE();
		Thread.sleep(5000L);
		detailPage.Select_CheckIn_CheckOut_Date_WE(checkInDate, checkOutDate); 		
		Thread.sleep(3000L);
		detailPage.click_bookNow_Btn();
		discount = Double.parseDouble(paymentPage.getText_subTotal_Lbl());
		discount = ((discount*10)/100);
		discount = Math.floor(discount);
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt, "PERCENTTEST-KLSD59BS98");
		paymentPage.click_couponCodeApply_Btn();
		Thread.sleep(5000L);
		paymentPageDiscount = Double.parseDouble(paymentPage.getText_discountValue_Lbl());
		Thread.sleep(2000L);
		Assert.assertEquals(paymentPageDiscount, discount, "percent Coupon is not working fine !!");		
	}
	

	@Test (dataProvider = "DataProvider_paymentPage")
	public void TC_Validate_coupon_expire (int rowno, String locality, String checkInDate, String checkOutDate,
		    String expectResults) throws InterruptedException {
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		ListingPage listingPage = new ListingPage(driver, generic);
		DetailPage detailPage = new DetailPage(driver, generic);
		PaymentPage paymentPage = new PaymentPage(driver, generic);
		if(!generic.isVisible(ListingPage.singleProperty_WE)){
			Assert.assertEquals("Property", "NotFound", "Property is not found on the list page !!");
		}
		listingPage.click_singleProperty_WE();
		Thread.sleep(5000L);
		detailPage.Select_CheckIn_CheckOut_Date_WE(checkInDate, checkOutDate); 		
		Thread.sleep(3000L);
		detailPage.click_bookNow_Btn();
		Thread.sleep(5000L);
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt, "EXPIRETEST-IDWLDG73JD989");
		paymentPage.click_couponCodeApply_Btn();
		Thread.sleep(2000L);
		Assert.assertEquals(paymentPage.getText_couponCodeErrorMssg_Lbl(), "Sorry! This coupon code or Loyalty Card Number is expired", "Expired coupon is not working !!");		
	}
	
	
	
	@Test (dataProvider = "DataProvider_paymentPage")
	public void TC_Validate_coupon_inactive (int rowno, String locality, String checkInDate, String checkOutDate,
		    String expectResults) throws InterruptedException {
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		ListingPage listingPage = new ListingPage(driver, generic);
		DetailPage detailPage = new DetailPage(driver, generic);
		PaymentPage paymentPage = new PaymentPage(driver, generic);
		if(!generic.isVisible(ListingPage.singleProperty_WE)){
			Assert.assertEquals("Property", "NotFound", "Property is not found on the list page !!");
		}
		listingPage.click_singleProperty_WE();
		Thread.sleep(5000L);
		detailPage.Select_CheckIn_CheckOut_Date_WE(checkInDate, checkOutDate); 		
		Thread.sleep(3000L);
		detailPage.click_bookNow_Btn();
		Thread.sleep(5000L);
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt, "INACTIVETEST-OALDBU59DID58JS");
		paymentPage.click_couponCodeApply_Btn();
		Thread.sleep(2000L);
		Assert.assertEquals(paymentPage.getText_couponCodeErrorMssg_Lbl(), "Coupon detail not found! Please try again", "Expired coupon is not working !!");		
	}
	
	
	
	@Test (dataProvider = "DataProvider_paymentPage")
	public void TC_Validate_coupon_cityNotAccepted (int rowno, String locality, String checkInDate, String checkOutDate,
		    String expectResults) throws InterruptedException {
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		ListingPage listingPage = new ListingPage(driver, generic);
		DetailPage detailPage = new DetailPage(driver, generic);
		PaymentPage paymentPage = new PaymentPage(driver, generic);
		String errorMssg = " ";
		if(!generic.isVisible(ListingPage.singleProperty_WE)){
			Assert.assertEquals("Property", "NotFound", "Property is not found on the list page !!");
		}
		listingPage.click_singleProperty_WE();
		Thread.sleep(5000L);
		detailPage.Select_CheckIn_CheckOut_Date_WE(checkInDate, checkOutDate); 		
		Thread.sleep(3000L);
		detailPage.click_bookNow_Btn();
		if (locality.equalsIgnoreCase("new delhi")){
			Thread.sleep(3000L);
			paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt, "CITYNOTACCEPTEDTEST-KWHCI48NK0NS");
			paymentPage.click_couponCodeApply_Btn();
			Thread.sleep(5000L);
			Assert.assertEquals(paymentPage.getText_couponCodeSuccessMssg_Lbl(), "Fab! You just saved Rs. 400 on your booking", "The coupon is assigned to new delhi and not working !!");
		}
		else {
			Thread.sleep(5000L);
			paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt, "CITYNOTACCEPTEDTEST-KWHCI48NK0NS");
			paymentPage.click_couponCodeApply_Btn();
			Thread.sleep(3000L);
			errorMssg = "Sorry! This doesn't seem to be a valid coupon code or Loyalty Card Number in this city";
			Assert.assertEquals(paymentPage.getText_couponCodeErrorMssg_Lbl(), errorMssg, "The coupon is assigned to new delhi but it is applicable into other cities also !!");	
		}
	}
	
    
	
	@Test (dataProvider = "DataProvider_paymentPage")
	public void TC_Validate_coupon_propertyNotAccepted (int rowno, String locality, String checkInDate, String checkOutDate,
		    String expectResults) throws InterruptedException {
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		ListingPage listingPage = new ListingPage(driver, generic);
		DetailPage detailPage = new DetailPage(driver, generic);
		PaymentPage paymentPage = new PaymentPage(driver, generic);
		String propertyName = " ", errorMssg = " ";
		if(!generic.isVisible(ListingPage.singleProperty_WE)){
			Assert.assertEquals("Property", "NotFound", "Property is not found on the list page !!");
		}
		listingPage.click_singleProperty_WE();
		Thread.sleep(5000L);
		detailPage.Select_CheckIn_CheckOut_Date_WE(checkInDate, checkOutDate); 		
		Thread.sleep(3000L);
		detailPage.click_bookNow_Btn();
		propertyName = paymentPage.getText_propertyName_Lbl();
		if (propertyName.equalsIgnoreCase("FabHotel Cabana GK1")){
			Thread.sleep(5000L);
			paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt, "PROPERTYNOTACCEPTED-JSB78BSI97");
			paymentPage.click_couponCodeApply_Btn();
			Thread.sleep(3000L);
			Assert.assertEquals(paymentPage.getText_couponCodeSuccessMssg_Lbl(), "Fab! You just saved Rs. 400 on your booking", "The coupon is assigned to new delhi (fabhotel Cabana GK1) and not working !!");
		}
		else if (locality.equalsIgnoreCase("new delhi")){
		Thread.sleep(5000L);
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt, "PROPERTYNOTACCEPTED-JSB78BSI97");
		paymentPage.click_couponCodeApply_Btn();
		Thread.sleep(3000L);
		errorMssg = "Sorry! This doesn't seem to be a valid coupon code or Loyalty Card Number on this property";
		Assert.assertEquals(paymentPage.getText_couponCodeErrorMssg_Lbl(), errorMssg, "The coupon is assigned to new delhi (fabhotel Cabana GK1), but working for other hotel !!");		
		}
		else {
			Thread.sleep(5000L);
			paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt, "PROPERTYNOTACCEPTED-JSB78BSI97");
			paymentPage.click_couponCodeApply_Btn();
			Thread.sleep(3000L);
			errorMssg = "Sorry! This doesn't seem to be a valid coupon code or Loyalty Card Number in this city";
			Assert.assertEquals(paymentPage.getText_couponCodeErrorMssg_Lbl(), errorMssg, "The coupon is assigned to new delhi (fabhotel Cabana GK1), but working for other hotel !!");
		}
	}
	
	
	
	
	@Test (dataProvider = "DataProvider_paymentPage")
	public void TC_Validate_coupon_priceCheckForFixedCoupon (int rowno, String locality, String checkInDate, String checkOutDate,
		    String expectResults) throws InterruptedException {
		double propertyFinalValue = 0, subTotal = 0, taxValue =0;
		String tax = " ";
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		ListingPage listingPage = new ListingPage(driver, generic);
		DetailPage detailPage = new DetailPage(driver, generic);
		PaymentPage paymentPage = new PaymentPage(driver, generic);
		if(!generic.isVisible(ListingPage.singleProperty_WE)){
			Assert.assertEquals("Property", "NotFound", "Property is not found on the list page !!");
		}
		listingPage.click_singleProperty_WE();
		detailPage.Select_CheckIn_CheckOut_Date_WE(checkInDate, checkOutDate); 		
		Thread.sleep(3000L);
		detailPage.click_bookNow_Btn();
		Thread.sleep(3000L);
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt, "FIXEDTEST-OSBDO65KDH98");
		paymentPage.click_couponCodeApply_Btn();
		subTotal = Double.parseDouble(paymentPage.getText_subTotal_Lbl());
		subTotal = subTotal - 150;
		tax = paymentPage.getText_taxPercent_Lbl();
		Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(tax);
	    while (m.find()){
	    	taxValue = Double.parseDouble(m.group(1));
	    }
	    taxValue = (taxValue/100) * subTotal;
	    taxValue = Math.ceil(taxValue);
	    subTotal = subTotal + taxValue;
	    Thread.sleep(5000L);
	    propertyFinalValue = Double.parseDouble(paymentPage.getText_finalAmount_Lbl());
	    Assert.assertEquals(propertyFinalValue, subTotal, "When the fixed coupon is applied the final amount value is not correct !! ");
	}
	
	
	
	@Test (dataProvider = "DataProvider_paymentPage")
	public void TC_Validate_coupon_priceCheckForPercentCoupon (int rowno, String locality, String checkInDate, String checkOutDate,
		    String expectResults) throws InterruptedException {
		double propertyFinalValue = 0, subTotal = 0, taxValue =0;
		String tax = " ";
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		ListingPage listingPage = new ListingPage(driver, generic);
		DetailPage detailPage = new DetailPage(driver, generic);
		PaymentPage paymentPage = new PaymentPage(driver, generic);
		if(!generic.isVisible(ListingPage.singleProperty_WE)){
			Assert.assertEquals("Property", "NotFound", "Property is not found on the list page !!");
		}
		listingPage.click_singleProperty_WE();
		detailPage.Select_CheckIn_CheckOut_Date_WE(checkInDate, checkOutDate); 		
		Thread.sleep(5000L);
		detailPage.click_bookNow_Btn();
		Thread.sleep(3000L);
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt, "PERCENTTEST-KLSD59BS98");
		paymentPage.click_couponCodeApply_Btn();
		subTotal = Double.parseDouble(paymentPage.getText_subTotal_Lbl());
		subTotal = subTotal - ((subTotal*10)/100);
		subTotal = Math.ceil(subTotal);
		tax = paymentPage.getText_taxPercent_Lbl();
		Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(tax);
	    while (m.find()){
	    	taxValue = Double.parseDouble(m.group(1));
	    }
	    taxValue = (taxValue/100) * subTotal;
	    taxValue = Math.ceil(taxValue);
	    subTotal = subTotal + taxValue;
	    Thread.sleep(5000L);
	    propertyFinalValue = Double.parseDouble(paymentPage.getText_finalAmount_Lbl());
	    Assert.assertEquals(propertyFinalValue, subTotal, "When the fixed coupon is applied the final amount value is not correct !! ");
	}

	
	
	@Test (dataProvider = "DataProvider_paymentPage")
	public void TC_Validate_coupon_priceCheckForRemoveFixedCoupon (int rowno, String locality, String checkInDate, String checkOutDate,
		    String expectResults) throws InterruptedException {
		double subTotal =0, taxValue=0;
		String tax = " ";
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		ListingPage listingPage = new ListingPage(driver, generic);
		DetailPage detailPage = new DetailPage(driver, generic);
		PaymentPage paymentPage = new PaymentPage(driver, generic);
		if(!generic.isVisible(ListingPage.singleProperty_WE)){
			Assert.assertEquals("Property", "NotFound", "Property is not found on the list page !!");
		}
		listingPage.click_singleProperty_WE();
		detailPage.Select_CheckIn_CheckOut_Date_WE(checkInDate, checkOutDate); 		
		Thread.sleep(3000L);
		detailPage.click_bookNow_Btn();
		Thread.sleep(3000L);
		subTotal = Double.parseDouble(paymentPage.getText_subTotal_Lbl());
		tax = paymentPage.getText_taxPercent_Lbl();
		Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(tax);
	    while (m.find()){
	    	taxValue = Double.parseDouble(m.group(1));
	    }
	    taxValue = (taxValue/100) * subTotal;
	    taxValue = Math.ceil(taxValue);
	    subTotal = subTotal + taxValue;
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt, "FIXEDTEST-OSBDO65KDH98");
		paymentPage.click_couponCodeApply_Btn();
		Thread.sleep(4000L);
		paymentPage.click_removeCouponCode_Lbl();
	    Assert.assertEquals(Double.parseDouble(paymentPage.getText_finalAmount_Lbl()), subTotal, "When the fixed coupon is removed the final amount value is not correct !! ");
	}
	
	
	
	@Test (dataProvider = "DataProvider_paymentPage")
	public void TC_Validate_coupon_priceCheckForRemovePercentCoupon (int rowno, String locality, String checkInDate, String checkOutDate,
		    String expectResults) throws InterruptedException {
		double subTotal =0, taxValue=0;
		String tax = " ";
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		ListingPage listingPage = new ListingPage(driver, generic);
		DetailPage detailPage = new DetailPage(driver, generic);
		PaymentPage paymentPage = new PaymentPage(driver, generic);
		if(!generic.isVisible(ListingPage.singleProperty_WE)){
			Assert.assertEquals("Property", "NotFound", "Property is not found on the list page !!");
		}
		listingPage.click_singleProperty_WE();
		detailPage.Select_CheckIn_CheckOut_Date_WE(checkInDate, checkOutDate); 		
		Thread.sleep(3000L);
		detailPage.click_bookNow_Btn();
		Thread.sleep(3000L);
		subTotal = Double.parseDouble(paymentPage.getText_subTotal_Lbl());
		tax = paymentPage.getText_taxPercent_Lbl();
		Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(tax);
	    while (m.find())
	    {
	    	taxValue = Double.parseDouble(m.group(1));
	    }
	    taxValue = (taxValue/100) * subTotal;
	    taxValue = Math.ceil(taxValue);
	    subTotal = subTotal + taxValue;
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt, "PERCENTTEST-KLSD59BS98");
		paymentPage.click_couponCodeApply_Btn();
		Thread.sleep(4000L);
		paymentPage.click_removeCouponCode_Lbl();
	    Assert.assertEquals(Double.parseDouble(paymentPage.getText_finalAmount_Lbl()), subTotal, "When the fixed coupon is removed the final amount value is not correct !! ");
	}
	
	
	
	

	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}