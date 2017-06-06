package com.fabhotels.dashboard.testsuite.auditors;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.dashboard.pageobjects.Auditors;
import com.fabhotels.dashboard.pageobjects.Dashboard;
import com.fabhotels.dashboard.pageobjects.Login;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.UrlProvider;
import com.fabhotels.dashboard.pageobjects.AuditorPropertyMapping;

public class ExecutionSuite_AuditorPropertyMapping extends Config {
	String Sheetname;
	Xls_Reader datatable;
	Login Login =new Login(driver,generic);
	Dashboard Dashboard=new Dashboard(driver,generic);
	Auditors Auditors=new Auditors(driver,generic);
	AuditorPropertyMapping AuditorPropertyMapping=new AuditorPropertyMapping(driver,generic);
	SoftAssert SoftAssert=new SoftAssert();

	@BeforeMethod
	public void beforeMethod() {
		driver = generic.startDriver(Driver_Type);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void TC_positiveAuditor_completeAuditorPropertyMappingFlow(){
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Login.positiveLoginFlow();
		Dashboard.click_Auditors();
		Auditors.createPositiveAuditors();
		generic.loadURL(UrlProvider.getAdminPageUrl());
		Dashboard.click_auditorPropertyMapping_Btn();
		AuditorPropertyMapping.click_createAuditorPropertyMapping_Btn();
		SoftAssert.assertEquals(driver.getCurrentUrl(),UrlProvider.get_createAuditorPropertyMapping(),
				"get_createAuditorPropertyMapping does not matches.");
		AuditorPropertyMapping.click_manageAuditorPropertyMapping_Btn();
		SoftAssert.assertEquals(driver.getCurrentUrl(),UrlProvider.get_manageAuditorPropertyMapping(),
				"get_manageAuditorPropertyMapping does not matches.");
		AuditorPropertyMapping.positive_SearchNewAuditorMapping();
		AuditorPropertyMapping.manageAuditorPropertyMappingDeleteAll_Btn();
		AuditorPropertyMapping.click_createAuditorPropertyMapping_Btn();
		SoftAssert.assertEquals(driver.getCurrentUrl(),UrlProvider.get_createAuditorPropertyMapping(),
				"get_createAuditorPropertyMapping does not matches.");
		AuditorPropertyMapping.positive_CreateNewAuditorMapping();
		AuditorPropertyMapping.click_manageAuditorPropertyMapping_Btn();
		SoftAssert.assertEquals(driver.getCurrentUrl(),UrlProvider.get_manageAuditorPropertyMapping(),
				"get_manageAuditorPropertyMapping does not matches.");
		AuditorPropertyMapping.positive_SearchNewAuditorMapping();
		AuditorPropertyMapping.manageAuditorPropertyMappingDeleteAll_Btn();
	}

	@AfterMethod
	public void afterTest() {
		System.out.println("Quit");
		//generic.goToSleep(5000);
		driver.quit();
	}
}
