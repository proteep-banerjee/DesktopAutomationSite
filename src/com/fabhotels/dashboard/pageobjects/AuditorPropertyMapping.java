package com.fabhotels.dashboard.pageobjects;

import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class AuditorPropertyMapping {

	WebDriver driver;
	GenericFunctions generic;

	public AuditorPropertyMapping(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;		
	}

	public String createAuditorPropertyMapping_Btn = "//a[text()='Create AuditorPropertyMapping']";

	public String createAuditorFromDate_Txt = "//input[@id='from_date']";  //2017-05-15
	public String createAuditorToDate_Txt = "//input[@id='to_date']";  //2017-05-15
	public String createAuditorAuditorSelector_DD = "//select[@id='auditor_selector']"; //Modify Testing firstname Auditor Modify Testing lastname Auditor
	public String createAuditorProperty_Txt = "//input[@id='token-input-Properties_property_name']";
	public String createAuditorProperty_Btn = "//input[@value='Create']";
	public String createAuditorSuccess_WE = "//div[contains(text(),'Auditor Mapped for all dates successfully')]";

	public String manageAuditorPropertyMapping_Btn = "//a[text()='Manage AuditorPropertyMapping']";
	public String manageAuditorPropertyMappingFirstName_Txt = "//input[@name='AuditorPropertyMapping[first_name]']";
	public String manageAuditorPropertyMappingLastName_Txt = "//input[@name='AuditorPropertyMapping[last_name]']";
	public String manageAuditorPropertyMappingProperties_Txt = "//input[@name='AuditorPropertyMapping[properties]']";
	public String manageAuditorPropertyMappingFromDate_Txt = "//input[@name='AuditorPropertyMapping[from_date]']";
	public String manageAuditorPropertyMappingDelete_Btn = "(//img[@alt='Delete'])[1]";
	public String manageAuditorPropertyMappingUpdate_Btn = "(//img[@alt='Update'])[1]";

	public void click_createAuditorPropertyMapping_Btn(){
		generic.click(createAuditorPropertyMapping_Btn);
	}

	public void positive_CreateNewAuditorMapping(){
		String date=generic.getDatesInYYYY_MM_DD();
		System.out.println("date : "+date);
		String spiltDate[]=date.split(",");
		generic.fill(createAuditorFromDate_Txt,spiltDate[0]);
		generic.click(createAuditorProperty_Txt);
		generic.escape(createAuditorFromDate_Txt);
		generic.fill(createAuditorToDate_Txt,spiltDate[1]);
		generic.click(createAuditorProperty_Txt);
		generic.escape(createAuditorToDate_Txt);
		System.out.println( Auditors.username);
		generic.select(createAuditorAuditorSelector_DD, Auditors.username);
		generic.fill(createAuditorProperty_Txt, "fabhotel Login Sankalp");
		generic.goToSleep(2000);
		generic.enter(createAuditorProperty_Txt);
		generic.click(createAuditorProperty_Btn);
	}

	public void click_manageAuditorPropertyMapping_Btn(){
		generic.click(manageAuditorPropertyMapping_Btn);
	}

	public void positive_SearchNewAuditorMapping(){
		generic.fill(manageAuditorPropertyMappingFirstName_Txt, "Testing Firstname Auditor");
		generic.fill(manageAuditorPropertyMappingLastName_Txt, "Testing LastName Auditor");
		generic.fill(manageAuditorPropertyMappingProperties_Txt, "fabhotel Login Sankalp");
		generic.enter(manageAuditorPropertyMappingProperties_Txt);
	}

	public void manageAuditorPropertyMappingDelete_Btn(){
		generic.click(manageAuditorPropertyMappingDelete_Btn);
	}

	public void manageAuditorPropertyMappingDeleteAll_Btn(){
		generic.goToSleep(1000);
		while(generic.isVisible(manageAuditorPropertyMappingDelete_Btn)){
			if(!generic.isVisible(manageAuditorPropertyMappingDelete_Btn)) return;
			generic.click(manageAuditorPropertyMappingDelete_Btn);
			generic.goToSleep(1000);
		}
	}

	public void SearchNewAuditorMapping(String firstname, String lastname, String properties, String date){
		generic.fill(manageAuditorPropertyMappingFirstName_Txt, firstname);
		generic.fill(manageAuditorPropertyMappingLastName_Txt, lastname);
		generic.fill(manageAuditorPropertyMappingProperties_Txt, properties);
		generic.fill(manageAuditorPropertyMappingFromDate_Txt, date);
	}


}
