package com.fabhotels.desktopsite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class SearchResultPage {

	WebDriver driver;
	GenericFunctions generic;


	public SearchResultPage (WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;		
	}

	public static final String bookNow_Btn = "(//a[contains(text(),'Book Now')])[1]"; 
	public static final String selectHotelFromDetail_Btn = "//a[contains(text(),'FabHotel SANKALP Phase 3 DLF Club')]";
	public static final String selectStagingHotel_Btn = "//a[contains(text(),'FabHotel GRD DLF Square')]";
	public static final String selectSaltHotelFromDetail_Btn ="//a[contains(text(),'FabHotel Saltee Salt Lake')]";
	public static final String selectSankalpHotelFromDetail_Btn ="//a[contains(text(),'FabHotel Hotel Sankalp')]";


	public void click_Btn(String xpath){
		if(xpath.length()==0) return;
		try{
			driver.findElement(By.xpath(xpath)).click();
		}catch(Exception ex){
			System.out.println("Exception caught");
		}
	}

	public void positive_BookNow(){
		click_Btn(bookNow_Btn);
		generic.goToSleep(500);
	}

	public void positive_selectHotelFromDetail(){
		if(driver.getCurrentUrl().contains("www.fabhotels.com")){
			click_Btn(selectSankalpHotelFromDetail_Btn);
			//click_Btn(bookNow_Btn);
			generic.goToSleep(500);
		}
		else if(driver.getCurrentUrl().contains("dev")){
			click_Btn(bookNow_Btn);
			generic.goToSleep(500);
		}else if(driver.getCurrentUrl().contains("staging")){
			click_Btn(selectStagingHotel_Btn);
			generic.goToSleep(500);
		}
	}

}
