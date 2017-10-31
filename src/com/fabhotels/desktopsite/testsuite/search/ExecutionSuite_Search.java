package com.fabhotels.desktopsite.testsuite.search;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.core.CustomAssert;
import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.desktopsite.pageobjects.ListingPage;
import com.fabhotels.desktopsite.pageobjects.SearchBar;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.Constants;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_Search extends Config {
	SearchBar searchBar;
	ListingPage listingPage;

	@BeforeTest
	public void beforeTest() {
		generic = new GenericFunctions(driver);
		driver = generic.startDriver(Driver_Type);
		listingPage = new ListingPage(driver, generic);
		searchBar = new SearchBar(driver, generic);
	}

	@BeforeMethod(firstTimeOnly = true)
	public void beforeMethod() {
		driver.manage().deleteAllCookies();
	}

	@Test
	public void TC_checkURL_listPage() {
		generic.loadURL(UrlProvider.getListingPageUrl());
		CustomAssert customAssert = new CustomAssert();
		String checkIn = GenericFunctions.getDateAfterDays("0");
		String checkOut = GenericFunctions.getDateAfterDays("1");
		String rooms = "4";
		searchBar.performSearch(Constants.LOCALITY_NAME, checkIn, checkOut, rooms);
		Assert.assertTrue(generic.isVisible(ListingPage.searchResultContainer_WE),
				"Search results not visible on performing Search !!");
		Assert.assertTrue(generic.getText(ListingPage.resultsCountText_Lbl).contains(Constants.LOCALITY_NAME),
				"Search results not Appropriate on ListPage !!");
		// listingPage.detailsPageLanding_VerifyWithDateAndRooms();

		Map<String, String> parameters = searchBar.getParameters_URL();
		customAssert.assertTrue(parameters.get(Constants.KEY_LOCATIONSEARCH).contains(Constants.LOCALITY_NAME),
				"Location parameter is not correct.in the url");
		customAssert.assertTrue(parameters.get(Constants.KEY_LOCALITYTEXT).contains(Constants.LOCALITY_NAME),
				"Location parameter is not correct in the url.");
		customAssert.assertEquals(rooms, parameters.get(Constants.KEY_OCCUPANCY),
				"Occupancy is not Matching with default value. i.e 1 OR is broken");
		customAssert.assertTrue(parameters.get(Constants.KEY_NEARCITY).contains("New Delhi"),
				"Near city parameter is not correct.in the url");
		customAssert.assertAll();

	}

}
