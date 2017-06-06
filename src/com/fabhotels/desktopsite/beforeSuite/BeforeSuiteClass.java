package com.fabhotels.desktopsite.beforeSuite;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import com.fabhotels.desktopsite.utils.Config;

public class BeforeSuiteClass extends Config {

	@BeforeSuite
	public void Initialize_ConfigVariables() {
		try {
			FileInputStream input = new FileInputStream("./config.properties");
			Properties prop = new Properties();
			prop.load(input);

			Environment = prop.getProperty("Environment");
			System.out.println(Environment);

			Driver_Type = prop.getProperty("Driver_Type");
			System.out.println(Driver_Type);

			Execution_Type = prop.getProperty("Execution_Type");
			System.out.println(Execution_Type);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
