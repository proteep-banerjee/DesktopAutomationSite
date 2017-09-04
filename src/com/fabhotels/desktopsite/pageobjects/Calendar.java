package com.fabhotels.desktopsite.pageobjects;

import java.text.SimpleDateFormat;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class Calendar {
	
	WebDriver driver;
	GenericFunctions generic;

	public static final By prevMonth_Btn = By.xpath("(//th[contains(@class,'prev')])[1]");
	public static final By nextMonth_Btn = By.xpath("(//th[contains(@class,'next')])[1]");
	public static final By currentMonth_Lbl = By.xpath("//th[@class='datepicker-switch']");
	public static final By date_WE = By.xpath("//td[contains(@class,'day')]");
	
	public Calendar(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}
	
	public void selectDate(DateTime date){
		String actualMonthShown = generic.findElement(currentMonth_Lbl).getText();
		DateTime currentDate = new DateTime(new SimpleDateFormat("dd MMMM yyyy").format("01" + actualMonthShown));
		int monthDisplayed = currentDate.getMonthOfYear();
		int monthToBeSelected = date.getMonthOfYear();
		
	}

}
