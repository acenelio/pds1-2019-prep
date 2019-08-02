package com.educandoweb.workshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.entities.Category;
import com.educandoweb.workshop.services.CRUDService;
import com.educandoweb.workshop.services.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource implements CRUDResource<Category, Long> {

	@Autowired
	private CategoryService service;

	@Override
	public CRUDService<Category, Long> getService() {
		return service;
	}
}
