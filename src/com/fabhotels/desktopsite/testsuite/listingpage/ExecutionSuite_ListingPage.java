package com.fabhotels.desktopsite.testsuite.listingpage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.pageobjects.ListingPage;
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
	public void TC_ValidateVisibility_FeatureBox_ListPage() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		Assert.assertTrue(generic.isVisible(ListingPage.featureBox_WE), "Feature box not visible on list page !!");
	}

	@Test
	public void TC_ValidateFunctionality_Filters() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		ListingPage listingPage = new ListingPage(driver, generic);
		List<WebElement> filters = generic.findElements(ListingPage.filters_WE);
		String firstFilter = filters.get(0).findElement(By.tagName("span")).getText();
		listingPage.click_Filters_WE();
		int count = Integer.parseInt(firstFilter.replaceAll("[^-?0-9]+", ""));
		Assert.assertEquals(generic.findElements(ListingPage.allProperties_WE).size(), count,
				"Filters not working properly count shown and actual properties dont Match !!");
	}

	@Test
	public void TC_ValidateClickability_ReviewsLink() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		ListingPage listingPage = new ListingPage(driver, generic);
		listingPage.click_ReviewsModalDialogue_WE();
		Assert.assertTrue(generic.isVisible(ListingPage.reviewsModalDialogue_WE),
				"Review Model Dialogue is not opening !!");
	}
	
	@Test
	public void TC_ValidateFunctionality_Search() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		ListingPage listingPage = new ListingPage(driver, generic);
		listingPage.click_ReviewsModalDialogue_WE();
		Assert.assertTrue(generic.isVisible(ListingPage.reviewsModalDialogue_WE),
				"Review Model Dialogue is not opening !!");
	}
	
	

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
