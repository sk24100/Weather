package com.wheather.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wheather.qa.base.TestBase;
import com.wheather.qa.pages.HomePage;
import com.wheather.qa.pages.HotelsPage;
import com.wheather.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	HotelsPage hotelsPage;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();

		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority=1)
	public void homePageTitleTest() {
		Assert.assertEquals(homePage.validateHomePageTitle(), "Demo PHPTRAVELS");
	}

	@Test(priority=2)
	public void clickOnHotelsTest() {
		hotelsPage = homePage.clickOnHotels();
		waitForPageReady();
	}

}
