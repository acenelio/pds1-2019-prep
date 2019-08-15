package com.educandoweb.workshop.dto;

import com.educandoweb.workshop.entities.User;

public class UserDTO implements DTO<User> {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private String phone;
	private String password;

	public UserDTO() {
	}

	public UserDTO(User entity) {
		name = entity.getName();
		email = entity.getEmail();
		phone = entity.getPhone();
		password = entity.getPassword();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public User toEntity() {
		return new User(null, name, email, phone, password);
	}
}
