package com.educandoweb.workshop.resources.generics;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.educandoweb.workshop.dto.DTO;
import com.educandoweb.workshop.entities.DomainEntity;
import com.educandoweb.workshop.services.generics.CRUDService;

public interface RetrieveResource<E extends DomainEntity<ID, D>, D extends DTO<E, ID>, ID> {

	CRUDService<E, D, ID> getService();

	@GetMapping
	default ResponseEntity<List<D>> findAll() {
		List<D> list = getService().findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	default ResponseEntity<D> findById(@PathVariable ID id) {
		D dto = getService().findById(id);
		return ResponseEntity.ok().body(dto);
	}
}
