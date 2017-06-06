package com.fabhotels.mobilesite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class RoomsPage {
	WebDriver driver;
	GenericFunctions generic;

	public static final By noOfRooms_Minus_Btn = By
			.xpath("//div[@class='pricing__rooms-number']//div[@class='minus-button icon-minus']");
	public static final By noOfRooms_Plus_Btn = By
			.xpath("//div[@class='pricing__rooms-number']//div[@class='plus-button icon-plus']");
	public static final By occupancy_Minus_Btn = By
			.xpath("//div[@class='pricing__rooms-list-item']//div[contains(@class,'minus-button icon-minus')]");
	public static final By occupancy_Plus_Btn = By
			.xpath("//div[@class='pricing__rooms-list-item']//div[contains(@class,'plus-button icon-plus')]");
	public static final By totalPrice_Lbl = By
			.xpath("//div[@class='hotel__total-price hotel__total-price-inner-price']");
	public static final By room_OcupancyDetails_Lbl = By
			.xpath("//div[@class='hotel__total-price hotel__total-price-inner-price']/span");
	public static final By save_Proceed_Btn = By.xpath("//button[text()='Save & Proceed']");
	public static final By back_Btn = By.xpath("//span[@class='icon__back-arrow hotel__back-button-icon']");

	public RoomsPage(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}

	public void click_NoOfRooms_Minus_Btn() {
		generic.click(noOfRooms_Minus_Btn);
	}

	public void click_NoOfRooms_Plus_Btn() {
		generic.click(noOfRooms_Plus_Btn);
	}

	public void click_Occupancy_Minus_Btn() {
		generic.click(occupancy_Minus_Btn);
	}

	public void click_Occupancy_Plus_Btn() {
		generic.click(occupancy_Plus_Btn);
	}

	public String getText_Room_OcupancyDetails_Lbl() {
		return generic.getText(room_OcupancyDetails_Lbl);
	}

	public String getText_TotalPrice_Lbl() {
		return generic.getText(totalPrice_Lbl).replaceAll("^[0-9]", "");
	}

	public void click_Save_Proceed_Btn() {
		generic.click(save_Proceed_Btn);
	}

	public void click_back_Btn() {
		generic.click(back_Btn);
	}

}
