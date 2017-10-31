package com.fabhotels.desktopsite.testsuite.homepage;

import java.text.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.pageobjects.Calendar;
import com.fabhotels.desktopsite.pageobjects.DetailPage;
import com.fabhotels.desktopsite.pageobjects.HomePage;
import com.fabhotels.desktopsite.pageobjects.ListingPage;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.Constants;
import com.fabhotels.desktopsite.utils.UrlProvider;


public class ExecutionSuite_HomePage extends Config {
	SoftAssert softAssert;
	HomePage hp;
	ListingPage lp;
	DetailPage dp;
	Calendar cal;
	Xls_Reader xls = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_HOMEPAGE);

	@BeforeTest
	public void beforeTest() {
		generic = new GenericFunctions(driver);
		driver = generic.startDriver(Driver_Type);
		hp = new HomePage(driver, generic);
		lp = new ListingPage(driver, generic);
		dp = new DetailPage(driver, generic);
		cal = new Calendar(driver, generic);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.manage().deleteAllCookies();
		generic.loadURL_HandlePopup(UrlProvider.getHomePageUrl());
		softAssert = new SoftAssert();
	}


	@Test
	public void TC_ExecutionSuite_HomePage_001_verifyPageHeadline_subHealine_popularCities(){
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL(UrlProvider.getHomePageUrl());
		softAssert.assertTrue(hp.getLabelText_mainTitle_Lbl().contains("Best Budget Hotels"), "Headine is incorrect");
		softAssert.assertEquals(hp.getLabelText_secondaryTitle_Lbl(), "250+ Budget Hotels in India | 20+ Cities");
		softAssert.assertEquals(hp.getLabelText_popularCities_Lbl(), "Popular Cities:");
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_HomePage_002_verifyDateLessSearches(){
		hp.fill_location_Txt("Karol Bagh");
		generic.goToSleep(2000);
		dp.click_firstValueFromLocationSuggestor_Lbl();
		hp.click_find_Fabhotels_Btn();
		assert lp.getText_resultsCountText_Lbl().contains("Budget Hotels in and around Karol Bagh"):"Not redirecting to correct listing page";
	}

	@Test
	public void TC_ExecutionSuite_HomePage_003_verifyWithDateSearches() throws ParseException{
		hp.fill_location_Txt("Koramangala");
		generic.goToSleep(2000);
		dp.click_firstValueFromLocationSuggestor_Lbl();
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE(GenericFunctions.getDateAfterDays("2"),GenericFunctions.getDateAfterDays("4"));
		String chkIn = hp.getElementText_checkIn_Date_WE();
		String chkOu = hp.getElementText_checkOut_Date_WE();
		hp.click_find_Fabhotels_Btn();
		softAssert.assertTrue(lp.getText_resultsCountText_Lbl().contains("Budget Hotels in and around Koramangala"), "Not getting redirected to correct URL");
		softAssert.assertEquals(lp.getText_checkIn_Date_WE(), chkIn);
		softAssert.assertEquals(lp.getText_checkOut_Date_WE(), chkOu);
		softAssert.assertAll();
	}

	@DataProvider(name = "polularCities")
	public Object[][] bookingTest() {
		int rowcount = xls.getRowCount("PopularCities");
		Object result[][] = new Object[rowcount - 1][2];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = xls.getCellData("PopularCities", "CityName", i);
			result[i-2][1]= xls.getCellData("PopularCities", "URL", i);
		}
		return result;
	}

	@Test(dataProvider="polularCities")
	public void TC_ExecutionSuite_HomePage_004_verifyPopularCitiesRedirection(String cityName, String url){
		hp.click_popularCitiesNames_Btn(cityName);
		//generic.switchtoNewWindow();
		generic.goToSleep(2000);
		softAssert.assertEquals(driver.getCurrentUrl(), UrlProvider.getHomePageUrl()+url,"Wrong Url Formed");
		softAssert.assertTrue(lp.getText_resultsCountText_Lbl().contains("Budget Hotels in "+cityName) ,"Page is not getting loaded properly");
		//generic.closeNewWindow();
		//generic.switchtoOriginalWindow();
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_HomePage_005_verifyMostPopularFabhotels(){
		generic.scrollToElement((HomePage.hotelsInDemandCheveron_Btn), false);
		generic.customPageScrollToBottomInSlowMotion(0, 150);
		int i = 1;
		while (!driver.findElement(By.xpath(HomePage.hotelsInDemandCard_Lnk + "[last()]")).isDisplayed()) {
			for (int j = i; j < i + 2; j++) {
				String review = hp.getElementText_hotelsInDemandOnlyReviews_WE(j);
				String getWidth = hp.getWidth_hotelsInDemandOnlyRatings_WE(j);
				System.out.println(hp.getElementText_hotelsInDemandPrices_WE(j).length());
				softAssert.assertTrue(hp.getElementText_hotelsInDemandPrices_WE(j).length() >=5, "Failed Prices for: "+j+" hotel" );
				softAssert.assertTrue(hp.isVisible_hotelsInDemandImages_WE(j), "Failed imagess");
				String hotelName = hp.getElementText_hotelsInDemandName_Lnk(j);
				hp.click_hotelsInDemandName_Lnk(j);
				generic.switchtoNewWindow();
				softAssert.assertTrue(hotelName.equals(dp.getLabelText_hotelName_Lbl()),"Redirection Failed");
				softAssert.assertEquals(dp.getWidth_starRating_WE(), getWidth,"Failed width "+dp.getLabelText_hotelName_Lbl());
				softAssert.assertEquals(dp.getLinkText_reviews_Lnk(), review,"Failed reviews "+dp.getLabelText_hotelName_Lbl());
				driver.close();
				generic.switchtoOriginalWindow();
			}
			i = i + 2;
			if(hp.isVisible_hotelsInDemandCheveron_Btn()){
				hp.click_hotelsInDemandCheveron_Btn();
			}
		}
		softAssert.assertAll();
	}


	@Test
	public void TC_ExecutionSuite_HomePage_006_verifyDealsonHomepage(){
		softAssert.assertEquals(hp.getLabelText_fabulousDealsHeadline_Lbl(), "Fabulous deals");
		softAssert.assertEquals(hp.getLabelText_stayMoreSaveMoreHeadline_Lbl(), "Stay more, Save more");
		hp.click_fifteenPercentOffCard_Lnk();
		generic.switchtoNewWindow();
		generic.goToSleep(2000);
		softAssert.assertEquals(driver.getCurrentUrl(), UrlProvider.getHomePageUrl()+"deals/fab-grab-flat-15-percent-off");
		driver.close();
		generic.switchtoOriginalWindow();
		hp.click_rFourHundredOffCard_Lnk();
		generic.switchtoNewWindow();
		generic.goToSleep(2000);
		softAssert.assertEquals(driver.getCurrentUrl(), UrlProvider.getHomePageUrl()+"deals/fab-grab-rs-400-off");
		driver.close();
		generic.switchtoOriginalWindow();
		hp.click_seeAllOffers_Lnk();
		generic.switchtoNewWindow();
		generic.goToSleep(2000);
		softAssert.assertEquals(driver.getCurrentUrl(), UrlProvider.getHomePageUrl()+"deals-and-offers");
		driver.close();
		generic.switchtoOriginalWindow();
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_HomePage_007_verifyReviewsOnHomepage(){
		softAssert.assertEquals(hp.getLabelText_plusVerifiedReviewsHeadline_Lbl(), "50,000+ verified reviews");
		softAssert.assertEquals(hp.getLabelText_hearFromOurGuestsHeadline_Lbl(), "Hear from our guests");
		hp.click_readAllReviews_Lnk();
		generic.switchtoNewWindow();
		generic.goToSleep(2000);
		softAssert.assertEquals(driver.getCurrentUrl(), UrlProvider.getHomePageUrl()+"customer-reviews");
		driver.close();
		generic.switchtoOriginalWindow();

		generic.scrollToElement((HomePage.reviewsCheveron_Btn), false);
		generic.customPageScrollToBottomInSlowMotion(0, 200);
		int i = 1;
		while (!driver.findElement(By.xpath(HomePage.reviewCards_Lnk + "[last()]")).isDisplayed()) {
			for (int j = i; j < i + 2; j++) {
				softAssert.assertTrue(hp.getLabelText_reviewerNameReviewCard_Lbl(j).length() > 1, "Failed reviewer Name");
				softAssert.assertTrue(hp.isVisible_reviewerRatingReviewCard_Lbl(j), "Failed reviewer rating");
				softAssert.assertTrue(hp.getLabelText_reviewerTextReviewCard_Lbl(j).length() > 5, "Failed reviewer Text");
				softAssert.assertTrue(hp.getLinkText_reviewerHotelNameReviewCard_Lnk(j).length() > 5, "Failed reviewer Text");
				softAssert.assertTrue(hp.getLabelText_reviewerStayDateNameReviewCard_Lbl(j).length() > 5, "Failed reviewer Text");
				String hotelName = hp.getLinkText_reviewerHotelNameReviewCard_Lnk(j);
				hp.click_reviewerHotelNameReviewCard_Lnk(j);
				generic.switchtoNewWindow();
				softAssert.assertTrue(hotelName.equals(dp.getLabelText_hotelName_Lbl()) || driver.getCurrentUrl().contains("hotels-in-hyderabad/"),"Redirection Failed");
				driver.close();
				generic.switchtoOriginalWindow();
			}
			i = i + 2;
			if(hp.isVisible_reviewsCheveron_Btn()){
				hp.click_reviewsCheveron_Btn();
			}
		}
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_HomePage_008_verifyOurHospitalityteamOnHomePage(){
		softAssert.assertEquals(hp.getLabelText_OurHospitalityTeamHeadline_Lbl(), "Our hospitality team");
		softAssert.assertEquals(hp.getLabelText_fabPeopleFabSyatHeadline_Lbl(), "Fab people for a fab stay experience");
		softAssert.assertTrue(hp.getLabelText_hospitalityTeamText_Lbl().length()>100,"Hopitality Team text is missing");
		softAssert.assertTrue(hp.isVisible_hospitalityTeamImage_Txt(),"Hopitality Team Image is missing");
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_HomePage_009_verifyWorkWithUsOnHomePage(){
		softAssert.assertEquals(hp.getLabelText_workWithUsHeadline_Lbl(), "Work with us");
		softAssert.assertEquals(hp.getLabelText_weAreHiringHeadline_Lbl(), "We are hiring awesome folks");
		softAssert.assertTrue(hp.getLabelText_workWithUsTeamText_Lbl().length()>100,"Hopitality Team text is missing");
		softAssert.assertTrue(hp.isVisible_workWithUsImage_WE(),"Hopitality Team Image is missing");
		hp.click_seeAllOpenings_Lnk();
		generic.switchtoNewWindow();
		generic.goToSleep(2000);
		softAssert.assertEquals(driver.getCurrentUrl(), UrlProvider.getHomePageUrl()+"careers");
		driver.close();
		generic.switchtoOriginalWindow();
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_HomePage_010_verifyWeAreSpokenAboutOnHomePage(){
		softAssert.assertEquals(hp.getLabelText_spokenAboutHeadline_Lbl(), "We are being spoken about");
		softAssert.assertEquals(hp.getLabelText_readMediaCoverageHeadline_Lbl(), "Read our media coverage");
		softAssert.assertTrue(hp.isVisible_economicTimesLogo_WE(),"ET Image is missing");
		softAssert.assertTrue(hp.isVisible_forbesLogo_WE(),"Forbes Image is missing");
		softAssert.assertEquals(hp.getLabelText_seriesBfunding_Lbl(), "FabHotels secures $25 million Series B funding led by Goldman Sachs Investment Partners");
		softAssert.assertEquals(hp.getLabelText_expandingRapidly_Lbl(), "Indian Budget Hotel Chain - FabHotels - Is Expanding Rapidly");
		softAssert.assertEquals(hp.getLabelText_economicTimesDate_Lbl(), "26 July 2017 | Source : Economic Times");
		softAssert.assertEquals(hp.getLabelText_forbesDate_Lbl(), "30 Aug 2016 | Source : Forbes");
		hp.click_economicTimes_Lnk();
		generic.switchtoNewWindow();
		generic.waitForCompletePageLoad();
		softAssert.assertEquals(driver.getCurrentUrl(), "https://economictimes.indiatimes.com/small-biz/money/fabhotels-secures-25-million-series-b-funding-led-by-goldman-sachs-investment-partners/articleshow/59769274.cms");
		driver.close();
		generic.switchtoOriginalWindow();
		hp.click_forbes_Lnk();
		generic.switchtoNewWindow();
		generic.waitForCompletePageLoad();
		softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.forbes.com/forbes/welcome/"),"Not getting redirected to forbes");
		driver.close();
		generic.switchtoOriginalWindow();
		hp.click_seeMoreMentions_Lnk();
		generic.switchtoNewWindow();
		softAssert.assertEquals(driver.getCurrentUrl(), UrlProvider.getHomePageUrl()+"press");
		driver.close();
		generic.switchtoOriginalWindow();
		softAssert.assertAll();
	}
	

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
