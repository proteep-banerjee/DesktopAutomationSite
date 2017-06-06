package com.fabhotels.dashboard.pageobjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class TestingExample {
	public static void main(String args[]){
		TestingExample TestingExample=new TestingExample();
		System.out.println(TestingExample.dateWithDifferentFormat("dd-MMM-yyyy",0));
		System.out.println(TestingExample.dateWithDifferentFormat("dd-MM-yyyy",2));
		
	}
	
	
	public String dateWithDifferentFormat(String format,int day){
		DateTimeFormatter dTF = 
			    new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern(format).toFormatter();
		//dd-mmm-yyyy , dd-mm-yyyy
		LocalDate todayDate1 = LocalDate.now();
		String date=todayDate1.plusDays(day).format(dTF);
		return date;
	}

}
