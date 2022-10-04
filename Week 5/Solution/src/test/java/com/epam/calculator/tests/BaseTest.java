package com.epam.calculator.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.epam.tat.module4.Calculator;

public class BaseTest {
	
	Calculator calculator;
	
	@BeforeMethod(groups = "Base Test")
	public void setUp() {
		calculator = new Calculator();
	}
	
	@AfterMethod
	public void tearDown() {
		calculator = null;
	}
	
}
