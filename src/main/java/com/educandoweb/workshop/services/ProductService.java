package com.educandoweb.workshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.entities.Product;
import com.educandoweb.workshop.repositories.ProductRepository;

@Service
public class ProductService implements CRUDService<Product, Long> {

	@Autowired
	private ProductRepository repository;

	@Override
	public JpaRepository<Product, Long> getRepository() {
		return repository;
	}

	@Override
	public void updateData(Product newObj, Product obj) {
		newObj.setName(obj.getName());
		newObj.setDescription(obj.getDescription());
		newObj.setImgUrl(obj.getImgUrl());
		newObj.setPrice(obj.getPrice());
	}	
}
