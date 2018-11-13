package Fab_Application.Constants;

import org.openqa.selenium.By;

public class UiAddresses {

    //Login flow addresses
    public static By loginScreen_mobileNumberField = By.xpath(".//*[@class='login-credencial']/input");
    public static By loginScreen_continueButton = By.xpath(".//*[@class='login__button']");
    public static By loginScreen_otpField = By.xpath(".//*[@class='otp-input']");
    public static By loginScreen_getSatrtedButton = By.xpath(".//*[@class='login__button']");
    public static By loginScreen_homeButton = By.xpath(".//*[contains(@title, 'FabHotels:')]");
    public static By loginScreen_googleLogin = By.id("google-login-button");
    public static By loginScreen_facebookLogin = By.xpath("//a[@id='google-login-button']/following-sibling::a");

    //Home Page
    public static By splashScreen_installAppClose = By.xpath(".//*[@class = 'InstallApp__CloseIcon']");
    public static By splashScreen_loginButton = By.xpath(".//*[text()='LOGIN']");
    public static By splashScreen_CitySearchField = By.id("gp-input");
    public static By splashScreen_autosuggestionList = By.xpath(".//*[@class='SearchBox__pacItem']/div[2]/span[1]");
    public static By splashScreen_SearchButton = By.xpath("//div[text() = 'SEARCH']");
    public static By splashScreen_GuestList = By.xpath("//span[text()='Guests']/following-sibling::select");

    // Calendar
    public static By splashScreen_checkinButton = By.xpath(".//*[text() = 'Check In']/..");
    public static By calendar_nextButton = By.xpath(".//*[@class = 'p-calendar']//div[contains(@class, 'p-next')]");
    public static By calendar_previousButton = By.xpath(".//*[@class = 'p-calendar']//div[contains(@class, 'p-prev')]");
    public static By calendarYear = By.xpath(".//*[@class = 'p-calendar']//div[contains(@class, 'p-title')]/span[3]");
    public static By calendarMonth = By.xpath(".//*[@class = 'p-calendar']//div[contains(@class, 'p-title')]/span[1]");
    public static By calendarDateList = By.xpath(".//*[@class = 'p-calendar']//div[@class='calendar__nextday']/dd");
    public static By calendar_DoneButton = By.xpath(".//*[text()='Done']");

    // SRP screen
    public static By couponTextCloseIcon = By.xpath("//span[@class = 'couponText__close']");
    public static By listOfProperties = By.xpath("//ul[@class='srp-list-wrap']/li//a");

    //PDP screen
    public static By PDP_EditButton = By.xpath("//span[text() = 'EDIT']");
    public static By PDP_BookNowButton = By.xpath("//a[text() = 'BOOK NOW']");
    public static By PDP_EditSelection = By.xpath("//div[@class='sc-fjdhpX ilFFcd']");
    public static By PDP_RedeemFabCredits = By.xpath("//span[contains(text(),'redeem Fab credits')]");
    public static By PDP_ViewAllRooms = By.xpath("//button[text()='VIEW ALL ROOMS']");
    public static By PDP_OpenMaps = By.xpath("//a[text()='Open Map']");
    public static By PDP_CancellationPolicy = By.xpath("//span[text()='Cancellation policy']");
    public static By PDP_ChildrenPolicy = By.xpath("//a[text()='Children policy']");
    public static By PDP_Check_In_out_timings = By.xpath("//span[contains(text(),'Check-in')]']");
    public static By PDP_ViewMore = By.xpath("//a[text()='View more']");
    public static By PDP_OpenAppButton = By.xpath("//a[text()='View more']");

    //Payment screen
    public static By PayAtHotel = By.xpath("//span[contains(@class, 'payment-cta')]/preceding-sibling::div");




}
