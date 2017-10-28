package com.fabhotels.desktopsite.pageobjects;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class ListingPage {

	WebDriver driver;
	GenericFunctions generic;
	int hotelsCountUnderListPage = 1;
	int cityCount = 1;
	int randomCity_count = 1;

	public static final By location_Txt = By.id("autocomplete-location");

	public static final By checkIn_Date_WE = By.id("checkIn");
	public static final By checkOut_Date_WE = By.id("checkOut");
	public static final By add_Room_Btn = By.id("addRoom");
	public static final By remove_room_Btn = By.id("removeRoom");
	public static final By find_Fabhotels_Btn = By.id("homePageSearchBtn");
	public static final By allProperties_WE = By.xpath("//div[@class='catalogue_property_list_bx_sngl']");
	public static final By singleProperty_WE = By.xpath("(//div[@class='catalogue_property_price_book']/a)[1]");
	public static final By listResults_WE = By.xpath("//div[@class='hotel-list-container']");
	public static final By hotelList_WE = By.xpath("//div[@class='hotel-list clearfix ']");
	public static final By noPropertyFound_Lbl = By
			.xpath("//div[contains(@class, 'catalogue_property_list_bx_sngl')]/p");
	public static final By resultsCountText_Lbl = By.xpath("//h1[@class='propertyCount']");
	public static final By noResultsFoundMessage_Lbl = By.xpath("//div[@class='no-data-found clearfix']/h2/text()");
	public static final By SingleFilterList_WE = By.xpath("(//ul[@class='filterList']/li)[1]");
	public static final By allFilterlist_WE = By.xpath("//ul[@class='filterList']/li");
	public static final By single_RoomMssg_WE = By.xpath("//span[contains(text(), 'room remaining!')]");
	public static final By more_RoomMssg_WE = By.xpath("//span[contains(text(), 'rooms remaining!')]");
	public static final By Reviews_WE = By.xpath("//div[@class='catalogue_property_list_detail_rating']");
	public static final By soldout_Btn = By
			.xpath("(//div[@class='catalogue_property_price_book']/a[contains(text(), 'Sold Out')])[1]");
	public static final By booknow_Btn = By
			.xpath("(//div[@class='catalogue_property_price_book']//a[contains(text(), 'Book Now')])[1]");
	public static final By review_close_Btn = By.xpath("//button[@class='close modal_review_cls']/span");
	public static final By moreReview_Btn = By.xpath("//a[contains(text(), 'Load more reviews')]");
	public static final By rackRate_WE = By.xpath("//div[@class='catalogue_property_price_show']/div");
	public static final By homePageSearchBox_WE = By.xpath("//input[@name='locationsearch']");

	public static final String noPropertyFound_Msg = "We couldn’t find hotels matching your search criteria";
	public static final By noOfRooms_DD = By.xpath("//div[@class='custom-value-content clearfix']");

	public static final By cityName_Lbl = By.xpath("//div[@class='hotel-info']/input");
	public static final By bookingDetails_Lbl = By.xpath("//div[@class='hotel-info']/span");
	public static final By filters_WE = By.xpath("//ul[@class='filterList clearfix']//label");

	public static final By hotelName_WE = By.xpath("//div[@class='hotel-list-desc-above']/h3/a");
	public static final By location_WE = By.xpath("//div[@class='location']");
	public static final By rating_WE = By.xpath("//span[@class='review-star-icon']");
	public static final By reviewsCount_WE = By.xpath("//div[@class='review-star']/a");
	public static final By peopleLookingNow_WE = By.xpath("//div[@class='booking-now']");
	public static final By price_WE = By.xpath("//span[@class='new-price']");
	public static final By rackPrice_WE = By.xpath("//span[@class='old-price']/del");
	public static final By bookNow_WE = By.xpath("//a[text()=' Book Now']");

	public static final By hotelName_FirstTuple_Lbl = By.xpath("(//div[@class='hotel-list-desc-above']/h3/a)[1]");
	public static final By location_FirstTuple_Lbl = By.xpath("(//div[@class='location'])[1]");
	public static final By rating_FirstTuple_Lbl = By.xpath("(//span[@class='review-star-icon'])[1]");
	public static final By reviewsCount_FirstTuple_WE = By.xpath("(//div[@class='review-star']/a)[1]");
	public static final By peopleLookingNow_FirstTuple_Lbl = By.xpath("(//div[@class='booking-now'])[1]");
	public static final By price_FirstTuple_Lbl = By.xpath("(//span[@class='new-price'])[1]");
	public static final By rackPrice_FirstTuple_Lbl = By.xpath("(//span[@class='old-price']/del)[1]");
	public static final By bookNow_FirstTuple_Lbl = By.xpath("(//a[text()=' Book Now'])[1]");
	public static final By selectRooms_Btn = By.id("propertySselectRoom");
	public static final By reviewsModalDialogue_WE = By.xpath("//div[@class='modal-content review-modal']");
	public static final By cross_reviewsModal_Btn = By.xpath("//button[contains(@class,'modal_review_cls')]");
	public static final By featureBox_WE = By.xpath("//div[@class='catalogue_property_feature_box clearfix']");
	public static final By closeToAirport_Lbl = By.xpath("//span[@class='link-airport']");
	public static final By priceContainer_WE = By.xpath("//div[@class='price']");
	public static final By popCloseButton_Btn = By.xpath("//button[contains(@class,'vouchure_close')]");
	public static final By hotelListPic_WE = By.xpath("//div[@class='hotel-list-pic']");
	public static final By hotelListName_WE = By.xpath("//div[@class='hotel-list-desc-above']//h3");
	public static final By hotelBook_Btn = By.xpath("//a[contains(text(),' Book Now')]");
	public static final By allCities_dropDown = By.xpath("//a[@class='other-cities-icon']");
	public static final By city_dropDown = By.xpath("//div[@class='other-cities-dropdown']//li/a");
	public static final By mainLogo_WE = By.xpath("//div[@class='main-logo']");
	public static final By nearByHotel_Lbl = By.xpath("//h2[@class='sub-title']");
	public static String totalNearByProperty_WE = "//ul[@id='more_properties_content']//li";
	public static final By lastHotelNearBy_WE = By.xpath("(" + totalNearByProperty_WE + ")" + "[last()]");
	public static String defaultHotelImage_name = "mainMedium.png";
	public static final By searchBox_WE = By.xpath("//input[@name='locationsearch']"); // both
																						// home
																						// and
																						// search
	public static final By goToHomePage_Btn = By.xpath("//a[text()=' Go to Home Page ']");
	public static final By searchResultContainer_WE = By.xpath("//div[@class='container search-result-page']");
	public static final By nearByProperty_nav = By.xpath("//a[@class='flex-next']");
	public static final By footer_stayUpdated = By.xpath("//div[@class='footer_row']//div[@class='stay_update']");
	public static final By findFabHotel_Btn = By
			.xpath("//*[contains(text(), ' Find FabHotels ') or contains(@value ,'Find FabHotels')]");
	public static final By homePage_mainTitle_lbl = By.xpath("//div[contains(text(),'Innnndia’s Best')]");
	public static String roomsNumber_WE = "//div[@class='custom-value-dropdown']//li/a[contains(text(),'";// Append
	public static String bookingNow_Lbl = "(//div[@class='booking-now'])";
	public static String nearBy_txt = "Explore more hotels near ";
	public static String nearByBook_btn = "//ul[@id='more_properties_content']//a[@class='btn']";
	public static String nearByHotelName_lbl = "//ul[@id='more_properties_content']//h3/a";
	public static String nearByHotelReview_lbl = "//ul[@id='more_properties_content']//div[@class='review-star']";
	public static String nearByHotelImg_img = "//ul[@id='more_properties_content']//img";
	public static final By cityErrorMsg_WE = By.xpath("//div[@id='cityErrorMsg']");
	public static String cityErrorMsg_txt = "Please tell us where you are headed!";
	public static final String noHotelFoundMsg_txt = "//h2[contains(text(),' We couldn’t find hotels matching ')]";

	public static String locality_name = "Sarojini Nagar";

	//Sold out 
	public static final By soldOut_Lbl=By.xpath("//div[@class='sold-out-caption']");
	public static final By lastHotelName_WE = By.xpath("(//div[@class='hotel-list-desc-above']/h3/a)[last()]");
	public static final By lastHotelPrice_WE=By.xpath("(//div[@class='price']//span[@class='new-price'])[last()]");
	public static String soldOut_Btn = "//a[@class='btn']";
	public static String soldOut_Msg="This hotel is SOLD OUT for selected dates. Change dates or explore nearby Hotels.";
	public static String soldOutByRooms_Msg="Selected number of rooms are not available. Adjust dates or number of rooms.";
	public static final String someRoomsLeft_Lbl="FabHotel Some Rooms Sold Out";
	
	public static final By lastSoldOut_btn = By.xpath("(" + soldOut_Btn + ")" + "[last()]");
	public static final By soldOutAlertBox_Lbl=By.xpath("//div[contains(@class,'error_msg_alert')]//p");
	public static final By roomSoldOutAlertBox_Lbl=By.xpath("(//div[contains(@class,'error_msg_alert')]//p)[2]");
	public static final By roomLeftLbl = By.xpath("//a[contains(text(),'FabHotel Some Rooms Sold Out')]//ancestor::div/div/a/following-sibling::div");
	public static final By roomLeftBookNow_btn=By.xpath("//a[contains(text(),'FabHotel Some Rooms Sold Out')]//following::div/a[contains(text(),'Book Now')]");
	public static final By someRoomLeft_WE = By.xpath("//a[contains(text(),'"+someRoomsLeft_Lbl+"')]");
	public static final String roomSelectionRoomTypeNumber_WE = "(//div[@class='room-types-selection'])[";
	public static final String disabledRoomSelectionNumberOfRooms_WE = "//a[@class='outOfStock' and contains(text(),'";
	public static final String soldOutText_Lbl = "//div[text()='Sold Out']";
	public static final String roomType_WE = "(//div[@class='room-types-section clearfix'])[";
	public static final String roomsLeft_Lbl = "//div[contains(text(),'left')]";
	public static final String roomSelectionNumberOfRooms_WE = "//a[contains(text(),'";
	
	// Details Page
	public static final By hotelName_Lbl = By.xpath("//h1");
	public static final By price_Lbl = By.xpath("//div[@class='select-room-price']//strong");
	public static final By exploreNearbyTop_WE = By.xpath("((//div[@class='nearby_properties_container'])[1])");
	public static final By disabledRooms_Btn=By.xpath("//a[@class='outOfStock']");

	public ListingPage(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}

	public String getText_resultsCountText_Lbl() {
		return generic.getText(resultsCountText_Lbl);
	}

	public void check_Hotels_count() {
		SoftAssert s_assert = new SoftAssert();
		for (int j = 1; j < 6; j++) {
			System.out.println("Current city :" + iterate_all_Cities(randomCity_count));
			int hotel_num = Integer.parseInt(getText_NoofHotelFound());
			System.out.println("Showing: " + hotel_num + " and listing: " + hotelsCountUnderListPage);
			s_assert.assertEquals(hotelsCountUnderListPage, hotel_num, "number of Hotels displayed is incorrect.");
		}
		s_assert.assertAll();
	}

	public void compare_Rack_Price() {
		SoftAssert s_assert = new SoftAssert();
		for (int j = 1; j < 6; j++) {
			System.out.println("Current city :" + iterate_all_Cities(randomCity_count));
			String price, rack, hotelName = "";
			for (int i = 1; i < 6; i++) {
				int randomHotel_count = generic.getRandomNumberBetween(1, hotelsCountUnderListPage);
				price = "(//div[@class='price'])" + "[" + randomHotel_count + "]" + "//span[@class='new-price']";
				rack = "(//div[@class='price'])" + "[" + randomHotel_count + "]" + "//span[@class='old-price']/del";
				hotelName = generic.getText("(//div[@class='hotel-list-desc-above']/h3/a)[" + randomHotel_count + "]");
				By price_WE = By.xpath(price);
				By rack_WE = By.xpath(rack);
				if (generic.isVisible(rack_WE)) {
					String rack_value = generic.getText(rack_WE).replaceAll("[^0-9.]", "");
					String price_value = generic.getText(price_WE).replaceAll("[^0-9.]", "");
					int rac_value = Integer.parseInt(rack_value);
					int pri_value = Integer.parseInt(price_value);
					System.out.println(
							hotelName + " Rack price is :" + rack_value + " and Offered price is :" + price_value);
					s_assert.assertTrue(rac_value > pri_value,
							"Price is greator than Rack Price !! under city :" + randomHotel_count + " Rack price is :"
									+ rac_value + " And offered price is :" + pri_value);
				}
			}
		}
		s_assert.assertAll();
	}

	public void check_All_Hotel_links() {
		SoftAssert s_assert = new SoftAssert();
		for (int j = 1; j < 6; j++) {
			System.out.println("Current city :" + iterate_all_Cities(randomCity_count));
			generic.setImplicitWaitInSeconds(2);
			Iterator<WebElement> it1 = generic.findElements(hotelListPic_WE).iterator();
			Iterator<WebElement> it2 = generic.findElements(hotelListName_WE).iterator();
			Iterator<WebElement> it3 = generic.findElements(hotelBook_Btn).iterator();
			while (it1.hasNext() && it2.hasNext() && it3.hasNext()) {
				s_assert.assertTrue(it1.next().isEnabled(), "Hotel pic link is disabled from  list page !! ");
				s_assert.assertTrue(it2.next().isEnabled(), "Hotel name link is disabled from list page !! ");
				s_assert.assertTrue(it3.next().isEnabled(), "Hotel button is disabled from list page");
			}
		}
		s_assert.assertAll();
	}

	public void check_review() {
		SoftAssert s_assert = new SoftAssert();
		for (int j = 1; j < 5; j++) {
			String cityName = iterate_all_Cities(randomCity_count);
			System.out.println("Current city :" + cityName);
			for (int i = 0; i < 6; i++) {
				int randomHotel_count = generic.getRandomNumberBetween(1, hotelsCountUnderListPage);
				generic.scrollToElement(By.xpath("(//div[@class='review-star'])[" + randomHotel_count + "]//a"), false);
				generic.click(By.xpath("(//div[@class='review-star'])[" + randomHotel_count + "]//a"));
				s_assert.assertTrue(generic.isVisible(ListingPage.reviewsModalDialogue_WE),
						"Review box not visible on " + cityName + " list page !!");
				generic.click(review_close_Btn);
				generic.goToSleep(2000);
			}
		}
		s_assert.assertAll();
	}

	public String iterate_all_Cities(int i) {
		generic.performMouseHover(allCities_dropDown);
		String name_of_city = generic.getText(By.xpath("(//ul[@class='clearfix']/li/a)[" + i + "]"));
		cityCount = generic.getSize(city_dropDown);
		generic.click(By.xpath("(//ul[@class='clearfix']/li/a)[" + i + "]"));
		generic.goToSleep(2000);
		randomCity_count = generic.getRandomNumberBetween(1, cityCount);
		hotelsCountUnderListPage = generic.getSize(hotelList_WE);
		return name_of_city;
	}

	public void all_Cities_names() {
		SoftAssert s_assert = new SoftAssert();
		for (int j = 1; j < 6; j++) {
			String cityName = iterate_all_Cities(randomCity_count);
			System.out.println("Current city :" + cityName);
			s_assert.assertEquals(generic.getValue(cityName_Lbl).trim(), cityName,
					"Hotel info name is not matching with picked city.");
			if (generic.isVisible(resultsCountText_Lbl)) {
				s_assert.assertEquals(generic.getText(resultsCountText_Lbl).split("in ")[1].trim(), cityName,
						"Hotel info is not matching with picked city");
			} else
				s_assert.assertTrue(generic.isVisible(resultsCountText_Lbl),
						"No hotles found under city :" + generic.getValue(cityName_Lbl).trim());
		}
		s_assert.assertAll();
	}

	public void check_ImageAndLandmark() {
		SoftAssert s_assert = new SoftAssert();
		for (int j = 1; j < 6; j++) {
			String cityName = iterate_all_Cities(randomCity_count);
			System.out.println("Current city :" + cityName);
			for (int i = 1; i < 5; i++) {
				int randomHotel_count = generic.getRandomNumberBetween(1, hotelsCountUnderListPage);
				generic.scrollToElement(By.xpath("(//img[@class='lazy'])[" + randomHotel_count + "]"), false);
				String imgsrc = generic.getAttributeValue(By.xpath("(//img[@class='lazy'])[" + randomHotel_count + "]"),
						"src");
				String hotelImageName = imgsrc.split("/")[imgsrc.split("/").length - 1];
				String HotelName = generic
						.getText("(//div[@class='hotel-list-desc-above']/h3/a)[" + randomHotel_count + "]");
				System.out.println(HotelName + "  imageName--->" + hotelImageName);
				s_assert.assertNotEquals(hotelImageName, defaultHotelImage_name,
						"Under city " + cityName + " ,Hotel image is not comming for : " + HotelName);
				s_assert.assertTrue(generic.getText(location_WE).trim().length() > 16,
						"Under city " + cityName + " ,Landmark is not comming for : " + HotelName);
				s_assert.assertTrue(
						generic.findElement(bookingNow_Lbl + "[" + randomHotel_count + "]").getText()
								.contains("people looking"),
						"Under city " + cityName + " ,people looking and last booked label is not comming for : "
								+ HotelName);

			}
		}
		s_assert.assertAll();
	}

	// TO check NearBy property.
	public void verifyNearByPropertyOnListPage() {
		SoftAssert s_assert = new SoftAssert();
		int i = 1;
		generic.goToSleep(1000);
		generic.scrollToElement(nearByProperty_nav, false);
		Assert.assertTrue(generic.isVisible("(" + nearByHotelName_lbl + ")" + "[" + i + "]"),
				"Near By Property is Not Coming!!!.");
		generic.goToSleep(2000);
		while (!driver.findElement(lastHotelNearBy_WE).isDisplayed()) {
			if (driver.findElement(By.xpath("(" + nearByHotelName_lbl + ")" + "[" + i + "]")).isDisplayed()) {
				String hotelName = generic.getText("(" + nearByHotelName_lbl + ")" + "[" + i + "]");
				System.out.println(i + ". Hotle ," + hotelName);
				s_assert.assertTrue(generic.isVisible("(" + totalNearByProperty_WE + ")" + "[" + i + "]"),
						"0 Near By Hotels are comming");
				s_assert.assertTrue(
						generic.isVisible(
								"(" + totalNearByProperty_WE + ")" + "[" + i + "]" + "//span[@class='new-price']"),
						"Price is not comming for :" + hotelName);

				s_assert.assertTrue(generic.isVisible("(" + nearByBook_btn + ")" + "[" + i + "]"),
						"'Book Now' or 'Sold Out' button is not cooming for :" + hotelName);

				s_assert.assertTrue(generic.isVisible("(" + nearByHotelName_lbl + ")" + "[" + i + "]"),
						"Hotel Name is not comming for :" + hotelName);

				s_assert.assertTrue(generic.isVisible("(" + nearByHotelReview_lbl + ")" + "[" + i + "]"),
						"Hotel review is not comming for :" + hotelName);

				String imgSrc = generic.getAttributeValue(By.xpath("(" + nearByHotelImg_img + ")" + "[" + i + "]"),
						"src");
				String imageName = imgSrc.split("/")[imgSrc.split("/").length - 1];
				s_assert.assertNotEquals(imageName, "mainMedium.png", "Main images are not comming for :" + hotelName);
				i++;
			} else {
				generic.click(nearByProperty_nav);
			}
		}
		s_assert.assertTrue(driver.findElement(footer_stayUpdated).isDisplayed(),
				"On Footer stay updated is not comming.");
		// Clicking on last nearby hotel book button
		String lastNearByHotelName = generic.getText("(" + nearByHotelName_lbl + ")" + "[" + i + "]");
		generic.click("(" + nearByBook_btn + ")" + "[" + i + "]");
		String hotelName_DetailsPage = generic.getText(hotelName_Lbl);
		generic.goToSleep(2000);
		s_assert.assertEquals(hotelName_DetailsPage, lastNearByHotelName,
				"Navigating from near by property hotel to Details page is failing...");
		s_assert.assertAll();
	}

	public void selectRooms() {
		generic.goToSleep(7000);
		for (int i = 1; i < 6; i++) {
			generic.performMouseHover(noOfRooms_DD);
			generic.click(roomsNumber_WE + i + "')]");
			generic.click(findFabHotel_Btn);
			generic.goToSleep(2000);
			generic.isVisible(searchResultContainer_WE);
		}

	}

	public void performSearch(String searchText, String checkIn, String checkOut, String noofRooms) {
		generic.fill(searchBox_WE, searchText);
		//generic.setImplicitWaitInSeconds(400);
		Calendar cal = new Calendar(driver, generic);
		if (checkIn.length() > 0 && checkOut.length() > 0) {
			try {
				cal.Select_CheckIn_CheckOut_Date_Calendar_WE(checkIn, checkOut);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (noofRooms.length() > 0) {
			generic.performMouseHover(noOfRooms_DD);
			generic.click(roomsNumber_WE + noofRooms + "')]");
		}

		generic.click(findFabHotel_Btn);
		generic.goToSleep(1000);
	}

	// Func to get url parameters.
	public Map<String, String> getQueryURL() {
		Map<String, String> query_pairs = new LinkedHashMap<>();
		String result = "";
		String query = "";
		int occupancy_count = 0;
		try {
			result = java.net.URLDecoder.decode(generic.getCurrentUrl(), "UTF-8");
			query = new URL(result).getQuery();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		String[] pairs = query.split("&");
		System.out.println("  PARAMETERS: " + "  VALUES:  ");
		for (String pair : pairs) {
			int idx = pair.indexOf("=");
			if (pair.substring(0, idx).equals("occupancy[]")) {
				occupancy_count++;
			} else {
				query_pairs.put(pair.substring(0, idx), pair.substring(idx + 1));
			}
			System.out.println(pair.substring(0, idx) + "\t" + pair.substring(idx + 1));
		}
		// Storing occupancy count on Map as occupancy property is redundant.
		// USE occupancy as a key to get the occupancy count.
		query_pairs.put("occupancy", String.valueOf(occupancy_count));
		return query_pairs;

	}
	
	public Map<String, String> getUrlparam()
	{
		return getQueryURL();
	}

	public void checkURL(String rooms) {
		SoftAssert s_assert = new SoftAssert();
		Map<String, String> parameters = getQueryURL();
		s_assert.assertTrue(parameters.get("locationsearch").contains(locality_name),
				"Location parameter is not correct.in the url");
		s_assert.assertTrue(parameters.get("locality_text").contains(locality_name),
				"Location parameter is not correct in the url.");
		
		GenericFunctions.getDateAfterDays3format("0");
		
		GenericFunctions.getDateAfterDays("5");
		
		
		s_assert.assertTrue(parameters.get("locality_text").contains(locality_name),
				"Location parameter is not correct in the url.");
		
		s_assert.assertEquals(rooms, parameters.get("occupancy"),
				"Occupancy is not Matching with default value. i.e 1 OR is broken");
		s_assert.assertTrue(parameters.get("nearcity").contains("New Delhi"),
				"Near city parameter is not correct.in the url");
		s_assert.assertAll();
	}

	public void assertSearchError() {
		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(generic.getText(cityErrorMsg_WE), cityErrorMsg_txt,
				"List Box errror warning is not comming.");
		s_assert.assertAll();
	}

	public void No_Hotelsfound() {
		SoftAssert s_assert = new SoftAssert();
		generic.goToSleep(2000);
		s_assert.assertTrue(generic.isVisible(noHotelFoundMsg_txt), "Error warning functionalty is broken");
		s_assert.assertTrue(generic.isVisible(goToHomePage_Btn), "Go to Home Page is not comming");
		generic.click(goToHomePage_Btn);
		generic.goToSleep(2000);
		s_assert.assertTrue(generic.isVisible(homePage_mainTitle_lbl), "Go to Home Page is Not Working.");
		s_assert.assertAll();
	}

	public void nearByHotelslistPage() {
		SoftAssert s_assert = new SoftAssert();
		s_assert.assertTrue(generic.findElement(nearByHotel_Lbl).getText().contentEquals(nearBy_txt + locality_name),
				"Near By Hotel is broken on List Page");
		s_assert.assertAll();
	}

	public String getText_NoofHotelFound() {
		return generic.getText(resultsCountText_Lbl).split(" ")[0];
	}

	public void detailsPageLanding_VerifyWithDateAndRooms() {
		SoftAssert s_assert = new SoftAssert();
		String date_ListPage = generic.getAttributeValue(checkIn_Date_WE, "value");
		String price_ListPage = generic
				.getText("(//div[@class='price'])" + "[" + 1 + "]" + "//span[@class='new-price']")
				.replaceAll("[^0-9.]", "");
		String hotelName_ListPage = generic.getText("(//div[@class='hotel-list-desc-above']/h3/a)[" + 1 + "]");
		Map<String, String> parametersListPage = getQueryURL();
		String cityName_ListPage = parametersListPage.get("locationsearch");
		s_assert.assertTrue(parametersListPage.get("rooms").contains("4"),
				"Rooms parameters are not matching on List Page's URL.");

		// Clicking on BookNow of first hotel
		generic.click(bookNow_FirstTuple_Lbl);
		generic.goToSleep(2000);

		// Details Page
		String date_DetailsPage = generic.getAttributeValue(checkIn_Date_WE, "value");
		String hotelName_DetailsPage = generic.getText(hotelName_Lbl);
		String price_DetailsPage = generic.getText(price_Lbl).replaceAll("[^0-9.]", "");
		// Asserting Page
		s_assert.assertEquals(hotelName_DetailsPage, hotelName_ListPage);
		s_assert.assertEquals(date_ListPage, date_DetailsPage);
		s_assert.assertEquals(price_DetailsPage, price_ListPage);
		Map<String, String> parametersDetails = getQueryURL();
		String cityName_DetailsPage = parametersListPage.get("locationsearch");
		// Asserting URL
		s_assert.assertTrue(generic.isVisible(selectRooms_Btn),
				"Select Rooms button is not present on landing From list Page to detail page.");
		s_assert.assertEquals(cityName_DetailsPage, cityName_ListPage);
		s_assert.assertTrue(parametersDetails.get("rooms").contains("4"),
				"Rooms parameters are not matching in Details Page's URL.");
		generic.navigateToPreviousPage();
		s_assert.assertAll();

	}

	public void detailsPageLanding_VerifyWithDateLess() {
		SoftAssert s_assert = new SoftAssert();
		String price_ListPage = generic
				.getText("(//div[@class='price'])" + "[" + 1 + "]" + "//span[@class='new-price']")
				.replaceAll("[^0-9.]", "");
		String hotelName_ListPage = generic.getText("(//div[@class='hotel-list-desc-above']/h3/a)[" + 1 + "]");
		Map<String, String> parametersListPage = getQueryURL();
		String cityName_ListPage = parametersListPage.get("locationsearch");
		s_assert.assertTrue(parametersListPage.get("rooms").contains("1"),
				"rooms parameter is not 1 with dateless case on List Page's URL.");
		s_assert.assertTrue(parametersListPage.get("checkIn").equals(""),
				"checkIn date is not empty on List Page's URL.");

		// Clicking on BookNow of first hotel
		generic.click(bookNow_FirstTuple_Lbl);
		generic.goToSleep(2000);
		// Details Page
		String hotelName_DetailsPage = generic.getText(hotelName_Lbl);
		String price_DetailsPage = generic.getText(price_Lbl).replaceAll("[^0-9.]", "");
		// Asserting Page
		s_assert.assertEquals(hotelName_DetailsPage, hotelName_ListPage,
				"Hotels Names are not matching on details and list page");
		s_assert.assertEquals(price_DetailsPage, price_ListPage,
				"Hotels Prices are not matching on details and list page for Hotel: "+hotelName_ListPage);
		Map<String, String> parametersDetails = getQueryURL();
		String cityName_DetailsPage = parametersListPage.get("locationsearch");
		// Asserting URL
		s_assert.assertTrue(generic.isVisible(selectRooms_Btn),
				"Select Rooms button is not present on landing From list Page to detail page.");
		s_assert.assertEquals(cityName_DetailsPage, cityName_ListPage);
		s_assert.assertTrue(parametersDetails.get("rooms").contains("1"),
				"rooms parameter is not 1 with dateless case on Details Page's URL.");
		// Navigating Back
		generic.navigateToPreviousPage();
		s_assert.assertAll();

	}

	public boolean isDisabled_roomNumber(int roomType, int roomNumber) {
		return generic.isVisible(roomSelectionRoomTypeNumber_WE + roomType + "]" + disabledRoomSelectionNumberOfRooms_WE
				+ roomNumber + "')]");
	}
	
	public boolean isSoldOut_roomType(int roomType) {
		return generic.isVisible(roomType_WE + roomType + "]" + soldOutText_Lbl);
	}
	
	public String getText_roomsLeft_roomType(int roomNumber) {
		return generic.getText(roomType_WE + roomNumber + "]" + roomsLeft_Lbl);
	}
	
	public void click_SingleProperty_WE() {
		generic.click(singleProperty_WE);

	}
	
	public boolean isEnabled_roomNumber(int roomType, int roomNumber) {
		return generic.isVisible(
				roomSelectionRoomTypeNumber_WE + roomType + "]" + roomSelectionNumberOfRooms_WE + roomNumber + "')]");
	}

	public void click_Filters_WE() {
		generic.click(filters_WE);
	}
	public void click_Find_Fabhotels_Btn() {
		generic.click(find_Fabhotels_Btn);
	}

	public void click_ReviewsModalDialogue_WE() {
		generic.click(reviewsModalDialogue_WE);
	}

	public void click_ReviewsCount_FirstTuple_WE() {
		generic.click(reviewsCount_FirstTuple_WE);
	}

	public void click_singleProperty_WE() {
		generic.click(hotelName_FirstTuple_Lbl);
	}

	public String getText_checkIn_Date_WE() {
		return generic.getValue(checkIn_Date_WE);
	}

	public String getText_checkOut_Date_WE() {
		return generic.getValue(checkOut_Date_WE);
	}

}


