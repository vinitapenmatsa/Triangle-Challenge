package com.challenge.model.factory;

import org.springframework.stereotype.Component;

import com.challenge.exception.UnsupportedShapeException;
import com.challenge.model.Shape;

/** 
 * Abstract Factory to create shape objects.
 * @author vinitapenmatsa
 */
@Component
public abstract class ShapeFactory {
     
	/**
	 * Returns an n-sided polygon n= length of sides.
	 * @param sides
	 * @return
	 * @throws UnsupportedShapeException
	 */
	public abstract Shape getShape(double[] sides) throws UnsupportedShapeException;
     
}
