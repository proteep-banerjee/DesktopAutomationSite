package com.fabhotels.desktopsite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class ListingPage {

	WebDriver driver;
	GenericFunctions generic;

	public static final By location_Txt = By.id("autocomplete-location");

	public static final By checkIn_Date_WE = By.id("checkIn");
	public static final By checkOut_Date_WE = By.id("checkOut");
	public static final By add_Room_Btn = By.id("addRoom");
	public static final By remove_room_Btn = By.id("removeRoom");
	public static final By find_Fabhotels_Btn = By.id("homePageSearchBtn");
	public static final By allProperties_WE = By.xpath("//div[@class='content-scroller']");
	public static final By singleProperty_WE = By.xpath("(//div[@class='catalogue_property_price_book']/a)[1]");
	public static final By listResults_WE = By.xpath("//div[@class='hotel-list-container']");
	public static final By noPropertyFound_Lbl = By.xpath("//div[contains(@class, 'catalogue_property_list_bx_sngl')]/p");
	public static final By resultsCountText_Lbl = By.xpath("//h1[@class='propertyCount']");
	public static final By noResultsFoundMessage_Lbl = By.xpath("//div[@class='no-data-found clearfix']/h2/text()");
	public static final By SingleFilterList_WE = By.xpath("(//ul[@class='filterList']/li)[1]");
	public static final By allFilterlist_WE = By.xpath("//ul[@class='filterList']/li");
	public static final By single_RoomMssg_WE = By.xpath("//span[contains(text(), 'room remaining!')]");
	public static final By more_RoomMssg_WE = By.xpath("//span[contains(text(), 'rooms remaining!')]");
	public static final By Reviews_WE = By.xpath("//div[@class='catalogue_property_list_detail_rating']");
	public static final By soldout_Btn = By.xpath("(//div[@class='catalogue_property_price_book']/a[contains(text(), 'Sold Out')])[1]");
	public static final By booknow_Btn = By.xpath("(//div[@class='catalogue_property_price_book']//a[contains(text(), 'Book Now')])[1]");
	public static final By review_close_Btn = By.xpath("//button[@class='close modal_review_cls']/span");
	public static final By moreReview_Btn = By.xpath("//a[contains(text(), 'Load more reviews')]");
	public static final By rackRate_WE = By.xpath("//div[@class='catalogue_property_price_show']/div");
	
	
	public static final String noPropertyFound_Msg = "We couldn’t find hotels matching your search criteria";
	
	public ListingPage (WebDriver driver, GenericFunctions generic){
		this.driver=driver;
		this.generic=generic;}
	
	

	public static final By noOfRooms_DD = By.xpath("//div[@class='custom-value-content clearfix']");
	public static final By list_noOfRooms_DD = By.xpath("(//div[@class='custom-value-dropdown']//a)[3]");
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
	public static final By cross_reviewsModal_Btn = By.xpath("//button[@class='close modal_review_cls']");
	public static final By featureBox_WE = By.xpath("//div[@class='catalogue_property_feature_box clearfix']");
	public static final By closeToAirport_Lbl = By.xpath("//span[@class='link-airport']");

	public String getText_resultsCountText_Lbl() {
		return generic.getText(resultsCountText_Lbl);
	}

	public String getText_NoofHotelFound() {
		return generic.getText(resultsCountText_Lbl).split("\\s+")[0];
	}

	public void click_SingleProperty_WE() {
		generic.click(singleProperty_WE);
	}
	
	public void click_Filters_WE(){
		generic.click(filters_WE);
	}
	
	public void click_ReviewsModalDialogue_WE(){
		generic.click(reviewsModalDialogue_WE);
	}
	
	public void click_ReviewsCount_FirstTuple_WE(){
		generic.click(reviewsCount_FirstTuple_WE);
	}
	
	public void click_singleProperty_WE(){
		generic.click(hotelName_FirstTuple_Lbl);
	}

}
