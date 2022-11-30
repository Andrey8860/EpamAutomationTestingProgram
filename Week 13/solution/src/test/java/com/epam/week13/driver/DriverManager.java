package com.epam.week13.driver;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.week13.configuration.AppiumAddressConfigurator;
import com.epam.week13.configuration.CapabilitiesConfigurator;
import com.epam.week13.configuration.ConfigurationReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class DriverManager {
	
	private static final Logger LOGGER = LogManager.getRootLogger();
	private static AppiumDriver driver;
	

	private DriverManager() {

	}
	
	public static AppiumDriver getDriver() {
		if (driver == null) {
			driver = new AndroidDriver(AppiumAddressConfigurator
					.getAppiumDriverLocalService(ConfigurationReader.getReader().getAppiumPort())
					, CapabilitiesConfigurator.getLocalCapabilities());
			
			LOGGER.info("Driver singleton has been created");
		}
		
		return driver;
	}
	
	public static void closeDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		
		LOGGER.info("Driver has been closed");
	}
	
	public static void closeAppium() {
		AppiumAddressConfigurator.stopService();
	}
	
	public static void closeEmulator() {
		try {
			Runtime.getRuntime().exec(String.format("adb -s %s emu kill", 
					ConfigurationReader.getReader().getUDID()));
			
			LOGGER.info("Emulator has been closed");
		} catch (IOException ex) {
			LOGGER.info("Emulator has not been closed. An exception occurred: " + ex.getMessage());
		}
	}
}
