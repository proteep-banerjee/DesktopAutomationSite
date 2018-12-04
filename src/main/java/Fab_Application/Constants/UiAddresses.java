package Fab_Application.Constants;

import org.openqa.selenium.By;

public class UiAddresses {

    //Login flow addresses
    public static By loginScreen_homeButton = By.xpath(".//*[contains(@title, 'FabHotels:')]");
    public static By loginScreen_login_SignUpText = By.xpath("//span[@class='log-in']");
    public static By loginScreen_verifyLoginPage = By.xpath("//span[@class='my-account-title']");
    public static By loginScreen_toggleButton = By.xpath("//div[contains(@class,'headerLeftMenu')]");
    public static By loginScreen_logoutButton = By.xpath("//span[contains(text(),'Log out')]");
    public static By loginScreen_logoutPopup = By.xpath("//span[text()='LOGOUT']");
    public static By loginScreen_booking_ongoingBooking = By.xpath("//a[contains(text(),'Ongoing')]");
    public static By loginScreen_beOurFranchise = By.xpath("//div[contains(@class,'large-message')]");
    public static By loginScreen_yourMemberShip = By.xpath("//div[@class='prime-membership']/h3");
    public static By loginScreen_referAFriend = By.xpath("//div[contains(@class,'invitation')]/h5");
    public static By loginScreen_aboutUs = By.xpath("//div[@class='content__bx']/h3");
    public static By loginScreen_termAndConditions = By.xpath("//div[contains(@class,'term-condition')]/h3");
    public static By loginScreen_FAQ = By.xpath("//div[text()='General']");
    public static By loginScreen_cancellationPolicy = By.xpath("//div[@class='content__bx']/h3");
    //public static By loginScreen_sideTabs = By.xpath("//ul[@class='clearfix sidebar_tabs']/li");
    public static By loginScreen_bookingSideTab = By.xpath("//a[contains(@class,'bookings_tab')]");
    public static By loginScreen_profileSideTab = By.xpath("//a[@class='sidebar_inner_tab'][contains(text(),'Profile')]");
    public static By loginScreen_fabCreditsSideTab = By.xpath("//a[contains(text(),'Fab Credits')]");
    public static By loginScreen_AListMemebershipSideTab = By.xpath("//a[contains(text(),'A-List Membership')]");
    public static By loginScreen_verifyBookingTab = By.xpath("//a[@class='active']");
    public static By loginScreen_verifyProfileTab = By.xpath("//div[@class='btn loginOtp update_profile btn_style']");
    public static By loginScreen_verifyFabCreditsTab = By.xpath("//strong[@class='fab-point-top-desc-title']");
    public static By loginScreen_verifyAListMembershipTab = By.xpath("//span[contains(text(),'Membership Summary')]");




    //Kalpana
    public static By loginScreen_mobileNumberField = By.xpath("(//input[@class='mobile_number'])[2]");
    public static By loginScreen_continueButton = By.xpath("(//button[contains(text(),'CONTINUE')])[2]");
    public static By loginScreen_otpField = By.xpath("(.//input[@class = 'otp'])[2]");
    public static By loginScreen_getStartedButton = By.xpath("(//button[(text()='GET STARTED')][contains(@class,'login_after_otp')])[2]");//#
    public static By loginScreen_googleLogin = By.id("google-login-button");
    public static By loginScreen_facebookLogin = By.id("facebook-login-button");
    public static By loginScreen_invalidUsername = By.xpath("//p[@class='error-message login_error_msg']");
    public static By loginScreen_invalidOTP = By.xpath("(//span[contains(@class, 'otp_error_msg')])[2]");
    public static By loginScreen_LogoutButton = By.xpath("//span[contains(text(),'Log out')]");
    public static By loginScreen_logoutPopUp = By.xpath("//span[contains(@class,'logout_ok_close')]");


    //##########

    //Home Page
    public static By splashScreen_installAppClose = By.xpath(".//*[@class = 'InstallApp__CloseIcon']");
    public static By splashScreen_loginButton = By.xpath("//span[contains(@class,'login-reg')]");
    public static By splashScreen_CitySearchField = By.id("autocomplete-location");
    public static By splashScreen_autosuggestionList = By.xpath("//div[@class='pac-item']");
    public static By splashScreen_SearchButton = By.xpath("//button[@id='listingPageBtn']");
    public static By splashScreen_GuestList = By.xpath("//div[@class='select-dropdown-section']//span");
    public static By splashScreen_GuestSelected = By.xpath("//span[contains(@class,'guests_selected')]");
    public static By splashScreen_menuTopThreeOptions = By.xpath("//ul[@class='menu-top']/li");

    public static By getSplashScreen_referFriendOption = By.xpath("//a[@href='/refer-and-earn']");
    public static By getSplashScreen_corporateEnquiryOption = By.xpath("//a[@class='corporate_enquiry']");
    public static By getSplashScreen_beOurFranchiseOption = By.xpath("//li[@class='be_our_franchisee_top']/a");
    public static By getSplashScreen_mobileNumberOnReferAFriend = By.xpath("//input[@placeholder='Enter Mobile Number']");
    public static By getSplashScreen_corporateEnquiry = By.xpath("//h2[contains(text(),'Corporate Panel')]");
    public static By getSplashScreen_beOurFranchise = By.xpath("//p[@class='medium-text']");
    //public static By getSplashScreen_AllCarousalCities = By.xpath("//small[@class='nearme__aboutCity']");
    //public static By getSplashScreen_OurLocations = By.xpath("//*[text()=' Our locations']");
    public static By getSplashScreen_OurLocationsList = By.xpath("//ul[@class='clearfix main-nav']/li");
    public static By getSplashScreen_moreCities = By.xpath("//a[contains(text(),'More cities')]");
    public static By getSplashScreen_getMoreCities = By.xpath("//div[@class='all-cities-link clearfix']/ul/li");
   // public static By getSplashScreen_toggleButton = By.xpath("//div[contains(@class,'headerLeftMenu')]");
    //public static By getSplashScreen_nearbyHotelTag = By.xpath("//span[@class='SearchBox__findHotelNearMe SearchBox__bounce']");
    //public static By getSplashScreen_searchButton = By.xpath("//div[text()='SEARCH']");
    public static By getSplashScreen_searchErrorWithoutLocation = By.xpath("//p[@class='error-message location_error_msg']");
    public static By getSplashScreen_verifyHomePageText = By.xpath("//div[@class='fab-home-title']//h1");
    public static By getSplashScreen_allLinks = By.tagName("a");
    public static By getSplashScreen_callOption = By.xpath("//a[contains(text(),'+91 70 4242 4242')]");
    public static By getSplashScreen_AListOption = By.xpath("//span[contains(text(),'A-List')]");
    public static By getSplashScreen_verifyAListOption = By.xpath("//div[@class='loyalty-banner-text']//h2");


    // Calendar
    public static By splashScreen_checkinButton = By.xpath("//input[@placeholder='Check-in Date']");
    public static By splashScreen_checkiInDate = By.xpath("//td[contains(@class,'today active')]");
    public static By calendar_nextButton = By.xpath(".//*[@class = 'p-calendar']//div[contains(@class, 'p-next')]");
    public static By calendar_previousButton = By.xpath(".//*[@class = 'p-calendar']//div[contains(@class, 'p-prev')]");
    public static By calendarYear = By.xpath(".//*[@class = 'p-calendar']//div[contains(@class, 'p-title')]/span[3]");
    public static By calendarMonth = By.xpath(".//*[@class = 'p-calendar']//div[contains(@class, 'p-title')]/span[1]");
    public static By calendarDateList = By.xpath(".//*[@class = 'p-calendar']//div[@class='calendar__nextday']/dd");
    public static By calendar_DoneButton = By.xpath(".//*[text()='Done']");
    public static By calendar_DateList = By.xpath("//*[@class = 'p-calendar']//div[@class='calendar__nextday']/dd");
    public static By Calendar_CurrentDate = By.xpath("//td[@class='today day']");
    public static By Calendar_SameCheckOutDateAsCheckIn = By.xpath("//td[contains(@class,'today selected')]");
    public static By Calendar_NonSelectableDateList = By.xpath("//td[@class='disabled day']");
    public static By Calendar_CheckedInDate = By.xpath("//input[@placeholder='Check-in Date']");
    public static By Calendar_CheckedOutDate = By.xpath("//input[@placeholder='Check-out Date']");
    public static By Calendar_expiredDate = By.xpath("//div[@class='calendar__entity calendar__prevday']");



    // SRP screen
    public static By SRP_couponTextCloseIcon = By.xpath("//span[@class = 'couponText__close']");
    public static By SRP_listOfProperties = By.xpath("//li[@class = ' hotel_card ']//h3[@class = 'hotel-name']/a");
    public static By SRP_SortButton = By.xpath("//span[@class = 'price-arrow ']");
    public static By SRP_FiltersButton = By.className("srp-fiters-text");
    public static By SRP_PropertyPricesList = By.xpath("//li[@class = ' hotel_card ']//span[@class = 'discounted-price']");
    public static By SRP_HeaderEditBox = By.className("header__searchHeaderEditBox");
    public static By SRP_SubscribeButton = By.xpath("//button[text() = 'SUBSCRIBE']");
    public static By SRP_BackToTop = By.className("backtotop");
    public static By SRP_SoldOutProperties = By.xpath("//div[text()='Sold out']");
    public static By SRP_SearchDetails_City = By.className("header__editSearchCity");
    public static By SRP_SearchDetails_Date = By.className("header__editSearchDate");
    public static By SRP_SearchDetails_Guest = By.className("header__editSearchGuest");
    public static By SRP_RatingStars = By.xpath("//li[@class = ' hotel_card ']//span[@class = 'rating-value']");
    public static By SRP_RatingReviews = By.xpath("//li[@class = ' hotel_card ']//span[@class = 'rating-text']");
    public static By SRP_CoupleFriendlyLabel = By.xpath("//span[text()= 'Couple Friendly']");
    public static By SRP_RackPricesList = By.xpath("//li[@class = ' hotel_card ']//span[@class = 'room-price']");
    public static By SRP_ReviewCountList = By.xpath("//li[@class = ' hotel_card ']//div[@class='rating-review']");
    public static By SRP_FreeBreakfast = By.xpath("//li[@class = ' hotel_card ']//div[@class = 'additional-discount']");
    public static By SRP_EarnCredits = By.xpath("//li[@class = ' hotel_card ']//span[@class = 'max-earning-msg']");
    public static By SRP_BackButton = By.xpath("//div[@class='sc-jTzLTM hJRnVL']");
    public static By SRP_SavedPriceAmount = By.xpath("//li[@class = ' hotel_card ']//span[@class = 'save-rupees']");
    public static By SRP_FooterBanner = By.xpath("//div[@class = 'fab-stay-coupan fab_stay_coupon ']//span[@class = 'cross-icon cross_icon']");


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
    public static By SRP_SortModal_PriceDesc = By.xpath("//span[@class='price-arrow high-to-low']");
    public static By SRP_SortModal_PriceAsc = By.xpath("//span[@class='price-arrow low-to-high']");


    //Filter Screen
    public static By Filter_ResetButton = By.xpath("//span[text() = 'Reset All']");
    public static By Filter_PriceSliderLeft = By.xpath("//div[@class = 'range-slider']//div[@class = 'range-caret range-left']");
    public static By Filter_PriceSliderRight = By.xpath("//div[@class = 'range-slider']//div[@class = 'range-caret range-right']");
    public static By Filter_LeftPriceSliderTooltip = By.xpath("//div[@class = 'price-container']//span[@class = 'display_min_price']");
    public static By Filter_RightPriceSliderTooltip = By.xpath("//div[@class = 'price-container']//span[@class = 'display_max_price']");
    public static By Filter_CoupleFriendlyPolicy = By.xpath("//label[text() = 'Couple Friendly ']");
    public static By Filter_Occupancy = By.xpath("//h3[text()='Occupancy']/following-sibling::div/span");
    public static By Filter_ApplyFilter = By.xpath("//button/span[contains(text(), 'VIEW' )]");
    public static By Filter_StandardAmenitiesSection = By.xpath("//div[@class = 'standard-amenities']");
    public static By Filter_AmenitiesSection = By.id("room_amenities_filter");
    public static By Filter_OccupancySection = By.id("max_guest_filter");
    public static By Filter_PoliciesSection = By.id("policy_filter']");
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
