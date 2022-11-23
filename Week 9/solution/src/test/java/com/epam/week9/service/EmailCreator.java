package com.epam.week9.service;

import com.epam.week9.model.Email;

public class EmailCreator {
	
	public static Email emptyEmail() {
		return new Email();
	}
	
	public static Email specificEmail(String emailAddress) {
		return new Email().setEmailAddress(emailAddress);
	}
}
