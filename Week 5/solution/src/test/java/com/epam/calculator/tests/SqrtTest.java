package com.epam.calculator.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SqrtTest extends BaseTest {
	
	@Test(dataProvider = "squareRootValues", groups = "Square Root")
	public void squareRootTest(double numberToEvaluate, double expectedResult) {
		Assert.assertEquals(calculator.sqrt(numberToEvaluate), expectedResult,  0.0001,
				"Number to evaluate was " + numberToEvaluate + ";");
	}
	
	@DataProvider(name = "squareRootValues")
	public Object[][] squareRootValues() {
		return new Object[][] {
			{-1, Double.NaN},
			{0, 0},
			{1, 1},
			{25, 5},
			{25, 5},
			{20.5, 4.52769}
		};
	}
	
}
