package com.fabhotels.desktopsite.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class OtpProvider {
	WebDriver driver;
	GenericFunctions generic = new GenericFunctions(driver);

	public OtpProvider(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}

	String message = "(//td[contains(text(),'FABHTL')])[1]/following-sibling::*[1]";
	String timeAfterMsgRecieved = "(//td[contains(text(),'FABHTL')])[1]/following-sibling::*[2]";
	String secondsIndication = "(//td[contains(text(),'FABHTL')])[1]/following-sibling::*[contains(text(),'seconds')]";
	String Number = "9654788525";
	String url = "https://www.receive-sms-online.info/read-sms.php?phone=91" + Number;

	public String getOTPNumber() {
		return generic.getText(By.xpath(message)).split(" ")[0];
	}

	public boolean timeTook() {
		String time = generic.getText(By.xpath(timeAfterMsgRecieved)).split(" ")[1];
		if (time.equalsIgnoreCase("seconds")) {
			return true;
		} else
			return false;
	}

	public String getvalidOtpNumber() {
		long startedTime = System.currentTimeMillis();
		generic.goToSleep(2000);
		while (!generic.isVisible(secondsIndication) && (System.currentTimeMillis() - startedTime) < 25000) {
			generic.refreshPage();
			generic.waitForCompletePageLoad();
		}
		if (timeTook()) {
			return getOTPNumber();
		} else {
			Assert.assertTrue("OTP NOT RECIVED , its been 20 Seconds", false);
		}
		return null;

	}

	public String getOtp() {
		String otp = "";
		((JavascriptExecutor) driver).executeScript("window.open()");
		generic.switchtoNewWindow();
		generic.loadURL(url);
		otp = getvalidOtpNumber();
		generic.closeNewWindow();
		generic.SwitchtoOriginalWindow();
		System.out.println("OTP is :" + otp);
		return otp;
	}

}
