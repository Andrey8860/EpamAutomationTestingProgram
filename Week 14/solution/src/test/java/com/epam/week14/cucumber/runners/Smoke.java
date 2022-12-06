package com.epam.week14.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/com/epam/week14/cucumber/features/GoogleCloudSearch.feature",
		glue = "com.epam.week14.cucumber.step_definitions",
		tags = "@Smoke",
		plugin = {"pretty", "com.epam.reportportal.cucumber.ScenarioReporter"})
public class Smoke extends AbstractTestNGCucumberTests {
	
}
