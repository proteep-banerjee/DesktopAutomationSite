package com.fabhotels.desktopsite.testsuite.homepage;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.pageobjects.DetailPage;
import com.fabhotels.desktopsite.pageobjects.HomePage;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.Constants;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_HomePage extends Config {
	String Sheetname;
	Xls_Reader datatable;

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
	public void TC_ValidateVisiblity_LowestOnlinePriceWidget() {
		generic.loadURL(UrlProvider.getHomePageUrl());
		Assert.assertTrue(generic.isVisible(HomePage.lowest_Online_Prices_WE), "Lowest Online Widget is Not Visible!!");
	}

	@Test
	public void TC_ValidateVisiblity_PhotoMatch() {
		generic.loadURL(UrlProvider.getHomePageUrl());
		Assert.assertTrue(generic.isVisible(HomePage.photo_Match_WE), "Photo Match Widget is Not Visible !!");
	}

	@Test
	public void TC_ValidateClickability_PropertyPromotionWidget() {
		generic.loadURL(UrlProvider.getHomePageUrl());
		HomePage homePage = new HomePage(driver, generic);
		homePage.click_PropertyPromotion_widget();
		Assert.assertTrue(generic.isVisible(DetailPage.propertyName_Lbl), "Clicking to the property promotion page is not landing to the proper page");
	}

	@Test
	public void TC_ValidateVisiblity_BestReviewedChain() throws InterruptedException {
		generic.loadURL(UrlProvider.getHomePageUrl());
		Thread.sleep(3000L);
		Assert.assertTrue(generic.isVisible(HomePage.best_Reviewed_Chain_WE), "Best Reviewed Chain Widget is not found");
	}

	@Test
	public void TC_ValidateVisiblity_BestDeal() {
		generic.loadURL(UrlProvider.getHomePageUrl());
		Assert.assertTrue(generic.isVisible(HomePage.Best_Deals_WE), "Best Deals Widget is not found !");
	}

	@Test
	public void TC_ValidateVisiblity_stayMoreEarnMore() {
		generic.loadURL(UrlProvider.getHomePageUrl());
		Assert.assertTrue(generic.isVisible(HomePage.stay_More_Earn_More_WE), "stay More Earn More Widget is not found !");
	}

	@Test
	public void TC_ValidateVisiblity_bestDeals() {
		generic.loadURL(UrlProvider.getHomePageUrl());
		Assert.assertTrue(generic.isVisible(HomePage.best_Deals_WE), "Best Deals Widgit is not found !");
	}

	@Test
	public void TC_ValidateVisiblity_testimonialBoxHeading() {
		generic.loadURL(UrlProvider.getHomePageUrl());
		Assert.assertTrue(generic.isVisible(HomePage.testimonial_bx_heading_WE),
				"Testimonial Box Heading  widget is not found !");
	}

	@Test
	public void TC_ValidateClickability_ReviewBoxHeadingWordName() {
		generic.loadURL(UrlProvider.getHomePageUrl());
		HomePage homePage = new HomePage(driver, generic);
		Assert.assertTrue(homePage.VerifyScrollFunctionality_ReviewBar(), "Review clicking action is not working");
	}

	@DataProvider(name = "Homepage_Subscription")
	public Object[][] DataProvider_HomePage() {
		Sheetname = "PayAtHotel";
		datatable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_PAYATHOTEL);
		int rowcount = datatable.getRowCount(Sheetname);
		Object result[][] = new Object[rowcount - 1][2];
		for (int i = 2; i < rowcount + 1; i++) {
			String email = datatable.getCellData(Sheetname, "Email", i);
			if (email.equalsIgnoreCase("timestamp")) {
				result[i - 2][0] = generic.getEmailasCurrentTimeStamp();
			} else {
				result[i - 2][0] = email;
			}
			result[i - 2][1] = datatable.getCellData(Sheetname, "Expected", i);
		}
		return result;
	}

	
	@Test(dataProvider = "Homepage_Subscription")
	public void TC_ValidateBlankVaalue_subscriberEmail(String Email, String Expected) {
		generic.loadURL(UrlProvider.getHomePageUrl());
		HomePage homePage = new HomePage(driver, generic);
		homePage.fill_subscriber_Email_Txt(Email);
		homePage.click_subscribe_Btn();

		if (Expected.equalsIgnoreCase("Submitted")) {
			Assert.assertTrue(generic.isVisible(HomePage.Subscribe_SuccessMssg_WE), "User is not able to Subcribe!!");
		} else if (Expected.equalsIgnoreCase("AlreadySubmitted")){
			Assert.assertTrue(generic.isVisible(HomePage.Subscribe_AlreadySubscribedMssg_WE), "User is already Subscribed is not Working");
		} else {
			Assert.assertTrue(generic.isVisible(HomePage.Subscribe_WrongEmailMssg_WE), "User is already Subcribed message is not working");
		}
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
