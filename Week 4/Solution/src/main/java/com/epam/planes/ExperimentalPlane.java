package com.epam.planes;

import com.epam.constants.ClassificationLevel;
import com.epam.constants.ExperimentalType;

public class ExperimentalPlane extends Plane {

	private ExperimentalType experimentalPlaneType;
	private ClassificationLevel classificationLevel;

	public ExperimentalPlane(String planeModel, int maximumPlaneSpeed, 
			int maximumPlaneFlightDistance, int maximumPlaneLoadCapacity,
			    ExperimentalType experimentalPlaneType, ClassificationLevel classificationLevel) {
		super(planeModel, maximumPlaneSpeed, maximumPlaneFlightDistance, maximumPlaneLoadCapacity);
		this.experimentalPlaneType = experimentalPlaneType;
		this.classificationLevel = classificationLevel;
	}

	public ClassificationLevel getClassificationLevel() {
		return classificationLevel;
	}

	public void setClassificationLevel(ClassificationLevel classificationLevel) {
		this.classificationLevel = classificationLevel;
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "experimentalPlane{model='" + planeModel + "\' }";
	}
}
