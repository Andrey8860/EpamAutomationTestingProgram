package com.epam.calculator.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CosTest extends BaseTest {
	
	@Test(dataProvider = "cosinusValues", groups = "Trigonometric Functions")
	public void cosinusTest(double numberToEvaluate, double expectedResult) {
		Assert.assertEquals(calculator.cos(numberToEvaluate), expectedResult, 0.0001,
				"Number to evaluate was " + numberToEvaluate + ";");
	}
	
	@DataProvider(name = "cosinusValues")
	public Object[][] cosinusValues() {
		return new Object[][] {
			{0, 1},
			{Math.PI, -1},
			{359, 0.65362},
			{180, -0.59846},
			{100, 0.86231},
			{-1, 0.54030},
			{-243, -0.45594},
			{-360, -0.28369}
		};
	}
	
}
