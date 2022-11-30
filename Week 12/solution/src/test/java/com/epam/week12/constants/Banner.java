package com.epam.week12.constants;

import lombok.Getter;

// I have used an enum here, since overall the banners and their variables which might affect the response do not change that much
// It allows not only to manage this in a single place, but also allows to not make any mistake in how locale is written, for example

public enum Banner {
	MARKS("MKS", "https://apim-nprd.marks.com/public/", "en_CA"), 
	SPORTCHEK("SC", "https://apim-nprd.sportchek.ca/public/", "en_CA"), 
	ATMOSPHERE("ATM", "https://apim-nprd.atmosphere.ca/public/", "en_CA"), 
	LEQUIPEUR_EN("LEQ", "https://apim-nprd.lequipeur.com/public/", "en_CA"),
	LEQUIPEUR_FR("LEQ", "https://apim-nprd.lequipeur.com/public/", "fr_CA");
	
	@Getter private String baseSite;
	@Getter private String APIMBaseURL;
	@Getter private String locale;
	
	Banner(String baseSite, String aPIMBaseURL, String locale) {
		this.baseSite = baseSite;
		this.APIMBaseURL = aPIMBaseURL;
		this.locale = locale;
	}
}
