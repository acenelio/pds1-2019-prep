package com.educandoweb.workshop.resources.generics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.educandoweb.workshop.dto.DTO;
import com.educandoweb.workshop.entities.DomainEntity;
import com.educandoweb.workshop.services.generics.CRUDService;

public interface DeleteResource<E extends DomainEntity<ID, D>, D extends DTO<E>, ID> {

	CRUDService<E, D, ID> getService();

	@DeleteMapping(value = "/{id}")
	default ResponseEntity<Void> delete(@PathVariable ID id) {
		getService().delete(id);
		return ResponseEntity.noContent().build();
	}
}
