package com.fabhotels.mobilesite.pageobjects;

import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class EditProfilePage {
	
	WebDriver driver;
	GenericFunctions generic;

	public EditProfilePage(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}

	public String fullName_txt = "(//div[@class='profile']//input)[1]";
	public String emailId_txt = "(//div[@class='profile']//input)[2]";
	
	public String cancel_Btn = "//a[@class='cancel__profile']";
	public String save_Btn = "//a[@class='edit__profile']";
	
	public void positive_saveProfileOneDetails(){
		generic.fill(fullName_txt, "SANKALP sharma");
		generic.fill(emailId_txt, "sankalpSHARMA@mailinator.com");
		generic.click(save_Btn);
	}
	public void positive_saveProfileTwoDetails(){
		generic.fill(fullName_txt, "sankalp SHARMA");
		generic.fill(emailId_txt, "sankalp@mailinator.com");
		generic.click(save_Btn);
	}
	
	

}
