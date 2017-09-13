package com.fabhotels.desktopsite.testsuite.search;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.pageobjects.ListingPage;
import com.fabhotels.desktopsite.pageobjects.SearchBar;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.Constants;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_Search extends Config {
	Xls_Reader datatable;
	String Sheetname;

	@BeforeTest
	public void beforeTest() {
		driver = generic.startDriver(Driver_Type);
		generic.maximize();
	}
	
	@BeforeMethod
	public void beforeMethod(){
		driver.manage().deleteAllCookies();
		generic.loadURL(UrlProvider.getHomePageUrl());
	}

	@DataProvider(name = "DataProvider_Search")
	public Object[][] DataProvider_Search() {
		Sheetname = "Search";
		datatable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_SEARCH);
		int rowcount = datatable.getRowCount(Sheetname);
		Object result[][] = new Object[rowcount - 1][5];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = i;
			result[i - 2][1] = datatable.getCellData(Sheetname, "Locality", i);
			String checkinDate = datatable.getCellData(Sheetname, "CheckInDate", i);
			String checkoutDate = datatable.getCellData(Sheetname, "CheckOutDate", i);

			if (checkinDate.equalsIgnoreCase("today")) {
				result[i - 2][2] = GenericFunctions.getTodaysDate();
			} else {
				result[i - 2][2] = checkinDate;
			}

			if (checkoutDate.equalsIgnoreCase("tomorrow")) {
				result[i - 2][3] = GenericFunctions.getTomorrowsDate();
			} else {
				try {
					Integer.parseInt(checkoutDate);
					result[i - 2][3] = GenericFunctions.getDateAfterDays(checkoutDate);
				} catch (Exception e) {
					result[i - 2][3] = checkoutDate;
				}
			}

			result[i - 2][4] = datatable.getCellData(Sheetname, "ExpectResults", i);

		}
		return result;
	}

	@Test(dataProvider = "DataProvider_Search")
	public void TC_Validate_Search_HomePage(int rowno, String locality, String checkInDate, String checkOutDate,
			String expectResults) {
		ListingPage listingPage =new ListingPage(driver, generic);
		SearchBar searchBar = new SearchBar(driver, generic);
		searchBar.Fill_Locality_Txt(locality);
		System.out.println(checkInDate+" -----------,------- "+checkOutDate);
		searchBar.Select_CheckIn_CheckOut_Date_WE(checkInDate, checkOutDate);
		searchBar.Click_findFabHotels_Btn();
		
		Assert.assertTrue(generic.isVisible(ListingPage.allProperties_WE), "No Results founds on Performing Search!!");
		customAssert.assertEquals(searchBar.GetText_Locality_Txt(), locality, "Compare Locality");
		customAssert.assertEquals(searchBar.GetText_CheckInDate_WE(),
				GenericFunctions.formatDateDisplayFullMonth(checkInDate), "Compare Check In Date");
		customAssert.assertEquals(searchBar.GetText_CheckOutDate_WE(),
				GenericFunctions.formatDateDisplayFullMonth(checkOutDate), "Compare Check Out Date");
		customAssert.assertEquals(searchBar.GetText_NoofRooms_Lbl(), "1 Room", "Compare No of Rooms");

		if (expectResults.equalsIgnoreCase("yes")) {
			customAssert.assertTrue(listingPage.getText_resultsCountText_Lbl().contains(locality),
					"Improper Results Screen Shown!!");
			customAssert.assertTrue(Integer.parseInt(listingPage.getText_NoofHotelFound()) >= 1,
					"Total Hotels found in results are less than 1!!"); 

		} else {
			customAssert.assertEquals(ListingPage.noResultsFoundMessage_Lbl.toString(),ListingPage.noPropertyFound_Msg,"Improper Message on Zero Results Page!!");
		}

		customAssert.assertAll();

	}

	@Test
	public void TC_Validate_BlankSearchCase_HomePage() {
		SearchBar searchBar = new SearchBar(driver, generic);
		searchBar.Click_findFabHotels_Btn();
		Assert.assertTrue(generic.isPresent(SearchBar.errorMessage_WE),
				"User is Able to perform Search Without filling any Details!!");
	}

	@Test
	public void TC_Validate_NoLocalityCase_HomePage() {
		SearchBar searchBar = new SearchBar(driver, generic);
		searchBar.Select_CheckIn_CheckOut_Date_WE(GenericFunctions.getTodaysDate(), GenericFunctions.getTomorrowsDate());
		generic.goToSleep(5000);
		searchBar.Click_findFabHotels_Btn();
		Assert.assertTrue(generic.isPresent(SearchBar.errorMessage_WE),
				"User is Able to perform Search Without filling any Details!!");
	}

	@AfterTest
	public void afterTest() {
		//driver.quit();
	}
}
