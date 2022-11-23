package com.epam.week10.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeDriverCreator implements WebDriverCreator {
	public WebDriver createWebDriver() {
		WebDriverManager.edgedriver().setup();
		return new EdgeDriver();
	}
}
