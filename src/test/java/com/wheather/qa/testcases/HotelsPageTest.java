package com.wheather.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wheather.qa.base.TestBase;
import com.wheather.qa.pages.HomePage;
import com.wheather.qa.pages.HotelsPage;
import com.wheather.qa.pages.HotelsResultPage;
import com.wheather.qa.pages.LoginPage;

public class HotelsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	HotelsPage hotelsPage;
	HotelsResultPage hotelResultPage;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();

		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		hotelsPage=homePage.clickOnHotels();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	//@Test(priority=1)
	public void hotelsPageTitleTest() {
		Assert.assertEquals(hotelsPage.validateHotelsPageTitle(),"PHPTRAVELS | Travel Technology Partner");
	}
	
	//@Test
	public void searchButtonTest() {
		Assert.assertTrue(hotelsPage.validateSearchButton());
	}
	//String hotelname,String checkin,String checkout,String adults
	@Test(priority=2)
	public void enterSearchDetailsTest() throws InterruptedException {
		hotelResultPage=hotelsPage.enterDataForSearchingHotel("Sydney", "24/09/2019", "26/09/2019");
	}

}
