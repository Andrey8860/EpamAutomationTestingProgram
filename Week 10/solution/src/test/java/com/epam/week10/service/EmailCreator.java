package com.epam.week10.service;

import com.epam.week10.model.Email;

public class EmailCreator {
	
	public static Email createEmptyEmail() {
		return new Email();
	}
	
	public static Email createSpecificEmail(String emailAddress) {
		return new Email().setEmailAddress(emailAddress);
	}
}
