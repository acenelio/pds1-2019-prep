package com.educandoweb.workshop.resources.generics;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.workshop.dto.DTO;
import com.educandoweb.workshop.entities.DomainEntity;
import com.educandoweb.workshop.services.generics.CRUDService;

public interface CreateResource<E extends DomainEntity<ID, D>, D extends DTO<E, ID>, ID> {

	CRUDService<E, D, ID> getService();
	
	@PostMapping
	default ResponseEntity<D> insert(@RequestBody D dto) {
		dto = getService().insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
