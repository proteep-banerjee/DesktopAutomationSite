package com.fabhotels.dashboard.pageobjects;

import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import org.testng.asserts.SoftAssert ;

public class Owners {

	WebDriver driver;
	GenericFunctions generic;
	SoftAssert SoftAssert =new SoftAssert();
	ManageUsers ManageUsers=new ManageUsers(driver,generic);

	public Owners(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;		
	}


	public String createOwners_Btn = "//a[contains(text(),'Create Hotel user')]";
	public String listOwners_Btn = "//a[contains(text(),'List Hotel user')]";
	public String UpdateOwners_Btn= "//a[contains(text(),'Update Hotel user')]";
	public String ManageOwners_Btn= "//a[contains(text(),'Manage Hotel user')]";

	public String property_Txt = "//select[@id='property_selector']/../span/input";
	public String property_Dd = "//select[@id='property_selector']";
	public String firstName_Txt = "//input[@id='Users_first_name']";
	public String lastName_Txt = "//input[@id='Users_last_name']";
	public String email_Txt = "//input[@id='Users_email']";
	public String countryCode_Txt = "//input[@id='Users_country_code']";
	public String mobile_Txt = "//input[@id='Users_mobile']";
	public String username_Txt = "//input[@id='Users_username']";
	public String password_Txt = "//input[@id='Users_password']";
	public String userOfflineNumber_Txt = "//input[@id='Users_user_offline_no']";
	public String role_Dd = "//select[@id='Users_role']"; 
	public String active_Dd = "//select[@id='Users_status']";

	public String create_Btn = "//input[@value='Create']";
	public String saveModify_Btn = "//input[@value='Save']";
	public String errorMessage_Err=""; //No Error Message

	public String viewOwnerID_WE = "(//table[@id='yw0']//td)[1]";
	public String viewOwnerFirstName_WE = "(//table[@id='yw0']//td)[2]";
	public String viewOwnerLastName_WE = "(//table[@id='yw0']//td)[3]";
	public String viewOwnerUsername_WE = "(//table[@id='yw0']//td)[4]";
	public String viewOwnerEmail_WE = "(//table[@id='yw0']//td)[5]";
	public String viewOwnerMobile_WE = "(//table[@id='yw0']//td)[6]";
	public String viewOwnerOfflineNumber_WE = "(//table[@id='yw0']//td)[7]";


	public String manageOwnersfirstName_Txt = "(//input[@name='Users[first_name]'])[2]";
	public String manageOwnerslastName_Txt = "(//input[@name='Users[last_name]'])[2]";
	public String manageOwnersUsername_Txt = "(//input[@name='Users[username]'])[2]";
	public String manageOwnersEmail_Txt = "(//input[@name='Users[email]'])[2]";
	public String manageOwnersMobile_Txt = "(//input[@name='Users[mobile]'])[2]";
	public String manageOwnersUserOfflineNo_Txt = "(//input[@name='Users[user_offline_no]'])[2]";
	public String manageOwnersupdate_Btn ="(//img[@alt='Update'])[1]";

	public String email;
	public String username;


	public void clickCreateOwners_Btn(){
		generic.click(createOwners_Btn);
	}

	public void clickListOwners_Btn(){
		generic.click(listOwners_Btn);
	}

	public void clickUpdateOwners_Btn(){
		generic.click(UpdateOwners_Btn);
	}

	public void clickManageOwners_Btn(){
		generic.click(ManageOwners_Btn);
	}
	
	public void searchOwnerbyUsername(){
		generic.fill(manageOwnersUsername_Txt, username);
		generic.enter(manageOwnersUsername_Txt);
		generic.click(manageOwnersupdate_Btn);
	}

	
	public void createOwner(Xls_Reader datatable, String sheetname, int rowNo){
		email="owner"+generic.getEmailasCurrentTimeStamp();
		username="owner"+generic.usernameTimeStamp();
		generic.fill(property_Txt, datatable.getCellData(sheetname, "property_Txt", rowNo));
		generic.fill(firstName_Txt, datatable.getCellData(sheetname, "firstName_Txt", rowNo));
		generic.fill(lastName_Txt, datatable.getCellData(sheetname, "lastName_Txt", rowNo));
		datatable.setCellData(sheetname, "email_Txt", rowNo,email);
		generic.fill(email_Txt, email);
		generic.fill(countryCode_Txt, datatable.getCellData(sheetname, "countryCode_Txt", rowNo));
		generic.fill(mobile_Txt, datatable.getCellData(sheetname, "mobile_Txt", rowNo));
		datatable.setCellData(sheetname, "username_Txt", rowNo,username);
		generic.fill(username_Txt, username);
		generic.fill(password_Txt, datatable.getCellData(sheetname, "password_Txt", rowNo));
		generic.fill(userOfflineNumber_Txt, datatable.getCellData(sheetname, "userOfflineNumber_Txt", rowNo));
		generic.select(role_Dd, datatable.getCellData(sheetname, "role_Dd", rowNo));
		generic.select(active_Dd,datatable.getCellData(sheetname, "active_Dd", rowNo));
		generic.click(create_Btn);
		generic.goToSleep(2000);
		positiveOwnerRole(username,email);
	}
	
		public void createOwnerRolePropertyAdmin(){
		email="owner"+generic.getEmailasCurrentTimeStamp();
		username="owner"+generic.usernameTimeStamp();
		generic.fill(property_Txt, "fabhotel Login Sankalp");
		//generic.select(property_Dd, "fabhotel Login Sankalp");
		generic.fill(countryCode_Txt, "+91");
		generic.fill(firstName_Txt, "Testing Owner first");
		generic.fill(lastName_Txt, "Testing Owner last");
		generic.fill(email_Txt, email);
		generic.fill(countryCode_Txt, "+91");
		generic.fill(mobile_Txt, "9650752666");
		generic.fill(username_Txt, username);
		generic.fill(password_Txt, "aaaaaa");
		generic.fill(userOfflineNumber_Txt, "01200000000");
		generic.select(role_Dd, "Property Admin");
		generic.select(active_Dd,"");
		generic.click(create_Btn);
		generic.goToSleep(2000);
		positiveOwnerRole(username,email);
	}

	public void createOwnerRolePropertyManager(){
		email="owner"+generic.getEmailasCurrentTimeStamp();
		username="owner"+generic.usernameTimeStamp();
		generic.fill(property_Txt, "fabhotel Login Sankalp");
		//generic.select(property_Dd, "fabhotel Login Sankalp");
		generic.fill(countryCode_Txt, "91");
		generic.fill(firstName_Txt, "Testing Owner first");
		generic.fill(lastName_Txt, "Testing Owner last");
		generic.fill(email_Txt, email);
		generic.fill(mobile_Txt, "9650752666");
		generic.fill(username_Txt, username);
		generic.fill(password_Txt, "aaaaaa");
		generic.fill(userOfflineNumber_Txt, "01200000000");
		generic.select(role_Dd, "Property Manager");
		generic.select(active_Dd,"");
		generic.click(create_Btn);
		generic.goToSleep(2000);
		positiveOwnerRole(username,email);
	}

	public void positiveOwnerRole(String username, String email){
		System.out.println("username :"+username+", email :"+email);
		SoftAssert =new SoftAssert();
		String viewOwnerID=generic.getText(viewOwnerID_WE);
		System.out.println(viewOwnerID);
		String viewOwnerFirstName=generic.getText(viewOwnerFirstName_WE);
		System.out.println(viewOwnerFirstName);
		String viewOwnerLastName=generic.getText(viewOwnerLastName_WE);
		String viewOwnerUsername=generic.getText(viewOwnerUsername_WE);
		String viewOwnerEmail=generic.getText(viewOwnerEmail_WE);
		String viewOwnerMobile=generic.getText(viewOwnerMobile_WE);
		String viewOwnerOfflineNumber=generic.getText(viewOwnerOfflineNumber_WE);
		SoftAssert.assertEquals(viewOwnerFirstName,"Testing Owner first","First Name does not matches.");
		SoftAssert.assertEquals(viewOwnerLastName,"Testing Owner last","Last Name does not matches.");
		SoftAssert.assertEquals(viewOwnerUsername,username," Username does not matches.");
		SoftAssert.assertEquals(viewOwnerEmail,email,"Email does not matches.");
		SoftAssert.assertEquals(viewOwnerMobile,"9650752666","Mobile Number does not matches.");
		SoftAssert.assertEquals(viewOwnerOfflineNumber,"01200000000","Offline Number does not matches.");
		SoftAssert.assertAll();
	}
	
	public void modifyOwnerRolePropertyAdminToPropertyManager(){
		email="ownerModify"+generic.getEmailasCurrentTimeStamp();
		generic.fill(property_Txt, "fabhotel Login Sankalp");
		//generic.select(property_Dd, "fabhotel Login Sankalp");
		generic.fill(countryCode_Txt, "91");
		generic.fill(firstName_Txt, "Testing Owner first modify");
		generic.fill(lastName_Txt, "Testing Owner last modify");
		generic.fill(email_Txt, email);
		generic.fill(mobile_Txt, "09650752666");
		generic.fill(password_Txt, "aaaaaa");
		generic.fill(userOfflineNumber_Txt, "1234567890");
		generic.select(role_Dd, "Property Manager");
		generic.select(active_Dd,"Inactive");
		generic.click(saveModify_Btn);
		generic.goToSleep(2000);
		positiveModifyOwnerRole(username,email);
	}
	
	public void positiveModifyOwnerRole(String username, String email){
		String viewOwnerID=generic.getText(viewOwnerID_WE);
		System.out.println(viewOwnerID);
		String viewOwnerFirstName=generic.getText(viewOwnerFirstName_WE);
		System.out.println(viewOwnerFirstName);
		String viewOwnerLastName=generic.getText(viewOwnerLastName_WE);
		String viewOwnerUsername=generic.getText(viewOwnerUsername_WE);
		String viewOwnerEmail=generic.getText(viewOwnerEmail_WE);
		String viewOwnerMobile=generic.getText(viewOwnerMobile_WE);
		String viewOwnerOfflineNumber=generic.getText(viewOwnerOfflineNumber_WE);
		SoftAssert.assertEquals(viewOwnerFirstName,"Testing Owner first modify","First Name does not matches.");
		SoftAssert.assertEquals(viewOwnerLastName,"Testing Owner last modify","Last Name does not matches.");
		SoftAssert.assertEquals(viewOwnerUsername,username," Username does not matches.");
		SoftAssert.assertEquals(viewOwnerEmail,email,"Email does not matches.");
		SoftAssert.assertEquals(viewOwnerMobile,"09650752666","Mobile Number does not matches.");
		SoftAssert.assertEquals(viewOwnerOfflineNumber,"1234567890","Offline Number does not matches.");
		SoftAssert.assertAll();
	}


}
