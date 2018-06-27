package com.challenge.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.challenge.model.Polygon.PolygonType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class PolygonTest{
	
	@Test
	public void invalidPolygonTest() {
		PolygonMockService polygonMockService = new PolygonMockService(new double[] {2,2});
		assertFalse(polygonMockService.isValid());
	}

	@Test
	public void validPolygonTest() {
		PolygonMockService polygonMockService = new PolygonMockService(new double[] {2,2,2,2});
        assertTrue(polygonMockService.isValid());
	}
	
	@Test
	public void numberOfSidesTest() {
		PolygonMockService polygonMockService = new PolygonMockService(new double[] {2,2,2,2,3,4,4});
        assertEquals(7, polygonMockService.numberOfSides());

	}
	
	@Test
	public void getTypeTest() {
		//test for equilateral type
		PolygonMockService polygonMockService = new PolygonMockService(new double[] {2,2,2,2,2,2,2});
		assertEquals(PolygonType.EQUILATERAL.toString(), polygonMockService.getType());
		
		//test for unknown type
		PolygonMockService polygonMockService1 = new PolygonMockService(new double[] {2,2,2,2,2,2,3});
		assertEquals(PolygonType.UNKNOWN.toString(), polygonMockService1.getType());
		 
		//test for invalid type
		PolygonMockService polygonMockService2 = new PolygonMockService(new double[] {2});
		assertEquals(PolygonType.INVALID.toString(), polygonMockService2.getType());

	}
	
	@Test
	public void isEquilateralTest() {
		// test for equilateral polygon
		PolygonMockService polygonMockService = new PolygonMockService(new double[] {2,2,2,2,2,2,2,2});
        assertTrue(polygonMockService.isEquilateral());
        
         // test for non - equilateral polygon
     	polygonMockService = new PolygonMockService(new double[] {2,2,2,2,2,2,2,2.1});
        assertFalse(polygonMockService.isEquilateral());

	}
	
}
