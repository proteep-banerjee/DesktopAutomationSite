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
    public static By SRP_couponTextCloseIcon = By.xpath("//span[@class = 'couponText__close']");
    public static By SRP_listOfProperties = By.xpath("//ul[@class='srp-list-wrap']/li//h4");
    public static By SRP_SortButton = By.className("srp-filter-sort-by");
    public static By SRP_FiltersButton = By.className("srp-fiters-text");
    public static By SRP_PropertyPricesList = By.xpath("//span[contains(text(),'Price/night. Ex GST')]/following-sibling::div/div[2]");
    public static By SRP_HeaderEditBox = By.className("header__searchHeaderEditBox");
    public static By SRP_SubscribeButton = By.xpath("//button[text() = 'SUBSCRIBE']");
    public static By SRP_BackToTop = By.className("backtotop");
    public static By SRP_SoldOutProperties = By.xpath("//div[text()='Sold out']");
    public static By SRP_SearchDetails_City = By.className("header__editSearchCity");
    public static By SRP_SearchDetails_Date = By.className("header__editSearchDate");
    public static By SRP_SearchDetails_Guest = By.className("header__editSearchGuest");
    public static By SRP_RatingStars = By.xpath("//li//h4/..//div/span");
    public static By SRP_RatingReviews = By.xpath("//li//h4/..//div/span/following-sibling::strong");
    public static By SRP_CoupleFriendlyLabel = By.xpath("//span[text()= 'Couple Friendly']");
    public static By SRP_RackPricesList = By.xpath("//span[contains(text(),'Price/night. Ex GST')]/following-sibling::div/div[1]");
    public static By SRP_ReviewCountList = By.xpath("//li//h4/..//div/span/..");
    public static By SRP_FreeBreakfast = By.xpath("//span[text() = 'FREE Breakfast']");
    public static By SRP_EarnCredits = By.xpath("//strong[contains(text(),'credits')]");


    // SRP Edit Details Modal
    public static By SRP_EditDetails_SearchField = By.id("gp-input");
    public static By SRP_EditDetails_ClearField = By.xpath("//span[text()='CLEAR']");
    public static By SRP_EditDetails_CalendarCheckIn = By.className("checkin");
    public static By SRP_EditDetails_SearchButton = By.xpath("//div[text()='SEARCH']");
    public static By SRP_EditDetails_GuestPlusButton = By.className(" bplus");
    public static By SRP_EditDetails_GuestMinusButton = By.className(" bminus");
    public static By SRP_EditDetails_AutosuggestionList = By.xpath("//div[@class='SearchBox__pacItem']/div[2]/span[1]");

    // SRP Sort Modal
    public static By SRP_SortModal_RecommendedSort = By.xpath("//ul[@class='header__sortModalList']/li[1]");
    public static By SRP_SortModal_PriceDesc = By.xpath("//ul[@class='header__sortModalList']/li[@value='price_desc']");
    public static By SRP_SortModal_PriceAsc = By.xpath("//ul[@class='header__sortModalList']/li[@value='price_asc']");


    //Filter Screen
    public static By Filter_ResetButton = By.xpath("//span[text() = 'Reset All']");
    public static By Filter_PriceSlider = By.xpath("//div[@role = 'slider']");
    public static By Filter_PriceSliderTooltip = By.className("rc-slider-tooltip-inner");
    public static By Filter_CoupleFriendlyPolicy = By.xpath("//label[text()='Couple Friendly']");
    public static By Filter_Occupancy = By.xpath("//h3[text()='Occupancy']/following-sibling::div/span");
    public static By Filter_ApplyFilter = By.xpath("//button/span[contains(text(), 'VIEW' )]");
    public static By Filter_StandardAmenitiesSection = By.xpath("//div[@class='Filters__standard-amenities-list']");
    public static By Filter_AmenitiesSection = By.xpath("//h3[text()='Amenities']");
    public static By Filter_OccupancySection = By.xpath("//h3[text()='Occupancy']");
    public static By Filter_PoliciesSection = By.xpath("//h3[text()='Policies']");
    public static By Filter_PricepernightSection = By.xpath("//h3[text()='Price/night']");
    public static By Filter_LocalitySection = By.xpath("//h3[text()='Popular Localities']");

    //PDPScreen screen
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
