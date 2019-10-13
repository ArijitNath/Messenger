package com.arijit.springboot.practice.springboot.Exception;

public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7226551786982701224L;
	
	public UserNotFoundException(String message) {
		super(message);
	}
	
	public UserNotFoundException(String message, Throwable e) {
		super(message, e);
	}
}