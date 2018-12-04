package Fab_Application.Controller.POM.HomeScreen;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

import static Fab_Application.Constants.UiAddresses.calendar_DateList;

public class HomeScreen_POM {

    public static WebElement LoginButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homePage_loginButton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement searchField(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homePage_CitySearchField, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

//    public static WebElement checkInButton(WebDriver driver, ExtentTest logger) throws IOException {
//        WebElement element = null;
//
//        try{
//            element = ReusableMethods.FindElement(driver, UiAddresses.splashScreen_CheckinField, logger);
//            logger.log(LogStatus.PASS, element.getText() + " : Found");
//
//        } catch (Exception e) {
//            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
//            System.out.println(e.getMessage());
//            Assert.assertTrue(false);
//        }
//
//        return element;
//    }


    public static WebElement SearchButton(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homePage_SearchButton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static List<WebElement> autosuggestionList(WebDriver driver, ExtentTest logger) throws IOException{
        List<WebElement> elements = null;

        try{
            elements = ReusableMethods.FindElements(driver, UiAddresses.homePage_CityAutosuggestionList, logger);
            logger.log(LogStatus.PASS, elements + " : Found", logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return elements;
    }

    public static WebElement selectGuest(WebDriver driver, ExtentTest logger, String numOfGuest) throws IOException {
        WebElement element = null;

        try{
        	
            element = ReusableMethods.FindElements(driver, UiAddresses.homePage_GuestList, logger).get(Integer.parseInt(numOfGuest)-1);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement calendarNextButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.calendar_nextButton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement CheckinButton(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.SRP_EditDetails_CalendarCheckIn, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement monthYearDisplay(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{

            element = ReusableMethods.FindElement(driver,UiAddresses.calendar_monthYearDisplay,logger);
            logger.log(LogStatus.PASS,element.getText()+" : Found");
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }
//
//    public static WebElement calendarYear(WebDriver driver, ExtentTest logger) throws IOException {
//        WebElement element = null;
//
//        try{
//            element = ReusableMethods.FindElement(driver, UiAddresses.calendarYear, logger);
//            logger.log(LogStatus.PASS, element.getText() + " : Found");
//
//        } catch (Exception e) {
//            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
//            System.out.println(e.getMessage());
//            Assert.assertTrue(false);
//        }
//
//        return element;
//    }

    public static WebElement selectCalendarDates(WebDriver driver, ExtentTest logger, String date) throws IOException{

        WebElement element = null;
        try{
            List<WebElement> dateList  = ReusableMethods.FindElements(driver, calendar_DateList, logger);
            for(WebElement element1 : dateList){
                if(element1.getText().equalsIgnoreCase(date)){
                    element = element1;
                }
            }

            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }




//    public static List<WebElement> installAppClose(WebDriver driver, ExtentTest logger) throws IOException {
//        List<WebElement> element = null;
//
//        try{
//            element = ReusableMethods.FindElements(driver, UiAddresses.splashScreen_installAppClose, logger);
//            logger.log(LogStatus.PASS, element + " : Found");
//
//        } catch (Exception e) {
//            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
//            System.out.println(e.getMessage());
//            Assert.assertTrue(false);
//        }
//
//        return element;
//    }

    /*    public static void ToggleButton(WebDriver driver, ExtentTest logger) throws IOException {
        try{

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
    }*/

//    public static WebElement ReferAFriendOption(WebDriver driver, ExtentTest logger) throws IOException {
//        WebElement element = null;
//
//        try{
//            element = ReusableMethods.FindElement(driver, UiAddresses.getSplashScreen_referFriend, logger);
//        }
//        catch(Exception e){
//            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
//            System.out.println(e.getMessage());
//            Assert.assertTrue(false);
//        }
//        return element;
//    }

//    public static WebElement CalendarCheckInButton(WebDriver driver, ExtentTest logger) throws IOException {
//        WebElement element = null;
//
//        try{
//            element = ReusableMethods.FindElement(driver, UiAddresses.splashScreen_CheckinField, logger);
//        }
//        catch(Exception e){
//            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
//            System.out.println(e.getMessage());
//            Assert.assertTrue(false);
//        }
//        return element;
//    }
//
//    public static WebElement CalendarCurrentDate(WebDriver driver, ExtentTest logger) throws IOException {
//        WebElement element = null;
//
//        try{
//            element = ReusableMethods.FindElement(driver,UiAddresses.Calendar_CurrentDate,logger);
//        }
//        catch(Exception e){
//            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
//            System.out.println(e.getMessage());
//            Assert.assertTrue(false);
//        }
//        return element;
//    }

    public static WebElement CheckedInDate(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.calendar_CheckinDate,logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement CheckedOutDate(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver,UiAddresses.calendar_CheckoutDate,logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

//    public static List<WebElement> fetchingAllCarousalCities(WebDriver driver, ExtentTest logger) throws IOException {
//        List<WebElement> allCities = null;
//
//        try{
//            allCities = ReusableMethods.FindElements(driver,UiAddresses.getSplashScreen_AllCarousalCities, logger);
//        }
//        catch(Exception e){
//            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
//            System.out.println(e.getMessage());
//            Assert.assertTrue(false);
//        }
//        return  allCities;
//    }

    /*public static WebElement MobileNumberOnLoginPage(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement mobile = null;
        try{
            mobile = ReusableMethods.FindElement(driver, UiAddresses.loginScreen_mobileNumberField, logger, "Mobile Number Field");
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return mobile;
    }*/

//    public static WebElement nearByHotelTag(WebDriver driver, ExtentTest logger) throws IOException {
//        WebElement element = null;
//
//        try{
//            element  = ReusableMethods.FindElement(driver,UiAddresses.getSplashScreen_nearbyHotelTag, logger);
//        }
//        catch(Exception e){
//            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
//            System.out.println(e.getMessage());
//            Assert.assertTrue(false);
//        }
//        return element;
//    }
//
//    public static WebElement toggleButton(WebDriver driver, ExtentTest logger) throws IOException {
//        WebElement element = null;
//
//        try{
//            element  = ReusableMethods.FindElement(driver,UiAddresses.getSplashScreen_toggleButton, logger);
//        }
//        catch(Exception e){
//            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
//            System.out.println(e.getMessage());
//            Assert.assertTrue(false);
//        }
//        return element;
//    }
//
//    public static WebElement hamburgerMoreOptions(WebDriver driver, ExtentTest logger) throws IOException {
//        WebElement element = null;
//
//        try{
//            element  = ReusableMethods.FindElement(driver,UiAddresses.getSplashScreen_HamburgerMoreOption, logger);
//        }
//        catch(Exception e){
//            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
//            System.out.println(e.getMessage());
//            Assert.assertTrue(false);
//        }
//        return element;
//    }
//
//    public static WebElement ourLocationsOption(WebDriver driver, ExtentTest logger) throws IOException {
//        WebElement element = null;
//
//        try{
//            element  = ReusableMethods.FindElement(driver,UiAddresses.getSplashScreen_OurLocations, logger);
//        }
//        catch(Exception e){
//            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
//            System.out.println(e.getMessage());
//            Assert.assertTrue(false);
//        }
//        return element;
//    }
//
//    public static List<WebElement> getAllourLocations(WebDriver driver, ExtentTest logger) throws IOException {
//        List<WebElement> elements = null;
//
//        try{
//            elements  = ReusableMethods.FindElements(driver,UiAddresses.getSplashScreen_OurLocationsList, logger);
//        }
//        catch(Exception e){
//            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
//            System.out.println(e.getMessage());
//            Assert.assertTrue(false);
//        }
//        return elements;
//    }
//
//    public static List<WebElement> getHamburgerOptions(WebDriver driver, ExtentTest logger) throws IOException {
//        List<WebElement> elements = null;
//
//        try{
//            elements  = ReusableMethods.FindElements(driver,UiAddresses.getSplashScreen_HamburgerOption, logger);
//        }
//        catch(Exception e){
//            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
//            System.out.println(e.getMessage());
//            Assert.assertTrue(false);
//        }
//        return elements;
//    }
//
//    public static List<WebElement> getHamburgerMoreOptionsList(WebDriver driver, ExtentTest logger) throws IOException {
//        List<WebElement> elements = null;
//
//        try{
//            elements  = ReusableMethods.FindElements(driver,UiAddresses.getSplashScreen_HamburgerMoreOptionList, logger);
//        }
//        catch(Exception e){
//            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
//            System.out.println(e.getMessage());
//            Assert.assertTrue(false);
//        }
//        return elements;
//    }

}
