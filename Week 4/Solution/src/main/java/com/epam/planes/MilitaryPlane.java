package com.epam.planes;

import com.epam.constants.MilitaryType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class MilitaryPlane extends Plane{

    @Getter private MilitaryType militaryPlaneType;

    public MilitaryPlane(String planeModel, int maximumPlaneSpeed, int maximumPlaneFlightDistance,
    		int maximumPlaneLoadCapacity, MilitaryType militaryPlaneType) {
        super(planeModel, maximumPlaneSpeed, maximumPlaneFlightDistance, maximumPlaneLoadCapacity);
        this.militaryPlaneType = militaryPlaneType;
    }
}
