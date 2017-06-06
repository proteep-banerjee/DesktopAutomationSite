package com.fabhotels.dashboard.pageobjects;

import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class Login {

	WebDriver driver;
	GenericFunctions generic;


	public Login (WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;		
	}


	public String login_Txt = "//input[@id='LoginForm_username']";
	public String password_Txt = "//input[@id='LoginForm_password']";
	public String login_Btn = "//input[@value='Login']";

	
	
	
	public void positiveLoginFlow(){
		generic.fill(login_Txt, "sankalp");   //salil
		generic.fill(password_Txt, "aaaaaa");  //salil
		generic.click(login_Btn);
	}

}
