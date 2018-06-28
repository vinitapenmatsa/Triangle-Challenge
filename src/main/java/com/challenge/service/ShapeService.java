package com.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.dto.PolygonDTO;
import com.challenge.model.Shape;
import com.challenge.model.factory.ShapeFactory;

/**
 * @author vinitapenmatsa
 */
@Service
public class ShapeService {

	@Autowired
	ShapeFactory shapeFactory;

	/**
	 * Creates a Polygon based on number of sides
	 * Returns its classification
	 * @param polygonDTO
	 * @return
	 */
	public String getPolygonType(PolygonDTO polygonDTO){
		double[] sides = polygonDTO.getSides();
		Shape shape = shapeFactory.getShape(sides);
		return shape.getType();	
	}

}
