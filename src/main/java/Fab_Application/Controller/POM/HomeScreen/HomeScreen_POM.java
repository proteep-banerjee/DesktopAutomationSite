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

	public static WebElement guestIcon(WebDriver driver, ExtentTest logger) throws IOException{

		WebElement element = null;

		try{

			element = ReusableMethods.FindElement(driver,UiAddresses.homePage_GuestIcon,logger);
			logger.log(LogStatus.PASS,element.getText()+" : Found");
		}
		catch(Exception e){
			logger.log(LogStatus.FAIL, e.getMessage(), logger.addScreenCapture(ReusableMethods.captureScreenShot(driver)));
			System.out.println(e.getMessage());
			Assert.assertTrue(false);
		}

		return element;
	}
}
