// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

package com.epam.airport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.epam.constants.MilitaryType;
import com.epam.planes.ExperimentalPlane;
import com.epam.planes.MilitaryPlane;
import com.epam.planes.PassengerPlane;
import com.epam.planes.Plane;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Airport {
	@Getter private List<? extends Plane> planes;

	public List<PassengerPlane> getPassengerPlanes() {
		List<PassengerPlane> passengerPlanes = new ArrayList<>();
		
		for (Plane plane : this.planes) {
			if (plane instanceof PassengerPlane) {
				passengerPlanes.add((PassengerPlane) plane);
			}
		}
		
		return passengerPlanes;
	}

	public List<MilitaryPlane> getMilitaryPlanes() {
		List<MilitaryPlane> militaryPlanes = new ArrayList<>();
		
		for (Plane plane : this.planes) {
			if (plane instanceof MilitaryPlane) {
				militaryPlanes.add((MilitaryPlane) plane);
			}
		}
		
		return militaryPlanes;
	}

	public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
		List<PassengerPlane> passengerPlanes = getPassengerPlanes();
		PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
		
		for (int i = 0; i < passengerPlanes.size(); i++) {
			if (passengerPlanes.get(i).getMaximumPlanePassengerCapacity() 
					> planeWithMaxCapacity.getMaximumPlanePassengerCapacity()) {
				planeWithMaxCapacity = passengerPlanes.get(i);
			}
		}
		
		return planeWithMaxCapacity;
	}

	public List<MilitaryPlane> getTransportMilitaryPlanes() {
		List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
		
		for (MilitaryPlane militaryPlane : getMilitaryPlanes()) {
			if (militaryPlane.getMilitaryPlaneType() == MilitaryType.TRANSPORT) {
				transportMilitaryPlanes.add(militaryPlane);
			}
		}
		
		return transportMilitaryPlanes;
	}

	public List<MilitaryPlane> getBomberMilitaryPlanes() {
		List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
		
		for (MilitaryPlane militaryPlane : getMilitaryPlanes()) {
			if (militaryPlane.getMilitaryPlaneType() == MilitaryType.BOMBER) {
				bomberMilitaryPlanes.add(militaryPlane);
			}
		}
		
		return bomberMilitaryPlanes;
	}

	public List<ExperimentalPlane> getExperimentalPlanes() {
		List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
		
		for (Plane plane : planes) {
			if (plane instanceof ExperimentalPlane) {
				experimentalPlanes.add((ExperimentalPlane) plane);
			}
		}
		
		return experimentalPlanes;
	}

	public Airport sortByMaxDistance() {
		Collections.sort(planes, (firstPlane, secondPlane) -> 
			firstPlane.getMaximumFlightDistance() - secondPlane.getMaximumFlightDistance());
		
		return this;
	}

	public Airport sortByMaxSpeed() {
		Collections.sort(planes, (firstPlane, secondPlane) -> 
			firstPlane.getMaximumSpeed() - secondPlane.getMaximumSpeed());
		
		return this;
	}

	public Airport sortByMaxLoadCapacity() {
		Collections.sort(planes, (firstPlane, secondPlane) -> 
			firstPlane.getMaximumLoadCapacity() - secondPlane.getMaximumLoadCapacity());
		
		return this;
	}
}
