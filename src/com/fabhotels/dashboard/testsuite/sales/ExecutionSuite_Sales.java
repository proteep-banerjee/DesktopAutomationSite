package com.fabhotels.dashboard.testsuite.sales;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.dashboard.pageobjects.Login;
import com.fabhotels.dashboard.pageobjects.Users;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.UrlProvider;
import com.fabhotels.dashboard.pageobjects.SalesLogin;
import com.fabhotels.dashboard.pageobjects.Sales;
import com.fabhotels.dashboard.pageobjects.CorporateCompany;
import com.fabhotels.dashboard.pageobjects.Dashboard;

public class ExecutionSuite_Sales extends Config {
	String Sheetname;
	Xls_Reader datatable;
	Login Login =new Login(driver,generic);
	Users Users =new Users(driver,generic);
	SalesLogin SalesLogin=new SalesLogin(driver,generic);
	Sales Sales=new Sales(driver,generic);
	CorporateCompany CorporateCompany=new CorporateCompany(driver,generic);
	Dashboard Dashboard=new Dashboard(driver,generic);

	@BeforeMethod
	public void beforeMethod() {
		driver = generic.startDriver(Driver_Type);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	@Test
	public void TC_positiveSalesUser_CreateNewSalesUserThenCreateBookingWithMinimumFields(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Users.positiveCreateUser_SALES();
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Dashboard.click_corporateCompany();
		CorporateCompany.createCorporate_Btn();
		CorporateCompany.positiveCreateNewCorporate();
		CorporateCompany.positiveViewNewCorporateCreated();
		CorporateCompany.updateCorporate_Btn();
		CorporateCompany.positiveUpdateNewCorporate();
		CorporateCompany.manageCorporate_Btn();
		CorporateCompany.assignCorporate_Btn();
		CorporateCompany.positiveAssignNewCorporate();
		//Create corporate and assign corporate
		generic.loadURL(UrlProvider.getSalesPageUrl());
		SalesLogin.positiveNewCorporateSalesLogin();
		SalesLogin.positiveSalesOTP();
		Sales.CreateBookingWithMinimumFields();
	//	Sales.positiveViewSalesBooking();
	}
	
	@Test
	public void TC_positiveSalesUser_CreateNewSalesUserThenCreateBookingWithChangesInAllFields(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Users.positiveCreateUser_SALES();
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Dashboard.click_corporateCompany();
		CorporateCompany.createCorporate_Btn();
		CorporateCompany.positiveCreateNewCorporate();
		CorporateCompany.positiveViewNewCorporateCreated();
		CorporateCompany.updateCorporate_Btn();
		CorporateCompany.positiveUpdateNewCorporate();
		CorporateCompany.manageCorporate_Btn();
		CorporateCompany.assignCorporate_Btn();
		CorporateCompany.positiveAssignNewCorporate();
		//Create corporate and assign corporate
		generic.loadURL(UrlProvider.getSalesPageUrl());
		SalesLogin.positiveNewCorporateSalesLogin();
		SalesLogin.positiveSalesOTP();
		Sales.CreateBookingWithChangesInAllFields();
		Sales.positiveViewSalesBooking();
	}
	
	@Test
	public void TC_positiveSalesUser_CreateNewSalesUserThenCreateBookingThenEditBooking(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Users.positiveCreateUser_SALES();
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Dashboard.click_corporateCompany();
		CorporateCompany.createCorporate_Btn();
		CorporateCompany.positiveCreateNewCorporate();
		CorporateCompany.positiveViewNewCorporateCreated();
		CorporateCompany.updateCorporate_Btn();
		CorporateCompany.positiveUpdateNewCorporate();
		CorporateCompany.manageCorporate_Btn();
		CorporateCompany.assignCorporate_Btn();
		CorporateCompany.positiveAssignNewCorporate();
		//Create corporate and assign corporate
		generic.loadURL(UrlProvider.getSalesPageUrl());
		SalesLogin.positiveNewCorporateSalesLogin();
		SalesLogin.positiveSalesOTP();
		Sales.CreateBookingWithMinimumFields();
		Sales.EditBookingWithChangesInAllFields();
		Sales.positiveViewSalesBooking();
	}
	
	@Test
	public void TC_positiveSalesUser_CreateBookingThenEditBookingThenCancelBooking(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Users.positiveCreateUser_SALES();
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Dashboard.click_corporateCompany();
		CorporateCompany.createCorporate_Btn();
		CorporateCompany.positiveCreateNewCorporate();
		CorporateCompany.positiveViewNewCorporateCreated();
		CorporateCompany.updateCorporate_Btn();
		CorporateCompany.positiveUpdateNewCorporate();
		CorporateCompany.manageCorporate_Btn();
		CorporateCompany.assignCorporate_Btn();
		CorporateCompany.positiveAssignNewCorporate();
		//Create corporate and assign corporate
		generic.loadURL(UrlProvider.getSalesPageUrl());
		SalesLogin.positiveNewCorporateSalesLogin();
		SalesLogin.positiveSalesOTP();
		Sales.CreateBookingWithMinimumFields();
		Sales.EditBookingWithChangesInAllFields();
		Sales.positiveViewSalesBooking();
		Sales.clickOnCancelSaleBooking_Btn();
		generic.AlertBox_promptMessage();
		Sales.positiveViewSalesCancelledBooking();
		
		Sales.home_Btn();
		Sales.viewBooking_btn();
		Sales.viewDetailsSaleBooking_Btn();
		Sales.positiveViewSalesCancelledBooking();
	}
	
	@Test
	public void TC_positiveSalesUser_CreateBookingWithMinimumFields(){
		generic.loadURL(UrlProvider.getSalesPageUrl());
		SalesLogin.positiveSalesLogin();
		SalesLogin.positiveSalesOTP();
		Sales.CreateBookingWithMinimumFields();
		}
	
	@Test
	public void TC_positiveSalesUser_CreateBookingWithChangesInAllFields(){
		generic.loadURL(UrlProvider.getSalesPageUrl());
		SalesLogin.positiveSalesLogin();
		SalesLogin.positiveSalesOTP();
		generic.getDatesInMMDDYYYY();
		Sales.CreateBookingWithChangesInAllFields();
		}
	
	@AfterMethod
	public void afterTest() {
		System.out.println("Quit");
		generic.goToSleep(50000);
		driver.quit();
	}
}
