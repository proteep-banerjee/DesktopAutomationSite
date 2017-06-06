package com.fabhotels.desktopsite.testsuite.header_footer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.pageobjects.Footer;
import com.fabhotels.desktopsite.pageobjects.HomePage;
import com.fabhotels.desktopsite.utils.Constants;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_Footer extends UrlProvider {

	Xls_Reader datatable;
	String Sheetname;


	@BeforeMethod(firstTimeOnly = true)
	public void Before() {
		driver = generic.startDriver(Driver_Type);
		generic.maximize();
		generic.loadURL(getHomePageUrl());
	}
	
	@BeforeMethod
	public void BeforeMethod(){
		
	}

	@DataProvider(name = "Validate_Links_Landings_Footer")
	public Object[][] DataProvider_Footer() {
		Sheetname = "Footer";
		datatable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_FOOTER);
		int rowcount = datatable.getRowCount(Sheetname);
		Object result[][] = new Object[rowcount - 1][3];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = i;
			result[i - 2][1] = datatable.getCellData(Sheetname, "Links", i);
			result[i - 2][2] = datatable.getCellData(Sheetname, "Link_Type", i);
		}
		return result;
	}

	@Test(dataProvider = "Validate_Links_Landings_Footer")
	public void TC_Validate_FooterLinks_Landings(int row, String LinkName, String Link_Type) {
		System.out.println("Row >> "+row+", Linkname >> "+LinkName+", link type >> "+Link_Type);
		if (!generic.isVisible(HomePage.lowest_Online_Prices_WE))
			generic.loadURL(getHomePageUrl());

		if (Link_Type.equalsIgnoreCase("Static")) {
			String Xpath = Footer.footerDiv_WE + "//li[text()='" + LinkName + "']";
			Assert.assertTrue(generic.isVisible(Xpath), "Fail Static Text " + LinkName + " Not Visible!!");
		} else {

			boolean check = true;
			String Xpath = Footer.footerDiv_WE + "//a[text()='" + LinkName + "']";
			generic.click(Xpath);
			check = generic.isVisible(datatable.getCellData(Sheetname, "LandingXpath", row));
			Assert.assertTrue(check, "Fail Link " + LinkName + "Improper Landing!!");
	}}
	
	@DataProvider(name = "Validate_Links_Number")
	public Object[][] DataProvider_FooterLink_Number() {
		Sheetname = "Footer";
		datatable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_FOOTER);
		int rowcount = datatable.getRowCount(Sheetname);
		Object result[][] = new Object[rowcount - 1][3];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = i;
			result[i - 2][1] = datatable.getCellData(Sheetname, "Link_Type", i);
			result[i - 2][2] = datatable.getCellData(Sheetname, "Count", i);
		}
		return result;
	}
	
	@Test (dataProvider = "Validate_Links_Number")
	public void TC_Validate_FooterLinks_Number (int row, String Link_Type, String Count){

	  if (Link_Type.equalsIgnoreCase("Static") && row == 2){
			  Assert.assertEquals(Count, String.valueOf(driver.findElements(Footer.fabhotels_AllElements_WE)), "Count of the 'fabhotels' in footer is not matched !");
		   }
	  else if (Link_Type.equalsIgnoreCase("static") && row == 9){
              Assert.assertEquals(Count, String.valueOf(driver.findElements(Footer.policies_AllElements_WE).size()), "Count of the 'policies' in footer is not matched !");
	  }
	  else if (Link_Type.equalsIgnoreCase("static") && row == 13){
		  Assert.assertEquals(Count, String.valueOf(driver.findElements(Footer.book_AllElements_WE).size()), "Count of the 'Policies' in the footer is not matched !");	  
	  }
	  
	   
	}
	
	@AfterMethod(lastTimeOnly = true)
	public void After() {
		driver.quit();
	}

}
