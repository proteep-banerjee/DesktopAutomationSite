package Fab_Application.Constants;

import org.openqa.selenium.By;

public class UiAddresses {

    //Login flow addresses
    public static By installAppClose = By.xpath(".//*[@class = 'InstallApp__CloseIcon']");
    public static By loginButton = By.xpath(".//*[text()='LOGIN']");
    public static By mobileNumberField = By.xpath(".//*[@class='login-credencial']/input");
    public static By continueButton = By.xpath(".//*[@class='login__button']");
    public static By otpField = By.xpath(".//*[@class='otp-input']");
    public static By getSatrtedButton = By.xpath(".//*[@class='login__button']");
    public static By homeButton = By.xpath(".//*[contains(@title, 'FabHotels:')]");

    //Home Page
    public static By CitySearchField = By.id("gp-input");
    public static By autosuggestionList = By.xpath(".//*[@class='SearchBox__pacItem']/div[2]/span[1]");
    public static By SearchButton = By.xpath("//div[text() = 'SEARCH']");

    // Calendar
    public static By checkinButton = By.xpath(".//*[text() = 'Check In']/..");
    public static By nextButton = By.xpath(".//*[@class = 'p-calendar']//div[contains(@class, 'p-next')]");
    public static By previousButton = By.xpath(".//*[@class = 'p-calendar']//div[contains(@class, 'p-prev')]");
    public static By calendarYear = By.xpath(".//*[@class = 'p-calendar']//div[contains(@class, 'p-title')]/span[3]");
    public static By calendarMonth = By.xpath(".//*[@class = 'p-calendar']//div[contains(@class, 'p-title')]/span[1]");
    public static By calendarDateList = By.xpath(".//*[@class = 'p-calendar']//div[@class='calendar__nextday']/dd");
    public static By DoneButton = By.xpath(".//*[text()='Done']");

    // SRP screen
    public static By couponTextCloseIcon = By.xpath("//span[@class = 'couponText__close']");
    public static By listOfProperties = By.xpath("//ul[@class='srp-list-wrap']/li//a");

    //PDP screen
    public static By EditButton = By.xpath("//span[text() = 'EDIT']");
    public static By BookNowButton = By.xpath("//a[text() = 'BOOK NOW']");

    //Payment screen
    public static By PayAtHotel = By.xpath("//span[contains(@class, 'payment-cta')]/preceding-sibling::div");




}
