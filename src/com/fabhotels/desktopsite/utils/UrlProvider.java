package com.fabhotels.desktopsite.utils;

import java.net.InetAddress;
import java.net.URL;

public class UrlProvider extends Config {

	public static String getHomePageUrl() {

		if (Environment.toLowerCase().contains("dev"))
			return "http://" + Environment + ".fabhotels.com";

		if (Environment.toLowerCase().contains("preprod"))
			return "https://preprod.fabhotels.com";

		else
			return "https://fabhotels.com";
	}

	public static String getListingPageUrl() {

		if (Environment.toLowerCase().contains("dev"))
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




	public static String getAdminPageUrl() {

		if (Environment.toLowerCase().contains("dev"))
			return "http://" + Environment + ".fabhotels.com/admin";

		if (Environment.toLowerCase().contains("preprod"))
			return "https://preprod.fabhotels.com/admin";

		if (Environment.toLowerCase().contains("staging"))
			return "https://staging.fabhotels.com/admin";

		else
			return "http://www.fabhotels.com/admin";
	}

	public static String getSalesPageUrl() {

		if (Environment.toLowerCase().contains("dev"))
			return "http://" + Environment + ".fabhotels.com/sales";

		if (Environment.toLowerCase().contains("preprod"))
			return "https://preprod.fabhotels.com/sales";

		if (Environment.toLowerCase().contains("staging"))
			return "https://staging.fabhotels.com/sales";

		else
			return "http://www.fabhotels.com/sales";
	}

	public static String get_createAuditorPropertyMapping() {

		if (Environment.toLowerCase().contains("dev"))
			return "http://" + Environment + ".fabhotels.com/auditorApp/auditorPropertyMapping/create";

		if (Environment.toLowerCase().contains("preprod"))
			return "https://preprod.fabhotels.com/auditorApp/auditorPropertyMapping/create";

		if (Environment.toLowerCase().contains("staging"))
			return "https://staging.fabhotels.com/auditorApp/auditorPropertyMapping/create";

		else
			return "http://www.fabhotels.com/auditorApp/auditorPropertyMapping/create";
	}
	
	public static String get_manageAuditorPropertyMapping() {

		if (Environment.toLowerCase().contains("dev"))
			return "http://" + Environment + ".fabhotels.com/auditorApp/auditorPropertyMapping/admin";

		if (Environment.toLowerCase().contains("preprod"))
			return "https://preprod.fabhotels.com/auditorApp/auditorPropertyMapping/admin";

		if (Environment.toLowerCase().contains("staging"))
			return "https://staging.fabhotels.com/auditorApp/auditorPropertyMapping/admin";

		else
			return "http://www.fabhotels.com/auditorApp/auditorPropertyMapping/admin";
	}
/*	public String get_createAuditorPropertyMapping() {

		if (Environment.toLowerCase().contains("dev"))
			return "http://" + Environment + ".fabhotels.com/auditorApp/auditorPropertyMapping/create";

		if (Environment.toLowerCase().contains("preprod"))
			return "https://preprod.fabhotels.com/auditorApp/auditorPropertyMapping/create";

		if (Environment.toLowerCase().contains("staging"))
			return "https://staging.fabhotels.com/auditorApp/auditorPropertyMapping/create";

		else
			return "http://www.fabhotels.com/auditorApp/auditorPropertyMapping/create";
	}
*/
	public void GetCurrentIPAddress(){
		try {
			String URL = driver.getCurrentUrl();
			URL url = new URL(URL);
			InetAddress address = InetAddress.getByName(url.getHost());
			String HostNameAndIPAddress = address.toString();
			System.out.println(HostNameAndIPAddress);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
