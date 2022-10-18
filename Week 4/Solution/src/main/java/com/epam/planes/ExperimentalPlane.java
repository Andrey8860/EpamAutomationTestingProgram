package com.epam.planes;

import com.epam.constants.ClassificationLevel;
import com.epam.constants.ExperimentalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class ExperimentalPlane extends Plane {

	private ExperimentalType experimentalPlaneType;
	@Getter @Setter private ClassificationLevel classificationLevel;

	public ExperimentalPlane(String planeModel, int maximumPlaneSpeed, 
			int maximumPlaneFlightDistance, int maximumPlaneLoadCapacity,
			    ExperimentalType experimentalPlaneType, ClassificationLevel classificationLevel) {
		super(planeModel, maximumPlaneSpeed, maximumPlaneFlightDistance, maximumPlaneLoadCapacity);
		this.experimentalPlaneType = experimentalPlaneType;
		this.classificationLevel = classificationLevel;
	}
}
