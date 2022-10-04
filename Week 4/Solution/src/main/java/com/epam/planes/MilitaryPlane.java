package com.epam.planes;

import java.util.Objects;
import com.epam.constants.MilitaryType;

public class MilitaryPlane extends Plane{

    private MilitaryType militaryPlaneType;

    public MilitaryPlane(String planeModel, int maximumPlaneSpeed, int maximumPlaneFlightDistance,
    		int maximumPlaneLoadCapacity, MilitaryType militaryPlaneType) {
        super(planeModel, maximumPlaneSpeed, maximumPlaneFlightDistance, maximumPlaneLoadCapacity);
        this.militaryPlaneType = militaryPlaneType;
    }

    public MilitaryType getType() {
        return militaryPlaneType;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", ", type=" + militaryPlaneType + '}');
    }

    @Override
    public boolean equals(Object o) {
    	
        if (this == o) {
        	return true;
        }
        
        if (!(o instanceof MilitaryPlane) || !super.equals(o)) {
        	return false;
        }
        
        MilitaryPlane plane = (MilitaryPlane) o;
        
        return militaryPlaneType == plane.militaryPlaneType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryPlaneType);
    }
}
