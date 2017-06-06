package com.fabhotels.desktopsite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class Header {
	WebDriver driver;
	GenericFunctions generic;
	
	public static final By fabLogo_WE = By.xpath("//div[@class='logo']/a");
	public static final By allCities_DD = By.xpath("(//div[@class='header_right']/div)[1]");
	public static final String allCities_Links_WE = "(//div[@class='header_right']/div)[1]//a";
	public static final By customerReviews_Btn = By.xpath("//div[@class='header_review_bx']");
	public static final By callUs_Btn = By.xpath("//ul[@class='call_us']/a");
	
	public Header(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}
	
	public void click_fabLogo_WE(){
		generic.click(fabLogo_WE);
	}
	
	public void click_CustomerReviews_Btn(){
		generic.click(customerReviews_Btn);
	}
	
}
