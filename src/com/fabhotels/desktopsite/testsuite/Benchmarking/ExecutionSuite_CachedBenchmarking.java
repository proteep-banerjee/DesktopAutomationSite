package com.fabhotels.desktopsite.testsuite.Benchmarking;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.Constants;

public class ExecutionSuite_CachedBenchmarking extends Config {
/*	String Sheetname;
	Xls_Reader datatable;

	@BeforeTest
	public void beforeMethod() {
		driver = generic.startDriver(Driver_Type);
		generic.waitForCompletePageLoad(driver);
		generic.maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@DataProvider(name = "DataProvider_Benchmarking")
	public Object[][] DataProvider_Benchmarking() {
		datatable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_BENCHMARKING);
		Object result[][] = new Object[200][1];
		
		for (int i = 2; i < 30; i++) {
			result[i - 2][0] = i;
		}
		return result;
	}
	
	
	@Test(dataProvider="DataProvider_Benchmarking")
	public void TC_positiveCase_pageLoadTimeForHomePageOld(int rowno) {
		driver.manage().deleteAllCookies();
		Sheetname = "HomePageLoadTime";
		String CachedOldURL="http:dev-sahil.fabhotels.com/";
		String pageLoadTime= generic.getElapsedTimeSecsForCached(CachedOldURL);
		datatable.setCellData(Sheetname, "CachedOldURL", rowno, pageLoadTime);
	}
	@Test(dataProvider="DataProvider_Benchmarking")
	public void TC_positiveCase_pageLoadTimeForHomePageNew(int rowno) {
		driver.manage().deleteAllCookies();
		Sheetname = "HomePageLoadTime";
		String CachedNewURL="http:dev-ajeet.fabhotels.com/";
		String pageLoadTime= generic.getElapsedTimeSecsForCached(CachedNewURL);
		datatable.setCellData(Sheetname, "CachedNewURL", rowno, pageLoadTime);
	}
	
	
	@Test(dataProvider="DataProvider_Benchmarking")
	public void TC_positiveCase_pageLoadTimeForListPageOld(int rowno) {
		driver.manage().deleteAllCookies();
		Sheetname = "ListPageLoadTime";
		String CachedOldURL="http:dev-sahil.fabhotels.com/hotels-in-new-delhi/";
		String pageLoadTime= generic.getElapsedTimeSecsForCached(CachedOldURL);
		datatable.setCellData(Sheetname, "CachedOldURL", rowno, pageLoadTime);
	}
	@Test(dataProvider="DataProvider_Benchmarking")
	public void TC_positiveCase_pageLoadTimeForListPageNew(int rowno) {
		driver.manage().deleteAllCookies();
		Sheetname = "ListPageLoadTime";
		String CachedNewURL="http:dev-ajeet.fabhotels.com/hotels-in-new-delhi/";
		String pageLoadTime= generic.getElapsedTimeSecsForCached(CachedNewURL);
		datatable.setCellData(Sheetname, "CachedNewURL", rowno, pageLoadTime);
	}

	
	@Test(dataProvider="DataProvider_Benchmarking")
	public void TC_positiveCase_pageLoadTimeForDetailPageOld(int rowno) {
		driver.manage().deleteAllCookies();
		Sheetname = "DetailPageLoadTime";
		String CachedOldURL="http://dev-sahil.fabhotels.com/hotels-in-goa/fabhotel-ashwem-beach-resort.html";
		String pageLoadTime= generic.getElapsedTimeSecsForCached(CachedOldURL);
		datatable.setCellData(Sheetname, "CachedOldURL", rowno, pageLoadTime);
	}
	@Test(dataProvider="DataProvider_Benchmarking")
	public void TC_positiveCase_pageLoadTimeForDetailPageNew(int rowno) {
		driver.manage().deleteAllCookies();
		Sheetname = "DetailPageLoadTime";
		String CachedNewURL="http://dev-ajeet.fabhotels.com/hotels-in-goa/fabhotel-ashwem-beach-resort.html";
		String pageLoadTime= generic.getElapsedTimeSecsForCached(CachedNewURL);
		datatable.setCellData(Sheetname, "CachedNewURL", rowno, pageLoadTime);
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	*/
}
