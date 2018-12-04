package Fab_Application.Constants;

import org.openqa.selenium.By;

public class UiAddresses {

    //Login flow addresses
    public static By loginScreen_mobileNumberField = By.xpath("(//input[@class='mobile_number'])[2]");
    public static By loginScreen_continueButton = By.xpath("(.//button[contains(text(),'CONTINUE')])[2]");
    public static By loginScreen_otpField = By.xpath("(.//input[@class = 'otp'])[2]");
    public static By loginScreen_getStartedButton = By.xpath("(.//button[contains(text(),'GET STARTED')])[3]");
    public static By loginScreen_googleLogin = By.id("google-login-button");
    public static By loginScreen_facebookLogin = By.id("facebook-login-button");
    public static By loginScreen_invalidUsername = By.xpath("//p[contains(@class,' login_error_msg ')]");
    public static By loginScreen_invalidOTP = By.xpath("(//span[contains(@class, 'otp_error_msg')])[2]");
    public static By loginScreen_LogoutButton = By.xpath("//span[contains(text(),'Log out')]");
    public static By loginScreen_logoutPopUp = By.xpath("//span[contains(@class,'logout_ok_close')]");



    //Home Page

    public static By homePage_loginButton = By.xpath(".//div[@class='login-cta']/span[1]");
    public static By homePage_CitySearchField = By.id("autocomplete-location");
    public static By homePage_CityAutosuggestionList = By.xpath("//span[@class='pac-item-query']/span");
    public static By homePage_GuestField = By.xpath("//span[contains(@class,'guests_selected')]");
    public static By homePage_GuestList = By.xpath("//div[@class='select-dropdown-section']/span");
    public static By homePage_SearchButton = By.id("listingPageBtn");
    public static By homePage_ArrowIcon = By.xpath("//span[@class='arrow-icon']");
    public static By homePage_PersonIcon = By.xpath("//*[contains(@class,'icon-person')]");

    // Calendar
    public static By calendar_monthYearDisplay = By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']");
    public static By calendar_previousButton = By.xpath("//div[@class='datepicker-days']//th[@class='prev']");
    public static By calendar_nextButton = By.xpath("//div[@class='datepicker-days']//th[@class='next']");
    public static By calendar_DateList = By.xpath("//div[@class='datepicker-days']//tbody//td");
    public static By calendar_CheckinDate = By.className("//div[contains(@class,'searchCheckInBox')]");
    public static By calendar_CheckoutDate = By.className("//div[contains(@class,'searchCheckOutBox')]");

    // SRP Page
    public static By SRP_listOfProperties = By.xpath("//li[contains(@class,'hotel_card')][not(contains(@class,'soldout'))]//h3/a");


    // SRP Edit Details Modal
    public static By SRP_EditDetails_SearchField = By.id("gp-input");
    public static By SRP_EditDetails_ClearField = By.xpath("//span[text()='CLEAR']");
    public static By SRP_EditDetails_CalendarCheckIn = By.className("searchCheckIn");
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

    //PDP Page

    public static By PDP_BookNowButton = By.xpath("//span[@class='book_now']");
    public static By PDP_continueButton = By.xpath("//span[contains(text(),'Continue')]");
    public static By PDP_payAtHotelButton = By.xpath("(//div[@class='review_payment_tab_content']//span[contains(text(),'Pay@Hotel')])[1]");
    public static By PDP_ConfirmBooking = By.xpath("//span[contains(text(),'Confirm Booking')]");
    public static By PDP_RoomPriceTotal = By.xpath("(//span[@class='total-wrap']/span)[2]");
    public static By PDP_InfobarPrice = By.xpath("//span[contains(@class,'proceed_pay_btn')]");
    public static By PDP_InfobarNightCount = By.className("proceed_pay_night");
    public static By PDP_InforbarGuestCount = By.className("proceed_pay_guest");
    public static By PDP_DeluxeNightCount = By.className("room_night");
    public static By PDP_DeluxeGuestCount = By.className("room_guest");
    public static By PDP_RoomIncrementButton = By.xpath(".//*[@id='select-room']/div[1]/div[2]/div[2]/div[1]/div/div[2]/a");
    public static By PDP_ScreenPrice = By.className("price");


    /*   Review screen  */

    public static By Review_GuestsAndRoomsDetails = By.className("review_details_complete_guests");
    public static By Review_PayNow = By.xpath("(//div[contains(text(),'Pay Now')])[1]");
    public static By Review_Name = By.xpath("//input[@name='User[Name]']");
    public static By Review_Email = By.xpath("//input[@name='User[Email]']");
    public static By Review_Mobile = By.xpath("//input[@name='User[Mobile]']");
    public static By Review_CountryCode = By.xpath("country-code");
    public static By Review_Otp = By.xpath("(//input[@name='Payment[OTP]'])[1]");
    public static By Review_ConfirmBooking = By.xpath("(//div[contains(@class,'submit-payment-otp')])[1]");
    public static By Review_CountryList = By.xpath("//div[@class='country_code_list_container']/div[@class='country_code_item']");
    public static By Review_TotalAmount = By.xpath("//div[@class='review_details_complete_price']/span[contains(@class,'grand-total-amount')]");
    public static By Review_AmountToBePaid = By.xpath("(//span[@class='grand-total-amount'])[3]");
    public static By appliedCoupon = By.xpath("(//strong[@class='coupon_code_text'])[2]");
    public static By couponDiscount = By.xpath("//div[contains(@class,'coupon_discount_row')]/div[@class='form-value']//span[@class='discount_amount']");
    public static By rackPrice = By.xpath("//span[@class='promo-rate-cut']");
    public static By promoPrice = By.xpath("//span[@class='sub-total-amount']");
    public static By discountedPrice = By.xpath("//span[@class='discounted_price']");
    public static By GSTAmount = By.xpath("//span[contains(@class,'tax-amount')]");
    public static By payableAmount = By.xpath("//div[@class='review_booking_total_amount']//span[contains(@class,'grand-total-amount grand_total_amount')]");
    public static By totalSavings = By.xpath("//span[@id='showBreakUp']/following-sibling :: div[contains(@class,'total_saving_wrapper')]//span[@class='total_saving']");
    
    /* Admin Panel  */
    
    public static By userName = By.id("LoginForm_username");
    public static By password = By.id("LoginForm_password");
    public static By login = By.xpath("//input[@value='Login']");
    public static By AbandonedCart = By.linkText("Abandoned Cart");
    public static By searchMobile = By.xpath("//input[@name='PaymentRequest[mobile]']");
    public static By mobile = By.xpath("//tbody//tr[1]//td[7]");
    public static By transactionId = By.xpath("//tbody//tr[1]/td[2]");



    //Payment screen
    public static By PayAtHotel = By.xpath("//span[contains(@class, 'payment-cta')]/preceding-sibling::div");
    public static By MobileNumber_Field = By.xpath("//label[@class='mobile']");
    public static By fullName_Field = By.xpath("//label[@class='full-name']");
    public static By email_Field = By.xpath("//label[@class='email']");
    public static By gst_CheckBox = By.xpath("//span[text()='I have a GST number']']");
    public static By GST_Number = By.xpath("//label[text()='GSTIN']");
    public static By companyNameField = By.xpath("//label[text()='Company Name']]");
    public static By companyAddressField = By.xpath("//label[text()='Company Address']");
    public static By CreditCardOption = By.xpath("//span[contains(text(),'Credit Card')]");
    public static By DebitCardOption = By.xpath("//span[contains(text(),'Debit Card')]");
    public static By CreditCardNumberField = By.xpath("//label[contains(text(),'Credit Card')]/following-sibling :: input");
    public static By fullName_Card = By.xpath("(//label[contains(text(),'Name on Card')]/following-sibling :: input)[1]");
    public static By CreditCardCvv = By.xpath("(//input[@type='password'][@name='Payment[Card_CVV]'])[1]");
    public static By monthYearField = By.xpath("(//input[@name = 'Payment[Card_Expiry]'])[1]");
    public static By payField = By.xpath("//div[contains(@class,'submit-payment-request')]");
    public static By netBanking = By.xpath("//span[contains(text(),'Net Banking')]");
    public static By paytm = By.xpath("//span[contains(text(),'Paytm')]");
    public static By wallet_CheckBox = By.xpath("//span[@class='payment-mode-selection']/input[@value='PAYTM']");

    
    //Paytm
    public static By paytmRadiobutton = By.id("wallet_PAYTM");
    public static By loginLink = By.id("login-btn");
    public static By loginField = By.xpath("//input[@name='username']");
    public static By passwordField = By.xpath("//input[@name='password']");
    public static By secureLogin = By.xpath("//button[contains(text(),'Secure Sign In')]");
    public static By walletPayNow = By.xpath("//div[contains(@class,'fullWalletDeduct')]//input[contains(@value,'Pay now')]");

    
    
    
    //login-iframe
    

}
