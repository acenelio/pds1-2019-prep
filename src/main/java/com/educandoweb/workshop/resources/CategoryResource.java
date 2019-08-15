package com.educandoweb.workshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.dto.CategoryDTO;
import com.educandoweb.workshop.entities.Category;
import com.educandoweb.workshop.resources.generics.CRUDResource;
import com.educandoweb.workshop.services.generics.CRUDService;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource implements CRUDResource<Category, CategoryDTO, Long> {

	@Autowired
	private CRUDService<Category, CategoryDTO, Long> service;
	
	@Override
	public CRUDService<Category, CategoryDTO, Long> getService() {
		return service;
	}
}
