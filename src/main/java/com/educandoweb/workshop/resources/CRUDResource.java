package com.educandoweb.workshop.resources;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(method=RequestMethod.POST)
	default ResponseEntity<Void> insert(@RequestBody E obj) {
		obj = getService().insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	default ResponseEntity<Void> update(@PathVariable ID id, @RequestBody E obj) {
		obj = getService().update(id, obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	default ResponseEntity<Void> delete(@PathVariable ID id) {
		getService().delete(id);
		return ResponseEntity.noContent().build();
	}
}
