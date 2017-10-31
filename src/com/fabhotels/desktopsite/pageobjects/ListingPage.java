package com.fabhotels.desktopsite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class ListingPage {

	WebDriver driver;
	GenericFunctions generic;

	public static final By checkIn_Date_WE = By.id("checkIn");
	public static final By checkOut_Date_WE = By.id("checkOut");
	public static final By find_Fabhotels_Btn = By.id("homePageSearchBtn");
	public static final By hotelList_WE = By.xpath("//div[@class='hotel-list clearfix ']");
	public static final By resultsCountText_Lbl = By.xpath("//h1[@class='propertyCount']");
	public static final By review_close_Btn = By.xpath("//button[@class='close modal_review_cls']/span");
	public static final By cityName_Lbl = By.xpath("//div[@class='hotel-info']/input");
	public static final By filters_WE = By.xpath("//ul[@class='filterList clearfix']//label");
	public static final By allProperties_WE = By.xpath("//div[contains(@class,'hotel-list clearfix')]");

	// All Tuples
	public static final By hotelName_WE = By.xpath("//div[@class='hotel-list-desc-above']/h3/a");
	public static final By location_WE = By.xpath("//div[@class='location']");
	public static final By rating_WE = By.xpath("//span[@class='review-star-icon']");
	public static final By reviewsCount_WE = By.xpath("//div[@class='review-star']/a");
	public static final By peopleLookingNow_WE = By.xpath("//div[@class='booking-now']");
	public static final By price_WE = By.xpath("//span[@class='new-price']");
	public static final By rackPrice_WE = By.xpath("//span[@class='old-price']/del");
	public static final By bookNow_WE = By.xpath("//a[text()=' Book Now']");
	public static final By hotelImage_WE = By.xpath("//div[@class='hotel-list-pic']");

	// First Tuple
	public static final By hotelName_FirstTuple_Lbl = By.xpath("(//div[@class='hotel-list-desc-above']/h3/a)[1]");
	public static final By location_FirstTuple_Lbl = By.xpath("(//div[@class='location'])[1]");
	public static final By rating_FirstTuple_Lbl = By.xpath("(//span[@class='review-star-icon'])[1]");
	public static final By reviewsCount_FirstTuple_WE = By.xpath("(//div[@class='review-star']/a)[1]");
	public static final By peopleLookingNow_FirstTuple_Lbl = By.xpath("(//div[@class='booking-now'])[1]");
	public static final By price_FirstTuple_Lbl = By.xpath("(//span[@class='new-price'])[1]");
	public static final By rackPrice_FirstTuple_Lbl = By.xpath("(//span[@class='old-price']/del)[1]");
	public static final By bookNow_FirstTuple_Btn = By.xpath("(//a[text()=' Book Now'])[1]");
	public static final By hotelImage_FirstTuple_WE = By.xpath("(//div[@class='hotel-list-pic'])[1]");

	// Reviews Modal Dialogue
	public static final By reviewsModalDialogue_WE = By.xpath("//div[@class='modal-content review-modal']");
	public static final By cross_reviewsModal_Btn = By.xpath("//button[contains(@class,'modal_review_cls')]");
	public static final By hotelName_ReviewsModal_Lbl = By.xpath("//h4[@id='myModalLabel']/a");
	public static final By ratingText_ReviewsModal_Lbl = By.xpath("//p[@class='modal-subtitle']");
	public static final By allTuples_ReviewsModal_WE = By.xpath("//div[@class='review_bx_main_bx_sngl ']");
	public static final By loadMoreReviews_ReviewsModal_Lnk = By.id("moreReviewLink_2");
	public static final By readMore_ReviewsModal_Lnk = By.xpath("//a[text()='Read More']");
	public static final By reviewLetter_Icon_ReviewsModal_Lnk = By
			.xpath("//div[@class='review_bx_heading_wrd bg_cyan']");
	public static final By reviewerName_Date_ReviewsModal_Lnk = By.xpath("//div[@class='review_bx_heading_wrd_name']");
	public static final By reviewDate_ReviewsModal_Lnk = By.xpath("//div[@class='review_bx_heading_wrd_name']/span");
	public static final By reviewRating_ReviewsModal_Lnk = By
			.xpath("//div[@class='modal-content review-modal']//span[@class='review-star-icon']/span");
	public static final By reviewBody_ReviewsModal_Lnk = By.xpath("//div[@class='review_text_bx']//p");

	public static final By selectRooms_Btn = By.id("propertySselectRoom");

	public static final By featureBox_WE = By.xpath("//div[@class='catalogue_property_feature_box clearfix']");
	public static final By closeToAirport_Lbl = By.xpath("//span[@class='link-airport']");
	public static final By priceContainer_WE = By.xpath("//div[@class='price']");
	public static final By popCloseButton_Btn = By.xpath("//button[contains(@class,'vouchure_close')]");
	public static final By nearByHotel_Lbl = By.xpath("//h2[@class='sub-title']");
	public static String totalNearByProperty_WE = "//ul[@id='more_properties_content']//li";
	public static final By lastHotelNearBy_WE = By.xpath("(" + totalNearByProperty_WE + ")" + "[last()]");
	public static String defaultHotelImage_name = "mainMedium.png";

	public static final By goToHomePage_Btn = By.xpath("//a[text()=' Go to Home Page ']");
	public static final By searchResultContainer_WE = By.xpath("//div[@class='container search-result-page']");
	public static final By nearByProperty_nav = By.xpath("//a[@class='flex-next']");
	public static final By footer_stayUpdated = By.xpath("//div[@class='footer_row']//div[@class='stay_update']");
	public static final By homePage_mainTitle_lbl = By.xpath("//div[contains(text(),'Innnndia’s Best')]");
	public static String bookingNow_Lbl = "(//div[@class='booking-now'])";
	public static String nearBy_txt = "Explore more hotels near ";
	public static String nearByBook_btn = "//ul[@id='more_properties_content']//a[@class='btn']";
	public static String nearByHotelName_lbl = "//ul[@id='more_properties_content']//h3/a";
	public static String nearByHotelReview_lbl = "//ul[@id='more_properties_content']//div[@class='review-star']";
	public static String nearByHotelImg_img = "//ul[@id='more_properties_content']//img";
	public static final By cityErrorMsg_WE = By.xpath("//div[@id='cityErrorMsg']");
	public static String cityErrorMsg_txt = "Please tell us where you are headed!";
	public static final String noHotelFoundMsg_txt = "//h2[contains(text(),' We couldn’t find hotels matching ')]";

	// Sold out
	public static final By soldOut_Lbl = By.xpath("//div[@class='sold-out-caption']");
	public static final By lastHotelName_WE = By.xpath("(//div[@class='hotel-list-desc-above']/h3/a)[last()]");
	public static final By lastHotelPrice_WE = By.xpath("(//div[@class='price']//span[@class='new-price'])[last()]");
	public static String soldOut_Btn = "//a[@class='btn']";

	public static final String someRoomsLeft_Lbl = "FabHotel Some Rooms Sold Out";
	public static final By lastSoldOut_btn = By.xpath("(" + soldOut_Btn + ")" + "[last()]");
	public static final By soldOutAlertBox_Lbl = By.xpath("//div[contains(@class,'error_msg_alert')]//p");
	public static final By roomSoldOutAlertBox_Lbl = By.xpath("(//div[contains(@class,'error_msg_alert')]//p)[2]");
	public static final By roomLeft_Lbl = By
			.xpath("//a[contains(text(),'FabHotel Some Rooms Sold Out')]//ancestor::div/div/a/following-sibling::div");
	public static final By roomLeftBookNow_btn = By.xpath(
			"//a[contains(text(),'FabHotel Some Rooms Sold Out')]//following::div/a[contains(text(),'Book Now')]");
	public static final By someRoomLeft_WE = By.xpath("//a[contains(text(),'" + someRoomsLeft_Lbl + "')]");
	public static final String roomSelectionRoomTypeNumber_WE = "(//div[@class='room-types-selection'])[";
	public static final String disabledRoomSelectionNumberOfRooms_WE = "//a[@class='outOfStock' and contains(text(),'";
	public static final String soldOutText_Lbl = "//div[text()='Sold Out']";
	public static final String roomType_WE = "(//div[@class='room-types-section clearfix'])[";
	public static final String roomsLeft_Lbl = "//div[contains(text(),'left')]";
	public static final String roomSelectionNumberOfRooms_WE = "//a[contains(text(),'";
	public static final By disabledRooms_Btn = By.xpath("//a[@class='outOfStock']");

	public ListingPage(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}

	public String getText_resultsCountText_Lbl() {
		return generic.getText(resultsCountText_Lbl);
	}

	public void click_FirstFilter_WE() {
		generic.click(ListingPage.filters_WE);
	}

	public int getSize_hotelList_WE() {
		return generic.findElements(hotelList_WE).size();
	}

	public String getText_RackPrice_FirstTuple_WE() {
		return generic.findElement(rackPrice_WE).getText().replaceAll("[^0-9.]", "");
	}

	public String getText_SellingPrice_FirstTuple_WE() {
		return generic.findElement(price_WE).getText().replaceAll("[^0-9.]", "");
	}

	public String getText_RackPrice_WE(WebElement tuple) {
		return tuple.findElement(rackPrice_WE).getText().replaceAll("[^0-9.]", "");
	}

	public String getText_SellingPrice_WE(WebElement tuple) {
		return tuple.findElement(price_WE).getText().replaceAll("[^0-9.]", "");
	}

	public String getText_HotelName_FirstTuple_Lbl() {
		return generic.findElement(hotelName_FirstTuple_Lbl).getText();
	}

	public void click_HotelName_FirstTuple_Lbl() {
		generic.click(ListingPage.hotelName_FirstTuple_Lbl);
	}

	public void click_BookNow_FirstTuple_Btn() {
		generic.click(ListingPage.bookNow_FirstTuple_Btn);
	}

	public void click_HotelImage_FirstTuple_WE() {
		generic.click(ListingPage.hotelImage_FirstTuple_WE);
	}

	public void click_Review_close_Btn() {
		generic.click(ListingPage.review_close_Btn);
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

	public int getTotalTupleCount_ListPage() {
		return generic.findElements(allProperties_WE).size();
	}

	public String getImagePath_Tuple(int tupleNo) {
		return generic.findElement(hotelImage_WE + "//img[" + tupleNo + "]").getAttribute("src");
	}

	public String getLandmark_Tuple(int tupleNo) {
		return generic.getText(location_WE + "[" + tupleNo + "]").trim();
	}

	public String getLastBookedText_Tuple(int tupleNo) {
		return generic.findElement(bookingNow_Lbl + "[" + tupleNo + "]").getText();
	}

	public String getText_NoofHotelFound() {
		return generic.getText(resultsCountText_Lbl).split(" ")[0];
	}

	public String getText_SoldOutAlertBox_Lbl() {
		return generic.getText(soldOutAlertBox_Lbl);
	}

	public String getText_RoomSoldOutAlertBox_Lbl() {
		return generic.getText(roomSoldOutAlertBox_Lbl);
	}

	public String getText_RoomLeft_Lbl() {
		return generic.getText(roomLeft_Lbl);
	}

	public void click_LastSoldOut_btn() {
		generic.click(lastSoldOut_btn);
	}

	public void click_DisabledRooms_Btn() {
		generic.click(disabledRooms_Btn);
	}

	public String getText_LastHotelPrice_WE() {
		return generic.getText(ListingPage.lastHotelPrice_WE).replaceAll("[^0-9.]", "");
	}

	public int getSize_DisabledRooms_Btn() {
		return generic.getSize(ListingPage.disabledRooms_Btn);
	}

	public void verifyNearByPropertyOnListPage() {

	}

}
