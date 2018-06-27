package com.challenge.factory;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.challenge.exception.UnsupportedShapeException;
import com.challenge.model.Shape;
import com.challenge.model.Triangle;
import com.challenge.model.factory.PolygonFactory;
import com.challenge.model.factory.ShapeFactory;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShapeFactoryTest {
	
	ShapeFactory shapeFactory;
	
	@Before
	public void setUp() {
		shapeFactory = new PolygonFactory();
	}
	
	
	@Test(expected=UnsupportedShapeException.class)
	public void unsupportedPolygonTest(){
		shapeFactory.getShape(new double[]{2,4,3,4,5});
	}
	
	@Test(expected=UnsupportedShapeException.class)
	public void unsupportedPolygonTestForNull(){
		shapeFactory.getShape(null);
	}
	
	@Test
	public void createNewTriangleTest() {
		Shape shape = shapeFactory.getShape(new double[]{3,4,5});
		assertTrue(shape instanceof Triangle);
	}

}
