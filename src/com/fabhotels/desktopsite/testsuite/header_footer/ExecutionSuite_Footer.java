package com.fabhotels.desktopsite.testsuite.header_footer;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.pageobjects.Footer;
import com.fabhotels.desktopsite.pageobjects.ListingPage;
import com.fabhotels.desktopsite.utils.Constants;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_Footer extends UrlProvider {

	Xls_Reader datatable;
	String Sheetname;
	String Sheetnames;
	Footer footer;

	@BeforeTest
	public void beforeTest() {
		generic = new GenericFunctions(driver);
		driver = generic.startDriver(Driver_Type);
		footer = new Footer(driver, generic);
		generic.loadURL(getHomePageUrl());
	}

	@BeforeMethod
	public void beforeMethod() {
		generic.handlePopUPTimer();
	}

	@DataProvider(name = "Validate_Links_Landings_Footer")
	public Object[][] DataProvider_Footer() {
		Sheetnames = "LandingURLs";
		datatable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_FOOTER);
		int rowcount_url = datatable.getRowCount(Sheetnames);
		Object result[][] = new Object[rowcount_url - 1][1];
		for (int j = 2; j < rowcount_url + 1; j++) {
			result[j - 2][0] = datatable.getCellData(Sheetnames, "Links_Url", j);
		}

		return result;
	}

	@Test(dataProvider = "Validate_Links_Landings_Footer")
	public void TC_Validate_FooterLinks_Landings(String Link_Url) {
		SoftAssert s_assert = new SoftAssert();
		Sheetname = "Footer";
		datatable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_FOOTER);
		int rowcount = datatable.getRowCount(Sheetname);
		String[][] result = new String[rowcount - 1][3];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = String.valueOf(i);
			result[i - 2][1] = datatable.getCellData(Sheetname, "Links", i);
			result[i - 2][2] = datatable.getCellData(Sheetname, "Link_Type", i);
		}
		generic.loadURL(getHomePageUrl() + Link_Url);
		for (int i = 2; i < rowcount + 1; i++) {
			String row = result[i - 2][0];
			String LinkName = result[i - 2][1];
			String Link_Type = result[i - 2][2];

			System.out.println("Row --->> " + row + ", Linkname --->> " + LinkName + ", link type --->> " + Link_Type
					+ ", LinkPage --->> " + Link_Url);

			if (Link_Type.equalsIgnoreCase("Static")) {

				String Xpath = Footer.footerDiv_WE + Footer.staticText_Lnk + LinkName + "')]";
				generic.scrollToElement(By.xpath(Xpath), true);
				s_assert.assertTrue(generic.isVisible(Xpath), "Fail Static Text " + LinkName + " Not Visible!!");

			} else if (Link_Type.equalsIgnoreCase("Link")) {
				boolean check = true;
				footer.clickCiti(LinkName);
				generic.SwitchtoNewWindow();
				check = generic.isVisible(datatable.getCellData(Sheetname, "LandingXpath", Integer.parseInt(row)));
				s_assert.assertTrue(check, "Fail Link " + LinkName + "Improper Landing!!");
				generic.SwitchtoOriginalWindow();
			}

		}
		s_assert.assertTrue(generic.getText(Footer.footerData_Lbl).length() > 50,
				"Footer text data is not comming for :" + Link_Url);
		s_assert.assertEquals(generic.getAttributeValue(Footer.subscribe_placeholder_input, "placeholder"),
				Footer.subscribe_placeholder_msg, "Placeholder ");
		s_assert.assertTrue(generic.isVisible(Footer.subscribe_Btn), "subscribe Email button is not visible!!");
		s_assert.assertAll();

	}

	@DataProvider(name = "Validate_HomePage_Links_Landings")
	public Object[][] DataProvider_Cities_And_Localities_Footer(Method selectTC) {
		if (selectTC.getName().equalsIgnoreCase("TC_Validate_HomePage_City_And_Localities_Landings")) {
			Sheetname = "City_And_Locality";
		} else if (selectTC.getName().equalsIgnoreCase("TC_Validate_HomePage_More_cities_Landings_Footer")) {
			Sheetname = "other_cities";
		}
		datatable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_FOOTER);
		int rowcount = datatable.getRowCount(Sheetname);
		Object result[][] = new Object[rowcount - 1][3];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = i;
			result[i - 2][1] = datatable.getCellData(Sheetname, "Links", i);
			result[i - 2][2] = datatable.getCellData(Sheetname, "Link_Type", i);
		}
		return result;
	}

	@Test(dataProvider = "Validate_HomePage_Links_Landings")
	public void TC_Validate_HomePage_City_And_Localities_Landings(int row, String LinkName, String Link_Type) {
		SoftAssert s_assert = new SoftAssert();
		System.out.println("Row --->> " + row + ", Linkname --->> " + LinkName + ", link type --->> " + Link_Type);
		if (!driver.getTitle().equals(Footer.homePage_title))
			generic.loadURL(getHomePageUrl());

		if (Link_Type.equalsIgnoreCase("CityLink")) {
			generic.scrollToElement(By.xpath(footer.footerSection(3)), false);
			boolean check = true;
			footer.clickCiti(LinkName);
			generic.goToSleep(2000);
			generic.SwitchtoNewWindow();
			check = generic.isVisible(By.xpath(datatable.getCellData(Sheetname, "LandingXpath", row)));
			s_assert.assertTrue(check, "Fail Link " + LinkName + "Improper Landing!!");
			s_assert.assertTrue(generic.isVisible(Footer.hotels_listPage_WE),
					"Hotles are not comming under :" + Link_Type);
			generic.switchtoOriginalWindow();
			generic.goToSleep(2000);
			for (WebElement localityName : footer.getLocaityName_Link(LinkName)) {
				String getLocalityName = localityName.getText();
				System.out.println("locality : " + getLocalityName);
				localityName.click();
				generic.SwitchtoNewWindow();
				if (generic.isVisible(Footer.locationResult_Lbl)) {
					s_assert.assertEquals(footer.getSearchResultPlace(), getLocalityName,
							"Hotel info is not matching with locality name");
					s_assert.assertTrue(generic.isVisible(Footer.hotels_listPage_WE),
							"Hotles are not comming under locality :" + getLocalityName);
				} else {
					s_assert.assertTrue(generic.isVisible(Footer.locationResult_Lbl),
							"No hotles found under locality :" + getLocalityName);
				}
				generic.switchtoOriginalWindow();

			}

		}
		s_assert.assertEquals(footer.return_footer_RowCount(), 6,
				"Footer under Locality Home Page is not appropriate !!");
		s_assert.assertAll();

	}

	@Test(dataProvider = "Validate_HomePage_Links_Landings")
	public void TC_Validate_HomePage_More_cities_Landings_Footer(int row, String LinkName, String Link_Type) {
		SoftAssert s_assert = new SoftAssert();
		System.out.println("Row --->> " + row + ", Linkname --->> " + LinkName + ", link type --->> " + Link_Type);
		if (!driver.getTitle().equals(Footer.homePage_title))
			generic.loadURL(getHomePageUrl());
		if (Link_Type.equalsIgnoreCase("OtherCityLink")) {
			boolean check = true;
			footer.clickCiti(LinkName);
			generic.SwitchtoNewWindow();
			check = generic.isVisible(By.xpath(datatable.getCellData(Sheetname, "LandingXpath", row)));
			s_assert.assertTrue(check, "Fail Link " + LinkName + "Improper Landing!!");
			s_assert.assertTrue(generic.isVisible(Footer.hotels_listPage_WE),
					"Hotles are not comming under :" + Link_Type);
			generic.SwitchtoOriginalWindow();

		} else if (Link_Type.equalsIgnoreCase("Static")) {
			String Xpath = Footer.footerDiv_WE + Footer.staticText_Lnk + LinkName + "')]";
			s_assert.assertTrue(generic.isVisible(Xpath), "Fail Static Text " + LinkName + " Not Visible!!");

		} else if (Link_Type.equalsIgnoreCase("SEOLink")) {
			footer.clickCiti(LinkName);
			generic.SwitchtoNewWindow();
			s_assert.assertTrue(generic.isVisible(Footer.Search_hotels_near_you_Lnk),
					"'Search hotels near you' link from home page is not landing on its page.!!");
			generic.switchtoOriginalWindow();

		}
		s_assert.assertEquals(footer.return_footer_RowCount(), 6,
				"Footer under Locality Home Page is not appropriate !!");
		s_assert.assertAll();
	}

	@Test
	public void TC_Validate_LocalitiesAndLandmarks_SearchedPage_Footer() {
		SoftAssert s_assert = new SoftAssert();
		String localityName = "Sarojini Nagar";
		generic.loadURL(getHomePageUrl());
		ListingPage listingPage = new ListingPage(driver, generic);
		listingPage.performSearch(localityName, "", "", "");
		generic.scrollToElement(By.xpath(footer.footerSection(4)), false);
		s_assert.assertTrue(generic.isVisible(By.xpath(footer.popularLocalities_Lbl("Nearby Localities"))),
				"Nearby Localities is not present in footer while searching for a locality : i.e " + localityName);
		s_assert.assertTrue(generic.isVisible(By.xpath(footer.popularLocalities_Lbl("Nearby Landmarks"))),
				"Nearby Landmarks is not present in footer while searching for a locality : i.e " + localityName);
		s_assert.assertTrue(generic.isVisible(By.xpath(footer.popularLocalities_Lbl("Hotel in Nearby Localities"))),
				"Hotel in Nearby Localities is not present in footer while searching for a locality : i.e "
						+ localityName);
		s_assert.assertTrue(generic.isVisible(By.xpath(footer.popularLocalities_Lbl("Hotel in Nearby Landmarks"))),
				"Hotel in Nearby Landmarks is not present in footer while searching for a locality : i.e "
						+ localityName);
		s_assert.assertEquals(footer.return_footer_RowCount(), 5,
				"Footer under Locality Search Page is not appropriate !!");
		s_assert.assertAll();
	}

	@Test
	public void TC_Validate_LocalitiesAndLandmarks_CityPage_Footer() {
		SoftAssert s_assert = new SoftAssert();
		generic.loadURL(getListingPageUrl());
		generic.scrollToElement(By.xpath(footer.footerSection(4)), false);
		s_assert.assertTrue(generic.isVisible(By.xpath(footer.popularLocalities_Lbl("Popular Localities"))),
				"Popular Localities is not present in footer under city Page : i.e " + getListingPageUrl());
		s_assert.assertTrue(generic.isVisible(By.xpath(footer.popularLocalities_Lbl("Popular Landmarks"))),
				"Popular Landmarks is not present in footer under city Page : i.e " + getListingPageUrl());
		s_assert.assertTrue(generic.isVisible(By.xpath(footer.popularLocalities_Lbl("Nearby Cities"))),
				"Nearby Cities is not present in footer under city Page : i.e " + getListingPageUrl());
		s_assert.assertTrue(
				generic.isVisible(By.xpath(footer.popularLocalities_Lbl("Popular Hotels in Nearby Cities"))),
				"Popular Hotels in Nearby Cities is not present in footer under city Page : i.e "
						+ getListingPageUrl());
		s_assert.assertEquals(footer.return_footer_RowCount(), 6, "Footer under city Page is not appropriate !!");
		s_assert.assertAll();
	}

	@DataProvider(name = "Subscription")
	public Object[][] DataProvider_HomePage() {
		Object result[][] = new Object[4][2];
		result[0][0] = generic.getEmailasCurrentTimeStamp();
		result[0][1] = "NewSubmission";
		result[0][1] = "NewSubmission";
		result[1][0] = "test@fabhotels.com";
		result[1][1] = "AlreadySubmitted";
		result[2][0] = "test@fabhotels";
		result[2][1] = "Invalid";
		result[3][0] = "";
		result[3][1] = "Blank email";
		return result;
	}
	
	@Test
	public void check()
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//executor.executeScript("hideModalPopup()");
		executor.executeScript("setVoucherCloseCookie()");
		
		generic.loadURL(UrlProvider.getHomePageUrl());
		generic.goToSleep(30000);
		
	}
	
	@Test(dataProvider = "Subscription")
	public void TC_Validate_subscriberEmail(String Email, String Expected) {
		generic.loadURL(UrlProvider.getHomePageUrl());
		footer.fill_subscriber_Email_Txt(Email);
		footer.click_subscribe_Btn();
		if (Expected.equalsIgnoreCase("NewSubmission")) {
			Assert.assertEquals(generic.getText(Footer.Subscribe_SuccessMssg_WE).replaceAll("\\r\\n|\\r|\\n", " "),
					"Thanks for subscribing. We're excited to share a whole lot more with you.",
					"User is not able to Subscribe!!");
		} else if (Expected.equalsIgnoreCase("AlreadySubmitted")) {
			Assert.assertEquals(generic.getText(Footer.Subscribe_AlreadySubscribedMssg_WE),
					"You are Fab, and already on our update list!", "User is already Subscribed is not Working.");
		} else {
			Assert.assertEquals(generic.getText(Footer.Subscribe_WrongEmailMssg_WE),
					"Oops! We think this is not a valid email ID", "Invalid email handling is not working.");
		}
	}

	@AfterMethod
	public void afterMethod() {
		//generic.closePopUpTimer();
	}

	@AfterTest
	public void aftertest() {
		driver.quit();
	}

}
