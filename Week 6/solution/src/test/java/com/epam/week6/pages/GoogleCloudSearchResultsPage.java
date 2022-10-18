package com.epam.week6.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudSearchResultsPage extends BasePage {
	
	public GoogleCloudSearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getSearchResults() {
		return new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.presenceOfElementLocated(By
						.cssSelector(".gsc-resultsbox-visible")));
	}
	
	public void goToSpecificSearchResultWhichContainsSpecificText(String expectedLink) {
		getSearchResults().findElement(By.partialLinkText(expectedLink)).click();
	}
	
}
