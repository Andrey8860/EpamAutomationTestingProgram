package com.epam.week12.tests;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.epam.week12.constants.Banner;
import com.epam.week12.requests.ProductRequest;

public class WODPTests {
	
	@Test(dataProvider = "products")
	public void statusCodeTest(Banner banner, String environment, String product, String storeId) {
		new ProductRequest(banner, environment, product, storeId)
		.sendRequest()
		.then()
		.assertThat().statusCode(200);
	}
	
	@Test(dataProvider = "products")
	public void responseHeaderTest(Banner banner, String environment, String product, String storeId) {
		new ProductRequest(banner, environment, product, storeId)
		.sendRequest()
		.then()
		.assertThat().header("content-type", "application/json; charset=utf-8");
	}
	
	@Test(dataProvider = "products")
	public void responseBodyTest(Banner banner, String environment, String product, String storeId) {
		new ProductRequest(banner, environment, product, storeId)
		.sendRequest()
		.then()
		.assertThat().body("currentPrice.size()", equalTo(3))
		.assertThat().body("currentPrice.value", notNullValue());
	}
	
	// This data provide has some products which will fail the responseBodyTest since the currentPrice value would be null
	// This is done on purpose, to illustrate that test works. Also, if we would be using Cucumber in this module, this could
	// be replaced with a data table or a scenario outline with examples
	@DataProvider(name = "products")
	public Object[][] productsToGet() {
		return new Object[][] {
			{Banner.SPORTCHEK, "qa3", "10613086f", "383"},
			{Banner.ATMOSPHERE, "qa3", "13359154f", "107"},
			{Banner.MARKS, "qa3", "75988577f", "730"},
			{Banner.LEQUIPEUR_EN, "qa3", "12604271f", "740"},
			{Banner.LEQUIPEUR_FR, "qa3", "12604271f", "740"},
		};
	}
}
