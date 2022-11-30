package com.epam.week12.requests;

import io.restassured.response.Response;

// For this exercise the abstract class might not really be needed since we have only one type of request, but overall
// it can still be used later for extension, even if for now there is only one method which certainly is present in all requests

public abstract class BaseRequest {
	
	public abstract Response sendRequest();
	
}
