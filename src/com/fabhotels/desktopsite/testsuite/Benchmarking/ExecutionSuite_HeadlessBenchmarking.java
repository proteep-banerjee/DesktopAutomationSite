package com.fabhotels.desktopsite.testsuite.Benchmarking;

import com.fabhotels.desktopsite.utils.Config;

public class ExecutionSuite_HeadlessBenchmarking extends Config {
/*	String Sheetname;
	Xls_Reader datatable;

	@BeforeMethod
	public void beforeMethod() {
		driver = new HtmlUnitDriver();
		driver = generic.startHeadlessDriver(Driver_Type);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		DetailPage DetailPage=new DetailPage(driver,generic);
		ListingPage ListingPage=new ListingPage(driver,generic);
		HomePage HomePage=new HomePage(driver,generic);
	}

	@DataProvider(name = "DataProvider_Benchmarking")
	public Object[][] DataProvider_Benchmarking() {
		datatable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_BENCHMARKING);
		Object result[][] = new Object[100][1];

		for (int i = 2; i < 102; i++) {
			result[i - 2][0] = i;
		}
		return result;
	}


	@Test(dataProvider="DataProvider_Benchmarking")
	public void TC_positiveCase_pageLoadTimeForHomePageOld(int rowno) {
		Sheetname = "HomePageLoadTime";
		String oldURL="http://www.fabhotels.com/";
		String pageLoadTime= generic.getElapsedTimeSecs(oldURL,HomePage.subscribe_Btn);
		datatable.setCellData(Sheetname, "oldURL", rowno, pageLoadTime);
	}
	@Test(dataProvider="DataProvider_Benchmarking")
	public void TC_positiveCase_pageLoadTimeForHomePageNew(int rowno) {
		Sheetname = "HomePageLoadTime";
		String newURL="http://preprod.fabhotels.com/";
		String pageLoadTime= generic.getElapsedTimeSecs(newURL,HomePage.subscribe_Btn);
		datatable.setCellData(Sheetname, "newURL", rowno, pageLoadTime);
	}


	@Test(dataProvider="DataProvider_Benchmarking")
	public void TC_positiveCase_pageLoadTimeForListPageOld(int rowno) {
		Sheetname = "ListPageLoadTime";
		String oldURL="http://www.fabhotels.com/hotels-in-new-delhi/";
		String pageLoadTime= generic.getElapsedTimeSecs(oldURL,ListingPage.booknow_Btn);
		datatable.setCellData(Sheetname, "oldURL", rowno, pageLoadTime);
	}
	@Test(dataProvider="DataProvider_Benchmarking")
	public void TC_positiveCase_pageLoadTimeForListPageNew(int rowno) {
		Sheetname = "ListPageLoadTime";
		String newURL="http://preprod.fabhotels.com/hotels-in-new-delhi/";
		String pageLoadTime= generic.getElapsedTimeSecs(newURL,ListingPage.booknow_Btn);
		datatable.setCellData(Sheetname, "newURL", rowno, pageLoadTime);
	}


	@Test(dataProvider="DataProvider_Benchmarking")
	public void TC_positiveCase_pageLoadTimeForDetailPageOld(int rowno) {
		Sheetname = "DetailPageLoadTime";
		String oldURL="http://www.fabhotels.com/hotels-in-goa/fabhotel-ashwem-beach-resort.html";
		String pageLoadTime= generic.getElapsedTimeSecs(oldURL,DetailPage.bookNow_Btn);
		datatable.setCellData(Sheetname, "oldURL", rowno, pageLoadTime);
	}
	@Test(dataProvider="DataProvider_Benchmarking")
	public void TC_positiveCase_pageLoadTimeForDetailPageNew(int rowno) {
		Sheetname = "DetailPageLoadTime";
		String newURL="http://preprod.fabhotels.com/hotels-in-goa/fabhotel-ashwem-beach-resort.html";
		String pageLoadTime= generic.getElapsedTimeSecs(newURL,DetailPage.bookNow_Btn);
		datatable.setCellData(Sheetname, "newURL", rowno, pageLoadTime);
	}

	@AfterMethod
	public void afterTest() {
		System.out.print("  Quit");
		driver.quit();
	}
	*/
}


