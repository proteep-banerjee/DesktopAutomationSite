package com.fabhotels.dashboard.pageobjects;

import org.openqa.selenium.WebDriver;

import org.testng.asserts.SoftAssert;
import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class Sales {

	WebDriver driver;
	GenericFunctions generic;
	SoftAssert SoftAssert = new SoftAssert();
	ManageUsers ManageUsers=new ManageUsers(driver,generic);

	public Sales(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;		
	}

	public String createBooking_Btn = "(//a[text()='Create Booking'])[1]";
	public String viewBooking_Btn = "(//a[text()='View Bookings'])[1]";
	
	public String home_Btn="//a[text()='Home']";

	public String city_DD = "//select[@id='CorporateBooking_propertyCity']";
	public String property_DD = "//select[@id='CorporateBooking_property_id']";
	public String checkIn_Txt = "//input[@id='CorporateBooking_checkin']";
	public String checkout_Txt = "//input[@id='CorporateBooking_checkout']";
	public String rooms_DD = "//select[@id='CorporateBooking_rooms']";
	public String roomCategory_DD = "//select[@id='CorporateBooking_room_category_0']";
	public String occupancy_DD = "//select[@id='CorporateBooking_occupancy_0']";
	public String title_DD = "//select[@id='CorporateUsers_title']";
	public String firstName_Txt = "//input[@id='CorporateUsers_first_name']";
	public String lastName_Txt = "//input[@id='CorporateUsers_last_name']";
	public String countryCode_Dd = "//select[@id='CorporateUsers_country_code']";
	public String mobile_Txt = "//input[@id='CorporateUsers_mobile']";
	public String email_Txt = "//input[@id='CorporateUsers_email']";
	public String inclusion_DD = "//select[@id='CorporateBooking_inclusions']";
	public String agnetCommission_Txt = "//input[@id='travel_agent_commission_val']";
	public String specialRequest_Txt = "//textarea[@id='CorporateBooking_special_request']";
	public String corporateName_DD = "//select[@id='CorporateBooking_cr_company_name']";
	public String paymentMode_DD = "//select[@id='CorporateBooking_payment_mode']";
	public String singleRoom_Txt = "//input[@id='CorporateBooking_custom_single_room_price']";
	public String doubleRoomPrice_Txt = "//input[@id='CorporateBooking_custom_double_room_price']";
	public String tripleRoomPrice_Txt = "//input[@id='CorporateBooking_custom_triple_room_price']";
	public String managerName_Txt = "//input[@id='CorporateBooking_cr_manager_name']";
	public String managerEmail_Txt = "//input[@id='CorporateBooking_cr_manager_email']";
	public String managerPhone_Txt = "//input[@id='CorporateBooking_cr_manager_phone']";

	public String validateOrderID_WE = "(//span[@class='list-box-right'])[1]";
	public String validateCorporateName_WE = "(//span[@class='list-box-right'])[2]";
	public String validateHotelName_WE = "(//span[@class='list-box-right'])[3]";
	public String validateCheckIn_WE = "(//span[@class='list-box-right'])[4]";
	public String validateCheckOut_WE = "(//span[@class='list-box-right'])[5]";
	public String validateRooms_WE = "(//span[@class='list-box-right'])[6]";
	public String validateRoomType_WE = "(//span[@class='list-box-right'])[7]";
	public String validateOccupancy_WE = "(//span[@class='list-box-right'])[8]";
	public String validateBookingStatus_WE = "(//span[@class='list-box-right'])[9]";
	public String validateGuestStatus_WE = "(//span[@class='list-box-right'])[10]";
	public String validateBookingDate_WE = "(//span[@class='list-box-right'])[11]";
	public String validateBookingPrice_WE = "(//span[@class='list-box-right'])[12]";
	public String validatePaymentMode_WE = "(//span[@class='list-box-right'])[13]";
	public String validateRoomPrice_WE = "(//span[@class='list-box-right'])[14]";
	public String validateGuestName_WE = "(//span[@class='list-box-right'])[15]";
	public String validateInclusion_WE = "(//span[@class='list-box-right'])[16]";
	public String validateTravelAgent_WE = "(//span[@class='list-box-right'])[17]";
	public String validateMealCost_WE = "(//span[@class='list-box-right'])[18]";
	public String validateCabCost_WE = "(//span[@class='list-box-right'])[19]";
	public String validateSpecialRequest_WE = "(//span[@class='list-box-right'])[20]";
	public String validateIsVIP_WE = "(//span[@class='list-box-right'])[21]//span";

	public String validateEditBooking_Btn = "//a[text()='Edit Booking']";
	public String validateCancelBooking_Btn ="//a[text()='Cancel Booking']";

	public String validateSaveEditBooking_Btn = "//input[@value='Save']";
	
	public String viewDetails_Btn = "(//a[text()='View Details'])[1]";


	public String create_Btn = "//input[@value='Create']";

	public String email;
	public String days;


	public void createBooking_btn(){
		generic.click(createBooking_Btn);
	}
	public void viewBooking_btn(){
		generic.click(viewBooking_Btn);
	}
	
	public void home_Btn(){
		generic.click(home_Btn);
	}


	public void clickOnCreateSaleBooking_Btn(){
		generic.click(create_Btn);
	}
	public void clickOnSaveSaleBooking_Btn(){
		generic.click(validateSaveEditBooking_Btn);
	}
	public void clickOnEditSaleBooking_Btn(){
		generic.click(validateEditBooking_Btn);
	}
	public void clickOnCancelSaleBooking_Btn(){
		generic.click(validateCancelBooking_Btn);
	}

	public void viewDetailsSaleBooking_Btn(){
		generic.click(viewDetails_Btn);
	}


	public void positiveViewSalesBooking(){
		String viewValidateOrderID_WE = generic.getText(validateOrderID_WE);
		String viewValidateCorporateName_WE = generic.getText(validateCorporateName_WE);
		String viewValidateHotelName_WE = generic.getText(validateHotelName_WE);
		String viewValidateCheckIn_WE = generic.getText(validateCheckIn_WE);
		String viewValidateCheckOut_WE = generic.getText(validateCheckOut_WE);
		String viewValidateRooms_WE = generic.getText(validateRooms_WE);
		String viewValidateRoomType_WE = generic.getText(validateRoomType_WE);
		String viewValidateOccupancy_WE = generic.getText(validateOccupancy_WE);
		String viewValidateBookingStatus_WE = generic.getText(validateBookingStatus_WE);
		String viewValidateGuestStatus_WE = generic.getText(validateGuestStatus_WE);
		String viewValidateBookingDate_WE = generic.getText(validateBookingDate_WE);
		String viewValidateBookingPrice_WE = generic.getText(validateBookingPrice_WE);
		String viewValidatePaymentMode_WE = generic.getText(validatePaymentMode_WE);
		String viewValidateRoomPrice_WE = generic.getText(validateRoomPrice_WE);
		String viewValidateGuestName_WE = generic.getText(validateGuestName_WE);
		String viewValidateInclusion_WE = generic.getText(validateInclusion_WE);
		String viewValidateTravelAgent_WE = generic.getText(validateTravelAgent_WE);
		String viewValidateMealCost_WE = generic.getText(validateMealCost_WE);
		String viewValidateCabCost_WE = generic.getText(validateCabCost_WE);
		String viewValidateSpecialRequest_WE = generic.getText(validateSpecialRequest_WE);
		String viewValidateIsVIP_WE = generic.getText(validateIsVIP_WE);

		SoftAssert.assertTrue(viewValidateOrderID_WE.length()!=0,"Issue in Order ID");
		SoftAssert.assertEquals(viewValidateCorporateName_WE,CorporateCompany.coporateName,"Issue in viewValidateCorporateName_WE");
		SoftAssert.assertEquals(viewValidateHotelName_WE,"fabhotel Login Sankalp","Issue in viewValidateHotelName_WE");

		SoftAssert.assertEquals(viewValidateCheckIn_WE,generic.dateWithDifferentFormat("dd-MMM-uuuu",2)
				.replaceAll("-", " "),"Issue in CheckIn");
		SoftAssert.assertEquals(viewValidateCheckOut_WE,generic.dateWithDifferentFormat("dd-MMM-uuuu",3)
				.replaceAll("-", " "),"Issue in CheckOut");
		SoftAssert.assertEquals(viewValidateRooms_WE,"2","Issue in ");
		SoftAssert.assertEquals(viewValidateRoomType_WE,"Premium,Deluxe Sankalp","Issue in ");
		SoftAssert.assertEquals(viewValidateOccupancy_WE,"[Double] [Single]","Issue in ");
		SoftAssert.assertEquals(viewValidateBookingStatus_WE,"Confirmed","Issue in ");
		SoftAssert.assertEquals(viewValidateGuestStatus_WE,"Pending","Issue in ");
		SoftAssert.assertEquals(viewValidateBookingDate_WE,generic.dateWithDifferentFormat("dd-MMM-uuuu",0)
				.replaceAll("-", " "),"Issue in Booking Date");
//		SoftAssert.assertEquals(viewValidateBookingPrice_WE,"32,700.00","Issue in ");
		SoftAssert.assertEquals(viewValidateBookingPrice_WE.length()!=0,true,"Issue in ");
		SoftAssert.assertEquals(viewValidatePaymentMode_WE,"Pay @ Hotel","Issue in ");
//		SoftAssert.assertEquals(viewValidateRoomPrice_WE,"10000\n20000\n0","Issue in ");
		SoftAssert.assertEquals(viewValidateRoomPrice_WE.length()!=0,true,"Issue in ");
		SoftAssert.assertEquals(viewValidateGuestName_WE,"Testing Login All fields Booking","Issue in ");
		SoftAssert.assertEquals(viewValidateInclusion_WE,"Office Transfers, Taxes, Breakfast & WiFi","Issue in ");
		SoftAssert.assertEquals(viewValidateTravelAgent_WE,"100","Issue in ");
		SoftAssert.assertEquals(viewValidateMealCost_WE,"0","Issue in ");
		SoftAssert.assertEquals(viewValidateCabCost_WE,"0","Issue in ");
		SoftAssert.assertEquals(viewValidateMealCost_WE,"0","Issue in ");
		SoftAssert.assertEquals(viewValidateIsVIP_WE,"No","Issue in ");
		SoftAssert.assertAll();		
	}	
	public void positiveViewSalesCancelledBooking(){
		String viewValidateOrderID_WE = generic.getText(validateOrderID_WE);
		String viewValidateCorporateName_WE = generic.getText(validateCorporateName_WE);
		String viewValidateHotelName_WE = generic.getText(validateHotelName_WE);
		String viewValidateCheckIn_WE = generic.getText(validateCheckIn_WE);
		String viewValidateCheckOut_WE = generic.getText(validateCheckOut_WE);
		String viewValidateRooms_WE = generic.getText(validateRooms_WE);
		String viewValidateRoomType_WE = generic.getText(validateRoomType_WE);
		String viewValidateOccupancy_WE = generic.getText(validateOccupancy_WE);
		String viewValidateBookingStatus_WE = generic.getText(validateBookingStatus_WE);
		String viewValidateGuestStatus_WE = generic.getText(validateGuestStatus_WE);
		String viewValidateBookingDate_WE = generic.getText(validateBookingDate_WE);
		String viewValidateBookingPrice_WE = generic.getText(validateBookingPrice_WE);
		String viewValidatePaymentMode_WE = generic.getText(validatePaymentMode_WE);
		String viewValidateRoomPrice_WE = generic.getText(validateRoomPrice_WE);
		String viewValidateGuestName_WE = generic.getText(validateGuestName_WE);
		String viewValidateInclusion_WE = generic.getText(validateInclusion_WE);
		String viewValidateTravelAgent_WE = generic.getText(validateTravelAgent_WE);
		String viewValidateMealCost_WE = generic.getText(validateMealCost_WE);
		String viewValidateCabCost_WE = generic.getText(validateCabCost_WE);
		String viewValidateSpecialRequest_WE = generic.getText(validateSpecialRequest_WE);
		String viewValidateIsVIP_WE = generic.getText(validateIsVIP_WE);

		SoftAssert.assertTrue(viewValidateOrderID_WE.length()!=0,"Issue in Order ID");
		SoftAssert.assertEquals(viewValidateCorporateName_WE,CorporateCompany.coporateName,"Issue in viewValidateCorporateName_WE");
		SoftAssert.assertEquals(viewValidateHotelName_WE,"fabhotel Login Sankalp","Issue in viewValidateHotelName_WE");

		SoftAssert.assertEquals(viewValidateCheckIn_WE,generic.dateWithDifferentFormat("dd-MMM-uuuu",2)
				.replaceAll("-", " "),"Issue in CheckIn");
		SoftAssert.assertEquals(viewValidateCheckOut_WE,generic.dateWithDifferentFormat("dd-MMM-uuuu",3)
				.replaceAll("-", " "),"Issue in CheckOut");
		SoftAssert.assertEquals(viewValidateRooms_WE,"2","Issue in ");
		SoftAssert.assertEquals(viewValidateRoomType_WE,"Premium,Deluxe Sankalp","Issue in ");
		SoftAssert.assertEquals(viewValidateOccupancy_WE,"[Double] [Single]","Issue in ");
		SoftAssert.assertEquals(viewValidateBookingStatus_WE,"Confirmed","Issue in ");
		SoftAssert.assertEquals(viewValidateGuestStatus_WE,"Cancelled","Issue in ");
		SoftAssert.assertEquals(viewValidateBookingDate_WE,generic.dateWithDifferentFormat("dd-MMM-uuuu",0)
				.replaceAll("-", " "),"Issue in Booking Date");
//		SoftAssert.assertEquals(viewValidateBookingPrice_WE,"32,700.00","Issue in ");
		SoftAssert.assertEquals(viewValidateBookingPrice_WE.length()!=0,true,"Issue in ");
		SoftAssert.assertEquals(viewValidatePaymentMode_WE,"Pay @ Hotel","Issue in ");
//		SoftAssert.assertEquals(viewValidateRoomPrice_WE,"10000\n20000\n0","Issue in ");
		SoftAssert.assertEquals(viewValidateRoomPrice_WE.length()!=0,true,"Issue in ");
		SoftAssert.assertEquals(viewValidateGuestName_WE,"Testing Login All fields Booking","Issue in ");
		SoftAssert.assertEquals(viewValidateInclusion_WE,"Office Transfers, Taxes, Breakfast & WiFi","Issue in ");
		SoftAssert.assertEquals(viewValidateTravelAgent_WE,"100","Issue in ");
		SoftAssert.assertEquals(viewValidateMealCost_WE,"0","Issue in ");
		SoftAssert.assertEquals(viewValidateCabCost_WE,"0","Issue in ");
		SoftAssert.assertEquals(viewValidateMealCost_WE,"0","Issue in ");
		SoftAssert.assertEquals(viewValidateIsVIP_WE,"No","Issue in ");
		SoftAssert.assertAll();		
	}

	public void CreateBookingWithMinimumFields(){
		createBooking_btn();
		positiveDataForMinimumFields();
		clickOnCreateSaleBooking_Btn();
	}
	
	public void CreateBookingWithChangesInAllFields(){
		createBooking_btn();
		positiveDataForAllFields();
		clickOnCreateSaleBooking_Btn();
	}

	public void EditBookingWithChangesInAllFields(){
		clickOnEditSaleBooking_Btn();
		positiveDataForAllFields();
		clickOnSaveSaleBooking_Btn();
	}

	public void positiveDataForMinimumFields(){
		days=generic.getDatesInMMDDYYYY();
		String day[]=days.toString().split("-");
		generic.select(city_DD, "Gurgaon");
		generic.select(property_DD, "fabhotel Login Sankalp");
		generic.fillCalendar(checkIn_Txt, day[0]);
		generic.fillCalendar(checkout_Txt, day[1]);
		generic.fill(firstName_Txt, "Testing Login");
		generic.fill(lastName_Txt, "Booking");
		generic.fill(mobile_Txt, "9650752666");
		email=generic.getEmailasCurrentTimeStamp();
		generic.fill(email_Txt, email); 
		generic.fill(specialRequest_Txt, "No special request");

	}

	public void positiveDataForAllFields(){
		days=generic.getDatesInMMDDYYYY();
		String day[]=days.toString().split("-");
		generic.select(city_DD, "Gurgaon");
		generic.select(property_DD, "fabhotel Login Sankalp");
		generic.fillCalendar(checkIn_Txt, day[0]);
		generic.fillCalendar(checkout_Txt, day[1]);
		generic.select(rooms_DD, "02");
		generic.select(roomCategory_DD, "Premium");
		generic.select(occupancy_DD, "Double");
		generic.select(title_DD, "Ms");
		generic.fill(firstName_Txt, "Testing Login");
		generic.fill(lastName_Txt, "All fields Booking");
		generic.select(countryCode_Dd,"Afghanistan +93" );
		generic.fill(mobile_Txt, "765075266");
		email=generic.getEmailasCurrentTimeStamp();
		generic.fill(email_Txt, email); 
		generic.select(inclusion_DD, "Office Transfers, Taxes, Breakfast & WiFi");
		generic.fill(agnetCommission_Txt, "100");
		generic.fill(specialRequest_Txt, "No special request");
		//generic.select(corporateName_DD,"Sankalp Login Corporate");
		generic.select(paymentMode_DD,"Pay @ Hotel");
		generic.fill(singleRoom_Txt, "10000");
		generic.fill(doubleRoomPrice_Txt, "20000");
		generic.fill(tripleRoomPrice_Txt, "30000");
		generic.fill(managerName_Txt, "Manager Name Sales Testing");
		generic.fill(managerEmail_Txt, "sankalpsales@mailinator.com");
		generic.fill(managerPhone_Txt, "09650752666");
	}


}
