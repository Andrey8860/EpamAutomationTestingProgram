package com.epam.week7.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SportchekStoreLocatorPage extends BasePage {
	
	private final String searchResultsLocator = ".nl-store-selector-flyout__stores-list__item";
	private final String autocompleteResultsLocator = ".nl-autocomplete-container__list-button";
	
	@FindBy(css="#nl-store-locator-search-box")
	private WebElement storeSearchInputField;
	
	@FindBy(css=".nl-autocomplete-container__search-btn")
	private WebElement storeSearchButton;
	
	@FindBy(css="a[dap-wac-value='View Store Details']")
	private List<WebElement> storeDetailsLinksOfSearchResults;
	
	@FindBy(css=".nl-store-selector-flyout__stores-list__item__set-preferred-store button")
	private List<WebElement> setAsPreferredStoreButtonsOfSearchResults;
	
	@FindBy(css=searchResultsLocator)
	private List<WebElement> searchResultsItems;
	
	public SportchekStoreLocatorPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void searchForStoreWithFirstOptionSelected(String searchQuery) {
		enterStoreSearchQuery(searchQuery);
		clickStoreSearchButton();
		selectAutocompleteSearchResultAtIndex(0);
		clickStoreSearchButton();
		
		//Thread.sleep() is not ok here, but I want to discuss how we can deal with refresh of elements, since I was
		// not able to figure it out by myself
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//searchResultsItems = waitUntilSearchResultsRefresh();
		
		PageFactory.initElements(driver, this);
	}
	
	public void setPreferredStoreAtIndex(int index) {
		setAsPreferredStoreButtonsOfSearchResults.get(index).click();
	}
	
	public void clickOnStoreDetailsLinkAtIndex(int index) {
		storeDetailsLinksOfSearchResults.get(index).click();
	}
	
	public List<WebElement> getAutocompleteSearchResults() {
		return driver.findElements(By.cssSelector(autocompleteResultsLocator));
	}
	
	public void selectAutocompleteSearchResultAtIndex(int index) {
		getAutocompleteSearchResults().get(index).click();
	}
	
	// This is how I tried to implement the wait for refresh, but it was unsuccessful
	/*
	private List<WebElement> waitUntilSearchResultsRefresh() {
		return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
				ExpectedConditions.refreshed(
						ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(searchResultsLocator))));
	}
	*/
	
	private void enterStoreSearchQuery(String searchQuery) {
		storeSearchInputField.sendKeys(searchQuery);
	}
	
	private void clickStoreSearchButton() {
		storeSearchButton.click();
	}
}
