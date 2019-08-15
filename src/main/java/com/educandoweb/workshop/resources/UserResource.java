package com.educandoweb.workshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.dto.UserDTO;
import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.resources.generics.CreateResource;
import com.educandoweb.workshop.resources.generics.RetrieveResource;
import com.educandoweb.workshop.resources.generics.UpdateResource;
import com.educandoweb.workshop.services.generics.CRUDService;

@RestController
@RequestMapping(value="/users")
public class UserResource implements CreateResource<User, UserDTO, Long>, RetrieveResource<User, UserDTO, Long>, UpdateResource<User, UserDTO, Long> {

	@Autowired
	private CRUDService<User, UserDTO, Long> service;
	
	@Override
	public CRUDService<User, UserDTO, Long> getService() {
		return service;
	}
}
