package com.fabhotels.desktopsite.testsuite.detailpage;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.pageobjects.Calendar;
import com.fabhotels.desktopsite.pageobjects.CheckoutReview;
import com.fabhotels.desktopsite.pageobjects.DetailPage;
import com.fabhotels.desktopsite.pageobjects.ListingPage;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.Constants;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_DetailPage extends Config {
	String Sheetname;
	Xls_Reader datatable;
	DetailPage dp;
	Calendar cal;
	ListingPage lp;
	Xls_Reader xls = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_NEWDETAILSPAGEDATA);

	@BeforeTest
	public void beforeTest() {
		generic = new GenericFunctions(driver);
		driver = generic.startDriver(Driver_Type);
		dp = new DetailPage(driver, generic);
		cal = new Calendar(driver, generic);
		lp = new ListingPage(driver, generic);
	}

	@BeforeMethod()
	public void beforeMethod() {
		driver.manage().deleteAllCookies();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_001_verifyBreadCrumsFunctionality() {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getDetailsPageUrl());
		dp.click_breadCrumbsClickable1_Lnk();
		String url1 = generic.getCurrentUrl();
		driver.navigate().back();
		dp.click_breadCrumbsClickable2_Lnk();
		String url2 = generic.getCurrentUrl();
		softAssert.assertEquals(url1, UrlProvider.getHomePageUrl());
		softAssert.assertEquals(url2, UrlProvider.getListingPageUrl());
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_002_verifyHotelNameAndAddress() {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getDetailsPageUrl());
		String name = dp.getLabelText_hotelName_Lbl();
		String address = dp.getLabelText_hotelsAdress_Lbl();
		softAssert.assertEquals(name, xls.getCellData("Sheet1", "HotelName", 2));
		softAssert.assertEquals(address, xls.getCellData("Sheet1", "HotelAddress", 2));
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_003_verifyRatingNReviewsOnTop() {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		softAssert.assertTrue(dp.isVisible_starRating_WE(), "Star rating on top is not present");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		long beforeScroll = (long) executor.executeScript("return window.pageYOffset;");
		dp.click_reviews_Lnk();
		generic.goToSleep(1000);
		long afterScroll = (long) executor.executeScript("return window.pageYOffset;");
		softAssert.assertEquals(beforeScroll, 0);
		softAssert.assertTrue(afterScroll > 2000,
				"Not getting scrolled to the Ratings and Review Section, Scroll Value is " + afterScroll);
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_004_verifyPeopleLookingAt_LastBooked() {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getDetailsPageUrl());
		softAssert.assertTrue(dp.isVisible_peopleLooking_Lbl(), "People Looking at is not present");
		softAssert.assertTrue(dp.isVisible_lastBooked_Lbl(), "Last booked is not present");
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_005_verifyGalleryOpeningNClosing() {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getDetailsPageUrl());
		dp.click_mainImage_WE();
		softAssert.assertEquals(xls.getCellData("Sheet1", "HotelName", 2), dp.getLabelText_hotelNameGallery_Lbl());
		dp.click_closeGallery_Lnk();
		softAssert.assertTrue(!dp.isVisible_hotelNameGallery_Lbl(), "Gallery doesn't close");
		dp.click_mainImage_WE();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		softAssert.assertTrue(!dp.isVisible_hotelNameGallery_Lbl(), "Gallery doesn't close");
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_006_verifyAllImagesText() {
		generic.loadURL_HandlePopup(UrlProvider.getDetailsPageUrl());
		Assert.assertEquals("+ " + xls.getCellData("Sheet1", "NumberOfPics", 2) + "\n" + "more photos",
				dp.getElementText_moreImages_WE());
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_007_verifyRackRateSellPrice() {
		generic.loadURL_HandlePopup(UrlProvider.getDetailsPageUrl());
		int rackRateInt = 0;
		int sellPriceInt = 0;
		if (dp.isVisible_rackRate_Lbl()) {
			String rackRate = dp.getLabelText_rackRate_Lbl().replace(",", "");
			rackRate = rackRate.replaceAll("\\D+", "");
			rackRateInt = Integer.parseInt(rackRate);
			String sellPrice = dp.getLabelText_price_Lbl().replace(",", "");
			sellPrice = sellPrice.replaceAll("\\D+", "");
			sellPriceInt = Integer.parseInt(sellPrice);
		} else {
			String sellPrice = dp.getLabelText_price_Lbl().replace(",", "");
			sellPrice = sellPrice.replaceAll("\\D+", "");
			sellPriceInt = Integer.parseInt(sellPrice);
			rackRateInt = sellPriceInt + 1;
		}
		Assert.assertTrue(rackRateInt > sellPriceInt, "Rack rate is less than sell price: TC failed ");
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_008_verifySelectRoomsFunctionality_Dateless() {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		long beforeScroll = (long) executor.executeScript("return window.pageYOffset;");
		dp.click_selectRooms_Btn();
		generic.goToSleep(1000);
		long afterScroll = (long) executor.executeScript("return window.pageYOffset;");
		softAssert.assertEquals(beforeScroll, 0);
		System.out.println(afterScroll);
		softAssert.assertTrue(afterScroll > 100, "");
		softAssert.assertTrue(dp.isVisible_calanderMiddle_WE(), "");
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_009_verifySelectRoomsFunctionality_withDate() throws ParseException {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE(GenericFunctions.getDateAfterDays("1"),
				GenericFunctions.getDateAfterDays("3"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		long beforeScroll = (long) executor.executeScript("return window.pageYOffset;");
		dp.click_selectRooms_Btn();
		generic.goToSleep(1000);
		long afterScroll = (long) executor.executeScript("return window.pageYOffset;");
		softAssert.assertEquals(beforeScroll, 0);
		System.out.println(afterScroll);
		softAssert.assertTrue(afterScroll > 1000, "");
		softAssert.assertTrue(dp.isVisible_numberOfRoomsSelectionAll_Btn(), "");
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_010_verifyHeaderLinksText() {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		softAssert.assertEquals("Overview", dp.getLinkText_overviewHeader_Lnk());
		softAssert.assertEquals("Amenities", dp.getLinkText_amenitiesHeader_Lnk());
		softAssert.assertEquals("Room Types", dp.getLinkText_roomTypesHeader_Lnk());
		softAssert.assertEquals("Why this Hotel", dp.getLinkText_whyThisHotelheader_Lnk());
		softAssert.assertEquals("Ratings and Reviews", dp.getLinkText_rNrHeader_Lnk());
		softAssert.assertEquals("Hotel Policies", dp.getLinkText_hotelPoliciesHeader_Lnk());
		dp.click_overviewHeader_Lnk();
		generic.goToSleep(1000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		long a = (long) executor.executeScript("return window.pageYOffset;");
		dp.click_amenitiesHeader_Lnk();
		generic.goToSleep(1000);
		long b = (long) executor.executeScript("return window.pageYOffset;");
		dp.click_roomTypesHeader_Lnk();
		generic.goToSleep(1000);
		long c = (long) executor.executeScript("return window.pageYOffset;");
		dp.click_whyThisHotelheader_Lnk();
		generic.goToSleep(1000);
		long d = (long) executor.executeScript("return window.pageYOffset;");
		dp.click_rNrHeader_Lnk();
		generic.goToSleep(1000);
		long e = (long) executor.executeScript("return window.pageYOffset;");
		dp.click_hotelPoliciesHeader_Lnk();
		generic.goToSleep(1000);
		long f = (long) executor.executeScript("return window.pageYOffset;");
		System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f);
		softAssert.assertTrue(a > 300, "");
		softAssert.assertTrue(b > 700, "");
		softAssert.assertTrue(c > 1000, "");
		softAssert.assertTrue(d > 2000, "");
		softAssert.assertTrue(e > 2100, "");
		softAssert.assertTrue(f > 2500, "");
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_011_verifyWhyFabhotelsSection() {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getDetailsPageUrl());
		softAssert.assertEquals("Best reviewed chain", dp.getElementText_bestRevChain_WE());
		softAssert.assertEquals("Most centrally located", dp.getElementText_centrallyLocated_WE());
		softAssert.assertEquals("Most Value for Money hotels", dp.getElementText_valueMoney_WE());
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_012_verifyRatingReview_MapSection() {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		softAssert.assertEquals(dp.getElementText_ratings_WE(), "Ratings");
		softAssert.assertEquals(dp.getElementText_numericRating_WE(), "5.0");
		softAssert.assertEquals(dp.getElementText_topReview_WE(), "Top Review");
		softAssert.assertEquals(dp.getElementText_topReviewValue_WE(),
				"A nice and a clean hotel.....I have earlier also recommended");
		softAssert.assertEquals(dp.getElementText_ratedVeryGood_WE(), "Rated very good across 1 Reviews");
		softAssert.assertTrue(dp.isVisible_ratingsLogo_WE(), "");
		softAssert.assertEquals(dp.getElementText_propertyNameOnMap_WE(), xls.getCellData("Sheet1", "HotelName", 3));
		softAssert.assertEquals(dp.getElementText_landmarkOnMap_WE(), "Landmark: Daman");
		dp.click_getDirectionOnMap_Lnk();
		generic.switchtoNewWindow();
		generic.goToSleep(2000);
		softAssert.assertTrue(generic.getCurrentUrl().contains("https://www.google.com/maps/dir//"),
				"Not getting redirected to Maps");
		softAssert.assertAll();
		driver.close();
		generic.switchtoOriginalWindow();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_013_verifyAllAmenities() {
		generic.loadURL_HandlePopup(UrlProvider.getDetailsPageUrl());
		Assert.assertEquals(
				dp.getElementText_allAmenities_WE(), "Breakfast" + "\n" + "24X7 Security" + "\n" + "Free Wifi" + "\n"
						+ "100% Power Backup" + "\n" + "News Paper" + "\n" + "Air Conditioner",
				"Amenities are not matching the  expected ones.");
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_014_verifyRoomSelectionMultipleRoomTypes() throws ParseException {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		generic.refreshPage();
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE(GenericFunctions.getDateAfterDays("10"),
				GenericFunctions.getDateAfterDays("20"));
		dp.click_selectRooms_Btn();
		softAssert.assertTrue(dp.isDisabled_roomNumber(1, 0), "Initial 0 is enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(2, 0), "Initial 0 is enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(3, 0), "Initial 0 is enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(4, 0), "Initial 0 is enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(5, 0), "Initial 0 is enabled");
		dp.click_roomNumber(1, 1);
		dp.selectPeopleDropDown(1, 1, 3);
		softAssert.assertTrue(dp.isEnabled_roomNumber(1, 0), "Zero  is not enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(2, 0), "Initial 0 is enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(3, 0), "Initial 0 is enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(4, 0), "Initial 0 is enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(5, 0), "Initial 0 is enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(2, 5), "Room 5 is Enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(3, 5), "Room 5 is Enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(4, 5), "Room 5 is Enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(5, 5), "Room 5 is Enabled");
		dp.click_roomNumber(2, 1);
		dp.selectPeopleDropDown(2, 1, 3);
		dp.click_roomNumber(3, 1);
		dp.selectPeopleDropDown(3, 1, 3);
		dp.click_roomNumber(4, 1);
		dp.selectPeopleDropDown(4, 1, 3);
		dp.click_roomNumber(5, 1);
		dp.selectPeopleDropDown(5, 1, 3);
		softAssert.assertTrue(dp.isEnabled_roomNumber(1, 0), "Zero  is not enabled");
		softAssert.assertTrue(dp.isEnabled_roomNumber(2, 0), "Zero  is not enabled");
		softAssert.assertTrue(dp.isEnabled_roomNumber(3, 0), "Zero  is not enabled");
		softAssert.assertTrue(dp.isEnabled_roomNumber(4, 0), "Zero  is not enabled");
		softAssert.assertTrue(dp.isEnabled_roomNumber(5, 0), "Zero  is not enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(1, 2), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(2, 2), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(3, 2), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(4, 2), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(5, 2), "Room 2 is Enabled");
		softAssert.assertEquals(dp.getLabelText_exTaxesFooter_Lbl(), "GST Extra");
		softAssert.assertEquals(dp.getLabelText_datesRoomsFooter_Lbl(), GenericFunctions.getDateAfterDays3format("10")
				+ " - " + GenericFunctions.getDateAfterDays3format("20") + " | " + "5 Rooms");
		softAssert.assertEquals(dp.getElementText_roomsSelectedFooter_WE(),
				"Adeon" + "\n" + "1 Room" + "\n" + "( 3 Guests )" + "\n" + "Bluotrix" + "\n" + "1 Room" + "\n"
						+ "( 3 Guests )" + "\n" + "Cajax" + "\n" + "1 Room" + "\n" + "( 3 Guests )" + "\n" + "Delta"
						+ "\n" + "1 Room" + "\n" + "( 3 Guests )" + "\n" + "Eriene" + "\n" + "1 Room" + "\n"
						+ "( 3 Guests )",
				"Footer is not displying data in sync");
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_015_verifySomeRoomTypeSoldOut() throws ParseException {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(
				UrlProvider.getHomePageUrl() + "hotels-in-gotham/fabhotel-some-rooms-sold-out.html");
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE(GenericFunctions.getDateAfterDays("30"),
				GenericFunctions.getDateAfterDays("32"));
		dp.click_checkAvailabilityOnTop_Btn();
		softAssert.assertTrue(dp.isSoldOut_roomType(2), "Sold Out Lablel is not displayed.");
		softAssert.assertTrue(dp.isDisabled_roomNumber(2, 0), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(2, 5), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isSoldOut_roomType(4), "Sold Out Lablel is not displayed.");
		softAssert.assertTrue(dp.isDisabled_roomNumber(4, 0), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(4, 5), "Room 2 is Enabled");
		softAssert.assertEquals(dp.getText_roomsLeft_roomType(1), "3 ROOMS LEFT");
		softAssert.assertEquals(dp.getText_roomsLeft_roomType(3), "1 ROOM LEFT");
		softAssert.assertTrue(dp.isDisabled_roomNumber(1, 0), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(1, 4), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isEnabled_roomNumber(1, 3), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(3, 0), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(3, 2), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isEnabled_roomNumber(3, 1), "Room 2 is Enabled");
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_016_verifyPropertySoldOut() throws ParseException {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getHomePageUrl() + "hotels-in-gotham/fabhotel-bikahua.html");
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE(GenericFunctions.getDateAfterDays("0"),
				GenericFunctions.getDateAfterDays("2"));
		dp.click_checkAvailabilityOnTop_Btn();
		softAssert.assertEquals(dp.getLabelText_soldOutErrorMessage_Lbl(),
				"This hotel is SOLD OUT for selected dates. Change dates or explore nearby Hotels.");
		softAssert.assertTrue(dp.isVisible_exploreNearbyTop_WE(), "Explore more option is not coming on top");
		softAssert.assertEquals(dp.getLabelText_soldOutOnMainImage_Lbl(), "SOLD OUT");
		softAssert.assertTrue(dp.isDisabled_selectRoomsDisabled_Btn(), "Button is not disabled.");
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_017_verifyCheckAvailability_MiddleOne() throws ParseException {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(
				UrlProvider.getHomePageUrl() + "hotels-in-gotham/fabhotel-some-rooms-sold-out.html");
		cal.Select_CheckIn_CheckOut_Date_SecondCalendaronDEtailsPage_WE(GenericFunctions.getDateAfterDays("2"),
				GenericFunctions.getDateAfterDays("5"));
		dp.click_checkAvailabilityInMiddle_Btn();
		softAssert.assertTrue(dp.isSoldOut_roomType(2), "Sold Out Lablel is not displayed.");
		softAssert.assertTrue(dp.isDisabled_roomNumber(2, 0), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(2, 5), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isSoldOut_roomType(4), "Sold Out Lablel is not displayed.");
		softAssert.assertTrue(dp.isDisabled_roomNumber(4, 0), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(4, 5), "Room 2 is Enabled");
		softAssert.assertEquals(dp.getText_roomsLeft_roomType(1), "3 ROOMS LEFT");
		softAssert.assertEquals(dp.getText_roomsLeft_roomType(3), "1 ROOM LEFT");
		softAssert.assertTrue(dp.isDisabled_roomNumber(1, 0), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(1, 4), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isEnabled_roomNumber(1, 3), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(3, 0), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isDisabled_roomNumber(3, 2), "Room 2 is Enabled");
		softAssert.assertTrue(dp.isEnabled_roomNumber(3, 1), "Room 2 is Enabled");
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_018_verifyStaticTexts_RoomSelection() {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		softAssert.assertEquals(dp.getLinkText_roomTypesHeader_Lnk(), "Room Types");
		softAssert.assertEquals(dp.getLabelText_roomTypesMaxNumbers_Lbl(), "(Maximum 5 rooms allowed per booking)");
		int i = 5;
		while (i == 0) {
			softAssert.assertEquals(dp.getText_roomTypesMaxGuests_Lbl(i), "max 3 guests/room");
			softAssert.assertEquals(dp.getText_roomType_selectDates_Lbl(i),
					" * Select dates to check prices and availability ");
			i--;
		}
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_019_verifyHotelDescription() {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		softAssert.assertEquals(dp.getLinkText_whyThisHotelheader_Lnk(), "Why this Hotel");
		softAssert.assertEquals(dp.getLinkText_readMore_Lnk(), "Read More");
		dp.click_readMore_Lnk();
		softAssert.assertEquals(dp.getLinkText_readLess_Lnk(), "Read Less");
		dp.click_readLess_Lnk();
		softAssert.assertEquals(dp.getLinkText_readMore_Lnk(), "Read More");
		softAssert.assertTrue(dp.getElementText_descriptionExpanded_WE().length() > 150, "");
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_020_verifyRatingsAndReviews() {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getDetailsPageUrl());
		String topReview = dp.getLinkText_reviews_Lnk();
		String midReview = dp.getElementText_ratedVeryGood_WE();
		String bottomReview = dp.getLabelText_ratedInBlock_Lbl();
		softAssert.assertTrue(midReview.contains(topReview), "Match Reviews Failed");
		softAssert.assertEquals(midReview, bottomReview);
		String topRating = dp.getElementText_numericRating_WE();
		String bottomRating = dp.getLabelText_ratingNumbers_Lbl();
		softAssert.assertEquals(topRating, bottomRating);
		String view10more = dp.getLinkText_viewMoreReviews_Lnk();
		String writtenReviews = dp.getLabelText_reviewsInRatingBlockBracket_Lbl();
		writtenReviews = writtenReviews.replace("(", "");
		writtenReviews = writtenReviews.replace(")", "");
		writtenReviews = writtenReviews.toLowerCase();
		softAssert.assertTrue(view10more.contains(writtenReviews), "Number of written reviews did not match.");
		dp.click_viewMoreReviews_Lnk();
		generic.goToSleep(2000);
		softAssert.assertEquals(dp.writtenReviewsCount(), 21);
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_021_verifyExploreMore() {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(
				UrlProvider.getHomePageUrl() + "hotels-in-goa/fabhotel-the-kings-court-calangute.html");
		generic.scrollToElement(By.xpath(DetailPage.cheveronNextNearby_Btn), false);
		int i = 1;
		while (!driver.findElement(By.xpath(DetailPage.exploreMorePropertiesCard_WE + "[last()]")).isDisplayed()) {
			for (int j = i; j < i + 2; j++) {
				softAssert.assertTrue(dp.getLabelText_hotelNameNearby_Lbl(j).length() > 5, "Failed Property Name");
				softAssert.assertTrue(dp.getLabelText_locationNearby_Lbl(j).length() > 5, "Failed Location");
				softAssert.assertTrue(dp.getLabelText_reviewsAndRatingNearby_Lbl(j).length() > 5,
						"Failed review and ratings");
				softAssert.assertTrue(dp.getLinkText_reviewsOnlyNearby_Lnk(j).length() > 5, "Failed review only");
				softAssert.assertTrue(dp.getLabelText_peopleBookingNowNearby_Lbl(j).length() > 5,
						"Failed people Looking at it");
				softAssert.assertTrue(dp.getLabelText_sellPriceNearBy_Lbl(j).length() > 3, "Failed sell price");
				softAssert.assertTrue(dp.isVisible_bookNowNearBy_Btn(j), "Failed review and ratings");
			}
			i = i + 2;
			dp.click_cheveronNextNearby_Btn();
		}
		softAssert.assertEquals(dp.getLabelText_exploreMoreSectionHeadline_Lbl(),
				"Explore more hotels near FabHotel The King's Court Calangute");
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_022_VerifyHotelPolicies() {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getDetailsPageUrl());
		softAssert.assertEquals(dp.getLabelText_hotelPolicies_Lbl(), "Hotel Policies");
		softAssert.assertTrue(dp.isVisible_hotelPolicies_WE(), "Hotel Policies section is missing");
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_023_VerifyNameInSearchBar() {
		generic.loadURL_HandlePopup(UrlProvider.getDetailsPageUrl());
		Assert.assertEquals(dp.getText_searchBox_WE(), xls.getCellData("Sheet1", "HotelName", 2));
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_024_verifySeachFromDetails() throws ParseException {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getDetailsPageUrl());
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE(GenericFunctions.getDateAfterDays("0"),
				GenericFunctions.getDateAfterDays("2"));
		dp.click_checkAvailabilityOnTop_Btn();
		dp.clear_searchBox_WE();
		dp.fill_searchBox_WE("Banglore");
		generic.goToSleep(2000);
		dp.click_firstValueFromLocationSuggestor_Lbl();
		dp.click_checkAvailabilityOnTop_Btn();
		softAssert.assertTrue(lp.getText_resultsCountText_Lbl().contains("Budget Hotels in Bangalore"),
				"Not redirecting to list page");
		softAssert.assertEquals(lp.getText_checkIn_Date_WE(), GenericFunctions.getDateAfterDays3format("0"));
		softAssert.assertEquals(lp.getText_checkOut_Date_WE(), GenericFunctions.getDateAfterDays3format("2"));
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_025_verifyREdirectionFRomExploreMore() {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getDetailsPageUrl());
		String propName = dp.getLabelText_hotelNameNearby_Lbl(1);
		String sellPrice = dp.getLabelText_sellPriceNearBy_Lbl(1);
		dp.click_bookNowNearBy_Btn(1);
		generic.goToSleep(2000);
		driver.navigate().refresh();
		softAssert.assertEquals(dp.getLabelText_hotelName_Lbl(), propName);
		softAssert.assertEquals(dp.getLabelText_price_Lbl(), sellPrice);
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_026_verifyPropertySoldOutAndDatesModifiedToBookHotel()
			throws ParseException {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getHomePageUrl() + "hotels-in-gotham/fabhotel-bikahua.html");
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE(GenericFunctions.getDateAfterDays("0"),
				GenericFunctions.getDateAfterDays("2"));
		dp.click_checkAvailabilityOnTop_Btn();
		softAssert.assertEquals(dp.getLabelText_soldOutErrorMessage_Lbl(),
				"This hotel is SOLD OUT for selected dates. Change dates or explore nearby Hotels.");
		softAssert.assertTrue(dp.isVisible_exploreNearbyTop_WE(), "Explore more option is not coming on top");
		softAssert.assertEquals(dp.getLabelText_soldOutOnMainImage_Lbl(), "SOLD OUT");
		softAssert.assertTrue(dp.isDisabled_selectRoomsDisabled_Btn(), "Button is not disabled.");
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE("01 January 2018", "04 January 2018");
		dp.click_checkAvailabilityOnTop_Btn();
		generic.goToSleep(2000);
		dp.click_roomNumber(2, 2);
		dp.click_bookNowFooter_Btn();
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_027_verifyBookingAcrossTheYear() throws ParseException {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE("31 December 2017", "02 January 2018");
		dp.click_checkAvailabilityOnTop_Btn();
		softAssert.assertEquals(dp.GetText_CheckOutDate_WE(), "02 Jan 2018");
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_028_verifyNotRelevant10RoomsLeft() throws ParseException {
		generic.loadURL_HandlePopup(UrlProvider.getHomePageUrl()
				+ "hotels-in-gotham/fabhotel-maple.html?locationsearch=Gotham&checkIn=30+Dec+2017&checkOut=31+Dec+2017&propertyDetailSearch=&occupancy%5B%5D=1&occupancy%5B%5D=1&occupancy%5B%5D=1&occupancy%5B%5D=1&occupancy%5B%5D=1&rooms=5&location_text=Gotham&locality_text=Gotham&location_list=&city=Gotham&nearcity=gotham&radius=8&ga_page_type=SearchPage");
		dp.click_selectRooms_Btn();
		generic.goToSleep(1000);
		dp.click_roomNumber(1, 1);
		generic.goToSleep(1000);
		dp.click_roomNumber(1, 2);
		generic.goToSleep(1000);
		Assert.assertTrue(!dp.isVisible_roomsLeft_roomType(1), "Rooms left message should not come");
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_029_verifyDAtesOfDifferentMonth() throws ParseException {
		generic.loadURL_HandlePopup(UrlProvider.getGothamPropertyPageUrl());
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE("30 March 2018", "02 April 2018");
		dp.click_checkAvailabilityOnTop_Btn();
		generic.goToSleep(1000);
		dp.click_roomNumber(1, 1);
		generic.goToSleep(1000);
		dp.click_roomNumber(1, 2);
		generic.goToSleep(1000);
		dp.click_bookNowFooter_Btn();
		generic.explicitlyWaitForElement(By.xpath(CheckoutReview.continue_Btn));
		Assert.assertEquals(generic.getCurrentUrl(), UrlProvider.getHomePageUrl() + "checkout/review");
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_030_verifyPageScrolled_SoldOut_MiddleCalander() throws ParseException {
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getHomePageUrl() + "hotels-in-gotham/fabhotel-bikahua.html");
		cal.Select_CheckInOnly_SecondCalendaronDEtailsPage_WE(GenericFunctions.getDateAfterDays("0"));
		dp.click_checkAvailabilityInMiddle_Btn();
		softAssert.assertEquals(dp.getLabelText_soldOutErrorMessage_Lbl(),
				"This hotel is SOLD OUT for selected dates. Change dates or explore nearby Hotels.");
		softAssert.assertTrue(dp.isVisible_exploreNearbyTop_WE(), "Explore more option is not coming on top");
		softAssert.assertEquals(dp.getLabelText_soldOutOnMainImage_Lbl(), "SOLD OUT");
		softAssert.assertTrue(dp.isDisabled_selectRoomsDisabled_Btn(), "Button is not disabled.");
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_031_VerifyThatAllThereviewsAndRatingsareInSync(){
		SoftAssert softAssert = new SoftAssert();
		generic.loadURL_HandlePopup(UrlProvider.getHomePageUrl() + "hotels-in-new-delhi/fabhotel-checkin-by-oran-cp.html");
		String rating1 = dp.getWidth_ratingsLogo_WE();
		String rating2 = dp.getWidth_starRating_WE();
		String rating3 = dp.getWidth_starsInRatingBlock_WE();
		String reviewsNumber1 = dp.getLinkText_reviews_Lnk();
		String reviewsNumber2 = dp.getElementText_ratedVeryGood_WE();
		String reviewsNumber3 = dp.getLabelText_ratedInBlock_Lbl();
		softAssert.assertEquals(rating1, rating2,"Ratings 1 and 2 did not match");
		softAssert.assertEquals(rating3, rating2,"Ratings 3 and 2 did not match");
		softAssert.assertEquals(reviewsNumber2, reviewsNumber3,"Reviews 3 and 2 did not match");
		softAssert.assertTrue(reviewsNumber2.contains(reviewsNumber1), "Reviews 1 and 2 did not match");
		softAssert.assertEquals(dp.getElementText_numericRating_WE(), dp.getLabelText_ratingNumbers_Lbl(),"Ratings are different");
		double rating = Double.parseDouble(dp.getElementText_numericRating_WE());
		rating = rating*20;
		int rat1 = (int) rating;
		softAssert.assertEquals("width: "+rat1+"%;",dp.getWidth_ratingsLogo_WE(),"Ratings are different");
		softAssert.assertAll();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}