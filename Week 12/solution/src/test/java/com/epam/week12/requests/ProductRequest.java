package com.epam.week12.requests;

import java.util.HashMap;
import com.epam.week12.constants.Banner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true)
@Setter
@NoArgsConstructor
public class ProductRequest extends BaseRequest {
	
	// Normally API keys would not be stored like this, but since the home exercise is simply I decided not to overcomplicate it
	// just because of one field
	private static final String API_KEY = "fee9b3ee47af44a7900c5a2a91484ddb";
	
	private HashMap<String, Object> headers = new HashMap<>();
	private Banner banner;
	private String environment;
	private String product;
	private String storeId;
	
	// This constructor allows enough flexibility to make any product request. At the same time, I do not forbid
	// creating the default object, which can be configured separately, if needed, through setters
	public ProductRequest(Banner banner, String environment, String product, String storeId) {
		this.banner = banner;
		this.product = product;
		this.storeId = storeId;
		this.environment = environment;
	}
	
	@Override
	public Response sendRequest() {
		// In this case we set the headers the same way, no matter what, even if user would push his own headers into the map.
		// It is not flexible overall, but it is completely fine for this type of request, since setUpBaseHeaders method only
		// sets the baseSite, which is coming from the Banner enum anyway, and API KEY, which normally would, anyway, be stored
		// separately, not in the class
		setUpBaseHeaders();
		return RestAssured.given().headers(headers).when().get(setUpURL());
	}
	
	// Here we are pushing the basic headers without which the request would not work at all. We are not adding 
	// headers which are optional - this can be done separately
	private HashMap<String, Object> setUpBaseHeaders() {
		headers.put("basesiteid", banner.getBaseSite());
		headers.put("ocp-apim-subscription-key", API_KEY);
		
		return headers;
	}
	
	// Here I am using String format() method to construct the URL with all the necessary query params. Note that this method is
	// not present in BaseRequest class on purpose, since not all requests would need to have query params
	private String setUpURL() {
		return String.format(banner.getAPIMBaseURL() + 
				"%s/v1/product/api/v1/product/%s?baseStoreId=%s&lang=%s&storeId=%s"
				, environment, product, banner.getBaseSite(), banner.getLocale(), storeId);
	}
}
