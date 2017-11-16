package com.fabhotels.desktopsite.testsuite.header_footer;

import java.util.List;

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
import com.fabhotels.desktopsite.pageobjects.Header;
import com.fabhotels.desktopsite.pageobjects.ListingPage;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.Constants;
import com.fabhotels.desktopsite.utils.UrlProvider;


public class ExecutionSuite_Header extends Config {

	Header header;
	SoftAssert softAssert;
	Xls_Reader xls= new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_HEADER);
	ListingPage lp;

	@BeforeTest
	public void beforeTest() {
		generic = new GenericFunctions(driver);
		driver = generic.startDriver(Driver_Type);
		header = new Header(driver, generic);
		lp = new ListingPage(driver, generic);
	}

	@BeforeMethod
	public void beforeMethod() {
		softAssert = new SoftAssert();
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
		generic.loadURL_HandlePopup(UrlProvider.getHomePageUrl()+url);
		if(count.equals("4")){
			softAssert.assertEquals("All Cities", header.getText_allCities_WE());
		}
		softAssert.assertEquals("+91 70 4242 4242", header.getText_callUs_Lbl());
		header.click_beOurFranchisee_Lnk();
		generic.switchtoNewWindow();
		softAssert.assertEquals(driver.getCurrentUrl(), UrlProvider.getHomePageUrl()+"franchise-enquiry");
		driver.close();
		generic.switchtoOriginalWindow();
		header.click_fabLogo_Lnk();
		softAssert.assertEquals(driver.getCurrentUrl(), UrlProvider.getHomePageUrl());
		softAssert.assertAll();
	}

	@DataProvider(name = "DataProvider_Cities")
	public Object[][] DataProvider_Cities() {
		generic.loadURL_HandlePopup(UrlProvider.getDetailsPageUrl());
		List<WebElement> we = header.getWebElements_AllCities_DD();
		Object result[][] = new Object[we.size()][1];
		for (int i = 0; i < we.size(); i++) {
			result[i][0] = we.get(i).getText();
		}
		return result;
	}

	@Test(dataProvider="DataProvider_Cities")
	public void TC_ExecutionSuite_Header_002_verifyAllCities(String cityName){
		header.click_CityNameByHref_Header_WE(cityName);
		String modCity = cityName.toLowerCase();
		if(modCity.contains(" ")){
			modCity = modCity.replace(" ", "-");
		}
		Assert.assertTrue(lp.getText_resultsCountText_Lbl().contains(cityName), "Not Redirecting to the correct URL");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
