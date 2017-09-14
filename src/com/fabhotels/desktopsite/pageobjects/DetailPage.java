package com.fabhotels.desktopsite.pageobjects;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;


public class DetailPage {
	WebDriver driver;
	GenericFunctions generic;


	public DetailPage (WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;		
	}


	public static final By checkIn_Date_WE = By.id("checkIn");
	public static final By checkOut_Date_WE = By.id("checkOut");
	public static final By currentMonth_WE = By.xpath("(//div[@class='datepicker-days']//th[@class='switch'])[1]");
	public static final By nextMonth_WE = By.xpath("(//div[@class='datepicker-days']//th[@class='switch'])[2]");
	public static final By nextMonthClick_WE = By.xpath("(//div[@class='datepicker-days']//th[@class='next'])[1]");
	public static final String checkInCalenderDates_WE = "//div[contains(@class, 'datepicker-checkin')]//td";
	public static final String checkOutCalenderDates_WE = "//div[contains(@class, 'datepicker-checkout')]//td";
	public static final String calender_dates_String_WE = "//div[@class='datepicker-days']//td";
	public static final By singlePropertyRoomCount_WE = By.xpath("(//input[contains(@class, 'property_counter_input')])[1]");
	public static final By availability_error_msg_Lbl = By.xpath("//p[contains(@class,'availability_error_msg')]");
	public static final By propertyName_Lbl = By.xpath("//div[@class='property_name']/h1");
	public static final By propertyReview_Lbl = By.xpath("//a[contains(text(), 'Rated Very Good across')]");
	public static final By SingleRoom_getRoomCountAndGuestCount_Lbl = By.xpath("//div[contains(text(),'Room /')]");
	public static final By multipleRoomPropertyRoomType_WE = By.xpath("//div[contains(@class, 'property_room_type_single')]");
	public static final By multipleRoom_SoldOutMssgForIndividualRoomType_Lbl = By.xpath("//div[@class='property_room_type_desc']/p");
	public static final By addRoomForIndividualRoomType_Lbl = By.xpath("(//div[contains(@class, 'property_button_plus')])[1]");
	public static final String singleRoom_addRoomForIndividualRoomType_Lbl = "(//div[contains(@class, 'property_button_plus')])";
	public static final String dropDown_Btn = "(//div[contains(text(),'Room /')]/..//span)[1]";
	public static final By availabilityErrMsg_Lbl = By.xpath("//p[contains(text(),'rooms left')]");
	public static final By bookNow_Btn = By.id("propertyReviewBooking");
	//	public static final String bookNow_Btn = "//button[@id='propertyReviewBooking']";
	public static final By totalAmounnt_Lbl = By.id("total_amount");
	public static final By SingleRoom_getRoomCountAndNightCount_Lbl = By.xpath("//span[@class='property_room_nights']");
	public static final By multipleRoom_getRoomAndNightCount_Lbl = By.xpath("//div[contains(@class, 'property_booking_total_summary')]");
	public static final By soldOutCout_Lbl = By.xpath("//p[contains(text(), 'Sold Out')]");
	public static final By oneRoomLeftMssg_Lbl = By.xpath("//p[contains(text(),'1 room left')]");
	public static final String multipleRoom_OneRoomLeftMssg_Lbl = "//p[contains(text(),'1 room left')]";
	public static final String multipleRoomType_roomCount_WE = "(//div[contains(@class, 'property_room_type_rooms')]/input[@class='property_counter_input'])";
	public static final String multipleRoomType_soldOutMssg_WE = "(//div[@class='property_room_type_desc']/p[@class='property_room_type_rooms_remaining'])";
	public static final String multipleRooomType_propertyPlusButton_WE = "(//div[contains(@class, 'property_room_type_rooms')]/div[contains(@class, 'property_button_plus')])";
	public static final String multipleRoomType_individualPropertyPrice_WE = "(//span[contains(@class, 'room_type_per_night_amount')])";
	public static final By multipleRoomType_totalPriceForAllRooms_WE = By.xpath("//span[contains(@class, 'property_booking_total_amount')]");
	public static final By singleRoom_propertyRoomDetails_Btn = By.xpath("//span[contains(@class, 'property_room_details_bg')]");
	public static final By singleRoom_occupanyIncrease_Btn = By.xpath("(//div[contains(@class, 'property_button_plus')])[2]");
	public static final By singleRoom_propertyAddRoomsDone_Btn = By.xpath("//div[contains(@class, 'property_add_rooms_done')]");
	public static final By singleRoom_propertyRoomDetails_Lbl = By.xpath("//div[contains(@class, 'property_room_details')]");
	public static final String multipleRoom_occupancyIncrease_Btn = "(//div[contains(@class, 'property_plus_minus_container')]/div[contains(@class, 'property_button_plus')])";
	public static final String multipleRoomType_guestCount_WE = "(//div[contains(@class, 'property_plus_minus_container')]/input[contains(@class, 'property_counter_input')])";

	//New details page xpaths
	public static final By breadCrumbsAll_Lnk = By.xpath("//div[@class='breadcrumb breadcrumb-top']/ul/li");
	public static final By breadCrumbsClickable_Lnk = By.xpath("//div[@class='breadcrumb breadcrumb-top']/ul/li/a");
	public static final By starRating_WE = By.xpath("//div[@class='hotel-content clearfix']/div[@class='hotel-review']/div[@class='review-star']/span");
	public static final By hotelName_Lbl = By.xpath("//h1");
	public static final By hotelsAdress_Lbl = By.xpath("//div[@class='hotel-title']/p");
	public static final By reviews_Lnk = By.xpath("//div[@class='hotel-content clearfix']/div[@class='hotel-review']/div[@class='review-star']/a");
	public static final By lastBooked_Lbl = By.xpath("//div[@class='last-booked']");
	public static final By peopleLooking_Lbl = By.xpath("//p[@class='people-looking']");
	public static final By mainImage_WE = By.id("property_main_banner");
	public static final By smallImages_WE = By.xpath("//ul/li/a/img");
	public static final By moreImages_WE = By.id("//span[@class='image_count']/span");
	public static final By rackRate_Lbl = By.xpath("//div[@class='select-room-price']//del");
	public static final By price_Lbl = By.xpath("//div[@class='select-room-price']//strong");
	public static final By onwards_Lbl = By.xpath("//div[@class='select-room-price']//span");
	public static final By selectRooms_Btn = By.id("propertySselectRoom");
	public static final By navigationHeader_WE = By.xpath("//ul[@class='clearfix internal_navigation']/li");
	public static final By whyFabhotels_WE = By.xpath("//div[@class='hotel-overview-left']/h4");
	public static final By bestRevChain_WE = By.xpath("//li[@class='hotel-review-chain']");
	public static final By centrallyLocated_WE = By.xpath("//li[@class='hotel-review-location']");
	public static final By ratings_WE = By.xpath("(//div[@class='hotel-overview-left']/div/div/h4)[1]");
	public static final By ratingsLogo_WE = By.xpath("//div[@class='hotel-overview-left']//span[@class='review-star-icon']");
	public static final By numericRating_WE = By.xpath("//div[@class='hotel-overview-left']//strong[@class='rated']");
	public static final By ratedVeryGood_WE = By.xpath("//div[@class='hotel-overview-left']//div[@class='hotel-overview-rating']/span");
	public static final By topReview_WE= By.xpath("(//div[@class='hotel-overview-left']/div/div/h4)[2]");
	public static final By topReviewValue_WE = By.id("lessReview_11");
	public static final By imageOnMap_WE = By.xpath("//div[@class='property_map_img_inner']");
	public static final By propertyNameOnMap_WE = By.xpath("//div[@class='property_map_dtl']/strong");
	public static final By landmarkOnMap_WE = By.xpath("//div[@class='property_map_dtl']/span[@class='landmark']");
	public static final By getDirectionOnMap_Lnk = By.xpath("//div[@class='property_map_dtl']/span[@class='get-direction']");
	public static final By valueMoney_WE = By.xpath("//li[@class='hotel-review-money-hotel']");
	public static final By allAmenities_WE = By.xpath("//li[@class='hotel-review-money-hotel']");
	public static final By amenities_Lbl = By.xpath("//h2[contains(text(),'Amenities')]");
	public static final By checkAvailability_Lbl = By.xpath("//div[@class='checkin-section property_detail_room_types_book_form']/h2");
	public static final By whyThisHotel_Lbl = By.xpath("//div[@id='about']/h2");

	public static final By overviewHeader_Lnk = By.xpath("(//ul[@class='clearfix internal_navigation']//li/a)[1]");
	public static final By amenitiesHeader_Lnk = By.xpath("(//ul[@class='clearfix internal_navigation']//li/a)[2]");
	public static final By roomTypesHeader_Lnk = By.xpath("(//ul[@class='clearfix internal_navigation']//li/a)[3]");
	public static final By whyThisHotelheader_Lnk = By.xpath("(//ul[@class='clearfix internal_navigation']//li/a)[4]");
	public static final By rNrHeader_Lnk = By.xpath("(//ul[@class='clearfix internal_navigation']//li/a)[5]");
	public static final By hotelPoliciesHeader_Lnk = By.xpath("(//ul[@class='clearfix internal_navigation']//li/a)[6]");

	public static final By readMoreDescription_Lnk = By.xpath("//div[@class='why-this-hotel-more']/a");
	public static final By descriptionExpanded_WE = By.xpath("//div[@class='why-this-hotel-inner']");
	public static final By ratingNReviewsHead_Lbl = By.xpath("//div[@id='reviews']/h2");
	public static final By ratingInRatingBlock_Lbl = By.xpath("(//div[@class='rating-reviews-left']/strong)[1]");
	public static final By reviewsInRatingBlock_Lbl = By.xpath("(//div[@class='rating-reviews-left']/strong)[2]");

	public static final By reviewsInRatingBlockBracket_Lbl = By.xpath("//div[@class='rating-reviews-left']/span");
	public static final By ratingNumbers_Lbl = By.xpath("//div[@class='rating-reviews-point']");
	public static final By starsInRatingBlock_WE = By.xpath("(//div[@class='rating-reviews-left']/strong)[2]");
	public static final By ratedInBlock_Lbl = By.xpath("(//div[@class='rating-reviews-user-content']/p)[1]");
	public static final By viewMoreReviews_Lnk = By.id("moreReviewLink");
	public static final By hotelPolicies_Lbl = By.xpath("//div[@id='policies']/h2");

	public static final By cancellationBlock_WE = By.xpath("//div[@class='hotel-policies-left']");
	public static final By checkInCheckOut_WE = By.xpath("//div[@class='hotel-policies-right']");
	public static final By exploreMoreHotels_Lbl = By.xpath("//div[@id='policies']/h2");

	public static final By readMore_Lnk = By.xpath("(//a[@class='see-more'])[1]");
	public static final By imagesNearbyBottom_WE = By.xpath("((//div[@class='nearby_properties_container'])[2]//img)");
	public static final By hotelsNameNearbyBottom_Lnk = By.xpath("//div[@id='policies']/h2");
	public static final By nearByDistance = By.xpath("((//div[@class='nearby_properties_container'])[2]//div[@class='location'])[1]");
	public static final By stars_WE = By.xpath("((//div[@class='nearby_properties_container'])[2]//span[@class='review-star-icon'])[1]");
	public static final By reviewsNearBy_Lnk = By.xpath("((//div[@class='nearby_properties_container'])[2]//div[@class='review-star']/a)[1]");
	public static final By bookingNowNearBy_Lbl = By.xpath("((//div[@class='nearby_properties_container'])[2]//div[@class='booking-now'])[1]");

	public static final By priceNearby_Lbl = By.xpath("((//div[@class='nearby_properties_container'])[2]//div[@class='price']/span)[1]");
	public static final By bookNowNearBy_Btn = By.xpath("((//div[@class='nearby_properties_container'])[2]//a[@class='btn'])[1]");
	public static final By chevronLeft_Lnk = By.xpath("(//a[@class='flex-prev'])[1]");
	public static final By chevronRight_Lnk = By.xpath("(//a[@class='flex-prev'])[2]");

	//

	//New Details Page methods

	public void click_breadCrumbsAll_Lnk(){
		generic.click(breadCrumbsAll_Lnk);
	}

	public String getLinkText_breadCrumbsAll_Lnk(){
		return generic.getText(breadCrumbsAll_Lnk);
	}

	public void click_breadCrumbsClickable_Lnk(){
		generic.click(breadCrumbsClickable_Lnk);
	}

	public String getLinkText_breadCrumbsClickable_Lnk(){
		return generic.getText(breadCrumbsClickable_Lnk);
	}

	public void click_starRating_WE(){
		generic.click(starRating_WE);
	}

	public String getElementText_starRating_WE(){
		return generic.getText(starRating_WE);

	}

	public void click_hotelName_Lbl(){
		generic.click(hotelName_Lbl);
	}

	public String getLabelText_hotelName_Lbl(){
		return generic.getText(hotelName_Lbl);
	}

	public void click_hotelsAdress_Lbl(){
		generic.click(hotelsAdress_Lbl);
	}

	public String getLabelText_hotelsAdress_Lbl(){
		return generic.getText(hotelsAdress_Lbl);
	}

	public void click_reviews_Lnk(){
		generic.click(reviews_Lnk);
	}

	public String getLinkText_reviews_Lnk(){
		return generic.getText(reviews_Lnk);
	}

	public void click_lastBooked_Lbl(){
		generic.click(lastBooked_Lbl);
	}

	public String getLabelText_lastBooked_Lbl(){
		return generic.getText(lastBooked_Lbl);
	}

	public void click_peopleLooking_Lbl(){
		generic.click(peopleLooking_Lbl);
	}

	public String getLabelText_peopleLooking_Lbl(){
		return generic.getText(peopleLooking_Lbl);
	}

	public void click_mainImage_WE(){
		generic.click(mainImage_WE);
	}

	public String getElementText_mainImage_WE(){
		return generic.getText(mainImage_WE);

	}

	public void click_smallImages_WE(){
		generic.click(smallImages_WE);
	}

	public String getElementText_smallImages_WE(){
		return generic.getText(smallImages_WE);

	}

	public void click_moreImages_WE(){
		generic.click(moreImages_WE);
	}

	public String getElementText_moreImages_WE(){
		return generic.getText(moreImages_WE);

	}

	public void click_rackRate_Lbl(){
		generic.click(rackRate_Lbl);
	}

	public String getLabelText_rackRate_Lbl(){
		return generic.getText(rackRate_Lbl);
	}

	public void click_price_Lbl(){
		generic.click(price_Lbl);
	}

	public String getLabelText_price_Lbl(){
		return generic.getText(price_Lbl);
	}

	public void click_onwards_Lbl(){
		generic.click(onwards_Lbl);
	}

	public String getLabelText_onwards_Lbl(){
		return generic.getText(onwards_Lbl);
	}

	public void click_selectRooms_Btn(){
		generic.click(selectRooms_Btn);
	}

	public void click_navigationHeader_WE(){
		generic.click(navigationHeader_WE);
	}

	public String getElementText_navigationHeader_WE(){
		return generic.getText(navigationHeader_WE);

	}

	public void click_whyFabhotels_WE(){
		generic.click(whyFabhotels_WE);
	}

	public String getElementText_whyFabhotels_WE(){
		return generic.getText(whyFabhotels_WE);

	}

	public void click_bestRevChain_WE(){
		generic.click(bestRevChain_WE);
	}

	public String getElementText_bestRevChain_WE(){
		return generic.getText(bestRevChain_WE);

	}

	public void click_centrallyLocated_WE(){
		generic.click(centrallyLocated_WE);
	}

	public String getElementText_centrallyLocated_WE(){
		return generic.getText(centrallyLocated_WE);

	}

	public void click_ratings_WE(){
		generic.click(ratings_WE);
	}

	public String getElementText_ratings_WE(){
		return generic.getText(ratings_WE);

	}

	public void click_ratingsLogo_WE(){
		generic.click(ratingsLogo_WE);
	}

	public String getElementText_ratingsLogo_WE(){
		return generic.getText(ratingsLogo_WE);

	}

	public void click_numericRating_WE(){
		generic.click(numericRating_WE);
	}

	public String getElementText_numericRating_WE(){
		return generic.getText(numericRating_WE);

	}

	public void click_ratedVeryGood_WE(){
		generic.click(ratedVeryGood_WE);
	}

	public String getElementText_ratedVeryGood_WE(){
		return generic.getText(ratedVeryGood_WE);

	}

	public void click_topReview_WE(){
		generic.click(topReview_WE);
	}

	public String getElementText_topReview_WE(){
		return generic.getText(topReview_WE);

	}

	public void click_topReviewValue_WE(){
		generic.click(topReviewValue_WE);
	}

	public String getElementText_topReviewValue_WE(){
		return generic.getText(topReviewValue_WE);

	}

	public void click_imageOnMap_WE(){
		generic.click(imageOnMap_WE);
	}

	public String getElementText_imageOnMap_WE(){
		return generic.getText(imageOnMap_WE);

	}

	public void click_propertyNameOnMap_WE(){
		generic.click(propertyNameOnMap_WE);
	}

	public String getElementText_propertyNameOnMap_WE(){
		return generic.getText(propertyNameOnMap_WE);

	}

	public void click_landmarkOnMap_WE(){
		generic.click(landmarkOnMap_WE);
	}

	public String getElementText_landmarkOnMap_WE(){
		return generic.getText(landmarkOnMap_WE);

	}

	public void click_getDirectionOnMap_Lnk(){
		generic.click(getDirectionOnMap_Lnk);
	}

	public String getLinkText_getDirectionOnMap_Lnk(){
		return generic.getText(getDirectionOnMap_Lnk);
	}

	public void click_valueMoney_WE(){
		generic.click(valueMoney_WE);
	}

	public String getElementText_valueMoney_WE(){
		return generic.getText(valueMoney_WE);

	}

	public void click_allAmenities_WE(){
		generic.click(allAmenities_WE);
	}

	public String getElementText_allAmenities_WE(){
		return generic.getText(allAmenities_WE);

	}

	public void click_amenities_Lbl(){
		generic.click(amenities_Lbl);
	}

	public String getLabelText_amenities_Lbl(){
		return generic.getText(amenities_Lbl);
	}

	public void click_checkAvailability_Lbl(){
		generic.click(checkAvailability_Lbl);
	}

	public String getLabelText_checkAvailability_Lbl(){
		return generic.getText(checkAvailability_Lbl);
	}

	public void click_whyThisHotel_Lbl(){
		generic.click(whyThisHotel_Lbl);
	}

	public String getLabelText_whyThisHotel_Lbl(){
		return generic.getText(whyThisHotel_Lbl);
	}

	public void click_overviewHeader_Lnk(){
		generic.click(overviewHeader_Lnk);
	}

	public String getLinkText_overviewHeader_Lnk(){
		return generic.getText(overviewHeader_Lnk);
	}

	public void click_amenitiesHeader_Lnk(){
		generic.click(amenitiesHeader_Lnk);
	}

	public String getLinkText_amenitiesHeader_Lnk(){
		return generic.getText(amenitiesHeader_Lnk);
	}

	public void click_roomTypesHeader_Lnk(){
		generic.click(roomTypesHeader_Lnk);
	}

	public String getLinkText_roomTypesHeader_Lnk(){
		return generic.getText(roomTypesHeader_Lnk);
	}

	public void click_whyThisHotelheader_Lnk(){
		generic.click(whyThisHotelheader_Lnk);
	}

	public String getLinkText_whyThisHotelheader_Lnk(){
		return generic.getText(whyThisHotelheader_Lnk);
	}

	public void click_rNrHeader_Lnk(){
		generic.click(rNrHeader_Lnk);
	}

	public String getLinkText_rNrHeader_Lnk(){
		return generic.getText(rNrHeader_Lnk);
	}

	public void click_hotelPoliciesHeader_Lnk(){
		generic.click(hotelPoliciesHeader_Lnk);
	}

	public String getLinkText_hotelPoliciesHeader_Lnk(){
		return generic.getText(hotelPoliciesHeader_Lnk);
	}

	public void click_readMoreDescription_Lnk(){
		generic.click(readMoreDescription_Lnk);
	}

	public String getLinkText_readMoreDescription_Lnk(){
		return generic.getText(readMoreDescription_Lnk);
	}

	public void click_descriptionExpanded_WE(){
		generic.click(descriptionExpanded_WE);
	}

	public String getElementText_descriptionExpanded_WE(){
		return generic.getText(descriptionExpanded_WE);

	}

	public void click_ratingNReviewsHead_Lbl(){
		generic.click(ratingNReviewsHead_Lbl);
	}

	public String getLabelText_ratingNReviewsHead_Lbl(){
		return generic.getText(ratingNReviewsHead_Lbl);
	}

	public void click_ratingInRatingBlock_Lbl(){
		generic.click(ratingInRatingBlock_Lbl);
	}

	public String getLabelText_ratingInRatingBlock_Lbl(){
		return generic.getText(ratingInRatingBlock_Lbl);
	}

	public void click_reviewsInRatingBlock_Lbl(){
		generic.click(reviewsInRatingBlock_Lbl);
	}

	public String getLabelText_reviewsInRatingBlock_Lbl(){
		return generic.getText(reviewsInRatingBlock_Lbl);
	}

	public void click_reviewsInRatingBlockBracket_Lbl(){
		generic.click(reviewsInRatingBlockBracket_Lbl);
	}

	public String getLabelText_reviewsInRatingBlockBracket_Lbl(){
		return generic.getText(reviewsInRatingBlockBracket_Lbl);
	}

	public void click_ratingNumbers_Lbl(){
		generic.click(ratingNumbers_Lbl);
	}

	public String getLabelText_ratingNumbers_Lbl(){
		return generic.getText(ratingNumbers_Lbl);
	}

	public void click_starsInRatingBlock_WE(){
		generic.click(starsInRatingBlock_WE);
	}

	public String getElementText_starsInRatingBlock_WE(){
		return generic.getText(starsInRatingBlock_WE);

	}

	public void click_ratedInBlock_Lbl(){
		generic.click(ratedInBlock_Lbl);
	}

	public String getLabelText_ratedInBlock_Lbl(){
		return generic.getText(ratedInBlock_Lbl);
	}

	public void click_viewMoreReviews_Lnk(){
		generic.click(viewMoreReviews_Lnk);
	}

	public String getLinkText_viewMoreReviews_Lnk(){
		return generic.getText(viewMoreReviews_Lnk);
	}

	public void click_hotelPolicies_Lbl(){
		generic.click(hotelPolicies_Lbl);
	}

	public String getLabelText_hotelPolicies_Lbl(){
		return generic.getText(hotelPolicies_Lbl);
	}

	public void click_cancellationBlock_WE(){
		generic.click(cancellationBlock_WE);
	}

	public String getElementText_cancellationBlock_WE(){
		return generic.getText(cancellationBlock_WE);

	}

	public void click_checkInCheckOut_WE(){
		generic.click(checkInCheckOut_WE);
	}

	public String getElementText_checkInCheckOut_WE(){
		return generic.getText(checkInCheckOut_WE);

	}

	public void click_exploreMoreHotels_Lbl(){
		generic.click(exploreMoreHotels_Lbl);
	}

	public String getLabelText_exploreMoreHotels_Lbl(){
		return generic.getText(exploreMoreHotels_Lbl);
	}

	public void click_readMore_Lnk(){
		generic.click(readMore_Lnk);
	}

	public String getLinkText_readMore_Lnk(){
		return generic.getText(readMore_Lnk);
	}

	public void click_imagesNearbyBottom_WE(){
		generic.click(imagesNearbyBottom_WE);
	}

	public String getElementText_imagesNearbyBottom_WE(){
		return generic.getText(imagesNearbyBottom_WE);

	}

	public void click_hotelsNameNearbyBottom_Lnk(){
		generic.click(hotelsNameNearbyBottom_Lnk);
	}

	public String getLinkText_hotelsNameNearbyBottom_Lnk(){
		return generic.getText(hotelsNameNearbyBottom_Lnk);
	}

	public void click_stars_WE(){
		generic.click(stars_WE);
	}

	public String getElementText_stars_WE(){
		return generic.getText(stars_WE);

	}

	public void click_reviewsNearBy_Lnk(){
		generic.click(reviewsNearBy_Lnk);
	}

	public String getLinkText_reviewsNearBy_Lnk(){
		return generic.getText(reviewsNearBy_Lnk);
	}

	public void click_bookingNowNearBy_Lbl(){
		generic.click(bookingNowNearBy_Lbl);
	}

	public String getLabelText_bookingNowNearBy_Lbl(){
		return generic.getText(bookingNowNearBy_Lbl);
	}

	public void click_priceNearby_Lbl(){
		generic.click(priceNearby_Lbl);
	}

	public String getLabelText_priceNearby_Lbl(){
		return generic.getText(priceNearby_Lbl);
	}

	public void click_bookNowNearBy_Btn(){
		generic.click(bookNowNearBy_Btn);
	}

	public void click_chevronLeft_Lnk(){
		generic.click(chevronLeft_Lnk);
	}

	public String getLinkText_chevronLeft_Lnk(){
		return generic.getText(chevronLeft_Lnk);
	}

	public void click_chevronRight_Lnk(){
		generic.click(chevronRight_Lnk);
	}

	public String getLinkText_chevronRight_Lnk(){
		return generic.getText(chevronRight_Lnk);
	}

	//


	public static final String checkInDate1_WE = "(//div[contains(@class, 'datepicker-checkin')]//td[text()='";
	public static final String checkInDate2_WE = "'])[1]"; //[@class='day']";

	public static final String checkOutDate1_WE = "(//div[contains(@class, 'datepicker-checkout')]//td[text()='";
	public static final String checkOutDate2_WE = "'])[1]";  //[@class='day']";

	//public static final String selectRooms_Btn = "//div[@class='property_booking_form_detail multi_room_type_detail']//a[text()='Select Rooms']";
	public static final By selectRoomsHref_Btn = By.xpath("//a[@href='#availability']");

	public String GetText_CheckInDate_WE() {
		return generic.getValue(checkIn_Date_WE);
	}


	public String GetText_CheckOutDate_WE() {
		return generic.getValue(checkOut_Date_WE);
	}


	public String getText_totalAmounnt_Lbl () {
		return generic.getText(totalAmounnt_Lbl);
	}

	public String getText_SingleRoom_getRoomCountAndNightCount_Lbl () {
		return generic.getText(SingleRoom_getRoomCountAndNightCount_Lbl);
	}

	public String getText_multipleRoom_getRoomAndNightCount_Lbl () {
		return generic.getText(multipleRoom_getRoomAndNightCount_Lbl);
	}

	public String getText_SingleRoom_getRoomCountAndGuestCount_Lbl () {
		return generic.getText(SingleRoom_getRoomCountAndGuestCount_Lbl);
	}

	public int getSize_multipleRoomPropertyRoomType_WE () {
		return 5;//generic.getSize(multipleRoomPropertyRoomType_WE);
	}

	public String getText_multipleRoom_SoldOutMssgForIndividualRoomType_Lbl () {
		return generic.getText(multipleRoom_SoldOutMssgForIndividualRoomType_Lbl);
	}

	public void click_addRoomForIndividualRoomType_Lbl () {
		generic.click(addRoomForIndividualRoomType_Lbl);
	}

	public void Select_CheckIn_CheckOut_Date_WE(String checkindate, String checkoutdate){
		if (checkindate.length() < 1)
			return;
		generic.click(checkIn_Date_WE);
		String str[] = checkindate.split("\\s+");
		while (!generic.getText(currentMonth_WE).equalsIgnoreCase(str[1] + " " + str[2]))
			generic.click(nextMonthClick_WE);
		if(str[0].startsWith("0"))
		{
			str[0] = str[0].substring(1, str[0].length());
		}
		generic.click("(" + checkInCalenderDates_WE + "[text()='" + str[0] + "']" + ")[1]" );
		if (checkoutdate.length() < 1)
			return;
		String strr [] = checkoutdate.split("\\s+");
		while (!generic.getText(nextMonth_WE).equals(strr[1] + " " + strr[2]))
			generic.click(nextMonthClick_WE);
		if(strr[0].startsWith("0"))
		{
			strr[0] = strr[0].substring(1, strr[0].length());
		}
		generic.click("(" + checkOutCalenderDates_WE + "[text()='" + strr[0] + "']" + ")[1]" );
	}


	public String getValue_singlePropertyRoomCount_WE () {
		return generic.getText(singlePropertyRoomCount_WE);
	}

	public String getText_availability_error_msg_Lbl (){
		return generic.getText(availability_error_msg_Lbl);
	}

	public void click_bookNow_Btn () {
		generic.click(bookNow_Btn);
	}


	public String getText_bookNow_Btn () {
		return generic.getText(bookNow_Btn);
	}


	public void visible_dropDown_Btn() {
		generic.isVisible(dropDown_Btn);
	}


	public int webElementsCount_soldOutCout_Lbl (){
		return generic.findElements(soldOutCout_Lbl).size();
	}

	public int getSize_oneRoomLeftMssg_Lbl () {
		return 5;//generic.getSize(oneRoomLeftMssg_Lbl);
	}

	public String getText_multipleRoomType_totalPriceForAllRooms_WE () {
		return generic.getText(multipleRoomType_totalPriceForAllRooms_WE);
	}

	public void click_singleRoom_propertyRoomDetails_Btn () {
		generic.click(singleRoom_propertyRoomDetails_Btn);
	}

	public void click_singleRoom_occupanyIncrease_Btn () {
		generic.click(singleRoom_occupanyIncrease_Btn);
	}


	public void click_singleRoom_propertyAddRoomsDone_Btn () {
		generic.click(singleRoom_propertyAddRoomsDone_Btn);
	}

	public String getText_singleRoom_propertyRoomDetails_Lbl () {
		return generic.getText(singleRoom_propertyRoomDetails_Lbl);
	}

	public void singleRoomTypePricecomparison (double detailFinalAmount, String paymentPageTotalAmount, 
			double paymentPageFinalAmount, 	double detailPageTotalPrice, double taxAmount) throws InterruptedException {
		PaymentPage paymentPage = new PaymentPage(driver, generic);
		Thread.sleep(3000L);
		paymentPageTotalAmount = paymentPage.getText_taxPercent_Lbl();
		Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(paymentPageTotalAmount);
		while (m.find())
		{
			detailFinalAmount = Double.parseDouble(m.group(1));
		}
		detailFinalAmount = (detailFinalAmount/100) * detailPageTotalPrice;
		detailFinalAmount = Math.ceil(detailFinalAmount);
		taxAmount = Double.parseDouble(paymentPage.getText_taxAmount_Lbl());
		Assert.assertEquals(taxAmount, detailFinalAmount, "Tax amount is not matched !! Prices are not correct !!");
		detailFinalAmount = detailFinalAmount + detailPageTotalPrice;
		paymentPageFinalAmount = Double.parseDouble(paymentPage.getText_finalAmount_Lbl());
		Assert.assertEquals(detailFinalAmount, paymentPageFinalAmount,"Final amount is not accurate !!");
	}



	public void Positive_CheckInCheckOutDateWE(){
		//	LocalDate todayDate = LocalDate.now();
		//	String nextDate = todayDate.plusDays(1).toString();
		LocalDate todayDate1 = LocalDate.now();
		String todayDate = todayDate1.plusDays(2).toString();
		String nextDate = todayDate1.plusDays(3).toString();
		//System.out.println(todayDate+" , "+nextDate);
		generic.click(checkIn_Date_WE);
		String spiltTodayDate[]=todayDate.toString().split("-");
		//	System.out.println(spiltTodayDate[0]+","+spiltTodayDate[1]+","+spiltTodayDate[2]);
		//	System.out.println(checkInDate1_WE+spiltTodayDate[2].replaceFirst("0", "")+checkInDate2_WE);
		generic.click(checkInDate1_WE+spiltTodayDate[2].replaceFirst("0", "")+checkInDate2_WE);
		String spiltNextDate[]=nextDate.toString().split("-");
		generic.click(checkOutDate1_WE+spiltNextDate[2].replaceFirst("0", "")+checkOutDate2_WE);

		//generic.click(selectRooms_Btn);
		//generic.click(selectRoomsHref_Btn);
		generic.click(bookNow_Btn);
	}



}