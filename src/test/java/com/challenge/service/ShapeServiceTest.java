package com.challenge.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.challenge.dto.PolygonDTO;
import com.challenge.model.Shape;
import com.challenge.model.Triangle;
import com.challenge.model.factory.ShapeFactory;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShapeServiceTest {
	
	@Autowired
	ShapeService shapeService;
	
	@MockBean
	ShapeFactory shapeFactory;
	
	Shape shape1, shape2;
	PolygonDTO polygonDTO;
	
	@Before
	public void setUp() {
	   shape1 = new Triangle(new double[] {3,4,5});
	   shape2 = new Triangle(new double[] {3,2,5});
	   
	   polygonDTO = new PolygonDTO();
	   polygonDTO.setSides(new double[] {2,2,2});
	   
	   when(shapeFactory.getShape(any(double[].class))).thenReturn(shape1, shape2,shape1,shape2);
	}
	
	@Test
	public void testGetPolygonType() {
		//testing for a triangle type
		String resultForScaleneTriangle = shapeService.getPolygonType(polygonDTO);
		assertEquals("SCALENE", resultForScaleneTriangle);
		
		//testing for an invalid triangle
		String resultForInvalidTriangle = shapeService.getPolygonType(polygonDTO);
		assertEquals("INVALID", resultForInvalidTriangle);
		
	}
	
	@Test
	public void testIsValidPolygon() {
		//testing for a valid polygon
		boolean resultForValidPolygon = shapeService.isValidPolygon(polygonDTO);
		assertEquals(true, resultForValidPolygon);
		
		//testing for an invalid polygon
		boolean resultForInValidPolygon = shapeService.isValidPolygon(polygonDTO);
		assertEquals(false, resultForInValidPolygon);
		
	}

}
