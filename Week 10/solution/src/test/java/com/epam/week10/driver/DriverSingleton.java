package com.epam.week10.driver;

import org.openqa.selenium.WebDriver;

public class DriverSingleton {

	// Here the Singleton pattern is already implemented
	
	private static WebDriver driver;

	private DriverSingleton() {

	}
	
	// Here we are also using the Factory method pattern. We have several classes which represent each possible driver, and they
	// are hiding how the driver is created
	
	public static WebDriver getDriver() {
		if (driver == null) {
			switch (System.getProperty("browser")) {
				case "edge": {
					driver = new EdgeDriverCreator().createWebDriver();
					break;
				}
				case "firefox": { 
					driver = new FirefoxDriverCreator().createWebDriver();
					break;
				}
				default: { 
					driver = new ChromeDriverCreator().createWebDriver();
					break;
				}
			}
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	public static void closeDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
