package Fab_Application.Config;

public interface DriverConfiguration {

    String chromeDriverPath = System.getProperty("user.dir")+"/Drivers/chromedriver.exe";
    String geckoDriverPath = System.getProperty("user.dir")+"/Drivers/geckodriver.exe";
    String operaDriverPath = System.getProperty("user.dir")+"/Drivers/operadriver.exe";
    String ieDriverPath = System.getProperty("user.dir")+"/Drivers/IEDriverServer.exe";
}
