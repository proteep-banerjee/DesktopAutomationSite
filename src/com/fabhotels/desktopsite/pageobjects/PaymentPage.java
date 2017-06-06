package com.fabhotels.desktopsite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class PaymentPage {
	WebDriver driver;
	GenericFunctions generic;

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
	public static final By propertyName_Lbl = By.xpath("//div[contains(@class, 'property_name')]/h1");
	

	public PaymentPage(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
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
    
    
}
