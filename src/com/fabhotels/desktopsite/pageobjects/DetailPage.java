package com.fabhotels.desktopsite.pageobjects;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class DetailPage {
	WebDriver driver;
	GenericFunctions generic;
	SoftAssert s_assert;

	public DetailPage(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
		this.s_assert = new SoftAssert();
	}
	// Old

	public static final By checkIn_Date_WE = By.id("checkIn");
	public static final By checkOut_Date_WE = By.id("checkOut");
	public static final By currentMonth_WE = By.xpath("(//div[@class='datepicker-days']//th[@class='switch'])[1]");
	public static final By nextMonth_WE = By.xpath("(//div[@class='datepicker-days']//th[@class='switch'])[2]");
	public static final By nextMonthClick_WE = By.xpath("(//div[@class='datepicker-days']//th[@class='next'])[1]");
	public static final String checkInCalenderDates_WE = "//div[contains(@class, 'datepicker-checkin')]//td";
	public static final String checkOutCalenderDates_WE = "//div[contains(@class, 'datepicker-checkout')]//td";
	public static final String calender_dates_String_WE = "//div[@class='datepicker-days']//td";
	public static final By singlePropertyRoomCount_WE = By
			.xpath("(//input[contains(@class, 'property_counter_input')])[1]");
	public static final By availability_error_msg_Lbl = By.xpath("//p[contains(@class,'availability_error_msg')]");
	public static final By propertyName_Lbl = By.xpath("//div[@class='property_name']/h1");
	public static final By propertyReview_Lbl = By.xpath("//a[contains(text(), 'Rated Very Good across')]");
	public static final By SingleRoom_getRoomCountAndGuestCount_Lbl = By.xpath("//div[contains(text(),'Room /')]");
	public static final By multipleRoomPropertyRoomType_WE = By
			.xpath("//div[contains(@class, 'property_room_type_single')]");
	public static final By multipleRoom_SoldOutMssgForIndividualRoomType_Lbl = By
			.xpath("//div[@class='property_room_type_desc']/p");
	public static final By addRoomForIndividualRoomType_Lbl = By
			.xpath("(//div[contains(@class, 'property_button_plus')])[1]");
	public static final String singleRoom_addRoomForIndividualRoomType_Lbl = "(//div[contains(@class, 'property_button_plus')])";
	public static final String dropDown_Btn = "(//div[contains(text(),'Room /')]/..//span)[1]";
	public static final By availabilityErrMsg_Lbl = By.xpath("//p[contains(text(),'rooms left')]");
	public static final By bookNow_Btn = By.id("propertyReviewBooking");
	// public static final String bookNow_Btn =
	// "//button[@id='propertyReviewBooking']";
	public static final By totalAmounnt_Lbl = By.id("total_amount");
	public static final By SingleRoom_getRoomCountAndNightCount_Lbl = By.xpath("//span[@class='property_room_nights']");
	public static final By multipleRoom_getRoomAndNightCount_Lbl = By
			.xpath("//div[contains(@class, 'property_booking_total_summary')]");
	public static final By soldOutCout_Lbl = By.xpath("//p[contains(text(), 'Sold Out')]");
	public static final By oneRoomLeftMssg_Lbl = By.xpath("//p[contains(text(),'1 room left')]");
	public static final String multipleRoom_OneRoomLeftMssg_Lbl = "//p[contains(text(),'1 room left')]";
	public static final String multipleRoomType_roomCount_WE = "(//div[contains(@class, 'property_room_type_rooms')]/input[@class='property_counter_input'])";
	public static final String multipleRoomType_soldOutMssg_WE = "(//div[@class='property_room_type_desc']/p[@class='property_room_type_rooms_remaining'])";
	public static final String multipleRooomType_propertyPlusButton_WE = "(//div[contains(@class, 'property_room_type_rooms')]/div[contains(@class, 'property_button_plus')])";
	public static final String multipleRoomType_individualPropertyPrice_WE = "(//span[contains(@class, 'room_type_per_night_amount')])";
	public static final By multipleRoomType_totalPriceForAllRooms_WE = By
			.xpath("//span[contains(@class, 'property_booking_total_amount')]");
	public static final By singleRoom_propertyRoomDetails_Btn = By
			.xpath("//span[contains(@class, 'property_room_details_bg')]");
	public static final By singleRoom_occupanyIncrease_Btn = By
			.xpath("(//div[contains(@class, 'property_button_plus')])[2]");
	public static final By singleRoom_propertyAddRoomsDone_Btn = By
			.xpath("//div[contains(@class, 'property_add_rooms_done')]");
	public static final By singleRoom_propertyRoomDetails_Lbl = By
			.xpath("//div[contains(@class, 'property_room_details')]");
	public static final String multipleRoom_occupancyIncrease_Btn = "(//div[contains(@class, 'property_plus_minus_container')]/div[contains(@class, 'property_button_plus')])";
	public static final String multipleRoomType_guestCount_WE = "(//div[contains(@class, 'property_plus_minus_container')]/input[contains(@class, 'property_counter_input')])";

	// New details page xpaths
	public static final By breadCrumbsAll_Lnk = By.xpath("//div[@class='breadcrumb breadcrumb-top']/ul/li");
	public static final By breadCrumbsClickable1_Lnk = By
			.xpath("(//div[@class='breadcrumb breadcrumb-top']/ul/li/a)[1]");
	public static final By breadCrumbsClickable2_Lnk = By
			.xpath("(//div[@class='breadcrumb breadcrumb-top']/ul/li/a)[2]");
	public static final By starRating_WE = By
			.xpath("//div[@class='hotel-content clearfix']/div[@class='hotel-review']/div[@class='review-star']/span/span");
	public static final By hotelName_Lbl = By.xpath("//h1");
	public static final By hotelsAdress_Lbl = By.xpath("//div[@class='hotel-title']/p");
	public static final By reviews_Lnk = By
			.xpath("//div[@class='hotel-content clearfix']/div[@class='hotel-review']/div[@class='review-star']/a");
	public static final By lastBooked_Lbl = By.xpath("//div[@class='last-booked']");
	public static final By peopleLooking_Lbl = By.xpath("//div[@class='booking-review-ripple']/p");
	public static final By mainImage_WE = By.id("property_main_banner");
	public static final By smallImages_WE = By.xpath("//ul/li/a/img");
	public static final By moreImages_WE = By.xpath("//span[@class='image_count']/span");
	public static final By hotelNameGallery_Lbl = By.xpath("//div[@class='banner-gallery common_gallery']//h2");
	public static final By closeGallery_Lnk = By.xpath("//a[@class='close-gallery']");
	public static final By rackRate_Lbl = By.xpath("//div[@class='select-room-price']//del");
	public static final By price_Lbl = By.xpath("//div[@class='select-room-price']//strong");
	public static final By onwards_Lbl = By.xpath("//div[@class='select-room-price']//span");
	public static final By selectRooms_Btn = By.id("propertySelectRoom");
	public static final By calanderMiddle_WE = By
			.xpath("//div[@class='datepicker-days']/table[@class='table-condensed']");
	public static final By numberOfRoomsSelectionAll_Btn = By
			.xpath("((//div[@class='room-types-selection'])[1]/div/ul/li)");
	public static final By navigationHeader_WE = By.xpath("//ul[@class='clearfix internal_navigation']/li");
	public static final By whyFabhotels_WE = By.xpath("//div[@class='hotel-overview-left']/h4");
	public static final By bestRevChain_WE = By.xpath("//li[@class='hotel-review-chain']");
	public static final By centrallyLocated_WE = By.xpath("//li[@class='hotel-review-location']");
	public static final By ratings_WE = By.xpath("(//div[@class='hotel-overview-left']/div/div/h4)[1]");
	public static final By ratingsLogo_WE = By
			.xpath("//div[@class='hotel-overview-left']//span[@class='review-star-icon']/span");
	public static final By numericRating_WE = By.xpath("//div[@class='hotel-overview-left']//strong[@class='rated']");
	public static final By ratedVeryGood_WE = By
			.xpath("//div[@class='hotel-overview-left']//div[@class='hotel-overview-rating']/span");
	public static final By topReview_WE = By.xpath("(//div[@class='hotel-overview-left']/div/div/h4)[2]");
	public static final By topReviewValue_WE = By.id("lessReview_11");
	public static final By imageOnMap_WE = By.xpath("//div[@class='property_map_img_inner']");
	public static final By propertyNameOnMap_WE = By.xpath("(//div[@class='property_map_dtl']/strong)[2]");
	public static final By landmarkOnMap_WE = By.xpath("(//div[@class='property_map_dtl']/span[@class='landmark'])[2]");
	public static final By getDirectionOnMap_Lnk = By.xpath("(//span[@class='get-direction']/a)[2]");
	public static final By valueMoney_WE = By.xpath("//li[@class='hotel-review-money-hotel']");
	public static final By allAmenities_WE = By.xpath("//div[@id='amenities']/div/ul");
	public static final By amenities_Lbl = By.xpath("//h2[contains(text(),'Amenities')]");
	public static final By checkAvailability_Lbl = By
			.xpath("//div[@class='checkin-section property_detail_room_types_book_form']/h2");
	public static final By whyThisHotel_Lbl = By.xpath("//div[@id='about']/h2");
	public static final By overviewHeader_Lnk = By.xpath("(//ul[@class='clearfix internal_navigation']//li/a)[1]");
	public static final By amenitiesHeader_Lnk = By.xpath("(//ul[@class='clearfix internal_navigation']//li/a)[2]");
	public static final By roomTypesHeader_Lnk = By.xpath("(//ul[@class='clearfix internal_navigation']//li/a)[3]");
	public static final By whyThisHotelheader_Lnk = By.xpath("(//ul[@class='clearfix internal_navigation']//li/a)[4]");
	public static final By rNrHeader_Lnk = By.xpath("(//ul[@class='clearfix internal_navigation']//li/a)[5]");
	public static final By hotelPoliciesHeader_Lnk = By.xpath("(//ul[@class='clearfix internal_navigation']//li/a)[6]");
	public static final By readMoreDescription_Lnk = By.xpath("//div[@class='why-this-hotel-more']/a");
	public static final By readLessDescription_Lnk = By.xpath("//div[@class='why-this-hotel-less']/a");
	public static final By descriptionExpanded_WE = By.xpath("//div[@class='why-this-hotel-inner']");
	public static final By ratingNReviewsHead_Lbl = By.xpath("//div[@id='reviews']/h2");
	public static final By ratingInRatingBlock_Lbl = By.xpath("(//div[@class='rating-reviews-left']/strong)[1]");
	public static final By reviewsInRatingBlock_Lbl = By.xpath("(//div[@class='rating-reviews-left']/strong)[2]");
	public static final By reviewsInRatingBlockBracket_Lbl = By.xpath("//div[@class='rating-reviews-left']/span");
	public static final By ratingNumbers_Lbl = By.xpath("//div[@class='rating-reviews-point']");
	public static final By starsInRatingBlock_WE = By.xpath("(//div[@class='rating-reviews-listing clearfix']//span[@class='review-star-icon']/span)[1]");
	public static final By ratedInBlock_Lbl = By.xpath("(//div[@class='rating-reviews-user-content']/p)[1]");
	public static final By viewMoreReviews_Lnk = By.id("moreReviewLink");
	public static final By hotelPolicies_Lbl = By.xpath("//div[@id='policies']/h2");
	public static final By cancellationBlock_WE = By.xpath("//div[@class='hotel-policies-left']");
	public static final By checkInCheckOut_WE = By.xpath("//div[@class='hotel-policies-right']");
	public static final By exploreMoreHotels_Lbl = By.xpath("//div[@id='policies']/h2");
	public static final By exploreNearbyTop_WE = By.xpath("((//div[@class='nearby_properties_container'])[1])");
	public static final By imagesNearbyBottom_WE = By.xpath("((//div[@class='nearby_properties_container'])[2]//img)");
	public static final By hotelsNameNearbyBottom_Lnk = By.xpath("//div[@id='policies']/h2");
	public static final By nearByDistance = By
			.xpath("((//div[@class='nearby_properties_container'])[2]//div[@class='location'])[1]");
	public static final By stars_WE = By
			.xpath("((//div[@class='nearby_properties_container'])[2]//span[@class='review-star-icon'])[1]");
	public static final By reviewsNearBy_Lnk = By
			.xpath("((//div[@class='nearby_properties_container'])[2]//div[@class='review-star']/a)[1]");
	public static final By bookingNowNearBy_Lbl = By
			.xpath("((//div[@class='nearby_properties_container'])[2]//div[@class='booking-now'])[1]");
	public static final By priceNearby_Lbl = By
			.xpath("((//div[@class='nearby_properties_container'])[2]//div[@class='price']/span)[1]");
	public static final By chevronLeft_Lnk = By.xpath("(//a[@class='flex-prev'])[1]");
	public static final By chevronRight_Lnk = By.xpath("(//a[@class='flex-prev'])[2]");

	public static final By exploreMoreSectionHeadline_Lbl = By.xpath("(//h2[@class='sub-title'])[2]");
	public static final String roomSelectionRoomTypeNumber_WE = "(//div[@class='room-types-selection'])[";
	public static final String disabledRoomSelectionNumberOfRooms_WE = "//a[@class='outOfStock' and contains(text(),'";
	public static final String roomSelectionNumberOfRooms_WE = "//a[contains(text(),'";

	public static final String peopleDropDowndiv_WE = "(//div[@id='roomtypeid-";
	public static final String peopleDropDownMouseHover_DD = "//div[@class='custom-value-content clearfix'])[";
	public static final String peopleDropDownSelect_DD = "//div[@class='room-listing-dropdown-left'])[";
	public static final String dropDownValue_DD = "//label[text()=' ";

	public static final String roomType_WE = "(//div[@class='room-types-section clearfix'])[";
	public static final String soldOut_Lbl = "//div[text()='Sold Out']";
	public static final String roomsLeft_Lbl = "//div[contains(text(),'left')]";

	public static final By bookNowFooter_Btn = By.xpath("//a[@id='propertyReviewBooking']");
	public static final By roomsSelectedFooter_WE = By.xpath("//div[@id='bookingSummaryRoomTypeDetail']");
	public static final By cityNameNightsFooter_Lbl = By.xpath("//div[@id='booking_summary_final']/span");
	public static final By datesRoomsFooter_Lbl = By
			.xpath("//div[@id='booking_summary_final']/p[@class='datesDetail']");
	public static final By exTaxesFooter_Lbl = By.xpath("//div[@id='booking_summary_final']/p[2]");
	public static final By soldOutErrorMessage_Lbl = By.xpath("//div[@class='room-selection-alert error_msg_alert']");
	public static final By soldOutOnRoomType_Lbl = By
			.xpath("//div[@class='room-types-section-container']/div[text()='Sold Out']");
	public static final By soldOutOnMainImage_Lbl = By.xpath("//div[@id='soldOutMessage']");
	public static final By checkAvailabilityOnTop_Btn = By.xpath("//a[@id='DetailPageBtn']");
	public static final By checkAvailabilityInMiddle_Btn = By.xpath("//a[@id='DetailPageBtn']");
	public static final By roomTypesh2_Lbl = By.xpath("//div[@id='room_type_div']/h2");
	public static final By roomTypesMaxNumbers_Lbl = By.xpath("//div[@id='room_type_div']/h2/strong");

	public static final String roomTypeImages_WE = "(//div[@class='room-pic']/img)[";
	public static final String roomTypeName_Lbl = "(//div[@class='room-content']/h4)[";
	public static final String roomTypesPrices_Lbl = "(//div[@class='room-price'])[";
	public static final String roomTypesMaxGuests_Lbl = "(//div[@class='max-person'])[";
	public static final String roomType_selectDates_Lbl = "(//div[@class='travel-dates']/p)[";
	public static final By whyThisHotelSectionHeadline_Lbl = By.xpath("//div[@id='about']/h2");
	public static final By hotelDescription_WE = By
			.xpath("//div[@class='why-this-hotel-wrap why-this-hotel-inner-less']/p");
	public static final By hotelDescriptionReadMore_Lnk = By.xpath("//div[@class='why-this-hotel-more']/a");
	public static final By writtenReviewsOnPage_Lbl = By.xpath("//div[@class='rating-reviews-listing clearfix']");

	public static String exploreMorePropertiesCard_WE = "((//div[@class='more_properties_inner'])[2]//div[@class='more_properties_single_content'])";
	public static String hotelNameNearby_Lbl = "//h3/a";
	public static String locationNearby_Lbl = "//div[@class='location']";
	public static String reviewsAndRatingNearby_Lbl = "//div[@class='review-star']";
	public static String reviewsOnlyNearby_Lnk = "//div[@class='review-star']";
	public static String peopleBookingNowNearby_Lbl = "//div[@class='booking-now']";
	public static String sellPriceNearBy_Lbl = "//span[@class='new-price']";
	public static String rackPriceNearBy_Lbl = "//span[@class='old-price']/del";
	public static String bookNowNearBy_Btn = "//a[@class='btn']";
	public static String cheveronNextNearby_Btn = "(//div[@class='nearby_properties_container'])[2]//a[@class='flex-next']";
	public static final By hotelPolicies_WE = By.xpath("//div[@id='policies']");
	public static final By searchBox_WE = By.xpath("//input[@name='locationsearch']");
	public static final By firstValueFromLocationSuggestor_Lbl = By.xpath("//div[@class='pac-item'][1]");
	//

	// New Details Page methods
	public void click_firstValueFromLocationSuggestor_Lbl() {
		generic.explicitlyWaitForElement(firstValueFromLocationSuggestor_Lbl);
		generic.click(firstValueFromLocationSuggestor_Lbl);
	}

	public void clear_searchBox_WE() {
		generic.scrollToElement(searchBox_WE, false);
		generic.customPageScrollToBottomInSlowMotion(0, -250);
		generic.clear(searchBox_WE);
	}

	public void fill_searchBox_WE(String value) {
		generic.fill(searchBox_WE, value);
	}

	public String getText_searchBox_WE() {
		return generic.getValue(searchBox_WE);
	}

	public boolean isVisible_hotelPolicies_WE() {
		return generic.isVisible(hotelPolicies_WE);
	}

	public int count_exploreMorePropertiesCard_WE() {
		return generic.getSize(By.xpath(exploreMorePropertiesCard_WE));
	}

	public boolean isVisible_LastExlporeMoreHotel_WE() {
		return generic.isVisible(By.xpath(exploreMorePropertiesCard_WE) + "[last()]");
	}

	public void click_exploreMorePropertiesCard_WE(int i) {
		generic.click(exploreMorePropertiesCard_WE + "[" + i + "]");
	}

	public String getElementText_exploreMorePropertiesCard_WE() {
		return generic.getText(exploreMorePropertiesCard_WE);
	}

	public void click_hotelNameNearby_Lbl(int i) {
		generic.click(exploreMorePropertiesCard_WE + "[" + i + "]" + hotelNameNearby_Lbl);
	}
	
	public String getWidth_starRating_WE(){
		return generic.getAttributeValue(starRating_WE, "style");

	}
	public String getWidth_starsInRatingBlock_WE(){
		return generic.getAttributeValue(starsInRatingBlock_WE, "style");

	}

	public String getLabelText_hotelNameNearby_Lbl(int i) {
		return generic.getText(exploreMorePropertiesCard_WE + "[" + i + "]" + hotelNameNearby_Lbl);
	}

	public void click_locationNearby_Lbl(int i) {
		generic.click(exploreMorePropertiesCard_WE + "[" + i + "]" + locationNearby_Lbl);
	}

	public String getLabelText_locationNearby_Lbl(int i) {
		return generic.getText(exploreMorePropertiesCard_WE + "[" + i + "]" + locationNearby_Lbl);
	}

	public void click_reviewsAndRatingNearby_Lbl(int i) {
		generic.click(exploreMorePropertiesCard_WE + "[" + i + "]" + reviewsAndRatingNearby_Lbl);
	}

	public String getLabelText_reviewsAndRatingNearby_Lbl(int i) {
		return generic.getText(exploreMorePropertiesCard_WE + "[" + i + "]" + reviewsAndRatingNearby_Lbl);
	}

	public void click_reviewsOnlyNearby_Lnk(int i) {
		generic.click(exploreMorePropertiesCard_WE + "[" + i + "]" + reviewsOnlyNearby_Lnk);
	}

	public String getLinkText_reviewsOnlyNearby_Lnk(int i) {
		return generic.getText(exploreMorePropertiesCard_WE + "[" + i + "]" + reviewsOnlyNearby_Lnk);
	}

	public void click_peopleBookingNowNearby_Lbl(int i) {
		generic.click(exploreMorePropertiesCard_WE + "[" + i + "]" + peopleBookingNowNearby_Lbl);
	}

	public String getLabelText_peopleBookingNowNearby_Lbl(int i) {
		return generic.getText(exploreMorePropertiesCard_WE + "[" + i + "]" + peopleBookingNowNearby_Lbl);
	}

	public void click_sellPriceNearBy_Lbl(int i) {
		generic.click(exploreMorePropertiesCard_WE + "[" + i + "]" + sellPriceNearBy_Lbl);
	}

	public String getLabelText_sellPriceNearBy_Lbl(int i) {
		return generic.getText(exploreMorePropertiesCard_WE + "[" + i + "]" + sellPriceNearBy_Lbl);
	}

	public void click_rackPriceNearBy_Lbl(int i) {
		generic.click(exploreMorePropertiesCard_WE + "[" + i + "]" + rackPriceNearBy_Lbl);
	}

	public String getLabelText_rackPriceNearBy_Lbl(int i) {
		if (!driver.findElement(By.xpath(exploreMorePropertiesCard_WE + "[" + i + "]" + rackPriceNearBy_Lbl))
				.isDisplayed()) {
			return "ABCDEF";
		} else
			return generic.getText(exploreMorePropertiesCard_WE + "[" + i + "]" + rackPriceNearBy_Lbl);
	}

	public void click_bookNowNearBy_Btn(int i) {
		generic.scrollToElement(By.xpath(exploreMorePropertiesCard_WE + "[" + i + "]" + bookNowNearBy_Btn), false);
		generic.click(exploreMorePropertiesCard_WE + "[" + i + "]" + bookNowNearBy_Btn);
	}

	public boolean isVisible_bookNowNearBy_Btn(int i) {
		return generic.isVisible(exploreMorePropertiesCard_WE + "[" + i + "]" + bookNowNearBy_Btn);
	}

	public void click_cheveronNextNearby_Btn() {
		generic.click(cheveronNextNearby_Btn);
	}

	public int writtenReviewsCount() {
		return driver.findElements(writtenReviewsOnPage_Lbl).size();
	}

	public String getText_roomTypeImages_WE(int roomTypeNumber) {
		return generic.getText(roomTypeImages_WE + roomTypeNumber + "]");
	}

	public String getText_roomTypeName_Lbl(int roomTypeNumber) {
		return generic.getText(roomTypeName_Lbl + roomTypeNumber + "]");
	}

	public String getText_roomTypesPrices_Lbl(int roomTypeNumber) {
		return generic.getText(roomTypesPrices_Lbl + roomTypeNumber + "]");
	}

	public String getText_roomTypesMaxGuests_Lbl(int roomTypeNumber) {
		return generic.getText(roomTypesMaxGuests_Lbl + roomTypeNumber + "]");
	}

	public String getText_roomType_selectDates_Lbl(int roomTypeNumber) {
		return generic.getText(roomType_selectDates_Lbl + roomTypeNumber + "]");
	}

	public String getLabelText_roomTypesMaxNumbers_Lbl() {
		return generic.getText(roomTypesMaxNumbers_Lbl);
	}

	public String getLabelText_soldOutErrorMessage_Lbl() {
		return generic.getText(soldOutErrorMessage_Lbl);
	}

	public String getLabelText_soldOutOnMainImage_Lbl() {
		return generic.getText(soldOutOnMainImage_Lbl);
	}

	public void selectPeopleDropDown(int roomType, int roomNumber, int people) {
		generic.scrollToElement(
				By.xpath(peopleDropDowndiv_WE + roomType + "']" + peopleDropDownMouseHover_DD + roomNumber + "]"),
				true);
		generic.customPageScrollToBottomInSlowMotion(0, -150);
		generic.performMouseHover(
				peopleDropDowndiv_WE + roomType + "']" + peopleDropDownMouseHover_DD + roomNumber + "]");
		generic.clickJS(peopleDropDowndiv_WE + roomType + "']" + peopleDropDownSelect_DD + roomNumber + "]"
				+ dropDownValue_DD + people + " Adults " + "']");
	}

	public Boolean isVisible_exploreNearbyTop_WE() {
		return generic.isVisible(exploreNearbyTop_WE);
	}

	public Boolean isDisabled_selectRoomsDisabled_Btn() {
		String className = generic.getAttributeValue(selectRooms_Btn, "class");
		System.out.println(className);
		if (className.equals("btn property_detail_select_rooms_button  property_book_now_disabled")) {
			return true;
		} else
			return false;
	}

	public void click_bookNowFooter_Btn() {
		generic.click(bookNowFooter_Btn);
	}

	public void click_checkAvailabilityOnTop_Btn() {
		generic.click(checkAvailabilityOnTop_Btn);
	}

	public void click_checkAvailabilityInMiddle_Btn() {
		generic.click(checkAvailabilityInMiddle_Btn);
	}

	public void click_roomsSelectedFooter_WE() {
		generic.click(roomsSelectedFooter_WE);
	}

	public String getElementText_roomsSelectedFooter_WE() {
		return generic.getText(roomsSelectedFooter_WE);

	}

	public void click_cityNameNightsFooter_Lbl() {
		generic.click(cityNameNightsFooter_Lbl);
	}

	public String getLabelText_cityNameNightsFooter_Lbl() {
		return generic.getText(cityNameNightsFooter_Lbl);
	}

	public void click_datesRoomsFooter_Lbl() {
		generic.click(datesRoomsFooter_Lbl);
	}

	public String getLabelText_datesRoomsFooter_Lbl() {
		return generic.getText(datesRoomsFooter_Lbl);
	}

	public void click_exTaxesFooter_Lbl() {
		generic.click(exTaxesFooter_Lbl);
	}

	public String getLabelText_exTaxesFooter_Lbl() {
		return generic.getText(exTaxesFooter_Lbl);
	}

	public boolean isSoldOut_roomType(int roomType) {
		return generic.isVisible(roomType_WE + roomType + "]" + soldOut_Lbl);
	}

	public String getText_roomsLeft_roomType(int roomNumber) {
		return generic.getText(roomType_WE + roomNumber + "]" + roomsLeft_Lbl);
	}

	public boolean isVisible_roomsLeft_roomType(int roomNumber) {
		return generic.isVisible(roomType_WE + roomNumber + "]" + roomsLeft_Lbl);
	}

	public boolean isDisabled_roomNumber(int roomType, int roomNumber) {
		return generic.isVisible(roomSelectionRoomTypeNumber_WE + roomType + "]" + disabledRoomSelectionNumberOfRooms_WE
				+ roomNumber + "')]");
	}

	public boolean isEnabled_roomNumber(int roomType, int roomNumber) {
		return generic.isVisible(
				roomSelectionRoomTypeNumber_WE + roomType + "]" + roomSelectionNumberOfRooms_WE + roomNumber + "')]");
	}

	public void click_roomNumber(int roomType, int roomNumber) {
		generic.clickJS(
				roomSelectionRoomTypeNumber_WE + roomType + "]" + roomSelectionNumberOfRooms_WE + roomNumber + "')]");
	}

	public void click_breadCrumbsAll_Lnk() {
		generic.click(breadCrumbsAll_Lnk);
	}

	public boolean isVisible_starRating_WE() {
		return generic.isVisible(starRating_WE);
	}

	public boolean isVisible_soldOutOnRoomType_Lbl() {
		return generic.isVisible(soldOutOnRoomType_Lbl);
	}

	public String getLinkText_breadCrumbsAll_Lnk() {
		return generic.getText(breadCrumbsAll_Lnk);
	}

	public void click_breadCrumbsClickable1_Lnk() {
		generic.click(breadCrumbsClickable1_Lnk);
	}

	public String getLinkText_breadCrumbsClickable2_Lnk() {
		return generic.getText(breadCrumbsClickable2_Lnk);
	}

	public void click_breadCrumbsClickable2_Lnk() {
		generic.click(breadCrumbsClickable2_Lnk);
	}

	public String getLinkText_breadCrumbsClickable1_Lnk() {
		return generic.getText(breadCrumbsClickable1_Lnk);
	}

	public void click_starRating_WE() {
		generic.click(starRating_WE);
	}

	public String getElementText_starRating_WE() {
		return generic.getText(starRating_WE);

	}

	public void click_hotelName_Lbl() {
		generic.click(hotelName_Lbl);
	}

	public String getLabelText_hotelName_Lbl() {
		return generic.getText(hotelName_Lbl);
	}

	public void click_hotelsAdress_Lbl() {
		generic.click(hotelsAdress_Lbl);
	}

	public String getLabelText_hotelsAdress_Lbl() {
		return generic.getText(hotelsAdress_Lbl);
	}

	public void click_reviews_Lnk() {
		generic.click(reviews_Lnk);
	}

	public String getLinkText_reviews_Lnk() {
		return generic.getText(reviews_Lnk);
	}

	public void click_lastBooked_Lbl() {
		generic.click(lastBooked_Lbl);
	}

	public String getLabelText_lastBooked_Lbl() {
		return generic.getText(lastBooked_Lbl);
	}

	public boolean isVisible_lastBooked_Lbl() {
		return generic.isVisible(lastBooked_Lbl);
	}

	public boolean isVisible_peopleLooking_Lbl() {
		return generic.isVisible(peopleLooking_Lbl);
	}

	public boolean isVisible_calanderMiddle_WE() {
		return generic.isVisible(calanderMiddle_WE);
	}

	public boolean isVisible_rackRate_Lbl() {
		return generic.isVisible(rackRate_Lbl);
	}

	public boolean isVisible_numberOfRoomsSelectionAll_Btn() {
		return generic.isVisible(numberOfRoomsSelectionAll_Btn);
	}

	public void click_peopleLooking_Lbl() {
		generic.click(peopleLooking_Lbl);
	}

	public String getLabelText_peopleLooking_Lbl() {
		return generic.getText(peopleLooking_Lbl);
	}

	public String getLabelText_hotelNameGallery_Lbl() {
		return generic.getText(hotelNameGallery_Lbl);
	}

	public boolean isVisible_hotelNameGallery_Lbl() {
		return generic.isVisible(hotelNameGallery_Lbl);
	}

	public void click_mainImage_WE() {
		generic.click(mainImage_WE);
	}

	public String getElementText_mainImage_WE() {
		return generic.getText(mainImage_WE);

	}

	public void click_smallImages_WE() {
		generic.click(smallImages_WE);
	}

	public String getElementText_smallImages_WE() {
		return generic.getText(smallImages_WE);

	}

	public void click_moreImages_WE() {
		generic.click(moreImages_WE);
	}

	public String getElementText_moreImages_WE() {
		return generic.getText(moreImages_WE);

	}

	public void click_rackRate_Lbl() {
		generic.click(rackRate_Lbl);
	}

	public String getLabelText_rackRate_Lbl() {
		return generic.getText(rackRate_Lbl);
	}

	public void click_price_Lbl() {
		generic.click(price_Lbl);
	}

	public String getLabelText_price_Lbl() {
		return generic.getText(price_Lbl);
	}

	public void click_onwards_Lbl() {
		generic.click(onwards_Lbl);
	}

	public String getLabelText_onwards_Lbl() {
		return generic.getText(onwards_Lbl);
	}

	public void click_selectRooms_Btn() {
		generic.click(selectRooms_Btn);
	}

	public void click_navigationHeader_WE() {
		generic.click(navigationHeader_WE);
	}

	public String getElementText_navigationHeader_WE() {
		return generic.getText(navigationHeader_WE);

	}

	public void click_whyFabhotels_WE() {
		generic.click(whyFabhotels_WE);
	}

	public String getElementText_whyFabhotels_WE() {
		return generic.getText(whyFabhotels_WE);

	}

	public void click_bestRevChain_WE() {
		generic.click(bestRevChain_WE);
	}

	public String getElementText_bestRevChain_WE() {
		return generic.getText(bestRevChain_WE);

	}

	public void click_centrallyLocated_WE() {
		generic.click(centrallyLocated_WE);
	}

	public String getElementText_centrallyLocated_WE() {
		return generic.getText(centrallyLocated_WE);

	}

	public void click_ratings_WE() {
		generic.click(ratings_WE);
	}

	public String getElementText_ratings_WE() {
		return generic.getText(ratings_WE);

	}

	public void click_ratingsLogo_WE() {
		generic.click(ratingsLogo_WE);
	}

	public boolean isVisible_ratingsLogo_WE() {
		return generic.isVisible(ratingsLogo_WE);
	}

	public String getElementText_ratingsLogo_WE() {
		return generic.getText(ratingsLogo_WE);

	}
	public String getWidth_ratingsLogo_WE(){
		return generic.getAttributeValue((ratingsLogo_WE), "style");

	}

	public void click_numericRating_WE() {
		generic.click(numericRating_WE);
	}

	public String getElementText_numericRating_WE() {
		return generic.getText(numericRating_WE);

	}

	public void click_ratedVeryGood_WE() {
		generic.click(ratedVeryGood_WE);
	}

	public String getElementText_ratedVeryGood_WE() {
		return generic.getText(ratedVeryGood_WE);

	}

	public void click_topReview_WE() {
		generic.click(topReview_WE);
	}

	public String getElementText_topReview_WE() {
		return generic.getText(topReview_WE);

	}

	public void click_topReviewValue_WE() {
		generic.click(topReviewValue_WE);
	}

	public String getElementText_topReviewValue_WE() {
		return generic.getText(topReviewValue_WE);

	}

	public void click_imageOnMap_WE() {
		generic.click(imageOnMap_WE);
	}

	public String getElementText_imageOnMap_WE() {
		return generic.getText(imageOnMap_WE);

	}

	public void click_propertyNameOnMap_WE() {
		generic.click(propertyNameOnMap_WE);
	}

	public String getElementText_propertyNameOnMap_WE() {
		return generic.getText(propertyNameOnMap_WE);

	}

	public void click_landmarkOnMap_WE() {
		generic.click(landmarkOnMap_WE);
	}

	public String getElementText_landmarkOnMap_WE() {
		return generic.getText(landmarkOnMap_WE);

	}

	public void click_getDirectionOnMap_Lnk() {
		generic.click(getDirectionOnMap_Lnk);
	}

	public String getLinkText_getDirectionOnMap_Lnk() {
		return generic.getText(getDirectionOnMap_Lnk);
	}

	public void click_valueMoney_WE() {
		generic.click(valueMoney_WE);
	}

	public String getElementText_valueMoney_WE() {
		return generic.getText(valueMoney_WE);

	}

	public void click_allAmenities_WE() {
		generic.click(allAmenities_WE);
	}

	public String getElementText_allAmenities_WE() {
		return generic.getText(allAmenities_WE);

	}

	public void click_amenities_Lbl() {
		generic.click(amenities_Lbl);
	}

	public String getLabelText_amenities_Lbl() {
		return generic.getText(amenities_Lbl);
	}

	public void click_checkAvailability_Lbl() {
		generic.click(checkAvailability_Lbl);
	}

	public String getLabelText_checkAvailability_Lbl() {
		return generic.getText(checkAvailability_Lbl);
	}

	public void click_whyThisHotel_Lbl() {
		generic.click(whyThisHotel_Lbl);
	}

	public String getLabelText_whyThisHotel_Lbl() {
		return generic.getText(whyThisHotel_Lbl);
	}

	public void click_overviewHeader_Lnk() {
		generic.click(overviewHeader_Lnk);
	}

	public String getLinkText_overviewHeader_Lnk() {
		return generic.getText(overviewHeader_Lnk);
	}

	public void click_amenitiesHeader_Lnk() {
		generic.click(amenitiesHeader_Lnk);
	}

	public String getLinkText_amenitiesHeader_Lnk() {
		return generic.getText(amenitiesHeader_Lnk);
	}

	public void click_roomTypesHeader_Lnk() {
		generic.click(roomTypesHeader_Lnk);
	}

	public String getLinkText_roomTypesHeader_Lnk() {
		return generic.getText(roomTypesHeader_Lnk);
	}

	public void click_whyThisHotelheader_Lnk() {
		generic.click(whyThisHotelheader_Lnk);
	}

	public String getLinkText_whyThisHotelheader_Lnk() {
		return generic.getText(whyThisHotelheader_Lnk);
	}

	public void click_rNrHeader_Lnk() {
		generic.click(rNrHeader_Lnk);
	}

	public String getLinkText_rNrHeader_Lnk() {
		return generic.getText(rNrHeader_Lnk);
	}

	public void click_hotelPoliciesHeader_Lnk() {
		generic.click(hotelPoliciesHeader_Lnk);
	}

	public String getLinkText_hotelPoliciesHeader_Lnk() {
		return generic.getText(hotelPoliciesHeader_Lnk);
	}

	public void click_readMoreDescription_Lnk() {
		generic.click(readMoreDescription_Lnk);
	}

	public String getLinkText_readMoreDescription_Lnk() {
		return generic.getText(readMoreDescription_Lnk);
	}

	public void click_descriptionExpanded_WE() {
		generic.click(descriptionExpanded_WE);
	}

	public String getElementText_descriptionExpanded_WE() {
		return generic.getText(descriptionExpanded_WE);

	}

	public void click_ratingNReviewsHead_Lbl() {
		generic.click(ratingNReviewsHead_Lbl);
	}

	public String getLabelText_ratingNReviewsHead_Lbl() {
		return generic.getText(ratingNReviewsHead_Lbl);
	}

	public void click_ratingInRatingBlock_Lbl() {
		generic.click(ratingInRatingBlock_Lbl);
	}

	public String getLabelText_ratingInRatingBlock_Lbl() {
		return generic.getText(ratingInRatingBlock_Lbl);
	}

	public void click_reviewsInRatingBlock_Lbl() {
		generic.click(reviewsInRatingBlock_Lbl);
	}

	public String getLabelText_reviewsInRatingBlock_Lbl() {
		return generic.getText(reviewsInRatingBlock_Lbl);
	}

	public void click_reviewsInRatingBlockBracket_Lbl() {
		generic.click(reviewsInRatingBlockBracket_Lbl);
	}

	public String getLabelText_reviewsInRatingBlockBracket_Lbl() {
		return generic.getText(reviewsInRatingBlockBracket_Lbl);
	}

	public void click_ratingNumbers_Lbl() {
		generic.click(ratingNumbers_Lbl);
	}

	public String getLabelText_ratingNumbers_Lbl() {
		return generic.getText(ratingNumbers_Lbl);
	}

	public void click_starsInRatingBlock_WE() {
		generic.click(starsInRatingBlock_WE);
	}

	public String getElementText_starsInRatingBlock_WE() {
		return generic.getText(starsInRatingBlock_WE);

	}

	public void click_ratedInBlock_Lbl() {
		generic.click(ratedInBlock_Lbl);
	}

	public String getLabelText_ratedInBlock_Lbl() {
		return generic.getText(ratedInBlock_Lbl);
	}

	public void click_viewMoreReviews_Lnk() {
		generic.click(viewMoreReviews_Lnk);
	}

	public String getLinkText_viewMoreReviews_Lnk() {
		return generic.getText(viewMoreReviews_Lnk);
	}

	public void click_hotelPolicies_Lbl() {
		generic.click(hotelPolicies_Lbl);
	}

	public String getLabelText_hotelPolicies_Lbl() {
		return generic.getText(hotelPolicies_Lbl);
	}

	public void click_cancellationBlock_WE() {
		generic.click(cancellationBlock_WE);
	}

	public String getElementText_cancellationBlock_WE() {
		return generic.getText(cancellationBlock_WE);

	}

	public void click_checkInCheckOut_WE() {
		generic.click(checkInCheckOut_WE);
	}

	public String getElementText_checkInCheckOut_WE() {
		return generic.getText(checkInCheckOut_WE);

	}

	public void click_exploreMoreHotels_Lbl() {
		generic.click(exploreMoreHotels_Lbl);
	}

	public void click_closeGallery_Lnk() {
		generic.click(closeGallery_Lnk);
	}

	public String getLabelText_exploreMoreHotels_Lbl() {
		return generic.getText(exploreMoreHotels_Lbl);
	}

	public String getLabelText_exploreMoreSectionHeadline_Lbl() {
		return generic.getText(exploreMoreSectionHeadline_Lbl);
	}

	public void click_readMore_Lnk() {
		generic.click(hotelDescriptionReadMore_Lnk);
	}

	public String getLinkText_readMore_Lnk() {
		return generic.getText(hotelDescriptionReadMore_Lnk);
	}

	public void click_readLess_Lnk() {
		generic.click(readLessDescription_Lnk);
	}

	public String getLinkText_readLess_Lnk() {
		return generic.getText(readLessDescription_Lnk);
	}

	public void click_imagesNearbyBottom_WE() {
		generic.click(imagesNearbyBottom_WE);
	}

	public String getElementText_imagesNearbyBottom_WE() {
		return generic.getText(imagesNearbyBottom_WE);

	}

	public void click_hotelsNameNearbyBottom_Lnk() {
		generic.click(hotelsNameNearbyBottom_Lnk);
	}

	public String getLinkText_hotelsNameNearbyBottom_Lnk() {
		return generic.getText(hotelsNameNearbyBottom_Lnk);
	}

	public void click_stars_WE() {
		generic.click(stars_WE);
	}

	public String getElementText_stars_WE() {
		return generic.getText(stars_WE);

	}

	public void click_reviewsNearBy_Lnk() {
		generic.click(reviewsNearBy_Lnk);
	}

	public String getLinkText_reviewsNearBy_Lnk() {
		return generic.getText(reviewsNearBy_Lnk);
	}

	public void click_bookingNowNearBy_Lbl() {
		generic.click(bookingNowNearBy_Lbl);
	}

	public String getLabelText_bookingNowNearBy_Lbl() {
		return generic.getText(bookingNowNearBy_Lbl);
	}

	public void click_priceNearby_Lbl() {
		generic.click(priceNearby_Lbl);
	}

	public String getLabelText_priceNearby_Lbl() {
		return generic.getText(priceNearby_Lbl);
	}

	public void click_chevronLeft_Lnk() {
		generic.click(chevronLeft_Lnk);
	}

	public String getLinkText_chevronLeft_Lnk() {
		return generic.getText(chevronLeft_Lnk);
	}

	public void click_chevronRight_Lnk() {
		generic.click(chevronRight_Lnk);
	}

	public String getLinkText_chevronRight_Lnk() {
		return generic.getText(chevronRight_Lnk);
	}

	public static final String checkInDate1_WE = "(//div[contains(@class, 'datepicker-checkin')]//td[text()='";
	public static final String checkInDate2_WE = "'])[1]"; // [@class='day']";

	public static final String checkOutDate1_WE = "(//div[contains(@class, 'datepicker-checkout')]//td[text()='";
	public static final String checkOutDate2_WE = "'])[1]"; // [@class='day']";

	// public static final String selectRooms_Btn =
	// "//div[@class='property_booking_form_detail
	// multi_room_type_detail']//a[text()='Select Rooms']";
	public static final By selectRoomsHref_Btn = By.xpath("//a[@href='#availability']");

	public String GetText_CheckInDate_WE() {
		return generic.getValue(checkIn_Date_WE);
	}

	public String GetText_CheckOutDate_WE() {
		return generic.getValue(checkOut_Date_WE);
	}

	public String getText_totalAmounnt_Lbl() {
		return generic.getText(totalAmounnt_Lbl);
	}

	public String getText_SingleRoom_getRoomCountAndNightCount_Lbl() {
		return generic.getText(SingleRoom_getRoomCountAndNightCount_Lbl);
	}

	public String getText_multipleRoom_getRoomAndNightCount_Lbl() {
		return generic.getText(multipleRoom_getRoomAndNightCount_Lbl);
	}

	public String getText_SingleRoom_getRoomCountAndGuestCount_Lbl() {
		return generic.getText(SingleRoom_getRoomCountAndGuestCount_Lbl);
	}

	public int getSize_multipleRoomPropertyRoomType_WE() {
		return 5;// generic.getSize(multipleRoomPropertyRoomType_WE);
	}

	public String getText_multipleRoom_SoldOutMssgForIndividualRoomType_Lbl() {
		return generic.getText(multipleRoom_SoldOutMssgForIndividualRoomType_Lbl);
	}

	public void click_addRoomForIndividualRoomType_Lbl() {
		generic.click(addRoomForIndividualRoomType_Lbl);
	}

	public void Select_CheckIn_CheckOut_Date_WE(String checkindate, String checkoutdate) {
		if (checkindate.length() < 1)
			return;
		generic.click(checkIn_Date_WE);
		String str[] = checkindate.split("\\s+");
		while (!generic.getText(currentMonth_WE).equalsIgnoreCase(str[1] + " " + str[2]))
			generic.click(nextMonthClick_WE);
		if (str[0].startsWith("0")) {
			str[0] = str[0].substring(1, str[0].length());
		}
		generic.click("(" + checkInCalenderDates_WE + "[text()='" + str[0] + "']" + ")[1]");
		if (checkoutdate.length() < 1)
			return;
		String strr[] = checkoutdate.split("\\s+");
		while (!generic.getText(nextMonth_WE).equals(strr[1] + " " + strr[2]))
			generic.click(nextMonthClick_WE);
		if (strr[0].startsWith("0")) {
			strr[0] = strr[0].substring(1, strr[0].length());
		}
		generic.click("(" + checkOutCalenderDates_WE + "[text()='" + strr[0] + "']" + ")[1]");
	}

	public String getValue_singlePropertyRoomCount_WE() {
		return generic.getText(singlePropertyRoomCount_WE);
	}

	public String getText_availability_error_msg_Lbl() {
		return generic.getText(availability_error_msg_Lbl);
	}

	public void click_bookNow_Btn() {
		generic.click(bookNow_Btn);
	}

	public String getText_bookNow_Btn() {
		return generic.getText(bookNow_Btn);
	}

	public void visible_dropDown_Btn() {
		generic.isVisible(dropDown_Btn);
	}

	public int webElementsCount_soldOutCout_Lbl() {
		return generic.findElements(soldOutCout_Lbl).size();
	}

	public int getSize_oneRoomLeftMssg_Lbl() {
		return 5;// generic.getSize(oneRoomLeftMssg_Lbl);
	}

	public String getText_multipleRoomType_totalPriceForAllRooms_WE() {
		return generic.getText(multipleRoomType_totalPriceForAllRooms_WE);
	}

	public void click_singleRoom_propertyRoomDetails_Btn() {
		generic.click(singleRoom_propertyRoomDetails_Btn);
	}

	public void click_singleRoom_occupanyIncrease_Btn() {
		generic.click(singleRoom_occupanyIncrease_Btn);
	}

	public void click_singleRoom_propertyAddRoomsDone_Btn() {
		generic.click(singleRoom_propertyAddRoomsDone_Btn);
	}

	public String getText_singleRoom_propertyRoomDetails_Lbl() {
		return generic.getText(singleRoom_propertyRoomDetails_Lbl);
	}

	public void singleRoomTypePricecomparison(double detailFinalAmount, String paymentPageTotalAmount,
			double paymentPageFinalAmount, double detailPageTotalPrice, double taxAmount) throws InterruptedException {
		PaymentPage paymentPage = new PaymentPage(driver, generic);
		Thread.sleep(3000L);
		paymentPageTotalAmount = paymentPage.getText_taxPercent_Lbl();
		Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(paymentPageTotalAmount);
		while (m.find()) {
			detailFinalAmount = Double.parseDouble(m.group(1));
		}
		detailFinalAmount = (detailFinalAmount / 100) * detailPageTotalPrice;
		detailFinalAmount = Math.ceil(detailFinalAmount);
		taxAmount = Double.parseDouble(paymentPage.getText_taxAmount_Lbl());
		Assert.assertEquals(taxAmount, detailFinalAmount, "Tax amount is not matched !! Prices are not correct !!");
		detailFinalAmount = detailFinalAmount + detailPageTotalPrice;
		paymentPageFinalAmount = Double.parseDouble(paymentPage.getText_finalAmount_Lbl());
		Assert.assertEquals(detailFinalAmount, paymentPageFinalAmount, "Final amount is not accurate !!");
	}

	public void Positive_CheckInCheckOutDateWE() {
		// LocalDate todayDate = LocalDate.now();
		// String nextDate = todayDate.plusDays(1).toString();
		LocalDate todayDate1 = LocalDate.now();
		String todayDate = todayDate1.plusDays(2).toString();
		String nextDate = todayDate1.plusDays(3).toString();
		// System.out.println(todayDate+" , "+nextDate);
		generic.click(checkIn_Date_WE);
		String spiltTodayDate[] = todayDate.toString().split("-");
		// System.out.println(spiltTodayDate[0]+","+spiltTodayDate[1]+","+spiltTodayDate[2]);
		// System.out.println(checkInDate1_WE+spiltTodayDate[2].replaceFirst("0",
		// "")+checkInDate2_WE);
		generic.click(checkInDate1_WE + spiltTodayDate[2].replaceFirst("0", "") + checkInDate2_WE);
		String spiltNextDate[] = nextDate.toString().split("-");
		generic.click(checkOutDate1_WE + spiltNextDate[2].replaceFirst("0", "") + checkOutDate2_WE);

		// generic.click(selectRooms_Btn);
		// generic.click(selectRoomsHref_Btn);
		generic.click(bookNow_Btn);
	}

	//

}