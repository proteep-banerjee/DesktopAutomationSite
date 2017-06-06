package com.fabhotels.dashboard.pageobjects;

import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;

public class SalesLogin {

	WebDriver driver;
	GenericFunctions generic;
	Users Users=new Users(driver,generic);
	
	public String username_Txt = "//input[@id='LoginForm_username']";
	public String password_Txt = "//input[@id='LoginForm_password']";
	public String login_Btn = "//input[@value='Login']";
	public String forgotPassword_Btn = "//a[@id='reset-pwd']";

	public String otp_Txt= "//input[@id='LoginForm_otp']";
	public String otpLogin_Btn = "//input[@value='Login']";
	public String resendOTP_Btn = "//a[@id='resend-otp']";
	
	
	
	
	public SalesLogin(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;		
	}
	
	public void positiveNewCorporateSalesLogin(){
		generic.fill(username_Txt, Users.username);  //USERS.username
		generic.fill(password_Txt, "aaaaaa");
		generic.click(login_Btn);
	}
	
	public void positiveCorporateSalesLogin(){
		generic.fill(username_Txt, "KIOSK11042017155655");  //USERS.username
		generic.fill(password_Txt, "aaaaaa");
		generic.click(login_Btn);
	}
	
	public void positiveSalesLogin(){
		generic.fill(username_Txt, "KIOSK11042017155655");  //USERS.username
		generic.fill(password_Txt, "aaaaaa");
		generic.click(login_Btn);
	}
	
	public void positiveSalesOTP(){
		generic.fill(otp_Txt, "123456");
		generic.click(otpLogin_Btn);
	}
	
	public void SalesLogin(Xls_Reader datatable, String sheetname, int rowNo){
		generic.fill(username_Txt, datatable.getCellData(sheetname, "username_Txt", rowNo));
		generic.fill(password_Txt, datatable.getCellData(sheetname, "password_Txt", rowNo));
		generic.click(login_Btn);
	}
}
