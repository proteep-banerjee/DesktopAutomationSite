package Fab_Application.Controller.BookingFlow.SearchResultPage;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

import static Fab_Application.Controller.POM.SRPScreen.SRP_POM.*;


public class SRP_Manager {

	public void Validate_TC(WebDriver driver, String PropertyName, ExtentTest logger) throws IOException, InterruptedException {


		ReusableMethods.scrollToEndLoads(driver);
		ReusableMethods.wait(2);

		boolean prop = false;

		for(WebElement property : listOfProperties(driver, logger)) {
			String Property = property.getText();

			if (Property.toLowerCase().contains(PropertyName.toLowerCase())) {

				prop = true;

				ReusableMethods.scrollIntoView(driver, property);

				System.out.println("Scrolled to property, Clicking now ");  
				ReusableMethods.wait(8);

				((JavascriptExecutor) driver).executeScript ("window.scrollBy(0,-500)");
				System.out.println("Scrolled ");
				ReusableMethods.wait(5);

				ReusableMethods.Click(driver, property);

				System.out.println("Clicked on prop ");

				break;
			}}
		System.out.println("Prop result " +prop);

	}
}
