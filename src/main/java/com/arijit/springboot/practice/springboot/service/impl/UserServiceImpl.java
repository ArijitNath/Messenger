package com.arijit.springboot.practice.springboot.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.arijit.springboot.practice.springboot.model.UserModel;
import com.arijit.springboot.practice.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private Map<Integer, UserModel> userMap = new HashMap<>();
	
	@Override
	public void insert(UserModel userData) {
		userMap.put(userData.getId(), userData);
	}

	@Override
	public UserModel fetch(String id) {
		return this.userMap.get(Integer.parseInt(id));
	}

	@Override
	public boolean contains(int id) {
		return userMap.containsKey(id);
	}

	@Override
	public boolean remove(int id) {
		return !Objects.isNull(this.userMap.remove(id));
	}
}
