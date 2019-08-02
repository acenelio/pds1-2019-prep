package com.educandoweb.workshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.entities.Product;
import com.educandoweb.workshop.services.CRUDService;
import com.educandoweb.workshop.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductResource implements CRUDResource<Product, Long> {

	@Autowired
	private ProductService service;

	@Override
	public CRUDService<Product, Long> getService() {
		return service;
	}
}
