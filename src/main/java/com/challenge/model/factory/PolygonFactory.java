package com.challenge.model.factory;

import org.springframework.stereotype.Component;

import com.challenge.exception.UnsupportedShapeException;
import com.challenge.model.Shape;
import com.challenge.model.Triangle;


/**
 * Class Extends Shape Factory to create N-sided Polygons.
 * Currently Supports 3-Sided Triangle.
 * Throws UnsupportedShapeException if given an array with size!=3. 
 * 
 * @author vinitapenmatsa
 */
@Component
public class PolygonFactory extends ShapeFactory{
	
	public Shape getShape(double[] sides){	
		if(sides!=null && sides.length == 3) {
			return new Triangle(sides);
		}
		throw new UnsupportedShapeException();			
	}

}
