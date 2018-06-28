package com.challenge.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.challenge.exception.InvalidTriangleException;
import com.challenge.model.Triangle.TriangleType;

public class TriangleTest {
	
	@Test(expected=InvalidTriangleException.class)
	public void invalidTriangleWithNoSidesTest() {
		//Test for no sides
		new Triangle(new double[] {});
	}
	
	@Test(expected=InvalidTriangleException.class)
	public void invalidTriangleWithTooManySidesTest() {
		// Test for invalid number of sides
        new Triangle(new double[] {2,2,3,4});
	}
	
	@Test(expected=InvalidTriangleException.class)
	public void invalidTriangleWrongLengths1() {
		//Test for sides that do not satisfy triangle length property
		//test sum of 1st and 2nd not greater than 3rd
		new Triangle(new double[] {2.4,3.5,5.9});
	}

	@Test(expected=InvalidTriangleException.class)
	public void invalidTriangleWrongLengths2() {
		//Test for sides that do not satisfy triangle length property
		//test sum of 1st and 2nd not greater than 3rd
		new Triangle(new double[] {2.4,5.9,3.5});
	}
	
	@Test(expected=InvalidTriangleException.class)
	public void invalidTriangleWrongLengths3() {
		//Test for sides that do not satisfy triangle length property
		//test sum of 1st and 2nd not greater than 3rd
		new Triangle(new double[] {5.9,3.5,2.4});
	}
		
	
	@Test
	public void validTriangleTest() {
		
		/*Test for a triangle that satisfies all conditions
		 * 1. 3 sides
		 * 2. sum of any 2 sides is greater than the third
		 */
		Triangle triangle = new Triangle(new double[] {2.4,5.8,3.5});
		assertTrue(triangle.isValid());	
		
	}
	
	@Test
	public void equilateralTriangleTest() {	
		Triangle triangle = new Triangle(new double[] {2,2,2});
		assertEquals(TriangleType.EQUILATERAL.toString(), triangle.getType());
	}
	
	@Test
	public void isoscelesTriangleTest() {
		Triangle triangle = new Triangle(new double[] {3,3,5});
		assertEquals(TriangleType.ISOSCELES.toString(), triangle.getType());
		
		Triangle triangle1 = new Triangle(new double[] {3,5,3});
		assertEquals(TriangleType.ISOSCELES.toString(), triangle1.getType());
		
		Triangle triangle2 = new Triangle(new double[] {5,3,3});
		assertEquals(TriangleType.ISOSCELES.toString(), triangle2.getType());
	}
	
	@Test
	public void scaleneTriangleTest() {
		Triangle triangle = new Triangle(new double[] {3,4,5});
		assertEquals(TriangleType.SCALENE.toString(), triangle.getType());
	}
	

}
