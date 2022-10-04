package com.epam.calculator.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SinTest extends BaseTest {
	
	@Test(dataProvider = "sineValues", groups = "Trigonometric Functions")
	public void cosinusTest(double numberToEvaluate, double expectedResult) {
		Assert.assertEquals(calculator.sin(numberToEvaluate), expectedResult,  0.0001,
				"Number to evaluate was " + numberToEvaluate + ";");
	}
	
	@DataProvider(name = "sineValues")
	public Object[][] sineValues() {
		return new Object[][] {
			{0, 0},
			{359, 0.75682},
			{180, -0.80115},
			{100, -0.50636},
			{-1, -0.84147},
			{-243, 0.89000},
			{-360, -0.95891}
		};
	}
	
}
