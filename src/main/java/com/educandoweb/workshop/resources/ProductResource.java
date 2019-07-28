package com.educandoweb.workshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.entities.Product;
import com.educandoweb.workshop.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductResource {

	@Autowired
	private ProductService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Product>> findAll() {
		var list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		var obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
