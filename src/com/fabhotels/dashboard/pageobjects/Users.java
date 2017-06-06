package com.fabhotels.dashboard.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.automationframework.core.CustomAssert;

public class Users {

	WebDriver driver;
	GenericFunctions generic;
	CustomAssert CustomAssert;
	ManageUsers ManageUsers=new ManageUsers(driver,generic);

	public Users(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;		
	}
	public String users_Btn = "//ul[@class='operations']//li//a[(text()='Users')]";

	//	public String users_Btn = "//ul/li[8]/a";
	public String createUsers_Btn= "//a[contains(text(),'Create Users')]";

	public String firstName_Txt = "//input[@id='Users_first_name']";
	public String lastName_Txt = "//input[@id='Users_last_name']";
	public String email_Txt = "//input[@id='Users_email']";
	public String countryCode_Txt = "//input[@id='Users_country_code']";
	public String mobile_Txt = "//input[@id='Users_mobile']";
	public String userType_Dd = "//select[@id='Users_user_type']";
	public String selectUserType1_Dd = "//select[@id='Users_user_type']//option[@value='"; //EXECUTIVE
	public String selectUserType2_Dd = "']";
	public String username_Txt = "//input[@id='Users_username']";
	public String password_Txt = "//input[@id='Users_password']";
	public String cluster_Dd = "//select[@id='cluster_selector']";
	public String selectCluster1_Dd = "//select[@id='cluster_selector']//option[@value='"; //Bangalore
	public String selectCluster2_Dd = "']";
	public String cluster_Chk = "//input[@id='Users_selectAllClusters']";
	public String role_Dd = "//select[@id='Users_role']";
	public String selectRole1_Dd = "//select[@id='Users_role']//option[@value='"; //bookingsummary
	public String selectRole2_Dd = "']";
	public String active_Dd = "//select[@id='Users_status']";
	public String selectActive1_Dd = "//select[@id='Users_status']//option[text()='"; //Active
	public String selectActive2_Dd = "']";

	public String create_Btn = "//input[@value='Create']";

	public String errorMessage_Err=""; //No Error Message


	public String viewUserID_WE = "(//table[@id='yw0']//td)[1]";
	public String viewUserFirstName_WE = "(//table[@id='yw0']//td)[2]";
	public String viewUserLastName_WE = "(//table[@id='yw0']//td)[3]";
	public String viewUserUsername_WE = "(//table[@id='yw0']//td)[4]";
	public String viewUserEmail_WE = "(//table[@id='yw0']//td)[5]";
	public String viewUserMobile_WE = "(//table[@id='yw0']//td)[6]";

	public String first_Name_Txt="(//input[@name='Users[first_name]'])[2]";
	public String last_Name_Txt="(//input[@name='Users[last_name]'])[2]";
	public String user_name_Txt="(//input[@name='Users[username]'])[2]";
	public String e_mail_Txt="(//input[@name='Users[email]'])[2]";
	public String m_obile_Txt="(//input[@name='Users[mobile]'])[2]";
	public String u_pdate_Btn="(//img[@alt='Update'])[1]";

	public String save_Btn="//input[@value='Save']";

	public void searchByUsername(){
		generic.fill(user_name_Txt, username);
		generic.click(u_pdate_Btn);
	}

	public static String username;
	public String email;

	public String userType;
	public String role;



	public void positiveCreateUser_EXECUTIVE(){
		userType="EXECUTIVE";
		role="bookingsummary";
		FillUserDetails(userType,role);
	}

	public void positiveCreateUser_ONLINE(){
		userType="ONLINE";
		role="bookingsummary";
		FillUserDetails(userType,role);
	}

	public void positiveCreateUser_SALES(){
		userType="SALES";
		role="corporate account manager";
		FillUserDetails(userType,role);
	}

	public void negativeCreateUser_SALES(){
		userType="SALES";
		role="corporate booking agent";
		FillUserDetails(userType,role);
	}

	public void positiveCreateUser_AUDITOR(){
		userType="AUDITOR";
		role="bookingsummary";
		FillUserDetails(userType,role);
	}

	public void positiveCreateUser_TABLET(){
		userType="TABLET";
		role="bookingsummary";
		FillUserDetails(userType,role);
	}


	public void positiveModifyUserTo_EXECUTIVE(){
		userType="EXECUTIVE";
		role="bookingsummary";
		ModifyUserDetails(userType,role);
	}

	public void positiveModifyUserTo_ONLINE(){
		userType="ONLINE";
		role="bookingsummary";
		ModifyUserDetails(userType,role);
	}

	public void positiveModifyUserTo_SALES(){
		userType="SALES";
		role="corporate booking agent";
		ModifyUserDetails(userType,role);
	}

	public void positiveModifyUserTo_AUDITOR(){
		userType="AUDITOR";
		role="bookingsummary";
		ModifyUserDetails(userType,role);
	}

	public void positiveModifyUserTo_TABLET(){
		userType="TABLET";
		role="bookingsummary";
		ModifyUserDetails(userType,role);
	}


	public void FillUserDetails(String userType, String role){
		username=generic.usernameTimeStamp();
		System.out.println(userType+"Username : "+username);
		email=generic.getEmailasCurrentTimeStamp();
		generic.goToSleep(5000);
	//	generic.pageScrollToBottomInSlowMotion(10,10);
		generic.click(users_Btn);
		generic.click(createUsers_Btn);
		generic.fill(firstName_Txt, "Testing firstName");
		generic.fill(lastName_Txt, "Testing LastName");
		generic.fill(email_Txt, email);
		generic.fill(countryCode_Txt, "+91");
		generic.fill(mobile_Txt, "9650752666");
		generic.select(userType_Dd, userType);
		generic.fill(username_Txt, username);
	//	generic.pageScrollToBottomInSlowMotion(10,10);
		generic.fill(password_Txt, "aaaaaa");
		generic.select(cluster_Dd, "Bangalore");
		generic.click(cluster_Chk);
		generic.select(role_Dd, role);
		generic.select(active_Dd, "Active");
		generic.click(create_Btn);
		generic.goToSleep(3000);
		positiveViewUser(username,email);
	}

	public void ModifyUserDetails(String userType, String role){
		email=generic.getEmailasCurrentTimeStamp();
		generic.goToSleep(5000);
		generic.pageScrollToBottomInSlowMotion(10,10);
		generic.click(users_Btn);
		searchByUsername();
		generic.fill(firstName_Txt, "Testing firstName");
		generic.fill(lastName_Txt, "Testing LastName");
		generic.fill(email_Txt, email);
		generic.fill(countryCode_Txt, "+91");
		generic.fill(mobile_Txt, "9999999999");
		generic.select(userType_Dd, userType);
		//	generic.fill(username_Txt, username);
		generic.fill(password_Txt, "qqqqqq");
		generic.select(cluster_Dd, "Bangalore");
		generic.click(cluster_Chk);
		generic.select(role_Dd, role);
		generic.select(active_Dd, "Active");
		generic.click(save_Btn);
		generic.goToSleep(3000);
		positiveViewUser(username,email);
	}

	public void positiveViewUser(String username, String email){
		CustomAssert =new CustomAssert();
		String viewUserID=generic.getText(viewUserID_WE);
		System.out.println(viewUserID);
		String viewUserFirstName=generic.getText(viewUserFirstName_WE);
		System.out.println(viewUserFirstName);
		String viewUserLastName=generic.getText(viewUserLastName_WE);
		String viewUserUsername=generic.getText(viewUserUsername_WE);
		String viewUserEmail=generic.getText(viewUserEmail_WE);
		String viewUserMobile=generic.getText(viewUserMobile_WE);
		CustomAssert.assertEquals(viewUserFirstName,"Testing firstName","First Name does not matches.");
		CustomAssert.assertEquals(viewUserLastName,"Testing LastName","Last Name does not matches.");
		CustomAssert.assertEquals(viewUserUsername,username," Username does not matches.");
		CustomAssert.assertEquals(viewUserEmail,email,"Email does not matches.");
		CustomAssert.assertEquals(viewUserMobile,"9650752666","Mobile Number does not matches.");
		CustomAssert.assertAll();
	}

	public void TestCase_CreateUser(Xls_Reader datatable, String sheetname, int rowNo){
		generic.goToSleep(5000);
		generic.pageScrollToBottomInSlowMotion(10,10);
		generic.click(users_Btn);
		generic.click(createUsers_Btn);
		generic.fill(firstName_Txt, datatable.getCellData(sheetname, "firstName_Txt", rowNo));
		generic.fill(lastName_Txt, datatable.getCellData(sheetname, "lastName_Txt", rowNo));
		email = generic.getEmailasCurrentTimeStamp();
		generic.fill(email_Txt, email);
		datatable.setCellData(sheetname, "email_Txt", rowNo,email);
		generic.fill(countryCode_Txt, datatable.getCellData(sheetname, "countryCode_Txt", rowNo));
		generic.fill(mobile_Txt, datatable.getCellData(sheetname, "mobile_Txt", rowNo));
		generic.select(userType_Dd, datatable.getCellData(sheetname, "userType_Dd", rowNo));
		username = generic.usernameTimeStamp();
		generic.fill(username_Txt, username);
		datatable.setCellData(sheetname, "username_Txt", rowNo, username);
		generic.fill(password_Txt, datatable.getCellData(sheetname, "password_Txt", rowNo));
		generic.select(cluster_Dd, datatable.getCellData(sheetname, "cluster_Dd", rowNo));
		generic.click(cluster_Chk);
		String role=datatable.getCellData(sheetname, "role_Dd", rowNo).trim();
		generic.select(role_Dd,role);
		generic.select(active_Dd, datatable.getCellData(sheetname, "active_Dd", rowNo));
		generic.click(create_Btn);
		generic.goToSleep(3000);
		positiveViewUser(username,email);
	}


	public String captureError(){
		String total_Error="";
		if(driver.findElements(By.xpath(errorMessage_Err)).size()> 0){
			List<WebElement> errors= driver.findElements(By.xpath(errorMessage_Err));
			for(int i=0; i<errors.size(); i++){
				if(errors.get(i).isDisplayed()){
					total_Error= total_Error+", "+errors.get(i).getText();
				}
			}
		}
		return total_Error;
	}

}
