package Fab_Application.Constants;

import java.util.HashMap;
import java.util.Map;

public interface Constants {

    // Add mobile emultion capabilities to chrome browser
    static Map<String, Object> mobileWebCapabilities(String deviceName){
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", deviceName);

        Map<String, Object> optionlist = new HashMap<String, Object>();
        optionlist.put("mobileEmulation", mobileEmulation);

        return optionlist;
    }

}
