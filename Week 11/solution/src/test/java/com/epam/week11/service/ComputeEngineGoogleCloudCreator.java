package com.epam.week11.service;

import com.epam.week11.model.ComputeEngineGoogleCloudCalculatorEntity;

public class ComputeEngineGoogleCloudCreator {
	
	public static ComputeEngineGoogleCloudCalculatorEntity emptyEntity() {
		return new ComputeEngineGoogleCloudCalculatorEntity.CloudEntityBuilder().build();
	}
	
}
