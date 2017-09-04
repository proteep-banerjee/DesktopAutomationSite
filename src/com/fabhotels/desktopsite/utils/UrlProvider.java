package com.fabhotels.desktopsite.utils;

public class UrlProvider extends Config {

	public static String getHomePageUrl() {

		if (Environment.toLowerCase().contains("dev"))
			return "http://" + Environment + ".fabhotels.com";
		
		else if (Environment.toLowerCase().contains("test2"))
			return "http://" + Environment + ".fabhotels.com";
		
		else if (Environment.toLowerCase().contains("preprod"))
			return "https://preprod.fabhotels.com";

		else
			return "https://fabhotels.com";
	}

	public static String getListingPageUrl() {

		if (Environment.toLowerCase().contains("dev"))
			return "http://" + Environment + ".fabhotels.com/hotels-in-new-delhi/";
		

		if (Environment.toLowerCase().contains("test"))
			return "http://" + Environment + ".fabhotels.com/hotels-in-new-delhi/";

		if (Environment.toLowerCase().contains("preprod"))
			return "https://preprod.fabhotels.com/hotels-in-new-delhi/";

		else
			return "http://www.fabhotels.com/hotels-in-new-delhi/";
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
