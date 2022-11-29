package com.epam.week9.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.epam.week9.service.TestDataReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	private static WebDriver driver;
	protected final Logger logger = LogManager.getRootLogger();

	private Driver() {

	}

	public static WebDriver getDriver() {
		if (driver == null) {
			switch (TestDataReader.getReader().getBrowser()) {
				case "edge": {
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;
				}
				case "firefox": { 
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				}
				default: { 
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
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
