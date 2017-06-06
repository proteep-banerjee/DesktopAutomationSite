package com.fabhotels.desktopsite.pageobjects;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;


public class DetailPage {
	WebDriver driver;
	GenericFunctions generic;


	public DetailPage (WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;		
	}


	public static final By checkIn_Date_WE = By.id("checkIn");
	public static final By checkOut_Date_WE = By.id("checkOut");
	public static final By currentMonth_WE = By.xpath("(//div[@class='datepicker-days']//th[@class='switch'])[1]");
	public static final By nextMonth_WE = By.xpath("(//div[@class='datepicker-days']//th[@class='switch'])[2]");
	public static final By nextMonthClick_WE = By.xpath("(//div[@class='datepicker-days']//th[@class='next'])[1]");
	public static final String checkInCalenderDates_WE = "//div[contains(@class, 'datepicker-checkin')]//td";
	public static final String checkOutCalenderDates_WE = "//div[contains(@class, 'datepicker-checkout')]//td";
	public static final String calender_dates_String_WE = "//div[@class='datepicker-days']//td";
	public static final By singlePropertyRoomCount_WE = By.xpath("(//input[contains(@class, 'property_counter_input')])[1]");
	public static final By availability_error_msg_Lbl = By.xpath("//p[contains(@class,'availability_error_msg')]");
	public static final By propertyName_Lbl = By.xpath("//div[@class='property_name']/h1");
	public static final By propertyReview_Lbl = By.xpath("//a[contains(text(), 'Rated Very Good across')]");
	public static final By SingleRoom_getRoomCountAndGuestCount_Lbl = By.xpath("//div[contains(text(),'Room /')]");
	public static final By multipleRoomPropertyRoomType_WE = By.xpath("//div[contains(@class, 'property_room_type_single')]");
	public static final By multipleRoom_SoldOutMssgForIndividualRoomType_Lbl = By.xpath("//div[@class='property_room_type_desc']/p");
	public static final By addRoomForIndividualRoomType_Lbl = By.xpath("(//div[contains(@class, 'property_button_plus')])[1]");
	public static final String singleRoom_addRoomForIndividualRoomType_Lbl = "(//div[contains(@class, 'property_button_plus')])";
	public static final String dropDown_Btn = "(//div[contains(text(),'Room /')]/..//span)[1]";
	public static final By availabilityErrMsg_Lbl = By.xpath("//p[contains(text(),'rooms left')]");
	public static final By bookNow_Btn = By.id("propertyReviewBooking");
//	public static final String bookNow_Btn = "//button[@id='propertyReviewBooking']";
	public static final By totalAmounnt_Lbl = By.id("total_amount");
	public static final By SingleRoom_getRoomCountAndNightCount_Lbl = By.xpath("//span[@class='property_room_nights']");
	public static final By multipleRoom_getRoomAndNightCount_Lbl = By.xpath("//div[contains(@class, 'property_booking_total_summary')]");
	public static final By soldOutCout_Lbl = By.xpath("//p[contains(text(), 'Sold Out')]");
	public static final By oneRoomLeftMssg_Lbl = By.xpath("//p[contains(text(),'1 room left')]");
	public static final String multipleRoom_OneRoomLeftMssg_Lbl = "//p[contains(text(),'1 room left')]";
	public static final String multipleRoomType_roomCount_WE = "(//div[contains(@class, 'property_room_type_rooms')]/input[@class='property_counter_input'])";
	public static final String multipleRoomType_soldOutMssg_WE = "(//div[@class='property_room_type_desc']/p[@class='property_room_type_rooms_remaining'])";
	public static final String multipleRooomType_propertyPlusButton_WE = "(//div[contains(@class, 'property_room_type_rooms')]/div[contains(@class, 'property_button_plus')])";
	public static final String multipleRoomType_individualPropertyPrice_WE = "(//span[contains(@class, 'room_type_per_night_amount')])";
	public static final By multipleRoomType_totalPriceForAllRooms_WE = By.xpath("//span[contains(@class, 'property_booking_total_amount')]");
	public static final By singleRoom_propertyRoomDetails_Btn = By.xpath("//span[contains(@class, 'property_room_details_bg')]");
	public static final By singleRoom_occupanyIncrease_Btn = By.xpath("(//div[contains(@class, 'property_button_plus')])[2]");
	public static final By singleRoom_propertyAddRoomsDone_Btn = By.xpath("//div[contains(@class, 'property_add_rooms_done')]");
	public static final By singleRoom_propertyRoomDetails_Lbl = By.xpath("//div[contains(@class, 'property_room_details')]");
	public static final String multipleRoom_occupancyIncrease_Btn = "(//div[contains(@class, 'property_plus_minus_container')]/div[contains(@class, 'property_button_plus')])";
	public static final String multipleRoomType_guestCount_WE = "(//div[contains(@class, 'property_plus_minus_container')]/input[contains(@class, 'property_counter_input')])";

	

	public static final String checkInDate1_WE = "(//div[contains(@class, 'datepicker-checkin')]//td[text()='";
	public static final String checkInDate2_WE = "'])[1]"; //[@class='day']";

	public static final String checkOutDate1_WE = "(//div[contains(@class, 'datepicker-checkout')]//td[text()='";
	public static final String checkOutDate2_WE = "'])[1]";  //[@class='day']";
	
	public static final String selectRooms_Btn = "//div[@class='property_booking_form_detail multi_room_type_detail']//a[text()='Select Rooms']";
	public static final By selectRoomsHref_Btn = By.xpath("//a[@href='#availability']");

	public String GetText_CheckInDate_WE() {
		return generic.getValue(checkIn_Date_WE);
	}


	public String GetText_CheckOutDate_WE() {
		return generic.getValue(checkOut_Date_WE);
	}


	public String getText_totalAmounnt_Lbl () {
		return generic.getText(totalAmounnt_Lbl);
	}

	public String getText_SingleRoom_getRoomCountAndNightCount_Lbl () {
		return generic.getText(SingleRoom_getRoomCountAndNightCount_Lbl);
	}

	public String getText_multipleRoom_getRoomAndNightCount_Lbl () {
		return generic.getText(multipleRoom_getRoomAndNightCount_Lbl);
	}

	public String getText_SingleRoom_getRoomCountAndGuestCount_Lbl () {
		return generic.getText(SingleRoom_getRoomCountAndGuestCount_Lbl);
	}

	public int getSize_multipleRoomPropertyRoomType_WE () {
		return 5;//generic.getSize(multipleRoomPropertyRoomType_WE);
	}

	public String getText_multipleRoom_SoldOutMssgForIndividualRoomType_Lbl () {
		return generic.getText(multipleRoom_SoldOutMssgForIndividualRoomType_Lbl);
	}

	public void click_addRoomForIndividualRoomType_Lbl () {
		generic.click(addRoomForIndividualRoomType_Lbl);
	}

	public void Select_CheckIn_CheckOut_Date_WE(String checkindate, String checkoutdate){
		if (checkindate.length() < 1)
			return;
		generic.click(checkIn_Date_WE);
		String str[] = checkindate.split("\\s+");
		while (!generic.getText(currentMonth_WE).equalsIgnoreCase(str[1] + " " + str[2]))
			generic.click(nextMonthClick_WE);
		if(str[0].startsWith("0"))
		{
			str[0] = str[0].substring(1, str[0].length());
		}
		generic.click("(" + checkInCalenderDates_WE + "[text()='" + str[0] + "']" + ")[1]" );
		if (checkoutdate.length() < 1)
			return;
		String strr [] = checkoutdate.split("\\s+");
		while (!generic.getText(nextMonth_WE).equals(strr[1] + " " + strr[2]))
			generic.click(nextMonthClick_WE);
		if(strr[0].startsWith("0"))
		{
			strr[0] = strr[0].substring(1, strr[0].length());
		}
		generic.click("(" + checkOutCalenderDates_WE + "[text()='" + strr[0] + "']" + ")[1]" );
	}


	public String getValue_singlePropertyRoomCount_WE () {
		return generic.getText(singlePropertyRoomCount_WE);
	}

	public String getText_availability_error_msg_Lbl (){
		return generic.getText(availability_error_msg_Lbl);
	}

	public void click_bookNow_Btn () {
		generic.click(bookNow_Btn);
	}


	public String getText_bookNow_Btn () {
		return generic.getText(bookNow_Btn);
	}


	public void visible_dropDown_Btn() {
		generic.isVisible(dropDown_Btn);
	}


	public int webElementsCount_soldOutCout_Lbl (){
		return generic.findElements(soldOutCout_Lbl).size();
	}

	public int getSize_oneRoomLeftMssg_Lbl () {
		return 5;//generic.getSize(oneRoomLeftMssg_Lbl);
	}

	public String getText_multipleRoomType_totalPriceForAllRooms_WE () {
		return generic.getText(multipleRoomType_totalPriceForAllRooms_WE);
	}

	public void click_singleRoom_propertyRoomDetails_Btn () {
		generic.click(singleRoom_propertyRoomDetails_Btn);
	}

	public void click_singleRoom_occupanyIncrease_Btn () {
		generic.click(singleRoom_occupanyIncrease_Btn);
	}


	public void click_singleRoom_propertyAddRoomsDone_Btn () {
		generic.click(singleRoom_propertyAddRoomsDone_Btn);
	}

	public String getText_singleRoom_propertyRoomDetails_Lbl () {
		return generic.getText(singleRoom_propertyRoomDetails_Lbl);
	}

	public void singleRoomTypePricecomparison (double detailFinalAmount, String paymentPageTotalAmount, 
			double paymentPageFinalAmount, 	double detailPageTotalPrice, double taxAmount) throws InterruptedException {
		PaymentPage paymentPage = new PaymentPage(driver, generic);
		Thread.sleep(3000L);
		paymentPageTotalAmount = paymentPage.getText_taxPercent_Lbl();
		Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(paymentPageTotalAmount);
		while (m.find())
		{
			detailFinalAmount = Double.parseDouble(m.group(1));
		}
		detailFinalAmount = (detailFinalAmount/100) * detailPageTotalPrice;
		detailFinalAmount = Math.ceil(detailFinalAmount);
		taxAmount = Double.parseDouble(paymentPage.getText_taxAmount_Lbl());
		Assert.assertEquals(taxAmount, detailFinalAmount, "Tax amount is not matched !! Prices are not correct !!");
		detailFinalAmount = detailFinalAmount + detailPageTotalPrice;
		paymentPageFinalAmount = Double.parseDouble(paymentPage.getText_finalAmount_Lbl());
		Assert.assertEquals(detailFinalAmount, paymentPageFinalAmount,"Final amount is not accurate !!");
	}
	


	public void Positive_CheckInCheckOutDateWE(){
	//	LocalDate todayDate = LocalDate.now();
		//	String nextDate = todayDate.plusDays(1).toString();
		LocalDate todayDate1 = LocalDate.now();
		String todayDate = todayDate1.plusDays(2).toString();
		String nextDate = todayDate1.plusDays(3).toString();
		//System.out.println(todayDate+" , "+nextDate);
		generic.click(checkIn_Date_WE);
		String spiltTodayDate[]=todayDate.toString().split("-");
	//	System.out.println(spiltTodayDate[0]+","+spiltTodayDate[1]+","+spiltTodayDate[2]);
	//	System.out.println(checkInDate1_WE+spiltTodayDate[2].replaceFirst("0", "")+checkInDate2_WE);
		generic.click(checkInDate1_WE+spiltTodayDate[2].replaceFirst("0", "")+checkInDate2_WE);
		String spiltNextDate[]=nextDate.toString().split("-");
		generic.click(checkOutDate1_WE+spiltNextDate[2].replaceFirst("0", "")+checkOutDate2_WE);
		
		//generic.click(selectRooms_Btn);
		//generic.click(selectRoomsHref_Btn);
		generic.click(bookNow_Btn);
	}



}