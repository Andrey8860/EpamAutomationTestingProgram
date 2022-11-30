package com.epam.week11.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestDataReader {
	
	private static final String PROPERTIES_DIRECTORY = "src/test/resources/main.properties";
	private static final Properties PROPERTIES = new Properties();
	private static final Logger LOGGER = LogManager.getRootLogger();
	
	private static TestDataReader reader;
	
	private TestDataReader() {
		
	}
	
	public static TestDataReader getReader() {
		if(reader == null) {
			reader = new TestDataReader();
			try {
				PROPERTIES.load(new FileInputStream(PROPERTIES_DIRECTORY));
			} catch (IOException ex) {
				LOGGER.fatal("Properties were not loaded: " + ex.getMessage());
			}
		}
		
		return reader;
	}
	
	public String getBrowser() {
		return PROPERTIES.getProperty("browser");
	}
}
