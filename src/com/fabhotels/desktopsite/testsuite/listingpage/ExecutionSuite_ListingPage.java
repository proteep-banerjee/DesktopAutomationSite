package com.fabhotels.desktopsite.testsuite.listingpage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.pageobjects.DetailPage;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_ListingPage extends Config {
	String Sheetname;
	Xls_Reader datatable;

	@BeforeTest
	public void beforeTest() {
		driver = generic.startDriver(Driver_Type);
		generic.maximize();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.manage().deleteAllCookies();
	}

	@Test
	public void TC_ValidateClickability_singleProperty_WE() {
		generic.loadURL(UrlProvider.getHomePageUrl());
		Assert.assertTrue(generic.isVisible(DetailPage.propertyName_Lbl), "Lowest Online Widget is Not Visible!!");
	}
	
	
	
	
	
    
	
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
