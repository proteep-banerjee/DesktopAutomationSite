package com.fabhotels.desktopsite.testsuite.listingpage;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.desktopsite.pageobjects.Calendar;
import com.fabhotels.desktopsite.pageobjects.ListingPage;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_ListingPage extends Config {

	ListingPage listingPage;
	SoftAssert s_assert;
	String soldOut_HotelName="FabHotel BikaHua";
	String soldOut_someRooms="FabHotel Some Rooms Sold Out";

	@BeforeTest
	public void beforeTest() {
		generic = new GenericFunctions(driver);
		driver = generic.startDriver(Driver_Type);
		listingPage = new ListingPage(driver, generic);
		s_assert = new SoftAssert();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.manage().deleteAllCookies();
		generic.loadURL(UrlProvider.getListingPageUrl());
		GenericFunctions.flag=false;
		generic.handlePopUPTimer(ListingPage.popCloseButton_Btn);
	}

	@Test
	public void TC_ValidateVisibility_FeatureBox_ListPage() {
		Assert.assertTrue(generic.isVisible(ListingPage.featureBox_WE), "Feature box not visible on list page !!");
	}

	@Test
	public void TC_ValidateFunctionality_Filters() {
		List<WebElement> filters = generic.findElements(ListingPage.filters_WE);
		String firstFilter = filters.get(0).getText();
		listingPage.click_Filters_WE();
		Assert.assertTrue(firstFilter.length()>1,
				"Filters not working properly !!");
	}

	@Test
	public void TC_CheckTotal_HotelCount_List() {
		listingPage.check_Hotels_count();
	}

	@Test
	public void TC_CheckRackPrice_List() {
		listingPage.compare_Rack_Price();
	}

	@Test
	public void TC_Three_hotels_links() {
		listingPage.check_All_Hotel_links();
	}

	@Test
	public void TC_Review_listPage() {
		listingPage.check_review();
	}

	@Test
	public void TC_CityDropdown_listPage() {
		listingPage.all_Cities_names();
	}

	@Test
	public void TC_ImageandLandmark_listPage() {
		listingPage.check_ImageAndLandmark();
	}

	@Test
	public void TC_HotelInfoContainer_listPage() throws ParseException {
		Calendar cal = new Calendar(driver, generic);
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE(GenericFunctions.getDateAfterDays("0"),GenericFunctions.getDateAfterDays("2"));
		listingPage.selectRooms();
		List<WebElement> list = generic.findElements(ListingPage.filters_WE);
		for (WebElement temp : list) {
			Assert.assertTrue(temp.isDisplayed(), " Locality button is not displayed !!");
			Assert.assertTrue(temp.isEnabled(), " Locality button is not enabled !!");
		}
	}

	@Test
	public void TC_NearByHotels_listPage() {
		listingPage.performSearch(ListingPage.locality_name,GenericFunctions.getDateAfterDays("0"),GenericFunctions.getDateAfterDays("2"), "4");
		Assert.assertTrue(generic.isVisible(ListingPage.searchResultContainer_WE),
				"Search results not visible on performing Search !!");
		Assert.assertTrue(generic.getText(ListingPage.resultsCountText_Lbl).contains(ListingPage.locality_name),
				"Search results not Appropriate on ListPage !!");
		listingPage.verifyNearByPropertyOnListPage();
	}

	@Test
	public void TC_SearchBox_listPage() {
		listingPage.performSearch("",GenericFunctions.getDateAfterDays("0"),GenericFunctions.getDateAfterDays("2"), "1");
		listingPage.assertSearchError();
	}

	@Test
	public void TC_checkURL_listPage() {
		listingPage.performSearch(ListingPage.locality_name,GenericFunctions.getDateAfterDays("0"),GenericFunctions.getDateAfterDays("1"), "4");
		Assert.assertTrue(generic.isVisible(ListingPage.searchResultContainer_WE),
				"Search results not visible on performing Search !!");
		Assert.assertTrue(generic.getText(ListingPage.resultsCountText_Lbl).contains(ListingPage.locality_name),
				"Search results not Appropriate on ListPage !!");
		listingPage.detailsPageLanding_VerifyWithDateAndRooms();
		listingPage.checkURL("4");
	}
		
	@Test
	public void TC_No_Hotelsfound_listPage() {
		generic.loadURL(UrlProvider.getHomePageUrl());
		listingPage.performSearch("*", "", "", "");
		listingPage.No_Hotelsfound();
	}

	@Test
	public void TC_DetailsPageLanding_Dates_listPage() {
		listingPage.performSearch(ListingPage.locality_name, "", "", "4");
		Assert.assertTrue(generic.isVisible(ListingPage.searchResultContainer_WE),
				"Search results not visible on performing Search !!");
		Assert.assertTrue(generic.getText(ListingPage.resultsCountText_Lbl).contains(ListingPage.locality_name),
				"Search results not Appropriate on ListPage !!");
		listingPage.detailsPageLanding_VerifyWithDateAndRooms();
	}

	@Test
	public void TC_DetailsPageLanding_DateLess_listPage() {
		listingPage.performSearch("Bangalore", "", "", "");
		Assert.assertTrue(generic.isVisible(ListingPage.searchResultContainer_WE),
				"Search results not visible on performing Search !!");
		listingPage.detailsPageLanding_VerifyWithDateLess();
	}
	
	@Test
	public void TC_ListPage_SoldOut_listPage() throws ParseException {
		listingPage.performSearch("New Delhi", GenericFunctions.getDateAfterDays("0"),
				GenericFunctions.getDateAfterDays("5"), "1");
		generic.loadURL(UrlProvider.getGothamListPageUrl());
		generic.scrollToElement(ListingPage.lastSoldOut_btn, false);
		s_assert.assertEquals(generic.getText(ListingPage.soldOut_Lbl), "SOLD OUT");
		s_assert.assertEquals(generic.getText(ListingPage.lastHotelName_WE), soldOut_HotelName);
		s_assert.assertEquals(generic.getText(ListingPage.lastSoldOut_btn), "SOLD OUT");
		s_assert.assertAll();
	}
	
	@Test
	public void TC_DetailsPageLanding_SoldOut_listPage() throws ParseException {
		listingPage.performSearch("New Delhi", GenericFunctions.getDateAfterDays("0"),
				GenericFunctions.getDateAfterDays("1"), "2");
		generic.loadURL(UrlProvider.getGothamListPageUrl());
		generic.scrollToElement(ListingPage.lastSoldOut_btn, false);
		String price_ListPage = generic
				.getText(ListingPage.lastHotelPrice_WE)
				.replaceAll("[^0-9.]", "");
		//Click on sold out button from list page.
		generic.click(ListingPage.lastSoldOut_btn);
		generic.waitForCompletePageLoad(driver);
		String hotelName_DetailsPage = generic.getText(ListingPage.hotelName_Lbl);
		String price_DetailsPage = generic.getText(ListingPage.price_Lbl).replaceAll("[^0-9.]", "");
		// Asserting Detail Page UI
		s_assert.assertEquals(generic.getText(ListingPage.soldOutAlertBox_Lbl),ListingPage.soldOut_Msg,"Sold out error message is not comming on details page.");
		s_assert.assertTrue(generic.isVisible(ListingPage.selectRooms_Btn),
				"Select Rooms button is not present on landing From list Page to detail page.");
		s_assert.assertEquals(hotelName_DetailsPage, soldOut_HotelName,
				"Hotels Names are not matching on details and list page");
		s_assert.assertEquals(price_DetailsPage, price_ListPage,"Hotels Prices are not matching on details and list page for Hotel: "+soldOut_HotelName);	
		// Asserting url param
		Map<String, String> parametersDetails = listingPage.getQueryURL();
		String cityName_DetailsPage = parametersDetails.get("locationsearch");
		s_assert.assertEquals(cityName_DetailsPage, "Gotham","city names are different on list page and detials page for sold out hotel.");
		s_assert.assertTrue(parametersDetails.get("rooms").contains("2"),
				"provided rooms are not reflected in url of sold out hotel details page.");
		s_assert.assertEquals(generic.getSize(ListingPage.disabledRooms_Btn),18,"All rooms are not disabled for sold out property.");
		// Navigating Back
		generic.navigateToPreviousPage();
		s_assert.assertAll();
	}
	
	@Test
	public void TC_DetailsPageLanding_SomeRoomLeft_listPage() throws ParseException {
		listingPage.performSearch("New Delhi", GenericFunctions.getDateAfterDays("0"),
				GenericFunctions.getDateAfterDays("5"), "5");
		generic.loadURL(UrlProvider.getGothamListPageUrl());
		generic.scrollToElement(ListingPage.someRoomLeft_WE, false);
		s_assert.assertEquals(generic.getText(ListingPage.roomLeftLbl),"3 ROOMS LEFT","proper room left warning is not comming on List page.");
		generic.findElement(ListingPage.roomLeftBookNow_btn).click();
		s_assert.assertEquals(generic.getText(ListingPage.roomSoldOutAlertBox_Lbl),ListingPage.soldOutByRooms_Msg,"Rooms are not available error message is not comming on details page.");
		generic.waitForCompletePageLoad(driver);
		s_assert.assertTrue(listingPage.isDisabled_roomNumber(2, 0), "Room 2 is Enabled");
		s_assert.assertTrue(listingPage.isDisabled_roomNumber(2, 5), "Room 2 is Enabled");
		s_assert.assertTrue(listingPage.isSoldOut_roomType(4), "Sold Out Lablel is not displayed.");
		s_assert.assertTrue(listingPage.isDisabled_roomNumber(4, 0), "Room 2 is Enabled");
		s_assert.assertTrue(listingPage.isDisabled_roomNumber(4, 5), "Room 2 is Enabled");
		s_assert.assertEquals(listingPage.getText_roomsLeft_roomType(1), "2 ROOMS LEFT");
		s_assert.assertEquals(listingPage.getText_roomsLeft_roomType(3), "1 ROOM LEFT");
		s_assert.assertTrue(listingPage.isDisabled_roomNumber(1, 0), "Room 2 is Enabled");
		s_assert.assertTrue(listingPage.isDisabled_roomNumber(1, 4), "Room 2 is Enabled");
		s_assert.assertTrue(listingPage.isEnabled_roomNumber(1, 3), "Room 2 is Enabled");
		s_assert.assertTrue(listingPage.isDisabled_roomNumber(3, 0), "Room 2 is Enabled");
		s_assert.assertTrue(listingPage.isDisabled_roomNumber(3, 2), "Room 2 is Enabled");
		s_assert.assertTrue(listingPage.isEnabled_roomNumber(3, 1), "Room 2 is Enabled");
		s_assert.assertAll();	
	}
	
	@AfterMethod
	public void afterMethod() {
		GenericFunctions.flag=true;
	}

	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}