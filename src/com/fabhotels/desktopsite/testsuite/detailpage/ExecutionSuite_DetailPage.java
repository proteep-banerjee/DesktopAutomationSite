package com.fabhotels.desktopsite.testsuite.detailpage;

import java.text.ParseException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
import com.fabhotels.desktopsite.pageobjects.DetailPage;
import com.fabhotels.desktopsite.pageobjects.ListingPage;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_DetailPage extends Config {
	String Sheetname;
	Xls_Reader datatable;
	DetailPage dp;
	GenericFunctions generic;
	WebDriver driver;
	SoftAssert softAssert;
	Calendar cal;

	@BeforeTest
	public void beforeTest() {
		generic = new GenericFunctions(driver);
		driver = generic.startDriver(Driver_Type);
		generic.loadURL(UrlProvider.getDetailsPageUrl());
		dp = new DetailPage(driver, generic);
		cal = new Calendar(driver, generic);
		softAssert = new SoftAssert();
	}

	@BeforeMethod
	public void beforeMethod() {
		generic.dissMissPopUPTimer(ListingPage.popCloseButton_Btn);
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_001_verifyBreadCrumsFunctionality(){
		dp.click_breadCrumbsClickable1_Lnk();
		String url1=generic.getCurrentUrl();
		driver.navigate().back();
		dp.click_breadCrumbsClickable2_Lnk();
		String url2=generic.getCurrentUrl();
		softAssert.assertEquals(url1, UrlProvider.getHomePageUrl());
		softAssert.assertEquals(url2, UrlProvider.getListingPageUrl());
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_002_verifyHotelNameAndAddress(){
		String name=dp.getLabelText_hotelName_Lbl();
		String address= dp.getLabelText_hotelsAdress_Lbl();
		softAssert.assertEquals(name, "FabHotel Check'In By Oran CP");
		softAssert.assertEquals(address, "104, Babar Road, Barakhamba Avenue, Opp World Trade Center, Connaught Place, New Delhi, India");
		softAssert.assertAll();
	}


	@Test
	public void TC_ExecutionSuite_DetailPage_003_verifyRatingNReviewsOnTop(){
		softAssert.assertTrue(dp.isVisible_starRating_WE(), "Star rating on top is not present");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Long beforeScroll = (Long) executor.executeScript("return window.pageYOffset;");
		dp.click_reviews_Lnk();
		generic.goToSleep(1000);
		Long afterScroll = (Long) executor.executeScript("return window.pageYOffset;");
		softAssert.assertEquals(beforeScroll,(long) 0);
		softAssert.assertEquals(afterScroll, (long)2070);
		softAssert.assertAll();
	}	

	@Test
	public void TC_ExecutionSuite_DetailPage_004_verifyPeopleLookingAt_LastBooked(){
		softAssert.assertTrue(dp.isVisible_peopleLooking_Lbl(), "People Looking at is not present");
		softAssert.assertTrue(dp.isVisible_lastBooked_Lbl(), "Last booked is not present");
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_005_verifyGalleryOpeningNClosing(){
		dp.click_mainImage_WE();
		softAssert.assertEquals("FabHotel Check'In By Oran CP", dp.getLabelText_hotelNameGallery_Lbl());
		dp.click_closeGallery_Lnk();
		softAssert.assertTrue(!dp.isVisible_hotelNameGallery_Lbl(), "Gallery doesn't close");
		dp.click_mainImage_WE();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		softAssert.assertTrue(!dp.isVisible_hotelNameGallery_Lbl(), "Gallery doesn't close");
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_006_verifyAllImagesText(){
		Assert.assertEquals("+ 20"+"\n"+ "more photos", dp.getElementText_moreImages_WE());
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_007_verifyRackRateSellPrice(){
		int rackRateInt=0;
		int sellPriceInt=0;
		if(dp.isVisible_rackRate_Lbl()){
			String rackRate =dp.getLabelText_rackRate_Lbl().replace(",", "");
			rackRate = rackRate.replace("₹ ", "");
			rackRateInt =Integer.parseInt(rackRate);
			String sellPrice = dp.getLabelText_price_Lbl().replace(",", "");
			sellPrice = sellPrice.replace("₹ ", "");
			sellPriceInt=Integer.parseInt(sellPrice);
		}else{
			String sellPrice = dp.getLabelText_price_Lbl().replace(",", "");
			sellPrice = sellPrice.replace("₹ ", "");
			sellPriceInt=Integer.parseInt(sellPrice);
			rackRateInt =sellPriceInt+1;
		}
		Assert.assertTrue(rackRateInt > sellPriceInt, "Rack rate is less than sell price: TC failed ");
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_008_verifySelectRoomsFunctionality_Dateless(){
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Long beforeScroll = (Long) executor.executeScript("return window.pageYOffset;");
		dp.click_selectRooms_Btn();
		generic.goToSleep(1000);
		Long afterScroll = (Long) executor.executeScript("return window.pageYOffset;");
		softAssert.assertEquals(beforeScroll,(long) 0);
		softAssert.assertEquals(afterScroll, (long)1147);
		softAssert.assertTrue(dp.isVisible_calanderMiddle_WE());
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_009_verifySelectRoomsFunctionality_withDate() throws ParseException{
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE(GenericFunctions.getDateAfterDays("1"), GenericFunctions.getDateAfterDays("3"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Long beforeScroll = (Long) executor.executeScript("return window.pageYOffset;");
		dp.click_selectRooms_Btn();
		generic.goToSleep(1000);
		Long afterScroll = (Long) executor.executeScript("return window.pageYOffset;");
		softAssert.assertEquals(beforeScroll,(long) 0);
		softAssert.assertEquals(afterScroll, (long)1279);
		softAssert.assertTrue(dp.isVisible_numberOfRoomsSelectionAll_Btn());
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_010_verifyHeaderLinksText(){
		softAssert.assertEquals("Overview", dp.getLinkText_overviewHeader_Lnk());
		softAssert.assertEquals("Amenities", dp.getLinkText_amenitiesHeader_Lnk());
		softAssert.assertEquals("Room Types", dp.getLinkText_roomTypesHeader_Lnk());
		softAssert.assertEquals("Why this Hotel", dp.getLinkText_whyThisHotelheader_Lnk());
		softAssert.assertEquals("Ratings and Reviews", dp.getLinkText_rNrHeader_Lnk());
		softAssert.assertEquals("Hotel Policies", dp.getLinkText_hotelPoliciesHeader_Lnk());
		dp.click_overviewHeader_Lnk();generic.goToSleep(1000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Long a = (Long) executor.executeScript("return window.pageYOffset;");
		dp.click_amenitiesHeader_Lnk();generic.goToSleep(1000);
		Long b = (Long) executor.executeScript("return window.pageYOffset;");
		dp.click_roomTypesHeader_Lnk();generic.goToSleep(1000);
		Long c = (Long) executor.executeScript("return window.pageYOffset;");
		dp.click_whyThisHotelheader_Lnk();generic.goToSleep(1000);
		Long d = (Long) executor.executeScript("return window.pageYOffset;");
		dp.click_rNrHeader_Lnk();generic.goToSleep(1000);
		Long e = (Long) executor.executeScript("return window.pageYOffset;");
		dp.click_hotelPoliciesHeader_Lnk();generic.goToSleep(1000);
		Long f = (Long) executor.executeScript("return window.pageYOffset;");
		softAssert.assertTrue(a==529L);
		softAssert.assertTrue(b==967L);
		softAssert.assertTrue(c==1196L);
		softAssert.assertTrue(d==1725L);
		softAssert.assertTrue(e==2119L);
		softAssert.assertTrue(f==3590L);
		softAssert.assertAll();
	}


	@Test
	public void TC_ExecutionSuite_DetailPage_011_verifyWhyFabhotelsSection(){
		softAssert.assertEquals("Best reviewed chain", dp.getElementText_bestRevChain_WE());
		softAssert.assertEquals("Most centrally located", dp.getElementText_centrallyLocated_WE());
		softAssert.assertEquals("Most Value for Money hotels", dp.getElementText_valueMoney_WE());
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_012_verifyRatingReview_MapSection(){
		softAssert.assertEquals(dp.getElementText_ratings_WE(), "Ratings");
		softAssert.assertEquals(dp.getElementText_numericRating_WE(), "3.4");
		softAssert.assertEquals(dp.getElementText_topReview_WE(), "Top Review");
		softAssert.assertEquals(dp.getElementText_topReviewValue_WE(), "we had a very nice time at the hotel. hotel ambience was good.");
		softAssert.assertEquals(dp.getElementText_ratedVeryGood_WE(), "Rated very good across 431 Reviews");
		softAssert.assertTrue(dp.isVisible_ratingsLogo_WE());
		softAssert.assertEquals(dp.getElementText_propertyNameOnMap_WE(),"FabHotel Check'In By Oran CP");
		softAssert.assertEquals(dp.getElementText_landmarkOnMap_WE(),"Landmark: Opposite Worl");
		dp.click_getDirectionOnMap_Lnk();
		generic.switchtoNewWindow();
		softAssert.assertTrue(generic.getCurrentUrl().contains("https://www.google.com/maps/dir//"), "Not getting redirected to Maps");
		softAssert.assertAll();
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_013_verifyAllAmenities(){
		Assert.assertEquals(dp.getElementText_allAmenities_WE(),"Breakfast"+"\n"+"24X7 Security"+"\n"+"Free Wifi"+"\n"+"Lift"+"\n"+"In Room Dining"+"\n"+"Air Conditioner","Amenities are not matching the  expected ones.");
	}

	@Test
	public void TC_ExecutionSuite_DetailPage_014_verifyRoomSelectionMultipleRoomTypes() throws ParseException{
		generic.loadURL(UrlProvider.getHomePageUrl()+"hotels-in-gotham/fabhotel-instructor-wow.html");
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE(GenericFunctions.getDateAfterDays("10"), GenericFunctions.getDateAfterDays("20"));
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
		softAssert.assertEquals(dp.getLabelText_datesRoomsFooter_Lbl(), GenericFunctions.getDateAfterDays3format("10")+" - "+GenericFunctions.getDateAfterDays3format("20")+" | "+"5 Rooms");
		softAssert.assertEquals(dp.getElementText_roomsSelectedFooter_WE(),"Adeon"+"\n"+"1 Room"+"\n"+"( 3 Guests )"+"\n"+"Bluotrix"+"\n"+"1 Room"+"\n"+"( 3 Guests )"+"\n"+"Cajax"+"\n"+"1 Room"+"\n"+"( 3 Guests )"+"\n"+"Delta"+"\n"+"1 Room"+"\n"+"( 3 Guests )"+"\n"+"Eriene"+"\n"+"1 Room"+"\n"+"( 3 Guests )","Footer is not displying data in sync");
		softAssert.assertAll();
	}
	

	@Test
	public void TC_ExecutionSuite_DetailPage_015_verifySomeRoomTypeSoldOut() throws ParseException{
		driver.get(UrlProvider.getHomePageUrl()+"hotels-in-gotham/fabhotel-some-rooms-sold-out.html");
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE(GenericFunctions.getDateAfterDays("0"), GenericFunctions.getDateAfterDays("2"));
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
	public void TC_ExecutionSuite_DetailPage_016_verifyPropertySoldOut() throws ParseException{
		driver.get(UrlProvider.getHomePageUrl()+"hotels-in-gotham/fabhotel-sold-out.html");
		cal.Select_CheckIn_CheckOut_Date_Calendar_WE(GenericFunctions.getDateAfterDays("0"), GenericFunctions.getDateAfterDays("2"));
		dp.click_checkAvailabilityOnTop_Btn();
		softAssert.assertEquals(dp.getLabelText_soldOutErrorMessage_Lbl(), "This hotel is SOLD OUT for selected dates. Change dates or explore nearby Hotels.");
		softAssert.assertTrue(dp.isVisible_exploreNearbyTop_WE(), "Explore more option is not coming on top");
		softAssert.assertEquals(dp.getLabelText_soldOutOnMainImage_Lbl(), "SOLD OUT");
		softAssert.assertTrue(dp.isDisabled_selectRoomsDisabled_Btn(), "Button is not disabled.");
		softAssert.assertAll();
	}





	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
