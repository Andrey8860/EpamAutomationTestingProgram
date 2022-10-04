package com.epam.planes;

import java.util.Objects;

public class PassengerPlane extends Plane {

	private int maximumPlanePassengerCapacity;

	public PassengerPlane(String planeModel, int maximumPlaneSpeed, int maximumPlaneFlightDistance, 
			int maximumPlaneLoadCapacity, int maximumPlanePassengerCapacity) {
		super(planeModel, maximumPlaneSpeed, maximumPlaneFlightDistance, maximumPlaneLoadCapacity);
		this.maximumPlanePassengerCapacity = maximumPlanePassengerCapacity;
	}

	public int getPassengersCapacity() {
		return maximumPlanePassengerCapacity;
	}

	@Override
	public String toString() {
		return super.toString().replace("}", ", passengersCapacity=" 
			+ maximumPlanePassengerCapacity + '}');
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (!(o instanceof PassengerPlane) || !super.equals(o)) {
			return false;
		}
		
		PassengerPlane plane = (PassengerPlane) o;
		
		return maximumPlanePassengerCapacity == plane.maximumPlanePassengerCapacity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), maximumPlanePassengerCapacity);
	}
}
