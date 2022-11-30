package com.epam.week11.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/com/epam/week11/cucumber/features/GoogleCloudPriceCalculator.feature",
		glue = "com.epam.week11.cucumber.step_definitions",
		tags = "@FullScopeWithEmail",
		plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json"})
public class GoogleCloudPriceCalculator extends AbstractTestNGCucumberTests {
	
}