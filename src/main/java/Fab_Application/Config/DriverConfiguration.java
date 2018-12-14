package Fab_Application.Config;

public interface DriverConfiguration {

    // Driver path for windows.
    String chromeDriverPath = System.getProperty("user.dir")+"/Drivers/chromedriver.exe";
    String geckoDriverPath = System.getProperty("user.dir")+"/Drivers/geckodriver.exe";
    String operaDriverPath = System.getProperty("user.dir")+"/Drivers/operadriver.exe";
    String ieDriverPath = System.getProperty("user.dir")+"/Drivers/IEDriverServer.exe";

    // Driver path for mac
    String chromeDriverPath_mac = System.getProperty("user.dir")+"/Drivers/chromedriver";
    String geckoDriverPath_mac = System.getProperty("user.dir")+"/Drivers/geckodriver";
    String operaDriverPath_mac = System.getProperty("user.dir")+"/Drivers/operadriver";

    //Driver path for linux
    String getChromeDriverPath_linux = System.getProperty("user.dir")+"/Drivers/Linux/chromedriver";
}
