package com.fabhotels.mobilesite.testsuite.citiesPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.mobilesite.pageobjects.HomePage;
import com.fabhotels.mobilesite.pageobjects.OurLocationsPage;
import com.fabhotels.mobilesite.pageobjects.SearchPage;
import com.fabhotels.mobilesite.utils.Config;
import com.fabhotels.mobilesite.utils.UrlProvider;

public class ExecutionSuite_CitiesPage extends Config {

	WebDriver driver;
	GenericFunctions generic;
	String baseUrl;
	UrlProvider urlProvider;
	HomePage hp;
	SearchPage sp;
	OurLocationsPage loc;

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
	public void TC_001_VerifyRedirectionOurLocationsPage(String linkName) {
		driver.get(baseUrl+"cities");
		System.out.println("Test" + linkName);
		loc.click_cityName_Lnk(linkName);
		generic.waitForCompletePageLoad(driver);
		String link = linkName.toLowerCase().replace(" ", "-");
		String currentURL = generic.getCurrentUrl();
		Assert.assertEquals(currentURL,(baseUrl + "hotels-in-" + link + "/"),
				"Search is not working for" + linkName);
	}



	@AfterTest
	void closeBrowser() {
		driver.quit();
	}

}