package com.fabhotels.desktopsite.testsuite.detailpage;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.pageobjects.DetailPage;
import com.fabhotels.desktopsite.pageobjects.ListingPage;
import com.fabhotels.desktopsite.pageobjects.PaymentPage;
import com.fabhotels.desktopsite.utils.Config;
import com.fabhotels.desktopsite.utils.Constants;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class ExecutionSuite_DetailPage extends Config {
	String Sheetname;
	Xls_Reader datatable;

	@BeforeTest
	public void beforeTest() {
		driver = generic.startDriver(Driver_Type);
		generic.maximize();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.manage().deleteAllCookies();
	}
	
	
	@DataProvider(name = "DataProvider_DetailPage")
	public Object[][] DataProvider_DetailPage() {
		Sheetname = "DetailPage";
		datatable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_DETAILPAGEANDPAYMENTPAGE);
		int rowcount = datatable.getRowCount(Sheetname);
		Object result[][] = new Object[rowcount - 1][5];
		for (int i = 2; i < rowcount + 1; i++) {
			result[i - 2][0] = i;
			result[i - 2][1] = datatable.getCellData(Sheetname, "Locality", i);
			String checkinDate = datatable.getCellData(Sheetname, "CheckInDate", i);
			String checkoutDate = datatable.getCellData(Sheetname, "CheckOutDate", i);

			if (checkinDate.equalsIgnoreCase("today")) {
				result[i - 2][2] = GenericFunctions.getTodaysDate();
			} else {
				result[i - 2][2] = checkinDate;
			}

			if (checkoutDate.equalsIgnoreCase("tomorrow")) 
			{
				result[i - 2][3] = GenericFunctions.getTomorrowsDate();
			} 
			else 
			{
			  result[i - 2][3] = GenericFunctions.getDateAfterDays(checkoutDate);
			}
			result[i - 2][4] = datatable.getCellData(Sheetname, "ExpectResults", i);
		}
		
		return result;
	}
	

	
	@Test(dataProvider = "DataProvider_DetailPage")
	public void TC_Validate_singleRoomPrice(int rowno, String locality, String checkInDate, String checkOutDate,
	    String expectResults) throws InterruptedException{
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		ListingPage listingPage = new ListingPage(driver, generic);
		DetailPage detailPage = new DetailPage(driver, generic);
		
		if(!generic.isVisible(ListingPage.singleProperty_WE)){
			Assert.assertEquals("Property", "NotFound", "Property is not found on the list page !!");
		}
		
		listingPage.click_singleProperty_WE();
		detailPage.Select_CheckIn_CheckOut_Date_WE(checkInDate, checkOutDate);
		double detailFinalAmount = 0; String paymentPageTotalAmount = " "; double paymentPageFinalAmount = 0;
		double detailPageTotalPrice = 0; double taxAmount = 0;		
		if(!driver.getPageSource().contains("Room /")){
			int count = 1; int roomcount = 0, soldOutCount=0;
			double sumOfAllPriceOfProperty = 0;
			String SoldOutMssg = " ";
			if (detailPage.getText_bookNow_Btn().equalsIgnoreCase("Book Now")){

				if (driver.getPageSource().contains("Sold Out")) {
					soldOutCount = detailPage.webElementsCount_soldOutCout_Lbl();
				}
				
				double [] multipleRoomIndividualprice = new double [detailPage.getSize_multipleRoomPropertyRoomType_WE()-soldOutCount];				
			 for (int i=1; i<=(detailPage.getSize_multipleRoomPropertyRoomType_WE()); i++){
				roomcount = Integer.parseInt(generic.driver.findElement(By.xpath(DetailPage.multipleRoomType_roomCount_WE+"["+i+"]")).getAttribute("value"));
				SoldOutMssg = generic.driver.findElement(By.xpath(DetailPage.multipleRoomType_soldOutMssg_WE+"["+i+"]")).getText();
				if (SoldOutMssg.equalsIgnoreCase("Sold Out") || roomcount>=1){
					continue;
				}
			    Thread.sleep(2000L);
			    driver.findElement(By.xpath(DetailPage.multipleRooomType_propertyPlusButton_WE+"["+i+"]")).click();
				count++;	 
			 }
			 for (int y=0; y<count; y++){
				 multipleRoomIndividualprice [y]  =  Double.parseDouble(driver.findElement(By.xpath(DetailPage.multipleRoomType_individualPropertyPrice_WE+"["+(y+1)+"]")).getText()); 
				 sumOfAllPriceOfProperty = sumOfAllPriceOfProperty + multipleRoomIndividualprice[y];
			 }
			 detailPageTotalPrice = Double.parseDouble(detailPage.getText_multipleRoomType_totalPriceForAllRooms_WE());		 			 
			 Assert.assertEquals(detailPageTotalPrice, sumOfAllPriceOfProperty, "The sum of individual price of the room of the property is not matched with the total price of the property !!");
			 detailPage.click_bookNow_Btn();
			 detailPage.singleRoomTypePricecomparison( detailFinalAmount, paymentPageTotalAmount, paymentPageFinalAmount, 
					   detailPageTotalPrice, taxAmount);
			}
			else{			
				 Assert.assertEquals(detailPage.getText_bookNow_Btn(), "Sold Out","Case failed!! Sold out not visible");	
			}		  
		}	
		else{
		   if (detailPage.getText_bookNow_Btn().equalsIgnoreCase("Book Now")){
			   detailPageTotalPrice = Integer.parseInt(detailPage.getText_totalAmounnt_Lbl());
			   Thread.sleep(5000L);
			   detailPage.click_bookNow_Btn();
			   detailPage.singleRoomTypePricecomparison( detailFinalAmount, paymentPageTotalAmount, paymentPageFinalAmount, 
					   detailPageTotalPrice, taxAmount);
		    }
		    else{
			 Assert.assertEquals(detailPage.getText_bookNow_Btn(), "Sold Out","Case failed!! Sold out not visible");
		    }
	   }
	}
	
	
	@Test(dataProvider = "DataProvider_DetailPage")
	public void TC_Validate_doubleRoomPrice(int rowno, String locality, String checkInDate, String checkOutDate,
	    String expectResults) throws InterruptedException{
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		ListingPage listingPage = new ListingPage(driver, generic);
		DetailPage detailPage = new DetailPage(driver, generic);
		
		if(!generic.isVisible(ListingPage.singleProperty_WE)){
			Assert.assertEquals("Property", "NotFound", "Property is not found on the list page !!");
		}
		
		listingPage.click_singleProperty_WE();
		detailPage.Select_CheckIn_CheckOut_Date_WE(checkInDate, checkOutDate);
		double detailFinalAmount = 0;  double paymentPageFinalAmount = 0; double taxAmount = 0;
		double detailPageTotalPrice = 0;  
		String paymentPageTotalAmount = " "; 
		if(!driver.getPageSource().contains("Room /")){
			int roomcount = 0, soldOutCount =0;
			double sumOfAllPriceOfProperty = 0;
			String individualRoomTypeMssg = " ";	
			if (detailPage.getText_bookNow_Btn().equalsIgnoreCase("Book Now")){
				
				if (driver.getPageSource().contains("Sold Out")) {
					soldOutCount = detailPage.webElementsCount_soldOutCout_Lbl();
				}
	
				  int oneRoomLeftMssg = detailPage.getSize_oneRoomLeftMssg_Lbl();
				  double [] multipleRoomIndividualprice = new double [(detailPage.getSize_multipleRoomPropertyRoomType_WE()*2)-((soldOutCount*2)+oneRoomLeftMssg)];
				  for (int i=1; i<=(detailPage.getSize_multipleRoomPropertyRoomType_WE()); i++){
					roomcount = Integer.parseInt(generic.driver.findElement(By.xpath(DetailPage.multipleRoomType_roomCount_WE+"["+i+"]")).getAttribute("value"));
					individualRoomTypeMssg = generic.driver.findElement(By.xpath(DetailPage.multipleRoomType_soldOutMssg_WE+"["+i+"]")).getText();
					if (individualRoomTypeMssg.equalsIgnoreCase("Sold Out")){
						continue;
					}
					if (individualRoomTypeMssg.equalsIgnoreCase("1 room left") || roomcount == 1){
						driver.findElement(By.xpath(DetailPage.multipleRooomType_propertyPlusButton_WE+"["+i+"]")).click();
					}
					else{
						driver.findElement(By.xpath(DetailPage.multipleRooomType_propertyPlusButton_WE+"["+i+"]")).click();
						Thread.sleep(2000L);
						driver.findElement(By.xpath(DetailPage.multipleRooomType_propertyPlusButton_WE+"["+i+"]")).click();
					}
				}
					for (int y=0; y<(multipleRoomIndividualprice.length); y++){
						multipleRoomIndividualprice [y] = Double.parseDouble(driver.findElement(By.xpath(DetailPage.multipleRoomType_individualPropertyPrice_WE+"["+(y+1)+"]")).getText());
						sumOfAllPriceOfProperty = sumOfAllPriceOfProperty + multipleRoomIndividualprice[y];
					}
					detailPageTotalPrice = Double.parseDouble(detailPage.getText_multipleRoomType_totalPriceForAllRooms_WE());		 			 
					Assert.assertEquals(detailPageTotalPrice, sumOfAllPriceOfProperty, "The sum of individual price of the room of the property is not matched with the total price of the property !!");
					detailPage.click_bookNow_Btn();
					detailPage.singleRoomTypePricecomparison( detailFinalAmount, paymentPageTotalAmount, paymentPageFinalAmount, 
							   detailPageTotalPrice, taxAmount);
		    }	
			else{
				Assert.assertEquals(detailPage.getText_bookNow_Btn(), "Sold Out","Case failed!! Sold out not visible");
			}	  	
		}			
		else{
  			 double detailPageTotalPriceSingleRoom = 0; double numberOfRoomLeft = 0;
			 String availability_error_msg = " ";
			 if (detailPage.getText_bookNow_Btn().equalsIgnoreCase("Book Now")){
				 Thread.sleep(5000L);
				 if (driver.getPageSource().contains("rooms left") || driver.getPageSource().contains("room left")){
				     availability_error_msg = detailPage.getText_availability_error_msg_Lbl();
				     Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(availability_error_msg);
				     while (m.find()){
				    	numberOfRoomLeft = Double.parseDouble(m.group(1));
				     }	   
				 }
				 if (numberOfRoomLeft > 1 || !driver.getPageSource().contains("1 room left")){
					 detailPageTotalPriceSingleRoom = Integer.parseInt(detailPage.getText_totalAmounnt_Lbl()) * 2;	 
					 detailPage.click_addRoomForIndividualRoomType_Lbl();
					 detailPageTotalPrice = Double.parseDouble(detailPage.getText_totalAmounnt_Lbl());
					 Assert.assertEquals(detailPageTotalPriceSingleRoom, detailPageTotalPrice, "Detail page price for 2 room is not correct !!");
					 detailPage.click_bookNow_Btn();
					 detailPage.singleRoomTypePricecomparison( detailFinalAmount, paymentPageTotalAmount, paymentPageFinalAmount, 
							   detailPageTotalPrice, taxAmount);
				 }
				 else{
					 System.out.println("Single room left for locality  >> "+locality);
					 detailPageTotalPrice = Integer.parseInt(detailPage.getText_totalAmounnt_Lbl());
					 detailPage.click_bookNow_Btn();
					 detailPage.singleRoomTypePricecomparison( detailFinalAmount, paymentPageTotalAmount, paymentPageFinalAmount, 
							   detailPageTotalPrice, taxAmount);
				 }
			 }
			 else{
				 Assert.assertEquals(detailPage.getText_bookNow_Btn(), "Sold Out","Case failed!! Sold out not visible");
			 }
		 }
	}
	
	
	/** TC_Validate_room-Night-And-Guest-Count-Match
	 * 	The count of Room, Night and Guest that is visible on the detail page is compared with the Count of Room, Night and Guest that is visible on the payment page. 
	 *  This code handle for both Multiple Room Type and Single Room Type. 
	 * @param rowno :- Does not use in the code 
	 * @param locality :- Take the locality from the xls sheet and match the Room, Night and Guest count from the payment page. 
	 * @param checkInDate :- Comes from the xls sheet, For the input of the checkIn Date
	 * @param checkOutDate :- Comes from the xls sheet, For the input of the checkOut Date
	 * @param expectResults :- Store the value for Room, Night and Guest the detail page
	 * @throws InterruptedException :- Compare the value of the detail page with the payment page
	 */
	@Test(dataProvider = "DataProvider_DetailPage")
	public void TC_Validate_roomNightAndGuestCountMatch(int rowno, String locality, String checkInDate, String checkOutDate,
	    String expectResults) throws InterruptedException {
		generic.loadURL(UrlProvider.getListingPageUrl(locality));
		ListingPage listingPage = new ListingPage(driver, generic);
		DetailPage detailPage = new DetailPage(driver, generic);
		PaymentPage paymentPage = new PaymentPage(driver, generic);
		if(!generic.isVisible(ListingPage.singleProperty_WE)){
			Assert.assertEquals("Property", "NotFound", "Property is not found on the list page !!");
		}
		listingPage.click_singleProperty_WE();
		Thread.sleep(10000L);
		detailPage.Select_CheckIn_CheckOut_Date_WE(checkInDate, checkOutDate);
		String propertyRoomAndNightCount = " ", detailPageRoomNightAndGuest = " ", paymentPageRoomNightAndNight = " ";
		if(!driver.getPageSource().contains("Room /")){
			String individualRoomTypeMssg = " ";
			if (detailPage.getText_bookNow_Btn().equalsIgnoreCase("Book Now")){
				int roomcount =0, soldOutCount=0, oneRoomLeftMssg=0, guestCount = 0;         
				if (driver.getPageSource().contains("Sold Out")) {
					soldOutCount = detailPage.webElementsCount_soldOutCout_Lbl();
				}
				oneRoomLeftMssg = detailPage.getSize_oneRoomLeftMssg_Lbl();
				int [] multipleRoomIndividualprice = new int [(detailPage.getSize_multipleRoomPropertyRoomType_WE()*2)-((soldOutCount*2)+oneRoomLeftMssg)];
				for (int i=1; i<=(detailPage.getSize_multipleRoomPropertyRoomType_WE()); i++){
					roomcount = Integer.parseInt(generic.driver.findElement(By.xpath(DetailPage.multipleRoomType_roomCount_WE+"["+i+"]")).getAttribute("value"));
					individualRoomTypeMssg = generic.driver.findElement(By.xpath(DetailPage.multipleRoomType_soldOutMssg_WE+"["+i+"]")).getText();
					if (individualRoomTypeMssg.equalsIgnoreCase("Sold Out") || (individualRoomTypeMssg.equalsIgnoreCase("1 room left") && roomcount == 1)){
						continue;
					}
					if (individualRoomTypeMssg.equalsIgnoreCase("1 room left") || roomcount == 1){
						driver.findElement(By.xpath(DetailPage.multipleRooomType_propertyPlusButton_WE+"["+i+"]")).click();
					}
					else{
						driver.findElement(By.xpath(DetailPage.multipleRooomType_propertyPlusButton_WE+"["+i+"]")).click();
						Thread.sleep(2000L);
						driver.findElement(By.xpath(DetailPage.multipleRooomType_propertyPlusButton_WE+"["+i+"]")).click();						
					}
					for (int y=1; y<=2; y++){
						Random rn = new Random();
				        int answer = rn.nextInt(3) + 1;
						if (!driver.findElement(By.xpath("((//div[contains(@class, 'property_room_type_single')])["+i+"]//div[@class='property_plus_minus_container']/div[contains(@class, 'property_button_plus')])["+y+"]")).isDisplayed()){
							break;	
						}
						if (individualRoomTypeMssg.equalsIgnoreCase("1 room left")){
							if (!driver.findElement(By.xpath("((//div[contains(@class, 'property_room_type_single')])["+i+"]//div[@class='property_plus_minus_container']/div[contains(@class, 'property_button_plus')])["+y+"]")).isDisplayed()){
								break;	
							}
							if (answer ==1){
								WebElement elementToClick = driver.findElement(By.xpath("((//div[contains(@class, 'property_room_type_single')])["+i+"]//div[@class='property_plus_minus_container']/div[contains(@class, 'property_button_plus')])["+y+"]"));
								((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick.getLocation().x+")");
								elementToClick.click();
								break;
							}
							else if (answer == 2){
								WebElement elementToClick = driver.findElement(By.xpath("((//div[contains(@class, 'property_room_type_single')])["+i+"]//div[@class='property_plus_minus_container']/div[contains(@class, 'property_button_plus')])["+y+"]"));
								((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick.getLocation().x+")");
								elementToClick.click();
								break;
							}
							else {
								for (int ii=1; ii<=2; ii++){
								WebElement elementToClick = driver.findElement(By.xpath("((//div[contains(@class, 'property_room_type_single')])["+i+"]//div[@class='property_plus_minus_container']/div[contains(@class, 'property_button_plus')])["+y+"]"));
								((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick.getLocation().x+")");
								elementToClick.click();
								}
								break;
							}	
						}
						else{
							if (answer == 1){
							 	break;
							}
							else if (answer == 2){
								WebElement elementToClick = driver.findElement(By.xpath("((//div[contains(@class, 'property_room_type_single')])["+i+"]//div[@class='property_plus_minus_container']/div[contains(@class, 'property_button_plus')])["+y+"]"));
								((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick.getLocation().x+")");
								elementToClick.click();
							}
							else {
								for (int ii=1; ii<=2; ii++){
								WebElement elementToClick = driver.findElement(By.xpath("((//div[contains(@class, 'property_room_type_single')])["+i+"]//div[@class='property_plus_minus_container']/div[contains(@class, 'property_button_plus')])["+y+"]"));
								((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick.getLocation().x+")");
								elementToClick.click();
								}
							}
						}
					}
				}
				for (int y=2; y<((multipleRoomIndividualprice.length)+2); y++){					
					multipleRoomIndividualprice [y-2] = Integer.parseInt(driver.findElement(By.xpath(DetailPage.multipleRoomType_guestCount_WE+"["+y+"]")).getAttribute("value"));
					guestCount = guestCount + multipleRoomIndividualprice [y-2];
				}
				propertyRoomAndNightCount = detailPage.getText_multipleRoom_getRoomAndNightCount_Lbl();
				String [] roomAndNightCount = propertyRoomAndNightCount.split(", ");
				String [] subRoomAndNightCount = roomAndNightCount[1].split(" ");
				if (guestCount == 1){
				detailPageRoomNightAndGuest = roomAndNightCount[0]+", "+subRoomAndNightCount[0]+" "+subRoomAndNightCount[1]+", "+ String.valueOf(guestCount)+" guest";
				}
				else {
				detailPageRoomNightAndGuest = roomAndNightCount[0]+", "+subRoomAndNightCount[0]+" "+subRoomAndNightCount[1]+", "+ String.valueOf(guestCount)+" guests";	
				}
				detailPage.click_bookNow_Btn();
		        Thread.sleep(3000L);
				paymentPageRoomNightAndNight = paymentPage.getText_roomCountNIghtCountAndGuestCount_Lbl();
				Assert.assertEquals(detailPageRoomNightAndGuest.toLowerCase(), paymentPageRoomNightAndNight.toLowerCase(), "The Room, Night and Guest Count is not correct !");
  			}
			else{
				Assert.assertEquals(detailPage.getText_bookNow_Btn(), "Sold Out","Case failed!! Sold out not visible");				
			}
		}
		else{
			if (detailPage.getText_bookNow_Btn().equalsIgnoreCase("Book Now")){
				double numberOfRoomLeft = 0;
				String propertyRoomAndGuestCount = " ", availability_error_msg = " ";
				if (driver.getPageSource().contains("rooms left") || driver.getPageSource().contains("room left")){
				     availability_error_msg = detailPage.getText_availability_error_msg_Lbl();
				     Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(availability_error_msg);
				     while (m.find()){
				    	numberOfRoomLeft = Double.parseDouble(m.group(1));
				     }	
				 }
				if (numberOfRoomLeft == 1){
					detailPage.click_singleRoom_propertyRoomDetails_Btn();
					detailPage.click_singleRoom_occupanyIncrease_Btn();
					detailPage.click_singleRoom_propertyAddRoomsDone_Btn();
					propertyRoomAndGuestCount = detailPage.getText_singleRoom_propertyRoomDetails_Lbl();
					String [] roomAndGuestCount = propertyRoomAndGuestCount.split(" / ");
					propertyRoomAndNightCount = detailPage.getText_SingleRoom_getRoomCountAndNightCount_Lbl();
					String [] roomAndNightCount = propertyRoomAndNightCount.split(", ");
					detailPageRoomNightAndGuest = roomAndNightCount[0]+", "+roomAndNightCount[1]+", "+roomAndGuestCount[1];
					detailPage.click_bookNow_Btn();
					paymentPageRoomNightAndNight = paymentPage.getText_roomCountNIghtCountAndGuestCount_Lbl();
					Assert.assertEquals(detailPageRoomNightAndGuest.toLowerCase(), paymentPageRoomNightAndNight.toLowerCase(), "The Room, Night and Guest Count is not correct !");
				}
				else{
										
					detailPage.click_addRoomForIndividualRoomType_Lbl();
					detailPage.click_singleRoom_propertyRoomDetails_Btn();
					for (int i =2; i<=3; i++){
						if (i==2){
							driver.findElement(By.xpath(DetailPage.singleRoom_addRoomForIndividualRoomType_Lbl + "["+i+"]")).click();
						}
						else {
							driver.findElement(By.xpath(DetailPage.singleRoom_addRoomForIndividualRoomType_Lbl + "["+i+"]")).click();
							Thread.sleep(1000L);
							driver.findElement(By.xpath(DetailPage.singleRoom_addRoomForIndividualRoomType_Lbl + "["+i+"]")).click();						
						}	
					}
					
					detailPage.click_singleRoom_propertyAddRoomsDone_Btn();
					propertyRoomAndGuestCount = detailPage.getText_singleRoom_propertyRoomDetails_Lbl();
					String [] roomAndGuestCount = propertyRoomAndGuestCount.split(" / ");
					propertyRoomAndNightCount = detailPage.getText_SingleRoom_getRoomCountAndNightCount_Lbl();
					String [] roomAndNightCount = propertyRoomAndNightCount.split(", ");
					detailPageRoomNightAndGuest = roomAndNightCount[0]+", "+roomAndNightCount[1]+", "+roomAndGuestCount[1];
					detailPage.click_bookNow_Btn();
					paymentPageRoomNightAndNight = paymentPage.getText_roomCountNIghtCountAndGuestCount_Lbl();
					Assert.assertEquals(detailPageRoomNightAndGuest.toLowerCase(), paymentPageRoomNightAndNight.toLowerCase(), "The Room, Night and Guest Count is not correct !");
				}
			}
			else{
				 Assert.assertEquals(detailPage.getText_bookNow_Btn(), "Sold Out","Case failed!! Sold out not visible");
			}
		}
	}
	
	
	public void TC_ExecutionSuite_DetailPage_001(){
	
	}
    
	
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
