package com.epam.week9.service;

import com.epam.week9.model.ComputeEngineGoogleCloudCalculatorEntity;

public class ComputeEngineGoogleCloudCreator {
	
	private static final String NUMBER_OF_INSTANCES = "testdata.cloud-entity.number-of-instances";
	private static final String OPERATING_SYSTEMS = "testdata.cloud-entity.operating-systems";
	private static final String VM_CLASS = "testdata.cloud-entity.vm-class";
	private static final String MACHINE_TYPE_SERIES = "testdata.cloud-entity.machine-type-series";
	private static final String MACHINE_TYPE = "testdata.cloud-entity.machine-type";
	private static final String NUMBER_OF_GPUS = "testdata.cloud-entity.number-of-gpus";
	private static final String GPU_TYPE = "testdata.cloud-entity.gpu-type";
	private static final String LOCAL_SSD = "testdata.cloud-entity.local-ssd";
	private static final String DATACENTER_LOCATION = "testdata.cloud-entity.datacenter-location";
	private static final String COMMITED_USAGE = "testdata.cloud-entity.commited-usage";
	
	public static ComputeEngineGoogleCloudCalculatorEntity emptyEntity() {
		return new ComputeEngineGoogleCloudCalculatorEntity();
	}
	
	public static ComputeEngineGoogleCloudCalculatorEntity defaultEntity() {
		return new ComputeEngineGoogleCloudCalculatorEntity()
		.setNumberOfInstances(TestDataReader.getTestData(NUMBER_OF_INSTANCES))
		.setOperatingSystems(TestDataReader.getTestData(OPERATING_SYSTEMS))
		.setVMClass(TestDataReader.getTestData(VM_CLASS))
		.setMachineTypeSeries(TestDataReader.getTestData(MACHINE_TYPE_SERIES))
		.setMachineType(TestDataReader.getTestData(MACHINE_TYPE))
		.setNumberOfGPUs(TestDataReader.getTestData(NUMBER_OF_GPUS))
		.setGPUType(TestDataReader.getTestData(GPU_TYPE))
		.setLocalSSD(TestDataReader.getTestData(LOCAL_SSD))
		.setDatacenterLocation(TestDataReader.getTestData(DATACENTER_LOCATION))
		.setCommittedUsage(TestDataReader.getTestData(COMMITED_USAGE));
	}
	
}
