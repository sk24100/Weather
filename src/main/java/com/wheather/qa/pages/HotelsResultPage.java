package com.wheather.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wheather.qa.base.TestBase;

public class HotelsResultPage extends TestBase {
	
	@FindBy(css=".bgwhite tr:nth-of-type(1) button")
	WebElement selectHotel;
	
	public HotelsResultPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public HotelDetailsPage selectHotel() throws InterruptedException {
		Thread.sleep(2000);
		selectHotel.click();
		waitForPageReady();

		
		return new HotelDetailsPage();
	}
}
