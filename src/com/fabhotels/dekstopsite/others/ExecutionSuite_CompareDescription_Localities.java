package com.fabhotels.dekstopsite.others;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.fabhotels.desktopsite.utils.Config;

public class ExecutionSuite_CompareDescription_Localities extends Config {
	
	@BeforeTest
	public void beforeTest() {
		driver = generic.startDriver(Driver_Type);
		generic.maximize();
	}
	
	 @DataProvider(name = "TC_Compare_Localities")
		public Object[][] DataProvider_Footer() {
			Object result[][] = new Object[19][1];
			result[0][0] = "New Delhi";
			result[1][0] = "Bangalore";
			result[2][0] = "Mumbai";
			result[3][0] = "Amritsar";
			result[4][0] = "Chennai";
			result[5][0] = "Goa";
			result[6][0] = "Gurgaon";
			result[7][0] = "Hyderabad";
			result[8][0] = "Ooty";
			result[9][0] = "Jaipur";
			result[10][0] = "Noida";
			result[11][0] = "Kolkata";
			result[12][0] = "Pondicherry";
			result[13][0] = "Pune";
			result[14][0] = "Udaipur";
			result[15][0] = "Mysore";
			result[16][0] = "Ahmedabad";
			result[17][0] = "Indore";
			result[18][0] = "Coimbatore";

			return result;
		}
	
	
}
