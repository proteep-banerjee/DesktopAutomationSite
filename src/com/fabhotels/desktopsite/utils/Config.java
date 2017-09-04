package com.fabhotels.desktopsite.utils;

import com.fabhotels.automationframework.core.CustomAssert;
import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.platforms.BaseDriver;

public class Config extends BaseDriver{
	public GenericFunctions generic = new GenericFunctions(driver);
	
	public static String Environment = "test2"; //live
	public static String Execution_Type = "System";
	public static String Driver_Type = "FF30"; //Chrome  FF30
	public CustomAssert customAssert = new CustomAssert();

}
