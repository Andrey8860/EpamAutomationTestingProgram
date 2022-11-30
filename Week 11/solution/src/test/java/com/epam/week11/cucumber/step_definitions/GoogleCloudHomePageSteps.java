package com.epam.week11.cucumber.step_definitions;

import org.openqa.selenium.WebDriver;

import com.epam.week11.driver.DriverSingleton;
import com.epam.week11.pages.GoogleCloudHomePage;

import io.cucumber.java.en.Given;

public class GoogleCloudHomePageSteps {
	
	private GoogleCloudHomePage googleCloudHomePage;
	private WebDriver driver = DriverSingleton.getDriver();
	
	@Given("I am on the Google Cloud Home Page")
	public void i_am_on_the_google_cloud_home_page() {
		googleCloudHomePage = new GoogleCloudHomePage(driver);
		googleCloudHomePage.openPage();
	}
	
}
