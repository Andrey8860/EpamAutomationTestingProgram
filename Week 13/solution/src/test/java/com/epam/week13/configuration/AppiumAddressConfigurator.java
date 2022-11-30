package com.epam.week13.configuration;

import java.io.IOException;
import java.net.ServerSocket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


public class AppiumAddressConfigurator {
	
	private static final Logger LOGGER = LogManager.getRootLogger();
	private static AppiumDriverLocalService appiumDriverLocalService;
	private static final String KILL_NODE_COMMAND = "taskkill /F /IM node.exe";
	
	private AppiumAddressConfigurator() {
		
	}
	
	public static AppiumDriverLocalService getAppiumDriverLocalService(int port) {
		if(appiumDriverLocalService == null) {
			startService(port);
		}
		return appiumDriverLocalService;
	}
	
	public static void startService(int port) {
		freePort(port);
		appiumDriverLocalService = new AppiumServiceBuilder()
			.withIPAddress(ConfigurationReader.getReader().getAppiumAddress())
			.usingPort(port)
			.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
			.withArgument(GeneralServerFlag.BASEPATH, "/")
			.withArgument(GeneralServerFlag.LOG_LEVEL, "info:error")
			.build();
		appiumDriverLocalService.start();
		LOGGER.info("Appium service started on port {}", port);
	}
	
	public static void stopService() {
		if(appiumDriverLocalService != null) {
			appiumDriverLocalService.stop();
		}
		LOGGER.info("Appium service stopped");
	}
	
	private static void freePort(int port) {
		if(!isPortFree(port)) {
			try {
				Runtime.getRuntime().exec(KILL_NODE_COMMAND);
			} catch (IOException ex) {
				LOGGER.error("Could not free node. Message: " + ex.getMessage());
			}
		}
	}
	
	private static boolean isPortFree(int port) {
		boolean isFree = true;
		
		try(ServerSocket ignored = new ServerSocket(port)) {
			LOGGER.info("Port {} is available and free to use", port);
		} catch(Exception ex) {
			isFree = false;
			LOGGER.warn("Port {} is occupied. Process will be terminated", port);
		}
		return isFree;
	}
}
