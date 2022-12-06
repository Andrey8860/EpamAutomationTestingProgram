package com.epam.week14.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/com/epam/week14/cucumber/features/GoogleCloudPriceCalculator.feature",
		glue = "com.epam.week14.cucumber.step_definitions",
		tags = "@FullScopeWithEmail",
		plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json"
				, "com.epam.reportportal.cucumber.ScenarioReporter"})
public class GoogleCloudPriceCalculator extends AbstractTestNGCucumberTests {
	
}