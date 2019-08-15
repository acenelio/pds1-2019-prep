package com.educandoweb.workshop.resources.generics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.educandoweb.workshop.dto.DTO;
import com.educandoweb.workshop.entities.DomainEntity;
import com.educandoweb.workshop.services.generics.CRUDService;

public interface UpdateResource<E extends DomainEntity<ID, D>, D extends DTO<E, ID>, ID> {

	CRUDService<E, D, ID> getService();

	@PutMapping(value = "/{id}")
	default ResponseEntity<D> update(@PathVariable ID id, @RequestBody D dto) {
		dto = getService().update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
}
