package com.fabhotels.desktopsite.testsuite.listingpage;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.desktopsite.pageobjects.Calendar;
import com.fabhotels.desktopsite.pageobjects.ListingPage;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_ListingPage extends Config {

	ListingPage listingPage;

	@BeforeTest
	public void beforeTest() {
		generic = new GenericFunctions(driver);
		driver = generic.startDriver(Driver_Type);
		listingPage = new ListingPage(driver, generic);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.manage().deleteAllCookies();
		generic.loadURL(UrlProvider.getListingPageUrl());
		generic.handlePopUPTimer(ListingPage.popCloseButton_Btn);
	}

	@Test
	public void TC_ValidateVisibility_FeatureBox_ListPage() {
		Assert.assertTrue(generic.isVisible(ListingPage.featureBox_WE), "Feature box not visible on list page !!");
	}

	@Test
	public void TC_ValidateFunctionality_Filters() {
		List<WebElement> filters = generic.findElements(ListingPage.filters_WE);
		String firstFilter = filters.get(0).findElement(By.tagName("span")).getText();
		listingPage.click_Filters_WE();
		int count = Integer.parseInt(firstFilter.replaceAll("[()]", ""));
		Assert.assertEquals(generic.getSize(ListingPage.hotelList_WE), count,
				"Filters not working properly count shown and actual properties dont Match !!");
	}

	@Test
	public void TC_CheckTotal_HotelCount_List() {
		listingPage.check_Hotels_count();
	}

	@Test
	public void TC_CheckRackPrice_List() {
		listingPage.compare_Rack_Price();
	}

	@Test
	public void TC_Three_hotels_links() {
		listingPage.check_All_Hotel_links();
	}

	@Test
	public void TC_Review_listPage() {
		listingPage.check_review();
	}

	@Test
	public void TC_CityDropdown_listPage() {
		listingPage.all_Cities_names();
	}

	@Test
	public void TC_ImageandLandmark_listPage() {
		listingPage.check_ImageAndLandmark();
	}

	@Test
	public void TC_HotelInfoContainer_listPage() throws ParseException {
		Calendar cal = new Calendar(driver, generic);
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE(cal.dateWithDifferentFormat("dd MMMM uuuu", 1),
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
		listingPage.performSearch(ListingPage.locality_name, "", "", "4");
		listingPage.verifyNearByPropertyOnListPage();
	}

	@Test
	public void TC_SearchBox_listPage() {
		listingPage.performSearch("", "", "", "1");
		listingPage.assertSearchError();
	}

	@Test
	public void TC_checkURL_listPage() {
		listingPage.performSearch(ListingPage.locality_name, "", "", "4");
		listingPage.checkURL();
	}

	@Test
	public void TC_No_Hotelsfound_listPage() {
		generic.loadURL(UrlProvider.getHomePageUrl());
		listingPage.performSearch("*", "", "", "");
		listingPage.No_Hotelsfound();
	}

	@Test
	public void TC_DetailsPageLanding_Dates_listPage() {
		listingPage.performSearch(ListingPage.locality_name, "", "", "4");
		listingPage.detailsPageLanding_VerifyWithDateAndRooms();
	}

	@Test
	public void TC_DetailsPageLanding_DateLess_listPage() {
		listingPage.performSearch("New Delhi", "", "", "0");
		listingPage.detailsPageLanding_VerifyWithDateLess();
	}

	@AfterMethod
	public void afterMethod() {

	}

	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
