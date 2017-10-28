package com.fabhotels.desktopsite.testsuite.paymentpage;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fabhotels.apiautomation.pojo.priceDetails.PriceTaxDetail;
import com.fabhotels.apiautomation.utils.FabLogic;
import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.pageobjects.Calendar;
import com.fabhotels.desktopsite.pageobjects.DetailPage;
import com.fabhotels.desktopsite.pageobjects.ListingPage;
import com.fabhotels.desktopsite.pageobjects.PaymentPage;
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

	@BeforeTest
	public void beforeTest() {
		generic = new GenericFunctions(driver);
		driver = generic.startDriver(Driver_Type);
		listingPage = new ListingPage(driver, generic);
		detailspage = new DetailPage(driver, generic);
		paymentPage = new PaymentPage(driver, generic);
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
	public void TC_Validate_coupon_minimumOrderAmount(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws InterruptedException, ParseException {
		int paymentPageFinalAmount = 0;
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		listingPage.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertTrue(generic.isVisible(ListingPage.listResults_WE), "Property is not found on the list page !!");
		generic.click(ListingPage.hotelName_WE);
		detailspage.click_selectRooms_Btn();
		generic.goToSleep(1000);
		detailspage.click_roomNumber(1, NumberOfRooms);
		paymentPageFinalAmount = Integer.parseInt(detailspage.getText_bookNow_Btn().replaceAll("[^0-9.]", ""));
		detailspage.click_bookNow_Btn();
		if (paymentPageFinalAmount >= 2000) {
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
	public void TC_Validate_coupon_maximumCapValue(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws InterruptedException {
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		listingPage.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertTrue(generic.isVisible(ListingPage.listResults_WE), "Property is not found on the list page !!");
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
	public void TC_Validate_coupon_fixed(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws InterruptedException {
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		listingPage.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertTrue(generic.isVisible(ListingPage.listResults_WE), "Property is not found on the list page !!");
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
	public void TC_Validate_coupon_percent(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws InterruptedException {
		double discount = 0, paymentPageDiscount = 0;
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		listingPage.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertTrue(generic.isVisible(ListingPage.listResults_WE), "Property is not found on the list page !!");
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
	public void TC_Validate_coupon_expire(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws InterruptedException {
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		listingPage.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertTrue(generic.isVisible(ListingPage.listResults_WE), "Property is not found on the list page !!");
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
	public void TC_Validate_coupon_inactive(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws InterruptedException {
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		listingPage.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertTrue(generic.isVisible(ListingPage.listResults_WE), "Property is not found on the list page !!");
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
	public void TC_Validate_coupon_cityNotAccepted(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws InterruptedException {
		String errorMssg = " ";
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		listingPage.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertTrue(generic.isVisible(ListingPage.listResults_WE), "Property is not found on the list page !!");
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
			errorMssg = "Sorry! This doesn’t seem to be a valid coupon code or Loyalty Card Number in this city";
			Assert.assertEquals(paymentPage.getText_couponCodeErrorMssg_Lbl(), errorMssg,
					"The coupon is assigned to new delhi but it is applicable into other cities also !!");
		}
	}
	
	@Test(dataProvider = "DataProvider_paymentPage")
	public void TC_Validate_coupon_propertyNotAccepted(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws InterruptedException {
		String propertyName = " ", errorMssg = " ";
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		listingPage.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertTrue(generic.isVisible(ListingPage.listResults_WE), "Property is not found on the list page !!");
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
			errorMssg = "Sorry! This doesn’t seem to be a valid coupon code or Loyalty Card Number on this property";
			Assert.assertEquals(paymentPage.getText_couponCodeErrorMssg_Lbl(), errorMssg,
					"The coupon is assigned to new delhi (fabhotel Cabana GK1), but working for other hotel !!"+"under property :"+propertyName);
		} else {
			paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","fixedDiscount_400_onProperty"));
			paymentPage.click_couponCodeApply_Btn();
			errorMssg = "Sorry! This doesn’t seem to be a valid coupon code or Loyalty Card Number in this city";
			Assert.assertEquals(paymentPage.getText_couponCodeErrorMssg_Lbl(), errorMssg,
					"The coupon is assigned to new delhi (fabhotel Cabana GK1), but working for other hotel !!"+"under property :"+propertyName);
		}
	}

	@Test(dataProvider = "DataProvider_paymentPage")
	public void TC_Validate_coupon_priceCheckForFixedCoupon(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws Exception {
		double propertyFinalValue = 0;
		Map<String, String> parameters ;
		String propertyId="",propertyName = "",nextDate="",todayDate ="";
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		listingPage.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertTrue(generic.isVisible(ListingPage.listResults_WE), "Property is not found on the list page !!");
		generic.click(ListingPage.bookNow_FirstTuple_Lbl);
		detailspage.click_selectRooms_Btn();
		generic.goToSleep(1000);
		parameters= listingPage.getQueryURL();
		detailspage.click_roomNumber(1, NumberOfRooms);
		detailspage.click_bookNow_Btn();
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","fixedDiscount_150"));
		paymentPage.click_couponCodeApply_Btn();
		propertyName = paymentPage.getText_propertyName_Lbl().split("\n")[0];
		propertyId=paymentPage.getPropertyId_ByItsName(propertyName);
		todayDate = LocalDate.now().toString();
		nextDate = LocalDate.now().plusDays(Integer.parseInt(checkOutDateAfter)).toString();
		PriceTaxDetail check = FabLogic.getFinalPriceAndTaxWithCoupon(todayDate, nextDate, propertyId, parameters.get(Constants.KEY_ROOMS), parameters.get(Constants.KEY_OCCUPANCY), 150);
		propertyFinalValue = Double.parseDouble(paymentPage.getText_finalAmount_Lbl());
		Assert.assertEquals(propertyFinalValue, check.getFinalGrandTotal(),
				"When the fixed coupon is applied the final amount value is not correct !! ");
	}

	@Test(dataProvider = "DataProvider_paymentPage")
	public void TC_Validate_coupon_priceCheckForPercentCoupon(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws Exception {
		Map<String, String> parameters ;
		double propertyFinalValue = 0, subTotal = 0;
		String propertyId="",propertyName = "",nextDate="",todayDate ="";
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		listingPage.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertTrue(generic.isVisible(ListingPage.listResults_WE), "Property is not found on the list page !!");
		generic.click(ListingPage.bookNow_FirstTuple_Lbl);
		generic.goToSleep(1000);
		detailspage.click_selectRooms_Btn();
		parameters= listingPage.getQueryURL();
		detailspage.click_roomNumber(1, NumberOfRooms);
		detailspage.click_bookNow_Btn();
		subTotal = Double.parseDouble(paymentPage.getText_subTotal_Lbl());
		Double discount = subTotal * (10 / 100f);
		Integer discountInt = discount.intValue();
		Double discountValue = discountInt.doubleValue();
		PriceTaxDetail fromAPI = FabLogic.getFinalPriceAndTaxWithCoupon(todayDate, nextDate, propertyId, parameters.get(Constants.KEY_ROOMS), parameters.get(Constants.KEY_OCCUPANCY), discountValue);
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","percentDiscount_10"));
		paymentPage.click_couponCodeApply_Btn();
		propertyName = paymentPage.getText_propertyName_Lbl().split("\n")[0];	
		propertyId=paymentPage.getPropertyId_ByItsName(propertyName);
		todayDate = LocalDate.now().toString();
		nextDate = LocalDate.now().plusDays(Integer.parseInt(checkOutDateAfter)).toString();
		propertyFinalValue = Double.parseDouble(paymentPage.getText_finalAmount_Lbl());
		Assert.assertEquals(propertyFinalValue, fromAPI.getFinalGrandTotal(),
				"When the fixed coupon is applied the final amount value is not correct !! ");
	}

	@Test(dataProvider = "DataProvider_paymentPage")
	public void TC_Validate_coupon_priceCheckForRemoveFixedCoupon(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws Exception {
		Map<String, String> parameters ;
		String propertyId="",propertyName = "",nextDate="",todayDate ="";
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		listingPage.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertTrue(generic.isVisible(ListingPage.listResults_WE), "Property is not found on the list page !!");
		generic.click(ListingPage.bookNow_FirstTuple_Lbl);
		generic.goToSleep(1000);
		parameters= listingPage.getQueryURL();
		detailspage.click_selectRooms_Btn();
		detailspage.click_roomNumber(1, NumberOfRooms);
		detailspage.click_bookNow_Btn();
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","fixedDiscount_150"));
		paymentPage.click_couponCodeApply_Btn();
		propertyName = paymentPage.getText_propertyName_Lbl().split("\n")[0];
		propertyId=paymentPage.getPropertyId_ByItsName(propertyName);
		todayDate = LocalDate.now().toString();
		nextDate = LocalDate.now().plusDays(Integer.parseInt(checkOutDateAfter)).toString();
		PriceTaxDetail fromAPI = FabLogic.getFinalPriceAndTaxWithoutCoupon(todayDate, nextDate, propertyId, parameters.get(Constants.KEY_ROOMS), parameters.get(Constants.KEY_OCCUPANCY));
		paymentPage.click_couponCodeApply_Btn();
		paymentPage.click_removeCouponCode_Lbl();
		Assert.assertEquals(Double.parseDouble(paymentPage.getText_finalAmount_Lbl()), fromAPI.getFinalGrandTotal(),
				"When the fixed coupon is removed the final amount value is not correct !! ");
	}

	@Test(dataProvider = "DataProvider_paymentPage")
	public void TC_Validate_coupon_priceCheckForRemovePercentCoupon(int rowno, String locality, String checkInDateAfter,String checkOutDateAfter, int NumberOfRooms) throws Exception {
		Map<String, String> parameters ;
		double subTotal = 0;
		String propertyId="",propertyName = "",nextDate="",todayDate ="";
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		listingPage.performSearch(locality,GenericFunctions.getDateAfterDays(checkInDateAfter),GenericFunctions.getDateAfterDays(checkOutDateAfter), "2");
		Assert.assertTrue(generic.isVisible(ListingPage.listResults_WE), "Property is not found on the list page !!");
		generic.click(ListingPage.bookNow_FirstTuple_Lbl);
		generic.goToSleep(1000);
		parameters= listingPage.getQueryURL();
		detailspage.click_selectRooms_Btn();
		detailspage.click_roomNumber(1, NumberOfRooms);
		detailspage.click_bookNow_Btn();
		subTotal = Double.parseDouble(paymentPage.getText_subTotal_Lbl());
		Double discount = subTotal * (10 / 100f);
		Integer discountInt = discount.intValue();
		Double discountValue = discountInt.doubleValue();
		propertyName = paymentPage.getText_propertyName_Lbl().split("\n")[0];
		paymentPage.sendKeys_coupon_applyCouponTextBtn(PaymentPage.couponApplyFillBox_Txt,paymentPage.getSheetTxt_ByType(CoupnSheet,"couponType","percentDiscount_10"));
		propertyId=paymentPage.getPropertyId_ByItsName(propertyName);
		todayDate = LocalDate.now().toString();
		nextDate = LocalDate.now().plusDays(Integer.parseInt(checkOutDateAfter)).toString();
		PriceTaxDetail fromAPI = FabLogic.getFinalPriceAndTaxWithCoupon(todayDate, nextDate, propertyId, parameters.get(Constants.KEY_ROOMS), parameters.get(Constants.KEY_OCCUPANCY), discountValue);
		paymentPage.click_couponCodeApply_Btn();
		paymentPage.click_removeCouponCode_Lbl();
		Assert.assertEquals(Double.parseDouble(paymentPage.getText_finalAmount_Lbl()), fromAPI.getFinalGrandTotal(),
				"When the percent coupon is removed the final amount value is not correct !! ");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}