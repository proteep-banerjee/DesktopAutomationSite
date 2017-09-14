package com.fabhotels.desktopsite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class SearchBar {

	WebDriver driver;
	GenericFunctions generic;

	public static final By locality_Txt = By.id("autocomplete-location");
	public static final By checkInDateInput_WE = By.id("checkIn");
	public static final By checkInDateDiv_WE = By.id("daterangepicker_start");
	public static final By checkOutDate_WE = By.id("checkOut");
	public static final By findFabHotels_Btn = By.id("homePageSearchBtn");
	public static final By calendar_WE = By.xpath("//div[contains(@class,'daterangepicker dropdown-menu ltr show-calendar')]");
	public static final By calendar_Month_WE = By.xpath("(//th[@class='month'])[1]");
	public static final String calendar_Dates_WE = "//div[@class='calendar left']//td";
	public static final By calendar_NextArrow_WE = By.xpath("//th[@class='next available']");
	public static final By noofRooms_Lbl = By.xpath("//div[@class='custom-value-content clearfix']/span");
	public static final By addRoom_Btn = By.id("addroom");
	public static final By removeRoom_Btn = By.id("rooms");
	public static final By errorMessage_WE = By.id("cityErrorMsg");
	
	public SearchBar(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}

	public void Fill_Locality_Txt(String input) {
		generic.fill(locality_Txt, input);
	}

	public void Select_CheckIn_CheckOut_Date_WE(String checkindate, String checkoutdate) {

		if (checkindate.length() < 1)
			return;

		generic.click(checkInDateDiv_WE);

		String str[] = checkindate.split("\\s+");
		for(int i=0; i<str.length; i++){
			System.out.println("str[]"+str[i]);
		}
		System.out.println(driver.getCurrentUrl());
		System.out.println();

		while (!generic.getText(calendar_Month_WE).equals(str[1] + " " + str[2]))
			generic.click(calendar_NextArrow_WE);
		
		if(str[0].startsWith("0")){
			str[0] = str[0].substring(1, str[0].length());
		}

		System.out.println(calendar_Dates_WE + "[text()='" + str[0] + "']");
		generic.click(calendar_Dates_WE + "[text()='" + str[0] + "']");

		if (checkoutdate.length() < 1)
			return;

		str = checkoutdate.split("\\s+");

		while (!generic.getText(calendar_Month_WE).equals(str[1] + " " + str[2]))
			generic.click(calendar_NextArrow_WE);
		
		if(str[0].startsWith("0")){
			str[0] = str[0].substring(1, str[0].length());
		}

		generic.click(calendar_Dates_WE + "[text()='" + str[0] + "']");

	}

	public void Click_findFabHotels_Btn() {
		generic.click(findFabHotels_Btn);
	}

	public void Click_addRoom_Btn() {
		generic.click(addRoom_Btn);
	}

	public void Click_RemoveRoom_Btn() {
		generic.click(removeRoom_Btn);
	}

	public String GetText_NoofRooms_Lbl() {
		return generic.getText(noofRooms_Lbl);
	}

	public String GetText_Locality_Txt() {
		return generic.getValue(locality_Txt);
	}

	public String GetText_CheckInDate_WE() {
		return generic.getValue(checkInDateInput_WE);
	}

	public String GetText_CheckOutDate_WE() {
		return generic.getValue(checkOutDate_WE);
	}

	public void Fill_NoofRooms_WE(String input) {
		int current = Integer.parseInt(GetText_NoofRooms_Lbl());
		int expected = Integer.parseInt(input);

		if (current < expected) {
			for (int i = 0; i < expected - current; i++)
				Click_addRoom_Btn();
		} else {
			for (int i = 0; i < current - expected; i++)
				Click_RemoveRoom_Btn();
		}
	}

}
