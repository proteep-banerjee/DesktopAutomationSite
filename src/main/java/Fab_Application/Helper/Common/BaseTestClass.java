package Fab_Application.Helper.Common;

import com.mongodb.MongoClient;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

import static java.lang.System.getProperty;

public class BaseTestClass {

    public static Connection connection = null;
    public static MongoClient mongoClient = null;
    public Process p;
    public static ExtentReports extent;
    public static ExtentTest logger;

    public static Process process;

    WebDriver driver = null;

    public BaseTestClass() {
    }

    @BeforeSuite(alwaysRun = true)
    public void setEnvironment() throws Exception {
        startReport();
        //startAppium();
    }

    @AfterSuite(alwaysRun = true)
    public void closeEnvironment() throws Exception {
        stopAppiumServer();
        //extent.flush();
        extent.close();
    }

    @AfterMethod
    public void getResult(ITestResult result) {

        if (result == null) {
            result.setStatus(ITestResult.FAILURE);

        }

        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());

            logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, "Test Case Passed is " + result.getName());
        }

        extent.flush();
        extent.endTest(logger);


    }


    public void startAppium() throws Exception {
        String port = "4723";
        String command = "appium --session-override -p " + port;
        System.out.println(command);
        String output = runCommand(command); //run command on terminal
        System.out.println(output);
    }

    // This function will run command on terminal
    public String runCommand(String command) throws IOException {
        p = Runtime.getRuntime().exec(command);
        System.out.println(p.toString());
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line = "";
        String allLine = "";
        while ((line = r.readLine()) != null) {
            allLine = allLine + "" + line + "\n";
            if (line.contains("started on")) break;
        }
        return allLine;
    }


    public void stopAppiumServer() throws IOException, InterruptedException {

        //out.println(p.getInputStream().read());
        if (p != null) {
            p.destroy();
            System.out.println("Killing appium");
        }
        Thread.sleep(2000);
    }

    public void startReport() {
        extent = new ExtentReports(getProperty("user.dir") + "/Results/" + "AutomationReport_" + java.time.LocalDate.now() + ".html", true);
        //System.out.println(getProperty("user.name"));
        extent
                .addSystemInfo("Host Name", "FabHotels Mweb")
                .addSystemInfo("Environment", "chrome desktop")
                .addSystemInfo("User Name", getProperty("user.name"));
        extent.loadConfig(new File(getProperty("user.dir") + "/extent-config.xml"));
    }
}
