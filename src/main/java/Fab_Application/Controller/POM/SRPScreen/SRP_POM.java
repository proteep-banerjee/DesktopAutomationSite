package Fab_Application.Controller.POM.SRPScreen;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

@SuppressWarnings({"ConstantConditions", "DanglingJavadoc"})
public class SRP_POM {

    public static List<WebElement> listOfProperties(WebDriver driver, ExtentTest logger) throws IOException {

        List<WebElement> element = null;

        try{
            element = ReusableMethods.FindElements(driver, UiAddresses.SRP_listOfProperties, logger);
            logger.log(LogStatus.PASS, element + " : Found", logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static List<WebElement> listOfNearbyProperties(WebDriver driver, ExtentTest logger) throws IOException {

        List<WebElement> element = null;

        try{
            element = ReusableMethods.FindElements(driver, UiAddresses.SRP_listOfNearbyProperties, logger);
            logger.log(LogStatus.PASS, element + " : Found", logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static WebElement sortButton(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.SRP_SortButton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }


    public static List<WebElement> listOfPropertyPrices(WebDriver driver, ExtentTest logger) throws IOException {

        List<WebElement> elements = null;

        try{
            elements = ReusableMethods.FindElements(driver, UiAddresses.SRP_PropertyPricesList, logger);
            logger.log(LogStatus.PASS, elements + " : Found", logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return elements;
    }




    // Edit Details modal
    /************************************************************************
     * **********************************************************************
     */

    public static WebElement SearchField(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.SRP_EditDetails_SearchField, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static List<WebElement> autosuggestionList(WebDriver driver, ExtentTest logger) throws IOException{
        List<WebElement> elements = null;

        try{
            elements = ReusableMethods.FindElements(driver, UiAddresses.SRP_EditDetails_AutosuggestionList, logger);
            logger.log(LogStatus.PASS, elements + " : Found", logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return elements;
    }

    public static WebElement CheckinButton(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.SRP_EditDetails_CalendarCheckIn, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static WebElement GuestIncrease(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.SRP_EditDetails_GuestPlusButton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }


    public static WebElement SearchButton(WebDriver driver, ExtentTest logger) throws IOException {

        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.SRP_EditDetails_SearchButton, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
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
            Assert.fail();
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
            Assert.fail();
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
            Assert.fail();
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
            Assert.fail();
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
            Assert.fail();
        }

        return element;
    }
/*****************************************************************************
 ***************************************************************************
 ****************************************************************************/




    // SRP Sort Modal
    /**************************************************************************
     * ************************************************************************
     */

    public static WebElement LowToHigh(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.SRP_SortModal_PriceAsc, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }
/*******************************************************************************
 * *****************************************************************************
 * ******************************************************************************/


    public static List<WebElement> soldoutPropertiesList(WebDriver driver, ExtentTest logger) throws IOException{
        List<WebElement> elements = null;

        try{
            elements = ReusableMethods.FindElements(driver, UiAddresses.SRP_SoldOutProperties, logger);
            logger.log(LogStatus.PASS, elements + " : Found", logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return elements;
    }

    public static WebElement SearchDetailsCity(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.splashScreen_CitySearchField, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static WebElement SearchDetailsDate(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.SRP_SearchDetails_Date, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static WebElement SearchDetailsGuest(WebDriver driver, ExtentTest logger) throws IOException{
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.SRP_SearchDetails_Guest, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static List<WebElement> RatingStars(WebDriver driver, ExtentTest logger) throws IOException{
        List<WebElement> element = null;

        try{
            element = ReusableMethods.FindElements(driver, UiAddresses.SRP_RatingStars, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static List<WebElement> RatingReviews(WebDriver driver, ExtentTest logger) throws IOException{
        List<WebElement> element = null;

        try{
            element = ReusableMethods.FindElements(driver, UiAddresses.SRP_RatingReviews, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static List<WebElement> CoupleFriendlyTags(WebDriver driver, ExtentTest logger) throws IOException {
        List<WebElement> element = null;

        try{
            element = ReusableMethods.FindElements(driver, UiAddresses.SRP_CoupleFriendlyLabel, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }


    public static List<WebElement> RackPricesList(WebDriver driver, ExtentTest logger) throws IOException {
        List<WebElement> element = null;

        try{
            element = ReusableMethods.FindElements(driver, UiAddresses.SRP_RackPricesList, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }


    public static List<WebElement> ReviewCountList(WebDriver driver, ExtentTest logger) throws IOException {
        List<WebElement> element = null;

        try{
            element = ReusableMethods.FindElements(driver, UiAddresses.SRP_ReviewCountList, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static List<WebElement> FreeBreakfastList(WebDriver driver, ExtentTest logger) throws IOException {
        List<WebElement> element = null;

        try{
            element = ReusableMethods.FindElements(driver, UiAddresses.SRP_FreeBreakfast, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static List<WebElement> EarnCreditsList(WebDriver driver, ExtentTest logger) throws IOException {
        List<WebElement> element = null;

        try{
            element = ReusableMethods.FindElements(driver, UiAddresses.SRP_EarnCredits, logger);
            logger.log(LogStatus.PASS, element + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static List<WebElement> SavedAmountList(WebDriver driver, ExtentTest logger) throws IOException {
        List<WebElement> element = null;

        try{
            element = ReusableMethods.FindElements(driver, UiAddresses.SRP_SavedPriceAmount, logger);
            logger.log(LogStatus.PASS, element + " : Found Saved Prices List");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static WebElement FooterBannerCloseIcon(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.SRP_FooterBanner, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }

    public static List<WebElement> AppliedFiltersList(WebDriver driver, ExtentTest logger) throws IOException {
        List<WebElement> element = null;

        try{
            element = ReusableMethods.FindElements(driver, UiAddresses.SRP_AppliedFilterList, logger);
            logger.log(LogStatus.PASS, element + " : Found applied filters List");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }


    public static WebElement AppliedFilterCloseIcon(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;

        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.SRP_AppliedFiltersCloseIcon, logger);
            logger.log(LogStatus.PASS, element.getText() + " : Found");

        } catch (Exception e) {
            logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
            System.out.println(e.getMessage());
            Assert.fail();
        }

        return element;
    }


}
