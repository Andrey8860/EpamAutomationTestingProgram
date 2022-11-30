package com.epam.week13.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import com.epam.week13.driver.DriverManager;
import com.epam.week13.util.TestListener;
import io.appium.java_client.AppiumDriver;

@Listeners({TestListener.class})
public class BaseTest {
	
	protected AppiumDriver driver;
	
	@BeforeClass(alwaysRun = true)
	public void createSession() {
		this.driver = DriverManager.getDriver();
	}
	
	@AfterClass(alwaysRun = true)
	public void closeSession() {
		DriverManager.closeDriver();
		DriverManager.closeAppium();
		DriverManager.closeEmulator();
	}
}
