package com.arijit.springboot.practice.springboot.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.arijit.springboot.practice.springboot.Exception.InvalidUserServiceInputException;
import com.arijit.springboot.practice.springboot.Exception.UserNotFoundException;
import com.arijit.springboot.practice.springboot.model.UserModel;
import com.arijit.springboot.practice.springboot.processors.UserProcessor;

@RestController
public class UserController {
	
	@Autowired
	private UserProcessor userProcessor;
	
	@GetMapping( value = "/getUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<UserModel> getUser(@PathVariable String id) throws InvalidUserServiceInputException, UserNotFoundException {
		UserModel userData = null;
		
		try {
			userData = userProcessor.fetchUser(id);
		} catch (InvalidUserServiceInputException | UserNotFoundException e) {
			if( e instanceof InvalidUserServiceInputException ) {
				throw new InvalidUserServiceInputException(e.getMessage());
			}
			else if( e instanceof UserNotFoundException ) {
				throw new UserNotFoundException(e.getMessage());
			}
		}		
		
		return new ResponseEntity<>( userData, HttpStatus.ACCEPTED );
	}
	
	
	@PostMapping( value = "/addUser", produces = MediaType.APPLICATION_JSON_VALUE ) 
	public ResponseEntity<URI> addUser(@RequestBody UserModel userData) throws InvalidUserServiceInputException {
		String userID = "";
		
		try {
			userID = userProcessor.createUser(userData);
		} catch (InvalidUserServiceInputException e) {
			throw new InvalidUserServiceInputException(e.getMessage());
		}
		
		URI location = ServletUriComponentsBuilder
							.fromCurrentContextPath()
							.path("/getUser/{id}")
							.buildAndExpand(userID)
							.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping( value = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE ) 
	public ResponseEntity<URI> updateUser(@RequestBody UserModel userData) throws InvalidUserServiceInputException {
		String userID = "";
		
		try {
			userID = userProcessor.updateUser(userData);
		} catch (InvalidUserServiceInputException e) {
			throw new InvalidUserServiceInputException(e.getMessage());
		}
		
		URI location = ServletUriComponentsBuilder
							.fromCurrentContextPath()
							.path("/getUser/{id}")
							.buildAndExpand(userID)
							.toUri();
		
		return ResponseEntity.created(location).build();
	}
	 
	@DeleteMapping( value = "/deleteUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Boolean> deleteUser(@PathVariable String id) throws InvalidUserServiceInputException, UserNotFoundException {
		boolean deleteUser = Boolean.FALSE;
		
		try {
			deleteUser = userProcessor.deleteUser(id);
		} catch (InvalidUserServiceInputException  e) {
			throw new InvalidUserServiceInputException(e.getMessage());
		}		
		
		return new ResponseEntity<>( deleteUser, HttpStatus.ACCEPTED );
	}
}
