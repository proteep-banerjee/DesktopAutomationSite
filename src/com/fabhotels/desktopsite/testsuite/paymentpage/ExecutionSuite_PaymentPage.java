package com.fabhotels.desktopsite.testsuite.paymentpage;

import java.text.ParseException;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fabhotels.apiautomation.pojo.priceDetails.PriceTaxDetail;
import com.fabhotels.apiautomation.utils.FabLogic;
import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;

import com.fabhotels.desktopsite.pageobjects.Calendar;
import com.fabhotels.desktopsite.pageobjects.DetailPage;
import com.fabhotels.desktopsite.pageobjects.ListingPage;
import com.fabhotels.desktopsite.pageobjects.PaymentPage;
import com.fabhotels.desktopsite.pageobjects.SearchBar;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.Constants;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_PaymentPage extends Config {
	String Sheetname;
	String CoupnSheet="Coupons";
	Xls_Reader datatable;
	Calendar cal;
	DetailPage detailspage;
	ListingPage listingPage;
	PaymentPage paymentPage;
	SearchBar performSearch;
	PriceTaxDetail fromAPI;
	Map<String, String> parameters ;
	double subTotal = 0,propertyFinalValue = 0,paymentPageDiscount = 0,discount = 0;
	String propertyId="",todayDate="",discountedPrice="";
	String propertyName = "",errorMssg="",nextDate="";

	@BeforeTest
	public void beforeTest() {
		generic = new GenericFunctions(driver);
		driver = generic.startDriver(Driver_Type);
		listingPage = new ListingPage(driver, generic);
		detailspage = new DetailPage(driver, generic);
		paymentPage = new PaymentPage(driver, generic);
		performSearch=new SearchBar(driver, generic);
		cal = new Calendar(driver, generic);
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
			result[i - 2][2] = datatable.getCellData(Sheetname, "checkInDateAfter", i);
			result[i - 2][3] = datatable.getCellData(Sheetname, "checkOutDateAfter", i);
			result[i - 2][4] = Integer.parseInt(datatable.getCellData(Sheetname, "NumberOfRooms", i));

		}
		return result;
	}

	@Test(dataProvider = "DataProvider_paymentPage")
	public void TC_PaymentPage_Coupon_01_minimumOrderAmount(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws InterruptedException, ParseException {
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl(locality));
		performSearch.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertFalse(listingPage.getSize_hotelList_WE()==0, "Property is not found on the list page !!");
		generic.click(ListingPage.hotelName_WE);
		detailspage.click_selectRooms_Btn();
		generic.goToSleep(1000);
		detailspage.click_roomNumber(1, NumberOfRooms);
		propertyFinalValue = Integer.parseInt(detailspage.getText_bookNow_Btn().replaceAll("[^0-9.]", ""));
		detailspage.click_bookNow_Btn();
		if (propertyFinalValue >= 2000) {
			paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,
					paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","minPrice_2000"));
			paymentPage.click_couponCodeApply_Btn();
			Assert.assertEquals(paymentPage.getText_couponCodeSuccessMssg_Lbl(),
					"Fab! You just saved Rs. 50 on your booking", "The minimum amount coupon is not working !!");
		} else {
			paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","fixedDiscount_50_onMinPrice_2000"));
			paymentPage.click_couponCodeApply_Btn();
			Assert.assertEquals(paymentPage.getText_couponCodeErrorMssg_Lbl(),
					"This coupon is applicable above Rs 2000",
					"The minimum value coupon is able to get applied even on defined minimum value !!");
		}
	}
	
	@Test(dataProvider = "DataProvider_paymentPage")
	public void TC_PaymentPage_Coupon_02_maximumCapValue(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws InterruptedException {
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl(locality));
		performSearch.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertFalse(listingPage.getSize_hotelList_WE()==0, "Property is not found on the list page !!");
		generic.click(ListingPage.hotelName_WE);
		detailspage.click_selectRooms_Btn();
		generic.goToSleep(1000);
		detailspage.click_roomNumber(1, NumberOfRooms);
		detailspage.click_bookNow_Btn();
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","percentDiscount_50_maxDiscount_100"));
		paymentPage.click_couponCodeApply_Btn();
		Assert.assertEquals(paymentPage.getText_couponCodeSuccessMssg_Lbl(),
				"Fab! You just saved Rs. 100 on your booking", "maximum Cap Value coupon is not Working !!");
	}
	
	@Test(dataProvider = "DataProvider_paymentPage")
	public void TC_PaymentPage_Coupon_03_fixed(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws InterruptedException {
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl(locality));
		performSearch.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertFalse(listingPage.getSize_hotelList_WE()==0, "Property is not found on the list page !!");
		generic.click(ListingPage.hotelName_WE);
		detailspage.click_selectRooms_Btn();
		generic.goToSleep(1000);
		detailspage.click_roomNumber(1, NumberOfRooms);
		detailspage.click_bookNow_Btn();
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","fixedDiscount_150"));
		paymentPage.click_couponCodeApply_Btn();
		Assert.assertEquals(paymentPage.getText_couponCodeSuccessMssg_Lbl(),
				"Fab! You just saved Rs. 150 on your booking", "fixed coupon is not Working !!");
	}

	@Test(dataProvider = "DataProvider_paymentPage")
	public void TC_PaymentPage_Coupon_04_percent(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws InterruptedException {
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl(locality));
		performSearch.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertFalse(listingPage.getSize_hotelList_WE()==0, "Property is not found on the list page !!");
		generic.click(ListingPage.hotelName_WE);
		detailspage.click_selectRooms_Btn();
		generic.goToSleep(1000);
		detailspage.click_roomNumber(1, NumberOfRooms);
		detailspage.click_bookNow_Btn();
		discount = Double.parseDouble(paymentPage.getText_subTotal_Lbl());
		discount = ((discount * 10) / 100);
		discount = Math.floor(discount);
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","percentDiscount_10"));
		paymentPage.click_couponCodeApply_Btn();
		paymentPageDiscount = Double.parseDouble(paymentPage.getText_discountValue_Lbl());
		Assert.assertEquals(paymentPageDiscount, discount, "percent Coupon is not working fine !!");
	}

	@Test(dataProvider = "DataProvider_paymentPage")
	public void TC_PaymentPage_Coupon_05_expire(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws InterruptedException {
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl(locality));
		performSearch.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertFalse(listingPage.getSize_hotelList_WE()==0, "Property is not found on the list page !!");
		generic.click(ListingPage.hotelName_WE);
		detailspage.click_selectRooms_Btn();
		generic.goToSleep(1000);
		detailspage.click_roomNumber(1, NumberOfRooms);
		detailspage.click_bookNow_Btn();
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","expiredCoupon"));
		paymentPage.click_couponCodeApply_Btn();
		Assert.assertEquals(paymentPage.getText_couponCodeErrorMssg_Lbl(),
				"Sorry! This coupon code or Loyalty Card Number is expired", "Expired coupon is not working !!");
	}

	@Test(dataProvider = "DataProvider_paymentPage")
	public void TC_PaymentPage_Coupon_06_inactive(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws InterruptedException {
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl(locality));
		performSearch.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertFalse(listingPage.getSize_hotelList_WE()==0, "Property is not found on the list page !!");
		generic.click(ListingPage.hotelName_WE);
		detailspage.click_selectRooms_Btn();
		generic.goToSleep(1000);
		detailspage.click_roomNumber(1, NumberOfRooms);
		detailspage.click_bookNow_Btn();
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","inActiveCoupon"));
		paymentPage.click_couponCodeApply_Btn();
		Assert.assertEquals(paymentPage.getText_couponCodeErrorMssg_Lbl(), "Coupon detail not found! Please try again",
				"Expired coupon is not working !!");
	}

	@Test(dataProvider = "DataProvider_paymentPage")
	public void TC_PaymentPage_Coupon_07_cityNotAccepted(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws InterruptedException {
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl(locality));
		performSearch.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertFalse(listingPage.getSize_hotelList_WE()==0, "Property is not found on the list page !!");
		generic.click(ListingPage.hotelName_WE);
		detailspage.click_selectRooms_Btn();
		generic.goToSleep(1000);
		detailspage.click_roomNumber(1, NumberOfRooms);
		detailspage.click_bookNow_Btn();
		if (locality.equalsIgnoreCase("new delhi")) {
			paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","fixedDiscount_400_onCityDelhi"));
			paymentPage.click_couponCodeApply_Btn();
			Assert.assertEquals(paymentPage.getText_couponCodeSuccessMssg_Lbl(),
					"Fab! You just saved Rs. 400 on your booking",
					"The coupon is assigned to new delhi and not working !!");
		} else {
			paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","fixedDiscount_400_onCityDelhi"));
			paymentPage.click_couponCodeApply_Btn();
			errorMssg = "seem to be a valid coupon code or Loyalty Card Number in this city";
			Assert.assertEquals(paymentPage.getText_couponCodeErrorMssg_Lbl().substring(20), errorMssg,
					"The coupon is assigned to new delhi but it is applicable into other cities also !!");
		}
	}

	@Test(dataProvider = "DataProvider_paymentPage")
	public void TC_PaymentPage_Coupon_08_propertyNotAccepted(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws InterruptedException {
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl(locality));
		performSearch.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertFalse(listingPage.getSize_hotelList_WE()==0, "Property is not found on the list page !!");
		generic.click(ListingPage.hotelName_WE);
		detailspage.click_selectRooms_Btn();
		generic.goToSleep(1000);
		detailspage.click_roomNumber(1, NumberOfRooms);
		detailspage.click_bookNow_Btn();
		propertyName = paymentPage.getText_propertyName_Lbl().split("\n")[0];
		if (propertyName.equalsIgnoreCase("FabHotel Cabana GK1")) {
			paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","fixedDiscount_400_onProperty"));
			paymentPage.click_couponCodeApply_Btn();
			Assert.assertEquals(paymentPage.getText_couponCodeSuccessMssg_Lbl(),
					"Fab! You just saved Rs. 400 on your booking",
					"The coupon is assigned to new delhi (fabhotel Cabana GK1) and not working !!"+"under property :"+propertyName);
		} else if (locality.equalsIgnoreCase("new delhi")) {
			paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","fixedDiscount_400_onProperty"));
			paymentPage.click_couponCodeApply_Btn();
			errorMssg = "seem to be a valid coupon code or Loyalty Card Number on this property";
			Assert.assertEquals(paymentPage.getText_couponCodeErrorMssg_Lbl().substring(20), errorMssg,
					"The coupon is assigned to new delhi (fabhotel Cabana GK1), but working for other hotel !!"+"under property :"+propertyName);
		} else {
			paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","fixedDiscount_400_onProperty"));
			paymentPage.click_couponCodeApply_Btn();
			errorMssg = "seem to be a valid coupon code or Loyalty Card Number in this city";
			Assert.assertEquals(paymentPage.getText_couponCodeErrorMssg_Lbl().substring(20), errorMssg,
					"The coupon is assigned to new delhi (fabhotel Cabana GK1), but working for other hotel !!"+"under property :"+propertyName);
		}
	}

	@Test(dataProvider = "DataProvider_paymentPage")
	public void TC_PaymentPage_Coupon_09_priceCheckForFixedCoupon(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws Exception {
		todayDate = GenericFunctions.getDate0forTodayPlus1forTommorrowMinusOneForYesterday(Integer.parseInt(checkInDateAfter));
		nextDate = GenericFunctions.getDate0forTodayPlus1forTommorrowMinusOneForYesterday(Integer.parseInt(checkOutDateAfter));
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl(locality));
		performSearch.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "1");
		generic.goToSleep(3000);
		Assert.assertFalse(listingPage.getSize_hotelList_WE()==0, "Property is not found on the list page !!");
		listingPage.click_BookNow_FirstTuple_Btn();
		detailspage.click_selectRooms_Btn();
		generic.goToSleep(1000);
		parameters= performSearch.getParameters_URL();
		detailspage.click_roomNumber(1, NumberOfRooms);
		detailspage.click_bookNow_Btn();
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","fixedDiscount_150"));
		paymentPage.click_couponCodeApply_Btn();
		propertyName = paymentPage.getText_propertyName_Lbl().split("\n")[0];
		propertyId=paymentPage.getPropertyId_ByItsName(propertyName);
		PriceTaxDetail fromAPI = FabLogic.getFinalPriceAndTaxWithCoupon(todayDate, nextDate, propertyId, parameters.get(Constants.KEY_ROOMS), parameters.get(Constants.KEY_OCCUPANCY), 150);
		propertyFinalValue = Double.parseDouble(paymentPage.getText_finalAmount_Lbl());
		Assert.assertEquals(propertyFinalValue, fromAPI.getFinalGrandTotal(),
				"When the fixed coupon is applied the final amount value is not correct, comparing with data from API and found on UI !! ");
	}
//expected [1593.0] but found [1592.0]
	@Test(dataProvider = "DataProvider_paymentPage")
	public void TC_PaymentPage_Coupon_10_priceCheckForPercentCoupon(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws Exception {
		todayDate = GenericFunctions.getDate0forTodayPlus1forTommorrowMinusOneForYesterday(Integer.parseInt(checkInDateAfter));
		nextDate = GenericFunctions.getDate0forTodayPlus1forTommorrowMinusOneForYesterday(Integer.parseInt(checkOutDateAfter));
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl(locality));
		performSearch.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "1");
		Assert.assertFalse(listingPage.getSize_hotelList_WE()==0, "Property is not found on the list page !!");
		propertyId=driver.findElement(PaymentPage.propertyContainer_WE).getAttribute("value");
		listingPage.click_BookNow_FirstTuple_Btn();
		generic.goToSleep(3000);
		detailspage.click_selectRooms_Btn();
		detailspage.click_roomNumber(1, NumberOfRooms);
		parameters= performSearch.getParameters_URL();
		detailspage.click_bookNow_Btn();
		subTotal = Double.parseDouble(paymentPage.getText_subTotal_Lbl());
		Double discount = subTotal * (10 / 100f);
		Integer discountInt = discount.intValue();
		Double discountValue = discountInt.doubleValue();
		System.out.println("todayDate"+todayDate+"nextDate"+ nextDate+ "propertyId"+propertyId+ "KEY_ROOMS"+parameters.get(Constants.KEY_ROOMS)+ "KEY_OCCUPANCY"+parameters.get(Constants.KEY_OCCUPANCY)+"discountValue"+discountValue);
		PriceTaxDetail fromAPI = FabLogic.getFinalPriceAndTaxWithCoupon(todayDate, nextDate, propertyId, parameters.get(Constants.KEY_ROOMS), parameters.get(Constants.KEY_OCCUPANCY), discountValue);
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","percentDiscount_10"));
		paymentPage.click_couponCodeApply_Btn();
		generic.goToSleep(1000);
		propertyFinalValue = Double.parseDouble(paymentPage.getText_finalAmount_Lbl());
		Assert.assertEquals(propertyFinalValue, fromAPI.getFinalGrandTotal(),
				"When the fixed coupon is applied the final amount value is not correct, comparing with data from API and found on UI !! ");
	}

	@Test(dataProvider = "DataProvider_paymentPage")
	public void TC_PaymentPage_Coupon_11_priceCheckForRemoveFixedCoupon(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws Exception {
		todayDate = GenericFunctions.getDate0forTodayPlus1forTommorrowMinusOneForYesterday(Integer.parseInt(checkInDateAfter));
		nextDate = GenericFunctions.getDate0forTodayPlus1forTommorrowMinusOneForYesterday(Integer.parseInt(checkOutDateAfter));
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl(locality));
		performSearch.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "1");
		Assert.assertFalse(listingPage.getSize_hotelList_WE()==0, "Property is not found on the list page !!");
		propertyId=driver.findElement(PaymentPage.propertyContainer_WE).getAttribute("value");
		listingPage.click_BookNow_FirstTuple_Btn();
		generic.goToSleep(1000);
		parameters= performSearch.getParameters_URL();
		detailspage.click_selectRooms_Btn();
		detailspage.click_roomNumber(1, NumberOfRooms);
		detailspage.click_bookNow_Btn();
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","fixedDiscount_150"));
		paymentPage.click_couponCodeApply_Btn();
		//propertyName = paymentPage.getText_propertyName_Lbl().split("\n")[0];
		//propertyId=paymentPage.getPropertyId_ByItsName(propertyName);
		PriceTaxDetail fromAPI = FabLogic.getFinalPriceAndTaxWithoutCoupon(todayDate, nextDate, propertyId, parameters.get(Constants.KEY_ROOMS), parameters.get(Constants.KEY_OCCUPANCY));
		paymentPage.click_removeCouponCode_Lbl();
		Assert.assertEquals(Double.parseDouble(paymentPage.getText_finalAmount_Lbl()), fromAPI.getFinalGrandTotal(),
				"When the fixed coupon is removed the final amount value is not correct, comparing with data from API and found on UI !! ");
	}

	@Test(dataProvider = "DataProvider_paymentPage")
	public void TC_PaymentPage_Coupon_12_priceCheckForRemovePercentCoupon(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws Exception {
		todayDate = GenericFunctions.getDate0forTodayPlus1forTommorrowMinusOneForYesterday(Integer.parseInt(checkInDateAfter));
		nextDate = GenericFunctions.getDate0forTodayPlus1forTommorrowMinusOneForYesterday(Integer.parseInt(checkOutDateAfter));
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl(locality));
		performSearch.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "1");
		Assert.assertFalse(listingPage.getSize_hotelList_WE()==0, "Property is not found on the list page !!");
		propertyId=driver.findElement(PaymentPage.propertyContainer_WE).getAttribute("value");
		listingPage.click_BookNow_FirstTuple_Btn();
		generic.goToSleep(1000);
		parameters= performSearch.getParameters_URL();
		detailspage.click_selectRooms_Btn();
		detailspage.click_roomNumber(1, NumberOfRooms);
		detailspage.click_bookNow_Btn();
		subTotal = Double.parseDouble(paymentPage.getText_subTotal_Lbl());
		Double discount = subTotal * (10 / 100f);
		Integer discountInt = discount.intValue();
		Double discountValue = discountInt.doubleValue();
		//propertyName = paymentPage.getText_propertyName_Lbl().split("\n")[0];
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","percentDiscount_10"));
		//paymentPage.getPropertyId_ByItsName(propertyName);
		System.out.println(todayDate + "\t"  +nextDate  +"\t"+propertyId+ "\t"+parameters.get(Constants.KEY_ROOMS)+"\t"+parameters.get(Constants.KEY_OCCUPANCY)+"\t"+discountValue);
		paymentPage.click_couponCodeApply_Btn();
		generic.goToSleep(1000);
		PriceTaxDetail fromAPI = FabLogic.getFinalPriceAndTaxWithoutCoupon(todayDate, nextDate, propertyId, parameters.get(Constants.KEY_ROOMS), parameters.get(Constants.KEY_OCCUPANCY));
		paymentPage.click_removeCouponCode_Lbl();
		Assert.assertEquals(Double.parseDouble(paymentPage.getText_finalAmount_Lbl()), fromAPI.getFinalGrandTotal(),
				"When the percent coupon is removed the final amount value is not correct, comparing with data from API and found on UI !! ");
	}
	
	@Test
	public void TC_PaymentPage_Coupon_13_byNights() throws Exception {
		String checkinAfter="2",checkoutAfter="5";
		todayDate = GenericFunctions.getDate0forTodayPlus1forTommorrowMinusOneForYesterday(Integer.parseInt(checkinAfter));
		nextDate = GenericFunctions.getDate0forTodayPlus1forTommorrowMinusOneForYesterday(Integer.parseInt(checkoutAfter));
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());		
		propertyId=paymentPage.getText_propertyIdOnDetailsPage_WE();
		System.out.println(propertyId);
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE(GenericFunctions.getDateAfterDays(checkinAfter),GenericFunctions.getDateAfterDays(checkoutAfter));
		detailspage.click_selectRooms_Btn();
		String sellPrice = detailspage.getLabelText_price_Lbl().replace(",", "").replaceAll("\\D+", "");
		double oneRoomPriceWithTax=FabLogic.getGstSlabBasedTax(Double.parseDouble(sellPrice));
		int singleRoomPriceWithtax=(int) Math.round(oneRoomPriceWithTax+Double.parseDouble(sellPrice));
		generic.goToSleep(1000);
		detailspage.click_roomNumber(1, 1);
		detailspage.click_bookNow_Btn();
		PriceTaxDetail fromAPI = FabLogic.getFinalPriceAndTaxWithCoupon(todayDate, nextDate, propertyId, "1", "1", singleRoomPriceWithtax);
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","1NightOff_onMin3Night_onTestProperty"));
		paymentPage.click_couponCodeApply_Btn();
		generic.goToSleep(1000);
		propertyFinalValue = Double.parseDouble(paymentPage.getText_finalAmount_Lbl());
		Assert.assertEquals(propertyFinalValue, fromAPI.getFinalGrandTotal(),"When by night coupons is applied the final amount value is not correct, comparing with data from API and found on UI !!");
		Assert.assertEquals(paymentPage.getText_couponCodeSuccessMssg_Lbl(),
				"Fab! You just saved Rs. "+singleRoomPriceWithtax+" on your booking", "by nights coupon is not Working !!");
	}
	//expected [6090.0] but found [6089]
	@Test
	public void TC_PaymentPage_Coupon_14_byNights_multipleRoomTypes() throws Exception {
		SoftAssert customassert = new SoftAssert();
		String checkinAfter="2",checkoutAfter="5";
		todayDate = GenericFunctions.getDate0forTodayPlus1forTommorrowMinusOneForYesterday(Integer.parseInt(checkinAfter));
		nextDate = GenericFunctions.getDate0forTodayPlus1forTommorrowMinusOneForYesterday(Integer.parseInt(checkoutAfter));
		int totalNights =  Integer.parseInt(checkoutAfter)-Integer.parseInt(checkinAfter);
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());		
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE(GenericFunctions.getDateAfterDays(checkinAfter),GenericFunctions.getDateAfterDays(checkoutAfter));
		detailspage.click_selectRooms_Btn();
		generic.goToSleep(1000);
		detailspage.click_roomNumber(1, 1);
		detailspage.click_roomNumber(3, 1);
		int roomType1Price=Integer.parseInt(detailspage.return_priceByRoomType(1));
		int roomType2Price=Integer.parseInt(detailspage.return_priceByRoomType(3));
		int roomType1TotalNightsPriceWithTax=(int) ((FabLogic.getGstSlabBasedTax(roomType1Price)+roomType1Price)*totalNights);
		int roomType2TotalNightsPriceWithTax=(int) ((FabLogic.getGstSlabBasedTax(roomType2Price)+roomType2Price)*totalNights);
		System.out.println("first "+roomType1TotalNightsPriceWithTax+"second"+roomType2TotalNightsPriceWithTax);	
		propertyId=paymentPage.getText_propertyIdOnDetailsPage_WE();
		double totalRoomPriceWithTax=roomType1TotalNightsPriceWithTax+roomType2TotalNightsPriceWithTax;
		int avgRoomPriceWithtax=(int) (totalRoomPriceWithTax/totalNights);
		detailspage.click_bookNow_Btn();
		System.out.println("totalRoomPriceWithTax"+totalRoomPriceWithTax+"avgRoomPriceWithtax"+avgRoomPriceWithtax);
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","1NightOff_onMin3Night_onTestProperty"));
		paymentPage.click_couponCodeApply_Btn();
		generic.goToSleep(2000);
		customassert.assertEquals(avgRoomPriceWithtax, Double.parseDouble(paymentPage.getText_discountValue_Lbl()),"When nights coupons is applied ON MULTIPLE ROOM TYPE ,the discounted price is not correct, comparing with data from API and found on UI !!");
		customassert.assertAll();
	}

	@Test
	public void TC_PaymentPage_Coupon_15_minThreeNightRequiredWarning() throws Exception {
		SoftAssert customassert = new SoftAssert();
		String checkinAfter="2",checkoutAfter="4";
		todayDate = GenericFunctions.getDate0forTodayPlus1forTommorrowMinusOneForYesterday(Integer.parseInt(checkinAfter));
		nextDate = GenericFunctions.getDate0forTodayPlus1forTommorrowMinusOneForYesterday(Integer.parseInt(checkoutAfter));
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());		
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE(GenericFunctions.getDateAfterDays(checkinAfter),GenericFunctions.getDateAfterDays(checkoutAfter));
		detailspage.click_selectRooms_Btn();
		generic.goToSleep(1000);
		detailspage.click_roomNumber(1, 1);
		detailspage.click_bookNow_Btn();
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","1NightOff_onMin3Night_onTestProperty"));
		paymentPage.click_couponCodeApply_Btn();
		generic.goToSleep(1000);
		customassert.assertEquals(paymentPage.getText_couponCodeErrorMssg_Lbl(), "3"+paymentPage.minimumRoomTypeWarning_Lbl,
				"When less than 3 nights are provided the coupon is failing, Min 3 nights are requred for this coupon.. Asserting the warning message.. ");
		customassert.assertAll();
	}
	//expected [18269.0] but found [18270.0]
	@Test
	public void TC_PaymentPage_Coupon_16_priceCheckForRemoveCouponbyNights() throws Exception {
		SoftAssert customassert = new SoftAssert();
		String checkinAfter="2",checkoutAfter="5";
		todayDate = GenericFunctions.getDate0forTodayPlus1forTommorrowMinusOneForYesterday(Integer.parseInt(checkinAfter));
		nextDate = GenericFunctions.getDate0forTodayPlus1forTommorrowMinusOneForYesterday(Integer.parseInt(checkoutAfter));
		int totalNights =  Integer.parseInt(checkoutAfter)-Integer.parseInt(checkinAfter);
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());		
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE(GenericFunctions.getDateAfterDays(checkinAfter),GenericFunctions.getDateAfterDays(checkoutAfter));
		detailspage.click_selectRooms_Btn();
		generic.goToSleep(1000);
		detailspage.click_roomNumber(1, 1);
		detailspage.click_roomNumber(3, 1);
		int roomType1Price=Integer.parseInt(detailspage.return_priceByRoomType(1));
		int roomType2Price=Integer.parseInt(detailspage.return_priceByRoomType(3));
		System.out.println("GST of room 1: "+FabLogic.getGstSlabBasedTax(roomType1Price));
		System.out.println("GST of room 2: "+FabLogic.getGstSlabBasedTax(roomType2Price));
		int roomType1TotalNightsPriceWithTax=(int) ((FabLogic.getGstSlabBasedTax(roomType1Price)+roomType1Price)*totalNights);
		int roomType2TotalNightsPriceWithTax=(int) ((FabLogic.getGstSlabBasedTax(roomType2Price)+roomType2Price)*totalNights);
		double totalRoomPriceWithTax=roomType1TotalNightsPriceWithTax+roomType2TotalNightsPriceWithTax;
		int avgRoomPriceWithtax=(int) (totalRoomPriceWithTax/totalNights);
		detailspage.click_bookNow_Btn();
		System.out.println("totalRoomPriceWithTax"+totalRoomPriceWithTax+"avgRoomPriceWithtax"+avgRoomPriceWithtax);
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","1NightOff_onMin3Night_onTestProperty"));
		paymentPage.click_couponCodeApply_Btn();
		generic.goToSleep(1000);
		paymentPage.click_removeCouponCode_Lbl();
		customassert.assertEquals(Double.parseDouble(paymentPage.getText_finalAmount_Lbl()), totalRoomPriceWithTax,
				"When the by nights coupon is removed the final amount value is not correct, comparing with data from API and found on UI !! ");
		customassert.assertAll();
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}