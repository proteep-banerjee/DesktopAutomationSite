package Fab_Application.Utilities;

import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

import static Fab_Application.Controller.POM.ReviewPage.Review_POM.PayAtHotel;
import static Fab_Application.Helper.Common.BaseTestClass.logger;

public class ReusableMethods extends DriverHelper {

    public static final int impliciteTimeOut = 2;


    // Method to enter the text into a web element
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

    // Method to enter the int text into a web element
    public static void enterValue(WebDriver driver, WebElement element, String value) {

        if (isElementPresent(driver, element)) {
            element.click();

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].value='" + value + "';", element);

            System.out.println(element.getTagName());
            System.out.println("Entered Text :" + value);
        } else {
            System.out.println("Not present element:" + element);
        }
    }
    
    public static void sendKeys(WebDriver driver, WebElement element) {

        if (isElementPresent(driver, element)) {
            element.click();

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        } else {
            System.out.println("Not present element:" + element);
        }
    }

    // Method to click on the webelement
    public static void Click(WebDriver driver, WebElement element) {

        if (isElementPresent(driver, element)) {

            element.click();
        } else {
            System.out.println("Not present element:" + element);
            softAssert.assertTrue(false);
        }


    }


    public static boolean verifyText(WebDriver driver, WebElement element, String text) {

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


    public static void ClickByXpath(WebDriver driver, String locator) {


        driver.findElement(By.xpath(locator)).click();

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


    public static void typeByID(WebDriver driver, String locator, String value) {

        driver.findElement(By.id(locator)).clear();
        driver.findElement(By.id(locator)).sendKeys(value);

    }

    // Method to find a single element
    public static WebElement FindElement(WebDriver driver, By by,
                                         ExtentTest logger) throws IOException {

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        WebElement element = null;

        try {
            element = (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(by));
            logger.log(LogStatus.INFO, "Found the element : " + element);
            return element;
        } catch (NoSuchElementException | StaleElementReferenceException e) {

            String img = captureScreenShot(driver);
            System.out.println("Exception occured in finding the element " + e.getMessage());
            logger.log(LogStatus.ERROR, "Unable to locate element : " +
                    element + "<br>" + "Exception : " + "<br>" + e.getMessage());
            logger.addScreenCapture(img);
            return null;
        }
    }

    // Method to find the list of elements and return the same
    public static List<WebElement> FindElements(WebDriver driver, By by,
                                                ExtentTest logger) throws IOException {
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        List<WebElement> elements = null;

        try {
            elements = (new WebDriverWait(driver, 15))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
            logger.log(LogStatus.INFO, "Found the list of elements : " + elements);

            return elements;

        } catch (NoSuchElementException | StaleElementReferenceException e) {

            String img = captureScreenShot(driver);
            System.out.println("Exception occured in finding the element " + e.getMessage());
            logger.log(LogStatus.ERROR, "Unable to locate element : " +
                    elements + "<br>" + "Exception : " + "<br>" + e.getMessage());
            logger.addScreenCapture(img);
            return null;

        }

    }

    public static void typeByXpath(WebDriver driver, String locator, String value) {

        driver.findElement(By.xpath(locator)).clear();
        driver.findElement(By.xpath(locator)).sendKeys(value);
        // else {
        // ((IOSDriver) driver).findElementByXPath(locator).clear();
        // ((IOSDriver) driver).findElementByXPath(locator).sendKeys(value);
        // }
    }

    /**
     * @param element
     * @param value1
     */
    public static void dropBoxText(WebDriver driver, WebElement element, String value1) {

        Select dropdownGroup = new Select(element);

        dropdownGroup.selectByVisibleText(value1);

    }

    public static String getTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date now = new Date();
        String strDate = sdf.format(now);
        return strDate;
    }


    public static void tearDown(WebDriver driver) {
        driver.quit();
    }

    public static void scrollUp(WebDriver driver, MobileElement scroll, String text) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
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

        File rest = new File(System.getProperty("user.dir") + "/Screenshots/" + File.separator + newDate + System.currentTimeMillis() + ".png");

        FileUtils.copyFile(src, rest);
        String destination = rest.toString();
        return destination;

    }


    public static void scrollDown(WebDriver driver, String text) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            //JavascriptExecutor js = driver;
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


    public static void wait(WebDriver driver, long num, TimeUnit unit) {
        driver.manage().timeouts().implicitlyWait(num, unit);
    }

    public void waitForLoadView(WebDriver driver, long num, TimeUnit unit) {
        driver.manage().timeouts().pageLoadTimeout(num, unit);
    }

    public boolean waitForElementVisible(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)) != null;

    }

    public boolean waitForElementclickable(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 250);

        return wait.until(ExpectedConditions.elementToBeClickable(locator)) != null;
    }



    public static void elementClick(WebDriver driver, By locator1, By locator2, int value) {


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

        TouchAction action = new TouchAction((MobileDriver) driver);

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


    /*public static void dummyScroll_up(WebDriver driver, int swipeUP) {


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

    public static void dummyScroll_down(WebDriver driver, int swipeDown) {


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
*/
    /*public static String getDeviceName() throws Exception {
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
            *//*if (line.contains("device")) break*//*
            ;
        }

        String spitter[] = allLine.split(" ");
        return spitter[4];
    }*/


    /*-------------------------------------PROTEEP BANERJEE------------------------------------------------*/

    // To select element from a dropdown using value attribute.
    public static void selectByValue(WebDriver driver, WebElement element, String value) throws IOException {

        try {
            if (isElementPresent(driver, element)) {
                Select select = new Select(element);
                select.selectByValue(value);
            }
        } catch (Exception e) {

            System.out.println("Not present element:" + element);

        }

    }

    // To select element from a list by matching text
    public static void selectFromListByText(WebDriver driver, List<WebElement> elementsList, String matcherText) {

        for (WebElement element : elementsList) {
            if (element.getText().equalsIgnoreCase(matcherText)) {
                Click(driver, element);
                break;
            }
        }
    }

    // Scroll into view to a web element
    public static void scrollIntoView(WebDriver driver, WebElement element) throws IOException {

        try {
            ((JavascriptExecutor) driver).executeScript
                    ("arguments[0].scrollIntoView(true);", element);

            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Unable to scroll to element : " + element);
            Assert.assertTrue(false);
        }
    }

    // Scroll to find an element
    public static void scrollToFind(WebDriver driver, WebElement element) throws IOException {

        try {
            while (true) {
                if (element.isDisplayed() || element.isEnabled()) {
                    break;
                } else {
                    ((JavascriptExecutor) driver).executeScript
                            ("window.scrollTo(0, document.body.scrollHeight);", element);
                }
            }
        } catch (Exception e) {

            System.out.println("Not present element:" + element);
        }
    }

    // Scroll to the end of the page while the page loads on scrolling
    public static void scrollToEndLoads(WebDriver driver) throws IOException {
        try {

            Object lenOfPage = ((JavascriptExecutor) driver).executeScript
                    ("window.scrollTo(0, document.body.scrollHeight);" +
                            "var lenOfPage=document.body.scrollHeight;" +
                            "return lenOfPage;"
                    );

            while (true) {
                Object lastCount = lenOfPage;
                Thread.sleep(2000);
                lenOfPage = ((JavascriptExecutor) driver).executeScript
                        ("window.scrollTo(0, document.body.scrollHeight);var lenOfPage=document.body.scrollHeight;return lenOfPage;");
                if (lastCount.equals(lenOfPage)) {
                    break;
                }
            }
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Unable to scroll to the end of page due to : " +
                    e.getMessage());
        }
    }

    // To retrieve the page title of a page.
    public static void getPageTitle(WebDriver driver, String PageTitle) throws IOException {

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        try {
            (new WebDriverWait(driver, 15)).until(ExpectedConditions.titleIs(PageTitle));
            Assert.assertEquals(driver.getTitle(), PageTitle, "Page title did not match.");
            System.out.println("Page title matched.");
        } catch (Exception e) {
            System.out.println("Unable to fetch page title for the page : " + PageTitle);
        }

    }


    //to scroll the window till end using ajax scrolling
    public static void scroll(WebDriver driver) throws InterruptedException {
        JavascriptExecutor je = (JavascriptExecutor) driver;

        String jscode = "window.scrollBy(0, document.body.scrollHeight)";
        for (int i = 0; i < 7; i++) {
            Thread.sleep(5000);
            je.executeScript(jscode);
        }
    }


    // To verify the text of a webelement.
    public static boolean verifyText(WebElement element, String text) {

        if (element.getText().equalsIgnoreCase(text)) {
            softAssert.assertTrue(true, text + " verified");
            softAssert.assertAll();
            return true;
        } else {
            softAssert.assertTrue(false, text + " not verified");
            softAssert.assertAll();
            return false;
        }
    }

    public static void scrollByCount(WebDriver driver, int Num) throws InterruptedException {
        JavascriptExecutor je = (JavascriptExecutor) driver;

        String jscode = "window.scrollBy(0, document.body.scrollHeight)";
        for (int i = 0; i < Num; i++) {
            Thread.sleep(5000);
            je.executeScript(jscode);
        }
    }


    public static String getText(WebDriver driver, By by,ExtentTest logger) throws IOException{
        String text = FindElement(driver,by,logger).getText();
        return text;
    }


    /*------------------------------------------SUMEET SINGH---------------------------------------------*/

    // Method to move element by offset
    public static void MoveByOffsetAndClick(WebDriver driver, int x_axis, int y_axis) throws IOException {
        try {
            Actions act = new Actions(driver);
            act.moveByOffset(x_axis,y_axis).click().build().perform();
        } catch (Exception e){
            System.out.println("Unable to move element ");
        }
    }

    // Method to move element by element
    public static void MoveByElementAndClick(WebDriver driver, WebElement element) throws IOException, InterruptedException {
        try {
            Actions act = new Actions(driver);
            act.moveToElement(element).click().build().perform();
            //Thread.sleep(500);
            //act.perform();
        } catch (Exception e){
            System.out.println("Unable to move element ");
        }
        Thread.sleep(500);
    }

    // To select element from a dropdown using value attribute.
    public static WebElement GetFirstSelectedValue(WebDriver driver, WebElement element) throws IOException {
        WebElement option= null;
        try{
            if(isElementPresent(driver, element)){
                Select select = new Select(element);
                option = select.getFirstSelectedOption();
            }
        }
        catch (Exception e){
            System.out.println("Unable to select element from the dropdown");
        }
        return option;
    }

    // Method to check whether Webelement is clickable or not
    public static boolean IsClickable(WebDriver driver, WebElement element) throws IOException {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Failed to check element is clickable");
            return false;
        }
    }

    public static boolean CompareText(WebElement element1, WebElement element2) {
        if (element1.getText().equalsIgnoreCase(element2.getText())) {
            return true;
        } else {
            System.out.println("Failed to compare text");
            return false;
        }

    }

    public static void wait(int sec) {
        int millisec = sec * 1000;

        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void switchToChildWindow(WebDriver driver, ExtentTest logger) {
    	
    }
}
