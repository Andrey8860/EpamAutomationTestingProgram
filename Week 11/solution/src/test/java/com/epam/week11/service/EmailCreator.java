package com.epam.week11.service;

import com.epam.week11.model.Email;

public class EmailCreator {
	
	public static Email createEmptyEmail() {
		return new Email();
	}
	
	public static Email createSpecificEmail(String emailAddress) {
		return new Email().setEmailAddress(emailAddress);
	}
}
