package com.fabhotels.mobilesite.pageobjects;

import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class OurLocationsPage {
	WebDriver driver;
	GenericFunctions generic;
		
	public OurLocationsPage(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}
	
	String cityName_lnk="//h3[text()='";
	
	public void click_cityName_Lnk(String link){
		generic.click(cityName_lnk+link+"']");
	}
	
	

}
