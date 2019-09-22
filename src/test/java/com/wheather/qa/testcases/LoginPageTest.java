package com.wheather.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wheather.qa.base.TestBase;
import com.wheather.qa.pages.HomePage;
import com.wheather.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	

	
	@Test(priority=1)
	public void loginPageTitleTest() {
		loginPage=new LoginPage();
		String title=loginPage.validateLoginPageTitle();
		
		Assert.assertEquals(title, "Login");
	}
	
	@Test (priority=2)
	public void loginButtonTest() {
		loginPage=new LoginPage();
		boolean flag= loginPage.validateLoginBtnHome();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
}
