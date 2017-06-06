package com.fabhotels.dashboard.testsuite.auditors;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.dashboard.pageobjects.Dashboard;
import com.fabhotels.dashboard.pageobjects.Login;
import com.fabhotels.dashboard.pageobjects.Auditors;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_Auditors extends Config {
	String Sheetname;
	Xls_Reader datatable;
	Login Login =new Login(driver,generic);
	Dashboard Dashboard=new Dashboard(driver,generic);
	Auditors Auditors=new Auditors(driver,generic);

	@BeforeMethod
	public void beforeMethod() {
		driver = generic.startDriver(Driver_Type);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	@Test
	public void TC_positiveAuditor_createAuditor(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Dashboard.click_Auditors();
		Auditors.createPositiveAuditors();
	}
	
	@Test
	public void TC_positiveAuditor_updateAuditor(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Dashboard.click_Auditors();
		Auditors.createPositiveAuditors();
		Auditors.clickUpdateAuditors_Btn();
		Auditors.modifyPositiveAuditors();
	}
	
	@Test
	public void TC_positiveAuditor_manageAuditor(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Dashboard.click_Auditors();
		Auditors.createPositiveAuditors();
		Auditors.clickUpdateAuditors_Btn();
		Auditors.clickManageAuditors_Btn();
		Auditors.searchAuditorByUsername();
		Auditors.modifyPositiveAuditors();
	}
	
	

	@AfterMethod
	public void afterTest() {
		System.out.println("Quit");
		generic.goToSleep(5000);
		driver.quit();
	}
}