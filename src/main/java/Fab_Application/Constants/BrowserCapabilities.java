package Fab_Application.Constants;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class BrowserCapabilities {

    public static DesiredCapabilities MWebCapabilitiesList(Map<String, Object> optionsList,
                                                String browserName){

        DesiredCapabilities capabilities = null;

        if(browserName.equalsIgnoreCase("Chrome")){
            capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, optionsList);
        }
        return capabilities;
    }
}
