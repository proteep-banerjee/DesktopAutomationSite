package com.fabhotels.desktopsite.pageobjects;

import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class ListingPage {

	WebDriver driver;
	GenericFunctions generic;
	SoftAssert s_assert = new SoftAssert();

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

	public static final String noPropertyFound_Msg = "We couldn’t find hotels matching your search criteria";

	public ListingPage(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}

	public static final By noOfRooms_DD = By.xpath("//div[@class='custom-value-content clearfix']");
	public static final By list_noOfRooms_DD = By.xpath("//div[@class='custom-value-dropdown']//ul/li");
	public static final By search_Btn = By.id("listingPageBtn");

	public static final By cityName_Lbl = By.xpath("//div[@class='hotel-info']/strong");
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

	public static final By reviewsModalDialogue_WE = By.xpath("//div[@class='modal-content review-modal']");
	public static final By cross_reviewsModal_Btn = By.xpath("//button[contains(@class,'modal_review_cls')]");
	public static final By featureBox_WE = By.xpath("//div[@class='catalogue_property_feature_box clearfix']");
	public static final By closeToAirport_Lbl = By.xpath("//span[@class='link-airport']");
	public static final By priceContainer_WE = By.xpath("//div[@class='price']");
	public static final By popCloseButton_Btn = By.xpath("//button[contains(@class,'vouchure_close')]");
	public static final By hotelListPic_WE = By.xpath("//div[@class='hotel-list-pic']");
	public static final By hotelListName_WE = By.xpath("//div[@class='hotel-list-desc-above']//h3");
	public static final By hotelBook_Btn = By.xpath("//a[contains(text(),'Book Now')]");
	public static final By allCities_dropDown = By.xpath("//a[@class='other-cities-icon']");
	public static final By city_dropDown = By.xpath("//ul[@class='clearfix']/li/a");
	public static final By mainLogo_WE = By.xpath("//div[@class='main-logo']");
	public static String defaultHotelImage_name = "mainMedium.png";
	public static final By searchResultContainer_WE = By.xpath("//div[@class='container search-result-page']");
	public static String roomsNumber_WE = "//div[@class='custom-value-dropdown']//li/a[contains(text(),'";// Append
																											// "roomNumber)]"

	public String getText_resultsCountText_Lbl() {
		return generic.getText(resultsCountText_Lbl);
	}

	public void check_Hotels_count() {
		for (int j = 1; j < generic.getSize(city_dropDown); j++) {
			System.out.println("Current city :" + iterate_all_Cities(j));
			int Hotellist = generic.getSize(hotelList_WE);
			generic.goToSleep(2000);
			int hotel_num = Integer.parseInt(getText_NoofHotelFound());
			System.out.println("Showing: " + hotel_num + " and listing: " + Hotellist);
			s_assert.assertEquals(Hotellist, hotel_num, "number of Hotels displayed is incorrect.");
		}
		s_assert.assertAll();
	}

	public void compare_Rack_Price() {
		for (int j = 1; j < 4; j++) {
			String name_of_city = iterate_all_Cities(j);
			System.out.println("Current city :" + name_of_city);
			String price, rack, hotelName = "";
			for (int i = 1; i < generic.getSize(hotelList_WE); i++) {
				price = "(//div[@class='price'])" + "[" + i + "]" + "//span[@class='new-price']";
				rack = "(//div[@class='price'])" + "[" + i + "]" + "//span[@class='old-price']/del";
				hotelName = generic.getText("(//div[@class='hotel-list-desc-above']/h3/a)[" + i + "]");
				By price_WE = By.xpath(price);
				By rack_WE = By.xpath(rack);
				if (generic.isVisible(rack_WE)) {
					String rack_value = generic.getText(rack_WE).replaceAll("[^0-9.]", "");
					String price_value = generic.getText(price_WE).replaceAll("[^0-9.]", "");
					int rac_value = Integer.parseInt(rack_value);
					int pri_value = Integer.parseInt(price_value);
					System.out.println(
							hotelName + " Rack price is :" + rack_value + " and Offered price is :" + price_value);
					s_assert.assertTrue(rac_value > pri_value, "Price is greator than Rack Price !! under city :"
							+ name_of_city + " Rack price is :" + rac_value + " And offered price is :" + pri_value);
				}
			}
		}
		s_assert.assertAll();
	}

	public void check_All_Hotel_links() {
		for (int j = 1; j < 4; j++) {
			String name_of_city = iterate_all_Cities(j);
			System.out.println("Current city :" + name_of_city);
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
		for (int j = 1; j < 4; j++) {
			String name_of_city = iterate_all_Cities(j);
			System.out.println("Current city :" + name_of_city);
			int totalHotelNum = driver.findElements(hotelList_WE).size();
			for (int i = 0; i < totalHotelNum / 2; i++) {
				int randomNum = ThreadLocalRandom.current().nextInt(1,totalHotelNum);
				generic.scrollToElement(By.xpath("(//div[@class='hotel-list-desc-above']//div[@class='review-star'])[" + randomNum + "]//a"), false);
				generic.click(By.xpath("(//div[@class='hotel-list-desc-above']//div[@class='review-star'])[" + randomNum + "]//a"));
				s_assert.assertTrue(generic.isVisible(ListingPage.reviewsModalDialogue_WE),
						"Review box not visible on " + name_of_city + " list page !!");
				generic.click(review_close_Btn);
				generic.goToSleep(2000);
			}
		}
		s_assert.assertAll();
	}

	public String iterate_all_Cities(int i) {
		generic.performMouseHover(allCities_dropDown);
		String name_of_city = generic.getText(By.xpath("(//ul[@class='clearfix']/li/a)[" + i + "]"));
		generic.click(By.xpath("(//ul[@class='clearfix']/li/a)[" + i + "]"));
		generic.goToSleep(2000);
		return name_of_city;
	}

	public void all_Cities_names() {
		for (int j = 1; j < 4; j++) {
			String name_of_city = iterate_all_Cities(j);
			System.out.println("Current city :" + name_of_city);
			s_assert.assertEquals(generic.getText(cityName_Lbl).trim(), name_of_city,
					"Hotel info name is not matching with picked city.");
			if (generic.isVisible(resultsCountText_Lbl)) {
				s_assert.assertEquals(generic.getText(resultsCountText_Lbl).split("in ")[1].trim(), name_of_city,
						"Hotel info is not matching with picked city");
			} else
				s_assert.assertTrue(generic.isVisible(resultsCountText_Lbl),
						"No hotles found under city :" + generic.getText(cityName_Lbl).trim());
		}
		s_assert.assertAll();
	}

	public void check_ImageAndLandmark() {
		for (int j = 1; j < 4; j++) {
			String name_of_city = iterate_all_Cities(j);
			System.out.println("Current city :" + name_of_city);
			int count = generic.getSize(By.xpath("//img[@class='lazy']"));
			for (int i = 1; i < count; i++) {
				generic.scrollToElement(By.xpath("(//img[@class='lazy'])[" + i + "]"), false);
				String imgsrc = generic.getAttributeValue(By.xpath("(//img[@class='lazy'])[" + i + "]"), "src");
				String hotelImageName = imgsrc.split("/")[imgsrc.split("/").length - 1];
				String HotelName = generic.getText("(//div[@class='hotel-list-desc-above']/h3/a)[" + i + "]");
				System.out.println(HotelName + "  imageName--->" + hotelImageName);
				s_assert.assertNotEquals(hotelImageName, defaultHotelImage_name,
						"Under city " + name_of_city + " ,Hotel image is not comming for : " + HotelName);
				s_assert.assertTrue(generic.getText(location_WE).trim().length() > 16,
						"Under city " + name_of_city + " ,Landmark is not comming for : " + HotelName);

			}
		}
		s_assert.assertAll();
	}

	public void selectRooms() {
		for (int i = 1; i < generic.getSize(list_noOfRooms_DD) + 1; i++) {
			generic.performMouseHover(noOfRooms_DD);
			generic.click(roomsNumber_WE + i + "')]");
			generic.click(search_Btn);
			generic.goToSleep(2000);
			generic.isVisible(searchResultContainer_WE);
		}

	}

	public String getText_NoofHotelFound() {
		return generic.getText(resultsCountText_Lbl).split(" ")[0];
	}

	public void click_SingleProperty_WE() {
		generic.click(singleProperty_WE);

	}

	public void click_Filters_WE() {
		generic.click(filters_WE);
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

}
