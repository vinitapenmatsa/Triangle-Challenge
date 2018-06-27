package com.challenge.exception;

public class UnsupportedShapeException extends RuntimeException {
	
	private static final long serialVersionUID = -1550155052384863410L;

	public UnsupportedShapeException() {
		super("Shape Not Supported");
	}

}
