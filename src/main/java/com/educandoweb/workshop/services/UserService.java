package com.educandoweb.workshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.workshop.dto.UserDTO;
import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.repositories.UserRepository;
import com.educandoweb.workshop.services.generics.CRUDService;

public class UserService implements CRUDService<User, UserDTO, Long> {

	@Autowired
	private UserRepository repository;

	@Override
	public JpaRepository<User, Long> getRepository() {
		return repository;
	}

	@Override
	public void updateData(User entity, UserDTO dto) {
		entity.setName(dto.getEmail());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
	}
}
