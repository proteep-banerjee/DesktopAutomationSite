package com.fabhotels.desktopsite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class Header {
	WebDriver driver;
	GenericFunctions generic;
	
	public static final By fabLogo_Lnk= By.xpath("//div[@class='main-logo']");
	public static final By beOurFranchisee_Lnk = By.xpath("//div[@class='be-franchisee']");
	public static final By callUs_Lbl = By.xpath("//div[@class='tel clearfix']");
	public static final By allCities_WE = By.xpath("//div[@class='other-cities']"); 
	
	public Header(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}
	
	public void click_fabLogo_Lnk(){
		generic.click(fabLogo_Lnk);
	}
	
	public void click_beOurFranchisee_Lnk(){
		generic.click(beOurFranchisee_Lnk);
	}
	
	public String getText_callUs_Lbl(){
		return generic.getText(callUs_Lbl);
	}
}
