package com.educandoweb.workshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.workshop.dto.ProductDTO;
import com.educandoweb.workshop.entities.Product;
import com.educandoweb.workshop.repositories.ProductRepository;
import com.educandoweb.workshop.services.generics.CRUDService;

public class ProductService implements CRUDService<Product, ProductDTO, Long> {

	@Autowired
	private ProductRepository repository;

	@Override
	public JpaRepository<Product, Long> getRepository() {
		return repository;
	}

	@Override
	public void updateData(Product entity, ProductDTO dto) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setImgUrl(dto.getImgUrl());
		entity.setPrice(dto.getPrice());
	}	
}
