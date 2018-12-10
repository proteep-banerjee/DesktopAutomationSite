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
    public static By loginScreen_googleLogin = By.id("google-login-button");
    public static By loginScreen_facebookLogin = By.id("facebook-login-button");
    public static By loginScreen_mobileNumberField = By.xpath("//div[@id='social-login-container']/following-sibling :: div[contains(@class,'login-credencial')]//input[@class='mobile_number']");
    public static By loginScreen_continueButton = By.xpath("//div[contains(@class,'referral_section')]/preceding-sibling :: div[contains(@class,'login_otp')]/button");
    public static By loginScreen_otpField = By.xpath("//input[@id='facebook_app_id']/following-sibling :: div[contains(@class,'otp-section')]//input[@class='otp']");
    public static By loginScreen_getStartedButton = By.xpath("//div[@class='otp-section otp_form']//button[@class='login-control login_after_otp'][contains(text(),'GET STARTED')]");
    public static By loginScreen_invalidUsername = By.xpath("//p[contains(@class,' login_error_msg ')]");
    public static By loginScreen_invalidOTP = By.xpath("//span[@class='error-message otp-error-msg otp_error_msg']");
    public static By loginScreen_LogoutButton = By.xpath("//span[contains(text(),'Log out')]");
    public static By loginScreen_logoutPopUp = By.xpath("//span[contains(@class,'logout_ok_close')]");

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
    public static By calendar_nextButton = By.xpath("//div[@class='datepicker-days']//th[@class='next']");
    public static By Calendar_CurrentDate = By.xpath("//td[@class='today day']");
    public static By Calendar_SameCheckOutDateAsCheckIn = By.xpath("//td[contains(@class,'today selected')]");
    public static By Calendar_NonSelectableDateList = By.xpath("//td[@class='disabled day']");
    public static By Calendar_CheckedInDate = By.xpath("//input[@placeholder='Check-in Date']");
    public static By Calendar_CheckedOutDate = By.xpath("//input[@placeholder='Check-out Date']");



    //Home Page
    public static By homePage_GuestList = By.xpath("//div[@class='select-dropdown-section']/span");
    public static By homePage_GuestIcon = By.xpath("//span[@class='person-icon-wrap']");

    // Calendar
    public static By calendar_monthYearDisplay = By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']");
    public static By calendar_DateList = By.xpath("//div[@class='datepicker-days']//tbody//td");

    // SRP Page
    public static By SRP_listOfProperties = By.xpath("//li[contains(@class,'hotel_card')][not(contains(@class,'soldout'))]//h3/a");


    // SRP Edit Details Modal
    public static By SRP_EditDetails_CalendarCheckIn = By.className("searchCheckIn");



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

    //Payment screen
    public static By PayAtHotel = By.xpath("//span[contains(@class, 'payment-cta')]/preceding-sibling::div");


    //PDP Page

    public static By PDP_BookNowButton = By.xpath("//span[@class='book_now']");
    public static By PDP_continueButton = By.xpath("//span[contains(text(),'Continue')]");
    public static By PDP_payAtHotelButton = By.xpath("//div[@class='payment_options_content guest-payment-option guest_payment_option']//span[contains(text(),'Book Now, Pay@Hotel')]");
    public static By PDP_ConfirmBooking = By.xpath("//span[contains(text(),'Confirm Booking')]");
    public static By PDP_RoomPriceTotal = By.xpath("//span[@class='price']");
    public static By PDP_InfobarPrice = By.xpath("//span[contains(@class,'proceed_pay_btn')]");
    public static By PDP_InfobarNightCount = By.className("proceed_pay_night");
    public static By PDP_InforbarGuestCount = By.className("proceed_pay_guest");
    public static By PDP_DeluxeNightCount = By.className("room_night");
    public static By PDP_DeluxeGuestCount = By.className("room_guest");
    public static By PDP_RoomIncrementButton = By.xpath("//div[@class='room-description-card flex-cls room_type_section select-room show-add-room-area']//a[@class='add_new_room_row'][contains(text(),'+ Add Room')]");
    public static By PDP_ScreenPrice = By.className("price");
    public static By PDP_userType = By.className("user-type");


    /*   Review screen  */

    public static By Review_GuestsAndRoomsDetails = By.className("review_details_complete_guests");
    public static By Review_PayNow = By.xpath("//div[@class='payment_options_content guest-payment-option guest_payment_option']//div[@class='review_guest_continue submit-guest-details'][contains(text(),'Pay Now')]");
    public static By Review_Name = By.xpath("//input[@name='User[Name]']");
    public static By Review_Mobile = By.xpath("//input[@name='User[Mobile]']");
    public static By Review_Otp = By.xpath("//div[@class='payment_options_content guest-payment-option guest_payment_option']//input[@placeholder='Enter OTP here']");
    public static By Review_ConfirmBooking = By.xpath("//div[@class='payment_options_content guest-payment-option guest_payment_option']//span[contains(text(),'Confirm Booking')]");
    public static By Review_TotalAmount = By.xpath("//div[@class='review_details_complete_price']/span[contains(@class,'grand-total-amount')]");
    public static By Review_AmountToBePaid = By.xpath("//div[@class='payment_options_content guest-payment-option guest_payment_option']//span[@class='grand-total-amount']");
    public static By Review_appliedCoupon = By.xpath("//div[contains(@class,'review_booking_offers')]//strong[@class='coupon_code_text']");
    public static By Review_couponDiscount = By.xpath("//div[contains(@class,'coupon_discount_row')]/div[@class='form-value']//span[@class='discount_amount']");
    public static By Review_rackPrice = By.xpath("//span[@class='promo-rate-cut']");
    public static By Review_promoPrice = By.xpath("//span[@class='sub-total-amount']");
    public static By Review_discountedPrice = By.xpath("//span[@class='discounted_price']");
    public static By Review_GSTAmount = By.xpath("//span[contains(@class,'tax-amount')]");
    public static By Review_payableAmount = By.xpath("//div[@class='review_booking_total_amount']//span[contains(@class,'grand-total-amount grand_total_amount')]");
    public static By Review_totalSavings = By.xpath("//span[@id='showBreakUp']/following-sibling :: div[contains(@class,'total_saving_wrapper')]//span[@class='total_saving']");
    public static By Review_pointsToBeCredited = By.xpath("//span[@class='points_to_credit']");
    public static By Review_removeCoupon = By.xpath("//span[contains(@class,'remove_coupon_code')]");
    public static By Review_applyCouponField = By.xpath("//input[@name='Payment[Coupon_Code]']");
    public static By Review_applyCouponButton = By.xpath("//div[contains(@class,'apply_coupon_code')]");
  
    /* Admin Panel  */
    
    public static By userName = By.id("LoginForm_username");
    public static By password = By.id("LoginForm_password");
    public static By login = By.xpath("//input[@value='Login']");
    public static By AbandonedCart = By.xpath("//a[text() = 'Abandoned Cart']");
    public static By searchMobile = By.xpath("//input[@name='PaymentRequest[mobile]']");
    public static By mobile = By.xpath("//tbody//tr[1]//td[7]");
    public static By transactionId = By.xpath("//tbody//tr[1]/td[2]");


    public static By MobileNumber_Field = By.xpath("//label[@class='mobile']");
    public static By fullName_Field = By.xpath("//label[@class='full-name']");
    public static By email_Field = By.xpath("//label[@class='email']");
    public static By gst_CheckBox = By.xpath("//span[text()='I have a GST number']']");
    public static By GST_Number = By.xpath("//label[text()='GSTIN']");
    public static By companyNameField = By.xpath("//label[text()='Company Name']]");
    public static By companyAddressField = By.xpath("//label[text()='Company Address']");
    public static By CreditCardOption = By.xpath("//span[contains(text(),'Credit Card')]");
    public static By CreditCardNumberField = By.xpath("//label[contains(text(),'Credit Card')]/following-sibling :: input");
    public static By fullName_Card = By.xpath("//div[@tab-detail-order='1']/descendant :: input[@name='Payment[Card_Name]']");
    public static By CreditCardCvv = By.xpath("//div[@tab-detail-order='1']/descendant :: input[@name='Payment[Card_CVV]']");
    public static By monthYearField = By.xpath("//div[@tab-detail-order='1']/descendant :: input[@name='Payment[Card_Expiry]']");
    public static By payField = By.xpath("//div[contains(@class,'submit-payment-request')]");
    public static By netBanking = By.xpath("//span[contains(text(),'Net Banking')]");
    public static By paytm = By.xpath("//span[contains(text(),'Paytm')]");
    public static By wallet_CheckBox = By.xpath("//span[@class='payment-mode-selection']/input[@value='PAYTM']");


    //Booking Confirmation Page
    public static By bookingConfirmationText = By.xpath("//div[@class='confirmed-status']/h3");
    public static By bookingId = By.xpath("//div[@class='booking-id']/p");

    
    //Paytm
    public static By paytmRadiobutton = By.id("wallet_PAYTM");
    public static By loginLink = By.id("login-btn");
    public static By loginField = By.xpath("//input[@name='username']");
    public static By passwordField = By.xpath("//input[@name='password']");
    public static By secureLogin = By.xpath("//button[contains(text(),'Secure Sign In')]");
    public static By walletPayNow = By.xpath("//div[contains(@class,'fullWalletDeduct')]//input[contains(@value,'Pay now')]");



}
