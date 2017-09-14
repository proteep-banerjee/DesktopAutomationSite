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
	public static final By month_WE = By.xpath("//th[@class='datepicker-switch']");
	public static final By nextMonthClick_WE = By.xpath("(//div[@class='datepicker-days']//th[@class='next'])[1]");

	public static final String Date_WE = "//table[@class='table-condensed']//td";

	public Calendar(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}

	// Here the date format should be "dd MMMM uuuu"
	public void Select_CheckIn_CheckOut_Date_WE(String checkindate, String checkoutdate) throws ParseException {
		if (checkindate.length() < 1)
			return;
		generic.click(checkIn_Date_WE);
		String str[] = checkindate.split("\\s+");
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM uuuu");
				
		Assert.assertTrue("check-in date cant be smaller than todays date.",
				sdf.parse(getTodaysDate("dd MMMM uuuu")).before(sdf.parse(checkindate)));
		
		Assert.assertFalse("check-in and check out date should be different.",
				sdf.parse(checkindate).equals(sdf.parse(checkoutdate)));
		
		Assert.assertTrue("check-in date should be smaller than check-out date ",
				sdf.parse(checkindate).before(sdf.parse(checkoutdate)));
		while (!generic.getText(month_WE).equalsIgnoreCase(str[1] + " " + str[2]))
			generic.click(nextMonthClick_WE);
		if (str[0].startsWith("0")) {
			str[0] = str[0].substring(1, str[0].length());
		}
		generic.click(Date_WE + "[text()='" + str[0] + "']");
		if (checkoutdate.length() < 1)
			return;
		String strr[] = checkoutdate.split("\\s+");
		while (!generic.getText(month_WE).equals(strr[1] + " " + strr[2]))
			generic.click(nextMonthClick_WE);
		if (strr[0].startsWith("0")) {
			strr[0] = strr[0].substring(1, strr[0].length());
		}
		generic.click(Date_WE + "[text()='" + str[0] + "']");
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
