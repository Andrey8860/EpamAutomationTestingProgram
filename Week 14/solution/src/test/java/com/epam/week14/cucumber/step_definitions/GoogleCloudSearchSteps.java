package com.epam.week14.cucumber.step_definitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.epam.week14.driver.DriverSingleton;
import com.epam.week14.pages.GoogleCloudHomePage;
import com.epam.week14.pages.GoogleCloudSearchResultsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleCloudSearchSteps {
	
	private final static String GOOGLE_CLOUD_SEARCH_TEST_FAIL_MESSAGE =
			"Search results are not available";
	
	WebDriver driver = DriverSingleton.getDriver();
	GoogleCloudHomePage googleCloudHomePage  = new GoogleCloudHomePage(driver);
	private GoogleCloudSearchResultsPage googleCloudSearchResultsPage;

	@When("I search for the {string}")
	public void i_search_for_the(String searchQuery) {
		googleCloudHomePage.searchFor(searchQuery);
	}
	
	@Then("Search results are available")
	public void search_results_are_available() {
		googleCloudSearchResultsPage = new GoogleCloudSearchResultsPage(driver);
		
		Assert.assertTrue(googleCloudSearchResultsPage
				.getSearchResults()
				.isDisplayed()
				, GOOGLE_CLOUD_SEARCH_TEST_FAIL_MESSAGE);
	}	
}
