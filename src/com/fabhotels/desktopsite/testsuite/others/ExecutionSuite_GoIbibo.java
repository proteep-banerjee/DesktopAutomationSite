package com.fabhotels.desktopsite.testsuite.others;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;

public class ExecutionSuite_GoIbibo {

	@Test
	public void test() {
		By AllLocations_Btn = By.xpath("(//button[contains(text(),'Show All') and contains(text(),'Locations')])[1]");
		String LocalitiesDiv_WE = "//div[@id='locations']/ul/li";
		
		WebDriver driver = null;
		//Xls_Reader datatable = new Xls_Reader("");
		GenericFunctions generic = new GenericFunctions(driver);
		driver = generic.startDriver("FF30");
		driver.get("https://www.goibibo.com/hotels/hotels-in-delhi");
		
		if (generic.isVisible(AllLocations_Btn))
			generic.click(AllLocations_Btn);
		
		List<WebElement> we = generic.findElements(By.xpath(LocalitiesDiv_WE));
		for (WebElement webElement : we) {
			System.out.println(webElement.findElement(By.xpath("./label/span")).getText() + "   " + webElement.findElement(By.xpath("./span")).getText());
		}

	}

}
