package com.fabhotels.desktopsite.CompareUrlRedirection;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.Constants;

public class ExecutionSuite_CompareRedirectedUrls extends Config {
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
	
	

	@DataProvider(name = "Validate_URLs")
	public Object[][] DataProvider_Footer() {
		Sheetname = "CompareRedirections";
		datatable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_URL);
		int rowcount = datatable.getRowCount(Sheetname);
		System.out.println(rowcount+" , "+Constants.FILEPATH_TESTDATASHEET_URL);
		Object result[][] = new Object[rowcount - 1][3];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = i;
			result[i - 2][1] = datatable.getCellData(Sheetname, "Old_URL", i);
			result[i - 2][2] = datatable.getCellData(Sheetname, "New_URL", i);
		}
		return result;
	}

	@Test(dataProvider = "Validate_URLs")
	public void TC_Validate_FooterLinks_Landings(int row, String Old_URL, String New_URL) {
		System.out.println("Old_URL:"+Old_URL);
		Sheetname = "CompareRedirections";
		String Old="https://www.fabhotels.com"+Old_URL;
		driver.get(Old);
		
		generic.goToSleep(100);
		String redirectedURL=driver.getCurrentUrl();
		System.out.println(Old+" , "+"\n"+New_URL+" = "+"\n"+redirectedURL);
		System.out.println();
		
		String New="https://www.fabhotels.com"+New_URL;
		if(redirectedURL.equalsIgnoreCase(New)){
			datatable.setCellData(Sheetname, "Result", row, "PASS");
		}else{
			datatable.setCellData(Sheetname, "Result", row, "Fail");
		}
		Assert.assertEquals(redirectedURL, New,"redirected URL and New_URL does not matches.");
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
