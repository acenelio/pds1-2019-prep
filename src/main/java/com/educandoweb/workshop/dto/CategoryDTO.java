package com.educandoweb.workshop.dto;

import com.educandoweb.workshop.entities.Category;

public class CategoryDTO implements DTO<Category> {
	private static final long serialVersionUID = 1L;

	private String name;

	public CategoryDTO() {
	}

	public CategoryDTO(Category entity) {
		name = entity.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Category toEntity() {
		return new Category(null, name);
	}
}

