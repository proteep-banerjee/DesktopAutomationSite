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
import org.testng.asserts.SoftAssert;

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
		int hotelList_BeforeFilter = listingPage.getSize_hotelList_WE();
		filters.get(0).click();
		generic.goToSleep(1000);
		int hotelList_AfterFilter = listingPage.getSize_hotelList_WE();
		Assert.assertNotEquals(hotelList_AfterFilter, hotelList_BeforeFilter,"Results do not change after applying filter !!");
	}

	@DataProvider(name = "DataProvider_Cities")
	public Object[][] DataProvider_Cities() {
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl());

		Object result[][] = new Object[4][2];
		List<WebElement> we = header.getWebElements_AllCities_DD();

		int ranNo = generic.getRandomNumberBetween(1, header.getCount_MainLocaity_WE()-1);
		result[0][0] = ranNo;
		result[0][1] = we.get(ranNo).getText();

		ranNo = generic.getRandomNumberBetween(1, header.getCount_MainLocaity_WE()-1);
		result[1][0] = ranNo;
		result[1][1] = we.get(ranNo).getText();

		ranNo = generic.getRandomNumberBetween(1, header.getCount_MainLocaity_WE()-1);
		result[2][0] = ranNo;
		result[2][1] = we.get(ranNo).getText();

		ranNo = generic.getRandomNumberBetween(1, header.getCount_MainLocaity_WE()-1);
		result[3][0] = ranNo;
		result[3][1] = we.get(ranNo).getText();
		
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
		Assert.assertTrue(generic.isVisible(ListingPage.rackPrice_WE), "Rack prices not Visible !!");
	}

	@Test(dataProvider = "DataProvider_Cities")
	public void TC_ListPage_005_CheckRackPrice(int No, String cityName) {
		CustomAssert customAssert = new CustomAssert();
		header.click_CityNo_Header_WE(No);
		List<WebElement> tuples = generic.findElements(ListingPage.allProperties_WE);
		Assert.assertTrue(generic.isVisible(ListingPage.rackPrice_WE), "Rack prices not Visible !!");
		for (WebElement webElement : tuples) {
			if (webElement.findElements(ListingPage.rackPrice_WE).size() > 0) {
				String hotelName = webElement.findElement(By.xpath("//h3/a")).getText();
				int rac_value = Integer.parseInt(listingPage.getText_RackPrice_WE(webElement));
				int pri_value = Integer.parseInt(listingPage.getText_SellingPrice_WE(webElement));
				customAssert.assertTrue(rac_value > pri_value, "Price is greator than Rack Price !! under city :"
						+ hotelName + " Rack price is :" + rac_value + " And offered price is :" + pri_value);
			}
			else {
				Assert.assertTrue(false, "Rack prices not Visible !!");
			}
		}
		customAssert.assertAll();
	}

	@Test
	public void TC_ListPage_006_Validate_Clickablity_AllLinks_hotelTuple() {
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
		CustomAssert customAssert = new CustomAssert();
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl());
		listingPage.click_ReviewsCount_FirstTuple_WE();
		Assert.assertTrue(generic.isVisible(ListingPage.reviewsModalDialogue_WE),"Review box not visible on list page !!");
		customAssert.assertEquals(listingPage.getCount_allTuples_ReviewsModal_WE(), 20,"Default listing reviews count is not 20 !!");
		generic.scrollToElement(ListingPage.loadMoreReviews_ReviewsModal_Lnk, false);
		customAssert.assertEquals(generic.getText(ListingPage.loadMoreReviews_ReviewsModal_Lnk), Constants.REVIEWBOX_LOADMORE," Load more reviews Link is appropriate !!");
		generic.click(ListingPage.loadMoreReviews_ReviewsModal_Lnk);
		generic.goToSleep(1000);
		customAssert.assertEquals(listingPage.getCount_allTuples_ReviewsModal_WE(), 40,"Load more reviews button is broken, it is not loading other reviews.");
		listingPage.click_Review_close_Btn();
		generic.goToSleep(1000);
		Assert.assertTrue(!generic.isVisible(ListingPage.review_close_Btn),"Reviews Modal is not closing on clicking cross button !!");
	}

	@Test(dataProvider = "DataProvider_Cities")
	public void TC_ListPage_008_Validate_visibility_ImageLandmark_LastBooked(int no, String cityName) {
		CustomAssert customAssert = new CustomAssert();
		header.click_CityNo_Header_WE(no);
		generic.pageScrollToBottomInSlowMotion();
		int ranHotel = generic.getRandomNumberBetween(1, listingPage.getTotalTupleCount_ListPage());
		String imgsrc = listingPage.getImagePath_Tuple(ranHotel);
		String hotelImageName = imgsrc.split("/")[imgsrc.split("/").length - 1];

		customAssert.assertNotEquals(hotelImageName, ListingPage.defaultHotelImage_name,
				"Under city " + cityName + " , Hotel image is not comming proper !!");
		customAssert.assertTrue(listingPage.getLandmark_Tuple(ranHotel).length() > 16,
				"Under city " + cityName + ", Landmark is not comming !!");
		customAssert.assertTrue(listingPage.getLastBookedText_Tuple(ranHotel).contains("people looking"),
				"Under city " + cityName + " , people looking label is not comming !!");
		customAssert.assertTrue(listingPage.getLastBookedText_Tuple(ranHotel).contains("Last booked"),
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
		searchBar.performSearch("", checkIn, checkOut, rooms);
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
		String checkIn = GenericFunctions.getDateAfterDays("3");
		String checkOut = GenericFunctions.getDateAfterDays("5");
		String rooms = "5";
		searchBar.performSearch("", checkIn, checkOut, rooms);
		customAssert.assertEquals(listingPage.getText_RoomLeft_Lbl(), "4 ROOMS LEFT",
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
		customAssert.assertEquals(listingPage.getText_roomsLeft_roomType(1), "3 ROOMS LEFT");
		customAssert.assertEquals(listingPage.getText_roomsLeft_roomType(3), "1 ROOM LEFT");
		customAssert.assertTrue(listingPage.isDisabled_roomNumber(1, 0), "Room 2 is Enabled");
		customAssert.assertTrue(listingPage.isDisabled_roomNumber(1, 4), "Room 2 is Enabled");
		customAssert.assertTrue(listingPage.isEnabled_roomNumber(1, 3), "Room 2 is Enabled");
		customAssert.assertTrue(listingPage.isDisabled_roomNumber(3, 0), "Room 2 is Enabled");
		customAssert.assertTrue(listingPage.isDisabled_roomNumber(3, 2), "Room 2 is Enabled");
		customAssert.assertTrue(listingPage.isEnabled_roomNumber(3, 1), "Room 2 is Enabled");
		customAssert.assertAll();
	}

	@Test
	public void TC_ListPage_014_NearByHotels_listPage() {
		String checkIn = GenericFunctions.getDateAfterDays("0");
		String checkOut = GenericFunctions.getDateAfterDays("1");
		String exploreMoreHotel_Lbl = "Explore more hotels near " + Constants.LOCALITY_NAME;
		String rooms = "4";
		int i = 1;
		CustomAssert customAssert = new CustomAssert();
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl());
		searchBar.performSearch(Constants.LOCALITY_NAME, checkIn, checkOut, rooms);
		generic.waitForCompletePageLoad();
		Assert.assertTrue(generic.isVisible(ListingPage.searchResultContainer_WE),
				"Search results not visible on performing Search !!");
		customAssert.assertTrue(generic.getText(ListingPage.resultsCountText_Lbl).contains(Constants.LOCALITY_NAME),
				"Search results not Appropriate on ListPage !!");
		generic.scrollToElement(ListingPage.nearByPropertyNext_nav, false);
		customAssert.assertEquals(listingPage.getText_nearByHotel_Lbl(), exploreMoreHotel_Lbl,
				"Explore more lable under SRP is not appropriate.");
		customAssert.assertTrue(generic.isVisible(listingPage.get_nearByHotelName_lbl(i)),
				"Near By Property is Not Coming!!!.");
		while (!driver.findElement(ListingPage.lastHotelNearBy_WE).isDisplayed()) {
			if (driver.findElement(listingPage.get_nearByHotelName_lbl(i)).isDisplayed()) {

				String hotelName = generic.getText(listingPage.get_nearByHotelName_lbl(i));
				System.out.println(i + ". Hotel ," + hotelName);
				customAssert.assertTrue(generic.isVisible(listingPage.get_nearByTuple(i)),
						"Near By Hotels are comming under SRP of hotel");
				customAssert.assertTrue(driver.findElement(listingPage.get_nearByHotelPrice_WE(i)).isDisplayed(),
						"Price is not comming for :" + hotelName);
				customAssert.assertTrue(generic.isVisible(listingPage.get_nearByBook_btn(i)),
						"'Book Now' or 'Sold Out' button is not coming for :" + hotelName);
				customAssert.assertTrue(generic.isVisible(listingPage.get_nearByHotelName_lbl(i)),
						"Hotel Name is not coming for :" + hotelName);
				customAssert.assertTrue(generic.isVisible(listingPage.get_nearByHotelReview_lbl(i)),
						"Hotel review is not coming for :" + hotelName);
				String imgSrc = generic.getAttributeValue(listingPage.get_nearByHotelImg_img(i), "src");
				String imageName = imgSrc.split("/")[imgSrc.split("/").length - 1];
				customAssert.assertNotEquals(imageName, "mainMedium.png",
						"Main images are not comming for :" + hotelName);
				i++;
			} else {
				listingPage.click_nearByPropertyNext_nav();
			}
		}
		customAssert.assertAll();
	}
	
	@Test
	public void TC_ListPage_015_DetailsPageLanding_NearByHotels() {
		String checkIn = GenericFunctions.getDateAfterDays("0");
		String checkOut = GenericFunctions.getDateAfterDays("1");
		String rooms = "4";
		int i = 1;
		SoftAssert customAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl());
		searchBar.performSearch(Constants.LOCALITY_NAME, checkIn, checkOut, rooms);
		generic.waitForCompletePageLoad();
		Assert.assertTrue(generic.isVisible(ListingPage.searchResultContainer_WE),
				"Search results not visible on performing Search !!");
		customAssert.assertTrue(generic.getText(ListingPage.resultsCountText_Lbl).contains(Constants.LOCALITY_NAME),
				"Search results not Appropriate on ListPage !!");
		generic.scrollToElement(ListingPage.nearByPropertyNext_nav, false);
		String hotelName_NearByProperty = generic.getText(listingPage.get_nearByHotelName_lbl(i));
		System.out.println(i + ". Hotel ," + hotelName_NearByProperty);
		String price_NearByProperty=generic.getText(listingPage.get_nearByHotelPrice_WE(1)).replaceAll("[^0-9.]", "");
		String hotelButton_NearByProperty=generic.getText(listingPage.get_nearByBook_btn(i));
		String reviewCount_NearByProperty=generic.getText(listingPage.get_nearByHotelReview_lbl(i));
		String imgSrc = generic.getAttributeValue(listingPage.get_nearByHotelImg_img(i), "src");
		String imageName_NearByProperty = imgSrc.split("/")[imgSrc.split("/").length - 1];
		generic.click(listingPage.get_nearByBook_btn(i));
		generic.goToSleep(2000);
		String hotelName_DetailsPage = detailPage.getLabelText_hotelName_Lbl();
		String hotelPrice_DetailsPage = detailPage.getText_priceWithoutRupeeSymbol_Lbl();
		String reviewCount_DetailsPage = detailPage.getLinkText_reviews_Lnk();
		String imgSrcMain = generic.getAttributeValue(DetailPage.mainImage_WE, "src");
		String mainImageSrc_DetailsPage = imgSrcMain.split("/")[imgSrcMain.split("/").length - 1];
		customAssert.assertEquals(hotelName_NearByProperty,hotelName_DetailsPage,"Hotel Name is not identical on Near by Hotel and its Details Page.");
		customAssert.assertEquals(price_NearByProperty,hotelPrice_DetailsPage,"Hotel Price are not identical on Near by Hotel and its Details Page.");
		customAssert.assertEquals(hotelButton_NearByProperty,"BOOK NOW","");
		customAssert.assertEquals(reviewCount_NearByProperty,reviewCount_DetailsPage,"Review count is not identical on Near by Hotel and its Details Page.");
		customAssert.assertEquals(imageName_NearByProperty,mainImageSrc_DetailsPage,"Main image is not identical on Near by Hotel and its Details Page.");
		customAssert.assertAll();
	}

	@Test(dataProvider = "DataProvider_Cities")
	public void TC_ListPage_016_DistanceFromSearchedHotel_NearByHotels(int no, String cityName)
	{
		String checkIn = GenericFunctions.getDateAfterDays("0");
		String checkOut = GenericFunctions.getDateAfterDays("1");
		String rooms = "4";
		int i = 1;
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl(cityName.replaceAll(" ", "-")));
		String HotelName=listingPage.getText_HotelName_FirstTuple_Lbl();
		searchBar.performSearch(HotelName, checkIn, checkOut, rooms);
		generic.scrollToElement(ListingPage.nearByPropertyNext_nav, false);
		Assert.assertTrue(generic.isVisible(listingPage.get_nearByHotelName_lbl(i)),"Near By Property is Not Coming!!!.");
		while (!driver.findElement(ListingPage.lastHotelNearBy_WE).isDisplayed()) {
			if (driver.findElement(listingPage.get_nearByHotelName_lbl(i)).isDisplayed()) {
				float distanceFromSearchedHotel=listingPage.distanceFromSearchedHotel_nearByHotel_WE(i);
				Assert.assertTrue((distanceFromSearchedHotel>7)&&(distanceFromSearchedHotel<26),"Nearby hotels distance from searched hotel is not falling between 8 - 25 Km");
				i++;
			} else {
				listingPage.click_nearByPropertyNext_nav();
			}
		}
	}
	
	@Test
	public void TC_ListPage_017_LastTupleSoldOut_NearByHotels()
	{
		String checkIn = GenericFunctions.getDateAfterDays("0");
		String checkOut = GenericFunctions.getDateAfterDays("1");
		String rooms = "4";
		int i = 1;
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl());
		searchBar.performSearch(Constants.LOCALITY_NAME, checkIn, checkOut, rooms);
		generic.scrollToElement(ListingPage.nearByPropertyNext_nav, false);
		Assert.assertTrue(generic.isVisible(listingPage.get_nearByHotelName_lbl(i)),
				"Near By Property is Not Coming!!!.");
		listingPage.click_nearByPropertyPrevious_nav();
		String buttonNameLbl=generic.getText(listingPage.get_lastHotelBook_Btn());
		Assert.assertEquals(buttonNameLbl, "SOLD OUT","Last tuple of near by property is not sold out on SRP!!");
		generic.click(listingPage.get_lastHotelBook_Btn());
		generic.goToSleep(2000);
		Assert.assertEquals(listingPage.getText_SoldOutAlertBox_Lbl(), Constants.SOLDOUT_MSG_DETAILSPAGE,
				"Sold out error message is not comming on details page when selecting last tuple from nearby hotles.");
		Assert.assertTrue(detailPage.isDisabled_selectRoomsDisabled_Btn(),"Button is not disabled for sold out hotel.");
	}
	
	@Test
	public void TC_ListPage_018_Validate_ReviewsAndRatings_ListAndDetailsPage(){
		CustomAssert customAssert = new CustomAssert();
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl());
		String reviewStars_ListPage=listingPage.getWidth_starRating_WE();
		String reviewsCount_ListPage = listingPage.getElementText_reviewsCount_WE();
		listingPage.click_HotelName_FirstTuple_Lbl();
		String reviewStars_DetailsPage = detailPage.getWidth_ratingsLogo_WE();
		String reviewsCount_DetailsPage = detailPage.getLinkText_reviews_Lnk();
		customAssert.assertEquals(reviewStars_ListPage, reviewStars_DetailsPage,"Review STARS of Hotel under list page are NOT identical as on its Details Page.");
		customAssert.assertEquals(reviewsCount_ListPage, reviewsCount_DetailsPage,"Review COUNT of Hotel under list page are NOT identical as on its Details Page.");
		customAssert.assertAll();
	}
	
	@Test
	public void TC_ListPage_019_Validate_ReadMoreAndReadLess_ReviewsModal() {
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl());
		listingPage.click_ReviewsCount_FirstTuple_WE();
		Assert.assertTrue(generic.isVisible(ListingPage.reviewsModalDialogue_WE),"Review box not visible on list page !!");
		generic.click(ListingPage.loadMoreReviews_ReviewsModal_Lnk);
		for(int i=1;i<5;i++)
		{
			int lengthOfReviewBefore=listingPage.getLength_beforeClickingReadMore_ReviewsModal(i);
			listingPage.click_readMore_ReviewsModal_Lnk(i);
			int lengthOfReviewAfter=listingPage.getLength_afterClickingReadMore_ReviewsModal(i);
			System.out.println("intial length :"+lengthOfReviewBefore + "length after clicking Read More :"+lengthOfReviewAfter);
			Assert.assertTrue(lengthOfReviewBefore<lengthOfReviewAfter," Read More functionality is broken in Review Box..");
			listingPage.click_readLess_ReviewsModal_Lnk(i);
			int lenOfReviewAfterClickingReadLess=listingPage.getLength_beforeClickingReadMore_ReviewsModal(i);
			Assert.assertTrue(lengthOfReviewBefore==lenOfReviewAfterClickingReadLess," Read Less functionality is broken in Review Box..");
		}
	}

	@Test
	public void TC_ListPage_020_Validate_Headers_ReviewsModal() {
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl());
		listingPage.click_ReviewsCount_FirstTuple_WE();
		Assert.assertTrue(generic.isVisible(ListingPage.reviewsModalDialogue_WE),"Review box not visible on list page !!");
		Assert.assertEquals(listingPage.getText_title_ReviewsModal_Lbl().trim(), "Reviews for "+listingPage.getText_HotelName_FirstTuple_Lbl(),"Review Modal header's title section is not appropriate.");
		Assert.assertEquals(listingPage.getText_subTitle_ReviewsModal_Lbl().trim(),"Rated Very Good across "+generic.getText(ListingPage.reviewsCount_FirstTuple_WE),"Review Modal header's Sub-title section is not appropriate.");
	}
	
	@Test
	public void TC_ListPage_021_Validate_BreadCrumb_CityPage() {
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl());
		Assert.assertTrue(generic.isVisible(ListingPage.cityPage_breadcrumb_WE),"Bread Crumb is not present at the top of City Page.");
		listingPage.click_cityPage_breadcrumb_AllHotels_Lnk();
		Assert.assertEquals(driver.getTitle(),Constants.TITLE_HOMEPAGE,"Breadcrumb link is Not Navigating to HOME PAGE ....");
	}
	
	@Test
	public void TC_ListPage_022_Validate_Title_CityPage() {
		generic.loadURL_HandlePopup(UrlProvider.getListingPageUrl());
		Assert.assertEquals(driver.getTitle(),Constants.DELHI_CITYPAGE_TITLE,"City Page Title is not appropriate.");
	}

	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}