package Fab_Application.Controller.Payment.PropertyDetailPage;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import static Fab_Application.Controller.POM.PropertyDetailPage.PDP_POM.*;
import static Fab_Application.Controller.POM.ReviewPage.Review_POM.GuestAndRoomDetails;

public class PDP_Manager_PaymentFlow {

    public void Validate_TC(WebDriver driver, ExtentTest logger) throws IOException, InterruptedException {
    	
    	String childWindow = "";
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator handlesItr = windowHandles.iterator();
        while(handlesItr.hasNext()){
            handlesItr.next();
            childWindow =   handlesItr.next().toString();
        }

        driver.switchTo().window(childWindow);
        System.out.println("Switched to window " + driver.getTitle());
    	
    	System.out.println("Room increment wait ");
    	Thread.sleep(3000);
    	

    	WebElement roomInc = roomIncrementButton(driver,logger);
    	ReusableMethods.scrollIntoView(driver, roomInc);
        if(roomInc.isEnabled()) {
        	System.out.println("room is enabled ");
        	((JavascriptExecutor) driver).executeScript("arguments[0].click", roomInc);
        	
        }

        //to verify the price of rooms after increment and decrement

        String roomPrice =  RoomPriceTotal(driver,logger).getText().replaceAll("[^0-9]", "");
        System.out.println("Final Deluxe Price is :: " + roomPrice);

        String bookNow_BtnPrice = InfobarPrice(driver,logger).getText().replaceAll("[^0-9]","");
        System.out.println("Book Now Button price is:: " + bookNow_BtnPrice);

        if (Integer.parseInt(roomPrice) == Integer.parseInt(bookNow_BtnPrice)) {
            System.out.println("Price Matched...");
        } else {
            Assert.assertTrue(false, "Price didn't match :- " + "Deluxe section price is: " + roomPrice + " || Book Now Button Price is: " + bookNow_BtnPrice);

        }

        //used to get the guest and night count details from the deluxe tupple

        String DeluxeNightCount = DeluxeNightCount(driver, logger).getText().split("//s+")[0];
        String DeluxeGuestCount = DeluxeGuestCount(driver,logger).getText().split("//s+")[0];

        System.out.println("Night Count in Deluxe Tupple is: " + DeluxeNightCount);
        System.out.println("Guest Count in Deluxe Tupple is: " + DeluxeGuestCount);

        //Guest and Night count details from the bottom Infobar

        String InfobarGuestDetails = InfobarGuestCount(driver,logger).getText().split("//s+")[0];
        String InfobarNightDetails = InfobarNightCount(driver,logger).getText().split("//s+")[0];

        System.out.println("Night Count in Book Now field is: " + InfobarNightDetails);
        System.out.println("Guest Details in Book Now field is: " + InfobarGuestDetails);

        if (DeluxeNightCount.equalsIgnoreCase(InfobarNightDetails) && DeluxeGuestCount.equalsIgnoreCase(InfobarGuestDetails)) {
            Assert.assertTrue(true, "Night and Guest count details matched.>");
        } else {
            Assert.assertTrue(false, "Night and Guest count details didn't match ..>");
        }

        Thread.sleep(5000);

        String pdpPrice = PDPScreenPrice(driver, logger).getText().replaceAll("[^0-9]", "");


        System.out.println("PropertyDetailPage page price is: " + pdpPrice);
        if (pdpPrice.equals(bookNow_BtnPrice)) {
            System.out.println("Price Matched on Description page and PropertyDetailPage Screen...");
        } else {
            Assert.assertTrue(false, "Price not Matched on Description page and PropertyDetailPage Screen...");
        }

        ReusableMethods.Click(driver, BookNowButton(driver, logger));

        String[] guestCount_ReviewScreen = GuestAndRoomDetails(driver,logger).getAttribute("innerText").split(",");
        
        System.out.println("GuestAndRoomDetails(driver,logger).getText() -> "+ GuestAndRoomDetails(driver,logger).getAttribute("innerText"));
        String roomDetails = guestCount_ReviewScreen[0].trim().split("//s")[0];
        String NightDetails = guestCount_ReviewScreen[1].trim().split("//s")[0];
        String GuestDetails = guestCount_ReviewScreen[2].trim().split("//s")[0];

        System.out.println("guestCount_ReviewScreen[1].trim()"+ guestCount_ReviewScreen[1].trim());
        System.out.println("Night details"+ NightDetails);
        
        System.out.println("Total guests on Payment Screen is: " + GuestDetails);

//        if (GuestDetails.equals(DeluxeGuestCount) && GuestDetails.equals(InfobarGuestDetails)) {
//            Assert.assertTrue(true, "Count of Guests matched with Deluxe tupple and Book Now button...");
//        } else {
//            Assert.assertTrue(false, "Count of Guests didn't match with Deluxe tupple and Book Now button Guests...");
//        }
        if (NightDetails.equalsIgnoreCase(DeluxeNightCount) && NightDetails.equalsIgnoreCase(InfobarNightDetails)) {
        	System.out.println("In if");
            Assert.assertTrue(true, "Count of Nights matched with Deluxe tupple and Infobar..");
        } else {
        	System.out.println("Else");
        	System.out.println("NightDetails"+NightDetails);
        	System.out.println("DeluxeNightCount"+DeluxeNightCount);
        	System.out.println("InfobarNightDetails"+InfobarNightDetails);
            Assert.assertTrue(false, "Count of Nights didn't match with Deluxe tupple and Infobar Night...");
        }

        // Add room details

//        if (roomDetails.equals(DeluxeGuestCount) && GuestDetails.equals(InfobarGuestDetails)) {
//            Assert.assertTrue(true, "Count of Guests matched with Deluxe tupple and Book Now button...");
//        } else {
//            Assert.assertTrue(false, "Count of Guests didn't matched with Deluxe tupple and Book Now button Guests...");
//        }
    }
}
