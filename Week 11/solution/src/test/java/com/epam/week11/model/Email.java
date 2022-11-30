package com.epam.week11.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Email {
	
	@Getter private String emailAddress;
	
	public Email setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}
}
