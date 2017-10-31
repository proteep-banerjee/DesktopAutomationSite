package com.fabhotels.desktopsite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fabhotels.automationframework.genericfunctions.GenericFunctions;

public class HomePage extends SearchBar {
	WebDriver driver;
	GenericFunctions generic;

	public HomePage(WebDriver driver, GenericFunctions generic) {
		super(driver, generic);
		this.driver = driver;
		this.generic = generic;
	}

	public static final By mainTitle_Lbl = By.xpath("//div[@class='main_title']");
	public static final By secondaryTitle_Lbl = By.xpath("//h2");
	public static final By popularCities_Lbl = By.xpath("//div[@class='popular-cities']/h4");
	public static final String popularCitiesNames_Btn = "//div[@class='popular-cities']//a[text()='";
	public static final By mostPopularHotesHeadline_Lbl = By.xpath("//strong[text()='Most popular FabHotels']");
	public static final By inHighestDemandHeadline_Lbl = By.xpath("//h4[text()='In highest demand']");
	public static final String hotelsInDemandImages_WE = "(//div[@class='hotels_fig_wrap']/img)";
	public static final String hotelsInDemandOnlyRatings_WE = "((//div[@class='reviewer_rating float_left'])/span/span)";
	public static final String hotelsInDemandOnlyReviews_WE = "((//div[@class='reviewer_rating float_left'])/small)";
	public static final String hotelsInDemandPrices_WE = "(//span[@class='popular_fabhotels_price'])";
	public static final String hotelsInDemandName_Lnk = "(//div[@class='review_bottom_content']/h3)";
	public static final String hotelsInDemandLocality_WE = "(//div[@class='popular_fabhotels_address']/span)";
	public static final By hotelsInDemandCheveron_Btn = By.xpath("(//li/a[@class='flex-next'])[1]");
	public static final String hotelsInDemandCard_Lnk = "(//div[@class='hotels_fig_wrap'])";
	public static final String reviewCards_Lnk = "(//div[@class='review_top_content'])";
	public static final By fabulousDealsHeadline_Lbl = By.xpath("//strong[text()='Fabulous deals']");
	public static final By stayMoreSaveMoreHeadline_Lbl = By.xpath("//h4[text()='Stay more, Save more']");
	public static final By plusVerifiedReviewsHeadline_Lbl = By.xpath("//strong[text()='50,000+ verified reviews']");
	public static final By hearFromOurGuestsHeadline_Lbl = By.xpath("//h4[text()='Hear from our guests']");
	public static final By OurHospitalityTeamHeadline_Lbl = By.xpath("//strong[text()='Our hospitality team']");
	public static final By fabPeopleFabSyatHeadline_Lbl = By
			.xpath("//h4[text()='Fab people for a fab stay experience']");
	public static final By workWithUsHeadline_Lbl = By.xpath("//strong[text()='Work with us']");
	public static final By weAreHiringHeadline_Lbl = By.xpath("//h4[text()='We are hiring awesome folks']");
	public static final By spokenAboutHeadline_Lbl = By.xpath("//strong[text()='We are being spoken about']");
	public static final By readMediaCoverageHeadline_Lbl = By.xpath("//h4[text()='Read our media coverage']");
	public static final By fifteenPercentOffCard_Lnk = By.xpath("//a[@href='/deals/fab-grab-flat-15-percent-off']");
	public static final By rFourHundredOffCard_Lnk = By.xpath("//a[@href='/deals/fab-grab-rs-400-off']");
	public static final By reviewsCheveron_Btn = By.xpath("(//li/a[@class='flex-next'])[2]");
	public static final String reviewerNameReviewCard_Lbl = "(//div[@class='reviewer_name'])";
	public static final String reviewerRatingReviewCard_Lbl = "(//div[@class='reviewer_rating'])";
	public static final String reviewerTextReviewCard_Lbl = "(//div[@class='reviewer_text'])";
	public static final String reviewerHotelNameReviewCard_Lnk = "((//div[@class='review_bottom_content'])/a/h3)";
	public static final String reviewerStayDateNameReviewCard_Lbl = "(//div[@class='reviewer_stay_date'])";
	public static final By readAllReviews_Lnk = By.xpath("//a[text()=' Read all reviews ']");
	public static final By hospitalityTeamText_Lbl = By.xpath("(//div[@class='team_text'])[1]");
	public static final By workWithUsTeamText_Lbl = By.xpath("(//div[@class='team_text'])[2]");
	public static final By hospitalityTeamImage_WE = By.xpath("//img[@class='team_graphics']");
	public static final By workWithUsImage_WE = By.xpath("//div[@class='team_graphics backend-team']");
	public static final By seeAllOffers_Lnk = By.xpath("//a[text()=' See all offers ']");
	public static final By seeAllOpenings_Lnk = By.xpath("//a[text()='See all openings']");
	public static final By seeMoreMentions_Lnk = By.xpath("//a[text()='See more mentions']");
	public static final By economicTimesLogo_WE = By
			.xpath("//div[@class='flex_container spoken_about_fabhotels_title et']");
	public static final By forbesLogo_WE = By
			.xpath("//div[@class='flex_container spoken_about_fabhotels_title forbes']");
	public static final By seriesBfunding_Lbl = By.xpath("(//div[@class='spoken_about_fabhotels_text']/p)[1]");
	public static final By expandingRapidly_Lbl = By.xpath("(//div[@class='spoken_about_fabhotels_text']/p)[2]");
	public static final By economicTimes_Lnk = By.xpath("(//small/a)[1]");
	public static final By forbes_Lnk = By.xpath("(//small/a)[2]");
	public static final By economicTimesDate_Lbl = By.xpath("(//div[@class='spoken_about_fabhotels_source']/span)[1]");
	public static final By forbesDate_Lbl = By.xpath("(//div[@class='spoken_about_fabhotels_source']/span)[2]");

	public void click_mainTitle_Lbl() {
		generic.click(mainTitle_Lbl);
	}

	public boolean isVisible_mainTitle_Txt() {
		return generic.isVisible(mainTitle_Lbl);
	}

	public String getLabelText_mainTitle_Lbl() {
		return generic.getText(mainTitle_Lbl);
	}

	public void click_secondaryTitle_Lbl() {
		generic.click(secondaryTitle_Lbl);
	}

	public void click_seeAllOffers_Lnk() {
		generic.click(seeAllOffers_Lnk);
	}

	public void click_reviewsCheveron_Btn() {
		generic.click(reviewsCheveron_Btn);
	}

	public boolean isVisible_reviewsCheveron_Btn() {
		return generic.isVisible(reviewsCheveron_Btn);
	}

	public void click_readAllReviews_Lnk() {
		generic.click(readAllReviews_Lnk);
	}

	public boolean isVisible_secondaryTitle_Txt() {
		return generic.isVisible(secondaryTitle_Lbl);
	}

	public String getLabelText_secondaryTitle_Lbl() {
		return generic.getText(secondaryTitle_Lbl);
	}

	public void click_popularCities_Lbl() {
		generic.click(popularCities_Lbl);
	}

	public boolean isVisible_popularCities_Txt() {
		return generic.isVisible(popularCities_Lbl);
	}

	public String getLabelText_popularCities_Lbl() {
		return generic.getText(popularCities_Lbl);
	}

	public void click_popularCitiesNames_Btn(String cityName) {
		generic.click(popularCitiesNames_Btn + cityName + "']");
	}

	public boolean isVisible_popularCitiesNames_Txt(String cityName) {
		return generic.isVisible(popularCitiesNames_Btn + cityName + "']");
	}

	public String getLabelText_popularCitiesNames_Lbl(String cityName) {
		return generic.getText(popularCitiesNames_Btn + cityName + "']");
	}

	public void click_mostPopularHotesHeadline_Lbl() {
		generic.click(mostPopularHotesHeadline_Lbl);
	}

	public boolean isVisible_mostPopularHotesHeadline_Txt() {
		return generic.isVisible(mostPopularHotesHeadline_Lbl);
	}

	public String getLabelText_mostPopularHotesHeadline_Lbl() {
		return generic.getText(mostPopularHotesHeadline_Lbl);
	}

	public void click_inHighestDemandHeadline_Lbl() {
		generic.click(inHighestDemandHeadline_Lbl);
	}

	public boolean isVisible_inHighestDemandHeadline_Txt() {
		return generic.isVisible(inHighestDemandHeadline_Lbl);
	}

	public String getLabelText_inHighestDemandHeadline_Lbl() {
		return generic.getText(inHighestDemandHeadline_Lbl);
	}

	public void click_hotelsInDemandImages_WE() {
		generic.click(hotelsInDemandImages_WE);
	}

	public boolean isVisible_hotelsInDemandImages_WE(int i) {
		return generic.isVisible(hotelsInDemandImages_WE + "[" + i + "]");
	}

	public String getElementText_hotelsInDemandImages_WE() {
		return generic.getText(hotelsInDemandImages_WE);

	}

	public String getElementText_hotelsInDemandOnlyRatings_WE(int i) {
		return generic.getText(hotelsInDemandOnlyRatings_WE + "[" + i + "]");

	}

	public String getWidth_hotelsInDemandOnlyRatings_WE(int i) {
		return generic.getAttributeValue(By.xpath(hotelsInDemandOnlyRatings_WE + "[" + i + "]"), "style");

	}

	public String getElementText_hotelsInDemandOnlyReviews_WE(int i) {
		return generic.getText(hotelsInDemandOnlyReviews_WE + "[" + i + "]");

	}

	public void click_hotelsInDemandPrices_WE() {
		generic.click(hotelsInDemandPrices_WE);
	}

	public boolean isVisible_hotelsInDemandPrices_Txt() {
		return generic.isVisible(hotelsInDemandPrices_WE);
	}

	public String getElementText_hotelsInDemandPrices_WE(int i) {
		return generic.getText(hotelsInDemandPrices_WE + "[" + i + "]");

	}

	public void click_hotelsInDemandName_Lnk(int i) {
		generic.click(hotelsInDemandName_Lnk + "[" + i + "]");
	}

	public boolean isVisible_hotelsInDemandName_Lnk(int i) {
		return generic.isVisible(hotelsInDemandName_Lnk + "[" + i + "]");
	}

	public String getElementText_hotelsInDemandName_Lnk(int i) {
		return generic.getText(hotelsInDemandName_Lnk + "[" + i + "]");

	}

	public void click_hotelsInDemandLocality_WE() {
		generic.click(hotelsInDemandLocality_WE);
	}

	public boolean isVisible_hotelsInDemandLocality_Txt() {
		return generic.isVisible(hotelsInDemandLocality_WE);
	}

	public String getElementText_hotelsInDemandLocality_WE(int i) {
		return generic.getText(hotelsInDemandLocality_WE + "[" + i + "]");

	}

	public boolean isVisible_hotelsInDemandCheveron_Btn() {
		return generic.isVisible(hotelsInDemandCheveron_Btn);
	}

	public void click_hotelsInDemandCheveron_Btn() {
		generic.click(hotelsInDemandCheveron_Btn);
	}

	public boolean isVisible_hotelsInDemandCheveron_Txt() {
		return generic.isVisible(hotelsInDemandCheveron_Btn);
	}

	public void click_hotelsInDemandCard_Lnk() {
		generic.click(hotelsInDemandCard_Lnk);
	}

	public boolean isVisible_hotelsInDemandCard_Txt() {
		return generic.isVisible(hotelsInDemandCard_Lnk);
	}

	public String getLinkText_hotelsInDemandCard_Lnk() {
		return generic.getText(hotelsInDemandCard_Lnk);
	}

	public void click_fabulousDealsHeadline_Lbl() {
		generic.click(fabulousDealsHeadline_Lbl);
	}

	public boolean isVisible_fabulousDealsHeadline_Txt() {
		return generic.isVisible(fabulousDealsHeadline_Lbl);
	}

	public String getLabelText_fabulousDealsHeadline_Lbl() {
		return generic.getText(fabulousDealsHeadline_Lbl);
	}

	public void click_stayMoreSaveMoreHeadline_Lbl() {
		generic.click(stayMoreSaveMoreHeadline_Lbl);
	}

	public boolean isVisible_stayMoreSaveMoreHeadline_Txt() {
		return generic.isVisible(stayMoreSaveMoreHeadline_Lbl);
	}

	public String getLabelText_stayMoreSaveMoreHeadline_Lbl() {
		return generic.getText(stayMoreSaveMoreHeadline_Lbl);
	}

	public void click_plusVerifiedReviewsHeadline_Lbl() {
		generic.click(plusVerifiedReviewsHeadline_Lbl);
	}

	public boolean isVisible_plusVerifiedReviewsHeadline_Txt() {
		return generic.isVisible(plusVerifiedReviewsHeadline_Lbl);
	}

	public String getLabelText_plusVerifiedReviewsHeadline_Lbl() {
		return generic.getText(plusVerifiedReviewsHeadline_Lbl);
	}

	public void click_hearFromOurGuestsHeadline_Lbl() {
		generic.click(hearFromOurGuestsHeadline_Lbl);
	}

	public boolean isVisible_hearFromOurGuestsHeadline_Txt() {
		return generic.isVisible(hearFromOurGuestsHeadline_Lbl);
	}

	public String getLabelText_hearFromOurGuestsHeadline_Lbl() {
		return generic.getText(hearFromOurGuestsHeadline_Lbl);
	}

	public void click_OurHospitalityTeamHeadline_Lbl() {
		generic.click(OurHospitalityTeamHeadline_Lbl);
	}

	public boolean isVisible_OurHospitalityTeamHeadline_Txt() {
		return generic.isVisible(OurHospitalityTeamHeadline_Lbl);
	}

	public String getLabelText_OurHospitalityTeamHeadline_Lbl() {
		return generic.getText(OurHospitalityTeamHeadline_Lbl);
	}

	public void click_fabPeopleFabSyatHeadline_Lbl() {
		generic.click(fabPeopleFabSyatHeadline_Lbl);
	}

	public boolean isVisible_fabPeopleFabSyatHeadline_Txt() {
		return generic.isVisible(fabPeopleFabSyatHeadline_Lbl);
	}

	public String getLabelText_fabPeopleFabSyatHeadline_Lbl() {
		return generic.getText(fabPeopleFabSyatHeadline_Lbl);
	}

	public void click_workWithUsHeadline_Lbl() {
		generic.click(workWithUsHeadline_Lbl);
	}

	public boolean isVisible_workWithUsHeadline_Txt() {
		return generic.isVisible(workWithUsHeadline_Lbl);
	}

	public String getLabelText_workWithUsHeadline_Lbl() {
		return generic.getText(workWithUsHeadline_Lbl);
	}

	public void click_weAreHiringHeadline_Lbl() {
		generic.click(weAreHiringHeadline_Lbl);
	}

	public boolean isVisible_weAreHiringHeadline_Txt() {
		return generic.isVisible(weAreHiringHeadline_Lbl);
	}

	public String getLabelText_weAreHiringHeadline_Lbl() {
		return generic.getText(weAreHiringHeadline_Lbl);
	}

	public void click_spokenAboutHeadline_Lbl() {
		generic.click(spokenAboutHeadline_Lbl);
	}

	public boolean isVisible_spokenAboutHeadline_Txt() {
		return generic.isVisible(spokenAboutHeadline_Lbl);
	}

	public String getLabelText_spokenAboutHeadline_Lbl() {
		return generic.getText(spokenAboutHeadline_Lbl);
	}

	public void click_readMediaCoverageHeadline_Lbl() {
		generic.click(readMediaCoverageHeadline_Lbl);
	}

	public boolean isVisible_readMediaCoverageHeadline_Txt() {
		return generic.isVisible(readMediaCoverageHeadline_Lbl);
	}

	public String getLabelText_readMediaCoverageHeadline_Lbl() {
		return generic.getText(readMediaCoverageHeadline_Lbl);
	}

	public void click_fifteenPercentOffCard_Lnk() {
		generic.click(fifteenPercentOffCard_Lnk);
	}

	public boolean isVisible_fifteenPercentOffCard_Txt() {
		return generic.isVisible(fifteenPercentOffCard_Lnk);
	}

	public String getLinkText_fifteenPercentOffCard_Lnk() {
		return generic.getText(fifteenPercentOffCard_Lnk);
	}

	public void click_rFourHundredOffCard_Lnk() {
		generic.click(rFourHundredOffCard_Lnk);
	}

	public boolean isVisible_rFourHundredOffCard_Txt() {
		return generic.isVisible(rFourHundredOffCard_Lnk);
	}

	public String getLinkText_rFourHundredOffCard_Lnk() {
		return generic.getText(rFourHundredOffCard_Lnk);
	}

	public void click_reviewerNameReviewCard_Lbl() {
		generic.click(reviewerNameReviewCard_Lbl);
	}

	public boolean isVisible_reviewerNameReviewCard_Txt() {
		return generic.isVisible(reviewerNameReviewCard_Lbl);
	}

	public String getLabelText_reviewerNameReviewCard_Lbl(int i) {
		return generic.getText(reviewerNameReviewCard_Lbl + "[" + i + "]");
	}

	public void click_reviewerRatingReviewCard_Lbl() {
		generic.click(reviewerRatingReviewCard_Lbl);
	}

	public boolean isVisible_reviewerRatingReviewCard_Txt() {
		return generic.isVisible(reviewerRatingReviewCard_Lbl);
	}

	public String getLabelText_reviewerRatingReviewCard_Lbl(int i) {
		return generic.getText(reviewerRatingReviewCard_Lbl + "[" + i + "]");
	}

	public boolean isVisible_reviewerRatingReviewCard_Lbl(int i) {
		return generic.isVisible(reviewerRatingReviewCard_Lbl + "[" + i + "]");
	}

	public void click_reviewerTextReviewCard_Lbl() {
		generic.click(reviewerTextReviewCard_Lbl);
	}

	public boolean isVisible_reviewerTextReviewCard_Txt() {
		return generic.isVisible(reviewerTextReviewCard_Lbl);
	}

	public String getLabelText_reviewerTextReviewCard_Lbl(int i) {
		return generic.getText(reviewerTextReviewCard_Lbl + "[" + i + "]");
	}

	public void click_reviewerHotelNameReviewCard_Lnk(int i) {
		generic.click(reviewerHotelNameReviewCard_Lnk + "[" + i + "]");
	}

	public boolean isVisible_reviewerHotelNameReviewCard_Txt() {
		return generic.isVisible(reviewerHotelNameReviewCard_Lnk);
	}

	public String getLinkText_reviewerHotelNameReviewCard_Lnk(int i) {
		return generic.getText(reviewerHotelNameReviewCard_Lnk + "[" + i + "]");
	}

	public void click_reviewerStayDateNameReviewCard_Lbl() {
		generic.click(reviewerStayDateNameReviewCard_Lbl);
	}

	public boolean isVisible_reviewerStayDateNameReviewCard_Txt() {
		return generic.isVisible(reviewerStayDateNameReviewCard_Lbl);
	}

	public String getLabelText_reviewerStayDateNameReviewCard_Lbl(int i) {
		return generic.getText(reviewerStayDateNameReviewCard_Lbl + "[" + i + "]");
	}

	public void click_hospitalityTeamText_Lbl() {
		generic.click(hospitalityTeamText_Lbl);
	}

	public boolean isVisible_hospitalityTeamText_Txt() {
		return generic.isVisible(hospitalityTeamText_Lbl);
	}

	public String getLabelText_hospitalityTeamText_Lbl() {
		return generic.getText(hospitalityTeamText_Lbl);
	}

	public void click_workWithUsTeamText_Lbl() {
		generic.click(workWithUsTeamText_Lbl);
	}

	public boolean isVisible_workWithUsTeamText_Txt() {
		return generic.isVisible(workWithUsTeamText_Lbl);
	}

	public String getLabelText_workWithUsTeamText_Lbl() {
		return generic.getText(workWithUsTeamText_Lbl);
	}

	public void click_hospitalityTeamImage_WE() {
		generic.click(hospitalityTeamImage_WE);
	}

	public boolean isVisible_hospitalityTeamImage_Txt() {
		return generic.isVisible(hospitalityTeamImage_WE);
	}

	public String getElementText_hospitalityTeamImage_WE() {
		return generic.getText(hospitalityTeamImage_WE);

	}

	public void click_workWithUsImage_WE() {
		generic.click(workWithUsImage_WE);
	}

	public boolean isVisible_workWithUsImage_WE() {
		return generic.isVisible(workWithUsImage_WE);
	}

	public String getElementText_workWithUsImage_WE() {
		return generic.getText(workWithUsImage_WE);

	}

	public void click_seeAllOpenings_Lnk() {
		generic.click(seeAllOpenings_Lnk);
	}

	public boolean isVisible_seeAllOpenings_Txt() {
		return generic.isVisible(seeAllOpenings_Lnk);
	}

	public String getLinkText_seeAllOpenings_Lnk() {
		return generic.getText(seeAllOpenings_Lnk);
	}

	public void click_seeMoreMentions_Lnk() {
		generic.click(seeMoreMentions_Lnk);
	}

	public boolean isVisible_seeMoreMentions_Txt() {
		return generic.isVisible(seeMoreMentions_Lnk);
	}

	public String getLinkText_seeMoreMentions_Lnk() {
		return generic.getText(seeMoreMentions_Lnk);
	}

	public void click_economicTimesLogo_WE() {
		generic.click(economicTimesLogo_WE);
	}

	public boolean isVisible_economicTimesLogo_WE() {
		return generic.isVisible(economicTimesLogo_WE);
	}

	public String getElementText_economicTimesLogo_WE() {
		return generic.getText(economicTimesLogo_WE);

	}

	public void click_forbesLogo_WE() {
		generic.click(forbesLogo_WE);
	}

	public boolean isVisible_forbesLogo_WE() {
		return generic.isVisible(forbesLogo_WE);
	}

	public String getElementText_forbesLogo_WE() {
		return generic.getText(forbesLogo_WE);

	}

	public void click_seriesBfunding_Lbl() {
		generic.click(seriesBfunding_Lbl);
	}

	public boolean isVisible_seriesBfunding_Txt() {
		return generic.isVisible(seriesBfunding_Lbl);
	}

	public String getLabelText_seriesBfunding_Lbl() {
		return generic.getText(seriesBfunding_Lbl);
	}

	public void click_expandingRapidly_Lbl() {
		generic.click(expandingRapidly_Lbl);
	}

	public boolean isVisible_expandingRapidly_Txt() {
		return generic.isVisible(expandingRapidly_Lbl);
	}

	public String getLabelText_expandingRapidly_Lbl() {
		return generic.getText(expandingRapidly_Lbl);
	}

	public void click_economicTimes_Lnk() {
		generic.click(economicTimes_Lnk);
	}

	public boolean isVisible_economicTimes_Txt() {
		return generic.isVisible(economicTimes_Lnk);
	}

	public String getLinkText_economicTimes_Lnk() {
		return generic.getText(economicTimes_Lnk);
	}

	public void click_forbes_Lnk() {
		generic.click(forbes_Lnk);
	}

	public boolean isVisible_forbes_Txt() {
		return generic.isVisible(forbes_Lnk);
	}

	public String getLinkText_forbes_Lnk() {
		return generic.getText(forbes_Lnk);
	}

	public void click_economicTimesDate_Lbl() {
		generic.click(economicTimesDate_Lbl);
	}

	public boolean isVisible_economicTimesDate_Txt() {
		return generic.isVisible(economicTimesDate_Lbl);
	}

	public String getLabelText_economicTimesDate_Lbl() {
		return generic.getText(economicTimesDate_Lbl);
	}

	public void click_forbesDate_Lbl() {
		generic.click(forbesDate_Lbl);
	}

	public boolean isVisible_forbesDate_Txt() {
		return generic.isVisible(forbesDate_Lbl);
	}

	public String getLabelText_forbesDate_Lbl() {
		return generic.getText(forbesDate_Lbl);
	}

}
