package com.fabhotels.dekstopsite.others;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fabhotels.desktopsite.pageobjects.Header;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_CompareDescription_Localities extends Config {
	
	@BeforeTest
	public void beforeTest() {
		driver = generic.startDriver(Driver_Type);
		generic.maximize();
	}
	
	 @DataProvider(name = "TC_Compare_Localities")
		public Object[][] DataProvider_Footer() {
			Object result[][] = new Object[19][1];
			result[0][0] = "New Delhi";
			result[1][0] = "Bangalore";
			result[2][0] = "Mumbai";
			result[3][0] = "Amritsar";
			result[4][0] = "Chennai";
			result[5][0] = "Goa";
			result[6][0] = "Gurgaon";
			result[7][0] = "Hyderabad";
			result[8][0] = "Ooty";
			result[9][0] = "Jaipur";
			result[10][0] = "Noida";
			result[11][0] = "Kolkata";
			result[12][0] = "Pondicherry";
			result[13][0] = "Pune";
			result[14][0] = "Udaipur";
			result[15][0] = "Mysore";
			result[16][0] = "Ahmedabad";
			result[17][0] = "Indore";
			result[18][0] = "Coimbatore";

			return result;
		}
	
	@Test (dataProvider = "TC_Compare_Localities")
	public void TC_Compare_Localities(String linkName){
		UrlProvider.getHomePageUrl();
		driver.get("http://fabhotels.com");
		generic.performMouseHover(Header.allCities_DD);
		generic.click(Header.allCities_Links_WE + "[text()='" + linkName + "']");
		List<WebElement> we = driver.findElements(By.xpath("//ul[@class='filterList']/li/label"));
		String livedata = "";
		for (WebElement webElement : we) {
			livedata += webElement.getText().split("\\(")[0];
		} 
		
		driver.get("http://preprod.fabhotels.com");
		generic.performMouseHover(Header.allCities_DD);
		generic.click(Header.allCities_Links_WE + "[text()='" + linkName + "']");
		we = driver.findElements(By.xpath("//ul[@class='filterList']/li/label"));
		String devdata = "";
		for (WebElement webElement : we) {
			devdata += webElement.getText().split("\\(")[0];
		} 
		
		Assert.assertEquals(devdata, livedata);
	}
	
	@Test (dataProvider = "TC_Compare_Localities")
	public void TC_Compare_Text(String linkName){
		UrlProvider.getHomePageUrl();
		driver.get("http://fabhotels.com");
		generic.performMouseHover(Header.allCities_DD);
		generic.click(Header.allCities_Links_WE + "[text()='" + linkName + "']");
		String livedata = driver.findElement(By.xpath("//p[@class='property-description']")).getText();
		driver.get("http://preprod.fabhotels.com");
		generic.performMouseHover(Header.allCities_DD);
		generic.click(Header.allCities_Links_WE + "[text()='" + linkName + "']");
		String devdata  = driver.findElement(By.xpath("//p[@class='property-description']")).getText();
		
		Assert.assertEquals(devdata, livedata);
	}

}
