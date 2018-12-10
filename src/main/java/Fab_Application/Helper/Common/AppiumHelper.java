package Fab_Application.Helper.Common;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.logging.LogEntry;
import org.apache.commons.exec.CommandLine;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

public class AppiumHelper {


    public static String dest;
    public static File rest;

    public static void startServer() {

        CommandLine command = new CommandLine(
                "/Applications/Appium.app/Contents/Resources/node/bin/node");
        command.addArgument(
                "/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js",
                false);
        command.addArgument("--address");
        command.addArgument("127.0.0.1");
        command.addArgument("--port");
        command.addArgument("4723");
        command.addArgument("--no-reset", false);
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);
        try {
            executor.execute(command, resultHandler);
            Thread.sleep(50000);
            System.out.println("Appium server started.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
/*if (resultHandler==null) {
    ReportHelper.logValidationFailure("Appium not started", "starting appium at node server 4723","", "HTTP status check failure");
    Reporter.log("Appium " + resultHandler..getStatusCode() + " & Response Message -" + response.asString());
}*/

    }

    public static void stopServer() {
        String[] command = {"/usr/bin/killall", "-KILL", "node"};
        try {
            Runtime.getRuntime().exec(command);
            System.out.println("Appium server stopped.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @SuppressWarnings({"resource", "rawtypes"})
    public static void captureLog(AndroidDriver driver, String testName)
            throws Exception {
        DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH-mm-ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        String logPath = System.getProperty("user.dir") + "/AppiumLogs/";
        System.out.println(driver.getSessionId() + ": Saving device log...");
        List<LogEntry> logEntries = driver.manage().logs().get("logcat").filter(Level.ALL);
        File logFile = new File(logPath + reportDate + "_" + testName + ".txt");
        PrintWriter log_file_writer = new PrintWriter(logFile);
        log_file_writer.println(logEntries);
        log_file_writer.flush();
        System.out.println(driver.getSessionId() + ": Saving device log - Done.");
    }


    public static String captureScreen(AndroidDriver driver) {

        File src = driver.getScreenshotAs(OutputType.FILE);
        try {
            // now copy the  screenshot to desired location using copyFile method

            rest = new File(System.getProperty("user.dir") + "/screenshots/" + new SimpleDateFormat("dd_MM_yyyy_HH-mm-ss") + ".png");

            FileUtils.copyFile(src, rest);
            dest = rest.toString();
            System.out.println(dest);
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
        return dest;
    }
}
