package com.epam.week10.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverCreator implements WebDriverCreator {
	public WebDriver createWebDriver() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}
}
