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
}
