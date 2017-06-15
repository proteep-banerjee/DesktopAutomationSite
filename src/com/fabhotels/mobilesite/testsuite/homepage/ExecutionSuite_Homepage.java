package com.fabhotels.mobilesite.testsuite.homepage;

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

public class ExecutionSuite_Homepage extends Config {

	WebDriver driver;
	GenericFunctions generic;
	String baseUrl;
	UrlProvider urlProvider;
	HomePage hp;
	SearchPage sp;
	OurLocationsPage loc;
	Xls_Reader xls = new Xls_Reader(Constants.EMAILVALIDATIONSHEETS);
	Xls_Reader xls1 = new Xls_Reader(Constants.CITYNAMESIMAGESSHEET);
	Xls_Reader xls2 = new Xls_Reader(Constants.DISCOUNTNAMESIMAGESSHEETS);
	Xls_Reader xls3 = new Xls_Reader(Constants.FOOTERLINKSSHEETS);
	Xls_Reader xls4 = new Xls_Reader(Constants.HAMBURGERMENULINKSSHEET);

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

	@DataProvider(name = "TC_Validate_Links_Landings_AllcitiesDD")
	public Object[][] DataProvider_Footer() {
		Object result[][] = new Object[19][1];
		result[0][0] = "New Delhi";
		result[1][0] = "Bangalore";
		result[2][0] = "Mumbai";
		result[3][0] = "Amritsar";
		result[4][0] = "Chennai";
		result[5][0] = "Goa";
		result[6][0] = "Gurgaon";
		result[7][0] = "Hyderabad";
		result[8][0] = "Ooty";
		result[9][0] = "Jaipur";
		result[10][0] = "Noida";
		result[11][0] = "Kolkata";
		result[12][0] = "Pondicherry";
		result[13][0] = "Pune";
		result[14][0] = "Udaipur";
		result[15][0] = "Mysore";
		result[16][0] = "Ahmedabad";
		result[17][0] = "Indore";
		result[18][0] = "Coimbatore";
		return result;
	}

	@Test(dataProvider = "TC_Validate_Links_Landings_AllcitiesDD")
	public void TC_001_VerifySearchonMobile(String linkName) {
		driver.get(baseUrl);
		System.out.println("Test" + linkName);
		hp.click_searchBar_Txt();
		sp.click_cityName_Lnk(linkName);
		generic.waitForCompletePageLoad(driver);
		String link = linkName.toLowerCase().replace(" ", "-");
		String currentURL = generic.getCurrentUrl();
		Assert.assertTrue(currentURL.equals(baseUrl + "hotels-in-" + link + "/"),
				"Search is not working for" + linkName);
	}

	@DataProvider(name = "email Validations")
	public Object[][] loginData() {
		int rowcount = xls.getRowCount("Sheet1");
		Object result[][] = new Object[rowcount - 1][1];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = i;
		}
		return result;
	}

	@Test(dataProvider = "email Validations")
	public void TC_002_Verify_KeepMeUpdatedFunctionality(int rowNum) {
		String text = "";
		driver.get(baseUrl);
		hp.fill_keepMeUpdated_Txt(xls.getCellData("Sheet1", "Email", rowNum));
		hp.click_keepMeUpdated_Btn();
		if (hp.isVisible_errorOnKeepMeUpdated_WE()) {
			text = "Error";
		} else if (hp.isVisible_keepMeUpdatedSucessMessage()) {
			text = "Pass";
		}
		Assert.assertTrue(text.equals(xls.getCellData("Sheet1", "Expected Result", rowNum)),
				"Validation Failed" + xls.getCellData("Sheet1", "Test Case", rowNum));
	}

	@Test
	public void TC_003_Verify_ViewAllDealsandOffers_LinkFunctionality() {
		hp.click_viewAlldealsOffers_Lnk();
		Assert.assertTrue(generic.getCurrentUrl().equals(baseUrl + "deals-and-offers"),
				"View All link is not working properly");
	}

	@Test
	public void TC_004_Verify_ViewAllCities_LinkFunctionality() {
		hp.click_viewAllPolularCities_Lnk();
		Assert.assertTrue(generic.getCurrentUrl().equals(baseUrl + "cities"), "View All link is not working properly");
	}

	@DataProvider(name = "cityImagesOnHomepage")
	public Object[][] cityImagesOnHomepage() {
		int rowcount = xls1.getRowCount("Sheet1");
		Object result[][] = new Object[rowcount - 1][1];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = i;
		}
		return result;
	}

	@Test(dataProvider = "cityImagesOnHomepage")
	public void TC_005_VerifyCityImagesRedirection(int rowNum) {
		driver.get(baseUrl);
		String cityName = xls1.getCellData("Sheet1", "Test Case", rowNum);
		System.out.println("Test" + cityName + " Image");
		String city = cityName.toLowerCase();
		if (city.contains(" ")) {
			city = city.replace(" ", "-");
		}
		hp.click_imagesCityOrDiscount_Lnk(city);
		Assert.assertTrue(generic.getCurrentUrl().equals(baseUrl + "hotels-in-" + city + "/"),
				"Redirection not working for " + cityName + " Image on Homepage");
	}

	@DataProvider(name = "discountImagesOnHomepage")
	public Object[][] discountImagesOnHomepage() {
		int rowcount = xls2.getRowCount("Sheet1");
		Object result[][] = new Object[rowcount - 1][1];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = i;
		}
		return result;
	}

	@Test(dataProvider = "discountImagesOnHomepage")
	public void TC_006_VerifyDiscountImagesRedirection(int rowNum) {
		driver.get(baseUrl);
		String discount = xls2.getCellData("Sheet1", "Test Case", rowNum);
		System.out.println("Test" + discount + " Image");
		hp.click_imagesCityOrDiscount_Lnk(discount);
		Assert.assertTrue(generic.getCurrentUrl().equals(baseUrl + xls2.getCellData("Sheet1", "Url", rowNum)),
				"Redirection not working for " + discount + " Image on Homepage");
	}

	@DataProvider(name = "footerLinks")
	public Object[][] footerLinks() {
		int rowcount = xls3.getRowCount("Sheet1");
		Object result[][] = new Object[rowcount - 1][1];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = i;
		}
		return result;
	}

	@Test(dataProvider = "footerLinks")
	public void TC_007_VerifyDiscountImagesRedirection(int rowNum) {
		String cUrl = "";
		driver.get(baseUrl);
		String name = xls3.getCellData("Sheet1", "Test Case", rowNum);
		if (name.contains("Blog")) {
			hp.click_footerLinks_Lnk(name);
			generic.SwitchtoNewWindow();
			cUrl = generic.getCurrentUrl();
			driver.close();
			generic.switchtoOriginalWindow();
		} else {
			hp.click_footerLinks_Lnk(name);
			cUrl = generic.getCurrentUrl();
		}
		Assert.assertTrue(cUrl.equals(xls3.getCellData("Sheet1", "Url", rowNum)),
				"Redirection not working for " + name + " Image on Homepage");
	}

	@DataProvider(name = "hamburgerMenu")
	public Object[][] hamburgerMenu() {
		int rowcount = xls4.getRowCount("Sheet1");
		Object result[][] = new Object[rowcount - 1][1];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = i;
		}
		return result;
	}

	@Test(dataProvider = "hamburgerMenu")
	public void TC_008_VerifyHamburgerMenuLinksLandingPage(int rowNum) {
		System.out.println(rowNum);
		hp.click_hamburgerIcon_WE();
		String name = xls4.getCellData("Sheet1", "Test Case", rowNum);
		hp.click_hamburgerMenuItme_Lnk(name);
		String cUrl=generic.getCurrentUrl();
		Assert.assertTrue((cUrl.equals(baseUrl+xls4.getCellData("Sheet1", "Url", rowNum)) && !hp.isVisible_hamburgerMenuItme_Lnk(name)),
				"Redirection not working for " + name + " Hamburger Item");
	}
	
	@Test(dataProvider = "TC_Validate_Links_Landings_AllcitiesDD")
	public void TC_009_VerifyRedirectionOurLocationsPage(String linkName) {
		driver.get(baseUrl+"cities");
		System.out.println("Test" + linkName);
		loc.click_cityName_Lnk(linkName);
		generic.waitForCompletePageLoad(driver);
		String link = linkName.toLowerCase().replace(" ", "-");
		String currentURL = generic.getCurrentUrl();
		Assert.assertTrue(currentURL.equals(baseUrl + "hotels-in-" + link + "/"),
				"Search is not working for" + linkName);
	}



	@AfterTest
	void closeBrowser() {
		driver.quit();
	}

}