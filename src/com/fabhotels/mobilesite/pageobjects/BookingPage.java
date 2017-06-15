package com.fabhotels.mobilesite.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class BookingPage {

	WebDriver driver;
	GenericFunctions generic;
	SoftAssert softAssert;

	public static final By seeAllBookings_Btn = By.linkText("See all bookings");
	public static final By getDirections_Btn = By.xpath("(//a[contains(text(),'Get Directions')])[1]");
	public static final By booking_Btn = By.xpath("(//a[contains(@href,'/user/bookings/')])[1]");
	public static final By logOut_Btn = By.partialLinkText("LOGOUT");
	public static final By cancelLogOut_Btn = By.xpath("//span[text()='CANCEL']");
	public static final By confirmLogOut_Btn = By.xpath("//span[text()='LOGOUT']");
	public static final String editProfile_Btn = "//a[@class='edit__profile']";
	public static final String getHotelName_Txt = "(//div[@class='content']/h3)";

	public BookingPage(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;

	}

	public void positive_Bookings() {
		generic.click(seeAllBookings_Btn);
		// directions();
		click_AllDirections();
		click_AllBookings();
	}

	public void click_editProfile_Btn() {
		generic.click(editProfile_Btn);
	}

	public void directions() {
		WebElement selectBox = driver.findElement(getDirections_Btn);
		List<WebElement> options = selectBox.findElements(getDirections_Btn);
		System.out.println("size :" + options.size());
		for (WebElement option : options) {
			selectBox.click();
			option.click();
		}
	}

	public void click_AllDirections() {
		generic.click(getDirections_Btn + "[1]");
		generic.goToSleep(4000);
		driver.navigate().back();
		generic.goToSleep(4000);
		if (driver.findElements(getDirections_Btn).size() > 0) {
			List<WebElement> errors = driver.findElements(getDirections_Btn);
			for (int i = 0; i < errors.size(); i++) {
				System.out.println("size : " + errors.size() + " , " + errors.get(i));

				String hotelName = generic.getText(getHotelName_Txt + "[" + (i + 1) + "]").toLowerCase().replaceAll(" ",
						"-");
				System.out.println(hotelName);
				generic.click(getDirections_Btn + "[" + (i + 1) + "]");

				String url = generic.getCurrentUrl();
				System.out.println("url : " + url);
				generic.goToSleep(2000);

				if (url.contains(hotelName)) {
					System.out.println((url.contains(hotelName)));
				} else {
					System.out.println("false url : " + url);
				}
				softAssert.assertTrue(url.contains(hotelName),
						"Case failed, url : " + url + " , hotelName : " + hotelName);
				driver.navigate().back();
				generic.goToSleep(4000);
			}
			softAssert.assertAll();
		}
	}

	public void click_AllBookings() {
		if (driver.findElements(booking_Btn).size() > 0) {
			List<WebElement> errors = driver.findElements(booking_Btn);
			for (int i = 0; i < errors.size(); i++) {
				// if(errors.get(i).isDisplayed()){
				generic.click(booking_Btn + "[" + (i + 1) + "]");
				generic.goToSleep(2000);
				System.out.println("Booking url : " + generic.getCurrentUrl());
				// }
				driver.navigate().back();
				generic.goToSleep(2000);
			}
		}
	}
}
