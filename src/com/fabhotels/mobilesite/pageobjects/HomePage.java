package com.fabhotels.mobilesite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class HomePage {
	WebDriver driver;
	GenericFunctions generic;
		
	public HomePage(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}
	
	String searchBar_Txt="//a/input[@class='home__top-search-input']";
	String keepMeUpdated_Txt = "//input[@type='email']";
	String keepMeUpdated_Btn = "//button[text()='Keep me updated!']";
	String errorOnKeepMeUpdated_WE = "//div[@class='home__subscribe-bx-txt home__subscribe-bx-email-error']";
	String keepMeUpdatedSucessMessage="//p[contains(text(),'Thank you!')]";
	String viewAllPolularCities_Lnk = "//a[@href='/cities' and text()='VIEW ALL']";
	String viewAlldealsOffers_Lnk = "//a[@href='/deals-and-offers' and text()='VIEW ALL']";
	String imagesCityOrDiscount_Lnk = "//img[@id='";
	String footerLinks_Lnk="//a[text()='";
	String hamburgerIcon_WE ="//span[@class='head__icon-hamburger icon-Menu']";
	String hamburgerMenuItme_Lnk="(//span[@class='sidebar__text' and contains(text(),'";
	
	
	public void click_searchBar_Txt(){
		generic.click(searchBar_Txt);
	}
	
	public void fill_keepMeUpdated_Txt(String email){
		generic.fill(By.xpath(keepMeUpdated_Txt), email);
	}
	
	public void click_keepMeUpdated_Btn(){
		generic.click(keepMeUpdated_Btn);
	}
	public boolean isVisible_errorOnKeepMeUpdated_WE(){
		return generic.isVisible(errorOnKeepMeUpdated_WE);
	}
	
	public boolean isVisible_keepMeUpdatedSucessMessage(){
		return generic.isVisible(keepMeUpdatedSucessMessage);
	}
	public void click_viewAllPolularCities_Lnk(){
		generic.click(viewAllPolularCities_Lnk);
	}
	public void click_viewAlldealsOffers_Lnk(){
		generic.click(viewAlldealsOffers_Lnk);
	}
	public void click_imagesCityOrDiscount_Lnk(String name){
		generic.click(imagesCityOrDiscount_Lnk+name+"-img']");
	}
	public void click_footerLinks_Lnk(String name){
		generic.click(footerLinks_Lnk+name+"']");
	}
	public void click_hamburgerIcon_WE(){
		generic.click(hamburgerIcon_WE);
	}
	public void click_hamburgerMenuItme_Lnk(String linkname){
		generic.click(hamburgerMenuItme_Lnk+linkname+"')])[1]");
	}
	public boolean isVisible_hamburgerMenuItme_Lnk(String linkname){
		return generic.isVisible(hamburgerMenuItme_Lnk+linkname+"')])[1]");
	}

}
