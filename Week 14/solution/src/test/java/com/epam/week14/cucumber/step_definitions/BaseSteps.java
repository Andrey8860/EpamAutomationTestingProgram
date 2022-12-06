package com.epam.week14.cucumber.step_definitions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.mail.MessagingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.week14.driver.DriverSingleton;
import com.epam.week14.model.Email;
import com.epam.week14.service.EmailCreator;
import com.epam.week14.service.ReportSender;
import com.epam.week14.service.ScreenshotTaker;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BaseSteps {
	
	private final static String PASSED_SCREENSHOTS_PATH = ".//target/screenshots/passed/";
	private final static String FAILED_SCREENSHOTS_PATH = ".//target/screenshots/failed/";
	private final static Email REPORT_RECIPIENT = 
			EmailCreator.createSpecificEmail("andrey886060@gmail.com");
	
	private final Logger logger = LogManager.getRootLogger();
	
	
	@Before
	public void setUp() {
		DriverSingleton.getDriver();
	}
	
	@After
	public void tearDown() {
		DriverSingleton.closeDriver();
	}
	
	@After
	public void takeScreenshot(Scenario scenario) throws IOException{
	    File screenshot;
		
		if(scenario.isFailed()) {
	    	screenshot = ScreenshotTaker.saveScreenshot(FAILED_SCREENSHOTS_PATH);
	    } else {
	    	screenshot = ScreenshotTaker.saveScreenshot(PASSED_SCREENSHOTS_PATH);
	    }
		
		scenario.attach(Files.readAllBytes(screenshot.toPath()), "image/png", scenario.getName());
	}
	
	@After
	public void sendReport() {
		try {
			ReportSender.sendReport(REPORT_RECIPIENT.getEmailAddress());
			logger.info("Report sent to " + REPORT_RECIPIENT.getEmailAddress());
		} catch (MessagingException e) {
			logger.error("Report not send due to an error: " + e.getMessage());
		}
	}
}
