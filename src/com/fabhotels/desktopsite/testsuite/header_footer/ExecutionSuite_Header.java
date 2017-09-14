package com.fabhotels.desktopsite.testsuite.header_footer;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fabhotels.desktopsite.pageobjects.CustomerReviewsPage;
import com.fabhotels.desktopsite.pageobjects.Header;
import com.fabhotels.desktopsite.pageobjects.HomePage;
import com.fabhotels.desktopsite.pageobjects.ListingPage;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_Header extends Config {

	@BeforeTest
	public void beforeTest() {
		driver = generic.startDriver(Driver_Type);
		generic.maximize();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.manage().deleteAllCookies();
	}

	@Test
	public void TC_Validate_Clickability_FabLogo() {
		driver.get(UrlProvider.getListingPageUrl());
		Header header = new Header(driver, generic);
		header.click_fabLogo_WE();
		Assert.assertTrue(generic.isVisible(HomePage.lowest_Online_Prices_WE),
				"Clicking Fab Logo is not redirecting user to HomePage!!");
	}

	@Test
	public void TC_Validate_Clickability_CustomerReviewsButton() throws InterruptedException {
		driver.get(UrlProvider.getListingPageUrl());
		Header header = new Header(driver, generic);
		Thread.sleep(2000L);
		header.click_CustomerReviews_Btn();
		Assert.assertTrue(generic.isVisible(CustomerReviewsPage.reviews_list_WE),
				"Customer Reviews button not redirecting to Reviews Page!!");
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
	public void TC_Validate_Links_Landings_AllcitiesDD(String linkName) {
		driver.get(UrlProvider.getHomePageUrl());
		generic.performMouseHover(Header.allCities_DD);
		generic.click(Header.allCities_Links_WE + "[text()='" + linkName + "']");
		String currenturl = driver.getCurrentUrl();
		Assert.assertTrue(currenturl.contains("hotels-in-" + linkName.replaceAll(" ", "-").toLowerCase()),
				"Wrong url is forming in clicking link!! " + currenturl);
		Assert.assertTrue(generic.isVisible(ListingPage.allProperties_WE), "No Results comming in clicking Link!!");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
