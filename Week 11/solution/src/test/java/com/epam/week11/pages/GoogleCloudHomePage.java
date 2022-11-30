package com.epam.week11.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends BasePage {

	private static final String PAGE_URL = "https://cloud.google.com/";
	
	@FindBy(xpath="//div[@class='devsite-searchbox']/input")
	private WebElement searchBox;
	
	public GoogleCloudHomePage(WebDriver driver) {
		super(driver);
	}
	
	public GoogleCloudHomePage openPage() {
		driver.get(PAGE_URL);
		logger.info("Opened the Google Cloud Home Page at URL: " + PAGE_URL);
		return this;
	}
	
	public GoogleCloudSearchResultsPage searchFor(String searchQuery) {
		js.highlightElement(searchBox);
		searchBox.sendKeys(searchQuery + Keys.ENTER);
		logger.info("Performed search for: " + searchQuery);
		return new GoogleCloudSearchResultsPage(driver);
	}
	
}
