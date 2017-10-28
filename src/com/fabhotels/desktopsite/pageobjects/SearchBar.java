package com.fabhotels.desktopsite.pageobjects;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class SearchBar extends Calendar {

	WebDriver driver;
	GenericFunctions generic;

	private static final By searchBox_Txt = By.xpath("//input[@name='locationsearch']");
	private static final By noOfRooms_DD = By.xpath("//div[@class='custom-value-content clearfix']");
	private static final By findFabHotel_Btn = By
			.xpath("//*[contains(text(), ' Find FabHotels ') or contains(@value ,'Find FabHotels')]");
	private static String roomsNumber_WE = "//div[@class='custom-value-dropdown']//li/a[contains(text(),'";

	public SearchBar(WebDriver driver, GenericFunctions generic) {
		super(driver, generic);
		this.driver = driver;
		this.generic = generic;
	}

	public void fill_searchBox_Txt(String inputdata) {
		if (inputdata.trim().length() == 0) {
			clear_searchBox_Txt();
			return;
		}
		generic.fill(searchBox_Txt, inputdata);
	}

	public void clear_searchBox_Txt() {
		generic.clear(searchBox_Txt);
	}

	public void click_searchBox_Txt() {
		generic.click(searchBox_Txt);
	}

	public String getText_searchBox_Txt() {
		return generic.getText(searchBox_Txt);
	}

	public void select_noOfRooms_DD(String inputdata) {
		if (inputdata.trim().length() == 0)
			return;
		generic.select(noOfRooms_DD, inputdata);
	}

	public void deSelect_noOfRooms_DD(String inputdata) {
		new Select(driver.findElement(noOfRooms_DD)).deselectByVisibleText(inputdata);
	}

	public String getSelectedText_noOfRooms_DD() {
		return generic.getFirstSelectedOptionBy(noOfRooms_DD);
	}

	public String getSelectedID_noOfRooms_DD() {
		return new Select(driver.findElement(noOfRooms_DD)).getFirstSelectedOption().getAttribute("value");
	}

	public void click_findFabHotel_Btn() {
		generic.click(findFabHotel_Btn);
	}

	// Func to get url parameters.
	public Map<String, String> getParameters_URL() {
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
		for (String pair : pairs) {
			int idx = pair.indexOf("=");
			if (pair.substring(0, idx).equals("occupancy[]")) {
				occupancy_count++;
			} else {
				query_pairs.put(pair.substring(0, idx), pair.substring(idx + 1));
			}
		}
		// Storing occupancy count on Map as occupancy property is redundant.
		// USE occupancy as a key to get the occupancy count.
		query_pairs.put("occupancy", String.valueOf(occupancy_count));
		return query_pairs;

	}

	public void fill_SearchBox_Txt(String input) {
		if (input.length() < 1)
			return;
		else
			generic.fill(searchBox_Txt, input);
	}

	public void performSearch(String searchText, String checkIn, String checkOut, String noofRooms) {
		fill_SearchBox_Txt(searchText);
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

	public void select_RoomsNumber_WE(int rooms) {
		generic.performMouseHover(noOfRooms_DD);
		generic.click(roomsNumber_WE + rooms + "')]");
		generic.click(findFabHotel_Btn);
	}

}
