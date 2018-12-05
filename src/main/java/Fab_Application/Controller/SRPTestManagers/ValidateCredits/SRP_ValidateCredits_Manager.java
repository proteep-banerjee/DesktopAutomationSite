package Fab_Application.Controller.SRPTestManagers.ValidateCredits;

import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Fab_Application.Controller.POM.SRPScreen.SRP_POM.*;

public class SRP_ValidateCredits_Manager {

    SoftAssert softAssert = new SoftAssert();

    public void ValidateCredits(WebDriver driver, ExtentTest logger) throws IOException {

        ReusableMethods.scrollToEndLoads(driver);

        ReusableMethods.scrollup(driver);

        List<String> creditsList = new ArrayList<String>();

        for(WebElement element : EarnCreditsList(driver, logger)){
            creditsList.add(element.getText());
        }

        softAssert.assertEquals(creditsList.size(), (listOfProperties(driver, logger).size()),
                "All properties do not contains fab credits on SRP");

        for(String credit : creditsList){
            softAssert.assertNotEquals(credit, "Earn 0 or more credits", "A property in the SRP contains 0 credits.");
        }

        softAssert.assertAll();
    }
}
