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
    public static By loginScreen_bookingSideTab = By.xpath("//a[contains(@class,'bookings_tab')]");
    public static By loginScreen_profileSideTab = By.xpath("//a[@class='sidebar_inner_tab'][contains(text(),'Profile')]");
    public static By loginScreen_fabCreditsSideTab = By.xpath("//a[contains(text(),'Fab Credits')]");
    public static By loginScreen_AListMemebershipSideTab = By.xpath("//a[contains(text(),'A-List Membership')]");
    public static By loginScreen_verifyBookingTab = By.xpath("//a[@class='active']");
    public static By loginScreen_verifyProfileTab = By.xpath("//div[@class='btn loginOtp update_profile btn_style']");
    public static By loginScreen_verifyFabCreditsTab = By.xpath("//strong[@class='fab-point-top-desc-title']");
    public static By loginScreen_verifyAListMembershipTab = By.xpath("//span[contains(text(),'Membership Summary')]");
    public static By loginScreen_mobileNumberField = By.xpath("(//input[@class='mobile_number'])[2]");
    public static By loginScreen_continueButton = By.xpath("(//button[contains(text(),'CONTINUE')])[2]");
    public static By loginScreen_otpField = By.xpath("(.//input[@class = 'otp'])[2]");
    public static By loginScreen_getStartedButton = By.xpath("(//button[(text()='GET STARTED')][contains(@class,'login_after_otp')])[2]");//#
    public static By loginScreen_googleLogin = By.id("google-login-button");
    public static By loginScreen_facebookLogin = By.id("facebook-login-button");
    public static By loginScreen_invalidUsername = By.xpath("//p[@class='error-message login_error_msg']");
    public static By loginScreen_invalidOTP = By.xpath("(//span[contains(@class, 'otp_error_msg')])[2]");

    //Home Page
    public static By homeScreen_loginButton = By.xpath("//span[@class='login-reg login_register']");
    public static By homeScreen_CitySearchField = By.id("autocomplete-location");
    public static By homeScreen_autosuggestionList = By.xpath("//div[@class='pac-item']");
    public static By homeScreen_SearchButton = By.xpath("//button[@id='listingPageBtn']");
    public static By homeScreen_GuestList = By.xpath("//div[@class='select-dropdown-section']//span");
    public static By homeScreen_GuestSelected = By.xpath("//span[contains(@class,'guests_selected')]");
    public static By homeScreen_referFriendOption = By.xpath("//a[@href='/refer-and-earn']");
    public static By homeScreen_corporateEnquiryOption = By.xpath("//a[@class='corporate_enquiry']");
    public static By homeScreen_corporateEnquiry = By.xpath("//h2[contains(text(),'Corporate Panel')]");
    public static By homeScreen_beOurFranchiseOption = By.xpath("//li[@class='be_our_franchisee_top']/a");
    public static By homeScreen_beOurFranchiseOptionDown = By.xpath("//p[@class='medium-text']");
    public static By homeScreen_mobileNumberOnReferAFriend = By.xpath("//input[@placeholder='Enter Mobile Number']");
    public static By homeScreen_beOurFranchise = By.xpath("//p[@class='medium-text']");
    public static By homeScreen_OurLocationsList = By.xpath("//ul[@class='clearfix main-nav']/li");
    public static By homeScreen_moreCities = By.xpath("//a[contains(text(),'More cities')]");
    public static By homeScreen_getMoreCities = By.xpath("//div[@class='all-cities-link clearfix']/ul/li");
    public static By homeScreen_searchErrorWithoutLocation = By.xpath("//p[@class='error-message location_error_msg']");
    public static By homeScreen_verifyHomePageText = By.xpath("//div[@class='fab-home-title']//h1");
    public static By homeScreen_allLinks = By.tagName("a");
    public static By homeScreen_callOption = By.xpath("//a[contains(text(),'+91 70 4242 4242')]");
    public static By homeScreen_AListOption = By.xpath("//span[contains(text(),'A-List')]");
    public static By homeScreen_verifyAListOption = By.xpath("//div[@class='loyalty-banner-text']//h2");
    public static By homeScreen_referalCodeOptionBeforeLogin = By.xpath("//span[@class='text']");
    public static By homeScreen_mobileNumberOnReferal = By.xpath("//input[@class='mobile_number']");
    public static By homeScreen_continueButtonOnReferal = By.xpath("//button[@class='login-control login_continue']");
    public static By homeScreen_OTPOnReferal = By.xpath("//input[@class='otp']");
    public static By homeScreen_getStartedButtonOnReferal = By.xpath("//button[@class='login-control login_after_otp']");
    public static By homeScreen_referalCodeOptionAfterLogin = By.xpath("//span[@class='text referLink']");
    public static By homeScreen_socialMediaLinks = By.xpath("(//div[@class='social-btn-link'])[1]/ul/li/a");
    public static By homeScreen_getAllStaticLinks = By.xpath("//div[@class='links-menu clearfix']/ul/li");
    public static By homeScreen_aboutUs = By.xpath("//h2[contains(text(),'About Us')]");
    public static By homeScreen_careers = By.xpath("//span[contains(text(),'Careers')]");
    public static By homeScreen_press = By.xpath("//span[contains(text(),'Press')]");
    public static By homeScreen_blog = By.xpath("//a[contains(text(),'Home')]");
    public static By homeScreen_travelAgent = By.xpath("//a[@class='travel-agent-link']");
    public static By homeScreen_termsANdConditions = By.xpath("//h2[@class='static-sub-title']");
    public static By homeScreen_privacyPolicy = By.xpath("//h2[contains(text(),'Privacy Policy')]");
    public static By homeScreen_cancellationPolicy = By.xpath("//h2[contains(text(),'Cancellation and Refunds Policy')]");
    public static By homeScreen_FAQ = By.xpath("//h2[@class='static-sub-title']");
    public static By homeScreen_userType = By.xpath("//span[@class='user-type']");

    // Calendar
    public static By homeScreen_checkinButton = By.xpath("//input[@placeholder='Check-in Date']");
    public static By calendarYear = By.xpath(".//*[@class = 'p-calendar']//div[contains(@class, 'p-title')]/span[3]");
    public static By calendarMonth = By.xpath(".//*[@class = 'p-calendar']//div[contains(@class, 'p-title')]/span[1]");
    public static By calendarDateList = By.xpath(".//*[@class = 'p-calendar']//div[@class='calendar__nextday']/dd");
    public static By calendar_nextButton = By.xpath("//div[@class='datepicker-days']//th[@class='next']");
    public static By calendar_DoneButton = By.xpath(".//*[text()='Done']");
    public static By Calendar_CurrentDate = By.xpath("//td[@class='today day']");
    public static By Calendar_SameCheckOutDateAsCheckIn = By.xpath("//td[contains(@class,'today selected')]");
    public static By Calendar_NonSelectableDateList = By.xpath("//td[@class='disabled day']");
    public static By Calendar_CheckedInDate = By.xpath("//input[@placeholder='Check-in Date']");
    public static By Calendar_CheckedOutDate = By.xpath("//input[@placeholder='Check-out Date']");

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
