package com.fabhotels.mobilesite.utils;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.platforms.BaseDriver;

public class Config extends BaseDriver{
	public GenericFunctions generic = new GenericFunctions(driver);
	
	public static String TestorLive = "live";
	public static String Execution_Type = "System";
	public static String Driver_Type = "FF30";
	public static String Device_Type = "Android";
	public String emailValidationsSheet="./TestData/emailValidations.xls";
	public String cityNamesImagesSheet="./TestData/cityImagesOnHomepage.xls";
	public String discountNamesImagesSheet="./TestData/discountImagesOnHomepage.xls";
	public String footerLinksSheet="./TestData/footerLinksSheet.xls";
	public String hamburgerMenuLinksSheet="./TestData/breadcrumbMenuItems.xls";
}
