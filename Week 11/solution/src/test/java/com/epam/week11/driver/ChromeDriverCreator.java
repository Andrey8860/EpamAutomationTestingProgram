package com.epam.week11.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverCreator implements WebDriverCreator {
	public WebDriver createWebDriver() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}
}
