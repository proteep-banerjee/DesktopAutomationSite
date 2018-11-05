package Fab_Application.Utilities;

import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReusableMethods extends DriverHelper {

    public static final int impliciteTimeOut = 2;


    public static void type(WebDriver driver, WebElement element, String value) {

        if (isElementPresent(driver, element)) {
            element.click();
            element.clear();
            element.sendKeys(value);
            System.out.println("Entered Text :" + value);
        } else {
            System.out.println("Not present element:" + element);
        }
    }

    public static void Click(WebDriver driver, WebElement element) {

        if (isElementPresent(driver, element)) {

            element.click();
        } else {
            System.out.println("Not present element:" + element);
        }


    }


    public static boolean verifyText(AndroidDriver driver, WebElement element, String text) {

        if (element.getText().toString().equalsIgnoreCase(text)) {
            softAssert.assertTrue(true, text + " verified");
            softAssert.assertAll();
            return true;
        } else {
            softAssert.assertTrue(false, text + " not verified");
            softAssert.assertAll();
            return false;
        }

    }


    public static void ClickByXpath(AndroidDriver driver, String locator) {


        driver.findElementByXPath(locator).click();

        // else {
        // ((IOSDriver) driver).findElementByXPath(locator).click();
        // }

    }

    /**
     * This method is used to check the specified element is present or not on the page
     *
     * @return true if element is present false if element is not present
     */
    public static boolean isElementPresent(WebDriver driver, WebElement element) {
       // driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        if (element.isDisplayed() || element.isEnabled()) {
            //driver.manage().timeouts().implicitlyWait(impliciteTimeOut, TimeUnit.SECONDS);
            return true;
        } else {
            //driver.manage().timeouts().implicitlyWait(impliciteTimeOut, TimeUnit.SECONDS);
            return false;

        }
    }

    public static void typeByID(AndroidDriver driver, String locator, String value) {

        driver.findElementById(locator).clear();
        driver.findElementById(locator).sendKeys(value);

    }

    public static WebElement FindElement(WebDriver driver, By by) throws IOException {

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        //System.out.println(driver.toString());
        WebElement element = null;

        try{
            element = (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(by));
            return element;
        }catch (NoSuchElementException  | StaleElementReferenceException e){

            System.out.println("Exception occured in finding the element " +e.getMessage());
            return null;
        }
        //WebElement element = driver.findElement(by);
    }



    public static List<WebElement> FindElements(WebDriver driver, By by) {
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        List<WebElement> element = null;

        try {
            element = (new WebDriverWait(driver, 15))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));

            return element;

        } catch (NoSuchElementException | StaleElementReferenceException e) {

            System.out.println("Exception occured in finding the element " + e.getMessage());
            return null;


        }
        //WebElement element = driver.findElement(by);

    }


    public static void typeByXpath(AndroidDriver driver, String locator, String value) {

        driver.findElementByXPath(locator).clear();
        driver.findElementByXPath(locator).sendKeys(value);
        // else {
        // ((IOSDriver) driver).findElementByXPath(locator).clear();
        // ((IOSDriver) driver).findElementByXPath(locator).sendKeys(value);
        // }
    }

    /**
     * @param element
     * @param value1
     */
    public static void dropBoxText(AndroidDriver driver, WebElement element, String value1) {

        Select dropdownGroup = new Select(element);

        dropdownGroup.selectByVisibleText(value1);

    }

    public static String getTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date now = new Date();
        String strDate = sdf.format(now);
        return strDate;
    }

    static public void hideSoftKeyboard(AndroidDriver driver) {
        try {
            driver.hideKeyboard();
            System.out.println("hided keyboard successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tearDown(AndroidDriver driver) {
        driver.quit();

    }

    public static void scrollUp(AndroidDriver driver, MobileElement scroll, String text) {
        try {
            JavascriptExecutor js = driver;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", "up");
            scrollObject.put("text", text);
            scrollObject.put("element", scroll.getId());
            js.executeScript("mobile: scrollTo", scrollObject);
        } catch (Exception localException) {
        }
    }


    public static String captureScreenShot(WebDriver driver) throws IOException {
        String newDate = null;
        Date startTime = null;
        startTime = new Date();

        SimpleDateFormat oDateFormat = new SimpleDateFormat("dd_MM_YY");
        newDate = oDateFormat.format(startTime);


        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // now copy the  screenshot to desired location using copyFile method

        File rest = new File(System.getProperty("user.dir") + "/screenshots/" + File.separator + newDate + System.currentTimeMillis() + ".png");

        FileUtils.copyFile(src, rest);
        String destination = rest.toString();
        return destination;

    }


    public static void scrollDown(AndroidDriver driver, String text) {
        try {
            JavascriptExecutor js = driver;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", "down");
            scrollObject.put("text", text);
            // scrollObject.put("element", ((RemoteWebElement) scroll).getId());
            js.executeScript("mobile: scrollTo", scrollObject);
        } catch (Exception localException) {
        }
    }


    public static boolean isPresentOnPage(WebDriver driver, By by) {

        WebElement we = null;

        WebDriverWait wait = new WebDriverWait(driver,
                30);

        we = wait.until(ExpectedConditions
                .visibilityOfElementLocated(by));

        we = driver.findElement(by);

        if (we.isDisplayed() || we.isEnabled()) {

            System.out.println("Element Exist");
            return true;
        } else {
            System.out.println("Element doesn't Exist");
            return false;
        }

    }

    public static boolean isPresentOnPageAppiumID(AndroidDriver driver, String locator) {

        WebElement we = null;

        WebDriverWait wait = new WebDriverWait(driver,
                30);

        we = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id(locator)));

        we = driver.findElementById(locator);

        if (we.isDisplayed() || we.isEnabled()) {

            System.out.println("Element Exist" + locator);
            return true;
        } else {
            System.out.println("Element doesn't Exist" + locator);
            return false;
        }


    }


    public static void wait(AndroidDriver driver, long num, TimeUnit unit) {
        driver.manage().timeouts().implicitlyWait(num, unit);
    }

    public void waitForLoadView(AndroidDriver driver, long num, TimeUnit unit) {
        driver.manage().timeouts().pageLoadTimeout(num, unit);
    }

    public boolean waitForElementVisible(AndroidDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)) != null;

    }

    public boolean waitForElementclickable(AndroidDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 250);

        return wait.until(ExpectedConditions.elementToBeClickable(locator)) != null;
    }


    public static void sleep(long millis) {


        try {

            Thread.sleep(millis);

        } catch (InterruptedException ex) {
            System.out.println("Sleep interrupted :: " + ex.getMessage());

        }

    }

    public static void longPressAppium(AndroidDriver driver, String locator) {

        MobileElement element = (MobileElement) driver.findElementById(locator);

        TouchAction action = new TouchAction(driver);

        action.longPress(element).release().perform();

    }


    public static void elementClick(AndroidDriver driver, By locator1, By locator2, int value) {


        WebElement element = driver.findElement(locator1);
        List<WebElement> elements = element.findElements(locator2);
        int sizeGrid = elements.size();

        Reporter.log(sizeGrid + "<<<<<<<<<size of grid value>>>>>>>");

        Point point = elements.get(value).getLocation();

        Dimension size = elements.get(value).getSize();

        int elementX = point.getX() + Math.round(size.getWidth() / 2);

        int elementY = point.getY() + Math.round(size.getHeight() / 2);

        int elementX1 = elementX + 100;

        int elementY1 = elementY + 150;

        TouchAction action = new TouchAction(driver);

        action.longPress(elementX1, elementY1).release().perform();
    }

    public static boolean verifyTrue(boolean condition, String SuccessMessage,
                                     String FailureMessage) {

        if (condition) {
            //Reporter.log(SuccessMessage, MessageType.PASS);
            return true;
        } else {
            throw new AssertionError("Assertion Error");
        }
    }

    public static boolean verifyFalse(boolean condition, String SuccessMessage,
                                      String FailureMessage) {
        if (!condition) {
            //Reporter.log(SuccessMessage, MessageType.PASS);
            return true;
        } else {
            throw new AssertionError("Assertion Error");
            //Reporter.log(FailureMessage, MessageType.FAIL);

        }
    }

    public static void assertTrue(boolean condition, String SuccessMessage,
                                  String FailureMessage) {
        if (condition) {
            // Reporter.log(SuccessMessage, MessageType.PASS, true);
        } else {
            //Reporter.log(FailureMessage, MessageType.FAIL, true);
            throw new AssertionError("Assertion Error");
        }
    }

    public static void assertFalse(boolean condition, String SuccessMessage,
                                   String FailureMessage) {
        if (!condition) {
            // Reporter.log(SuccessMessage, MessageType.PASS, true);
        } else {
            // Reporter.log(FailureMessage, MessageType.FAIL, true);
            throw new AssertionError("Assertion Error");
        }
    }


    public static void dummyScroll_up(AndroidDriver driver, int swipeUP) {


        Dimension dimensions = driver.manage().window().getSize();
        Double screenHeightStart = dimensions.getHeight() * 0.5;
        int scrollStart = screenHeightStart.intValue();
        System.out.println("sstart=" + scrollStart);
        Double screenHeightEnd = dimensions.getHeight() * 0.2;
        int scrollEnd = screenHeightEnd.intValue();
        System.out.println("send=" + scrollEnd);

        System.out.println("get height" + dimensions.getHeight());

        for (int i = 0; i < swipeUP; i++)

        {
            driver.swipe(0, scrollStart, 0, scrollEnd, 2000);

            //Dimension dimensions2 = driver.findElement(By.id("com.ocbc.mobile:id/tv_card_exchange_exchange_rate")).getSize();
            //int l=dimensions2.getHeight();
            //if(l>0)
            //	{
            //		break;
            //	}

            //Dimension dimensions2=	driver.findElement(By.name("YourText")).getSize();
            //break;

        }
    }

    public static void dummyScroll_down(AndroidDriver driver, int swipeDown) {


        Dimension dimensions = driver.manage().window().getSize();
        Double screenHeightStart = dimensions.getHeight() * 0.5;
        int scrollStart = screenHeightStart.intValue();
        System.out.println("sstart=" + scrollStart);
        Double screenHeightEnd = dimensions.getHeight() * 0.2;
        int scrollEnd = screenHeightEnd.intValue();
        System.out.println("send=" + scrollEnd);

        System.out.println("get height" + dimensions.getHeight());

        for (int i = 0; i < swipeDown; i++)

        {
            driver.swipe(0, scrollEnd, 0, scrollStart, 2000);

            //Dimension dimensions2 = driver.findElement(By.id("com.ocbc.mobile:id/tv_card_exchange_exchange_rate")).getSize();
            //int l=dimensions2.getHeight();
            //if(l>0)
            //	{
            //		break;
            //	}

            //Dimension dimensions2=	driver.findElement(By.name("YourText")).getSize();
            //break;

        }


    }

    public static String getDeviceName() throws Exception {
        String command = "adb devices";
        //System.out.println(command);
        String output = runCommand(command); //run command on terminal
        //System.out.println(output);
        String spitter[] = output.split("\t");
        //System.out.println(spitter[0]);
        return spitter[0];

    }

    // This function will run command on terminal
    public static String runCommand(String command) throws IOException {
        Process p = Runtime.getRuntime().exec(command);

        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        String allLine = "";
        while ((line = r.readLine()) != null) {
            allLine = allLine + "" + line + " ";
            /*if (line.contains("device")) break*/
            ;
        }

        String spitter[] = allLine.split(" ");
        return spitter[4];
    }

}
