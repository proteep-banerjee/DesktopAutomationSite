package Fab_Application.Controller.PropertyDetailPage;

/**
 * Created By Kalpana.
 * Modified By Proteep.
 */

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static Fab_Application.Controller.POM.PropertyDetailPage.PDP_POM.BookNowButton;
import static Fab_Application.Controller.POM.PropertyDetailPage.PDP_POM.ContinueButton;

public class PDP_Manager_withoutValidations {

    /* This method just clicks on the book now button and the continue button on the PDP
    * to redirects the user to the next page.*/
    public void PDP_Redirection(WebDriver driver, ExtentTest logger) throws IOException {

        ReusableMethods.Click(driver, BookNowButton(driver, logger));
        ReusableMethods.scrollToEndLoads(driver);
        ReusableMethods.Click(driver,ContinueButton(driver,logger));

    }

    public String PDP_RedirectionAndUserType(WebDriver driver, ExtentTest logger) throws IOException {

        String userType = ReusableMethods.getText(driver, UiAddresses.PDP_userType, logger);

        String[] userTypeArr = userType.split(" | ");

        System.out.println("userType ");
        userType = userTypeArr[4].trim();

        System.out.println(userType);

        ReusableMethods.Click(driver, BookNowButton(driver, logger));

        return userType;

    }
}

