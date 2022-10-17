package com.epam.week6.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends BasePage {

	private String pageURL = "https://cloud.google.com/";
	
	@FindBy(xpath="//div[@class='devsite-searchbox']/input")
	private WebElement searchBox;
	
	public GoogleCloudHomePage(WebDriver driver) {
		super(driver);
	}
	
	public void openPage() {
		driver.get(pageURL);
	}
	
	public void searchFor(String searchQuery) {
		searchBox.sendKeys(searchQuery);
		searchBox.sendKeys(Keys.ENTER);
	}
	
}
