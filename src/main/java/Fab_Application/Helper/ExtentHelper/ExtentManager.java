package Fab_Application.Helper.ExtentHelper;

import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.time.LocalDate;
import java.util.Locale;

public class ExtentManager {

    public static ExtentReports extent;
    public static String SuiteName;

    //	This method returns the name of the report to be set.
    public static String ReportName(){
        LocalDate d = LocalDate.now();
        String date = d.toString();
        return "Test Automation Report "+date+".html";
    }

    //	This method sets up the extent report for tests and loads the extent config file.
    public static ExtentReports startReport(){
        Locale.setDefault(Locale.ENGLISH);
        extent = new ExtentReports(System.getProperty("user.dir")+"/Results/"+ReportName(),true);
        extent.addSystemInfo("Browser",DriverHelper.getValueOfProperty(DriverHelper.CONFIGURATION_FILE_PATH, "browserName"));
        extent.addSystemInfo("Environment", DriverHelper.getValueOfProperty(DriverHelper.CONFIGURATION_FILE_PATH, "environment"));
        extent.addSystemInfo("OS", DriverHelper.getValueOfProperty(DriverHelper.CONFIGURATION_FILE_PATH, "OS"));
        extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
        return extent;
    }

    //	This method ends the report when all the tests have been finished.
    public static void endReport(){
        extent.flush();
        //extent.close();
    }
}
