package com.arijit.springboot.practice.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {
	
	@JsonProperty(value = "id")
	private int id;
	
	@JsonProperty(value = "name")
	private String name;
	
	@JsonProperty(value = "qualification")
	private String qualification;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public UserModel(int id, String name, String qualification) {
		super();
		this.id = id;
		this.name = name;
		this.qualification = qualification;
	}
	
	public UserModel() {
		super();
	}
}
