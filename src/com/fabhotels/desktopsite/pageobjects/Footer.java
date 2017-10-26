package com.fabhotels.desktopsite.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class Footer {

	WebDriver driver;
	GenericFunctions generic;

	public Footer(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}

	public static final String footerDiv_WE = "//footer[@class='footer']";

	public static final By fabhotels_AllElements_WE = By.xpath("//ul[@class='left_aligned_links']/li");
	public static final By policies_AllElements_WE = By.xpath("//ul[@class='center_aligned_links']/li");
	public static final By book_AllElements_WE = By.xpath("//ul[@class='right_aligned_links']/li");
	public static final By bottomBannerClose_Btn = By.xpath("//i[@class='we_close']");
	public static final By locationResult_Lbl = By.xpath("//h1[@class='propertyCount']");
	public static final By footerData_Lbl = By.xpath("//div[@class='footer_row fab-data']");
	public static final By keep_MePosted_btn = By.xpath("//input[@value='Keep me posted']");
	public static final By subscriberEmail_input = By.xpath("//input[@id='subscriberEmail']");

	public static final By subscriber_Email_Txt = By.id("subscriberEmail");
	public static final By subscribe_Btn = By.xpath("//input[@type='submit']");

	public static final By subscribe_placeholder_input = By.id("subscriberEmail");

	public static final By Subscribe_SuccessMssg_WE = By.xpath("//p[@class='success-message']");
	public static final By Subscribe_AlreadySubscribedMssg_WE = By.xpath("//p[@class='error-message']");
	public static final By Subscribe_WrongEmailMssg_WE = By.xpath("//p[@class='error-message']");
	public static final By hotels_listPage_WE=By.xpath("//div[contains(@class,'search-result-page')]");
	public static final By Search_hotels_near_you_Lnk=By.xpath("//div[@class='container search-result-page other-search-result']");
	public static final By copy_right=By.xpath("//span[@class='copy_right']");
	
	public static final String localityText_Lnk = "//a[contains(text(),'";
	public static final String staticText_Lnk = "//*[contains(text(),'";
	public static final String footerSection_WE = "(//div[contains(@class,'footer_row')])[";
	public static final String input_placeholder = "Your email address here. We never spam. Promise.";
	public static final String localCitieName1_Lnk = "//a[contains(text(),'";
	public static final String localCitieName2_Lnk = "')]/following::span[1]//a";
	public static final String homePage_title = "Best Budget Hotels in India: FabHotels";
	public static final String popular_localities_footer_Lbl = "//div[@class='popular-localities']//strong[text()='";
	public static final String subscribe_placeholder_msg = "Your email address here. We never spam. Promise.";
	
	public List<WebElement> getLocalityName_Link(String cityName) {
		return generic.findElements(By.xpath(localCitieName1_Lnk + cityName + localCitieName2_Lnk));
	}

	public String getSearchResultPlace() {
		return generic.getText(locationResult_Lbl).split("in and around |in |near ")[1].trim();
	}

	public void clickLink(String name) {
		generic.click(footerDiv_WE + localityText_Lnk + name + "')]");
		generic.goToSleep(1000);
	}

	public String footerSection(int index) {
		return footerSection_WE + index + "]";
	}

	public String popularLocalities_Lbl(String localityLable) {
		return popular_localities_footer_Lbl + localityLable + "']";
	}

	public String return_copy_rightText() {
		return generic.getText(copy_right);
	}

	public int return_footer_RowCount() {
		return generic.getSize(By.xpath(footerSection_WE + '*' + "]"));
	}

	public void fill_subscriber_Email_Txt(String input) {
		generic.fill(subscriber_Email_Txt, input);
	}

	public void click_subscribe_Btn() {
		generic.click(subscribe_Btn);
	}
}
