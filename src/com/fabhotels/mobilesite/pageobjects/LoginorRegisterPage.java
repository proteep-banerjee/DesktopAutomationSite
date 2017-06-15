package com.fabhotels.mobilesite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class LoginorRegisterPage {

	WebDriver driver;
	GenericFunctions generic;

	public static final By loginOrRegister_Btn = By.partialLinkText("LOG IN OR REGISTER");
	public static final By helpAndSupport_Lnk = By.partialLinkText("Help & Support");
	public static final By termsAndConditions_Lnk = By.partialLinkText("Terms & Conditions");
	public static final By privacyPolicy_Lnk = By.partialLinkText("Privacy Policy");
	public static final By cancellationPolicy_Lnk = By.partialLinkText("Cancellation Policy");

	public LoginorRegisterPage(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}

	public void Positive_Login() {
		generic.click(loginOrRegister_Btn);
	}
}
