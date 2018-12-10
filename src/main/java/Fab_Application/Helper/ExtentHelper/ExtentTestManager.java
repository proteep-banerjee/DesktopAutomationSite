package Fab_Application.Helper.ExtentHelper;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    @SuppressWarnings("rawtypes")
    static Map extentTestMap = new HashMap();
    static ExtentReports test = ExtentManager.startReport();

    public static synchronized ExtentTest getTest(){
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized void endTest(){
        test.endTest((ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }

    public static synchronized ExtentTest startTest(String testName) {
        return startTest(testName, "");
    }

    @SuppressWarnings("unchecked")
    public static synchronized ExtentTest startTest(String testName, String desc){
        ExtentTest Test1 = test.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), Test1);
        return Test1;
    }
}
