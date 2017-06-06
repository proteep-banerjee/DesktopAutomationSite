package com.fabhotels.dashboard.pageobjects;

import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.core.CustomAssert;
import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class ManageUsers {
	
	WebDriver driver;
	GenericFunctions generic;
	CustomAssert CustomAssert;
	
	public ManageUsers (WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;		
	}
	
	public String firstName_Txt="(//input[@name='Users[first_name]'])[2]";
	public String lastName_Txt="(//input[@name='Users[last_name]'])[2]";
	public String username_Txt="(//input[@name='Users[username]'])[2]";
	public String email_Txt="(//input[@name='Users[email]'])[2]";
	public String mobile_Txt="(//input[@name='Users[mobile]'])[2]";
	public String update_Btn="(//img[@alt='Update'])[1]";
	
	public void searchByUsername(String username){
		generic.fill(username_Txt, username);
		generic.click(update_Btn);
	}
}
