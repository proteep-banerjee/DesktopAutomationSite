package com.fabhotels.dashboard.pageobjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class Auditors {

	WebDriver driver;
	GenericFunctions generic;
	SoftAssert SoftAssert;


	public Auditors(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;		
	}

	public static String createAuditors_Btn = "//a[text()='Create Auditors']";
	public static String updateAuditors_Btn = "//a[text()='Update Auditors']";
	public static String manageAuditors_Btn = "//a[text()='Manage Auditors']";

	public static String firstName_Txt = "//input[@id='Users_first_name']";
	public static String lastName_Txt = "//input[@id='Users_last_name']";
	public static String email_Txt = "//input[@id='Users_email']";
	public static String mobile_Txt = "//input[@id='Users_mobile']";
	public static String username_Txt = "//input[@id='Users_username']";
	public static String password_Txt = "//input[@id='Users_password']";
	public static String status_DD = "//select[@id='Users_status']";
	public static String create_Btn = "//input[@value='Create']";
	public static String save_Btn = "//input[@value='Save']";

	public static String email;
	public static String username;

	public String viewAuditorFirstName_WE = "(//table[@id='yw0']//td)[1]";
	public String viewAuditorLastName_WE = "(//table[@id='yw0']//td)[2]";
	public String viewAuditorEmail_WE = "(//table[@id='yw0']//td)[3]";
	public String viewAuditorMobile_WE = "(//table[@id='yw0']//td)[4]";
	public String viewAuditorUsername_WE = "(//table[@id='yw0']//td)[5]";
	public String viewAuditorStatus_WE = "(//table[@id='yw0']//td)[6]";

	public String searchAuditorfirstName_Txt="(//input[@name='Users[first_name]'])[1]";
	public String searchAuditorlastName_Txt="(//input[@name='Users[last_name]'])[1]";
	public String searchAuditorusername_Txt="(//input[@name='Users[username]'])[1]";
	public String searchAuditoremail_Txt="(//input[@name='Users[email]'])[1]";
	public String searchAuditormobile_Txt="(//input[@name='Users[mobile]'])[1]";
	public String searchAuditorupdate_Btn="(//img[@alt='Update'])[1]";
	
	
	public void clickcreateAuditors_Btn(){
		generic.click(createAuditors_Btn);
	}

	public void clickUpdateAuditors_Btn(){
		generic.click(updateAuditors_Btn);
	}

	public void clickManageAuditors_Btn(){
		generic.click(manageAuditors_Btn);
	}
	
	public void searchAuditorByUsername(){
		generic.fill(searchAuditorusername_Txt, username);
		generic.enter(searchAuditorusername_Txt);
		generic.goToSleep(5000);
		generic.click(searchAuditorupdate_Btn);
	}


	public void createPositiveAuditors(){
		email = "auditor"+generic.getEmailasCurrentTimeStamp();
		username = "auditor"+generic.usernameTimeStamp();
		generic.click(createAuditors_Btn);
		generic.goToSleep(2000);
		generic.fill(firstName_Txt, "Testing Firstname Auditor");
		generic.fill(lastName_Txt, "Testing LastName Auditor");
		generic.fill(email_Txt, email);
		generic.fill(mobile_Txt, "9650752666");
		generic.fill(username_Txt, username);
		generic.fill(password_Txt, "aaaaaa");
		generic.select(status_DD, "");  //Active by default
		generic.click(create_Btn);
		positiveCreateViewAuditor(username,email);
	}
	public void positiveCreateViewAuditor(String username, String email){
		SoftAssert =new SoftAssert();
		String viewAuditorFirstName=generic.getText(viewAuditorFirstName_WE);
		String viewAuditorLastName=generic.getText(viewAuditorLastName_WE);
		String viewAuditorEmail=generic.getText(viewAuditorEmail_WE);
		String viewAuditorMobile=generic.getText(viewAuditorMobile_WE);
		String viewAuditorUsername=generic.getText(viewAuditorUsername_WE);
		String viewAuditorStatus=generic.getText(viewAuditorStatus_WE);
		SoftAssert.assertEquals(viewAuditorFirstName,"Testing Firstname Auditor","First Name does not matches.");
		SoftAssert.assertEquals(viewAuditorLastName,"Testing LastName Auditor","Last Name does not matches.");
		SoftAssert.assertEquals(viewAuditorEmail,email,"Email does not matches.");
		SoftAssert.assertEquals(viewAuditorMobile,"9650752666","Mobile Number does not matches.");
		SoftAssert.assertEquals(viewAuditorUsername,username," Username does not matches.");
		SoftAssert.assertEquals(viewAuditorStatus,"Active"," Active does not matches.");
		SoftAssert.assertAll();
	}

	//update and manage
	public void modifyPositiveAuditors(){
		generic.fill(firstName_Txt, "Modify Testing firstname Auditor");
		generic.fill(lastName_Txt, "Modify Testing lastname Auditor");
		generic.fill(email_Txt, email);
		generic.fill(mobile_Txt, "09650752666");
		generic.fill(password_Txt, "aaaaaa");
		generic.select(status_DD, "Inactive");  //Active by default
		generic.click(save_Btn);
		positiveModifyViewAuditor(username,email);
	}
	public void positiveModifyViewAuditor(String username, String email){
		System.out.println("username : "+username);
		SoftAssert =new SoftAssert();
		String viewAuditorFirstName=generic.getText(viewAuditorFirstName_WE);
		String viewAuditorLastName=generic.getText(viewAuditorLastName_WE);
		String viewAuditorEmail=generic.getText(viewAuditorEmail_WE);
		String viewAuditorMobile=generic.getText(viewAuditorMobile_WE);
		String viewAuditorUsername=generic.getText(viewAuditorUsername_WE);
		String viewAuditorStatus=generic.getText(viewAuditorStatus_WE);
		SoftAssert.assertEquals(viewAuditorFirstName,"Modify Testing firstname Auditor","First Name does not matches.");
		SoftAssert.assertEquals(viewAuditorLastName,"Modify Testing lastname Auditor","Last Name does not matches.");
		SoftAssert.assertEquals(viewAuditorEmail,email,"Email does not matches.");
		SoftAssert.assertEquals(viewAuditorMobile,"09650752666","Mobile Number does not matches.");
		SoftAssert.assertEquals(viewAuditorUsername,username," Username does not matches.");
		SoftAssert.assertEquals(viewAuditorStatus,"Inactive"," Active does not matches.");
		SoftAssert.assertAll();
	}

}
