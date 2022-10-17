package com.epam.week6.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		this.driver = new ChromeDriver();
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
}