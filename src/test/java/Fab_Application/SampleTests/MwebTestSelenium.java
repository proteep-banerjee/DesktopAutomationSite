package Fab_Application.SampleTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.PrintStream;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MwebTestSelenium {

    static WebDriver driver;

    @BeforeTest
    public void setup(){

        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", "Galaxy S5");

        Map<String, Object> chromeOptions = new HashMap<String, Object>();
        chromeOptions.put("mobileEmulation", mobileEmulation);

        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir")+"/Drivers/chromedriver.exe");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        driver = new ChromeDriver(capabilities);

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(priority = 0)
    public void launchUrl(){
        driver.get("https://uat.fabmailers.in");

        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement installAppClose = driver.findElement(By.xpath(".//*[@class = 'InstallApp__CloseIcon']"));

        wait.until(ExpectedConditions.visibilityOf(installAppClose)).click();
    }

    @Test(priority = 1)
    public void login() throws InterruptedException {

        driver.findElement(By.xpath(".//*[text()='LOGIN']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath(".//*[@class='login-credencial']/input")).
          sendKeys("9818274287");

        Thread.sleep(500);

        driver.findElement(By.xpath(".//*[@class='login__button']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath(".//*[@class='otp-input']")).
                sendKeys("123456");

        driver.findElement(By.xpath(".//*[@class='login__button']")).click();

        Thread.sleep(500);

        driver.findElement(By.xpath(".//*[contains(@title, 'FabHotels:')]")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void searchCity() throws InterruptedException {

        String cityName = "New Delhi";

        driver.findElement(By.id("gp-input")).sendKeys(cityName);
        Thread.sleep(3000);

        List<WebElement> lst = driver.findElements(By.xpath(".//*[@class='SearchBox__pacItem']/div[2]/span[1]"));

        for(WebElement elmnt : lst){
            if(elmnt.getText().equalsIgnoreCase(cityName)){
                elmnt.click();
                break;
            }
        }
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void selectDates() throws InterruptedException {

        String CheckinDate = "01-01-2019", checkoutDate = "10-March-2019", currentDate;

        //Open calendar
        driver.findElement(By.xpath(".//*[text() = 'Check In']/..")).click();

        // Fetching the current system date
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern
                ("dd-MM-yyyy", Locale.ENGLISH);
        currentDate = formatter.format(date);

        // Calendar Webelements
        WebElement nextButton = driver.findElement(By.xpath
                (".//*[@class = 'p-calendar']//div[contains(@class, 'p-next')]")),

                previousButton = driver.findElement(By.xpath
                        (".//*[@class = 'p-calendar']//div[contains(@class, 'p-prev')]")),

                calendarYear = driver.findElement(By.xpath
                        (".//*[@class = 'p-calendar']//div[contains(@class, 'p-title')]/span[3]"));

        WebElement calendarMonth = driver.findElement(By.xpath
                (".//*[@class = 'p-calendar']//div[contains(@class, 'p-title')]/span[1]"));

        int userInputCheckinYear = Integer.parseInt(CheckinDate.split("-")[2]);
        int userInputCheckinMonth = Integer.parseInt(CheckinDate.split("-")[1]);
        int userInputCheckinDate = Integer.parseInt(CheckinDate.split("-")[0]);

        int currentYear = Integer.parseInt(currentDate.split("-")[2]);
        int currentMonth = Integer.parseInt(currentDate.split("-")[1]);
        int Currentdate = Integer.parseInt(currentDate.split("-")[0]);

        if(userInputCheckinYear < currentYear){
            System.out.println("Please enter a valid date. " +
                    "Year should be the current year.");
            System.exit(-1);

        }

        if(userInputCheckinYear > currentYear){

            while(Integer.parseInt(calendarYear.getText()) != userInputCheckinYear){
                nextButton.click();
            }

            for(int i = 1; i < userInputCheckinMonth; i++){
                nextButton.click();
            }
        }

        if (currentYear == userInputCheckinYear){
            if(currentMonth > userInputCheckinMonth){
                System.out.println("Please enter a valid date. " +
                        "Month should be the current month or later.");
                System.exit(-1);
            }

            else if(currentMonth == userInputCheckinMonth){
                if(Currentdate < userInputCheckinDate){
                    System.out.println("Previous date selection is not allowed.");
                    System.exit(-1);
                }
            }

            else if(userInputCheckinMonth > currentMonth){
                for(int i = 1; i < (userInputCheckinMonth-currentMonth); i++){
                    nextButton.click();
                }
            }
        }

        Thread.sleep(1000);

        // Check In Date Selection

        WebElement calendarDate = driver.findElement(By.xpath
                ("//*[@class = 'p-calendar']//dd[text()='"+userInputCheckinDate+"']/.."));

        calendarDate.click();

        Thread.sleep(1000);

        String checkoutMonth = checkoutDate.split("-")[1];
        String checkoutYear = checkoutDate.split("-")[2];
        int userInputCheckoutDate = Integer.parseInt(checkoutDate.split("-")[0]);

        while(!(checkoutMonth.equalsIgnoreCase(calendarMonth.getText()) && checkoutYear.equalsIgnoreCase(calendarYear.getText()))){
            nextButton.click();
        }

        Thread.sleep(500);

        WebElement calendarcheckoutDate = driver.findElement(By.xpath
                ("//*[@class = 'p-calendar']//dd[text()='"+userInputCheckoutDate+"']/.."));

        calendarcheckoutDate.click();

        Thread.sleep(500);

        driver.findElement(By.xpath(".//*[text()='Done']")).click();

        Thread.sleep(5000);

    }

    @AfterTest
    public void TearDown(){
        driver.quit();
    }
}
