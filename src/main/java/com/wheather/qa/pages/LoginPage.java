package com.wheather.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wheather.qa.base.TestBase;

public class LoginPage extends TestBase {

	// PageFactory - OR
	
	@FindBy(name = "username")
	@CacheLookup
	WebElement userEmail;

	@FindBy(name = "password")
	@CacheLookup
	WebElement userPassword;

	@FindBy(xpath = "//button[text()='Login']")
	@CacheLookup
	WebElement loginBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();

	}

	public boolean validateLoginBtnHome() {
		return loginBtn.isDisplayed();
	}

	public HomePage login(String username, String password) throws InterruptedException {

		driver.switchTo().frame(driver.findElement(By.cssSelector(".full-screen-preview__frame")));
		
		driver.findElement(By.xpath("(//li[@id='li_myaccount']//a[@data-toggle='dropdown'])[2]")).click();;
		driver.findElement(By.xpath("(//a[@href='https://www.phptravels.net/demo/login'])[2]")).click();;
		userEmail.sendKeys(username);
		userPassword.sendKeys(password);
		loginBtn.click();
		waitForPageReady();
		
		driver.switchTo().defaultContent();

		return new HomePage();
	}

}
