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


	@Test(priority=1)
	public void homePageTitleTest() throws InterruptedException {
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(homePage.validateHomePageTitle(), "Demo PHPTRAVELS");
	}

	@Test(priority=2)
	public void clickOnHotelsTest() throws InterruptedException {
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		hotelsPage = homePage.clickOnHotels();
		waitForPageReady();
	}

}
