package com.epam.week11.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/com/epam/week11/cucumber/features/GoogleCloudSearch.feature",
		glue = "com.epam.week11.cucumber.step_definitions",
		tags = "@Smoke",
		plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"})
public class Smoke extends AbstractTestNGCucumberTests {
	
}
