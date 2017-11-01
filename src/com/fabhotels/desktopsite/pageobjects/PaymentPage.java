package com.fabhotels.desktopsite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;
import com.fabhotels.automationframework.xlsreader.Xls_Reader;
import com.fabhotels.desktopsite.utils.Constants;
import com.fabhotels.desktopsite.utils.UrlProvider;

public class PaymentPage {
	WebDriver driver;
	GenericFunctions generic;
	Xls_Reader dataTable;
	ListingPage listingpage;
	SearchBar performSearch;

	public static final By roomCountNIghtCountAndGuestCount_Lbl = By.xpath("(//div[contains(text(), 'guest')])[2]");
	public static final By subTotal_Lbl = By.xpath("//span[@class='sub-total-amount']");
	public static final By taxAmount_Lbl = By.xpath("//span[@class='tax-amount']");
	public static final By taxPercent_Lbl = By.xpath("//div[@class='review_booking_tax_title']");
	public static final By finalAmount_Lbl = By.xpath("//div[@class='review_booking_total_amount']/span");
	public static final By couponCode_Txt = By.xpath("//span[@class='coupon_code_text']");
	public static final By couponCodeApply_Btn = By.xpath("//div[@class='apply_coupon_code']/span");
	public static final By removeCouponCode_Lbl = By.xpath("//div[contains(@class, 'review_booking_coupon_detail')]/span[contains(@class, 'remove_coupon_code')]");
	public static final By discountValue_Lbl = By.xpath("//div[@class='review_booking_discount_amount']/span[@class='discount-amount']");
	public static final By couponCodeSuccessMssg_Lbl = By.xpath("//p[@class='coupon_code_success']");
	public static final By couponCodeErrorMssg_Lbl = By.xpath("//p[contains(@class, 'coupon_code_error')]");
	public static final By taxPercentTitle_Lbl = By.xpath("//div[@class='review_booking_tax_title']");
	public static final By reviewBookingContinue_btn = By.xpath("//div[@class='review_booking_continue submit-booking-details']/span");
	public static final By couponApplyFillBox_Txt = By.xpath("//input[contains(@class, 'coupon-code')]");
	public static final By propertyName_Lbl = By.xpath("//div[contains(@class, 'review_property_name')]");
	public static final By propertyContainer_WE=By.xpath("(//div[contains(@class,'hotel-list')]//input)[1]");
	public static final By propertyDetailPageContianer_WE=By.xpath("//div[@class='property_container']");
	public String minimumRoomTypeWarning_Lbl=" minimum room nights required to use this coupon";
	

	public PaymentPage(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}
	
	public String getSheetTxt_ByType(String sheetName,String colName,String cellValue)
	{
		dataTable = new Xls_Reader(Constants.FILEPATH_TESTDATASHEET_DETAILPAGEANDPAYMENTPAGE);
		int getRowNum=dataTable.getCellRowNum(sheetName, colName, cellValue);
		return dataTable.getCellData(sheetName, "couponName", getRowNum);
	}
	
	public String getPropertyId_ByItsName(String hotelName)
	{	
		String hotelid="";
		listingpage=new ListingPage(driver, generic);
		performSearch=new SearchBar(driver, generic);
		((JavascriptExecutor)driver).executeScript("window.open()");
		generic.switchtoNewWindow();
		generic.loadURL(UrlProvider.getListingPageUrl());
		
		performSearch.performSearch(hotelName,"","","");
		hotelid = driver.findElement(propertyContainer_WE).getAttribute("value");
		generic.closeNewWindow();
		generic.SwitchtoOriginalWindow();
		System.out.println(hotelName+", its id : "+hotelid);
		return hotelid;	
	}

	public String getText_roomCountNIghtCountAndGuestCount_Lbl ()  {
		return generic.getText(roomCountNIghtCountAndGuestCount_Lbl);
	}
	
    
	public String getText_subTotal_Lbl (){
		return generic.getText(subTotal_Lbl);
	}

	
    public String getText_taxAmount_Lbl () {
    	return generic.getText(taxAmount_Lbl);
    }
    
    public String getText_taxPercent_Lbl () {
    	return generic.getText(taxPercent_Lbl);
    }
	
    public String getText_finalAmount_Lbl () {
    	return generic.getText(finalAmount_Lbl);
    }
    
    public String getText_couponCode_Txt () {
    	return generic.getText(couponCode_Txt);
    }
    
    
    public void click_couponCodeApply_Btn () {
    	generic.click(couponCodeApply_Btn);
    }
    
    
    public void click_removeCouponCode_Lbl () {
    	generic.click(removeCouponCode_Lbl);
    }
    
    
    public String getText_discountValue_Lbl () {
    	return generic.getText(discountValue_Lbl);
    }
    
    
    public String getText_couponCodeSuccessMssg_Lbl () {
    	return generic.getText(couponCodeSuccessMssg_Lbl);
    }
    
    public String getText_couponCodeErrorMssg_Lbl () {
    	return generic.getText(couponCodeErrorMssg_Lbl);
    }
   
    public String getText_taxPercentTitle_Lbl () {
    	return generic.getText(taxPercentTitle_Lbl);
    }
	
    
    public void click_reviewBookingContinue_btn () {
    	generic.click(reviewBookingContinue_btn);
    }
    
    
    public void sendKeys_coupon_applyCouponTextBtn (By couponApplyFillBox_Txt, String minimumOrderCoupon) {
    	generic.fill(couponApplyFillBox_Txt, minimumOrderCoupon);
    }
    
    
    public String getText_propertyName_Lbl () {
    	return generic.getText(propertyName_Lbl);
    }
    public String getText_propertyIdOnDetailsPage_WE () {
    	return generic.getAttributeValue(propertyDetailPageContianer_WE, "data-property-id");
    }
    
    
}
