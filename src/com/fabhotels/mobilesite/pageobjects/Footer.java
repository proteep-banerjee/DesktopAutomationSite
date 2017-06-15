package com.fabhotels.mobilesite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class Footer {

	WebDriver driver;
	GenericFunctions generic;

	public static final By facebookFooter_Btn = By.xpath("//a[contains(@href,'https://facebook.com/fabhotelscom')]");
	public static final By instagramFooter_Btn = By.xpath("//a[contains(@href,'https://instagram.com/')]");
	public static final By twitterFooter_Btn = By.xpath("//a[contains(@href,'https://twitter.com/')]");
	public static final By plusGoogleFooter_Btn = By.xpath("//a[contains(@href,'https://plus.google.com/')]");

	public static final By aboutUsFooter_Btn = By.xpath("//a[contains(@href,'/about-us')]");
	public static final By contactUsFooter_Btn = By.xpath("//a[contains(@href,'/contact-us')]");
	public static final By blogFooter_Btn = By.xpath("//a[contains(@href,'https://blog.fabhotels.com/')]");
	public static final By termsAndConditionsFooter_Btn = By.xpath("//a[contains(@href,'/terms-conditions')]");
	public static final By userProfile_Btn = By.xpath("//span[@class='user__icon']");

	// public static final By =
	// By.xpath("//a[contains(@href,'/corporate-enquiry')]");
	// public static final By =
	// By.xpath("//a[contains(@href,'/franchise-enquiry')]");

}
