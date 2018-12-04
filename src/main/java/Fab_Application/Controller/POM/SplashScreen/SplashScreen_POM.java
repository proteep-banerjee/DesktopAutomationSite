package Fab_Application.Controller.POM.SplashScreen;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class SplashScreen_POM {

    public static WebElement LoginButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.splashScreen_loginButton, logger);
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
            element = ReusableMethods.FindElement(driver, UiAddresses.splashScreen_CitySearchField, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement checkInButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.splashScreen_checkinButton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement calendarNextButton(WebDriver driver, ExtentTest logger) throws IOException{
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

    public static WebElement calendarYear(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.calendarYear, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement calendarMonth(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.calendarMonth, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static List<WebElement> calendarDates(WebDriver driver, ExtentTest logger) throws IOException{
        List<WebElement> elements = null;

        try{
            elements = ReusableMethods.FindElements(driver, UiAddresses.calendarDateList, logger);
            logger.log(LogStatus.PASS, elements + " : Found", logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return elements;
    }

    public static WebElement calendarDoneButton(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.calendar_DoneButton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement SearchButton(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.splashScreen_SearchButton, logger);
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
            elements = ReusableMethods.FindElements(driver, UiAddresses.splashScreen_autosuggestionList, logger);
            logger.log(LogStatus.PASS, elements + " : Found", logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return elements;
    }

    public static List<WebElement> guestList(WebDriver driver, ExtentTest logger) throws IOException {
        List<WebElement> elements = null;

        try{
            elements = ReusableMethods.FindElements(driver, UiAddresses.splashScreen_GuestList, logger);
            logger.log(LogStatus.PASS, "Guest List Found.");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return elements;
    }

    public static WebElement guestSelected(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.splashScreen_GuestSelected, logger);
            logger.log(LogStatus.PASS, "Guest List Found.");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static List<WebElement> installAppClose(WebDriver driver, ExtentTest logger) throws IOException {
        List<WebElement> element = null;

        try{
            element = ReusableMethods.FindElements(driver, UiAddresses.splashScreen_installAppClose, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }


    /*    public static void ToggleButton(WebDriver driver, ExtentTest logger) throws IOException {
        try{

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
    }*/

    public static WebElement ReferAFriendOption(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.getSplashScreen_referFriendOption, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement corporateEnquiryOption(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.getSplashScreen_corporateEnquiryOption, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement beOurFranchiseOption(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.getSplashScreen_beOurFranchiseOption, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement CalendarCheckInButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.splashScreen_checkinButton, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement CalendarCurrentDate(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Calendar_CurrentDate,logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement CheckedInDate(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.Calendar_CheckedInDate,logger);
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
            element = ReusableMethods.FindElement(driver, UiAddresses.Calendar_CheckedOutDate,logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }



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





/*    public static WebElement ourLocationsOption(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element  = ReusableMethods.FindElement(driver, UiAddresses.getSplashScreen_OurLocations, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }*/

    public static List<WebElement> getAllourLocations(WebDriver driver, ExtentTest logger) throws IOException {
        List<WebElement> elements = null;

        try{
            elements  = ReusableMethods.FindElements(driver, UiAddresses.getSplashScreen_OurLocationsList, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return elements;
    }

    public static WebElement searchButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element  = ReusableMethods.FindElement(driver, UiAddresses.splashScreen_SearchButton, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement callOption(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element  = ReusableMethods.FindElement(driver, UiAddresses.getSplashScreen_callOption, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static List<WebElement> menuTopOption(WebDriver driver, ExtentTest logger) throws IOException {
        List<WebElement> elements = null;
        try{
            elements  = ReusableMethods.FindElements(driver, UiAddresses.splashScreen_menuTopThreeOptions, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return elements;
    }

    public static WebElement searchWithoutLocation(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element  = ReusableMethods.FindElement(driver, UiAddresses.getSplashScreen_searchErrorWithoutLocation, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement verifyHomePageText(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element  = ReusableMethods.FindElement(driver, UiAddresses.getSplashScreen_verifyHomePageText, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement moreCitesOption(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element  = ReusableMethods.FindElement(driver, UiAddresses.getSplashScreen_moreCities, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static List<WebElement> getMoreCities(WebDriver driver, ExtentTest logger) throws IOException {
        List<WebElement> elements = null;
        try{
            elements  = ReusableMethods.FindElements(driver, UiAddresses.getSplashScreen_getMoreCities, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return elements;
    }


    //to be done########################
    public static WebElement backButton(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.SRP_BackButton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement AListOption(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.getSplashScreen_AListOption, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static String verifyAListOptionText(WebDriver driver, ExtentTest logger) throws IOException{
        String element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.getSplashScreen_verifyAListOption, logger).getText();
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }




}
