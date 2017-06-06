package com.fabhotels.mobilesite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class DetailsPage {
	WebDriver driver;
	GenericFunctions generic;

	public static final By hotelTitle_Lbl = By.xpath("//h3[@class='hlc__title']/a");
	public static final By hotelAddress_Lbl = By.xpath("//div[@class='hotel__loc_meta hotel__address']");
	public static final By hotelRating_Lbl = By.xpath("//div[@class='hotel__rating_meta']");
	public static final By hotelMapLink_Lnk = By.xpath("//a[@class='maplink']");
	public static final By bookNow_Btn = By.xpath("//button[text()='Book now']");
	public static final By finalSubTotal_Lbl = By.xpath("//div[@class='hotel__total-price-txt']");

	public static final By nearByPlaces_WE = By.xpath("//div[@class='hotel__property-metadata_near-by_single_detail']");
	public static final By amenities_WE = By.xpath("//heading[text()='Amenities']/following-sibling::div/span");
	public static final By amenities_Expanded_WE = By.xpath("//span[contains(@class,'amenities__item-text')]");
	public static final By loadMore_Amenities_WE = By.xpath("(//div[@class='hotel__arrow-button'])[1]");

	public static final By aboutHotel_WE = By.xpath("//div[@class='hotel__common_box_about']/p");
	public static final By loadMore_AboutHotel_WE = By.xpath("(//div[@class='hotel__arrow-button'])[2]");

	public static final By checkInDate_Lbl = By.xpath("//div[text()='Check In']/following-sibling::div/span");
	public static final By checkOutDate_Lbl = By.xpath("//div[text()='Check Out']/following-sibling::div/span");

	public static final By room_OcupancyDetails_Lbl = By.xpath("//div[@class='hotel__select_room_detail']");
	public static final By change_Lnk = By.xpath("//a[text()='CHANGE']");

	public static final By email_Subscribe_Txt = By.xpath("//div[contains(@class,'home__subscribe-bx-txt')]/input");
	public static final By keepMeUpdated_Btn = By.xpath("//button[text()='Keep me updated!']");

	
	public static By noOfRooms_Minus_WE = By
			.xpath("//div[@class='pricing__rooms-number']//div[@class='minus-button icon-minus']");
	public static By noOfRooms_Plus_WE = By
			.xpath("//div[@class='pricing__rooms-number']//div[@class='plus-button icon-plus']");
	public static By noOfGuests_Minus_WE = By
			.xpath("//div[@class='pricing__rooms-list']//div[@class='minus-button icon-minus']");
	public static By noOfGuests_Plus_WE = By
			.xpath("//div[@class='pricing__rooms-list']//div[@class='plus-button icon-plus']");
	
	
	public static By totalPrice_Lbl = By.xpath("//div[@class='hotel__total-price-txt']");
	public static By bookNow_Lbl = By.xpath("//button[text()='Book now']");

	public DetailsPage(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}
	
	public void click_NoOfRooms_Minus_WE() {
		generic.click(noOfRooms_Minus_WE);
	}

	public void click_NoOfRooms_Plus_WE() {
		generic.click(noOfRooms_Plus_WE);
	}

	public void click_NoOfGuests_Minus_WE() {
		generic.click(noOfGuests_Minus_WE);
	}

	public void click_NoOfGuests_Plus_WE() {
		generic.click(noOfGuests_Plus_WE);
	}
	
	public void click_Change_Lnk(){
		generic.click(change_Lnk);
	}

	public void click_BookNow_Btn() {
		generic.click(bookNow_Btn);
	}

	public void click_LoadMore_Amenities_WE(){
		generic.click(loadMore_Amenities_WE);
	}
	
	public String getText_TotalPrice_Lbl() {
		return generic.getText(totalPrice_Lbl).replaceAll("^[0-9]", "");
	}

}
