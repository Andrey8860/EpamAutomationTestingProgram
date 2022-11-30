package com.epam.week13.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigurationReader {
	
	private static final String PROPERTIES_DIRECTORY = "src/test/resources/test.properties";
	private static final Properties PROPERTIES = new Properties();
	private static final Logger LOGGER = LogManager.getRootLogger();
	
	private static ConfigurationReader reader;
	
	private ConfigurationReader() {
		
	}
	
	public static ConfigurationReader getReader() {
		if(reader == null) {
			reader = new ConfigurationReader();
			try {
				PROPERTIES.load(new FileInputStream(PROPERTIES_DIRECTORY));
			} catch (IOException ex) {
				LOGGER.fatal("Properties were not loaded: " + ex.getMessage());
			}
		}
		
		return reader;
	}
	
	public String getAppPath() {
		return PROPERTIES.getProperty("app.path");
	}
	
	public String getAppPackage() {
		return PROPERTIES.getProperty("app.package");
	}
	
	public String getAppActivity() {
		return PROPERTIES.getProperty("app.activity");
	}
	
	public String getPlatformName() {
		return PROPERTIES.getProperty("platform.name");
	}
	
	public String getPlatformVersion() {
		return PROPERTIES.getProperty("platform.version");
	}
	
	public String getLocalDeviceName() {
		return PROPERTIES.getProperty("local.device.name");
	}
	
	public String getUDID() {
		return PROPERTIES.getProperty("udid");
	}
	
	public String getAppiumAddress() {
		return PROPERTIES.getProperty("appium.address");
	}
	
	public int getAppiumPort() {
		return NumberUtils.toInt(PROPERTIES.getProperty("appium.port"));
	}
}
