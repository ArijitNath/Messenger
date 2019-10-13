package com.arijit.springboot.practice.springboot.processors.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arijit.springboot.practice.springboot.Exception.InvalidUserServiceInputException;
import com.arijit.springboot.practice.springboot.Exception.UserNotFoundException;
import com.arijit.springboot.practice.springboot.model.UserModel;
import com.arijit.springboot.practice.springboot.processors.UserProcessor;
import com.arijit.springboot.practice.springboot.service.UserService;

@Component
public class UserProcessorImpl implements UserProcessor {

	@Autowired
	private UserService userService;
	
	public UserModel fetchUser(String id) throws InvalidUserServiceInputException, UserNotFoundException {
		try {
			Integer.parseInt(id);
		}
		catch(NumberFormatException e) {
			throw new InvalidUserServiceInputException("ID in incorrect format. Not a number!");
		}
		
		UserModel userData = userService.fetch(id);
		
		if( Objects.isNull(userData) ) {
			throw new UserNotFoundException("No data found!"); 
		}
		
		return userData;		
	}

	@Override
	public String createUser(UserModel userData) throws InvalidUserServiceInputException {
		if( Objects.isNull(userData) ) {
			throw new InvalidUserServiceInputException("Invalid user data");
		}
		
		if( userService.contains(userData.getId()) ) {
			throw new InvalidUserServiceInputException("User already created!");
		}
		
		userService.insert(userData);
		return String.valueOf(userData.getId());		
	}

	@Override
	public String updateUser(UserModel userData) throws InvalidUserServiceInputException {
		if( Objects.isNull(userData) ) {
			throw new InvalidUserServiceInputException("Invalid user data");
		}
		
		userService.insert(userData);
		return String.valueOf(userData.getId());	
	}

	@Override
	public boolean deleteUser(String id) throws InvalidUserServiceInputException {
		try {
			Integer.parseInt(id);
		}
		catch(NumberFormatException e) {
			throw new InvalidUserServiceInputException("ID in incorrect format. Not a number!");
		}
		
		return userService.remove(Integer.parseInt(id));
	}
	
}
