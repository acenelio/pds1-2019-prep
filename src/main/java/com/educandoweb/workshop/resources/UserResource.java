package com.educandoweb.workshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.services.CRUDService;
import com.educandoweb.workshop.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource implements CRUDResource<User, Long> {

	@Autowired
	private UserService service;

	@Override
	public CRUDService<User, Long> getService() {
		return service;
	}
}
