package com.arijit.springboot.practice.springboot.service;

import com.arijit.springboot.practice.springboot.model.UserModel;

public interface UserService {
	void insert(UserModel userData);
	UserModel fetch(String id);
	boolean contains(int id);
	boolean remove(int id);
}
