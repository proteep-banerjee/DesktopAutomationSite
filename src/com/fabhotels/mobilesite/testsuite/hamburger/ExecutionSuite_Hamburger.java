package com.fabhotels.mobilesite.testsuite.hamburger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.mobilesite.pageobjects.HomePage;
import com.fabhotels.mobilesite.pageobjects.OurLocationsPage;
import com.fabhotels.mobilesite.pageobjects.SearchPage;
import com.fabhotels.mobilesite.utils.Config;
import com.fabhotels.mobilesite.utils.Constants;
import com.fabhotels.mobilesite.utils.UrlProvider;

public class ExecutionSuite_Hamburger extends Config {

	WebDriver driver;
	GenericFunctions generic;
	String baseUrl;
	UrlProvider urlProvider;
	HomePage hp;
	SearchPage sp;
	OurLocationsPage loc;
	Xls_Reader xls = new Xls_Reader(Constants.HAMBURGERMENULINKSSHEET);

	@BeforeTest
	void startBrowser() {
		generic = new GenericFunctions(driver);
		driver = generic.startDriver(Driver_Type, Device_Type);
		urlProvider = new UrlProvider();
		baseUrl = UrlProvider.getBaseUrl();
		driver.get(baseUrl);
		generic.maximize();
		hp = new HomePage(driver, generic);
		sp = new SearchPage(driver, generic);
		loc = new OurLocationsPage(driver, generic);

	}


	@DataProvider(name = "hamburgerMenu")
	public Object[][] hamburgerMenu() {
		int rowcount = xls.getRowCount("Sheet1");
		Object result[][] = new Object[rowcount - 1][1];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = i;
		}
		return result;
	}

	@Test(dataProvider = "hamburgerMenu")
	public void TC_001_VerifyHamburgerMenuLinksLandingPage(int rowNum) {
		System.out.println(rowNum);
		hp.click_hamburgerIcon_WE();
		String name = xls.getCellData("Sheet1", "Test Case", rowNum);
		hp.click_hamburgerMenuItme_Lnk(name);
		String cUrl=generic.getCurrentUrl();
		Assert.assertTrue((cUrl.equals(baseUrl+xls.getCellData("Sheet1", "Url", rowNum)) && !hp.isVisible_hamburgerMenuItme_Lnk(name)),
				"Redirection not working for " + name + " Hamburger Item");
	}
	


	@AfterTest
	void closeBrowser() {
		driver.quit();
	}

}