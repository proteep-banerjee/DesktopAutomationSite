package com.fabhotels.mobilesite.pageobjects;

import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class SearchPage {
	WebDriver driver;
	GenericFunctions generic;
		
	public SearchPage(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}
	
	String cityName_lnk="//li/a[text()='";
	
	public void click_cityName_Lnk(String link){
		generic.click(cityName_lnk+link+"']");
	}
	
	

}
