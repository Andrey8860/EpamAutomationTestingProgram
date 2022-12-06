package com.epam.week14.cucumber.step_definitions;

import org.openqa.selenium.WebDriver;

import com.epam.week14.driver.DriverSingleton;
import com.epam.week14.pages.GoogleCloudHomePage;

import io.cucumber.java.en.Given;

public class GoogleCloudHomePageSteps {
	
	WebDriver driver = DriverSingleton.getDriver();
	GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);
	
	@Given("I am on the Google Cloud Home Page")
	public void i_am_on_the_google_cloud_home_page() {
		googleCloudHomePage.openPage();
	}
	
}

