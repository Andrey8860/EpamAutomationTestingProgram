package com.epam.planes;

import java.util.Objects;

public abstract class Plane {
    String planeModel;
    private int maximumSpeed;
    private int maximumFlightDistance;
    private int maximumLoadCapacity;

    public Plane(String planeModel, int maximumSpeed, int maximumFlightDistance, 
    		int maximumLoadCapacity) {
        this.planeModel = planeModel;
        this.maximumSpeed = maximumSpeed;
        this.maximumFlightDistance = maximumFlightDistance;
        this.maximumLoadCapacity = maximumLoadCapacity;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public int getPlaneMaximumSpeed() {
        return maximumSpeed;
    }

    public int getPlaneMaximumFlightDistance() {
        return maximumFlightDistance;
    }

    public int getMaximumLoadCapacity() {
        return maximumLoadCapacity;
    }

    @Override
    public String toString() {
        return "Plane{model='" + planeModel 
        		+ "\', maxSpeed=" + maximumSpeed 
        		+ ", maxFlightDistance=" + maximumFlightDistance 
        		+ ", maxLoadCapacity=" + maximumLoadCapacity + '}';
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof Plane)) {
			return false;
		}

		Plane plane = (Plane) o;

		return maximumSpeed == plane.maximumSpeed 
				&& maximumFlightDistance == plane.maximumFlightDistance
				&& maximumLoadCapacity == plane.maximumLoadCapacity 
				&& Objects.equals(planeModel, plane.planeModel);
	}

    @Override
    public int hashCode() {
        return Objects.hash(planeModel, maximumSpeed, maximumFlightDistance, maximumLoadCapacity);
    }
}
