package com.epam.week8.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {
	
	private static final String PROPERTIES_DIRECTORY = "src/test/resources/hub.properties";
	private static final Properties PROPERTIES = new Properties();
	
	private static TestDataReader reader;
	
	private TestDataReader() {
		
	}
	
	public static TestDataReader getTestDataReader() {
		if(reader == null) {
			reader = new TestDataReader();
			try {
				PROPERTIES.load(new FileInputStream(PROPERTIES_DIRECTORY));
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		return reader;
	}
	
	public String getHubURL() {
		return PROPERTIES.getProperty("hub.url");
	}
	
}
