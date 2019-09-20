package com.wheather.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wheather.qa.base.TestBase;


public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[contains(text(),'Hotels')]")
	@CacheLookup
	WebElement hotelLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public HotelsPage clickOnHotels() {
		driver.switchTo().frame(driver.findElement(By.cssSelector(".full-screen-preview__frame")));
		hotelLink.click();
		waitForPageReady();
		
		return new HotelsPage();
	}
	
	

}
