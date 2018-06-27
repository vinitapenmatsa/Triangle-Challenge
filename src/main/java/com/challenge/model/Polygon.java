package com.challenge.model;


/**
 *  This class provides a skeleton implementation of Shape interface for all
 *  n-sided polygons
 *  
 *  @author vinitapenmatsa
 */
public abstract class Polygon implements Shape {
    
	public enum PolygonType{ EQUILATERAL , UNKNOWN , INVALID };

	protected double[] sides;
	
	public Polygon(double[] sides) {
		this.sides = sides;
	}
	
	
	/**
	 * Returns number of sides for an n-sided polygon. 
	 * @return int number of sides.
	 */
	public int numberOfSides() {
		return sides.length;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see com.challenge.model.Shape#isValid()
	 * Any shape with size greater than 2 is a polygon
	 * @return  boolean.
	 */
	public boolean isValid() {
		if(sides.length <= 2)
		     return false;
		
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.challenge.model.Shape#getType()
	 * Checks if polygon is equilateral / unknown type.
	 * 
	 * @Return String
	 */
	@Override
	public String getType() {
         if(isValid()) {
        	    if(isEquilateral())
        	    	   return PolygonType.EQUILATERAL.toString();
        	    else
        	    	   return PolygonType.UNKNOWN.toString();
        	 
         }else {
        	    return PolygonType.INVALID.toString();
         }
	}
	
	/*
	 *  Checks if all sides of a polygon are equal
	 *  returns: true if equal , false otherwise
	 */
	protected boolean isEquilateral() {
	   for(int i=0 ; i < sides.length-1 ; i++) if(sides[i]!=sides[i+1]) return false;	   
	   return true;
	}
	

	
}
