package com.epam.week14.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

// Here I saw that in fact I already pretty much created a Builder pattern before. However, I changed some stuff
// I have used Lombok library to remove all the setters which I created - I did not know I could do this
// I also made the default constructor private, and instead added a nested static class which would actually create any kind of entity we want

@Getter
@EqualsAndHashCode
@ToString
public class ComputeEngineGoogleCloudCalculatorEntity {
	
	private final String numberOfInstances;
	private final String operatingSystems;
	private final String vMClass;
	private final String machineTypeSeries;
	private final String machineType;
	private final String numberOfGPUs;
	private final String gPUType;
	private final String localSSD;
	private final String datacenterLocation;
	private final String committedUsage;
	
	private ComputeEngineGoogleCloudCalculatorEntity(CloudEntityBuilder builder) {
		this.numberOfInstances = builder.numberOfInstances;
		this.operatingSystems = builder.operatingSystems;
		this.vMClass = builder.vMClass;
		this.machineTypeSeries = builder.machineTypeSeries;
		this.machineType = builder.machineType;
		this.numberOfGPUs = builder.numberOfGPUs;
		this.gPUType = builder.gPUType;
		this.localSSD = builder.localSSD;
		this.datacenterLocation = builder.datacenterLocation;
		this.committedUsage = builder.committedUsage;
	}
	
	@Accessors(chain = true)
	@Setter
	public static class CloudEntityBuilder {
		
		private String numberOfInstances;
		private String operatingSystems;
		private String vMClass;
		private String machineTypeSeries;
		private String machineType;
		private String numberOfGPUs;
		private String gPUType;
		private String localSSD;
		private String datacenterLocation;
		private String committedUsage;
		
		public ComputeEngineGoogleCloudCalculatorEntity build() {
			return new ComputeEngineGoogleCloudCalculatorEntity(this);
		}
	}
}
