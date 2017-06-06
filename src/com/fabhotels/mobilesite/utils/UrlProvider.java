package com.fabhotels.mobilesite.utils;

public class UrlProvider extends Config {

	public static String getHomePageUrl() {

		if (TestorLive.toLowerCase().contains("dev"))
			return "https://" + TestorLive + "/fabhotels.com";
		
		if (TestorLive.equalsIgnoreCase("staging"))
			return "https://staging.fabhotels.com";
		
		if (TestorLive.equalsIgnoreCase("preprod"))
			return "https://preprod.fabhotels.com";
		
		else
			return "https://fabhotels.com";
	}
	
	public static String getBaseUrl() {

		if (TestorLive.toLowerCase().contains("dev"))
			return "https://" + TestorLive + "/fabhotels.com";
		
		if (TestorLive.equalsIgnoreCase("staging"))
			return "https://staging.fabhotels.com";
		
		if (TestorLive.equalsIgnoreCase("preprod"))
			return "https://preprod.fabhotels.com";
		
		else
			return "https://www.fabhotels.com/";
	}

	public static String getDetailsPageUrl() {

		if (TestorLive.toLowerCase().contains("dev"))
			return "http://" + TestorLive + "/fabhotels.com";
		
		if (TestorLive.equalsIgnoreCase("staging"))
			return "https://staging.fabhotels.com/hotels-in-gurgaon/fabhotel-daffodil-sector-45.html?checkIn=17+Jan+2017&checkOut=18+Jan+2017";
		
		if (TestorLive.equalsIgnoreCase("preprod"))
			return "https://preprod.fabhotels.com/hotels-in-gurgaon/fabhotel-daffodil-sector-45.html?checkIn=17+Jan+2017&checkOut=18+Jan+2017";
		
		else
			return "https://www.fabhotels.com/hotels-in-gurgaon/fabhotel-daffodil-sector-45.html?checkIn=17+Jan+2017&checkOut=18+Jan+2017";
	}

}
