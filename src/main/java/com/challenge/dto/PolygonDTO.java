package com.challenge.dto;

public class PolygonDTO extends ShapeDTO {
	
	private double[] sides;

	/**
	 * @return the sidesOfPolygon
	 */
	public double[] getSides() {
		return sides;
	}

	/**
	 * @param sidesOfPolygon the sidesOfPolygon to set
	 */
	public void setSides(double[] sides) {
		this.sides = sides;
	}
	

}
