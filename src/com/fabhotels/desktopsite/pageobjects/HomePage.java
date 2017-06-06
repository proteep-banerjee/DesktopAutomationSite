package com.fabhotels.desktopsite.pageobjects;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class HomePage {
	WebDriver driver;
	GenericFunctions generic;


	public static final By location_Txt = By.id("autocomplete-location");
	public static final By checkIn_Date_WE = By.id("checkIn");
	public static final By checkOut_Date_WE = By.id("checkOut");
	public static final By find_Fabhotels_Btn = By.id("homePageSearchBtn");
	public static final By lowest_Online_Prices_WE = By.xpath("//div[@class='middle_bx_lowest_price']/img[@class='lazy']");
	public static final By photo_Match_WE = By.xpath("//div[@Class='middle_bx_photo_match_white_bx']");
	public static final By propertyPromotion_widget_WE = By.xpath("//div[@class='middle_bx_photo_match_pic_shadow']");
	public static final By best_Reviewed_Chain_WE = By.xpath("//div[contains(@class, 'best_review_chain')]/img[contains(@class, 'lazy')]");
	public static final By Best_Deals_WE = By.xpath("//div[@class='best_hotel_deals']");
	public static final By stay_More_Earn_More_WE = By.xpath("//div[@class='stay_more_earn']");
	public static final By best_Deals_WE = By.xpath("//div[@class='last_minute_offer_text']");
	public static final By testimonial_bx_heading_WE = By.xpath("//div[@class='testimonial_bx_heading']");
	public static final By homepage_Reviews_R_WE = By.xpath("//span[@class='homepage_reviews_slide_right']");
	public static final By homepage_Reviews_L_WE = By.xpath("//span[@class='homepage_reviews_slide_left']");
	public static final By subscriber_Email_Txt = By.id("subscriberEmail");
	public static final By subscribe_Btn = By.xpath("//input[@type='submit']");
	public static final By Subscribe_SuccessMssg_WE = By.xpath("//p[contains(text(), 'Thank you! We shall keep you updated')]");
	public static final By Subscribe_AlreadySubscribedMssg_WE = By.xpath("//p[contains(text(), 'You are already subscribed')]");
	public static final By Subscribe_WrongEmailMssg_WE = By.xpath("//p[contains(text(), 'Oops! We think this is not a valid email ID')]");
	public static final By review_bx_heading_wrd_name_WE = By.xpath("//div[@class='review_bx_heading_wrd_name']");

	public static final By voucher_Close_Btn = By.xpath("//div[@class='vouchure-modal-dialog']//button[@class='vouchure_close modal_review_cls']");
	public static final By voucher_Name_Txt = By.xpath("//input[@placeholder='Your name']");
	public static final By voucher_EmailID_Txt = By.xpath("//input[@placeholder='Your email ID']");
	public static final By voucher_MobileNumber_Txt = By.xpath("//input[@placeholder='Your mobile no.']");
	public static final By voucher_SendMeVouchers_Btn = By.xpath("//button[text()='Yes, Send me vouchers']");

	public static final By getCheckInMonthText1_WE = By.xpath("(//th[@class='month'])[1]");
	public static final By getCheckInMonthText2_WE = By.xpath("(//th[@class='month'])[2]");

	public static final By getCheckInDateText_WE = By.xpath("//div[@id='daterangepicker_start']");
	public static final By getCheckOutDateText_WE = By.xpath("//div[@id='daterangepicker_end']");

	public static final String checkInDate1_Btn = "//div[@class='calendar left']///td[text()='";
	public static final String checkInDate2_Btn = "']";

	public static final String checkOutDate1_Btn = "//div[@class='calendar right']///td[text()='";
	public static final String checkOutDate2_Btn = "']";


	public static final String click_checkIn_Btn = "//div[@id='daterangepicker_start']";
	public static final String click_checkOut_Btn = "//div[@id='daterangepicker_end']";

	//input[@id='checkOut']
	//div[@id='booking_calender']//td[text()='14']

	public HomePage(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}

	public boolean VerifyScrollFunctionality_ReviewBar() {
		List<WebElement> we = driver.findElements(review_bx_heading_wrd_name_WE);

		//String first = we.get(0).getText();
		String second = we.get(1).getText();

		generic.click(homepage_Reviews_R_WE);

		generic.goToSleep(2000);

		List<WebElement> we1 = driver.findElements(review_bx_heading_wrd_name_WE);

		String first1 = we1.get(0).getText();
		// String second1 = we1.get(1).getText();

		System.out.println(first1 + "   " + second);
		// System.out.println(second + " " + second1);

		if (first1.equals(second))
			return true;
		else
			return false;
	}

	public void fill_location_Txt(String input) {
		generic.fill(location_Txt, input);
	}

	public void clear_location_Txt() {
		generic.clear(location_Txt);
	}

	public String getText_location_Txt() {
		return generic.getText(location_Txt);
	}

	public void click_location_Txt() {
		generic.click(location_Txt);
	}

	public void click_checkIn_Date_WE() {
		generic.click(checkIn_Date_WE);
	}

	public String getText_checkIn_Date_WE() {
		return generic.getText(checkIn_Date_WE);
	}

	public void click_checkOut_Date_WE() {
		generic.click(checkOut_Date_WE);
	}

	public String getText_checkOut_Date_WE() {
		return generic.getText(checkOut_Date_WE);
	}

	public void click_find_Fabhotels_Btn() {
		generic.click(find_Fabhotels_Btn);
	}

	public String getText_find_Fabhotels_Btn() {
		return generic.getText(find_Fabhotels_Btn);
	}

	public String getText_lowest_Online_Prices_WE() {
		return generic.getText(lowest_Online_Prices_WE);
	}

	public String getText_photo_Match_WE() {
		return generic.getText(photo_Match_WE);
	}

	public void click_PropertyPromotion_widget() {
		generic.click(propertyPromotion_widget_WE);
	}

	public void click_best_Reviewed_Chain_WE() {
		generic.click(best_Reviewed_Chain_WE);
	}

	public void click_Best_Deals_WE() {
		generic.clear(Best_Deals_WE);
	}

	public String getText_testimonial_bx_heading_WE () {
		return generic.getText(testimonial_bx_heading_WE);
	}

	public void click_homepage_Reviews_R_WE () {
		generic.click(homepage_Reviews_R_WE);
	}

	public void click_homepage_Reviews_L_WE () {
		generic.click(homepage_Reviews_L_WE);
	}

	public void fill_subscriber_Email_Txt (String input) {
		generic.fill(subscriber_Email_Txt, input);
	}

	public void clear_subscriber_Email_Txt() {
		generic.clear(subscriber_Email_Txt);
	}

	public String getText_subscriber_Email_Txt() {
		return generic.getText(subscriber_Email_Txt);
	}

	public void click_subscriber_Email_Txt() {
		generic.click(subscriber_Email_Txt);
	}

	public void click_subscribe_Btn() {
		generic.click(subscribe_Btn);
	}

	public void click_voucher_Close_Btn() {
		generic.click(voucher_Close_Btn);
	}


	public void click_checkInDate_WE(){
		generic.clear(checkIn_Date_WE);
	}

	public void click_checkOutDate_WE(){
		generic.clear(checkOut_Date_WE);
	}

	public void getCheckInMonthText1_WE(){
		driver.findElement(getCheckInMonthText1_WE).getText();
	}

	public void getCheckInMonthText2_WE(){
		driver.findElement(getCheckInMonthText2_WE).getText();
	}

	public void click_checkInDate_Btn(){
		generic.clear(checkIn_Date_WE);
	}

	public void click_checkOutDate_Btn(){
		generic.clear(checkOut_Date_WE);
	}

	public void getCheckInDateText_WE(){
		driver.findElement(getCheckInDateText_WE).getText();
	}

	public void getCheckOutDateText_WE(){
		driver.findElement(getCheckOutDateText_WE).getText();
	}

	public void Click_Btn(String xpath){
		try{
			driver.findElement(By.xpath(xpath)).click();
		}catch(Exception e){

		}
	}

	public void Click_Btn(String xpath1,String xpath2 , String inputData){
		String xpath=xpath1+inputData+xpath2;
		try{
			System.out.println(xpath);
			driver.findElement(By.xpath(xpath)).click();
		}catch(Exception e){

		}
	}

	public void positiveCase_Search_HomePage(){

		if(generic.isVisible(voucher_Close_Btn)){
			click_voucher_Close_Btn();
		}
		LocalDate todayDate = LocalDate.now();
		String nextDate = todayDate.plusDays(1).toString();
		System.out.println(todayDate+" , "+nextDate);
		click_checkInDate_WE();
		String spiltDate[]=todayDate.toString().split("-");
		Click_Btn(checkInDate1_Btn,checkInDate2_Btn,spiltDate[2]);
	}
	
	
}
