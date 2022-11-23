package com.epam.week9.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.epam.week9.driver.Driver;
import com.epam.week9.util.TestListener;

@Listeners({TestListener.class})
public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		this.driver = Driver.getDriver();
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		Driver.closeDriver();
	}
	
}
