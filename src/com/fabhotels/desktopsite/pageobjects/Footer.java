package com.fabhotels.desktopsite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class Footer {

	WebDriver driver;
	GenericFunctions generic;
	
	public Footer(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}
	
	public static final String footerDiv_WE = "//footer[@class='footer_section']";
	
	public static final By fabhotels_AllElements_WE = By.xpath("//ul[@class='left_aligned_links']/li");
	
	public static final By policies_AllElements_WE = By.xpath("//ul[@class='center_aligned_links']/li");
	
	public static final By book_AllElements_WE = By.xpath("//ul[@class='right_aligned_links']/li");
	
	
//	public int countOf_fabhotels_AllElements_WE (){
//		return generic.getCountOfElements(fabhotels_AllElements_WE);
//	}
	
	
	
}
