package com.fabhotels.desktopsite.testsuite.listingpage;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fabhotels.desktopsite.pageobjects.Calendar;
import com.fabhotels.desktopsite.pageobjects.ListingPage;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_ListingPage extends Config {

	ListingPage listingPage;

	@BeforeMethod
	public void beforeMethod() {
		driver = generic.startDriver(Driver_Type);
		new ListingPage(driver, generic);
		generic.dissMissPopUPTimer(ListingPage.popCloseButton_Btn);
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
		List<WebElement> filters = generic.findElements(ListingPage.filters_WE);
		String firstFilter = filters.get(0).findElement(By.tagName("span")).getText();
		listingPage.click_Filters_WE();
		int count = Integer.parseInt(firstFilter.replaceAll("[()]", ""));
		Assert.assertEquals(generic.getSize(ListingPage.hotelList_WE), count,
				"Filters not working properly count shown and actual properties dont Match !!");
	}

	@Test
	public void TC_CheckTotal_HotelCount_List() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		listingPage.check_Hotels_count();
	}

	@Test
	public void TC_CheckRackPrice_List() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		listingPage.compare_Rack_Price();
	}

	@Test
	public void TC_Three_hotels_links() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		listingPage.check_All_Hotel_links();
	}

	@Test
	public void TC_Review_listPage() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		listingPage.check_review();
	}

	@Test
	public void TC_CityDropdown_listPage() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		listingPage.all_Cities_names();
	}

	@Test
	public void TC_ImageandLandmark_listPage() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		listingPage.check_ImageAndLandmark();
	}

	@Test
	public void TC_HotelInfoContainer_listPage() throws ParseException {
		generic.loadURL(UrlProvider.getListingPageUrl());
		Calendar cal = new Calendar(driver, generic);
		cal.Select_CheckIn_CheckOut_Date_WE(cal.dateWithDifferentFormat("dd MMMM uuuu", 1),
				cal.dateWithDifferentFormat("dd MMMM uuuu", 3));
		listingPage.selectRooms();
		List<WebElement> list = generic.findElements(ListingPage.filters_WE);
		for (WebElement temp : list) {
			Assert.assertTrue(temp.isDisplayed(), " Locality button is not displayed !!");
			Assert.assertTrue(temp.isEnabled(), " Locality button is not enabled !!");
		}
	}

	@Test
	public void TC_NearByHotels_listPage() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		listingPage.searchingCriteria(ListingPage.searchBox_WE, ListingPage.locality_name, "4");
		listingPage.verifyNearByPropertyOnListPage();
	}

	@Test
	public void TC_SearchBox_listPage() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		listingPage.searchingCriteria(ListingPage.searchBox_WE, "", "1");
		listingPage.assertSearchError();
	}

	@Test
	public void TC_checkURL_listPage() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		listingPage.searchingCriteria(ListingPage.searchBox_WE, ListingPage.locality_name, "4");
		listingPage.checkURL();
	}

	@Test
	public void TC_No_Hotelsfound_listPage() {
		generic.loadURL(UrlProvider.getHomePageUrl());
		listingPage.searchingCriteria(ListingPage.searchBox_WE, "*", "0");
		listingPage.No_Hotelsfound();
	}
	
	@Test
	public void TC_DetailsPageLanding_Dates_listPage() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		listingPage.searchingCriteria(ListingPage.searchBox_WE, ListingPage.locality_name, "4");
		listingPage.detailsPageLanding_VerifyWithDateAndRooms();
	}

	@Test
	public void TC_DetailsPageLanding_DateLess_listPage() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		listingPage.searchingCriteria(ListingPage.searchBox_WE, "New Delhi", "0");
		listingPage.detailsPageLanding_VerifyWithDateLess();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
