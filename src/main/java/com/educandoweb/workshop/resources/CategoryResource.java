package com.educandoweb.workshop.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.entities.Category;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {

	private Map<Long, Category> map = Map.of(
		1L, new Category(1L, "Electronics"),
		2L, new Category(2L, "Books")
	);
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Category>> findAll() {
		var list = new ArrayList<Category>(map.values());
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		var obj = map.get(id);
		return ResponseEntity.ok().body(obj);
	}
}
