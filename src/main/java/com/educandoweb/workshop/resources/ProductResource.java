package com.educandoweb.workshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.dto.ProductDTO;
import com.educandoweb.workshop.entities.Product;
import com.educandoweb.workshop.resources.generics.CRUDResource;
import com.educandoweb.workshop.services.ProductService;
import com.educandoweb.workshop.services.generics.CRUDService;

@RestController
@RequestMapping(value="/products")
public class ProductResource implements CRUDResource<Product, ProductDTO, Long> {

	@Autowired
	private ProductService service;
	
	@Override
	public CRUDService<Product, ProductDTO, Long> getService() {
		return service;
	}
}
