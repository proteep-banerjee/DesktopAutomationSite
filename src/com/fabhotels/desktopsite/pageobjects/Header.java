package com.fabhotels.desktopsite.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class Header {
	WebDriver driver;
	GenericFunctions generic;

	public static final By fabLogo_Lnk = By.xpath("//div[@class='main-logo']");
	public static final By beOurFranchisee_Lnk = By.xpath("//div[@class='be-franchisee']");
	public static final By callUs_Lbl = By.xpath("//div[@class='tel clearfix']");
	public static final By allCities_WE = By.xpath("//div[@class='other-cities']");
	public static final By cities_WE = By.xpath("//div[@class='other-cities']//li/a");
	public static final String cities_Xpath_WE = "//div[@class='other-cities']//li/a";

	public Header(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}

	public void click_fabLogo_Lnk() {
		generic.click(fabLogo_Lnk);
	}

	public void click_beOurFranchisee_Lnk() {
		generic.click(beOurFranchisee_Lnk);
	}

	public String getText_callUs_Lbl() {
		return generic.getText(callUs_Lbl);
	}

	public String getText_allCities_WE() {
		return generic.getText(allCities_WE);
	}

	public List<WebElement> getWebElements_AllCities_DD() {
		generic.performMouseHover(allCities_WE);
		return generic.findElements(cities_WE);
	}

	public void click_CityNo_Header_WE(int cityNumber) {
		generic.performMouseHover(allCities_WE);
		generic.findElements(cities_WE).get(cityNumber).click();
	}

	public void click_CityName_Header_WE(String cityName) {
		generic.performMouseHover(allCities_WE);
		generic.click(cities_Xpath_WE + "[text()='" + cityName + "']");
	}
}
