package com.fabhotels.desktopsite.testsuite.listingpage;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.core.CustomAssert;
import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.desktopsite.pageobjects.Calendar;
import com.fabhotels.desktopsite.pageobjects.DetailPage;
import com.fabhotels.desktopsite.pageobjects.Header;
import com.fabhotels.desktopsite.pageobjects.ListingPage;
import com.fabhotels.desktopsite.pageobjects.SearchBar;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.Constants;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_ListingPage extends Config {

	Header header;
	ListingPage listingPage;
	DetailPage detailPage;
	Calendar cal;
	SearchBar searchBar;
	String soldOut_HotelName = "FabHotel BikaHua";
	String soldOut_someRooms = "FabHotel Some Rooms Sold Out";
	int totalCities = 23;

	@BeforeTest
	public void beforeTest() {
		generic = new GenericFunctions(driver);
		driver = generic.startDriver(Driver_Type);
		listingPage = new ListingPage(driver, generic);
		cal = new Calendar(driver, generic);
		header = new Header(driver, generic);
		searchBar = new SearchBar(driver, generic);
		detailPage = new DetailPage(driver, generic);
	}

	@BeforeMethod(firstTimeOnly = true)
	public void beforeMethod() {
		driver.manage().deleteAllCookies();
	}

	@Test
	public void TC_ListPage_001_ValidateVisibility_FeatureBox() {
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl());
		Assert.assertTrue(generic.isVisible(ListingPage.featureBox_WE), "Feature box not visible on list page !!");
	}

	@Test
	public void TC_ListPage_002_ValidateVisibility_Filters() {
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl());
		List<WebElement> filters = generic.findElements(ListingPage.filters_WE);
		Assert.assertTrue(filters.size() > 1, "No of Filters less than equal to 1  !!");
		listingPage.click_FirstFilter_WE();
		Assert.assertTrue(generic.isVisible(ListingPage.searchResultContainer_WE),
				"No Results After Clicking Filter !!");
	}

	@DataProvider(name = "DataProvider_Cities")
	public Object[][] DataProvider_Cities() {
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl());

		Object result[][] = new Object[3][2];
		List<WebElement> we = header.getWebElements_AllCities_DD();

		int ranNo = generic.getRandomNumberBetween(1, we.size());
		result[0][0] = ranNo;
		result[0][1] = we.get(ranNo).getText();

		ranNo = generic.getRandomNumberBetween(1, we.size());
		result[1][0] = ranNo;
		result[1][1] = we.get(ranNo).getText();

		ranNo = generic.getRandomNumberBetween(1, we.size());
		result[2][0] = ranNo;
		result[2][1] = we.get(ranNo).getText();

		return result;

	}

	@Test(dataProvider = "DataProvider_Cities")
	public void TC_ListPage_003_Validate_HotelResultsCount(int no, String cityName) {
		header.click_CityNo_Header_WE(no);
		int countDisplayed = Integer.parseInt(listingPage.getText_NoofHotelFound());
		Assert.assertEquals(listingPage.getSize_hotelList_WE(), countDisplayed,
				"Number of Hotels displayed is incorrect for City = " + cityName);
	}

	@Test
	public void TC_ListPage_004_Validate_Visibility_RackPrice() {
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl());
		Assert.assertTrue(generic.findElements(ListingPage.rackPrice_WE).size() > 0, "Rack prices not Visible !!");
	}

	@Test(dataProvider = "DataProvider_Cities", dependsOnMethods = { "TC_ListPage_004_Validate_Visibility_RackPrice" })
	public void TC_ListPage_005_CheckRackPrice(int No, String cityName) {
		CustomAssert customAssert = new CustomAssert();
		header.click_CityNo_Header_WE(No);

		List<WebElement> tuples = generic.findElements(ListingPage.allProperties_WE);
		for (WebElement webElement : tuples) {
			if (webElement.findElements(ListingPage.rackPrice_WE).size() > 0) {
				String hotelName = webElement.findElement(By.xpath("//h3/a")).getText();
				int rac_value = Integer.parseInt(listingPage.getText_RackPrice_WE(webElement));
				int pri_value = Integer.parseInt(listingPage.getText_SellingPrice_WE(webElement));
				customAssert.assertTrue(rac_value > pri_value, "Price is greator than Rack Price !! under city :"
						+ hotelName + " Rack price is :" + rac_value + " And offered price is :" + pri_value);
			}
		}
		customAssert.assertAll();
	}

	@Test
	public void TC_ListPage_006_Validate_Clickablity_AllLinks_hotelTuples() {
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl());
		CustomAssert customAssert = new CustomAssert();
		DetailPage detailPage = new DetailPage(driver, generic);
		String hotelName = listingPage.getText_HotelName_FirstTuple_Lbl();

		listingPage.click_HotelName_FirstTuple_Lbl();
		customAssert.assertEquals(detailPage.getLabelText_hotelName_Lbl(), hotelName,
				"Hotel Name link is disabled from list page !! ");

		driver.navigate().back();
		listingPage.click_HotelImage_FirstTuple_WE();
		customAssert.assertEquals(detailPage.getLabelText_hotelName_Lbl(), hotelName,
				"Hotel Pic link is disabled from  list page !! ");

		driver.navigate().back();
		listingPage.click_BookNow_FirstTuple_Btn();
		customAssert.assertEquals(detailPage.getLabelText_hotelName_Lbl(), hotelName,
				"Book Now button is disabled from list page !!");

		customAssert.assertAll();

	}

	@Test
	public void TC_ListPage_007_Validate_Functionality_ReviewsModal() {
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl());
		listingPage.click_ReviewsCount_FirstTuple_WE();
		Assert.assertTrue(generic.isVisible(ListingPage.reviewsModalDialogue_WE),
				"Review box not visible on list page !!");
		listingPage.click_Review_close_Btn();
		Assert.assertTrue(!generic.isVisible(ListingPage.review_close_Btn),
				"Reviews Modal is not closing on clicking cross button !!");
	}

	@Test(dataProvider = "DataProvider_Cities")
	public void TC_ListPage_008_Validate_visibility_ImageLandmark_LastBooked(int no, String cityName) {
		CustomAssert customAssert = new CustomAssert();
		int ranHotel = generic.getRandomNumberBetween(1, listingPage.getTotalTupleCount_ListPage());
		String imgsrc = listingPage.getImagePath_Tuple(ranHotel);
		String hotelImageName = imgsrc.split("/")[imgsrc.split("/").length - 1];

		customAssert.assertNotEquals(hotelImageName, ListingPage.defaultHotelImage_name,
				"Under city " + cityName + " , Hotel image is not comming proper !!");
		customAssert.assertTrue(listingPage.getLandmark_Tuple(no).length() > 16,
				"Under city " + cityName + ", Landmark is not comming !!");
		customAssert.assertTrue(listingPage.getLastBookedText_Tuple(no).contains("people looking"),
				"Under city " + cityName + " , people looking label is not comming !!");
		customAssert.assertTrue(listingPage.getLastBookedText_Tuple(no).contains("Last booked"),
				"Under city " + cityName + " , last booked label is not comming !!");

		customAssert.assertAll();
	}

	@Test
	public void TC_ListPage_009_DetailsPageLanding_withDates() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		String rooms = "4";
		searchBar.performSearch(Constants.LOCALITY_NAME, "", "", rooms);
		Assert.assertTrue(generic.isVisible(ListingPage.searchResultContainer_WE),
				"Search results not visible on performing Search !!");
		Assert.assertTrue(generic.getText(ListingPage.resultsCountText_Lbl).contains(Constants.LOCALITY_NAME),
				"Search results not Appropriate on ListPage !!");

		CustomAssert customAssert = new CustomAssert();
		String date_ListPage = searchBar.getElementText_checkIn_Date_WE();
		String price_ListPage = listingPage.getText_SellingPrice_FirstTuple_WE();
		String hotelName_ListPage = listingPage.getText_HotelName_FirstTuple_Lbl();
		Map<String, String> parametersListPage = searchBar.getParameters_URL();
		String cityName_ListPage = parametersListPage.get(Constants.KEY_LOCATIONSEARCH);

		customAssert.assertTrue(parametersListPage.get(Constants.KEY_ROOMS).contains(rooms),
				"Rooms parameters are not matching on List Page's URL.");
		listingPage.click_BookNow_FirstTuple_Btn();

		String date_DetailsPage = searchBar.getElementText_checkIn_Date_WE();
		String hotelName_DetailsPage = detailPage.getLabelText_hotelName_Lbl();
		String price_DetailsPage = detailPage.getLabelText_price_Lbl();

		customAssert.assertEquals(hotelName_DetailsPage, hotelName_ListPage);
		customAssert.assertEquals(date_ListPage, date_DetailsPage);
		customAssert.assertEquals(price_DetailsPage, price_ListPage);

		Map<String, String> parametersDetails = searchBar.getParameters_URL();
		String cityName_DetailsPage = parametersListPage.get(Constants.KEY_LOCATIONSEARCH);

		customAssert.assertTrue(generic.isVisible(DetailPage.selectRooms_Btn),
				"Select Rooms button is not present on landing From list Page to detail page.");
		customAssert.assertEquals(cityName_DetailsPage, cityName_ListPage);
		customAssert.assertTrue(parametersDetails.get("rooms").contains("4"),
				"Rooms parameters are not matching in Details Page's URL.");
		customAssert.assertAll();

	}

	@Test
	public void TC_ListPage_010_DetailsPageLanding_DateLess() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		CustomAssert customAssert = new CustomAssert();
		searchBar.performSearch("Bangalore", "", "", "");
		Assert.assertTrue(generic.isVisible(ListingPage.searchResultContainer_WE),
				"Search results not visible on performing Search !!");

		String price_ListPage = listingPage.getText_SellingPrice_FirstTuple_WE();
		String hotelName_ListPage = listingPage.getText_HotelName_FirstTuple_Lbl();
		Map<String, String> parametersListPage = searchBar.getParameters_URL();
		String cityName_ListPage = parametersListPage.get(Constants.KEY_LOCATIONSEARCH);

		customAssert.assertTrue(parametersListPage.get(Constants.KEY_ROOMS).contains("1"),
				"rooms parameter is not 1 with dateless case on List Page's URL.");
		customAssert.assertTrue(parametersListPage.get("checkIn").equals(""),
				"checkIn date is not empty on List Page's URL.");

		listingPage.click_BookNow_FirstTuple_Btn();
		String hotelName_DetailsPage = detailPage.getLabelText_hotelName_Lbl();
		String price_DetailsPage = detailPage.getLabelText_price_Lbl();

		customAssert.assertEquals(hotelName_DetailsPage, hotelName_ListPage,
				"Hotels Names are not matching on details and list page");
		customAssert.assertEquals(price_DetailsPage, price_ListPage,
				"Hotels Prices are not matching on details and list page for Hotel: " + hotelName_ListPage);

		Map<String, String> parametersDetails = searchBar.getParameters_URL();
		String cityName_DetailsPage = parametersListPage.get("locationsearch");

		customAssert.assertTrue(generic.isVisible(DetailPage.selectRooms_Btn),
				"Select Rooms button is not present on landing From list Page to detail page.");
		customAssert.assertEquals(cityName_DetailsPage, cityName_ListPage);
		customAssert.assertTrue(parametersDetails.get("rooms").contains("1"),
				"rooms parameter is not 1 with dateless case on Details Page's URL.");
		customAssert.assertAll();
	}

	@Test
	public void TC_ListPage_011_Validate_SoldOutProperty() {
		CustomAssert customAssert = new CustomAssert();
		generic.loadURL_HandlePopup(UrlProvider.getGothamListPageUrl());
		String checkIn = GenericFunctions.getDateAfterDays("0");
		String checkOut = GenericFunctions.getDateAfterDays("5");
		String rooms = "1";
		searchBar.performSearch("New Delhi", checkIn, checkOut, rooms);
		customAssert.assertEquals(generic.getText(ListingPage.soldOut_Lbl), "SOLD OUT");
		customAssert.assertEquals(generic.getText(ListingPage.lastHotelName_WE), soldOut_HotelName);
		customAssert.assertEquals(generic.getText(ListingPage.lastSoldOut_btn), "SOLD OUT");
		customAssert.assertAll();
	}

	@Test
	public void TC_ListPage_012_Validate_DetailsPageLanding_SoldOutCase() {
		CustomAssert customAssert = new CustomAssert();
		generic.loadURL_HandlePopup(UrlProvider.getGothamListPageUrl());
		String checkIn = GenericFunctions.getDateAfterDays("0");
		String checkOut = GenericFunctions.getDateAfterDays("1");
		String rooms = "2";
		String cityName = "Gotham";
		searchBar.performSearch("", checkIn, checkOut, rooms);
		String price_ListPage = listingPage.getText_LastHotelPrice_WE();
		listingPage.click_LastSoldOut_btn();
		String hotelName_DetailsPage = detailPage.getLabelText_hotelName_Lbl();
		String price_DetailsPage = detailPage.getLabelText_price_Lbl();

		customAssert.assertEquals(listingPage.getText_SoldOutAlertBox_Lbl(), Constants.SOLDOUT_MSG_DETAILSPAGE,
				"Sold out error message is not comming on details page.");
		customAssert.assertTrue(generic.isVisible(ListingPage.selectRooms_Btn),
				"Select Rooms button is not present on landing From list Page to detail page.");
		customAssert.assertEquals(hotelName_DetailsPage, soldOut_HotelName,
				"Hotels Names are not matching on details and list page");
		customAssert.assertEquals(price_DetailsPage, price_ListPage,
				"Hotels Prices are not matching on details and list page for Hotel: " + soldOut_HotelName);
		Map<String, String> parametersDetails = searchBar.getParameters_URL();
		String cityName_DetailsPage = parametersDetails.get(Constants.KEY_LOCATIONSEARCH);
		customAssert.assertEquals(cityName_DetailsPage, cityName,
				"city names are different on list page and detials page for sold out hotel.");
		customAssert.assertTrue(parametersDetails.get(Constants.KEY_ROOMS).contains(rooms),
				"provided rooms are not reflected in url of sold out hotel details page.");
		customAssert.assertEquals(listingPage.getSize_DisabledRooms_Btn(), 18,
				"All rooms are not disabled for sold out property.");
		customAssert.assertAll();
	}

	@Test
	public void TC_ListPage_013_DetailsPageLanding_SomeRoomLeftCase() {
		CustomAssert customAssert = new CustomAssert();
		generic.loadURL_HandlePopup(UrlProvider.getGothamListPageUrl());
		String checkIn = GenericFunctions.getDateAfterDays("0");
		String checkOut = GenericFunctions.getDateAfterDays("5");
		String rooms = "5";
		searchBar.performSearch("", checkIn, checkOut, rooms);
		customAssert.assertEquals(listingPage.getText_RoomLeft_Lbl(), "3 ROOMS LEFT",
				"Proper room left warning is not comming on List page !!");
		generic.click(ListingPage.roomLeftBookNow_btn);
		customAssert.assertEquals(listingPage.getText_RoomSoldOutAlertBox_Lbl(),
				Constants.SOLDOUT_MSG_ROOMS_DETAILSPAGE,
				"Rooms are not available error message is not comming on details page.");
		customAssert.assertTrue(listingPage.isDisabled_roomNumber(2, 0), "Room 2 is Enabled");
		customAssert.assertTrue(listingPage.isDisabled_roomNumber(2, 5), "Room 2 is Enabled");
		customAssert.assertTrue(listingPage.isSoldOut_roomType(4), "Sold Out Lablel is not displayed.");
		customAssert.assertTrue(listingPage.isDisabled_roomNumber(4, 0), "Room 2 is Enabled");
		customAssert.assertTrue(listingPage.isDisabled_roomNumber(4, 5), "Room 2 is Enabled");
		customAssert.assertEquals(listingPage.getText_roomsLeft_roomType(1), "2 ROOMS LEFT");
		customAssert.assertEquals(listingPage.getText_roomsLeft_roomType(3), "1 ROOM LEFT");
		customAssert.assertTrue(listingPage.isDisabled_roomNumber(1, 0), "Room 2 is Enabled");
		customAssert.assertTrue(listingPage.isDisabled_roomNumber(1, 4), "Room 2 is Enabled");
		customAssert.assertTrue(listingPage.isEnabled_roomNumber(1, 3), "Room 2 is Enabled");
		customAssert.assertTrue(listingPage.isDisabled_roomNumber(3, 0), "Room 2 is Enabled");
		customAssert.assertTrue(listingPage.isDisabled_roomNumber(3, 2), "Room 2 is Enabled");
		customAssert.assertTrue(listingPage.isEnabled_roomNumber(3, 1), "Room 2 is Enabled");
		customAssert.assertAll();
	}

	/*
	 * @Test public void TC_ListPage_009_NearByHotels_listPage() {
	 * generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl()); String
	 * checkIn = GenericFunctions.getDateAfterDays("0"); String checkOut =
	 * GenericFunctions.getDateAfterDays("1"); String rooms = "4";
	 * searchBar.performSearch(Constants.LOCALITY_NAME, checkIn, checkOut,
	 * rooms);
	 * Assert.assertTrue(generic.isVisible(ListingPage.searchResultContainer_WE)
	 * , "Search results not visible on performing Search !!");
	 * Assert.assertTrue(generic.getText(ListingPage.resultsCountText_Lbl).
	 * contains(ListingPage.locality_name),
	 * "Search results not Appropriate on ListPage !!"); SoftAssert s_assert =
	 * new SoftAssert(); int i = 1; generic.goToSleep(1000);
	 * generic.scrollToElement(nearByProperty_nav, false);
	 * Assert.assertTrue(generic.isVisible("(" + nearByHotelName_lbl + ")" + "["
	 * + i + "]"), "Near By Property is Not Coming!!!.");
	 * generic.goToSleep(2000); while
	 * (!driver.findElement(lastHotelNearBy_WE).isDisplayed()) { if
	 * (driver.findElement(By.xpath("(" + nearByHotelName_lbl + ")" + "[" + i +
	 * "]")).isDisplayed()) { String hotelName = generic.getText("(" +
	 * nearByHotelName_lbl + ")" + "[" + i + "]"); System.out.println(i +
	 * ". Hotel ," + hotelName); s_assert.assertTrue(generic.isVisible("(" +
	 * totalNearByProperty_WE + ")" + "[" + i + "]"),
	 * "0 Near By Hotels are comming"); s_assert.assertTrue( generic.isVisible(
	 * "(" + totalNearByProperty_WE + ")" + "[" + i + "]" +
	 * "//span[@class='new-price']"), "Price is not comming for :" + hotelName);
	 * 
	 * s_assert.assertTrue(generic.isVisible("(" + nearByBook_btn + ")" + "[" +
	 * i + "]"), "'Book Now' or 'Sold Out' button is not coming for :" +
	 * hotelName);
	 * 
	 * s_assert.assertTrue(generic.isVisible("(" + nearByHotelName_lbl + ")" +
	 * "[" + i + "]"), "Hotel Name is not coming for :" + hotelName);
	 * 
	 * s_assert.assertTrue(generic.isVisible("(" + nearByHotelReview_lbl + ")" +
	 * "[" + i + "]"), "Hotel review is not coming for :" + hotelName);
	 * 
	 * String imgSrc = generic.getAttributeValue(By.xpath("(" +
	 * nearByHotelImg_img + ")" + "[" + i + "]"), "src"); String imageName =
	 * imgSrc.split("/")[imgSrc.split("/").length - 1];
	 * s_assert.assertNotEquals(imageName, "mainMedium.png",
	 * "Main images are not comming for :" + hotelName); i++; } else {
	 * generic.click(nearByProperty_nav); } }
	 * s_assert.assertTrue(driver.findElement(footer_stayUpdated).isDisplayed(),
	 * "On Footer stay updated is not comming."); // Clicking on last nearby
	 * hotel book button String lastNearByHotelName = generic.getText("(" +
	 * nearByHotelName_lbl + ")" + "[" + i + "]"); generic.click("(" +
	 * nearByBook_btn + ")" + "[" + i + "]"); String hotelName_DetailsPage = ""
	 * ; generic.goToSleep(2000); s_assert.assertEquals(hotelName_DetailsPage,
	 * lastNearByHotelName,
	 * "Navigating from near by property hotel to Details page is failing...");
	 * s_assert.assertAll(); }
	 */

	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}