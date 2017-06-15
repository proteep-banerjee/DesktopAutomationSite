package com.fabhotels.mobilesite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class LoginPage {

	WebDriver driver;
	GenericFunctions generic;

	public static final By country_Txt = By.xpath("//input[@value='India']");
	public static final By countryPlaceholder_DD = By.xpath("//div[@class='Select-placeholder']");
	public static final By country_Dd = By
			.xpath("//div[@class='modal select-country-modal']//span[contains(text(),'Iran')]");
	public static final By getOtp_Btn = By.linkText("Get OTP");
	public static final By mobileNumber_Txt = By.xpath("//input[@class='mobile__number']");
	public static final By otp_Txt = By.xpath("//div[@class='otp_section']/input");
	public static final By otp_Btn = By.xpath("//a[@class='btn-new']");

	public LoginPage(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}

	public void Positive_LoginWithInternationalNumber() {
		generic.click(country_Txt);
		generic.goToSleep(3000);
		generic.fill(countryPlaceholder_DD, "costa rica");
		generic.goToSleep(3000);
		generic.click(country_Dd);
		generic.goToSleep(3000);
		generic.fill(mobileNumber_Txt, "84478384");
		generic.goToSleep(3000);
		generic.click(getOtp_Btn);
	}

	public void Positive_LoginWithNationalNumber() {
		// generic.click(country_Txt);
		// generic.goToSleep(3000);
		// generic.fill(countryPlaceholder_DD, "India");
		// generic.goToSleep(3000);
		// generic.click(country_Dd);
		generic.goToSleep(3000);
		generic.fill(mobileNumber_Txt, "9650752666");
		generic.goToSleep(3000);
		generic.click(getOtp_Btn);
	}

	public void Positive_OTP() {
		generic.fill(otp_Txt, "123456");
		generic.click(otp_Btn);
	}

}