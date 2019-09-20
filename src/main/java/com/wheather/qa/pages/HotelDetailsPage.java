package com.wheather.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wheather.qa.base.TestBase;

public class HotelDetailsPage extends TestBase {
	
	@FindBy(css=".description__header")
	WebElement hotelDescription;
	
	@FindBy(css=".acc-details__search-results .room-card:nth-of-type(1) button")
	WebElement hotelBookNow;
	
	public HotelDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateHotelDetails() {
		return hotelDescription.isDisplayed();
	}
	
	public boolean validateBookNowBtn() {
		return hotelBookNow.isDisplayed();
	}

	public BookingPage clickOnBookNow() throws InterruptedException {
		Thread.sleep(5000);
		
		hotelBookNow.click();
		
		return new BookingPage();
	}
}
