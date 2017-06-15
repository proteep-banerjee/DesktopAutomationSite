package com.fabhotels.mobilesite.testsuites.headerfooter;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fabhotels.mobilesite.pageobjects.Header;
import com.fabhotels.mobilesite.utils.Config;
import com.fabhotels.mobilesite.utils.UrlProvider;

public class ExecutionSuite_Header extends Config{
	
	@BeforeTest
	public void beforeTest(){
		driver = generic.startDriver(Driver_Type);
		//generic = new GenericFunctions(driver);
		generic.maximize();
	}
	
	@Test
	public void TC_Validate_Clickablity_FabLogo(){
		driver.get(UrlProvider.getHomePageUrl());
		Header header = new Header(driver, generic);
		header.click_fabLogo_WE();
		Assert.assertTrue(true);
	}
	
	@Test
	public void TC_Validate_Clickablity_FabLogo2(){
		driver.get(UrlProvider.getHomePageUrl());
		Header header = new Header(driver, generic);
		header.click_fabLogo_WE();
		Assert.assertTrue(false);
	}
	
	@Test
	public void TC_Validate_Clickablity_FabLogo3(){
		driver.get("http://naukri.com");
		Header header = new Header(driver, generic);
		header.click_fabLogo_WE();
	}
	
	@Test
	public void TC_Validate_Clickablity_FabLogo4(){
		driver.get(UrlProvider.getHomePageUrl());
		Header header = new Header(driver, generic);
		header.click_fabLogo_WE();
		Assert.assertTrue(false);
	}
	
	@Test
	public void TC_Validate_Clickablity_FabLogo5(){
		driver.get(UrlProvider.getHomePageUrl());
		Header header = new Header(driver, generic);
		header.click_fabLogo_WE();
		Assert.assertTrue(true);
	}
	
	@Test
	public void TC_Validate_Clickablity_FabLogo6(){
		driver.get(UrlProvider.getHomePageUrl());
		Header header = new Header(driver, generic);
		header.click_fabLogo_WE();
		Assert.assertTrue(true);
	}
	
	@AfterTest
	public void afterTest(){
		driver.quit();
	}

}
