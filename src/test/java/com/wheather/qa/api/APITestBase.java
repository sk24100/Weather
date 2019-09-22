package com.wheather.qa.api;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class APITestBase {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite Called");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite Called");
	}
}
