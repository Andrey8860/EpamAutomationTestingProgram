package com.epam.week14.service;

import com.epam.week14.model.ComputeEngineGoogleCloudCalculatorEntity;

public class ComputeEngineGoogleCloudCreator {
	
	public static ComputeEngineGoogleCloudCalculatorEntity emptyEntity() {
		return new ComputeEngineGoogleCloudCalculatorEntity.CloudEntityBuilder().build();
	}
	
}
