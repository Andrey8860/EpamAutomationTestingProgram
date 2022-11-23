package com.epam.week9.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class ComputeEngineGoogleCloudCalculatorEntity {
	
	@Getter private String numberOfInstances;
	@Getter private String operatingSystems;
	@Getter private String vMClass;
	@Getter private String machineTypeSeries;
	@Getter private String machineType;
	@Getter private String numberOfGPUs;
	@Getter private String gPUType;
	@Getter private String localSSD;
	@Getter private String datacenterLocation;
	@Getter private String committedUsage;
	
	public ComputeEngineGoogleCloudCalculatorEntity setNumberOfInstances(String numberOfInstances) {
		this.numberOfInstances = numberOfInstances;
		return this;
	}
	public ComputeEngineGoogleCloudCalculatorEntity setOperatingSystems(String operatingSystems) {
		this.operatingSystems = operatingSystems;
		return this;
	}
	public ComputeEngineGoogleCloudCalculatorEntity setVMClass(String vMClass) {
		this.vMClass = vMClass;
		return this;
	}
	public ComputeEngineGoogleCloudCalculatorEntity setMachineTypeSeries(String machineTypeSeries) {
		this.machineTypeSeries = machineTypeSeries;
		return this;
	}
	public ComputeEngineGoogleCloudCalculatorEntity setMachineType(String machineType) {
		this.machineType = machineType;
		return this;
	}
	public ComputeEngineGoogleCloudCalculatorEntity setNumberOfGPUs(String numberOfGPUs) {
		this.numberOfGPUs = numberOfGPUs;
		return this;
	}
	public ComputeEngineGoogleCloudCalculatorEntity setGPUType(String gPUType) {
		this.gPUType = gPUType;
		return this;
	}
	public ComputeEngineGoogleCloudCalculatorEntity setLocalSSD(String localSSD) {
		this.localSSD = localSSD;
		return this;
	}
	public ComputeEngineGoogleCloudCalculatorEntity setDatacenterLocation(String datacenterLocation) {
		this.datacenterLocation = datacenterLocation;
		return this;
	}
	public ComputeEngineGoogleCloudCalculatorEntity setCommittedUsage(String committedUsage) {
		this.committedUsage = committedUsage;
		return this;
	}
	
}
