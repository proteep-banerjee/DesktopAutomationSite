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
	public void TC_001_Verify_KeepMeUpdatedFunctionality(int rowNum) {
		String text = "";
		driver.get(baseUrl);
		hp.fill_keepMeUpdated_Txt(xls.getCellData("Sheet1", "Email", rowNum));
		hp.click_keepMeUpdated_Btn();
		if (hp.isVisible_errorOnKeepMeUpdated_WE()) {
			text = "Error";
		} else if (hp.isVisible_keepMeUpdatedSucessMessage()) {
			text = "Pass";
		}
		Assert.assertEquals(text,(xls.getCellData("Sheet1", "Expected Result", rowNum)),
				"Validation Failed" + xls.getCellData("Sheet1", "Test Case", rowNum));
	}

	@Test
	public void TC_002_Verify_ViewAllDealsandOffers_LinkFunctionality() {
		hp.click_viewAlldealsOffers_Lnk();
		Assert.assertEquals(generic.getCurrentUrl(),(baseUrl + "deals-and-offers"),
				"View All link is not working properly");
	}

	@Test
	public void TC_003_Verify_ViewAllCities_LinkFunctionality() {
		hp.click_viewAllPolularCities_Lnk();
		Assert.assertEquals(generic.getCurrentUrl(),(baseUrl + "cities"), "View All link is not working properly");
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
	public void TC_004_VerifyCityImagesRedirection(int rowNum) {
		driver.get(baseUrl);
		String cityName = xls1.getCellData("Sheet1", "Test Case", rowNum);
		System.out.println("Test" + cityName + " Image");
		String city = cityName.toLowerCase();
		if (city.contains(" ")) {
			city = city.replace(" ", "-");
		}
		hp.click_imagesCityOrDiscount_Lnk(city);
		Assert.assertEquals(generic.getCurrentUrl(),(baseUrl + "hotels-in-" + city + "/"),
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
	public void TC_005_VerifyDiscountImagesRedirection(int rowNum) {
		driver.get(baseUrl);
		String discount = xls2.getCellData("Sheet1", "Test Case", rowNum);
		System.out.println("Test" + discount + " Image");
		hp.click_imagesCityOrDiscount_Lnk(discount);
		Assert.assertEquals(generic.getCurrentUrl(),(baseUrl + xls2.getCellData("Sheet1", "Url", rowNum)),
				"Redirection not working for " + discount + " Image on Homepage");
	}


	@AfterTest
	void closeBrowser() {
		driver.quit();
	}

}