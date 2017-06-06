package com.fabhotels.dashboard.testsuite.users;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.dashboard.pageobjects.Login;
import com.fabhotels.dashboard.pageobjects.Users;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.Constants;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_CreateUsers extends Config {
	String Sheetname;
	Xls_Reader datatable;
	Login Login =new Login(driver,generic);
	Users Users =new Users(driver,generic);


	@BeforeMethod
	public void beforeMethod() {
		driver = generic.startDriver(Driver_Type);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
	}

	@DataProvider(name = "DataProvider_CreateUserPage")
	public Object[][] DataProvider_AdminUserPage() {
		Sheetname = "CreateUsers";
		datatable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_CREATEUSER);
		int rowcount = datatable.getRowCount(Sheetname);
		Object result[][] = new Object[rowcount - 1][2];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = i;
			result[i - 2][1] = datatable.getCellData(Sheetname, "Case_Type", i);
		}	
		return result;
	}
	@Test(dataProvider="DataProvider_CreateUserPage")
	public void TC_positiveCase_User_CreateUser(int rowNo, String Case_Type) {
		//rowNo=4;
		System.out.println("Case_Type :"+Case_Type);
		Sheetname = "CreateUsers";
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login = new Login(driver,generic);
		Users = new Users(driver,generic);
		Login.positiveLoginFlow();
		Users.TestCase_CreateUser(datatable,Sheetname,rowNo);
		//String currentError=Users.captureError();
		//datatable.setCellData(Sheetname, "ExpectedErrors", rowNo, currentError);
		String ExpectedErrors=datatable.getCellData(Sheetname, "ExpectedErrors", rowNo);

		String Expected=datatable.getCellData(Sheetname, "Expected", rowNo);

		if(Expected.equalsIgnoreCase("NotSubmitted")){
			//Assert.assertTrue((currentError.equals(ExpectedErrors)),"Errors does not matches. ");

		}else{
		}
	}

	@Test
	public void TC_positiveCreateUser_EXECUTIVE(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Users.positiveCreateUser_EXECUTIVE();
	}

	@Test
	public void TC_positiveCreateUser_AUDITOR(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Users.positiveCreateUser_AUDITOR();
	}

	@Test
	public void TC_positiveCreateUser_ONLINE(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Users.positiveCreateUser_ONLINE();
	}

	@Test
	public void TC_positiveCreateUser_SALES(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Users.positiveCreateUser_SALES();
	}

	@Test
	public void TC_negativeCreateUser_SALES(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Users.negativeCreateUser_SALES();
	}

	@Test
	public void TC_positiveCreateUser_TABLET(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Users.positiveCreateUser_TABLET();
	}

	@Test
	public void TC_positiveModifyUser_EXECUTIVEtoAUDITOR(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Users.positiveCreateUser_EXECUTIVE();
		generic.loadURL(UrlProvider.getAdminPageUrl());
	//	Login.positiveLoginFlow();
		Users.positiveModifyUserTo_AUDITOR();
		}
	
	@Test
	public void TC_positiveModifyUser_AUDITORtoEXECUTIVE(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Users.positiveCreateUser_AUDITOR();
		generic.loadURL(UrlProvider.getAdminPageUrl());
	//	Login.positiveLoginFlow();
		Users.positiveModifyUserTo_EXECUTIVE();;
	}

	@Test
	public void TC_positiveModifyUser_ONLINEtoSALES(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Users.positiveCreateUser_ONLINE();
		generic.loadURL(UrlProvider.getAdminPageUrl());
	//	Login.positiveLoginFlow();
		Users.positiveModifyUserTo_SALES();
	}

	@Test
	public void TC_positiveModifyUser_SALEStoTABLET(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Users.positiveCreateUser_SALES();
		generic.loadURL(UrlProvider.getAdminPageUrl());
		//Login.positiveLoginFlow();
		Users.positiveModifyUserTo_TABLET();
	}

	@Test
	public void TC_positiveModifyUser_TABLETtoONLINE(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Users.positiveCreateUser_TABLET();
		generic.loadURL(UrlProvider.getAdminPageUrl());
	//	Login.positiveLoginFlow();
		Users.positiveModifyUserTo_ONLINE();
	}


	@AfterMethod
	public void afterTest() {
		System.out.println("Quit");
		driver.quit();
	}
}
