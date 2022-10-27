package com.epam.week8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lombok.Getter;

public class SportchekStoreDetailsPage extends BasePage {

	@Getter private WebElement storeTitleInDetailedAddressSection;
	private final String storeTitleInDetailedAddressSectionLocator = ".nl-store-details__address h1";
	private final String storeDetailsComponentLocator = ".nl-store-details";
	
	public SportchekStoreDetailsPage(WebDriver driver) {
		super(driver);
		waitSecondsForVisibilityOfAnElement(5, By.cssSelector(storeDetailsComponentLocator));
		storeTitleInDetailedAddressSection = js.findElementByCss(storeTitleInDetailedAddressSectionLocator);
	}
}
