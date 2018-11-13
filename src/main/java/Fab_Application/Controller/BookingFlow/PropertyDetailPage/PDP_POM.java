package Fab_Application.Controller.BookingFlow.PropertyDetailPage;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;


public class PDP_POM {

    public static WebElement EditButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_EditButton,logger,"Edit Search");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement BookNowButton(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_BookNowButton, logger, "Book Now button");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement EditSelection(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_EditSelection, logger,"");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement RedeemFabCredits(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_RedeemFabCredits, logger, "\"Sign in to redeem Fab credits and enjoy A-List benefits\" option");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement ViewAllRooms(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_ViewAllRooms, logger, "View All Room");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement OpenMaps(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_OpenMaps, logger, "Open in Maps");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement CancellationPolicy(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_CancellationPolicy, logger, "Cancellation Policy");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement ChildrenPolicy(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_ChildrenPolicy, logger, "Children Policy");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement Check_In_Out_Timings(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_Check_In_out_timings, logger, "Check-In/Out Timings");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement ViewMoreHotels(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_ViewMore, logger, "View More Hotels");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

    public static WebElement OpenApp(WebDriver driver, ExtentTest logger) throws IOException {
        WebElement element = null;
        try{
            element = ReusableMethods.FindElement(driver, UiAddresses.PDP_OpenAppButton, logger, "\"Open App\" Option");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
        return element;
    }

}
