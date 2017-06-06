package com.fabhotels.dashboard.pageobjects;

import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class Dashboard {
	
	public String sales_Btn = "//a[text()='Sales']";
	public String auditors_Btn = "//a[text()='Auditors']";
	public String owners_Btn = "//a[text()='Owners']";
	public String corporateCompany_Btn =  "//a[text()='corporate company']";
	public String auditorPropertyMapping_Btn = "//a[text()='Auditor-Property Mapping']";
	public String abandonedCart_Btn = "//a[text()='Abandoned Cart']";
	
	WebDriver driver;
	GenericFunctions generic;


	public Dashboard(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;		
	}
	
	public void click_Sales(){
		generic.click(sales_Btn);
	}

	public void click_Auditors(){
		generic.click(auditors_Btn);
	}

	public void click_Owners(){
		generic.click(owners_Btn);
	}

	public void click_corporateCompany(){
		generic.click(corporateCompany_Btn);
	}

	public void click_auditorPropertyMapping_Btn(){
		generic.click(auditorPropertyMapping_Btn);
	}

	public void click_abandonedCart_Btn(){
		generic.click(abandonedCart_Btn);
	}



}
