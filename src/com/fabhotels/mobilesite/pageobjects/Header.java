package com.fabhotels.mobilesite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class Header {
	WebDriver driver;
	GenericFunctions generic;
	
	public static final By fabLogo_WE = By.xpath("//div[@class='logo']/a");
	
	public Header(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}
	
	public void click_fabLogo_WE(){
		generic.click(fabLogo_WE);
	}
	
}
