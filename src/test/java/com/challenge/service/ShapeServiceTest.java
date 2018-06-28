package com.challenge.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.challenge.dto.PolygonDTO;
import com.challenge.exception.InvalidTriangleException;
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
	
	Shape shape;
	PolygonDTO polygonDTO;
	
	@Before
	public void setUp() {
	   shape = new Triangle(new double[] {3,4,5});
	   
	   polygonDTO = new PolygonDTO();
	   polygonDTO.setSides(new double[] {2,2,2});
	   
	}
	
	@Test
	public void testGetPolygonTypeForValidTriangle() {
		//testing for a triangle type
		when(shapeFactory.getShape(any(double[].class))).thenReturn(shape);
		String resultForScaleneTriangle = shapeService.getPolygonType(polygonDTO);
		assertEquals("SCALENE", resultForScaleneTriangle);		
	}
	
	@Test(expected=InvalidTriangleException.class)
	public void testGetPolygonTypeForInValidTriangle() {
		//testing for an invalid triangle
		when(shapeFactory.getShape(any(double[].class))).thenThrow(InvalidTriangleException.class);
		shapeService.getPolygonType(polygonDTO);

	}
	
}
