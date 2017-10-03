package com.fabhotels.desktopsite.utils;

public class UrlProvider extends Config {

	public static String getHomePageUrl() {

		if (Environment.toLowerCase().contains("dev"))
			return "https://" + Environment + ".fabhotels.com/";
		
		else if (Environment.toLowerCase().contains("test2"))
			return "https://" + Environment + ".fabhotels.com/";
		
		else if (Environment.toLowerCase().contains("preprod"))
			return "https://preprod.fabhotels.com/";

		if (Environment.toLowerCase().contains("test"))
			return "https://" + Environment + ".fabhotels.com/";
		else
			return "https://www.fabhotels.com/";
	}

	public static String getListingPageUrl() {

		if (Environment.toLowerCase().contains("dev"))
			return "https://" + Environment + ".fabhotels.com/hotels-in-new-delhi/";
		

		if (Environment.toLowerCase().contains("test2"))
			return "https://" + Environment + ".fabhotels.com/hotels-in-new-delhi/";

		if (Environment.toLowerCase().contains("preprod"))
			return "https://preprod.fabhotels.com/hotels-in-new-delhi/";

		else
			return "https://www.fabhotels.com/hotels-in-new-delhi/";
	}
	
	public static String getDetailsPageUrl() {

		if (Environment.toLowerCase().contains("dev"))
			return "http://" + Environment + ".fabhotels.com/hotels-in-new-delhi/fabhotel-checkin-by-oran-cp.html/";
		

		if (Environment.toLowerCase().contains("test2"))
			return "http://" + Environment + ".fabhotels.com/hotels-in-new-delhi/fabhotel-checkin-by-oran-cp.html/";

		if (Environment.toLowerCase().contains("preprod"))
			return "https://preprod.fabhotels.com/hotels-in-new-delhi/fabhotel-checkin-by-oran-cp.html/";

		else
			return "http://www.fabhotels.com/hotels-in-new-delhi/fabhotel-checkin-by-oran-cp.html/";
	}

	public static String getListingPageUrl(String locality) {

		locality = locality.replaceAll(" ", "-").toLowerCase();
		if (Environment.toLowerCase().contains("dev"))
			return "http://" + Environment + ".fabhotels.com/hotels-in-" + locality + "/";

		if (Environment.toLowerCase().contains("preprod"))
			return "https://preprod.fabhotels.com/hotels-in-" + locality + "/";

		if (Environment.toLowerCase().contains("staging"))
			return "https://staging.fabhotels.com/hotels-in-" + locality + "/";

		else
			return "http://www.fabhotels.com/hotels-in-" + locality + "/";
	}

	public static String getDamanPageUrl() {

		if (Environment.toLowerCase().contains("dev"))
			return "http://" + Environment + ".fabhotels.com/hotels-in-gurgaon";

		if (Environment.toLowerCase().contains("preprod"))
			return "https://preprod.fabhotels.com/hotels-in-daman/fabhotel-hotel-sankalp.html";

		if (Environment.toLowerCase().contains("staging"))
			return "https://staging.fabhotels.com/hotels-in-gurgaon/";

		else
			return "http://www.fabhotels.com/hotels-in-daman";
	}

	public static String getcheckoutReviewUrl() {

		if (Environment.toLowerCase().contains("dev"))
			return "http://" + Environment + ".fabhotels.com/checkout/review";

		if (Environment.toLowerCase().contains("preprod"))
			return "https://preprod.fabhotels.com/checkout/review";

		if (Environment.toLowerCase().contains("staging"))
			return "https://staging.fabhotels.com/checkout/review";

		else
			return "http://www.fabhotels.com/checkout/review";
	}


}
