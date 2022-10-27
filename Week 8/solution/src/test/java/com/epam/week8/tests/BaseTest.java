package com.epam.week8.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	private static final String HUB_URL = "http://192.168.0.36:4444";
	protected WebDriver driver;

	@Parameters({ "browser", "platform", "instanceType" })
	@BeforeMethod(alwaysRun = true)
	public void setUp(@Optional("chrome") String browser, 
			@Optional("windows") String platform,
			@Optional("local") String instanceType) throws MalformedURLException {
		if (instanceType.equalsIgnoreCase("local")) {
			setUpLocal();
		} else {
			setUpRemote(browser, platform);
		}
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}

	private void setUpLocal() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
	}

	private void setUpRemote(String browser, String platform) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(browser);
		
		switch(platform.toLowerCase()) {
			case "windows" -> capabilities.setPlatform(Platform.WINDOWS);
		};
		
		this.driver = new RemoteWebDriver(new URL(HUB_URL), capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
	}
}
