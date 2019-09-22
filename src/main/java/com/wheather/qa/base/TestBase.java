package com.wheather.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import shared.Constants;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase()  {
		

		
	}
	
	@BeforeMethod
	public static void initialization() {
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream(Constants.CONFIG_PATH);
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			prop =null;
		}catch(IOException e) {
			e.printStackTrace();
			prop = null;
		}
		if(prop == null) return;
		
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			if (System.getProperty("os.name").toLowerCase().contains("win")) {
			System.setProperty("webdriver.chrome.driver", Constants.DRIVERS_PATH + "/chromedriver.exe");}
			driver=new ChromeDriver();
		}
		else if (browserName.equals("Firefox")) {
			if (System.getProperty("os.name").toLowerCase().contains("win")) {
			System.setProperty("webdriver.gecko.driver",  Constants.DRIVERS_PATH + "/geckodriver.exe");}
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	public void waitForPageReady() {
		try {
			String sPageInteractiveStatus = "";
			for (int iPageStatusLoop = 0; iPageStatusLoop < 60; iPageStatusLoop++) {
				if (sPageInteractiveStatus.equalsIgnoreCase("complete")
						|| sPageInteractiveStatus.equalsIgnoreCase("interactive")) {
					Thread.sleep(500);
					break;
				} else {
					Thread.sleep(1000);
					sPageInteractiveStatus = String.valueOf(((JavascriptExecutor) driver)
							.executeScript("return document.readyState"));
				}
			}
		} catch (Exception e) {
			System.out.println("error while getting page interactive status; " + e);
		}
	}
}
