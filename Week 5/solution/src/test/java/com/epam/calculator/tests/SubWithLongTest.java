package com.epam.calculator.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubWithLongTest extends BaseTest {
	
	@Test(dataProvider = "subtractionValues", groups = "Basic Math Operations")
	public void subWithDoubleTest(long minuend, long subtrahend, long expectedResult) {
		Assert.assertEquals(calculator.sub(minuend, subtrahend), expectedResult, 
				"Minuend was " + minuend + ", subtrahend was " + subtrahend + ";");
	}
	
	@DataProvider(name = "subtractionValues")
	public Object[][] subtractionValues() {
		return new Object[][] {
			{0, 0, 0},
			{1, 0, 1},
			{0, 1, -1},
			{-1, 1, -2},
			{-1, -1, 0},
			{25534, 7891, 17643},
			{-25534, 7891, -33425},
			{25534, -7891, 33425},
			{-25534, -7891, -17643}
		};
	}
}
