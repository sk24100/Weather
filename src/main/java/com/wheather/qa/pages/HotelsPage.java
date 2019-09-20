package com.wheather.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wheather.qa.base.TestBase;

public class HotelsPage extends TestBase{
	
	@FindBy(xpath="//div[@id='select2-drop']//input[@class='select2-input']")
	WebElement hotelName;
	
	@FindBy(name="checkin")
	WebElement hotelCheckinDate;
	
	@FindBy(name="checkout")
	WebElement hotelCheckoutDate;
	
	@FindBy(name="travellers")
	WebElement hotelTravellers;
	
	@FindBy(xpath="(//button[@type='submit'])[4]")
	WebElement searchBtn;
	
	public HotelsPage() {
		PageFactory.initElements(driver, this);
		}
	
	public String validateHotelsPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateSearchButton() {
		return searchBtn.isDisplayed();
	}
	
	public HotelsResultPage enterDataForSearchingHotel(String hotelcity,String checkindt,String checkoutdt ) throws InterruptedException {
		
		driver.findElement(By.xpath("//span[text()='Search by Hotel or City Name']")).click();
		Thread.sleep(5000);
		hotelName.sendKeys(hotelcity);
		driver.findElement(By.cssSelector(".select2-result-sub li:nth-of-type(1)")).click();
		
		hotelCheckinDate.sendKeys(checkindt);
	
		hotelCheckoutDate.sendKeys(checkoutdt);
		
		searchBtn.click();
		
		waitForPageReady();
		
		return new HotelsResultPage();
		
		
		
	}
	
}

