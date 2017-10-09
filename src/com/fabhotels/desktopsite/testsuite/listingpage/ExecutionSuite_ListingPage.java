package com.fabhotels.desktopsite.testsuite.listingpage;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.pageobjects.Calendar;
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
		int count = Integer.parseInt(firstFilter.replaceAll("[()]", ""));
		Assert.assertEquals(generic.getSize(ListingPage.hotelList_WE), count,
				"Filters not working properly count shown and actual properties dont Match !!");
	}

	@Test
	public void TC_CheckTotal_HotelCount_List() {
		ListingPage listingPage = new ListingPage(driver, generic);
		generic.loadURL(UrlProvider.getListingPageUrl());
		listingPage.check_Hotels_count();
	}

	@Test
	public void TC_CheckRackPrice_List() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		ListingPage listingPage = new ListingPage(driver, generic);
		listingPage.compare_Rack_Price();
	}

	@Test
	public void TC_Three_hotels_links() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		ListingPage listingPage = new ListingPage(driver, generic);
		listingPage.check_All_Hotel_links();
	}

	@Test
	public void TC_Review_listPage() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		ListingPage listingPage = new ListingPage(driver, generic);
		listingPage.check_review();
	}

	@Test
	public void TC_CityDropdown_listPage() {
		generic.loadURL(UrlProvider.getHomePageUrl());
		ListingPage listingPage = new ListingPage(driver, generic);
		listingPage.all_Cities_names();
	}

	@Test
	public void TC_ImageandLandmark_listPage() {
		generic.loadURL(UrlProvider.getHomePageUrl());
		ListingPage listingPage = new ListingPage(driver, generic);
		listingPage.check_ImageAndLandmark();
	}

	@Test
	public void TC_HotelInfoContainer_listPage() throws ParseException {
		generic.loadURL(UrlProvider.getListingPageUrl());
		generic.handlePopUPTimer(ListingPage.popCloseButton_Btn);
		ListingPage listingPage = new ListingPage(driver, generic);
		Calendar cal = new Calendar(driver, generic);
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE(cal.dateWithDifferentFormat("dd MMMM uuuu",1),cal.dateWithDifferentFormat("dd MMMM uuuu", 3));
		listingPage.selectRooms();
		List<WebElement> list = generic.findElements(ListingPage.filters_WE);
		for (WebElement temp : list) {
			Assert.assertTrue(temp.isDisplayed(), " Locality button is not displayed !!");
			Assert.assertTrue(temp.isEnabled(), " Locality button is not enabled !!");
		}
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
