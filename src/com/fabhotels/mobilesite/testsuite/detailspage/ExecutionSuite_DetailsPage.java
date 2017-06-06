package com.fabhotels.mobilesite.testsuite.detailspage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.mobilesite.pageobjects.DetailsPage;
import com.fabhotels.mobilesite.pageobjects.RoomsPage;
import com.fabhotels.mobilesite.utils.Config;
import com.fabhotels.mobilesite.utils.UrlProvider;

public class ExecutionSuite_DetailsPage extends Config {
	DetailsPage detailsPage;

	@BeforeTest
	public void BeforeTest() {
		generic = new GenericFunctions(driver);
		driver = generic.startDriver(Driver_Type, Device_Type);
		detailsPage = new DetailsPage(driver, generic);
	}

	@BeforeMethod
	public void BeforeMethod() {

	}

	/*
	@Test
	public void TC_VerifyPrices() {
		generic.loadURL(UrlProvider.getDetailsPageUrl());
		DetailsPage detailsPage = new DetailsPage(driver, generic);
		detailsPage.click_NoOfGuests_Plus_WE();
		System.out.println(detailsPage.getText_TotalPrice_Lbl().split("\\s+")[1]);
	} */

	@Test
	public void TC_VerifyFunctionality_ChangeButton() {
		generic.loadURL(UrlProvider.getDetailsPageUrl());
		detailsPage.click_Change_Lnk();
		Assert.assertTrue(generic.isVisible(RoomsPage.save_Proceed_Btn),
				"Clicking Change Button is not Opening Rooms Page!!");
	}
	
	@Test
	public void TC_VerifyFunctionality_Expand_Amenities(){
		generic.loadURL(UrlProvider.getDetailsPageUrl());
		Assert.assertTrue(!generic.isVisible(DetailsPage.amenities_Expanded_WE),"Amenities section is not hidden!!");
		detailsPage.click_LoadMore_Amenities_WE();
		generic.goToSleep(5000);
		Assert.assertTrue(generic.isVisible(DetailsPage.amenities_Expanded_WE),"Amenities section is not getting expanded on clicking!!");		
	}

	@AfterTest
	public void AfterTest() {
		driver.quit();
	}

}
