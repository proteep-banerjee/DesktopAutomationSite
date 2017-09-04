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
	
	
	public String GetText_resultsCountText_Lbl() {
		return generic.getText(resultsCountText_Lbl);
	}

	public String GetText_NoofHotelFound() {
		return generic.getText(resultsCountText_Lbl).split("\\s+")[0];
	}
	
     
	public void click_singleProperty_WE () {
		generic.click(singleProperty_WE);
	}
	
	
	public String getText_noPropertyFound_Lbl () {
		return generic.getText(noPropertyFound_Lbl);
	}
	
	
	
	
}
