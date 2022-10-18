package com.epam.planes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class PassengerPlane extends Plane {

	@Getter private int maximumPlanePassengerCapacity;

	public PassengerPlane(String planeModel, int maximumPlaneSpeed, int maximumPlaneFlightDistance, 
			int maximumPlaneLoadCapacity, int maximumPlanePassengerCapacity) {
		super(planeModel, maximumPlaneSpeed, maximumPlaneFlightDistance, maximumPlaneLoadCapacity);
		this.maximumPlanePassengerCapacity = maximumPlanePassengerCapacity;
	}
}
