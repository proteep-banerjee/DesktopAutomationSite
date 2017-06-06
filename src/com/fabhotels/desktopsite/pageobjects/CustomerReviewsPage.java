package com.fabhotels.desktopsite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class CustomerReviewsPage {
	WebDriver driver;
	GenericFunctions generic;
	
	public static final By reviews_list_WE = By.xpath("//div[@class='review_bx_main_bx']/div/div");
	
	public CustomerReviewsPage(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}

}
