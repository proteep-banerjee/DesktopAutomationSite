package Fab_Application.Constants;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class BrowserCapabilities {

    private static String BrowserName;

    public static DesiredCapabilities CapabilitiesList(Map<String, Object> optionsList,
                                                String browserName){

        DesiredCapabilities capabilities = null;
        BrowserName = browserName;
        if(BrowserName.equalsIgnoreCase("Chrome")){
            capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, optionsList);
        }
        return capabilities;
    }
}
