package com.wheather.qa.api;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCurrentWeather extends APITestBase {

	/*
	 * Ac1 : I want to get Current Weather Data for multiple places in the world
	 * base on Lat and Lon
	 */
	
	@Test(dataProvider = "latandlon")
	public void testCurrentWeatherWithLatAndLon(Integer lat, Integer lon) {

		given().queryParam("lat", lat).queryParam("lon", lon).queryParam("key", TestConstants.API_KEY).when().log()
				.all().get(TestConstants.APOI_BASE_URL + "current").then().statusCode(200);
	}

	/*
	 * AC2. I want to get Current Weather Data for multiple places in the world base
	 * on PostCode
	 */

	@Test(dataProvider = "postalcode")
	public void testCurrentWeatherWithPostCode(String postalCode) {
		given().queryParam("postal_code", postalCode).queryParam("key", TestConstants.API_KEY).when().log().all()
				.get(TestConstants.APOI_BASE_URL + "current").then().statusCode(200);
	}

	/*
	 * On entering Invalid key user should get 403
	 */
	@Test
	public void testCurrentWeatherWithInvalidKey() {
		
		given().queryParam("lat", 38).queryParam("lon", -78).queryParam("key", TestConstants.API_INVALID_KEY).when().
		get(TestConstants.APOI_BASE_URL + "current").then().statusCode(403);
		
	
	}

	/*
	 * Entering negative values should return me status code 400 but getting 200
	 */

	@Test
	public void testCurrentWeatherWithInvalidPostalCode() {
		given().queryParam("postal_code", -60173).queryParam("key", TestConstants.API_KEY).when().log().all()
				.get(TestConstants.APOI_BASE_URL + "current").then().statusCode(400);

	}

	@DataProvider(name = "latandlon")
	public Object[][] getLatAndLonData() {
		Object data[][] = new Object[4][2];
		// Country code :- IN
		data[0][0] = 28;
		data[0][1] = 78;

		// County code :- US
		data[1][0] = 30;
		data[1][1] = -100;

		// Country code:- JP
		data[2][0] = 33;
		data[2][1] = 151;

		// Country code :- AUS
		data[3][0] = -30;
		data[3][1] = 151;

		return data;
	}

	@DataProvider(name = "postalcode")
	public Object[][] getPostalCode() {
		Object data[][] = new Object[4][1];
		// London
		data[0][0] = "SE167BL";

		// India/Delhi
		data[1][0] = "110085";

		// Europe/Vienna
		data[2][0] = "2145";

		// US/Chicago
		data[3][0] = "60173";

		return data;
	}
}
