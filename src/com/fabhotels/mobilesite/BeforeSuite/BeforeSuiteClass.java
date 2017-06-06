package com.fabhotels.mobilesite.BeforeSuite;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import com.fabhotels.mobilesite.utils.Config;

public class BeforeSuiteClass extends Config{
	
	@BeforeSuite
	public void Initialize_ConfigVariables(){
		try {
			FileInputStream input = new FileInputStream("Config.properties");
			Properties	prop = new Properties();
			prop.load(input);

			TestorLive = prop.getProperty("Environment");
			System.out.println(TestorLive);

			String driver = prop.getProperty("Driver_Type");	
			Driver_Type = driver.split("_")[0];
			Device_Type = driver.split("_")[1];
			
			System.out.println(Driver_Type);
			System.out.println(Device_Type);

			Execution_Type = prop.getProperty("Execution_Type");
			System.out.println(Execution_Type);
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
