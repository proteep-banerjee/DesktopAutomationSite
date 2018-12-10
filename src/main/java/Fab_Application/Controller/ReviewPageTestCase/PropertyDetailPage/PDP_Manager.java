package Fab_Application.Controller.ReviewPageTestCase.PropertyDetailPage;

import Fab_Application.Constants.UiAddresses;
import Fab_Application.Utilities.ReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


import static Fab_Application.Controller.POM.PropertyDetailPage.PDP_POM.*;

public class PDP_Manager {

    public String Validate_TC(WebDriver driver, ExtentTest logger) throws IOException {

    	String userType = ReusableMethods.getText(driver, UiAddresses.PDP_userType, logger);
    	
    	String[] userTypeArr = userType.split(" | ");
    	
    	System.out.println("userType ");
    	userType = userTypeArr[4].trim();
    	
    	System.out.println(userType);
    	
        ReusableMethods.Click(driver, BookNowButton(driver, logger));
        
        return userType;

    }
}

