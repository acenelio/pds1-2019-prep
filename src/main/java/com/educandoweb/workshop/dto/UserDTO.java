package com.educandoweb.workshop.dto;

import com.educandoweb.workshop.entities.User;

public class UserDTO implements DTO<User, Long> {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email;
	private String phone;

	public UserDTO() {
	}

	public UserDTO(User entity) {
		setId(entity.getId());
		setName(entity.getName());
		setEmail(entity.getEmail());
		setPhone(entity.getPhone());
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public User toEntity() {
		return new User(id, name, email, phone, null);
	}
}
