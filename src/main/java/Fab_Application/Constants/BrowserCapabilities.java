package Fab_Application.Constants;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
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

	public static ChromeOptions WebChromeCapabilitiesList(){
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		
		return options;
	}
}
