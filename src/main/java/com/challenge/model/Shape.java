package com.challenge.model;

/**
 *  Interface to represent any shape.
 * 
 * @author vinitapenmatsa
 */
public interface Shape {
	
	
	/**
	 * validates a given shape by its properties.
	 * @return
	 */
	public boolean isValid();
	
	/**
	 * Returns a classification for Shape.
	 * @return 
	 */
	public String getType();

}
