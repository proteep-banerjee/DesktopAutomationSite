package Fab_Application.Controller.POM.HomeScreen;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class HomeScreen_POM {

    public static WebElement LoginButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_loginButton, logger);
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
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_CitySearchField, logger);
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
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_SearchButton, logger);
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
            elements = ReusableMethods.FindElements(driver, UiAddresses.homeScreen_autosuggestionList, logger);
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
            elements = ReusableMethods.FindElements(driver, UiAddresses.homeScreen_GuestList, logger);
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
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_GuestSelected, logger);
            logger.log(LogStatus.PASS, "Guest List Found.");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement ReferAFriendOption(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_referFriendOption, logger);
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
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_corporateEnquiry, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement corporateEnquiryOptionUp(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_corporateEnquiryOption, logger);
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
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_beOurFranchiseOption, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement beOurFranchiseOptionDown(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_beOurFranchiseOptionDown, logger);
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
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_checkinButton, logger);
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

    public static List<WebElement> getAllourLocations(WebDriver driver, ExtentTest logger) throws IOException {
        List<WebElement> elements = null;

        try{
            elements  = ReusableMethods.FindElements(driver, UiAddresses.homeScreen_OurLocationsList, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return elements;
    }

    public static WebElement callOption(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element  = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_callOption, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement searchWithoutLocation(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element  = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_searchErrorWithoutLocation, logger);
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
            element  = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_moreCities, logger);
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
            elements  = ReusableMethods.FindElements(driver, UiAddresses.homeScreen_getMoreCities, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return elements;
    }

    public static WebElement AListOption(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_AListOption, logger);
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
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_verifyAListOption, logger).getText();
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement referalCodeOptionBeforeLogin(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_referalCodeOptionBeforeLogin, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement mobileNumberOnReferal(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_mobileNumberOnReferal, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement continueButtonOnReferal(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_continueButtonOnReferal, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement OTPOnReferal(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_OTPOnReferal, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement getStartedButtonOnReferal(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_getStartedButtonOnReferal, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement referalCodeOptionAfterLogin(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_referalCodeOptionAfterLogin, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static List<WebElement> socialMediaLinks(WebDriver driver, ExtentTest logger) throws IOException {
        List<WebElement> elements = null;
        try{
            elements  = ReusableMethods.FindElements(driver, UiAddresses.homeScreen_socialMediaLinks, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return elements;
    }

    public static List<WebElement> AllStaticLinks(WebDriver driver, ExtentTest logger) throws IOException {
        List<WebElement> elements = null;
        try{
            elements  = ReusableMethods.FindElements(driver, UiAddresses.homeScreen_getAllStaticLinks, logger);
        }
        catch(Exception e){
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return elements;
    }

    public static WebElement aboutUs(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_aboutUs, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement careers(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_careers, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement press(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_press, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement blog(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_blog, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement travelAgent(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_travelAgent, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement termsAndConditions(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_termsANdConditions, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement privacyPolicy(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_privacyPolicy, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement cancellationPolicy(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_cancellationPolicy, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement FAQs(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_FAQ, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }

        return element;
    }

    public static WebElement userType(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.homeScreen_userType, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }
}
