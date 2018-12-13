package Fab_Application.Controller.SearchResultPage;


/**
 * Created By - Kalpana
 */

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static Fab_Application.Controller.POM.SRPScreen.SRP_POM.listOfProperties;


public class SRP_Manager_withoutValidations {

    /*This method simply clicks on a particular property on the SRP and redirects the user
     * to the PDP.*/
	public void SRP_Redirection(WebDriver driver, String PropertyName, ExtentTest logger) throws IOException, InterruptedException {

		ReusableMethods.scrollToEndLoads(driver);
		ReusableMethods.wait(2);

		for(WebElement property : listOfProperties(driver, logger)) {
			String Property = property.getText();

			if (Property.toLowerCase().contains(PropertyName.toLowerCase())) {

				ReusableMethods.scrollIntoView(driver, property);

				System.out.println("Scrolled to property, Clicking now ");  
				ReusableMethods.wait(3);

				((JavascriptExecutor) driver).executeScript ("window.scrollBy(0,-500)");
				System.out.println("Scrolled ");

				ReusableMethods.wait(3);

				ReusableMethods.Click(driver, property);
				System.out.println("Clicked on prop ");

				break;
			}
		}

	}
}
