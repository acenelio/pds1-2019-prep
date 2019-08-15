package com.educandoweb.workshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.dto.CategoryDTO;
import com.educandoweb.workshop.entities.Category;
import com.educandoweb.workshop.repositories.CategoryRepository;
import com.educandoweb.workshop.services.generics.CRUDService;

@Service
public class CategoryService implements CRUDService<Category, CategoryDTO, Long> {

	@Autowired
	private CategoryRepository repository;

	@Override
	public JpaRepository<Category, Long> getRepository() {
		return repository;
	}
}
