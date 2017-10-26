package com.fabhotels.desktopsite.testsuite.header_footer;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
	}

	@DataProvider(name = "Validate_Links_Landings_Footer")
	public Object[][] DataProvider_Footer() {
		Sheetname = "Footer";
		datatable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_FOOTER);
		int rowcount = datatable.getRowCount(Sheetname);
		Object result[][] = new Object[rowcount - 1][3];
		for (int j = 2; j < rowcount + 1; j++) {
			result[j - 2][0] = j;
			result[j - 2][1] = datatable.getCellData(Sheetname, "Links", j);
			result[j - 2][2] = datatable.getCellData(Sheetname, "Link_Type", j);
		}

		return result;
	}

	@Test(dataProvider = "Validate_Links_Landings_Footer")
	public void TC_Footer_001_Validate_FooterLinks_Landings(int rowNo, String LinkName, String Link_Type) {
		SoftAssert s_assert = new SoftAssert();
		System.out.println("Row --->> " + rowNo + ", Linkname --->> " + LinkName + ", Link_Type --->> " + Link_Type);
		generic.loadURL(getHomePageUrl());
		if (Link_Type.equalsIgnoreCase("Static")) {
			String Xpath = Footer.footerDiv_WE + Footer.staticText_Lnk + LinkName + "')]";
			s_assert.assertTrue(generic.isVisible(Xpath), "Fail Static Text " + LinkName + " Not Visible!!");
		} else {
			footer.clickLink(LinkName);
			generic.SwitchtoNewWindow();
			s_assert.assertTrue(generic.isVisible(datatable.getCellData(Sheetname, "LandingXpath", rowNo)),
					"Fail Link " + LinkName + "Improper Landing!!");
			generic.closeNewWindow();
			generic.SwitchtoOriginalWindow();
		}
		s_assert.assertTrue(generic.getText(Footer.footerData_Lbl).length() > 50,
				"Footer text data is not comming for :" + LinkName);
		s_assert.assertAll();
	}

	@Test
	public void TC_Footer_002_Validate_Structure_StaticText() {
		SoftAssert s_assert = new SoftAssert();
		generic.loadURL(getHomePageUrl());
		s_assert.assertTrue(generic.getText(Footer.footerData_Lbl).length() > 50,
				"Footer text data is not comming for Home Page");
		s_assert.assertEquals(generic.getAttributeValue(Footer.subscribe_placeholder_input, "placeholder"),
				Footer.subscribe_placeholder_msg, "Placeholder for email subscribe input form is not apropriate");
		s_assert.assertTrue(generic.isVisible(Footer.subscribe_Btn), "subscribe Email button is not visible!!");
		s_assert.assertAll();
	}

	@Test
	public void TC_Footer_003_Validate_CopyRightText() {
		generic.loadURL(getHomePageUrl());
		String presentYear = new SimpleDateFormat("yyyy").format(new Date());
		String text = footer.get_copy_rightText();
		Assert.assertTrue(text.contains(presentYear), "The Year Shown in Footer is Wrong !! \n\n" + text);
	}

	@DataProvider(name = "Validate_HomePage_Links_Landings")
	public Object[][] DataProvider_Cities_And_Localities_Footer(Method selectTC) {
		if (selectTC.getName().equalsIgnoreCase("TC_Validate_HomePage_City_And_Localities_Landings")) {
			Sheetname = "City_And_Locality";
		} else if (selectTC.getName().equalsIgnoreCase("TC_Validate_HomePage_More_cities_Landings_Footer")) {
			Sheetname = "Other_Cities";
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
	public void TC_Footer_004_Validate_City_And_Localities_Landings(int row, String LinkName, String Link_Type) {
		SoftAssert s_assert = new SoftAssert();
		System.out.println("Row --->> " + row + ", Linkname --->> " + LinkName + ", link type --->> " + Link_Type);
		if (!driver.getTitle().equals(Footer.homePage_title))
			generic.loadURL(getHomePageUrl());

		if (Link_Type.equalsIgnoreCase("CityLink")) {
			boolean check = true;
			footer.clickLink(LinkName);
			// generic.goToSleep(2000);
			generic.SwitchtoNewWindow();
			check = generic.isVisible(By.xpath(datatable.getCellData(Sheetname, "LandingXpath", row)));
			s_assert.assertTrue(check, "Fail Link " + LinkName + "Improper Landing!!");
			s_assert.assertTrue(generic.isVisible(Footer.hotels_listPage_WE),
					"Hotles are not comming under :" + Link_Type);
			generic.closeNewWindow();
			generic.switchtoOriginalWindow();
			for (WebElement locality : footer.getLocalityName_Link(LinkName)) {
				String localityName = locality.getText();
				System.out.println("Current locality : " + localityName);
				locality.click();
				generic.SwitchtoNewWindow();
				if (generic.isVisible(Footer.locationResult_Lbl)) {
					s_assert.assertEquals(footer.getSearchResultPlace(), localityName,
							"Hotel info is not matching with locality name");
					s_assert.assertTrue(generic.isVisible(Footer.hotels_listPage_WE),
							"Hotles are not comming under locality :" + localityName);
				} else {
					s_assert.assertTrue(generic.isVisible(Footer.locationResult_Lbl),
							"No hotles found under locality :" + localityName);
				}
				generic.switchtoOriginalWindow();

			}

		}
		s_assert.assertEquals(footer.return_footer_RowCount(), 6,
				"Footer under Locality Home Page is not appropriate !!");
		s_assert.assertAll();

	}

	@Test(dataProvider = "Validate_HomePage_Links_Landings")
	public void TC_Footer_005_Validate_MoreCities_Landings(int row, String LinkName, String Link_Type) {
		SoftAssert s_assert = new SoftAssert();
		System.out.println("Row --->> " + row + ", Linkname --->> " + LinkName + ", link type --->> " + Link_Type);
		if (!driver.getTitle().equals(Footer.homePage_title))
			generic.loadURL(getHomePageUrl());
		if (Link_Type.equalsIgnoreCase("OtherCityLink")) {
			boolean check = true;
			footer.clickLink(LinkName);
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
			footer.clickLink(LinkName);
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
	public void TC_Footer_006_Validate_Localities_Landmarks_LocalityPage() {
		SoftAssert s_assert = new SoftAssert();
		String localityName = "Sarojini Nagar";
		generic.loadURL(getHomePageUrl());
		ListingPage listingPage = new ListingPage(driver, generic);
		listingPage.performSearch(localityName, "", "", "");
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
	public void TC_Footer_007_Validate_Localities_Landmarks_CityPage() {
		SoftAssert s_assert = new SoftAssert();
		generic.loadURL(getListingPageUrl());
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

	@Test(dataProvider = "Subscription")
	public void TC_Footer_008_FieldLevelValidations_SubscriberEmail(String Email, String Expected) {
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

	@AfterTest
	public void aftertest() {
		driver.quit();
	}

}
