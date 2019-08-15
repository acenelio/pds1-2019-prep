package com.educandoweb.workshop.dto;

import com.educandoweb.workshop.entities.Category;

public class CategoryDTO implements DTO<Category, Long> {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	public CategoryDTO() {
	}

	public CategoryDTO(Category entity) {
		setId(entity.getId());
		setName(entity.getName());
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

	@Override
	public Category toEntity() {
		return new Category(id, name);
	}
}
