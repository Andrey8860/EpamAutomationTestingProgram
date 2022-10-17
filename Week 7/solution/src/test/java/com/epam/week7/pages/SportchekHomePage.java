package com.epam.week7.pages;

import org.openqa.selenium.WebDriver;

public class SportchekHomePage extends BasePage {
	
	private final String pageURL = "https://qa3-www.sportchek.ca/en.html";
	
	public SportchekHomePage(WebDriver driver) {
		super(driver);
	}
	
	public void openPage() {
		driver.get(pageURL);
	}
	
}
