package com.epam.week13.configuration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.AndroidMobileCapabilityType;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.*;
import static io.appium.java_client.remote.MobileCapabilityType.UDID;

public class CapabilitiesConfigurator {
	
	private CapabilitiesConfigurator() {
		
	}
	
	public static DesiredCapabilities getLocalCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(UDID, ConfigurationReader.getReader().getUDID());
		capabilities.setCapability(AVD, ConfigurationReader.getReader().getLocalDeviceName());
		capabilities.setCapability(APP_PACKAGE, ConfigurationReader.getReader().getAppPackage());
		capabilities.setCapability(APP_ACTIVITY, ConfigurationReader.getReader().getAppActivity());
		
		// this capability makes sure that we do not have to deal with permission popups
		capabilities.setCapability(AUTO_GRANT_PERMISSIONS, "true");
		
		// this capability ensures that driver will take a screenshot in base64 type. Otherwise an exception will be thrown
		// in recent versions of Appium
		capabilities.setCapability(AndroidMobileCapabilityType.NATIVE_WEB_SCREENSHOT, "true");
		
		return capabilities;
	}
}
