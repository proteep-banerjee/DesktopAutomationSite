package Fab_Application.Controller.BookingFlow.SearchResultPage;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SRP_Manager {

    public void Validate_TC(WebDriver driver, String PropertyName){

        try{

            ReusableMethods.FindElement(driver, UiAddresses.couponTextCloseIcon).click();

            List<WebElement> listOfProperties = ReusableMethods.FindElements(driver, UiAddresses.listOfProperties);

            for(WebElement property : listOfProperties){
                String Property = property.getAttribute("aria-label");
                if(Property.toLowerCase().contains(PropertyName.toLowerCase())){

                    ((JavascriptExecutor) driver).executeScript
                            ("arguments[0].scrollIntoView(true);", property);

                    Thread.sleep(1000);

                    property.click();
                    break;
                }
            }

        }
        catch(Exception e){

            e.printStackTrace();
        }
    }
}
