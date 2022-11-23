package com.epam.week10.service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public final class TimeService {
	
	public static String getCurrentTimeAsString() {
		return ZonedDateTime.now().format(DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss"));
	}
	
}
