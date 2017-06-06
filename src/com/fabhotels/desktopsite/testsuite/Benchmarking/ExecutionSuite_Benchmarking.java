package com.fabhotels.desktopsite.testsuite.Benchmarking;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.Constants;

public class ExecutionSuite_Benchmarking extends Config {
	/*
	String Sheetname;
	Xls_Reader datatable;

	@BeforeMethod
	public void beforeMethod() {
		//driver = new HtmlUnitDriver();
		driver = generic.startHeadlessDriver(Driver_Type);
		generic.waitForCompletePageLoad(driver);
		generic.maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@DataProvider(name = "DataProvider_Benchmarking")
	public Object[][] DataProvider_Benchmarking() {
		datatable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_BENCHMARKING);
		Object result[][] = new Object[30][1];
		
		for (int i = 2; i < 32; i++) {
			result[i - 2][0] = i;
		}
		return result;
	}
	
	
	@Test(dataProvider="DataProvider_Benchmarking")
	public void TC_positiveCase_pageLoadTimeForHomePageOld(int rowno) {
		Sheetname = "HomePageLoadTime";
		String oldURL="http://dev-sahil.fabhotels.com/";
		String pageLoadTime= generic.getElapsedTimeSecs(oldURL);
		datatable.setCellData(Sheetname, "oldURL", rowno, pageLoadTime);
	}
	@Test(dataProvider="DataProvider_Benchmarking")
	public void TC_positiveCase_pageLoadTimeForHomePageNew(int rowno) {
		Sheetname = "HomePageLoadTime";
		String newURL="http://dev-ajeet.fabhotels.com/";
		String pageLoadTime= generic.getElapsedTimeSecs(newURL);
		datatable.setCellData(Sheetname, "newURL", rowno, pageLoadTime);
	}
	
	
	@Test(dataProvider="DataProvider_Benchmarking")
	public void TC_positiveCase_pageLoadTimeForListPageOld(int rowno) {
		Sheetname = "ListPageLoadTime";
		String oldURL="http://dev-sahil.fabhotels.com/hotels-in-new-delhi/";
		String pageLoadTime= generic.getElapsedTimeSecs(oldURL);
		datatable.setCellData(Sheetname, "oldURL", rowno, pageLoadTime);
	}
	@Test(dataProvider="DataProvider_Benchmarking")
	public void TC_positiveCase_pageLoadTimeForListPageNew(int rowno) {
		Sheetname = "ListPageLoadTime";
		String newURL="http://dev-ajeet.fabhotels.com/hotels-in-new-delhi/";
		String pageLoadTime= generic.getElapsedTimeSecs(newURL);
		datatable.setCellData(Sheetname, "newURL", rowno, pageLoadTime);
	}

	
	@Test(dataProvider="DataProvider_Benchmarking")
	public void TC_positiveCase_pageLoadTimeForDetailPageOld(int rowno) {
		Sheetname = "DetailPageLoadTime";
		String oldURL="http://dev-sahil.fabhotels.com/hotels-in-goa/fabhotel-ashwem-beach-resort.html";
		String pageLoadTime= generic.getElapsedTimeSecs(oldURL);
		datatable.setCellData(Sheetname, "oldURL", rowno, pageLoadTime);
	}
	@Test(dataProvider="DataProvider_Benchmarking")
	public void TC_positiveCase_pageLoadTimeForDetailPageNew(int rowno) {
		Sheetname = "DetailPageLoadTime";
		String newURL="http://dev-ajeet.fabhotels.com/hotels-in-goa/fabhotel-ashwem-beach-resort.html";
		String pageLoadTime= generic.getElapsedTimeSecs(newURL);
		datatable.setCellData(Sheetname, "newURL", rowno, pageLoadTime);
	}
	
	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
	*/
}
