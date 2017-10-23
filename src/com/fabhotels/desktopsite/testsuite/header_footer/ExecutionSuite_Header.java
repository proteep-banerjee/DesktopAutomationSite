package com.fabhotels.desktopsite.testsuite.header_footer;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.desktopsite.pageobjects.Header;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.UrlProvider;


public class ExecutionSuite_Header extends Config {

	SoftAssert softAssert;
	Header header;
	
	@BeforeTest
	public void beforeTest() {
		generic = new GenericFunctions(driver);
		driver = generic.startDriver(Driver_Type);
		header = new Header(driver, generic);
		softAssert = new SoftAssert();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.manage().deleteAllCookies();
	}

	@Test
	public void TC_ExecutionSuite_Header_001_verifyHeaderPresenceAndFunctionality(){
		driver.get(UrlProvider.getHomePageUrl());
		softAssert.assertEquals("+91 70 4242 4242", header.getText_callUs_Lbl());
		header.click_beOurFranchisee_Lnk();
		generic.switchtoNewWindow();
		softAssert.assertEquals(driver.getCurrentUrl(), UrlProvider.getHomePageUrl()+"franchise-enquiry");
		driver.close();
		generic.SwitchtoOriginalWindow();
		header.click_fabLogo_Lnk();
		generic.switchtoNewWindow();
		softAssert.assertEquals(driver.getCurrentUrl(), UrlProvider.getHomePageUrl());
		driver.close();
		softAssert.assertAll();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
