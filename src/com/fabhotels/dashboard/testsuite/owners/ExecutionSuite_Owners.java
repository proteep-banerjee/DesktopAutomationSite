package com.fabhotels.dashboard.testsuite.owners;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.dashboard.pageobjects.Login;
import com.fabhotels.dashboard.pageobjects.Dashboard;
import com.fabhotels.dashboard.pageobjects.Owners;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.Constants;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_Owners extends Config {
	String Sheetname;
	Xls_Reader datatable;
	Login Login =new Login(driver,generic);
	Dashboard Dashboard=new Dashboard(driver,generic);
	Owners Owners=new Owners(driver,generic);

	@BeforeMethod
	public void beforeMethod() {
		driver = generic.startDriver(Driver_Type);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@Test
	public void TC_positiveSalesUser_createOwnerRolePropertyManager(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Dashboard.click_Owners();
		Owners.clickCreateOwners_Btn();
		Owners.createOwnerRolePropertyManager();
	}

	@Test
	public void TC_positiveSalesUser_createOwnerRolePropertyAdmin(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Dashboard.click_Owners();
		Owners.clickCreateOwners_Btn();
		Owners.createOwnerRolePropertyAdmin();
	}

	@Test
	public void TC_positiveSalesUser_modifyOwnerRolePropertyAdminToPropertyManager(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Dashboard.click_Owners();
		Owners.clickCreateOwners_Btn();
		Owners.createOwnerRolePropertyAdmin();
		Owners.clickManageOwners_Btn();
		Owners.searchOwnerbyUsername();
		Owners.modifyOwnerRolePropertyAdminToPropertyManager();
	}

	@DataProvider(name = "DataProvider_CreateOwnersPage")
	public Object[][] DataProvider_AdminUserPage() {
		Sheetname = "CreateOwners";
		datatable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_CREATEOWNER);
		int rowcount = datatable.getRowCount(Sheetname);
		Object result[][] = new Object[rowcount - 1][2];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = i;
			result[i - 2][1] = datatable.getCellData(Sheetname, "Case_Type", i);
		}	
		return result;
	}
	//@Test(dataProvider="DataProvider_CreateOwnersPage")
	public void TC_positiveCase_User_CreateOwner(int rowNo, String Case_Type) {
		System.out.println("Case_Type :"+Case_Type);
		Sheetname = "CreateOwners";
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Dashboard.click_Owners();
		Owners.clickCreateOwners_Btn();
		Owners.createOwner(datatable,Sheetname,rowNo);
		//String currentError=Owners.captureError();
		//datatable.setCellData(Sheetname, "ExpectedErrors", rowNo, currentError);
		String ExpectedErrors=datatable.getCellData(Sheetname, "ExpectedErrors", rowNo);

		String Expected=datatable.getCellData(Sheetname, "Expected", rowNo);

		if(Expected.equalsIgnoreCase("NotSubmitted")){
			//Assert.assertTrue((currentError.equals(ExpectedErrors)),"Errors does not matches. ");

		}else{
		}
	}


	@AfterMethod
	public void afterTest() {
		System.out.println("Quit");
		generic.goToSleep(5000);
		//driver.quit();
	}
}
