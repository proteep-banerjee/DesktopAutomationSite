package com.fabhotels.mobilesite.testsuite.login;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.mobilesite.pageobjects.BookingPage;
import com.fabhotels.mobilesite.pageobjects.EditProfilePage;
import com.fabhotels.mobilesite.pageobjects.Header;
import com.fabhotels.mobilesite.pageobjects.LoginPage;
import com.fabhotels.mobilesite.pageobjects.LoginorRegisterPage;
import com.fabhotels.mobilesite.utils.Config;
import com.fabhotels.mobilesite.utils.UrlProvider;

public class ExecutionSuite_Login extends Config {
	String Sheetname;
	Xls_Reader datatable;
	LoginorRegisterPage loginorRegisterPage;
	LoginPage loginPage;
	BookingPage bookingPage;
	Header header;
	EditProfilePage editProfilePage;

	
	@BeforeMethod
	public void beforeMethod() {
		driver = generic.startDriver(Driver_Type, Device_Type);
		generic.maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginorRegisterPage = new LoginorRegisterPage(driver,generic);
		loginPage = new LoginPage(driver,generic);
		bookingPage = new BookingPage(driver,generic);
		header = new Header(driver,generic);
		editProfilePage = new EditProfilePage(driver,generic);
	}

	@Test
	public void TC_positiveCase_LoginWithInternationalNumber() {
		generic.loadURL(UrlProvider.getBaseUrl());
		header.click_ProfileLoginSilhouette();
		loginorRegisterPage.Positive_Login();
		generic.goToSleep(1000);
		loginPage.Positive_LoginWithInternationalNumber();
		generic.goToSleep(1000);
		loginPage.Positive_OTP();
		generic.goToSleep(1000);
		bookingPage.positive_Bookings();
		
	}

	@Test
	public void TC_positiveCase_LoginWithNationalNumber() {
		generic.loadURL(UrlProvider.getBaseUrl());
		header.click_ProfileLoginSilhouette();
		loginorRegisterPage.Positive_Login();
		generic.goToSleep(1000);
		loginPage.Positive_LoginWithNationalNumber();
		generic.goToSleep(1000);
		loginPage.Positive_OTP();
		generic.goToSleep(1000);
		bookingPage.positive_Bookings();
		
	}
	
	@Test
	public void TC_positiveCase_EditUserProfile() {
		generic.loadURL(UrlProvider.getBaseUrl());
		header.click_ProfileLoginSilhouette();
		loginorRegisterPage.Positive_Login();
		generic.goToSleep(1000);
		loginPage.Positive_LoginWithNationalNumber();
		generic.goToSleep(1000);
		loginPage.Positive_OTP();
		generic.goToSleep(1000);
		bookingPage.click_editProfile_Btn();
		generic.goToSleep(1000);
		editProfilePage.positive_saveProfileOneDetails();
		generic.goToSleep(1000);
		bookingPage.click_editProfile_Btn();
		generic.goToSleep(1000);
		editProfilePage.positive_saveProfileTwoDetails();
	}
	
	@AfterMethod
	public void afterMethod(){
		//driver.quit();
	}


}
