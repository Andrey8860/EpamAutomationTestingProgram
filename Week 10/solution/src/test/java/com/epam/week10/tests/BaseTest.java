package com.epam.week10.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.epam.week10.driver.DriverSingleton;
import com.epam.week10.util.TestListener;

@Listeners({TestListener.class})
public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		this.driver = DriverSingleton.getDriver();
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		DriverSingleton.closeDriver();
	}
	
}
