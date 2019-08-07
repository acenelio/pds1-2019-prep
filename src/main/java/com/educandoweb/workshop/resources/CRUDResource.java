package com.educandoweb.workshop.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.educandoweb.workshop.entities.DomainEntity;
import com.educandoweb.workshop.services.CRUDService;

public interface CRUDResource<E extends DomainEntity<ID>, ID> {
	
	CRUDService<E, ID> getService();
	
	@RequestMapping(method=RequestMethod.GET)
	default ResponseEntity<List<E>> findAll() {
		var list = getService().findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	default ResponseEntity<E> findById(@PathVariable ID id) {
		var obj = getService().findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
