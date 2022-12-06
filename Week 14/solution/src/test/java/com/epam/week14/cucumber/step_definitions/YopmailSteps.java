package com.epam.week14.cucumber.step_definitions;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.epam.week14.driver.DriverSingleton;
import com.epam.week14.pages.YopmailEmailInboxPage;

import io.cucumber.java.en.When;

public class YopmailSteps {
	
	WebDriver driver = DriverSingleton.getDriver();
	YopmailEmailInboxPage yopmailEmailInboxPage = new YopmailEmailInboxPage(driver);
	
	@When("The email with esimation results arrives")
	public void the_email_with_esimation_results_arrives() {
		
		ArrayList<String> windowHandles = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		
		yopmailEmailInboxPage.waitForEmail().switchToEmailIFrame();
	}
	
}
