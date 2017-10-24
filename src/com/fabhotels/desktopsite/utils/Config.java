package com.fabhotels.desktopsite.utils;

import com.fabhotels.automationframework.core.CustomAssert;
import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.platforms.BaseDriver;

public class Config extends BaseDriver {
	public static String Environment = "live"; // live//test2
	public static String Execution_Type = "System";
	public static String Driver_Type = "FF30"; // Chrome FF30
	public GenericFunctions generic;
	public CustomAssert customAssert;

}