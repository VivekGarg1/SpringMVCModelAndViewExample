package com.home.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	
	@NotEmpty
	@Pattern(regexp = "[^0-9]+")
	@Size(min = 2,max=20)
	private String name;
	
	@NotEmpty
	@Email
	private String email;
	
	@Min(value = 12)
	@Max(value = 120)
	@NotNull
	private Integer age;
	
	@NotEmpty
	private String country;
	
	public User(String name, Integer age, String email, String country) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.country = country;
	}
	
	public User() {
		
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Integer getAge() {
		return age;
	}
	public String getCountry() {
		return country;
	}

}
