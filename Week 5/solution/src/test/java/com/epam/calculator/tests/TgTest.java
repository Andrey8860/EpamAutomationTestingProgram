package com.epam.calculator.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TgTest extends BaseTest {
	
	@Test(dataProvider = "tangentValues", groups = "Trigonometric Functions")
	public void tangentTest(double numberToEvaluate, double expectedResult) {
		Assert.assertEquals(calculator.tg(numberToEvaluate), expectedResult,  0.0001,
				"Number to evaluate was " + numberToEvaluate + ";");
	}
	
	@DataProvider(name = "tangentValues")
	public Object[][] tangentValues() {
		return new Object[][] {
			{1, 1.55740},
			{360, -3.38014},
			{-12, 0.63585},
			{0, 0},
			{-360, 3.38014}
		};
	}
	
}
