package com.epam.week11.cucumber.step_definitions;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.epam.week11.driver.DriverSingleton;
import com.epam.week11.pages.YopmailEmailInboxPage;

import io.cucumber.java.en.When;

public class YopmailSteps {
	
	private YopmailEmailInboxPage yopmailEmailInboxPage;
	private WebDriver driver = DriverSingleton.getDriver();
	
	@When("The email with esimation results arrives")
	public void the_email_with_esimation_results_arrives() {
		yopmailEmailInboxPage = new YopmailEmailInboxPage(driver);
		
		ArrayList<String> windowHandles = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		
		yopmailEmailInboxPage.waitForEmail().switchToEmailIFrame();
	}
	
}
