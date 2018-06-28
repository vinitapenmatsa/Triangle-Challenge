package com.challenge.model;

import com.challenge.exception.InvalidTriangleException;

/**
 *  Triangle implementation of Shape Interface.
 *  Takes a list of 3 double values ( lengths of sides of the triangle ).
 *  In addition to implementing isValid() and getType() of Shape Interface also has methods to 
 *  checks if given triangle is EQUILATERAL / ISOSCELES / SCLAENE.
 *
 *  @author vinitapenmatsa
 */
public class Triangle extends Polygon {

	public enum TriangleType{ EQUILATERAL , ISOSCELES , SCALENE };

	public Triangle(double[] sides) {
		super(sides);
		if(!isValid())
			throw new InvalidTriangleException();
	}

	/**
	 * (non-Javadoc)
	 * @see com.challenge.model.Polygon#isValid()
	 * Validates properties of a triangle
	 * 1. Has 3 sides
	 * 2. Sum of any two sides of a triangle is greater than the third
	 */
	@Override
	public boolean isValid() {
		if(numberOfSides() != 3)
			return false;

		if(sides[0] + sides[1] <= sides[2] 
				|| sides[1] + sides[2] <= sides[0] 
						|| sides[0] + sides[2] <= sides[1])
			return false;

		return true;
	}

	/**
	 * checks the sides of a triangle and returns EQUILATERAL/ISOSCELES/SCALENE.
	 * 1. If all 3 sides are equal - EQUILATERAL.
	 * 2. If any 2 sides are equal - ISOSCELES.
	 * 3. SCALENE otherwise.
	 */
	@Override
	public String getType() {
		
			if(isEquilateral())
				return TriangleType.EQUILATERAL.toString();
			else if((sides[0] == sides[1]) || (sides[1] == sides[2]) || (sides[2] == sides[0]))
				return TriangleType.ISOSCELES.toString();

			return TriangleType.SCALENE.toString();
	}
}
