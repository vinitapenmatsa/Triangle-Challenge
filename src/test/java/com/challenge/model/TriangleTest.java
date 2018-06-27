package com.challenge.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.challenge.model.Triangle.TriangleType;

public class TriangleTest {
	
	@Test
	public void invalidTriangleTest() {
		//Test for no sides
		Triangle triangle1 = new Triangle(new double[] {});
		assertFalse(triangle1.isValid());
		
		// Test for invalid number of sides
		Triangle triangle2 = new Triangle(new double[] {2,2,3,4});
		assertFalse(triangle2.isValid());
		
		//Test for sides that do not satisfy triangle length property
		//test sum of 1st and 2nd not greater than 3rd
		Triangle triangle3 = new Triangle(new double[] {2.4,3.5,5.9});
		assertFalse(triangle3.isValid());
		
		//test sum of 1st and 3rd not greater than 2nd
		Triangle triangle4 = new Triangle(new double[] {2.4,5.9,3.5});
		assertFalse(triangle4.isValid());
		
		//test sum of 3rd and 2nd not greater than 1st
		Triangle triangle5 = new Triangle(new double[] {5.9,3.5,2.4});
		assertFalse(triangle5.isValid());
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
