package com.fabhotels.desktopsite.testsuite.header_footer;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.pageobjects.Header;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.Constants;
import com.fabhotels.desktopsite.utils.UrlProvider;


public class ExecutionSuite_Header extends Config {

	SoftAssert softAssert;
	Header header;
	Xls_Reader xls= new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_HEADER);

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

	@DataProvider(name = "headerPages")
	public Object[][] bookingTest() {
		int rowcount = xls.getRowCount("Email");
		Object result[][] = new Object[rowcount - 1][3];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = xls.getCellData("Email", "Page Name", i);
			result[i-2][1]= xls.getCellData("Email", "Page URL", i);
			result[i-2][2]= xls.getCellData("Email", "Count", i);
		}
		return result;
	}

	@Test(dataProvider = "headerPages")
	public void TC_ExecutionSuite_Header_001_verifyHeaderPresenceAndFunctionality(String pageName, String url, String count){
		driver.get(UrlProvider.getHomePageUrl()+url);
		if(count.equals("4")){
			softAssert.assertEquals("All Cities", header.getText_allCities_WE());
		}
		softAssert.assertEquals("+91 70 4242 4242", header.getText_callUs_Lbl());
		header.click_beOurFranchisee_Lnk();
		generic.switchtoNewWindow();
		softAssert.assertEquals(driver.getCurrentUrl(), UrlProvider.getHomePageUrl()+"franchise-enquiry");
		driver.close();
		generic.SwitchtoOriginalWindow();
		header.click_fabLogo_Lnk();
		generic.switchtoNewWindow();
		softAssert.assertEquals(driver.getCurrentUrl(), UrlProvider.getHomePageUrl());
		softAssert.assertAll();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
