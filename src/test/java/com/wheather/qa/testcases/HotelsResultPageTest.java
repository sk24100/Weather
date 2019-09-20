package com.wheather.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wheather.qa.base.TestBase;
import com.wheather.qa.pages.HomePage;
import com.wheather.qa.pages.HotelDetailsPage;
import com.wheather.qa.pages.HotelsPage;
import com.wheather.qa.pages.HotelsResultPage;
import com.wheather.qa.pages.LoginPage;

public class HotelsResultPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	HotelsPage hotelsPage;
	HotelsResultPage hotelResultPage;
	HotelDetailsPage hotelDetailsPage;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();

		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		hotelsPage=homePage.clickOnHotels();
		hotelResultPage=hotelsPage.enterDataForSearchingHotel(prop.getProperty("hotelcity"), prop.getProperty("checkin"),  prop.getProperty("checkout"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void selectHotelTest() throws InterruptedException {
		hotelDetailsPage=hotelResultPage.selectHotel();
		
	}
	
	

}
