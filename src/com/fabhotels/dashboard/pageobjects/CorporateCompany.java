package com.fabhotels.dashboard.pageobjects;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class CorporateCompany {

	WebDriver driver;
	GenericFunctions generic;
	SoftAssert SoftAssert=new SoftAssert();
	Users Users=new Users(driver,generic);


	public CorporateCompany(WebDriver driver,GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;		
	}
	
	public String createCoporate_Btn = "//a[text()='Create Corporates']";
	public String assignCoporate_Btn = "//a[text()='Assign Corporates']";
	//input[@id='Corporates_company_name']
	public String companyName_Txt = "//input[@id='Corporates_company_name']";
	public String brandName_Txt = "//input[@id='Corporates_brand_name']";
	public String companyAddress_Txt = "//input[@id='Corporates_company_address']";
	public String remarks_Txt = "//input[@id='Corporates_remarks']";
	public String bookingSourceCompany_DD = "//select[@id='Corporates_active_status']";
	public String paymentMethodCompany_DD = "//select[@id='Corporates_btc_enabled']";
	public String create_Btn = "//input[@value='Create']";
	public String update_Btn = "//input[@value='Update']";
	
	public String corporateId_Txt = "//input[@name='Corporates[id]']";
	public String corporateCompanyName_Txt = "//input[@name='Corporates[company_name]']";
	public String corporateBrandName_Txt = "//input[@name='Corporates[brand_name]']";
	public String corporateCompanyAddress_Txt = "//input[@name='Corporates[company_address]']";
	public String corporateRemarks_Txt = "//input[@name='Corporates[remarks]']";
	public String corporateUpdate_Btn = "(//img[@alt='Update'])[1]";
	
	public String corporateAssignCompany_Dd = "//select[@id='SalesCorporateMapping_company_id']";
	public String corporateAssignSalesPerson_Dd = "//select[@id='SalesCorporateMapping_sales_person_id']";
	public String corporateAssignActive_Dd = "//select[@id='SalesCorporateMapping_active_status']";
	public String corporateAssignCreate_Btn = "//input[@value='Create']";
	
	public String manageSalesCorporateMapping_Btn ="//a[text()='Manage SalesCorporateMapping']";
	public String createSalesCorporateMapping_Btn ="//a[text()='Create SalesCorporateMapping']";

	
	public String viewCorporateID_WE = "(//table[@id='yw0']//td)[1]";
	public String viewCorporateCompanyName_WE = "(//table[@id='yw0']//td)[2]";
	public String viewCorporateCompanyAddress_WE = "(//table[@id='yw0']//td)[3]";
	public String viewCorporateBookingSource_WE = "(//table[@id='yw0']//td)[4]";
	public String viewCorporatePaymentMethod_WE = "(//table[@id='yw0']//td)[5]";
	public String viewCorporateRemarks_WE = "(//table[@id='yw0']//td)[6]";
	public String viewCorporateCreatedAt_WE = "(//table[@id='yw0']//td)[7]";
	public String viewCorporateUpdatedAt_WE = "(//table[@id='yw0']//td)[8]";
	
	public String createCorporate_Btn ="//a[text()='Create Corporates']";
	public String updateCorporate_Btn ="//a[text()='Update Corporates']";
	public String manageCorporate_Btn ="//a[text()='Manage Corporates']";
	public String assignCorporate_Btn ="//a[text()='Assign Corporates']";


	public static String coporateName; //="corporateCompany"; //+generic.usernameTimeStamp();
	
	public void createCorporate_Btn(){
		generic.click(createCoporate_Btn);
	}
	
	public void positiveCreateNewCorporate(){
		coporateName="corporateCompany"+generic.usernameTimeStamp();
		System.out.println("coporateName : "+coporateName);
		generic.fill(companyName_Txt, coporateName);
		generic.fill(brandName_Txt, "Login Brand Name");
		generic.fill(companyAddress_Txt, "Login Company Address");
		generic.fill(remarks_Txt, "Login Remarks");
		generic.select(bookingSourceCompany_DD, "Inactive");  //Active
		generic.select(paymentMethodCompany_DD, "");  //Inactive
		generic.click(create_Btn);
	}
	
	public void positiveUpdateNewCorporate(){
		generic.fill(companyName_Txt, coporateName);
		generic.fill(brandName_Txt, "Login Brand Name");
		generic.fill(companyAddress_Txt, "Login Company Address");
		generic.fill(remarks_Txt, "Login Remarks");
		generic.select(bookingSourceCompany_DD, "Active");  //Active
		generic.select(paymentMethodCompany_DD, "Active");  //Inactive
		generic.click(update_Btn);
	}
	
	public void positiveAssignNewCorporate(){
		generic.select(corporateAssignCompany_Dd, coporateName);
		System.out.println(" Users.username "+ Users.username.toLowerCase());
		generic.select(corporateAssignSalesPerson_Dd, Users.username.toLowerCase());
		generic.select(corporateAssignActive_Dd, "Active"); //Active default
		generic.click(corporateAssignCreate_Btn);
	}
	
	public void positiveAssignCorporate(){
		generic.fill(corporateAssignCompany_Dd, "corporateSankalpLogin");
		generic.fill(corporateAssignSalesPerson_Dd, "sankalpsale");
		generic.fill(corporateAssignActive_Dd, "Active"); //Active default
		generic.click(corporateAssignCreate_Btn);
	}
	
	public void updateCorporate_Btn(){
		generic.click(updateCorporate_Btn);
	}
	public void manageCorporate_Btn(){
		generic.click(manageCorporate_Btn);
	}
	public void assignCorporate_Btn(){
		generic.click(assignCorporate_Btn);
	}
	
	public void positiveSearchCorporate(){
		generic.fill(corporateId_Txt, "");
		generic.fill(corporateCompanyName_Txt, coporateName);
		generic.fill(corporateBrandName_Txt, "Login Brand Name");
		generic.fill(corporateCompanyAddress_Txt, "Login Company Address");
		generic.fill(corporateRemarks_Txt, "Login Remarks");
		generic.click(corporateUpdate_Btn);
	}
	
	
	public void positiveViewNewCorporateCreated(){
		String viewOwnerID=generic.getText(viewCorporateID_WE);
		System.out.println(viewOwnerID);
		String viewCorporateCompanyName=generic.getText(viewCorporateCompanyName_WE);
		String viewCorporateCompanyAddress=generic.getText(viewCorporateCompanyAddress_WE);
		String viewCorporateBookingSource=generic.getText(viewCorporateBookingSource_WE);
		String viewCorporatePaymentMethod=generic.getText(viewCorporatePaymentMethod_WE);
		String viewCorporateRemarks=generic.getText(viewCorporateRemarks_WE);
		SoftAssert.assertEquals(viewCorporateCompanyName,coporateName,"viewCorporateCompanyName does not matches.");
		SoftAssert.assertEquals(viewCorporateCompanyAddress,"Login Company Address","viewCorporateCompanyAddress does not matches.");
		SoftAssert.assertEquals(viewCorporateBookingSource,"Inactive","viewCorporateBookingSource does not matches.");
		SoftAssert.assertEquals(viewCorporatePaymentMethod,"Inactive","viewCorporatePaymentMethod does not matches.");
		SoftAssert.assertEquals(viewCorporateRemarks,"Login Remarks","viewCorporateRemarks does not matches.");
		SoftAssert.assertAll();
	}

	public void positiveViewNewCorporateUpdated(){
		String viewOwnerID=generic.getText(viewCorporateID_WE);
		System.out.println(viewOwnerID);
		String viewCorporateCompanyName=generic.getText(viewCorporateCompanyName_WE);
		String viewCorporateCompanyAddress=generic.getText(viewCorporateCompanyAddress_WE);
		String viewCorporateBookingSource=generic.getText(viewCorporateBookingSource_WE);
		String viewCorporatePaymentMethod=generic.getText(viewCorporatePaymentMethod_WE);
		String viewCorporateRemarks=generic.getText(viewCorporateRemarks_WE);
		SoftAssert.assertEquals(viewCorporateCompanyName,coporateName,"viewCorporateCompanyName does not matches.");
		SoftAssert.assertEquals(viewCorporateCompanyAddress,"Login Company Address","viewCorporateCompanyAddress does not matches.");
		SoftAssert.assertEquals(viewCorporateBookingSource,"Inactive","viewCorporateBookingSource does not matches.");
		SoftAssert.assertEquals(viewCorporatePaymentMethod,"Active","viewCorporatePaymentMethod does not matches.");
		SoftAssert.assertEquals(viewCorporateRemarks,"Login Remarks","viewCorporateRemarks does not matches.");
		SoftAssert.assertAll();
	}

	
	
}
