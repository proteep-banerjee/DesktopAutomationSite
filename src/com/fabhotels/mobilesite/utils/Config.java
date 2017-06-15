package com.fabhotels.mobilesite.utils;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.platforms.BaseDriver;

public class Config extends BaseDriver{
	public GenericFunctions generic = new GenericFunctions(driver);
	
	public static String TestorLive = "preprod";
	public static String Execution_Type = "System";
	public static String Driver_Type = "MobileChrome";  //MobileChrome //FF30
	public static String Device_Type = "Google Nexus 5";  //Google Nexus 5  //Android
	
}
