package com.fabhotels.desktopsite.pageobjects;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class Calendar {

	WebDriver driver;
	GenericFunctions generic;
	public static String date;

	public static final By checkIn_Date_WE = By.id("checkIn");
	public static final By checkOut_Date_WE = By.id("checkOut");
	public static final By month_WE = By.xpath("//th[@class='datepicker-switch'][1]");
	public static final By year_WE = By.xpath("(//th[@class='datepicker-switch'])[2]");
	public static final By nextYearClick_WE = By.xpath("(//th[@class='next'])[2]");
	public static final String Date_WE = "//table[@class='table-condensed']//td";
	public static final String selectMonth_Lnk = "//span[contains(@class,'month') and text()='";
	public static final String selectDate_Lnk = "//td[@class='day' and text()='";
	
	
	public Calendar(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}
	
	
	
	// Here the date format should be "dd MMMM uuuu"
	public void Select_CheckIn_CheckOut_Date_Calendar_WE(String checkindate, String checkoutdate) throws ParseException {
		if (checkindate.length() < 1)
			return;
		if (checkoutdate.length() < 1)
			return;
		String str[] = checkindate.split("\\s+");
		String inDate =str[0];
		inDate = inDate.charAt(0)=='0'?inDate.substring(1):inDate;
		String inMonth =str[1];
		String inMonthFormatted = inMonth.substring(0, 3);
		String inYear =str[2];
		String str1[] = checkoutdate.split("\\s+");
		String outDate =str1[0];
		outDate = outDate.charAt(0)=='0'?outDate.substring(1):outDate;
		String outMonth =str1[1];
		String outMonthFormatted = outMonth.substring(0, 3);
		String outYear =str1[2];
		generic.click(checkIn_Date_WE);
		generic.click(month_WE);
		while(!generic.getText(year_WE).equals(inYear)){
			generic.click(nextYearClick_WE);
		}
		generic.click(selectMonth_Lnk+inMonthFormatted+"']");
		generic.click(selectDate_Lnk+inDate+"']");
		
		generic.click(month_WE);
		while(!generic.getText(year_WE).equals(outYear)){
			generic.click(nextYearClick_WE);
		}
		generic.click(selectMonth_Lnk+outMonthFormatted+"']");
		generic.click(selectDate_Lnk+outDate+"']");
		
	}
	
	
	// for short month pass format as "dd-mm-yyyy" for full month pass "dd MMMM
	// uuuu"
	public String dateWithDifferentFormat(String format) {
		DateTimeFormatter dTF = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern(format)
				.toFormatter();
		LocalDate todayDate1 = LocalDate.now();
		date = todayDate1.plusDays(2).format(dTF);
		return date;
	}

	public String dateWithDifferentFormat(String format, int day) {
		DateTimeFormatter dTF = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern(format)
				.toFormatter();
		LocalDate todayDate1 = LocalDate.now();
		date = todayDate1.plusDays(day).format(dTF);
		return date;
	}

	// for short month pass format as "dd-mm-yyyy" for full month pass "dd MMMM
	// uuuu"
	public static String getTodaysDate(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String getDateAfterDays(String noofDays) {
		DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
		Date date = new Date();
		@SuppressWarnings("deprecation")
		Date newdate = new Date(date.getYear(), date.getMonth(), date.getDate() + Integer.parseInt(noofDays));
		return dateFormat.format(newdate);
	}

}
