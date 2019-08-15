package com.educandoweb.workshop.resources.generics;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.workshop.dto.DTO;
import com.educandoweb.workshop.entities.DomainEntity;
import com.educandoweb.workshop.services.generics.CRUDService;

public interface CreateResource<E extends DomainEntity<ID, D>, D extends DTO<E>, ID> {

	CRUDService<E, D, ID> getService();
	
	@PostMapping
	default ResponseEntity<Void> insert(@RequestBody D obj) {
		ID id = getService().insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}
}
