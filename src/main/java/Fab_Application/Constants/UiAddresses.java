package Fab_Application.Constants;

import org.openqa.selenium.By;

public class UiAddresses {

    //Login flow addresses
    public static By loginScreen_homeButton = By.xpath(".//*[contains(@title, 'FabHotels:')]");
    public static By loginScreen_verifyLoginPage = By.xpath("//span[@class='my-account-title']");
    public static By loginScreen_toggleButton = By.xpath("//div[contains(@class,'headerLeftMenu')]");
    public static By loginScreen_logoutButton = By.xpath("//span[contains(text(),'Log out')]");
    public static By loginScreen_logoutPopup = By.xpath("//span[text()='LOGOUT']");
    public static By loginScreen_bookingSideTab = By.xpath("//a[contains(@class,'bookings_tab')]");
    public static By loginScreen_profileSideTab = By.xpath("//a[@class='sidebar_inner_tab'][contains(text(),'Profile')]");
    public static By loginScreen_fabCreditsSideTab = By.xpath("//a[contains(text(),'Fab Credits')]");
    public static By loginScreen_AListMemebershipSideTab = By.xpath("//a[contains(text(),'A-List Membership')]");

    //Kalpana
    public static By loginScreen_mobileNumberField = By.xpath("(//input[@class='mobile_number'])[2]");
    public static By loginScreen_continueButton = By.xpath("(//button[contains(text(),'CONTINUE')])[2]");
    public static By loginScreen_otpField = By.xpath("(.//input[@class = 'otp'])[2]");
    public static By loginScreen_getStartedButton = By.xpath("(//button[(text()='GET STARTED')][contains(@class,'login_after_otp')])[2]");//#
    public static By loginScreen_googleLogin = By.id("google-login-button");
    public static By loginScreen_facebookLogin = By.id("facebook-login-button");
    public static By loginScreen_invalidUsername = By.xpath("//p[@class='error-message login_error_msg']");
    public static By loginScreen_invalidOTP = By.xpath("(//span[contains(@class, 'otp_error_msg')])[2]");


    //##########

    //Home Page
    public static By splashScreen_CitySearchField = By.id("autocomplete-location");
    public static By splashScreen_autosuggestionList = By.xpath("//div[@class='pac-item']");
    public static By splashScreen_SearchButton = By.xpath("//button[@id='listingPageBtn']");

    // Calendar
    public static By splashScreen_checkinButton = By.xpath("//input[@placeholder='Check-in Date']");
    public static By calendar_nextButton = By.xpath(".//*[@class = 'p-calendar']//div[contains(@class, 'p-next')]");
    public static By calendarYear = By.xpath(".//*[@class = 'p-calendar']//div[contains(@class, 'p-title')]/span[3]");
    public static By calendarMonth = By.xpath(".//*[@class = 'p-calendar']//div[contains(@class, 'p-title')]/span[1]");
    public static By calendarDateList = By.xpath(".//*[@class = 'p-calendar']//div[@class='calendar__nextday']/dd");
    public static By calendar_DoneButton = By.xpath(".//*[text()='Done']");


    // SRP screen
    public static By SRP_listOfProperties = By.xpath("//li[@class = ' hotel_card ']//h3[@class = 'hotel-name']/a");
    public static By SRP_listOfNearbyProperties = By.xpath("//div[@class = 'nearby-heading']/following-sibling::ul[@class = 'hotel-card-wrapper clearfix']/li");
    public static By SRP_SortButton = By.xpath("//span[@class = 'price-arrow ']");
    public static By SRP_PropertyPricesList = By.xpath("//li[@class = ' hotel_card ']//span[@class = 'discounted-price']");
    public static By SRP_SoldOutProperties = By.xpath("//li[@class = 'soldout hotel_card ']");
    public static By SRP_SearchDetails_Date = By.className("header__editSearchDate");
    public static By SRP_SearchDetails_Guest = By.className("header__editSearchGuest");
    public static By SRP_RatingStars = By.xpath("//li[@class = ' hotel_card ']//span[@class = 'rating-value']");
    public static By SRP_RatingReviews = By.xpath("//li[@class = ' hotel_card ']//span[@class = 'rating-text']");
    public static By SRP_CoupleFriendlyLabel = By.xpath("//span[text()= 'Couple Friendly']");
    public static By SRP_RackPricesList = By.xpath("//li[@class = ' hotel_card ']//span[@class = 'room-price']");
    public static By SRP_ReviewCountList = By.xpath("//li[@class = ' hotel_card ']//div[@class='rating-review']");
    public static By SRP_FreeBreakfast = By.xpath("//li[@class = ' hotel_card ']//div[@class = 'additional-discount']");
    public static By SRP_EarnCredits = By.xpath("//li[@class = ' hotel_card ']//span[@class = 'max-earning-msg']");
    public static By SRP_SavedPriceAmount = By.xpath("//li[@class = ' hotel_card ']//span[@class = 'save-rupees']");
    public static By SRP_FooterBanner = By.xpath("//div[@class = 'fab-stay-coupan fab_stay_coupon ']//span[@class = 'cross-icon cross_icon']");
    public static By SRP_AppliedFilterList = By.xpath("//ul[@id = 'top_filters_section']/li");
    public static By SRP_AppliedFiltersCloseIcon = By.xpath("//ul[@id = 'top_filters_section']/li/span[contains(@class, 'close')]");


    // SRP Edit Details Modal
    public static By SRP_EditDetails_SearchField = By.id("gp-input");
    public static By SRP_EditDetails_CalendarCheckIn = By.className("checkin");
    public static By SRP_EditDetails_SearchButton = By.xpath("//div[text()='SEARCH']");
    public static By SRP_EditDetails_GuestPlusButton = By.className(" bplus");
    public static By SRP_EditDetails_AutosuggestionList = By.xpath("//div[@class='SearchBox__pacItem']/div[2]/span[1]");

    // SRP Sort Modal
    public static By SRP_SortModal_PriceAsc = By.xpath("//span[@class='price-arrow low-to-high']");


    //Filter Screen
    public static By Filter_ResetButton = By.id("clear_all");
    public static By Filter_PriceSliderLeft = By.xpath("//div[@class = 'range-slider']//div[@class = 'range-caret range-left']");
    public static By Filter_PriceSliderRight = By.xpath("//div[@class = 'range-slider']//div[@class = 'range-caret range-right']");
    public static By Filter_LeftPriceSliderTooltip = By.xpath("//div[@class = 'price-container']//span[@class = 'display_min_price']");
    public static By Filter_RightPriceSliderTooltip = By.xpath("//div[@class = 'price-container']//span[@class = 'display_max_price']");
    public static By Filter_CoupleFriendlyPolicy = By.xpath("//label[text() = 'Couple Friendly ']/div");
    public static By Filter_Occupancy = By.xpath("//div[@id = 'max_guest_filter']//label/div");
    public static By Filter_StandardAmenitiesSection = By.xpath("//div[@class = 'standard-amenities']");
    public static By Filter_AmenitiesSection = By.id("room_amenities_filter");
    public static By Filter_OccupancySection = By.id("max_guest_filter");
    public static By Filter_PoliciesSection = By.id("policy_filter");
    public static By Filter_PricepernightSection = By.xpath("//div[@class = 'price-container']");
    public static By Filter_LocalitySection = By.id("popular_locality_filter");
    public static By Filter_TransportationSection = By.id("transportation_filter");

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
