package com.epam.planes;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Plane {
    @Getter String planeModel;
    @Getter private int maximumSpeed;
    @Getter private int maximumFlightDistance;
    @Getter private int maximumLoadCapacity;
}
