package com.epam.week9.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleCloudSearchResultsPage extends BasePage {
	
	public final String searchResultsLocator = ".gsc-resultsbox-visible";
	
	public GoogleCloudSearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getSearchResults() {
		return waitSecondsForPresenceOfAnElement(5, By.cssSelector(searchResultsLocator));
	}
	
	public void goToSpecificSearchResultWhichContainsSpecificText(String expectedLink) {
		WebElement searchResult = getSearchResults().findElement(By.partialLinkText(expectedLink));
		js.highlightElement(searchResult);
		searchResult.click();
		logger.info("Proceeding to the search result of " + expectedLink);
	}
	
}
