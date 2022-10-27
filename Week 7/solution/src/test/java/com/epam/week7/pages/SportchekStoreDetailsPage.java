package com.epam.week7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class SportchekStoreDetailsPage extends BasePage {

	private final String storeDetailsComponentLocator = ".nl-store-details";
	
	@FindBy(css=".nl-store-details__address h1")
	@Getter private WebElement storeTitleInDetailedAddressSection;
	
	public SportchekStoreDetailsPage(WebDriver driver) {
		super(driver);
		waitSecondsForVisibilityOfAnElement(5, By.cssSelector(storeDetailsComponentLocator));
		PageFactory.initElements(driver, this);
	}
}
