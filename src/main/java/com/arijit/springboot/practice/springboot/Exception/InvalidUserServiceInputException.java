package com.arijit.springboot.practice.springboot.Exception;

public class InvalidUserServiceInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7226551786982701224L;
	
	public InvalidUserServiceInputException(String message) {
		super(message);
	}
	
	public InvalidUserServiceInputException(String message, Throwable e) {
		super(message, e);
	}
}
