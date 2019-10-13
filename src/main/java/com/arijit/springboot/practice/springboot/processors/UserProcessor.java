package com.arijit.springboot.practice.springboot.processors;

import com.arijit.springboot.practice.springboot.Exception.InvalidUserServiceInputException;
import com.arijit.springboot.practice.springboot.Exception.UserNotFoundException;
import com.arijit.springboot.practice.springboot.model.UserModel;

public interface UserProcessor {
	UserModel fetchUser(String id) throws InvalidUserServiceInputException, UserNotFoundException;
	String createUser(UserModel userData) throws InvalidUserServiceInputException;
	String updateUser(UserModel userData) throws InvalidUserServiceInputException;
	boolean deleteUser(String id) throws InvalidUserServiceInputException;
}