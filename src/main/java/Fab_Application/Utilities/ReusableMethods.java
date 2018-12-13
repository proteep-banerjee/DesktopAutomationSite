package Fab_Application.Utilities;

/**
 * Created By Bhupesh Mehta
 * Modified By Proteep Banerjee
 * Modified By Sumeet Singh
 * Modified By Kalpana
 */

import Fab_Application.Helper.Common.DriverHelper;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReusableMethods extends DriverHelper {

    public static final int impliciteTimeOut = 2;


    // Method to enter the text into a web element
    public static void type(WebDriver driver, WebElement element, Object value) {

        if (isElementPresent(driver, element)) {
            element.click();
            element.clear();
            element.sendKeys((String)value);
            System.out.println("Entered Text :" + value);
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
    public static boolean isElementPresent(WebDriver driver, WebElement element){
       // driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        if (element.isDisplayed() || element.isEnabled()) {
            //driver.manage().timeouts().implicitlyWait(impliciteTimeOut, TimeUnit.SECONDS);
            return true;
        } else {
            //driver.manage().timeouts().implicitlyWait(impliciteTimeOut, TimeUnit.SECONDS);
            return false;
        }
    }

    /*public static void typeByID(AndroidDriver driver, String locator, String value) {

        driver.findElementById(locator).clear();
        driver.findElementById(locator).sendKeys(value);

    }*/

    // Method to find a single element
    public static WebElement FindElement(WebDriver driver, By by,
                                         ExtentTest logger) throws IOException {

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        WebElement element = null;

        try{
            element = (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(by));
            logger.log(LogStatus.INFO, "Found the element : " + element);
            return element;
        }catch (NoSuchElementException  | StaleElementReferenceException e){

            String img = captureScreenShot(driver);
            System.out.println("Exception occured in finding the element " +e.getMessage());
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

        List<WebElement> element = null;

        try {
            element = (new WebDriverWait(driver, 15))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
            logger.log(LogStatus.INFO, "Found the list of elements : " + element);

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


    /*public static void typeByXpath(AndroidDriver driver, String locator, String value) {

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
    /*public static void dropBoxText(AndroidDriver driver, WebElement element, String value1) {

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
    }*/


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


    /*public static void scrollDown(AndroidDriver driver, String text) {
        try {
            JavascriptExecutor js = driver;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", "down");
            scrollObject.put("text", text);
            // scrollObject.put("element", ((RemoteWebElement) scroll).getId());
            js.executeScript("mobile: scrollTo", scrollObject);
        } catch (Exception localException) {
        }
    }*/


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

    /*public static boolean isPresentOnPageAppiumID(AndroidDriver driver, String locator) {

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
            *//*if (line.contains("device")) break*//*
            ;
        }

        String spitter[] = allLine.split(" ");
        return spitter[4];
    }*/

    public static void scrollByCount(WebDriver driver, int Num) throws InterruptedException {
        JavascriptExecutor je = (JavascriptExecutor) driver;

        String jscode = "window.scrollBy(0, document.body.scrollHeight)";
        for (int i = 0; i < Num; i++) {
            Thread.sleep(5000);
            je.executeScript(jscode);
        }
    }

    /********************************************Proteep Banerjee**************************************************/

    // To select element from a dropdown using value attribute.
    public static void selectByValue(WebDriver driver, WebElement element, String value) throws IOException {

        try{
            if(isElementPresent(driver, element)){
                Select select = new Select(element);
                select.selectByValue(value);
            }
        }
        catch (Exception e){

            System.out.println("Not present element:" + element);

        }

    }

    // To select element from a list by matching text
    public static void selectFromListByText(WebDriver driver, List<WebElement> elmnts, String matcherText) {

        for(WebElement elmnt : elmnts){
            if(elmnt.getText().equalsIgnoreCase(matcherText)){
                Click(driver, elmnt);
                break;
            }
        }
    }

    // Scroll into view to a web element
    public static void scrollIntoView(WebDriver driver, WebElement element) throws IOException {

        try{
            ((JavascriptExecutor) driver).executeScript
                    ("arguments[0].scrollIntoView(true);", element);

            Thread.sleep(1000);
        }
        catch (Exception e){
            System.out.println("Unable to scroll to element : " + element);
        }
    }

    // Scroll to find an element
    public static void scrollToFind(WebDriver driver, WebElement element) throws IOException {

        try{
            while(true){
                if(element.isDisplayed()|| element.isEnabled()){
                    break;
                }
                else{
                    ((JavascriptExecutor) driver).executeScript
                            ("window.scrollTo(0, document.body.scrollHeight);", element);
                }
            }
        }
        catch(Exception e){

            System.out.println("Not present element:" + element);
        }
    }

    // Scroll to the end of the page while the page loads on scrolling
    public static void scrollToEndLoads(WebDriver driver) throws IOException {
        try{

            Object lenOfPage = ((JavascriptExecutor) driver).executeScript
                    ("window.scrollTo(0, document.body.scrollHeight);var lenOfPage=document.body.scrollHeight;return lenOfPage;");

            boolean match = true;

            while(match){
                Object lastCount = lenOfPage;
                Thread.sleep(2000);
                lenOfPage = ((JavascriptExecutor) driver).executeScript
                        ("window.scrollTo(0, document.body.scrollHeight);var lenOfPage=document.body.scrollHeight;return lenOfPage;");
                if(lastCount.equals(lenOfPage)){
                    break;
                }
            }
            Thread.sleep(1000);
        }
        catch(Exception e){
            System.out.println("Unable to scroll to the end of page due to : "+
                    e.getMessage());

        }
    }

    // Method to get the page title
    public static void getPageTitle(WebDriver driver, String PageTitle) throws IOException {

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        try {
            (new WebDriverWait(driver, 15)).until(ExpectedConditions.titleIs(PageTitle));
            Assert.assertEquals(driver.getTitle(), PageTitle, "Page title did not match.");
            System.out.println("Page title matched.");
        }

        catch (Exception e) {
            System.out.println("Unable to fetch page title for the page : " + PageTitle);
        }

    }

    // Method to verify text of a webelement to a matcher text.
    public static boolean verifyText(WebElement element, String text) {

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


    // Scroll to the top of page
    public static void scrollup(WebDriver driver){

        try{
            ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-(document.body.scrollHeight))");
        }
        catch (Exception e){
            System.out.println("Unable to scroll to the top of the page : " + e.getMessage());

        }

    }

    // Calendar date selection method for desktop.
    public static void calendar_CheckInDesktop(WebDriver driver, String Month, String Date) {

        String CheckIn = "//div[@class='datepicker-days']//th[contains(text(),'" + Month + "')]/ancestor::table//td[text()='" + Date + "']";

        while (true) {
            try {
                driver.findElement(By.xpath(CheckIn)).click();
                break;
            } catch (NoSuchElementException e) {
                String nextBtn = "//div[@class='datepicker-days']//th[@class='next']";
                driver.findElement(By.xpath(nextBtn)).click();
            }
        }
    }

    /**************************************************************************************************/




    /******************************************Sumeet*************************************************/
    // Method to move to the element
    public static void MoveToElement(WebDriver driver, WebElement element) throws IOException {
        try {
            Actions act = new Actions(driver);
            act.moveToElement(element).build().perform();
        } catch (Exception e){
            System.out.println("Unable to move to the element ");
        }
    }

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

    public static boolean CompareText(String element1, String element2) {
        if (element1.equalsIgnoreCase(element2)) {
            return true;
        } else {
            System.out.println(element1+" is not equal to "+element2);
            return false;
        }

    }

    // Sleep method
    public static void wait(int sec) {
        int millisec = sec * 1000;

        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /********************************************************************************************/



    /***********************************Kalpana**************************************************/

    // Method to get the text of a web element.
    public static String getText(WebDriver driver, By by,ExtentTest logger) throws IOException{
        String text = FindElement(driver,by,logger).getText();
        return text;
    }

    /********************************************************************************************/

}
